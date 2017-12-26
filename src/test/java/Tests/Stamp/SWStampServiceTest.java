package Tests.Stamp;

import Exceptions.AuthException;
import Exceptions.GeneralException;
import Services.Authentication.SWAuthenticationService;
import Services.Stamp.SWStampService;
import Tests.Utils;
import Utils.Responses.*;
import junit.framework.TestCase;
import org.json.JSONObject;
import org.junit.Assert;




public class SWStampServiceTest extends TestCase {


//STANDARD XML
   public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V1() throws Exception {
        SWStampService api = new SWStampService("T2lYQ0t4L0RHVkR4dHZ5Nkk1VHNEakZ3Y0J4Nk9GODZuRyt4cE1wVm5tbXB3YVZxTHdOdHAwVXY2NTdJb1hkREtXTzE3dk9pMmdMdkFDR2xFWFVPUXpTUm9mTG1ySXdZbFNja3FRa0RlYURqbzdzdlI2UUx1WGJiKzViUWY2dnZGbFloUDJ6RjhFTGF4M1BySnJ4cHF0YjUvbmRyWWpjTkVLN3ppd3RxL0dJPQ.T2lYQ0t4L0RHVkR4dHZ5Nkk1VHNEakZ3Y0J4Nk9GODZuRyt4cE1wVm5tbFlVcU92YUJTZWlHU3pER1kySnlXRTF4alNUS0ZWcUlVS0NhelhqaXdnWTRncklVSWVvZlFZMWNyUjVxYUFxMWFxcStUL1IzdGpHRTJqdS9Zakw2UGRiMTFPRlV3a2kyOWI5WUZHWk85ODJtU0M2UlJEUkFTVXhYTDNKZVdhOXIySE1tUVlFdm1jN3kvRStBQlpLRi9NeWJrd0R3clhpYWJrVUMwV0Mwd3FhUXdpUFF5NW5PN3J5cklMb0FETHlxVFRtRW16UW5ZVjAwUjdCa2g0Yk1iTExCeXJkVDRhMGMxOUZ1YWlIUWRRVC8yalFTNUczZXdvWlF0cSt2UW0waFZKY2gyaW5jeElydXN3clNPUDNvU1J2dm9weHBTSlZYNU9aaGsvalpQMUxsekZtK1Q3N25hd09CZmJ1K2RMVlRkandoUmE3c2gvanFxTUkwQmtmYURMQ2o0WjVqajlhVXRFejFHTHpVN211dFl6cE9iTFFOV1JKZFJ2dDZnaytXNktncDVKa1hlVElzM2VUenNXQ1dnVU4zc05pM0cyaXZLYWsxMFlVbHE2d1ZpeWgxWTRIdGhibG1seXg4UllCMm89.uMq7ctwyL9rXfh06z5mJ5Co0WDvanjOiITzzQCFxDfQ","http://services.test.sw.com.mx"
                ,"127.0.0.1","8888");
        SuccessV4Response response = null;
        Utils ut = new Utils();


        response = (SuccessV4Response) api.Stamp(ut.StringgenBasico(),"v4");
        System.out.println(response.Status);

        System.out.println(response.HttpStatusCode);
        //System.out.println(response.tfd);
        System.out.println(response.message);
        String expect_status = "success";
       String expect_error = "307. El comprobante contiene un timbre previo.";
       Assert.assertTrue(expect_status.equalsIgnoreCase(response.Status) || expect_error.equalsIgnoreCase(response.message));
    }

    public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V2() throws Exception {
        SWStampService api = new SWStampService("demo","123456789",Utils.url_pruebas);
        SuccessV2Response response = null;
        Utils ut = new Utils();
        if(ut.getRandomBoolean()){
            response = (SuccessV2Response) api.Stamp(ut.StringgenBasico(),"v2");
        }else{
            response = (SuccessV2Response) api.Stamp(ut.signXML(ut.StringgenBasico()),"v2");
        }

        System.out.println(response.message);
        System.out.println(response.Status);
        System.out.println(response.HttpStatusCode);
        System.out.println(response.tfd);
        System.out.println(response.cfdi);
        String expect_status = "success";
        String expect_error = "307. El comprobante contiene un timbre previo.";
        Assert.assertTrue(expect_status.equalsIgnoreCase(response.Status) || expect_error.equalsIgnoreCase(response.message));
    }

