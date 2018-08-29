package Utils.Responses;

import java.util.List;

public class PendientesCancelarResponse extends IResponse {
	public List<String> UUIDS;
	public String CodStatus;
	public PendientesCancelarResponse(int httpStatusCode,String status, List<String> UUIDS, String CodStatus, String msg, String msgDetail) {
		super(httpStatusCode, status, msg, msgDetail);
		this.UUIDS = UUIDS;
		this.CodStatus = CodStatus;
	}
	public PendientesCancelarResponse(int httpStatusCode, String status, String msg, String msgDetail) {
	    super(httpStatusCode, status, msg, msgDetail);
	}
}
