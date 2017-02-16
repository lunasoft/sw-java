package Utils.Requests.Authentication;

import Exceptions.GenaralException;
import Utils.Requests.IRequest;
import Utils.Requests.IRequestor;
import Utils.Responses.AuthResponse;
import Utils.Responses.IResponse;
import Utils.Responses.JSendFactory;
import org.json.JSONObject;
import org.junit.Assert;

import static junit.framework.Assert.fail;

/**
 * Created by asalvio on 15/02/2017.
 */
public class AuthRequestDummy implements IRequestor {
    @Override
    public IResponse sendRequest(IRequest request) throws GenaralException {
        String dummy_case = request.URI.split("-")[1].toString();
        String dcase = dummy_case.split("/")[0].toString();

        switch (dcase){
            case "success":
            JSONObject parser = new JSONObject();
            JSONObject data = new JSONObject();
            parser.put("status","success");
            parser.put("data",data.put("token","token001"));

            JSONObject res = new JSONObject(parser.toString());

                return (IResponse) JSendFactory.response(
                        res.getString("status").toString(),
                        res.getString("status").toString().equals("error") ? res.getString("message").toString() : res.getJSONObject("data").toString(),
                        res.getString("status").toString().equals("error") ? Integer.parseInt(res.getString("code").toString()) : 0
                );
            case "fail":
                JSONObject parserfail = new JSONObject();
                JSONObject datafail = new JSONObject();
                parserfail.put("status","fail");
                parserfail.put("data",datafail.put("usuario","usuario es requerido").toString());
                JSONObject res2 = new JSONObject(parserfail.toString());
                return (IResponse) JSendFactory.response(
                        res2.getString("status").toString(),
                        res2.getString("status").toString().equals("error") ? res2.getString("message").toString() : res2.getString("data").toString(),
                        res2.getString("status").toString().equals("error") ? Integer.parseInt(res2.getString("code").toString()) : 0
                );
            case "error":
                JSONObject parsererror = new JSONObject();
                parsererror.put("status","error");
                parsererror.put("message","Unable to communicate with database");
                parsererror.put("code","500");
                JSONObject res3 = new JSONObject(parsererror.toString());
                return (IResponse) JSendFactory.response(
                        res3.getString("status").toString(),
                        res3.getString("status").toString().equals("error") ? res3.getString("message").toString() : res3.getString("data").toString(),
                        res3.getString("status").toString().equals("error") ? Integer.parseInt(res3.getString("code").toString()) : 0
                );

            default:
                JSONObject parsererror2 = new JSONObject();
                parsererror2.put("status","error");
                parsererror2.put("dara","");
                parsererror2.put("message","Unable to communicate with database");
                parsererror2.put("code","Tfd-500");
                res = new JSONObject(parsererror2.toString());
                return (IResponse) JSendFactory.response(
                        res.getString("status").toString(),
                        res.getString("status").toString().equals("error") ? res.getString("message").toString() : res.getString("data").toString(),
                        res.getString("status").toString().equals("error") ? Integer.parseInt(res.getString("code").toString()) : 0
                );
        }

    }
}
