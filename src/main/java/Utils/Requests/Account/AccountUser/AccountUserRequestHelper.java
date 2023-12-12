package Utils.Requests.Account.AccountUser;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import Exceptions.GeneralException;
import Utils.Helpers.RequestHelper;
import Utils.Requests.IRequest;
import Utils.Responses.Account.AccountUser.AccountUserResponse;
import Utils.Responses.Account.AccountUser.DataAccountUser;

public class AccountUserRequestHelper {
    public static <T> AccountUserResponse<T> handleResponse(CloseableHttpResponse response, Class<T> responseType)
            throws IOException, GeneralException {
        int status = response.getStatusLine().getStatusCode();
        String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");

        if (!responseString.isEmpty() && status < 500) {
            JSONObject body = new JSONObject(responseString);

            if (status == 200) {
                Object dataObject = body.get("data");

                if (responseType == DataAccountUser.class && dataObject instanceof JSONObject) {
                    DataAccountUser user = UserData((JSONObject) dataObject);
                    return new AccountUserResponse<>(status, body.getString("status"), (T) user, "OK", "OK");
                } else if (responseType == String.class && dataObject instanceof String) {
                    String data = (String) dataObject;
                    return new AccountUserResponse<>(status, body.getString("status"), (T) data, "OK", "OK");
                } else if (responseType == List.class && dataObject instanceof JSONArray) {
                    JSONArray data = (JSONArray) dataObject;
                    List<DataAccountUser> userList = new LinkedList<>();

                    for (int i = 0; i < data.length(); i++) {
                        JSONObject userData = data.getJSONObject(i);
                        DataAccountUser user = UserData(userData);
                        userList.add(user);
                    }

                    return new AccountUserResponse<>(status, body.getString("status"), (T) userList, "OK", "OK");
                }
            } else {
                String messageDetail = body.optString("messageDetail", "");
                return new AccountUserResponse<>(status, body.getString("status"), null, body.getString("message"),
                        messageDetail);
            }
        } else {
            return new AccountUserResponse<>(status, "error", null, response.getStatusLine().getReasonPhrase(),
                    responseString);
        }
        return null;
    }

    public static JSONObject buildUserCreateJson(AccountUserOptionsRequest accountUserOptionsRequest) {
        JSONObject requestJSON = new JSONObject();
        requestJSON.put("email", accountUserOptionsRequest.getEmail());
        requestJSON.put("password", accountUserOptionsRequest.getPassword());
        requestJSON.put("name", accountUserOptionsRequest.getName());
        requestJSON.put("rfc", accountUserOptionsRequest.getRfc());
        requestJSON.put("profile", accountUserOptionsRequest.getProfile().getValue());
        requestJSON.put("stamps", accountUserOptionsRequest.getStamps());
        requestJSON.put("unlimited", accountUserOptionsRequest.isUnlimited());
        requestJSON.put("active", accountUserOptionsRequest.isActive());
        return requestJSON;
    }

    public static JSONObject buildUserUpdateJson(AccountUserOptionsRequest accountUserOptionsRequest) {
        JSONObject requestJSON = new JSONObject();
        requestJSON.put("name", accountUserOptionsRequest.getName());
        requestJSON.put("rfc", accountUserOptionsRequest.getRfc());
        requestJSON.put("unlimited", accountUserOptionsRequest.isUnlimited());
        requestJSON.put("active", accountUserOptionsRequest.isActive());
        return requestJSON;
    }

    public static DataAccountUser UserData(JSONObject userData) {
        String email = userData.optString("email", null);
        String password = userData.optString("password", null);
        String nombre = userData.optString("nombre", null);
        String apellidoPaterno = userData.optString("apellidoPaterno", null);
        String apellidoMaterno = userData.optString("apellidoMaterno", null);
        String username = userData.optString("username", null);
        String fechaUltimoPassword = userData.optString("fechaUltimoPassword", null);
        String telefono = userData.optString("telefono", null);
        boolean administrador = userData.optBoolean("administrador");
        String profileValue = userData.optString("profileValue", null);
        String idUsuario = userData.optString("idUsuario", null);
        String idCliente = userData.optString("idCliente", null);
        String stamps = userData.optString("stamps", null);
        boolean unlimited = userData.optBoolean("unlimited");
        int profile = userData.optInt("profile");
        boolean activo = userData.optBoolean("activo");
        String registeredDate = userData.optString("registeredDate", null);
        boolean eliminado = userData.optBoolean("eliminado");
        String tokenAccess = userData.optString("tokenAccess", null);
        String tokenAccessHash = userData.optString("tokenAccessHash", null);

        return new DataAccountUser(
                email, password, nombre, apellidoPaterno, apellidoMaterno, username,
                fechaUltimoPassword, telefono, administrador, profileValue, idUsuario,
                idCliente, stamps, unlimited, profile, activo, registeredDate,
                eliminado, tokenAccess, tokenAccessHash);
    }

    public static void configureHttpRequest(IRequest request, HttpRequestBase httpRequest, JSONObject requestJSON) {
        try {
            RequestHelper.setTimeOut(request.options, 5000);
            RequestHelper.setProxy(request.options, request.proxyHost, request.proxyPort);
            httpRequest.setConfig(request.options.build());
            httpRequest.setHeader(new BasicHeader("Authorization", "bearer " + request.Token));
            httpRequest.addHeader(new BasicHeader("Content-Type", "application/json"));

            if (httpRequest instanceof HttpEntityEnclosingRequestBase) {
                MultipartEntityBuilder builder = MultipartEntityBuilder.create();
                Charset chars = Charset.forName("UTF-8");
                builder.setCharset(chars);
                builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
                StringEntity sEntity = new StringEntity(requestJSON.toString(), StandardCharsets.UTF_8);
                ((HttpEntityEnclosingRequestBase) httpRequest).setEntity(builder.build());
                ((HttpEntityEnclosingRequestBase) httpRequest).setEntity(sEntity);
            }
        } catch (GeneralException e) {
            e.printStackTrace();
        }
    }
}