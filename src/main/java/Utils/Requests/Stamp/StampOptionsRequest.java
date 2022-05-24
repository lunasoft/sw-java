package Utils.Requests.Stamp;

import Utils.Constants;
import Utils.Requests.IRequest;

public class StampOptionsRequest extends IRequest {
    private String xml;
    
    public StampOptionsRequest(String token, String URI, String xml, String version, boolean isb64, String proxyHost, int proxyPort, boolean isV2) {
        super(token, URI + (isV2 ? Constants.STAMP_V2_PATH : Constants.STAMP_PATH) + version + (isb64 ? "/b64" : ""), version, isb64, proxyHost, proxyPort);
        this.xml = xml;
        this.version = version;
    }

    public StampOptionsRequest(String token, String URI, String xml, String version, String proxyHost, int proxyPort, boolean isV2) {
        super(token, URI + (isV2 ? Constants.STAMP_V2_PATH : Constants.STAMP_PATH) + version, xml, version, proxyHost, proxyPort);
        this.xml = xml;
        this.version = version;
    }
    
    public String getXml() {
        return xml;
    }
}