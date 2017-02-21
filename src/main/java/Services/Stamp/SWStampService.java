package Services.Stamp;

import Exceptions.AuthException;
import Exceptions.GenaralException;
import Services.SWService;
import Utils.Constants;
import Utils.EncoderHelper;
import Utils.Requests.Authentication.AuthOptionsRequest;
import Utils.Requests.Authentication.AuthRequest;
import Utils.Requests.Authentication.AuthSoapRequest;
import Utils.Requests.Stamp.StampOptionsRequest;
import Utils.Requests.Stamp.StampRequest;
import Utils.Requests.Stamp.StampRequestDummy;
import Utils.Responses.AuthResponse;
import Utils.Responses.IResponse;


import java.io.*;
import java.net.MalformedURLException;


/**
 * Created by asalvio on 09/02/2017.
 */
public class SWStampService extends SWService {

    public SWStampService(String user, String password, String URI) {
        super(user, password, URI);
    }

    public SWStampService(String token, String URI) {
        super(token, URI);
    }

    public IResponse Stamp(String xml, String version) throws AuthException, GenaralException {



        if (getToken()==null){

            if (getUser()==null || getPassword()==null){
                //CUSTOMER HASN'T TOKEN, USER AND PASSWORD--> WE CANT' DO ANYTHING --> THROW EXCEPTION
                throw new AuthException(500,"no existen elementos de autenticación");

            }

            //CUSTOMER HASN'T TOKEN, BUT HAS USER AND PASSWORD --> AUTH,GENERATE TOKEN AND SET TOKEN IN GLOBAL SETTINGS
            // Temporaly changes to soap
            AuthOptionsRequest settings = new AuthOptionsRequest(Constants.BASE_PATH+Constants.AUTH_PATH,getUser(),getPassword());
            AuthSoapRequest req = new AuthSoapRequest();
            IResponse res = req.sendRequest(settings);
            if (res.HttpStatusCode==200){
                setToken(res.Data);
            }
            else{
                //CUSTOMER HASN'T TOKEN, AND USER AND PASSWORD ARE BAD--> WE CANT' DO ANYTHING --> THROW EXCEPTION
                throw new AuthException(res.HttpStatusCode,res.Data);
            }


        }
        //MAKE STAMP PROCESS, CUSTOMER ALREADY HAS TOKEN

        StampOptionsRequest settings = new StampOptionsRequest(getToken(),getURI(),xml,version);
        String dum = settings.URI.split("-")[0];
        if (dum.equalsIgnoreCase("d")){
            StampRequestDummy req = new StampRequestDummy();
            return req.sendRequest(settings);
        }
        StampRequest req = new StampRequest();
        return req.sendRequest(settings);

    }

    public IResponse Stamp(File xmlFile, String version) throws AuthException, GenaralException {
        //BINARY XML

        try{
            String xmlProcess = "";
            String strLine;
            BufferedReader reader = new BufferedReader(new FileReader(xmlFile));
            while ((strLine = reader.readLine()) != null)   {
                // Print the content on the console
               xmlProcess+=strLine;
            }

            reader.close();




        if (getToken()==null){

            if (getUser()==null || getPassword()==null){
                //CUSTOMER HASN'T TOKEN, USER AND PASSWORD--> WE CANT' DO ANYTHING --> THROW EXCEPTION
                throw new AuthException(500,"no existen elementos de autenticación");

            }

            //CUSTOMER HASN'T TOKEN, BUT HAS USER AND PASSWORD --> TRY AUTH,GENERATE TOKEN AND SET TOKEN IN GLOBAL SETTINGS
            AuthOptionsRequest settings = new AuthOptionsRequest(Constants.BASE_PATH+Constants.AUTH_PATH,getUser(),getPassword());
            AuthRequest req = new AuthRequest();
            AuthResponse res = (AuthResponse) req.sendRequest(settings);
            if (res.HttpStatusCode==200){
                setToken(res.Data);
            }
            else{
                //CUSTOMER HASN'T TOKEN, AND USER AND PASSWORD ARE BAD--> WE CANT' DO ANYTHING --> THROW EXCEPTION
                throw new AuthException(res.HttpStatusCode,res.Data);
            }


        }

        //MAKE STAMP PROCESS, CUSTOMER ALREADY HAS TOKEN

        StampOptionsRequest settings = new StampOptionsRequest(getToken(),getURI(),xmlProcess,version);

            String dum = settings.URI.split("-")[0];
            System.out.println(dum);
            if (dum.equalsIgnoreCase("d")){
                StampRequestDummy req = new StampRequestDummy();
                return req.sendRequest(settings);
            }
        StampRequest req = new StampRequest();
        return req.sendRequest(settings);

        }catch (FileNotFoundException e) {
            throw new GenaralException(500,"ERROR AL LEER ARCHIVO");
        } catch (IOException e) {
            throw new GenaralException(500,"ERROR AL LEER ARCHIVO");
        }

    }
}
