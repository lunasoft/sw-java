package Services;

/**
 * Created by asalvio on 08/02/2017.
 */
public  abstract class SWService {
    private String Token = null;
    private String User = null;
    private String Password = null;

    public String getToken() {
        return Token;
    }

    public String getUser() {
        return User;
    }

    public String getPassword() {
        return Password;
    }

    public String getURI() {
        return URI;
    }

    private String URI;

    protected SWService(String user, String password, String URI) {
        User = user;
        Password = password;
        this.URI = URI;
    }

    protected SWService(String token, String URI) {

        Token = token;
        this.URI = URI;
    }

    public void setToken(String token) {
        Token = token;
    }

    public void setUser(String user) {
        User = user;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
