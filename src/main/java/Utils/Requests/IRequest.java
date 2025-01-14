package Utils.Requests;
import java.util.UUID;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import Utils.Helpers.EnumBalanceStamp.AccountBalanceAction;

public abstract class IRequest {
    public String Token;
    public String URI;
    public String URIAPI;
    public String User;
    public String Password;
    public String version;
    public String xml;
    public UUID idUser;
    public String comment;
    public int stamps;
    public byte[] XML;
	public boolean isb64;
    public Builder options = RequestConfig.custom();
    public String proxyHost;
    public int proxyPort;
    public AccountBalanceAction action;

    public IRequest(String URI, String user, String password, String version, boolean isb64, String proxyHost, int proxyPort) {
        this.URI = URI;
        User = user;
        Password = password;
        this.version = version;
        this.isb64 = isb64;
        this.proxyHost = proxyHost;
        this.proxyPort = proxyPort;
    }

    public IRequest(String token, String URI, String version, boolean isb64, String proxyHost, int proxyPort) {

        Token = token;
        this.URI = URI;
        this.version = version;
        this.isb64 = isb64;
        this.proxyHost = proxyHost;
        this.proxyPort = proxyPort;
    }
    
    public IRequest(String URI, String user, String password, String proxyHost, int proxyPort) {
        this.URI = URI;
        User = user;
        Password = password;
        this.proxyHost = proxyHost;
        this.proxyPort = proxyPort;
    }

    public IRequest(String token, String URI, String xml, String version, String proxyHost, int proxyPort) {
        Token = token;
        this.URI = URI;
        this.version = version;
        this.xml = xml;
        this.proxyHost = proxyHost;
        this.proxyPort = proxyPort;
    }

    public IRequest(String token, String URI, byte[] xml, String version, String proxyHost, int proxyPort) {
        Token = token;
        this.URI = URI;
        this.version = version;
        this.XML = xml;
        this.proxyHost = proxyHost;
        this.proxyPort = proxyPort;
    }

    public IRequest(String token, String URI, String proxyHost, int proxyPort) {
        Token = token;
        this.URI = URI;
        this.proxyHost = proxyHost;
        this.proxyPort = proxyPort;
    }

}