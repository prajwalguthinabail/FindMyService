
package com.rit.cs.client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "GeoService", targetNamespace = "http://controller.cs.rit.com/", wsdlLocation = "http://localhost:8080/FindMyService/GeoService?WSDL")
public class GeoService_Service
    extends Service
{

    private final static URL GEOSERVICE_WSDL_LOCATION;
    private final static WebServiceException GEOSERVICE_EXCEPTION;
    private final static QName GEOSERVICE_QNAME = new QName("http://controller.cs.rit.com/", "GeoService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/FindMyService/GeoService?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        GEOSERVICE_WSDL_LOCATION = url;
        GEOSERVICE_EXCEPTION = e;
    }

    public GeoService_Service() {
        super(__getWsdlLocation(), GEOSERVICE_QNAME);
    }

    public GeoService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), GEOSERVICE_QNAME, features);
    }

    public GeoService_Service(URL wsdlLocation) {
        super(wsdlLocation, GEOSERVICE_QNAME);
    }

    public GeoService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, GEOSERVICE_QNAME, features);
    }

    public GeoService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public GeoService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns GeoService
     */
    @WebEndpoint(name = "GeoServicePort")
    public GeoService getGeoServicePort() {
        return super.getPort(new QName("http://controller.cs.rit.com/", "GeoServicePort"), GeoService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns GeoService
     */
    @WebEndpoint(name = "GeoServicePort")
    public GeoService getGeoServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://controller.cs.rit.com/", "GeoServicePort"), GeoService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (GEOSERVICE_EXCEPTION!= null) {
            throw GEOSERVICE_EXCEPTION;
        }
        return GEOSERVICE_WSDL_LOCATION;
    }

}
