package Tests.Stamp;

import Services.Stamp.SWStampService;
import Tests.Utils;
import Utils.Responses.*;
import Utils.Responses.Stamp.SuccessV1Response;
import Utils.Responses.Stamp.SuccessV2Response;
import Utils.Responses.Stamp.SuccessV3Response;
import Utils.Responses.Stamp.SuccessV4Response;
import org.junit.Assert;
import org.junit.Test;

public class SWStampServiceTest {
	//STANDARD XML
	@Test
	public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V1() throws Exception {
		SWStampService api = new SWStampService(Utils.userSW, Utils.passwordSW, Utils.urlSW);
		SuccessV1Response response = null;
		Utils ut = new Utils();
		response = (SuccessV1Response) api.Stamp(ut.StringgenBasico(false), "v1");
		System.out.println(response.Status);
		System.out.println(response.HttpStatusCode);
		System.out.println(response.tfd);
		System.out.println(response.message);
		String expect_status = "success";
		Assert.assertTrue(expect_status.equalsIgnoreCase(response.Status));
	}
	@Test
	public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V2() throws Exception {
		SWStampService api = new SWStampService(Utils.userSW, Utils.passwordSW, Utils.urlSW);
		SuccessV2Response response = null;
		Utils ut = new Utils();
		response = (SuccessV2Response) api.Stamp(ut.StringgenBasico(false), "v2");

		System.out.println(response.message);
		System.out.println(response.Status);
		System.out.println(response.HttpStatusCode);
		System.out.println(response.tfd);
		System.out.println(response.cfdi);
		String expect_status = "success";
		Assert.assertTrue(expect_status.equalsIgnoreCase(response.Status));
	}
	@Test
	public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V3() throws Exception {
		SWStampService api = new SWStampService(Utils.userSW, Utils.passwordSW, Utils.urlSW);
		SuccessV3Response response = null;
		Utils ut = new Utils();
		response = (SuccessV3Response) api.Stamp(ut.StringgenBasico(false), "v3");
		System.out.println(response.Status);
		System.out.println(response.HttpStatusCode);
		System.out.println(response.cfdi);
		String expect_status = "success";
		Assert.assertTrue(expect_status.equalsIgnoreCase(response.Status));
	}
	@Test
	public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V4() throws Exception {
		SWStampService api = new SWStampService(Utils.userSW, Utils.passwordSW, Utils.urlSW);
		SuccessV4Response response = null;
		Utils ut = new Utils();
		response = (SuccessV4Response) api.Stamp(ut.StringgenBasico(false), "V4");
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
		System.out.println(response.messageDetail);
		String expect_status = "success";
		Assert.assertTrue(
				expect_status.equalsIgnoreCase(response.Status));

	}
	@Test
	public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V1_b64() throws Exception {
		SWStampService api = new SWStampService(Utils.userSW, Utils.passwordSW, Utils.urlSW);
		SuccessV1Response response = null;
		Utils ut = new Utils();
		response = (SuccessV1Response) api.Stamp(ut.StringgenBasico(true), "v1", true);
		System.out.println(response.Status);
		System.out.println(response.message);
		System.out.println(response.HttpStatusCode);
		System.out.println(response.tfd);
		Assert.assertTrue(Utils.isValidB64(response.tfd));
	}
	@Test
	public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V2_b64() throws Exception {
		SWStampService api = new SWStampService(Utils.userSW, Utils.passwordSW, Utils.urlSW);
		SuccessV2Response response = null;
		Utils ut = new Utils();
		response = (SuccessV2Response) api.Stamp(ut.StringgenBasico(true), "v2", true);
		System.out.println(response.Status);
		System.out.println(response.HttpStatusCode);
		System.out.println(response.tfd);
		System.out.println(response.cfdi);
		boolean cfdi_valid = Utils.isValidB64(response.cfdi), tfd_valid = Utils.isValidB64(response.tfd);
		Assert.assertTrue(cfdi_valid && tfd_valid);
	}
	@Test
	public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V3_b64() throws Exception {
		SWStampService api = new SWStampService(Utils.userSW, Utils.passwordSW, Utils.urlSW);
		SuccessV3Response response = null;
		Utils ut = new Utils();
		response = (SuccessV3Response) api.Stamp(ut.StringgenBasico(true), "v3", true);
		System.out.println(response.message);
		System.out.println(response.Status);
		System.out.println(response.HttpStatusCode);
		System.out.println(response.message);
		System.out.println(response.cfdi);
		Assert.assertTrue(Utils.isValidB64(response.cfdi));
	}
	@Test
	public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V4_b64() throws Exception {
		SWStampService api = new SWStampService(Utils.userSW, Utils.passwordSW, Utils.urlSW);
		SuccessV4Response response = null;
		Utils ut = new Utils();
		response = (SuccessV4Response) api.Stamp(ut.StringgenBasico(true), "V4", true);
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
		boolean valid_cfdi = Utils.isValidB64(response.cfdi), valid_qr = Utils.isValidB64(response.qrCode),
				valid_sellocfdi = Utils.isValidB64(response.selloCFDI),
				valid_sellosat = Utils.isValidB64(response.selloSAT);
		Assert.assertTrue(valid_cfdi && valid_qr && valid_sellocfdi && valid_sellosat);
	}