    public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V3() throws Exception {
        SWStampService api = new SWStampService("demo","123456789",Utils.url_pruebas);
        SuccessV3Response response = null;
        Utils ut = new Utils();
        response = (SuccessV3Response) api.Stamp(ut.StringgenBasico(),"v3");
        System.out.println(response.Status);
        System.out.println(response.HttpStatusCode);
        System.out.println(response.message);
        System.out.println(response.cfdi);
        String expect_status = "success";
        String expect_error = "307. El comprobante contiene un timbre previo.";
        Assert.assertTrue(expect_status.equalsIgnoreCase(response.Status) || expect_error.equalsIgnoreCase(response.message));
    }

    public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V4() throws Exception {
        SWStampService api = new SWStampService("demo","123456789",Utils.url_pruebas);
        SuccessV4Response response = null;
        Utils ut = new Utils();
        response = (SuccessV4Response) api.Stamp(ut.StringgenBasico(),"V4");
        System.out.println(response.message);
        System.out.println(response.Status);
        System.out.println(response.cfdi);
        System.out.println(response.qrCode);
        System.out.println(response.cadenaOriginalSAT);
        System.out.println(response.selloCFDI);
        System.out.println(response.selloSAT);
        System.out.println(response.noCertificadoCFDI);
        System.out.println(response.noCertificadoSAT);
        System.out.println(response.fechaTimbrado);
        System.out.println(response.uuid);
        String expect_status = "success";
        String expect_error = "307. El comprobante contiene un timbre previo.";
        Assert.assertTrue(expect_status.equalsIgnoreCase(response.Status) || expect_error.equalsIgnoreCase(response.message));

    }

    public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V1_b64() throws Exception {
        SWStampService api = new SWStampService("demo","123456789",Utils.url_pruebas);
        SuccessV1Response response = null;
        Utils ut = new Utils();
        response = (SuccessV1Response) api.Stamp(ut.toBase64(ut.StringgenBasico()),"v1",true);
        System.out.println(response.Status);
        System.out.println(response.message);
        System.out.println(response.HttpStatusCode);
        System.out.println(response.tfd);
        String expect_error = "307. El comprobante contiene un timbre previo.";
        Assert.assertTrue(Utils.isValidB64(response.tfd) || expect_error.equalsIgnoreCase(response.message));


    }

    public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V2_b64() throws Exception {
        SWStampService api = new SWStampService("demo","123456789",Utils.url_pruebas);
        SuccessV2Response response = null;
        Utils ut = new Utils();
        response = (SuccessV2Response) api.Stamp(ut.toBase64(ut.StringgenBasico()),"v2",true);
        System.out.println(response.Status);
        System.out.println(response.HttpStatusCode);
        System.out.println(response.tfd);
        System.out.println(response.cfdi);
        boolean cfdi_valid = Utils.isValidB64(response.cfdi), tfd_valid = Utils.isValidB64(response.tfd);
        String expect_error = "307. El comprobante contiene un timbre previo.";
        Assert.assertTrue(cfdi_valid && tfd_valid || expect_error.equalsIgnoreCase((response.message)));

    }

    public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V3_b64() throws Exception {
        SWStampService api = new SWStampService("demo","123456789",Utils.url_pruebas);
        SuccessV3Response response = null;
        Utils ut = new Utils();
        response = (SuccessV3Response) api.Stamp(ut.toBase64(ut.StringgenBasico()),"v3",true);
        System.out.println(response.message);
        System.out.println(response.Status);
        System.out.println(response.HttpStatusCode);
        System.out.println(response.message);
        System.out.println(response.cfdi);
        String expect_error = "307. El comprobante contiene un timbre previo.";
        Assert.assertTrue(Utils.isValidB64(response.cfdi) || expect_error.equalsIgnoreCase(response.message));
    }

