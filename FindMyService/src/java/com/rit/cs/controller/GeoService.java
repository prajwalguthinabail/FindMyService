package com.rit.cs.controller;

import com.rit.cs.model.ProviderModel;
import com.rit.cs.model.RequestModel;
import com.rit.cs.model.ResultModel;
import com.rit.cs.model.ServiceModel;
import com.rit.cs.model.UpdaterModel;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 * GeoService.java
 * 
 * @author Lijitha Govindankutty
 * @author Sahana Murthy
 * @author Prajwal Guthinabail Mar 20, 2018
 */
@WebService(serviceName = "GeoService")
public class GeoService {

    @WebMethod(operationName = "verify")
    public boolean verify(@WebParam(name = "phoneNo") long phoneNo) {
        UpdaterModel updaterModel = new UpdaterModel(phoneNo);
        return updaterModel.verifyProvider();

    }

    @WebMethod(operationName = "registerProvider")
    public boolean registerProvider(@WebParam(name = "phoneNo") long phoneNo, @WebParam(name = "name") String name, @WebParam(name = "latitude") double latitude,
            @WebParam(name = "longitude") double longitude) {

        ProviderModel providerModel = new ProviderModel(phoneNo, name, latitude,
                longitude);
        return providerModel.addUser();

    }

    @WebMethod(operationName = "addService")
    public boolean addService(@WebParam(name = "phoneNo") long phoneNo, @WebParam(name = "service") String service,
            @WebParam(name = "description") String description) {
        ServiceModel serviceModel = new ServiceModel(phoneNo, service,
                description);
        return serviceModel.add();

    }

    @WebMethod(operationName = "removeService")
    public boolean removeService(@WebParam(name = "phoneNo") long phoneNo, @WebParam(name = "service") String service) {
        ServiceModel serviceModel = new ServiceModel(phoneNo, service);
        return serviceModel.remove();

    }

    @WebMethod(operationName = "goOnline")
    public boolean goOnline(@WebParam(name = "phoneNo") long phoneNo) {
        UpdaterModel updaterModel = new UpdaterModel(phoneNo, true);
        return updaterModel.updateAvailability();

    }

    @WebMethod(operationName = "goOffline")
    public boolean goOffline(@WebParam(name = "phoneNo") long phoneNo) {
        UpdaterModel updaterModel = new UpdaterModel(phoneNo, false);
        return updaterModel.updateAvailability();

    }

    @WebMethod(operationName = "updateLocation")
    public void updateLocation(@WebParam(name = "phoneNo") long phoneNo, @WebParam(name = "latitude") double latitude,
            @WebParam(name = "longitude") double longitude) {
        UpdaterModel updaterModel = new UpdaterModel(phoneNo, latitude,
                longitude);
        updaterModel.updateLocation();

    }

    @WebMethod(operationName = "requestService")
    public List<ResultModel> requestService(@WebParam(name = "service") String service, @WebParam(name = "latitude") double latitude,
            @WebParam(name = "longitude") double longitude, @WebParam(name = "distance") double distance) {
        RequestModel requestModel = new RequestModel(service, latitude,
                longitude, distance);
        return requestModel.queryDB();

    }
}
