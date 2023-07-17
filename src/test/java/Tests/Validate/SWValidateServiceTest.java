package Tests.Validate;

import java.util.LinkedList;
import org.junit.Assert;
import org.junit.Test;
import Services.Validate.SWValidateService;
import Tests.Utils;
import Utils.Responses.Validate.DetailData;
import Utils.Responses.Validate.DetailNode;
import Utils.Responses.Validate.ValidateXmlResponse;
import junit.framework.TestCase;

public class SWValidateServiceTest extends TestCase {
    @Test
	public void testValidateREAL_XML_STRING_USER_PASSWORD() throws Exception {
        SWValidateService api = new SWValidateService(Utils.userSW, Utils.passwordSW,Utils.urlSW);
        ValidateXmlResponse response = null;
        Utils ut = new Utils();
        System.out.println(ut.StringgenBasico(false));
        response = (ValidateXmlResponse) api.ValidateXml(ut.StringgenBasico(false));
        System.out.println(response.Status);
        System.out.println(response.HttpStatusCode);
        System.out.println(response.message);
        LinkedList<DetailNode> List = (LinkedList<DetailNode>) response.detail;
        for(int i = 0; i < List.size(); i++) {
        	DetailNode node = List.get(i);
        	LinkedList<DetailData> ListData = node.detail;
        	for(int j = 0; j < ListData.size(); j++) {
        		DetailData datos = ListData.get(j);
        		System.out.println("\t\t"+datos.message);
        		System.out.println("\t\t"+datos.messageDetail);
        		System.out.println("\t\t"+datos.type);
        	}
        	System.out.println("\t"+node.section);
        }
        System.out.println(response.cadenaOriginalComprobante);
        System.out.println(response.cadenaOriginalSAT);
        System.out.println(response.uuid);
        System.out.println(response.statusSat);
        System.out.println(response.statusCodeSat);
        String expect_status = "success";
        Assert.assertTrue(expect_status.equalsIgnoreCase(response.Status));
    }

    @Test
	public void testValidateNULL_XML_STRING_USER_PASSWORD() throws Exception {
        SWValidateService api = new SWValidateService(Utils.userSW, Utils.passwordSW,Utils.urlSW);
        ValidateXmlResponse response = null;
        response = (ValidateXmlResponse) api.ValidateXml(null);
        System.out.println(response.Status);
        System.out.println(response.HttpStatusCode);
        System.out.println(response.message);
        String expect_status = "error";
        Assert.assertTrue(expect_status.equalsIgnoreCase(response.Status));
    }
    
    @Test
	public void testValidateEMPTY_XML_STRING_USER_PASSWORD() throws Exception {
        SWValidateService api = new SWValidateService(Utils.userSW, Utils.passwordSW,Utils.urlSW);
        ValidateXmlResponse response = null;
        response = (ValidateXmlResponse) api.ValidateXml("");
        System.out.println(response.Status);
        System.out.println(response.HttpStatusCode);
        System.out.println(response.message);
        String expect_status = "error";
        Assert.assertTrue(expect_status.equalsIgnoreCase(response.Status));
    }
}