    public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V4_b64() throws Exception {
        SWStampService api = new SWStampService("demo","123456789",Utils.url_pruebas);
        SuccessV4Response response = null;
        Utils ut = new Utils();
        response = (SuccessV4Response) api.Stamp(ut.toBase64(ut.StringgenBasico()),"V4",true);
        System.out.println(response.message);
        System.out.println(response.Status);
        System.out.println(response.cfdi);
        System.out.println(response.qrCode);
        System.out.println(response.cadenaOriginalSAT);
        System.out.println(response.selloCFDI);
        System.out.println(response.selloSAT);
        System.out.println(response.noCertificadoCFDI);
        System.out.println(response.noCertificadoSAT);
        System.out.println(response.fechaTimbrado);
        System.out.println(response.uuid);
        boolean valid_cfdi = Utils.isValidB64(response.cfdi),
                valid_qr = Utils.isValidB64(response.qrCode),
                valid_sellocfdi = Utils.isValidB64(response.selloCFDI),
                valid_sellosat = Utils.isValidB64(response.selloSAT);
        String expect_error = "307. El comprobante contiene un timbre previo.";
        Assert.assertTrue(valid_cfdi && valid_qr && valid_sellocfdi && valid_sellosat || expect_error.equalsIgnoreCase(response.message));
    }



    //cc10 XML

    public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V1_CC10() throws Exception {
        SWStampService api = new SWStampService("demo","123456789",Utils.url_pruebas);
        SuccessV1Response response = null;
        Utils ut = new Utils();
        response = (SuccessV1Response) api.Stamp(ut.genc10(),"v1");
        System.out.println(response.message);
        System.out.println(response.Status);
        System.out.println(response.HttpStatusCode);
        System.out.println(response.tfd);
        String expect_status = "success";
        String expect_error = "307. El comprobante contiene un timbre previo.";
        Assert.assertTrue(expect_status.equalsIgnoreCase(response.Status) || expect_error.equalsIgnoreCase(response.message));
    }

    public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V2_CC10() throws Exception {
        SWStampService api = new SWStampService("demo","123456789",Utils.url_pruebas);
        SuccessV2Response response = null;
        Utils ut = new Utils();
        response = (SuccessV2Response) api.Stamp(ut.genc10(),"v2");
        System.out.println(response.Status);
        System.out.println(response.message);
        System.out.println(response.HttpStatusCode);
        System.out.println(response.tfd);
        System.out.println(response.cfdi);
        String expect_status = "success";
        String expect_error = "307. El comprobante contiene un timbre previo.";
        Assert.assertTrue(expect_status.equalsIgnoreCase(response.Status) || expect_error.equalsIgnoreCase(response.message));
    }

    public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V3_CC10() throws Exception {
        SWStampService api = new SWStampService("demo","123456789",Utils.url_pruebas);
        SuccessV3Response response = null;
        Utils ut = new Utils();
        response = (SuccessV3Response) api.Stamp(ut.genc10(),"v3");
        System.out.println(response.Status);
        System.out.println(response.HttpStatusCode);
        System.out.println(response.cfdi);
        String expect_status = "success";
        String expect_error = "307. El comprobante contiene un timbre previo.";
        Assert.assertTrue(expect_status.equalsIgnoreCase(response.Status) || expect_error.equalsIgnoreCase(response.message));
    }

    public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V4_CC10() throws Exception {
        SWStampService api = new SWStampService("demo","123456789",Utils.url_pruebas);
        SuccessV4Response response = null;
        Utils ut = new Utils();
        response = (SuccessV4Response) api.Stamp(ut.genc10(),"V4");
        System.out.println(response.Status);

        System.out.println(response.qrCode);
        System.out.println(response.cadenaOriginalSAT);
        System.out.println(response.selloCFDI);
        System.out.println(response.selloSAT);
        System.out.println(response.noCertificadoCFDI);
        System.out.println(response.noCertificadoSAT);
        System.out.println(response.fechaTimbrado);
        System.out.println(response.uuid);
        String expect_status = "success";
        String expect_error = "307. El comprobante contiene un timbre previo.";
        Assert.assertTrue(expect_status.equalsIgnoreCase(response.Status) || expect_error.equalsIgnoreCase(response.message));

    }

    public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V1_b64_CC10() throws Exception {
        SWStampService api = new SWStampService("demo","123456789",Utils.url_pruebas);
        SuccessV1Response response = null;
        Utils ut = new Utils();
        response = (SuccessV1Response) api.Stamp(ut.toBase64(ut.genc10()),"v1",true);
        System.out.println(response.Status);
        System.out.println(response.HttpStatusCode);
        System.out.println(response.tfd);
        String expect_error = "307. El comprobante contiene un timbre previo.";
        Assert.assertTrue(Utils.isValidB64(response.tfd) || expect_error.equalsIgnoreCase(response.message));
    }

