package Utils;

/**
 * Created by asalvio on 09/02/2017.
 */
public class Constants {
    public static String BASE_PATH = "http://swservicestest.sw.com.mx";
    public static String AUTH_PATH = "/seguridad/autenticar";
    public static String xmlTest = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<cfdi:Comprobante xmlns:cfdi=\"http://www.sat.gob.mx/cfd/3\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.sat.gob.mx/cfd/3 http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv32.xsd\" version=\"3.2\" serie=\"RENO\" folio=\"127\" LugarExpedicion=\"Zapopan, Jalisco\" Moneda=\"MXN\" fecha=\"2013-12-19T16:56:43\" sello=\"HROetRzCxA6EDdFeNfabiO/wC1Hl5v27KqbjlrcUgHI0ThNe8+3CN84uSrl3O4qrDcxXElI2EN1bFsXJOyFkmkLFNNnGG2zawHMVAM3zvx4X5NO5lvF30BlUO/APN8fJfioAtnAtRwkCPdjkdK0Fwuc1k5cKFcRaI0JzjnVA6BQ=\" formaDePago=\"Pago en una sola exhibición\" noCertificado=\"00001000000202161827\" certificado=\"MIIE/zCCA+egAwIBAgIUMDAwMDEwMDAwMDAyMDIxNjE4MjcwDQYJKoZIhvcNAQEFBQAwggGVMTgwNgYDVQQDDC9BLkMuIGRlbCBTZXJ2aWNpbyBkZSBBZG1pbmlzdHJhY2nDs24gVHJpYnV0YXJpYTEvMC0GA1UECgwmU2VydmljaW8gZGUgQWRtaW5pc3RyYWNpw7NuIFRyaWJ1dGFyaWExODA2BgNVBAsML0FkbWluaXN0cmFjacOzbiBkZSBTZWd1cmlkYWQgZGUgbGEgSW5mb3JtYWNpw7NuMSEwHwYJKoZIhvcNAQkBFhJhc2lzbmV0QHNhdC5nb2IubXgxJjAkBgNVBAkMHUF2LiBIaWRhbGdvIDc3LCBDb2wuIEd1ZXJyZXJvMQ4wDAYDVQQRDAUwNjMwMDELMAkGA1UEBhMCTVgxGTAXBgNVBAgMEERpc3RyaXRvIEZlZGVyYWwxFDASBgNVBAcMC0N1YXVodMOpbW9jMRUwEwYDVQQtEwxTQVQ5NzA3MDFOTjMxPjA8BgkqhkiG9w0BCQIML1Jlc3BvbnNhYmxlOiBDZWNpbGlhIEd1aWxsZXJtaW5hIEdhcmPDrWEgR3VlcnJhMB4XDTEyMTAxNzIzMDIwNFoXDTE2MTAxNzIzMDIwNFowggE/MUkwRwYDVQQDE0BESVNUUklCVUlET1JFUyBBVVRPUklaQURPUyBERSBGQUNUVVJBQ0lPTiBFTEVDVFJPTklDQSBTIERFIFJMIERFMUwwSgYDVQQpE0NESVNUUklCVUlET1JFUyBBVVRPUklaQURPUyBERSBGQUNUVVJBQ0lPTiBFTEVDVFJPTklDQSBTIERFIFJMIERFIENWMUkwRwYDVQQKE0BESVNUUklCVUlET1JFUyBBVVRPUklaQURPUyBERSBGQUNUVVJBQ0lPTiBFTEVDVFJPTklDQSBTIERFIFJMIERFMSUwIwYDVQQtExxEQUYxMDA0MTRMSjQgLyBOQUdMNzgxMDEwRzI1MR4wHAYDVQQFExUgLyBOQUdMNzgxMDEwSEpDVlRTMDMxEjAQBgNVBAsTCXByaW5jaXBhbDCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEAoFHb7gVREu+S71Rph613Ozg4T2BOq6kMud2u0G/qRUqiguaBDrtLKH+681Xk8NnHhz+MbGIw1MK0sYqARl6+2sa2SiRdZzanBFQmm32pCxrFimxMVhEaMpZ7vfFr3wic7O6V9w3r931qH4TBZUeKiAIdRvUawtdCJgmebvAHoPsCAwEAAaMdMBswDAYDVR0TAQH/BAIwADALBgNVHQ8EBAMCBsAwDQYJKoZIhvcNAQEFBQADggEBAKFM4Z6DzuMYfMWPCqMjJqdXJOTA5urYdvcDNCIHmPaWaN/gu79h0e4xP0vJXTXfhR1XCcv1YDJIRJtBcxcNT1tiQoRhIE8etYfXBgPk+F5BBZVsq4nCygD8siIl+lv/38bL4Meq4aPPm4AgVbj+hnQV/YNZMYsJnX2HBuAgX07JSg3RspUo+w5FW8mAMWsNOVaCxYEKLxXw+4DD3nINR5ogjoRDOH5iTlFhk5YhPzRIw1iBQSpjf8yUQqxSSQX3X9xtMHGaF7+yr/i+PSJEaOeyMKRpZ4cql30agnJSuWIjNBcvlnEY7u/O45Vi3JTGKoct/P8gppSWtLuwSFGwJ5g=\" subTotal=\"1\" total=\"1.16\" metodoDePago=\"No Identificado\" tipoDeComprobante=\"ingreso\">\n" +
            "  <cfdi:Emisor rfc=\"DAF100414LJ4\" nombre=\"DISTRIBUIDORES AUTORIZADOS DE FACTURACIÓN ELECTRÓNICA S. DE R.L. DE C. V.\">\n" +
            "    <cfdi:DomicilioFiscal calle=\"AV. WASHINGTON\" noExterior=\"4921-A\" colonia=\"VALLARTA UNIVERSIDAD\" localidad=\"ZAPOPAN\" municipio=\"ZAPOPAN\" estado=\"Jalisco\" pais=\"México\" codigoPostal=\"45110\" />\n" +
            "    <cfdi:RegimenFiscal Regimen=\"Régimen General de Ley Personas Morales\" />\n" +
            "  </cfdi:Emisor>\n" +
            "  <cfdi:Receptor rfc=\"XAXX010101000\" nombre=\"Publico General\">\n" +
            "    <cfdi:Domicilio calle=\"Volcan Krakatoa\" noExterior=\"5683\" colonia=\"Huentitan El Bajo\" municipio=\"Guadalajara\" estado=\"Jalisco\" pais=\"México\" codigoPostal=\"44250\" />\n" +
            "  </cfdi:Receptor>\n" +
            "  <cfdi:Conceptos>\n" +
            "    <cfdi:Concepto cantidad=\"1.000\" unidad=\"No aplica\" noIdentificacion=\"002\" descripcion=\"PAQUETE MINI 100 CFDIs\" valorUnitario=\"1.000000\" importe=\"1.000000\" />\n" +
            "  </cfdi:Conceptos>\n" +
            "  <cfdi:Impuestos totalImpuestosTrasladados=\"0.16\">\n" +
            "    <cfdi:Traslados>\n" +
            "      <cfdi:Traslado impuesto=\"IVA\" tasa=\"16.000000\" importe=\"0.16\" />\n" +
            "    </cfdi:Traslados>\n" +
            "  </cfdi:Impuestos>\n" +
            "  <cfdi:Complemento/>\n" +
            "  <cfdi:Addenda />\n" +
            "</cfdi:Comprobante>";
}
