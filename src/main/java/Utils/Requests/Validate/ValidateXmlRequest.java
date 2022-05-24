package Utils.Requests.Validate;

import java.io.IOException;
import java.util.LinkedList;
import java.util.UUID;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Exceptions.AuthException;
import Exceptions.GeneralException;
import Utils.Helpers.RequestHelper;
import Utils.Requests.IRequest;
import Utils.Requests.IRequestor;
import Utils.Responses.IResponse;
import Utils.Responses.Validate.DetailData;
import Utils.Responses.Validate.DetailNode;
import Utils.Responses.Validate.ValidateXmlResponse;
import org.apache.http.entity.StringEntity;

public class ValidateXmlRequest implements IRequestor{

	public IResponse sendRequest(IRequest request) throws GeneralException, AuthException {
		try {
			String xmlStr = ((ValidateXmlOptionsRequest) request).getXml();
			String boundary = UUID.randomUUID().toString();
            String raw = "--"+boundary+"\r\nContent-Disposition: form-data; name=xml; filename=xml\r\nContent-Transfer-Encoding: binary\r\nContent-Type: text/xml\r\n\r\n"+xmlStr+"\r\n--"+boundary+"--";
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost httppost = new HttpPost(request.URI);
            RequestHelper.setTimeOut(request.options, raw.length());
            RequestHelper.setProxy(request.options, request.proxyHost, request.proxyPort);
			httppost.setConfig(request.options.build());
            httppost.setHeader("Authorization", "bearer " + request.Token);
            httppost.addHeader("Content-Type", "multipart/form-data; boundary="+boundary);
            httppost.setEntity(new StringEntity(raw, "UTF-8"));
            CloseableHttpResponse responseB = client.execute(httppost);
            HttpEntity entity = responseB.getEntity();
            String responseString = EntityUtils.toString(entity, "UTF-8");
            int statusE = responseB.getStatusLine().getStatusCode();
            client.close();  
            responseB.close();
            if(!responseString.isEmpty() && statusE < 500) {
            	JSONObject body = new JSONObject(responseString);
            	if(statusE==200){
            		LinkedList<DetailNode> List = new LinkedList<DetailNode>();
            		JSONArray detailP= new JSONArray(body.get("detail").toString());
            		for (int i = 0; i < detailP.length (); i++) {
            			JSONObject detailNode = new JSONObject(detailP.get(i).toString());
            			LinkedList<DetailData> ListItem = new LinkedList<DetailData>();
            			JSONArray detail = new JSONArray(detailNode.get("detail").toString());
                		for (int j = 0; j < detail.length (); j++) {
                			JSONObject detaildata = new JSONObject(detail.get(j).toString());
                			String message = detaildata.isNull("message") ? "" : detaildata.getString("message");
                			String messageDetail = detaildata.isNull("messageDetail") ? "" : detaildata.getString("messageDetail");
                			DetailData nuevo = new DetailData(message, messageDetail, String.valueOf(detaildata.getInt("type")));
                			ListItem.add(nuevo);
                		}
                		DetailNode x = new DetailNode(detailNode.getString("section"),ListItem);
            			List.add(x);
            		}
            		
            		return new ValidateXmlResponse(statusE,body.getString("status"),body.get("cadenaOriginalSAT").toString(),body.get("cadenaOriginalComprobante").toString(),body.get("uuid").toString(),body.get("statusSat").toString(),body.get("statusCodeSat").toString(),List,"OK","OK");
            	}
            	else {
            		String messageDetail = "";
            		if (!body.isNull("messageDetail")) {
                        messageDetail = body.getString("messageDetail");
                    }
                    return new ValidateXmlResponse(statusE, body.getString("status"), body.getString("message"), messageDetail);
            	}
            }
            else {
            	return new ValidateXmlResponse(statusE,"error",responseB.getStatusLine().getReasonPhrase(), responseString);
            }
		}
		catch (JSONException e){
            throw  new GeneralException(500,e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            throw new GeneralException(500,e.getMessage());
        }
	}

}