    public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V2_b64_CC10() throws Exception {
        SWStampService api = new SWStampService("demo","123456789",Utils.url_pruebas);
        SuccessV2Response response = null;
        Utils ut = new Utils();
        response = (SuccessV2Response) api.Stamp(ut.toBase64(ut.genc10()),"v2",true);
        System.out.println(response.Status);
        System.out.println(response.HttpStatusCode);
        System.out.println(response.tfd);
        System.out.println(response.cfdi);
        boolean cfdi_valid = Utils.isValidB64(response.cfdi), tfd_valid = Utils.isValidB64(response.tfd);
        String expect_error = "307. El comprobante contiene un timbre previo.";
        Assert.assertTrue(cfdi_valid && tfd_valid || expect_error.equalsIgnoreCase(response.message));

    }

    public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V3_b64_CC10() throws Exception {
        SWStampService api = new SWStampService("demo","123456789",Utils.url_pruebas);
        SuccessV3Response response = null;
        Utils ut = new Utils();
        response = (SuccessV3Response) api.Stamp(ut.toBase64(ut.genc10()),"v3",true);
        System.out.println(response.Status);
        System.out.println(response.HttpStatusCode);
        System.out.println(response.cfdi);
        String expect_error = "307. El comprobante contiene un timbre previo.";
        Assert.assertTrue(Utils.isValidB64(response.cfdi) || expect_error.equalsIgnoreCase(response.message));
    }

    public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V4_b64_CC10() throws Exception {
        SWStampService api = new SWStampService("demo","123456789",Utils.url_pruebas);
        SuccessV4Response response = null;
        Utils ut = new Utils();
        response = (SuccessV4Response) api.Stamp(ut.toBase64(ut.genc10()),"V4",true);
        System.out.println(response.Status);
        System.out.println(response.cfdi);
        System.out.println(response.qrCode);
        System.out.println(response.cadenaOriginalSAT);
        System.out.println(response.selloCFDI);
        System.out.println(response.selloSAT);
        System.out.println(response.noCertificadoCFDI);
        System.out.println(response.noCertificadoSAT);
        System.out.println(response.fechaTimbrado);
        System.out.println(response.uuid);
        boolean valid_cfdi = Utils.isValidB64(response.cfdi),
                valid_qr = Utils.isValidB64(response.qrCode),
                valid_sellocfdi = Utils.isValidB64(response.selloCFDI),
                valid_sellosat = Utils.isValidB64(response.selloSAT);
        String expect_error = "307. El comprobante contiene un timbre previo.";
        Assert.assertTrue(valid_cfdi && valid_qr && valid_sellocfdi && valid_sellosat || expect_error.equalsIgnoreCase(response.message));
    }



    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    //////////////////////////////////////////PAGOS10/////////////////////////////////////////////////////////////////////////////////////////


    public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V1_PAGOS10() throws Exception {
        SWStampService api = new SWStampService("demo","123456789",Utils.url_pruebas);
        SuccessV1Response response = null;
        Utils ut = new Utils();
        response = (SuccessV1Response) api.Stamp(ut.genPagos10(),"v1");
        System.out.println(response.Status);
        System.out.println(response.message);
        System.out.println(response.HttpStatusCode);
        System.out.println(response.tfd);
        String expect_status = "success";
        String expect_error = "307. El comprobante contiene un timbre previo.";
        Assert.assertTrue(expect_status.equalsIgnoreCase(response.Status) || expect_error.equalsIgnoreCase(response.message));
    }

    public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V2_PAGOS10() throws Exception {
        SWStampService api = new SWStampService("demo","123456789",Utils.url_pruebas);
        SuccessV2Response response = null;
        Utils ut = new Utils();
        response = (SuccessV2Response) api.Stamp(ut.genPagos10(),"v2");
        System.out.println(response.Status);
        System.out.println(response.message);
        System.out.println(response.HttpStatusCode);
        System.out.println(response.tfd);
        System.out.println(response.cfdi);
        String expect_status = "success";
        String expect_error = "307. El comprobante contiene un timbre previo.";
        Assert.assertTrue(expect_status.equalsIgnoreCase(response.Status) || expect_error.equalsIgnoreCase(response.message));
    }

