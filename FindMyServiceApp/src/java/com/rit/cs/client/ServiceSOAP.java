/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rit.cs.client;

/**
 *
 * @author itspr
 */
public class ServiceSOAP {
    public static void main(String[] args) {
        String np= "5851291217";
        
        System.out.println (verify(Long.parseLong(np)));
        System.out.println ("YESS");
    }
    public static boolean verify(long phoneNo) {
        com.rit.cs.client.GeoService_Service service = new com.rit.cs.client.GeoService_Service();
        com.rit.cs.client.GeoService port = service.getGeoServicePort();
        return port.verify(phoneNo);
    }

    public static boolean addService(long phoneNo, java.lang.String serviceName, java.lang.String description) {
        com.rit.cs.client.GeoService_Service service = new com.rit.cs.client.GeoService_Service();
        com.rit.cs.client.GeoService port = service.getGeoServicePort();
        return port.addService(phoneNo, serviceName, description);
    }

    public static boolean goOffline(long phoneNo) {
        com.rit.cs.client.GeoService_Service service = new com.rit.cs.client.GeoService_Service();
        com.rit.cs.client.GeoService port = service.getGeoServicePort();
        return port.goOffline(phoneNo);
    }

    public static boolean goOnline(long phoneNo) {
        com.rit.cs.client.GeoService_Service service = new com.rit.cs.client.GeoService_Service();
        com.rit.cs.client.GeoService port = service.getGeoServicePort();
        return port.goOnline(phoneNo);
    }

    public static boolean registerProvider(long phoneNo, java.lang.String name, double latitude, double longitude) {
        com.rit.cs.client.GeoService_Service service = new com.rit.cs.client.GeoService_Service();
        com.rit.cs.client.GeoService port = service.getGeoServicePort();
        return port.registerProvider(phoneNo, name, latitude, longitude);
    }

    public static boolean removeService(long phoneNo, java.lang.String serviceName) {
        com.rit.cs.client.GeoService_Service service = new com.rit.cs.client.GeoService_Service();
        com.rit.cs.client.GeoService port = service.getGeoServicePort();
        return port.removeService(phoneNo, serviceName);
    }

    public static java.util.List<com.rit.cs.client.ResultModel> requestService(java.lang.String serviceName, double latitude, double longitude, double distance) {
        com.rit.cs.client.GeoService_Service service = new com.rit.cs.client.GeoService_Service();
        com.rit.cs.client.GeoService port = service.getGeoServicePort();
        return port.requestService(serviceName, latitude, longitude, distance);
    }

    public static void updateLocation(long phoneNo, double latitude, double longitude) {
        com.rit.cs.client.GeoService_Service service = new com.rit.cs.client.GeoService_Service();
        com.rit.cs.client.GeoService port = service.getGeoServicePort();
        port.updateLocation(phoneNo, latitude, longitude);
    }
    
}
