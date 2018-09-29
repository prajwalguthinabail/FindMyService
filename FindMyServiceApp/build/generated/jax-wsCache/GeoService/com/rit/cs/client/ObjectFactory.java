
package com.rit.cs.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.rit.cs.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddService_QNAME = new QName("http://controller.cs.rit.com/", "addService");
    private final static QName _AddServiceResponse_QNAME = new QName("http://controller.cs.rit.com/", "addServiceResponse");
    private final static QName _GoOffline_QNAME = new QName("http://controller.cs.rit.com/", "goOffline");
    private final static QName _GoOfflineResponse_QNAME = new QName("http://controller.cs.rit.com/", "goOfflineResponse");
    private final static QName _GoOnline_QNAME = new QName("http://controller.cs.rit.com/", "goOnline");
    private final static QName _GoOnlineResponse_QNAME = new QName("http://controller.cs.rit.com/", "goOnlineResponse");
    private final static QName _RegisterProvider_QNAME = new QName("http://controller.cs.rit.com/", "registerProvider");
    private final static QName _RegisterProviderResponse_QNAME = new QName("http://controller.cs.rit.com/", "registerProviderResponse");
    private final static QName _RemoveService_QNAME = new QName("http://controller.cs.rit.com/", "removeService");
    private final static QName _RemoveServiceResponse_QNAME = new QName("http://controller.cs.rit.com/", "removeServiceResponse");
    private final static QName _RequestService_QNAME = new QName("http://controller.cs.rit.com/", "requestService");
    private final static QName _RequestServiceResponse_QNAME = new QName("http://controller.cs.rit.com/", "requestServiceResponse");
    private final static QName _UpdateLocation_QNAME = new QName("http://controller.cs.rit.com/", "updateLocation");
    private final static QName _UpdateLocationResponse_QNAME = new QName("http://controller.cs.rit.com/", "updateLocationResponse");
    private final static QName _Verify_QNAME = new QName("http://controller.cs.rit.com/", "verify");
    private final static QName _VerifyResponse_QNAME = new QName("http://controller.cs.rit.com/", "verifyResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.rit.cs.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddService }
     * 
     */
    public AddService createAddService() {
        return new AddService();
    }

    /**
     * Create an instance of {@link AddServiceResponse }
     * 
     */
    public AddServiceResponse createAddServiceResponse() {
        return new AddServiceResponse();
    }

    /**
     * Create an instance of {@link GoOffline }
     * 
     */
    public GoOffline createGoOffline() {
        return new GoOffline();
    }

    /**
     * Create an instance of {@link GoOfflineResponse }
     * 
     */
    public GoOfflineResponse createGoOfflineResponse() {
        return new GoOfflineResponse();
    }

    /**
     * Create an instance of {@link GoOnline }
     * 
     */
    public GoOnline createGoOnline() {
        return new GoOnline();
    }

    /**
     * Create an instance of {@link GoOnlineResponse }
     * 
     */
    public GoOnlineResponse createGoOnlineResponse() {
        return new GoOnlineResponse();
    }

    /**
     * Create an instance of {@link RegisterProvider }
     * 
     */
    public RegisterProvider createRegisterProvider() {
        return new RegisterProvider();
    }

    /**
     * Create an instance of {@link RegisterProviderResponse }
     * 
     */
    public RegisterProviderResponse createRegisterProviderResponse() {
        return new RegisterProviderResponse();
    }

    /**
     * Create an instance of {@link RemoveService }
     * 
     */
    public RemoveService createRemoveService() {
        return new RemoveService();
    }

    /**
     * Create an instance of {@link RemoveServiceResponse }
     * 
     */
    public RemoveServiceResponse createRemoveServiceResponse() {
        return new RemoveServiceResponse();
    }

    /**
     * Create an instance of {@link RequestService }
     * 
     */
    public RequestService createRequestService() {
        return new RequestService();
    }

    /**
     * Create an instance of {@link RequestServiceResponse }
     * 
     */
    public RequestServiceResponse createRequestServiceResponse() {
        return new RequestServiceResponse();
    }

    /**
     * Create an instance of {@link UpdateLocation }
     * 
     */
    public UpdateLocation createUpdateLocation() {
        return new UpdateLocation();
    }

    /**
     * Create an instance of {@link UpdateLocationResponse }
     * 
     */
    public UpdateLocationResponse createUpdateLocationResponse() {
        return new UpdateLocationResponse();
    }

    /**
     * Create an instance of {@link Verify }
     * 
     */
    public Verify createVerify() {
        return new Verify();
    }

    /**
     * Create an instance of {@link VerifyResponse }
     * 
     */
    public VerifyResponse createVerifyResponse() {
        return new VerifyResponse();
    }

    /**
     * Create an instance of {@link ResultModel }
     * 
     */
    public ResultModel createResultModel() {
        return new ResultModel();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddService }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller.cs.rit.com/", name = "addService")
    public JAXBElement<AddService> createAddService(AddService value) {
        return new JAXBElement<AddService>(_AddService_QNAME, AddService.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddServiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller.cs.rit.com/", name = "addServiceResponse")
    public JAXBElement<AddServiceResponse> createAddServiceResponse(AddServiceResponse value) {
        return new JAXBElement<AddServiceResponse>(_AddServiceResponse_QNAME, AddServiceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GoOffline }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller.cs.rit.com/", name = "goOffline")
    public JAXBElement<GoOffline> createGoOffline(GoOffline value) {
        return new JAXBElement<GoOffline>(_GoOffline_QNAME, GoOffline.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GoOfflineResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller.cs.rit.com/", name = "goOfflineResponse")
    public JAXBElement<GoOfflineResponse> createGoOfflineResponse(GoOfflineResponse value) {
        return new JAXBElement<GoOfflineResponse>(_GoOfflineResponse_QNAME, GoOfflineResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GoOnline }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller.cs.rit.com/", name = "goOnline")
    public JAXBElement<GoOnline> createGoOnline(GoOnline value) {
        return new JAXBElement<GoOnline>(_GoOnline_QNAME, GoOnline.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GoOnlineResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller.cs.rit.com/", name = "goOnlineResponse")
    public JAXBElement<GoOnlineResponse> createGoOnlineResponse(GoOnlineResponse value) {
        return new JAXBElement<GoOnlineResponse>(_GoOnlineResponse_QNAME, GoOnlineResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterProvider }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller.cs.rit.com/", name = "registerProvider")
    public JAXBElement<RegisterProvider> createRegisterProvider(RegisterProvider value) {
        return new JAXBElement<RegisterProvider>(_RegisterProvider_QNAME, RegisterProvider.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterProviderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller.cs.rit.com/", name = "registerProviderResponse")
    public JAXBElement<RegisterProviderResponse> createRegisterProviderResponse(RegisterProviderResponse value) {
        return new JAXBElement<RegisterProviderResponse>(_RegisterProviderResponse_QNAME, RegisterProviderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveService }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller.cs.rit.com/", name = "removeService")
    public JAXBElement<RemoveService> createRemoveService(RemoveService value) {
        return new JAXBElement<RemoveService>(_RemoveService_QNAME, RemoveService.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveServiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller.cs.rit.com/", name = "removeServiceResponse")
    public JAXBElement<RemoveServiceResponse> createRemoveServiceResponse(RemoveServiceResponse value) {
        return new JAXBElement<RemoveServiceResponse>(_RemoveServiceResponse_QNAME, RemoveServiceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestService }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller.cs.rit.com/", name = "requestService")
    public JAXBElement<RequestService> createRequestService(RequestService value) {
        return new JAXBElement<RequestService>(_RequestService_QNAME, RequestService.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestServiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller.cs.rit.com/", name = "requestServiceResponse")
    public JAXBElement<RequestServiceResponse> createRequestServiceResponse(RequestServiceResponse value) {
        return new JAXBElement<RequestServiceResponse>(_RequestServiceResponse_QNAME, RequestServiceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateLocation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller.cs.rit.com/", name = "updateLocation")
    public JAXBElement<UpdateLocation> createUpdateLocation(UpdateLocation value) {
        return new JAXBElement<UpdateLocation>(_UpdateLocation_QNAME, UpdateLocation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateLocationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller.cs.rit.com/", name = "updateLocationResponse")
    public JAXBElement<UpdateLocationResponse> createUpdateLocationResponse(UpdateLocationResponse value) {
        return new JAXBElement<UpdateLocationResponse>(_UpdateLocationResponse_QNAME, UpdateLocationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Verify }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller.cs.rit.com/", name = "verify")
    public JAXBElement<Verify> createVerify(Verify value) {
        return new JAXBElement<Verify>(_Verify_QNAME, Verify.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller.cs.rit.com/", name = "verifyResponse")
    public JAXBElement<VerifyResponse> createVerifyResponse(VerifyResponse value) {
        return new JAXBElement<VerifyResponse>(_VerifyResponse_QNAME, VerifyResponse.class, null, value);
    }

}