	// cc10 XML
	@Test
	public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V1_CC10() throws Exception {
		SWStampService api = new SWStampService(Utils.userSW, Utils.passwordSW, Utils.urlSW);
		SuccessV1Response response = null;
		Utils ut = new Utils();
		response = (SuccessV1Response) api.Stamp(ut.genComercioExterior(false), "v1");
		System.out.println(response.message);
		System.out.println(response.Status);
		System.out.println(response.HttpStatusCode);
		System.out.println(response.tfd);
		String expect_status = "success";
		Assert.assertTrue(expect_status.equalsIgnoreCase(response.Status));
	}
	@Test
	public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V2_CC10() throws Exception {
		SWStampService api = new SWStampService(Utils.userSW, Utils.passwordSW, Utils.urlSW);
		SuccessV2Response response = null;
		Utils ut = new Utils();
		response = (SuccessV2Response) api.Stamp(ut.genComercioExterior(false), "v2");
		System.out.println(response.Status);
		System.out.println(response.message);
		System.out.println(response.HttpStatusCode);
		System.out.println(response.tfd);
		System.out.println(response.cfdi);
		String expect_status = "success";
		Assert.assertTrue(expect_status.equalsIgnoreCase(response.Status));
	}
	@Test
	public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V3_CC10() throws Exception {
		SWStampService api = new SWStampService(Utils.userSW, Utils.passwordSW, Utils.urlSW);
		SuccessV3Response response = null;
		Utils ut = new Utils();
		response = (SuccessV3Response) api.Stamp(ut.genComercioExterior(false), "v3");
		System.out.println(response.Status);
		System.out.println(response.HttpStatusCode);
		System.out.println(response.cfdi);
		String expect_status = "success";
		Assert.assertTrue(expect_status.equalsIgnoreCase(response.Status));
	}
	@Test
	public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V4_CC10() throws Exception {
		SWStampService api = new SWStampService(Utils.userSW, Utils.passwordSW, Utils.urlSW);
		SuccessV4Response response = null;
		Utils ut = new Utils();
		response = (SuccessV4Response) api.Stamp(ut.genComercioExterior(false), "V4");
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
		Assert.assertTrue(expect_status.equalsIgnoreCase(response.Status));

	}
	@Test
	public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V1_b64_CC10() throws Exception {
		SWStampService api = new SWStampService(Utils.userSW, Utils.passwordSW, Utils.urlSW);
		SuccessV1Response response = null;
		Utils ut = new Utils();
		response = (SuccessV1Response) api.Stamp(ut.genComercioExterior(true), "v1", true);
		System.out.println(response.Status);
		System.out.println(response.HttpStatusCode);
		System.out.println(response.tfd);
		Assert.assertTrue(Utils.isValidB64(response.tfd));
	}
	@Test
	public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V2_b64_CC10() throws Exception {
		SWStampService api = new SWStampService(Utils.userSW, Utils.passwordSW, Utils.urlSW);
		SuccessV2Response response = null;
		Utils ut = new Utils();
		response = (SuccessV2Response) api.Stamp(ut.genComercioExterior(true), "v2", true);
		System.out.println(response.Status);
		System.out.println(response.HttpStatusCode);
		System.out.println(response.tfd);
		System.out.println(response.cfdi);
		boolean cfdi_valid = Utils.isValidB64(response.cfdi), tfd_valid = Utils.isValidB64(response.tfd);
		Assert.assertTrue(cfdi_valid && tfd_valid);
	}
	@Test
	public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V3_b64_CC10() throws Exception {
		SWStampService api = new SWStampService(Utils.userSW, Utils.passwordSW, Utils.urlSW);
		SuccessV3Response response = null;
		Utils ut = new Utils();
		response = (SuccessV3Response) api.Stamp(ut.genComercioExterior(true), "v3", true);
		System.out.println(response.Status);
		System.out.println(response.HttpStatusCode);
		System.out.println(response.cfdi);
		Assert.assertTrue(Utils.isValidB64(response.cfdi));
	}
	@Test
	public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V4_b64_CC10() throws Exception {
		SWStampService api = new SWStampService(Utils.userSW, Utils.passwordSW, Utils.urlSW);
		SuccessV4Response response = null;
		Utils ut = new Utils();
		response = (SuccessV4Response) api.Stamp(ut.genComercioExterior(true), "V4", true);
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
		boolean valid_cfdi = Utils.isValidB64(response.cfdi), valid_qr = Utils.isValidB64(response.qrCode),
				valid_sellocfdi = Utils.isValidB64(response.selloCFDI),
				valid_sellosat = Utils.isValidB64(response.selloSAT);
		Assert.assertTrue(valid_cfdi && valid_qr && valid_sellocfdi && valid_sellosat);
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////// PAGOS10/////////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V1_PAGOS10() throws Exception {
		SWStampService api = new SWStampService(Utils.userSW, Utils.passwordSW, Utils.urlSW);
		SuccessV1Response response = null;
		Utils ut = new Utils();
		response = (SuccessV1Response) api.Stamp(ut.genPagos10(false), "v1");
		System.out.println(response.Status);
		System.out.println(response.message);
		System.out.println(response.HttpStatusCode);
		System.out.println(response.tfd);
		String expect_status = "success";
		Assert.assertTrue(
				expect_status.equalsIgnoreCase(response.Status));
	}
	@Test
	public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V2_PAGOS10() throws Exception {
		SWStampService api = new SWStampService(Utils.userSW, Utils.passwordSW, Utils.urlSW);
		SuccessV2Response response = null;
		Utils ut = new Utils();
		response = (SuccessV2Response) api.Stamp(ut.genPagos10(false), "v2");
		System.out.println(response.Status);
		System.out.println(response.message);
		System.out.println(response.HttpStatusCode);
		System.out.println(response.tfd);
		System.out.println(response.cfdi);
		String expect_status = "success";
		Assert.assertTrue(expect_status.equalsIgnoreCase(response.Status));
	}
	@Test
	public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V3_PAGOS10() throws Exception {
		SWStampService api = new SWStampService(Utils.userSW, Utils.passwordSW, Utils.urlSW);
		SuccessV3Response response = null;
		Utils ut = new Utils();
		response = (SuccessV3Response) api.Stamp(ut.genPagos10(false), "v3");
		System.out.println(response.Status);
		System.out.println(response.message);
		System.out.println(response.HttpStatusCode);

		System.out.println(response.cfdi);
		String expect_status = "success";
		Assert.assertTrue(expect_status.equalsIgnoreCase(response.Status));
	}
	@Test
	public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V4_PAGOS10() throws Exception {
		SWStampService api = new SWStampService(Utils.userSW, Utils.passwordSW, Utils.urlSW);
		SuccessV4Response response = null;
		Utils ut = new Utils();
		response = (SuccessV4Response) api.Stamp(ut.genPagos10(false), "V4");
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
		Assert.assertTrue(expect_status.equalsIgnoreCase(response.Status));

	}
	@Test
	public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V1_b64_PAGOS10() throws Exception {
		SWStampService api = new SWStampService(Utils.userSW, Utils.passwordSW, Utils.urlSW);
		SuccessV1Response response = null;
		Utils ut = new Utils();
		response = (SuccessV1Response) api.Stamp(ut.genPagos10(true), "v1", true);
		System.out.println(response.Status);
		System.out.println(response.message);
		System.out.println(response.HttpStatusCode);
		System.out.println(response.tfd);
		Assert.assertTrue(Utils.isValidB64(response.tfd));
	}
	@Test
	public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V2_b64_PAGOS10() throws Exception {
		SWStampService api = new SWStampService(Utils.userSW, Utils.passwordSW, Utils.urlSW);
		SuccessV2Response response = null;
		Utils ut = new Utils();
		response = (SuccessV2Response) api.Stamp(ut.genPagos10(true), "v2", true);
		System.out.println(response.Status);
		System.out.println(response.message);
		System.out.println(response.HttpStatusCode);
		System.out.println(response.tfd);
		System.out.println(response.cfdi);
		boolean cfdi_valid = Utils.isValidB64(response.cfdi), tfd_valid = Utils.isValidB64(response.tfd);
		Assert.assertTrue(cfdi_valid && tfd_valid);

	}
	@Test
	public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V3_b64_PAGOS10() throws Exception {
		SWStampService api = new SWStampService(Utils.userSW, Utils.passwordSW, Utils.urlSW);
		SuccessV3Response response = null;
		Utils ut = new Utils();
		response = (SuccessV3Response) api.Stamp(ut.genPagos10(true), "v3", true);
		System.out.println(response.Status);
		System.out.println(response.message);
		System.out.println(response.HttpStatusCode);
		System.out.println(response.cfdi);
		Assert.assertTrue(Utils.isValidB64(response.cfdi));
	}
	@Test
	public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V4_b64_PAGOS10() throws Exception {
		SWStampService api = new SWStampService(Utils.userSW, Utils.passwordSW, Utils.urlSW);
		SuccessV4Response response = null;
		Utils ut = new Utils();
		response = (SuccessV4Response) api.Stamp(ut.genPagos10(true), "V4", true);
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
		boolean valid_cfdi = Utils.isValidB64(response.cfdi), valid_qr = Utils.isValidB64(response.qrCode),
				valid_sellocfdi = Utils.isValidB64(response.selloCFDI),
				valid_sellosat = Utils.isValidB64(response.selloSAT);
		Assert.assertTrue(valid_cfdi && valid_qr && valid_sellocfdi && valid_sellosat);
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////// NOMINA12/////////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V1_NOMINA12() throws Exception {
		SWStampService api = new SWStampService(Utils.userSW, Utils.passwordSW, Utils.urlSW);
		SuccessV1Response response = null;
		Utils ut = new Utils();
		response = (SuccessV1Response) api.Stamp(ut.genNomina12(false), "v1");
		System.out.println(response.Status);
		System.out.print(response.message);
		System.out.println(response.HttpStatusCode);
		System.out.println(response.tfd);
		String expect_status = "success";
		Assert.assertTrue(expect_status.equalsIgnoreCase(response.Status));
	}
	@Test
	public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V2_NOMINA12() throws Exception {
		SWStampService api = new SWStampService(Utils.userSW, Utils.passwordSW, Utils.urlSW);
		SuccessV2Response response = null;
		Utils ut = new Utils();
		response = (SuccessV2Response) api.Stamp(ut.genNomina12(false), "v2");
		System.out.println(response.Status);
		System.out.println(response.HttpStatusCode);
		System.out.println(response.tfd);
		System.out.println(response.cfdi);
		String expect_status = "success";
		Assert.assertTrue(expect_status.equalsIgnoreCase(response.Status));
	}
	@Test
	public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V3_NOMINA12() throws Exception {
		SWStampService api = new SWStampService(Utils.userSW, Utils.passwordSW, Utils.urlSW);
		SuccessV3Response response = null;
		Utils ut = new Utils();
		response = (SuccessV3Response) api.Stamp(ut.genNomina12(false), "v3");
		System.out.println(response.Status);
		System.out.println(response.HttpStatusCode);
		System.out.println(response.cfdi);
		String expect_status = "success";
		Assert.assertTrue(expect_status.equalsIgnoreCase(response.Status));
	}
	@Test
	public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V4_NOMINA12() throws Exception {
		SWStampService api = new SWStampService(Utils.userSW, Utils.passwordSW, Utils.urlSW);
		SuccessV4Response response = null;
		Utils ut = new Utils();
		response = (SuccessV4Response) api.Stamp(ut.genNomina12(false), "V4");
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
		Assert.assertTrue(expect_status.equalsIgnoreCase(response.Status));
	}
	@Test
	public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V1_b64_NOMINA12() throws Exception {
		SWStampService api = new SWStampService(Utils.userSW, Utils.passwordSW, Utils.urlSW);
		SuccessV1Response response = null;
		Utils ut = new Utils();
		response = (SuccessV1Response) api.Stamp(ut.genNomina12(true), "v1", true);
		System.out.println(response.Status);
		System.out.println(response.HttpStatusCode);
		System.out.println(response.message);
		System.out.println(response.tfd);
		Assert.assertTrue(Utils.isValidB64(response.tfd));
		String expect_status = "success";
		Assert.assertTrue(expect_status.equalsIgnoreCase(response.Status));
	}
	@Test
	public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V2_b64_NOMINA12() throws Exception {
		SWStampService api = new SWStampService(Utils.userSW, Utils.passwordSW, Utils.urlSW);
		SuccessV2Response response = null;
		Utils ut = new Utils();
		response = (SuccessV2Response) api.Stamp(ut.genNomina12(true), "v2", true);
		System.out.println(response.Status);
		System.out.println(response.HttpStatusCode);
		System.out.println(response.tfd);
		System.out.println(response.cfdi);
		boolean cfdi_valid = Utils.isValidB64(response.cfdi), tfd_valid = Utils.isValidB64(response.tfd);
		Assert.assertTrue(cfdi_valid && tfd_valid);

	}
	@Test
	public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V3_b64_NOMINA12() throws Exception {
		SWStampService api = new SWStampService(Utils.userSW, Utils.passwordSW, Utils.urlSW);
		SuccessV3Response response = null;
		Utils ut = new Utils();
		response = (SuccessV3Response) api.Stamp(ut.genNomina12(true), "v3", true);
		System.out.println(response.Status);
		System.out.println(response.HttpStatusCode);
		System.out.println(response.cfdi);
		Assert.assertTrue(Utils.isValidB64(response.cfdi));
	}
	@Test
	public void testStampREAL_XML_STRING_USER_PASSWORD_AUTH_V4_b64_NOMINA12() throws Exception {
		SWStampService api = new SWStampService(Utils.userSW, Utils.passwordSW, Utils.urlSW);
		SuccessV4Response response = null;
		Utils ut = new Utils();
		response = (SuccessV4Response) api.Stamp(ut.genNomina12(true), "V4", true);
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
		boolean valid_cfdi = Utils.isValidB64(response.cfdi), valid_qr = Utils.isValidB64(response.qrCode),
				valid_sellocfdi = Utils.isValidB64(response.selloCFDI),
				valid_sellosat = Utils.isValidB64(response.selloSAT);
		Assert.assertTrue(valid_cfdi && valid_qr && valid_sellocfdi && valid_sellosat);
	}
	@Test
	public void testStampREAL_XML_STRING_EMPTY_PARAMS() throws Exception {

		try {
			SWStampService api = new SWStampService("", "", "");
			IResponse response = null;
			Utils ut = new Utils();
			response = api.Stamp(ut.StringgenBasico(false), "v1");
			System.out.println(response.Status);
			System.out.println(response.HttpStatusCode);
		} catch (Exception e) {
			System.out.println("Something bad happened");
			System.out.println(e.getMessage());
			Assert.assertNotNull("Something bad happened", e);
		}
	}
	@Test
	public void testStampREAL_XML_STRING_INCORRECT_PARAMS() throws Exception {
		try {
			SWStampService api = new SWStampService("USER_BAD", "PASSWORD_BAD", "BAD_URI");
			IResponse response = null;
			Utils ut = new Utils();
			response = api.Stamp(ut.StringgenBasico(false), "v1");
			System.out.println(response.Status);
			System.out.println(response.HttpStatusCode);
		} catch (Exception e) {
			System.out.println("Something bad happened");
			System.out.println(e.getMessage());
			Assert.assertNotNull("Something bad happened", e);
		}
	}
	
	@Test
	public void testStampTOKEN_EXPIRES_NOT_USER_NOT_PASSWORD() throws Exception {
		SWStampService api = new SWStampService(Utils.userSW, Utils.passwordSW, Utils.urlSW);

		int request_number = 50;
		int revoke_token_step = request_number / 2;
		int counter;

		for (counter = 0; counter < request_number; counter++) {
			if (counter == revoke_token_step) {
				api.setToken(null);
				api.setUser(null);
				api.setPassword(null);			}
			try {
				Utils ut = new Utils();
				api.Stamp(ut.StringgenBasico(false), "v1");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Something bad happened");
				Assert.assertNotNull("Something bad happened", e);
				break;
			}
		}
	}
}