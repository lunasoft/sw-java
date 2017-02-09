package Tests;

import Services.Authentication.SWAuthenticationService;
import Services.SWService;
import Utils.Responses.AuthResponse;

/**
 * Created by asalvio on 09/02/2017.
 */
public class AuthTest {
    public static void main(String[] args){

        SWAuthenticationService auth = new SWAuthenticationService("demo","12345678A","http://swservicestest.sw.com.mx/seguridad/autenticar");
        AuthResponse response = (AuthResponse) auth.getToken();
        System.out.println(response.HttpStatusCode);
        System.out.println(response.Msg);
    }
}
