package Tests.AcceptReject;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Ignore;
import Services.AcceptReject.SWAcceptRejectService;
import Tests.Utils;
import Utils.Responses.AcceptReject.AceptarRechazarCancelationResponse;
import Utils.Responses.AcceptReject.CancelationData;

public class SWAcceptRejectServiceTest {
	public String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?><Cancelacion xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" RfcEmisor=\"LAN7008173R5\" Fecha=\"2017-07-06T17:00:31\" xmlns=\"http://cancelacfd.sat.gob.mx\"><Folios><UUID>3eaeabc9-ea41-4627-9609-c6856b78e2b1</UUID></Folios><Signature xmlns=\"http://www.w3.org/2000/09/xmldsig#\"><SignedInfo><CanonicalizationMethod Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\" /><SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\" /><Reference URI=\"\"><Transforms><Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\" /></Transforms><DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\" /><DigestValue>rs2ZcFnS9hbfmyJLmR3Mtnklt7g=</DigestValue></Reference></SignedInfo><SignatureValue>O/I7ILsU2y1fqeb2NBZSQKlQC3DpN/bgcDB5LWCMIYp4mFCLmLxEq/6ADz0xVQWUw49BqWDZ1GAI4ODIZLDQtafHSIE7BXKy8huvKD1dtpRLQ/39IfpxXsz1g6Q14mH3LxDOQugk/GhKMWILXZnIipyQosv3IbgLMZ/V/4btK7xrFX/KiOt0PcefChyaerj9A815dA3J4JgpBUNzbOz9VlhvdZMJskrHxzZ5riU1TAuSw/oi68dJfA7S+6XrTmeFDQzYxACHyOzj24RjLi/31+Fc/wiqQXNu9O6oWl8p5+GVoz2xtU4aRqLxVh73L6WAAef/WDeKDMfIge1BtMrxYw==</SignatureValue><KeyInfo><X509Data><X509IssuerSerial><X509IssuerName>OID.1.2.840.113549.1.9.2=Responsable: ACDMA, OID.2.5.4.45=SAT970701NN3, L=Coyoac?n, S=Distrito Federal, C=MX, PostalCode=06300, STREET=\"Av. Hidalgo 77, Col. Guerrero\", E=asisnet@pruebas.sat.gob.mx, OU=Administraci?n de Seguridad de la Informaci?n, O=Servicio de Administraci?n Tributaria, CN=A.C. 2 de pruebas(4096)</X509IssuerName><X509SerialNumber>3230303031303030303030333030303232383135</X509SerialNumber></X509IssuerSerial><X509Certificate>MIIFxTCCA62gAwIBAgIUMjAwMDEwMDAwMDAzMDAwMjI4MTUwDQYJKoZIhvcNAQELBQAwggFmMSAwHgYDVQQDDBdBLkMuIDIgZGUgcHJ1ZWJhcyg0MDk2KTEvMC0GA1UECgwmU2VydmljaW8gZGUgQWRtaW5pc3RyYWNpw7NuIFRyaWJ1dGFyaWExODA2BgNVBAsML0FkbWluaXN0cmFjacOzbiBkZSBTZWd1cmlkYWQgZGUgbGEgSW5mb3JtYWNpw7NuMSkwJwYJKoZIhvcNAQkBFhphc2lzbmV0QHBydWViYXMuc2F0LmdvYi5teDEmMCQGA1UECQwdQXYuIEhpZGFsZ28gNzcsIENvbC4gR3VlcnJlcm8xDjAMBgNVBBEMBTA2MzAwMQswCQYDVQQGEwJNWDEZMBcGA1UECAwQRGlzdHJpdG8gRmVkZXJhbDESMBAGA1UEBwwJQ295b2Fjw6FuMRUwEwYDVQQtEwxTQVQ5NzA3MDFOTjMxITAfBgkqhkiG9w0BCQIMElJlc3BvbnNhYmxlOiBBQ0RNQTAeFw0xNjEwMjUyMTUyMTFaFw0yMDEwMjUyMTUyMTFaMIGxMRowGAYDVQQDExFDSU5ERU1FWCBTQSBERSBDVjEaMBgGA1UEKRMRQ0lOREVNRVggU0EgREUgQ1YxGjAYBgNVBAoTEUNJTkRFTUVYIFNBIERFIENWMSUwIwYDVQQtExxMQU43MDA4MTczUjUgLyBGVUFCNzcwMTE3QlhBMR4wHAYDVQQFExUgLyBGVUFCNzcwMTE3TURGUk5OMDkxFDASBgNVBAsUC1BydWViYV9DRkRJMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgvvCiCFDFVaYX7xdVRhp/38ULWto/LKDSZy1yrXKpaqFXqERJWF78YHKf3N5GBoXgzwFPuDX+5kvY5wtYNxx/Owu2shNZqFFh6EKsysQMeP5rz6kE1gFYenaPEUP9zj+h0bL3xR5aqoTsqGF24mKBLoiaK44pXBzGzgsxZishVJVM6XbzNJVonEUNbI25DhgWAd86f2aU3BmOH2K1RZx41dtTT56UsszJls4tPFODr/caWuZEuUvLp1M3nj7Dyu88mhD2f+1fA/g7kzcU/1tcpFXF/rIy93APvkU72jwvkrnprzs+SnG81+/F16ahuGsb2EZ88dKHwqxEkwzhMyTbQIDAQABox0wGzAMBgNVHRMBAf8EAjAAMAsGA1UdDwQEAwIGwDANBgkqhkiG9w0BAQsFAAOCAgEAJ/xkL8I+fpilZP+9aO8n93+20XxVomLJjeSL+Ng2ErL2GgatpLuN5JknFBkZAhxVIgMaTS23zzk1RLtRaYvH83lBH5E+M+kEjFGp14Fne1iV2Pm3vL4jeLmzHgY1Kf5HmeVrrp4PU7WQg16VpyHaJ/eonPNiEBUjcyQ1iFfkzJmnSJvDGtfQK2TiEolDJApYv0OWdm4is9Bsfi9j6lI9/T6MNZ+/LM2L/t72Vau4r7m94JDEzaO3A0wHAtQ97fjBfBiO5M8AEISAV7eZidIl3iaJJHkQbBYiiW2gikreUZKPUX0HmlnIqqQcBJhWKRu6Nqk6aZBTETLLpGrvF9OArV1JSsbdw/ZH+P88RAt5em5/gjwwtFlNHyiKG5w+UFpaZOK3gZP0su0sa6dlPeQ9EL4JlFkGqQCgSQ+NOsXqaOavgoP5VLykLwuGnwIUnuhBTVeDbzpgrg9LuF5dYp/zs+Y9ScJqe5VMAagLSYTShNtN8luV7LvxF9pgWwZdcM7lUwqJmUddCiZqdngg3vzTactMToG16gZA4CWnMgbU4E+r541+FNMpgAZNvs2CiW/eApfaaQojsZEAHDsDv4L5n3M1CC7fYjE/d61aSng1LaO6T1mh+dEfPvLzp7zyzz+UgWMhi5Cs4pcXx1eic5r7uxPoBwcCTt3YI1jKVVnV7/w=</X509Certificate></X509Data></KeyInfo></Signature></Cancelacion>";
	@Ignore
	public void testAcceptrejectCancelationService_CSD() throws Exception {
		SWAcceptRejectService app = new SWAcceptRejectService(Utils.userSW, Utils.passwordSW, Utils.urlSW);
		Map<String, String> uuids = new HashMap<String, String>();
		uuids.put("06a46e4b-b154-4c12-bb77-f9a63ed55ff2", "Aceptacion");
		AceptarRechazarCancelationResponse response = null;
		response = (AceptarRechazarCancelationResponse) app.AceptarRechazarCancelacionCSD(uuids, Utils.passwordCsd, Utils.rfc,
				Utils.cerb64, Utils.keyb64);
		System.out.println(response.Status);
		System.out.println(response.HttpStatusCode);
		LinkedList<CancelationData> folios = (LinkedList<CancelationData>) response.folios;
		if (folios != null) {
			for (int i = 0; i < folios.size(); i++) {
				CancelationData datos = folios.get(i);
				System.out.println(datos.uuid);
				System.out.println(datos.estatusUUID);
				System.out.println(datos.respuesta);
			}
		}
		System.out.println(response.message);
		System.out.println(response.messageDetail);
		System.out.println(response.acuse);
		String expect_status = "success";
		Assert.assertTrue(expect_status.equalsIgnoreCase(response.Status));
	}
	@Ignore
	public void testAcceptrejectCancelationService_XML() throws Exception {
		SWAcceptRejectService app = new SWAcceptRejectService(Utils.userSW, Utils.passwordSW, Utils.urlSW);
		String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?> <SolicitudAceptacionRechazo xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" RfcReceptor=\"LAN7008173R5\" RfcPacEnviaSolicitud=\"DAL050601L35\" Fecha=\"2018-08-22T18:38:05\" xmlns=\"http://cancelacfd.sat.gob.mx\"> <Folios> <UUID>06a46e4b-b154-4c12-bb77-f9a63ed55ff2</UUID> <Respuesta>Aceptacion</Respuesta> </Folios> <Signature xmlns=\"http://www.w3.org/2000/09/xmldsig#\"> <SignedInfo> <CanonicalizationMethod Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\" /> <SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\" /> <Reference URI=\"\"> <Transforms> <Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\" /> </Transforms> <DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\" /> <DigestValue>AQ36cbqKJKHy5vaS6GhDTWtwKE4=</DigestValue> </Reference> </SignedInfo> <SignatureValue>HVlFUPmRLyxeztem827eaasDObRXi+oqedCNNvDyMsRizqsS99cHt5mJCEE4vWgpDGPGLrph/yd++R4aN+V562DPp9qreFkisFpEvJy5Z8o/KzG7vc5qqaD8z9ohPpRERPHvxFrIm3ryEBqnSV6zqJG02PuxkWvYonVc+B7RdsO5iAiDTMs9guUhOvHBK8BVXQHKCbUAPCp/4YepZ4LUkcdloCAMPsN0x9GaUty2RMtNJuwaRWy+5IIBUCeXXZmQhoQfS0QfPpCByt0ago5v+FocJQiYQrsUV/8mesmNw5JoOCmufQYliQFyZgsstV8+h76dU/rwLr6R8YlFOkTxKg==</SignatureValue> <KeyInfo> <X509Data> <X509IssuerSerial> <X509IssuerName>OID.1.2.840.113549.1.9.2=Responsable: ACDMA, OID.2.5.4.45=SAT970701NN3, L=Coyoacán, S=Distrito Federal, C=MX, PostalCode=06300, STREET=\"Av. Hidalgo 77, Col. Guerrero\", E=asisnet@pruebas.sat.gob.mx, OU=Administración de Seguridad de la Información, O=Servicio de Administración Tributaria, CN=A.C. 2 de pruebas(4096)</X509IssuerName> <X509SerialNumber>3230303031303030303030333030303232383135</X509SerialNumber> </X509IssuerSerial> <X509Certificate>MIIFxTCCA62gAwIBAgIUMjAwMDEwMDAwMDAzMDAwMjI4MTUwDQYJKoZIhvcNAQELBQAwggFmMSAwHgYDVQQDDBdBLkMuIDIgZGUgcHJ1ZWJhcyg0MDk2KTEvMC0GA1UECgwmU2VydmljaW8gZGUgQWRtaW5pc3RyYWNpw7NuIFRyaWJ1dGFyaWExODA2BgNVBAsML0FkbWluaXN0cmFjacOzbiBkZSBTZWd1cmlkYWQgZGUgbGEgSW5mb3JtYWNpw7NuMSkwJwYJKoZIhvcNAQkBFhphc2lzbmV0QHBydWViYXMuc2F0LmdvYi5teDEmMCQGA1UECQwdQXYuIEhpZGFsZ28gNzcsIENvbC4gR3VlcnJlcm8xDjAMBgNVBBEMBTA2MzAwMQswCQYDVQQGEwJNWDEZMBcGA1UECAwQRGlzdHJpdG8gRmVkZXJhbDESMBAGA1UEBwwJQ295b2Fjw6FuMRUwEwYDVQQtEwxTQVQ5NzA3MDFOTjMxITAfBgkqhkiG9w0BCQIMElJlc3BvbnNhYmxlOiBBQ0RNQTAeFw0xNjEwMjUyMTUyMTFaFw0yMDEwMjUyMTUyMTFaMIGxMRowGAYDVQQDExFDSU5ERU1FWCBTQSBERSBDVjEaMBgGA1UEKRMRQ0lOREVNRVggU0EgREUgQ1YxGjAYBgNVBAoTEUNJTkRFTUVYIFNBIERFIENWMSUwIwYDVQQtExxMQU43MDA4MTczUjUgLyBGVUFCNzcwMTE3QlhBMR4wHAYDVQQFExUgLyBGVUFCNzcwMTE3TURGUk5OMDkxFDASBgNVBAsUC1BydWViYV9DRkRJMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgvvCiCFDFVaYX7xdVRhp/38ULWto/LKDSZy1yrXKpaqFXqERJWF78YHKf3N5GBoXgzwFPuDX+5kvY5wtYNxx/Owu2shNZqFFh6EKsysQMeP5rz6kE1gFYenaPEUP9zj+h0bL3xR5aqoTsqGF24mKBLoiaK44pXBzGzgsxZishVJVM6XbzNJVonEUNbI25DhgWAd86f2aU3BmOH2K1RZx41dtTT56UsszJls4tPFODr/caWuZEuUvLp1M3nj7Dyu88mhD2f+1fA/g7kzcU/1tcpFXF/rIy93APvkU72jwvkrnprzs+SnG81+/F16ahuGsb2EZ88dKHwqxEkwzhMyTbQIDAQABox0wGzAMBgNVHRMBAf8EAjAAMAsGA1UdDwQEAwIGwDANBgkqhkiG9w0BAQsFAAOCAgEAJ/xkL8I+fpilZP+9aO8n93+20XxVomLJjeSL+Ng2ErL2GgatpLuN5JknFBkZAhxVIgMaTS23zzk1RLtRaYvH83lBH5E+M+kEjFGp14Fne1iV2Pm3vL4jeLmzHgY1Kf5HmeVrrp4PU7WQg16VpyHaJ/eonPNiEBUjcyQ1iFfkzJmnSJvDGtfQK2TiEolDJApYv0OWdm4is9Bsfi9j6lI9/T6MNZ+/LM2L/t72Vau4r7m94JDEzaO3A0wHAtQ97fjBfBiO5M8AEISAV7eZidIl3iaJJHkQbBYiiW2gikreUZKPUX0HmlnIqqQcBJhWKRu6Nqk6aZBTETLLpGrvF9OArV1JSsbdw/ZH+P88RAt5em5/gjwwtFlNHyiKG5w+UFpaZOK3gZP0su0sa6dlPeQ9EL4JlFkGqQCgSQ+NOsXqaOavgoP5VLykLwuGnwIUnuhBTVeDbzpgrg9LuF5dYp/zs+Y9ScJqe5VMAagLSYTShNtN8luV7LvxF9pgWwZdcM7lUwqJmUddCiZqdngg3vzTactMToG16gZA4CWnMgbU4E+r541+FNMpgAZNvs2CiW/eApfaaQojsZEAHDsDv4L5n3M1CC7fYjE/d61aSng1LaO6T1mh+dEfPvLzp7zyzz+UgWMhi5Cs4pcXx1eic5r7uxPoBwcCTt3YI1jKVVnV7/w=</X509Certificate> </X509Data> </KeyInfo> </Signature> </SolicitudAceptacionRechazo>";
		AceptarRechazarCancelationResponse response = null;
		response = (AceptarRechazarCancelationResponse) app.AceptarRechazarCancelacionXML(xml);
		System.out.println(response.Status);
		System.out.println(response.HttpStatusCode);
		List<CancelationData> folios = response.folios;
		if (folios != null) {
			for (int i = 0; i < folios.size(); i++) {
				CancelationData datos = folios.get(i);
				System.out.println(datos.uuid);
				System.out.println(datos.estatusUUID);
				System.out.println(datos.respuesta);
			}
		}
		System.out.println(response.message);
		System.out.println(response.messageDetail);
		System.out.println(response.acuse);
		String expect_status = "success";
		Assert.assertTrue(expect_status.equalsIgnoreCase(response.Status));
	}
	@Ignore
	public void testAcceptrejectCancelationService_PFX() throws Exception {
		SWAcceptRejectService app = new SWAcceptRejectService(Utils.userSW, Utils.passwordSW, Utils.urlSW);
		Map<String, String> uuids = new HashMap<String, String>();
        uuids.put("06a46e4b-b154-4c12-bb77-f9a63ed55ff2", "Aceptacion");
		AceptarRechazarCancelationResponse response = null;
		response = (AceptarRechazarCancelationResponse) app.AceptarRechazarCancelacionPFX(uuids, Utils.passwordPfx, Utils.rfc, Utils.pfxb64);
		System.out.println(response.Status);
		System.out.println(response.HttpStatusCode);
		LinkedList<CancelationData> folios = (LinkedList<CancelationData>) response.folios;
		if (folios != null) {
			for (int i = 0; i < folios.size(); i++) {
				CancelationData datos = folios.get(i);
				System.out.println(datos.uuid);
				System.out.println(datos.estatusUUID);
				System.out.println(datos.respuesta);
			}
		}
		System.out.println(response.message);
		System.out.println(response.messageDetail);
		System.out.println(response.acuse);
		String expect_status = "success";
		Assert.assertTrue(expect_status.equalsIgnoreCase(response.Status));
	}
	@Ignore
	public void testAcceptrejectCancelationService_UUID() throws Exception {
		SWAcceptRejectService app = new SWAcceptRejectService(Utils.userSW, Utils.passwordSW, Utils.urlSW);
		String uuidC = "06a46e4b-b154-4c12-bb77-f9a63ed55ff2";
		AceptarRechazarCancelationResponse response = null;
		response = (AceptarRechazarCancelationResponse) app.AceptarRechazarCancelacionUUID(uuidC, Utils.rfc, "Aceptacion");
		System.out.println(response.Status);
		System.out.println(response.HttpStatusCode);
		LinkedList<CancelationData> folios = (LinkedList<CancelationData>) response.folios;
		if (folios != null) {
			for (int i = 0; i < folios.size(); i++) {
				CancelationData datos = folios.get(i);
				System.out.println(datos.uuid);
				System.out.println(datos.estatusUUID);
				System.out.println(datos.respuesta);
			}
		}
		System.out.println(response.message);
		System.out.println(response.messageDetail);
		System.out.println(response.acuse);
		String expect_status = "success";
		Assert.assertTrue(expect_status.equalsIgnoreCase(response.Status));
	}
}