    public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V3_PAGOS10() throws Exception {
        SWStampService api = new SWStampService("demo","123456789",Utils.url_pruebas);
        SuccessV3Response response = null;
        Utils ut = new Utils();
        response = (SuccessV3Response) api.Stamp(ut.genPagos10(),"v3");
        System.out.println(response.Status);
        System.out.println(response.message);
        System.out.println(response.HttpStatusCode);

        System.out.println(response.cfdi);
        String expect_status = "success";
        String expect_error = "307. El comprobante contiene un timbre previo.";
        Assert.assertTrue(expect_status.equalsIgnoreCase(response.Status) || expect_error.equalsIgnoreCase(response.message));
    }

    public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V4_PAGOS10() throws Exception {
        SWStampService api = new SWStampService("demo","123456789",Utils.url_pruebas);
        SuccessV4Response response = null;
        Utils ut = new Utils();
        response = (SuccessV4Response) api.Stamp(ut.genPagos10(),"V4");
        System.out.println(response.Status);
        System.out.println(response.cfdi);
        System.out.println(response.qrCode);
        System.out.println(response.cadenaOriginalSAT);
        System.out.println(response.selloCFDI);
        System.out.println(response.selloSAT);
        System.out.println(response.noCertificadoCFDI);
        System.out.println(response.noCertificadoSAT);
        System.out.println(response.fechaTimbrado);
        System.out.println(response.uuid);
        String expect_status = "success";
        String expect_error = "307. El comprobante contiene un timbre previo.";
        Assert.assertTrue(expect_status.equalsIgnoreCase(response.Status) || expect_error.equalsIgnoreCase(response.message));

    }

    public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V1_b64_PAGOS10() throws Exception {
        SWStampService api = new SWStampService("demo","123456789",Utils.url_pruebas);
        SuccessV1Response response = null;
        Utils ut = new Utils();
        response = (SuccessV1Response) api.Stamp(ut.toBase64(ut.genPagos10()),"v1",true);
        System.out.println(response.Status);
        System.out.println(response.message);
        System.out.println(response.HttpStatusCode);
        System.out.println(response.tfd);
        String expect_error = "307. El comprobante contiene un timbre previo.";
        Assert.assertTrue(Utils.isValidB64(response.tfd) || expect_error.equalsIgnoreCase(response.message));
    }

    public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V2_b64_PAGOS10() throws Exception {
        SWStampService api = new SWStampService("demo","123456789",Utils.url_pruebas);
        SuccessV2Response response = null;
        Utils ut = new Utils();
        response = (SuccessV2Response) api.Stamp(ut.toBase64(ut.genPagos10()),"v2",true);
        System.out.println(response.Status);
        System.out.println(response.message);
        System.out.println(response.HttpStatusCode);
        System.out.println(response.tfd);
        System.out.println(response.cfdi);
        boolean cfdi_valid = Utils.isValidB64(response.cfdi), tfd_valid = Utils.isValidB64(response.tfd);
        String expect_error = "307. El comprobante contiene un timbre previo.";
        Assert.assertTrue(cfdi_valid && tfd_valid || expect_error.equalsIgnoreCase(response.message));

    }

    public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V3_b64_PAGOS10() throws Exception {
        SWStampService api = new SWStampService("demo","123456789",Utils.url_pruebas);
        SuccessV3Response response = null;
        Utils ut = new Utils();
        response = (SuccessV3Response) api.Stamp(ut.toBase64(ut.genPagos10()),"v3",true);
        System.out.println(response.Status);
        System.out.println(response.message);
        System.out.println(response.HttpStatusCode);
        System.out.println(response.cfdi);
        String expect_error = "307. El comprobante contiene un timbre previo.";
        Assert.assertTrue(Utils.isValidB64(response.cfdi) || expect_error.equalsIgnoreCase(response.message));
    }

