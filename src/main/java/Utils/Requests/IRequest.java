package Utils.Requests;

public abstract class IRequest {
    public String Token;
    public String URI;
    public String User;
    public String Password;

    public IRequest(String URI, String user, String password) {
        this.URI = URI;
        User = user;
        Password = password;
    }

    public IRequest(String token, String URI) {
        Token = token;
        this.URI = URI;
    }
}