    public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V4_b64_PAGOS10() throws Exception {
        SWStampService api = new SWStampService("demo","123456789",Utils.url_pruebas);
        SuccessV4Response response = null;
        Utils ut = new Utils();
        response = (SuccessV4Response) api.Stamp(ut.toBase64(ut.genPagos10()),"V4",true);
        System.out.println(response.Status);
        System.out.println(response.message);
        System.out.println(response.cfdi);

        System.out.println(response.qrCode);
        System.out.println(response.cadenaOriginalSAT);
        System.out.println(response.selloCFDI);
        System.out.println(response.selloSAT);
        System.out.println(response.noCertificadoCFDI);
        System.out.println(response.noCertificadoSAT);
        System.out.println(response.fechaTimbrado);
        System.out.println(response.uuid);
        boolean valid_cfdi = Utils.isValidB64(response.cfdi),
                valid_qr = Utils.isValidB64(response.qrCode),
                valid_sellocfdi = Utils.isValidB64(response.selloCFDI),
                valid_sellosat = Utils.isValidB64(response.selloSAT);
        String expect_error = "307. El comprobante contiene un timbre previo.";
        Assert.assertTrue(valid_cfdi && valid_qr && valid_sellocfdi && valid_sellosat || expect_error.equalsIgnoreCase(response.message));
    }



    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////NOMINA12/////////////////////////////////////////////////////////////////////////////////////////


    public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V1_NOMINA12() throws Exception {
        SWStampService api = new SWStampService("demo","123456789",Utils.url_pruebas);
        SuccessV1Response response = null;
        Utils ut = new Utils();
        response = (SuccessV1Response) api.Stamp(ut.genNomina10(),"v1");
        System.out.println(response.Status);
        System.out.print(response.message);
        System.out.println(response.HttpStatusCode);
        System.out.println(response.tfd);
        
    }

    public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V2_NOMINA12() throws Exception {
        SWStampService api = new SWStampService("demo","123456789",Utils.url_pruebas);
        SuccessV2Response response = null;
        Utils ut = new Utils();
        response = (SuccessV2Response) api.Stamp(ut.genNomina10(),"v2");
        System.out.println(response.Status);
        System.out.println(response.HttpStatusCode);
        System.out.println(response.tfd);
        System.out.println(response.cfdi);

    }

    public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V3_NOMINA12() throws Exception {
        SWStampService api = new SWStampService("demo","123456789",Utils.url_pruebas);
        SuccessV3Response response = null;
        Utils ut = new Utils();
        response = (SuccessV3Response) api.Stamp(ut.genNomina10(),"v3");
        System.out.println(response.Status);
        System.out.println(response.HttpStatusCode);

        System.out.println(response.cfdi);

    }

    public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V4_NOMINA12() throws Exception {
        SWStampService api = new SWStampService("demo","123456789",Utils.url_pruebas);
        SuccessV4Response response = null;
        Utils ut = new Utils();
        response = (SuccessV4Response) api.Stamp(ut.genNomina10(),"V4");
        System.out.println(response.Status);
        System.out.println(response.cfdi);
        System.out.println(response.qrCode);
        System.out.println(response.cadenaOriginalSAT);
        System.out.println(response.selloCFDI);
        System.out.println(response.selloSAT);
        System.out.println(response.noCertificadoCFDI);
        System.out.println(response.noCertificadoSAT);
        System.out.println(response.fechaTimbrado);
        System.out.println(response.uuid);


    }

    public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V1_b64_NOMINA12() throws Exception {
        SWStampService api = new SWStampService("demo","123456789",Utils.url_pruebas);
        SuccessV1Response response = null;
        Utils ut = new Utils();
        response = (SuccessV1Response) api.Stamp(ut.toBase64(ut.genNomina10()),"v1",true);
        System.out.println(response.Status);
        System.out.println(response.HttpStatusCode);
        System.out.println(response.message);
        System.out.println(response.tfd);
        Assert.assertTrue(Utils.isValidB64(response.tfd));
        String expect_status = "success";
        String expect_error = "307. El comprobante contiene un timbre previo.";
        Assert.assertTrue(expect_status.equalsIgnoreCase(response.Status) || expect_error.equalsIgnoreCase(response.message));
    }

    public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V2_b64_NOMINA12() throws Exception {
        SWStampService api = new SWStampService("demo","123456789",Utils.url_pruebas);
        SuccessV2Response response = null;
        Utils ut = new Utils();
        response = (SuccessV2Response) api.Stamp(ut.toBase64(ut.genNomina10()),"v2",true);
        System.out.println(response.Status);
        System.out.println(response.HttpStatusCode);
        System.out.println(response.tfd);
        System.out.println(response.cfdi);
        boolean cfdi_valid = Utils.isValidB64(response.cfdi), tfd_valid = Utils.isValidB64(response.tfd);
        String expect_error = "307. El comprobante contiene un timbre previo.";
        Assert.assertTrue(cfdi_valid && tfd_valid || expect_error.equalsIgnoreCase(response.message));

    }

    public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V3_b64_NOMINA12() throws Exception {
        SWStampService api = new SWStampService("demo","123456789",Utils.url_pruebas);
        SuccessV3Response response = null;
        Utils ut = new Utils();
        response = (SuccessV3Response) api.Stamp(ut.toBase64(ut.genNomina10()),"v3",true);
        System.out.println(response.Status);
        System.out.println(response.HttpStatusCode);
        System.out.println(response.cfdi);
        String expect_error = "307. El comprobante contiene un timbre previo.";
        Assert.assertTrue(Utils.isValidB64(response.cfdi) || expect_error.equalsIgnoreCase(response.message));
    }

    public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V4_b64_NOMINA12() throws Exception {
        SWStampService api = new SWStampService("demo","123456789",Utils.url_pruebas);
        SuccessV4Response response = null;
        Utils ut = new Utils();
        response = (SuccessV4Response) api.Stamp(ut.toBase64(ut.genNomina10()),"V4",true);
        System.out.println(response.Status);
        System.out.println(response.cfdi);
        System.out.println(response.qrCode);
        System.out.println(response.cadenaOriginalSAT);
        System.out.println(response.selloCFDI);
        System.out.println(response.selloSAT);
        System.out.println(response.noCertificadoCFDI);
        System.out.println(response.noCertificadoSAT);
        System.out.println(response.fechaTimbrado);
        System.out.println(response.uuid);
        boolean valid_cfdi = Utils.isValidB64(response.cfdi),
                valid_qr = Utils.isValidB64(response.qrCode),
                valid_sellocfdi = Utils.isValidB64(response.selloCFDI),
                valid_sellosat = Utils.isValidB64(response.selloSAT);
        String expect_error = "307. El comprobante contiene un timbre previo.";
        Assert.assertTrue(valid_cfdi && valid_qr && valid_sellocfdi && valid_sellosat || expect_error.equalsIgnoreCase(response.message));
    }



    public void testStampREAL_XML_STRING_EMPTY_PARAMS() throws Exception {

        try{
            SWStampService api = new SWStampService("","","");
            IResponse response = null;
            Utils ut = new Utils();
            response = api.Stamp(ut.StringgenBasico(),"v1");
            System.out.println(response.Status);
            System.out.println(response.HttpStatusCode);

        }
        catch(Exception e){
            System.out.println("Correcto excepcion lanzada");
            System.out.println(e.getMessage());
            Assert.assertNotNull("some bad happend", e);

        }

    }

    public void testStampREAL_XML_STRING_INCORRECT_PARAMS() throws Exception {

        try{
            SWStampService api = new SWStampService("USER_BAD","PASSWORD_BAD","BAD_URI");
            IResponse response = null;
            Utils ut = new Utils();
            response = api.Stamp(ut.StringgenBasico(),"v1");
            System.out.println(response.Status);
            System.out.println(response.HttpStatusCode);

        }
        catch(Exception e){
            System.out.println("Correcto excepcion lanzada");
            System.out.println(e.getMessage());
            Assert.assertNotNull("some bad happend", e);

        }

    }

    public void testStampTOKEN_EXPIRES_NOT_USER_NOT_PASSWORD() throws Exception {
        SWStampService api = new SWStampService("demo","123456789",Utils.url_pruebas);
        IResponse response = null;

        int request_number = 50;
        int revoke_token_step = request_number/2;
        int counter;

        for (counter=0;counter<request_number;counter++){
            if (counter==revoke_token_step){
                api.setToken(null);
                api.setUser(null);
                api.setPassword(null);
            }
            try{
                Utils ut = new Utils();
                response = api.Stamp(ut.StringgenBasico(),"v1");


            }catch (Exception e){
                System.out.println(e.getMessage());
                System.out.println("Correcto excepcion lanzada");

               Assert.assertNotNull("some bad happend", e);
               break;
            }
        }
    }



}