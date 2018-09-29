/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rit.cs.client;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author itspr
 */
public class GeoServiceServ extends HttpServlet {

    private ServiceSOAP ServiceSOAP;
    private Gson gson;
    private static final String ADD_SERVICE_SUCCESS_MESSAGE = "New service added";
    private static final String ADD_SERVICE_FAILURE_MESSAGE = "New service could not be added. Please try again later";
    private static final String REMOVE_SERVICE_SUCCESS_MESSAGE = "Service removed";
    private static final String REMOVE_SERVICE_FAILURE_MESSAGE = "Service could not be removed. Please try again later";
    private static final String AVAILABILITY_SUCCESS_MESSAGE = "Success";
    private static final String AVAILABILITY_FAILURE_MESSAGE = "Failed";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printer = resp.getWriter();
        String uri = req.getRequestURI();
        String ret;
        gson = new Gson();
        if (uri.endsWith("verify.ws")) {
            long phoneNo = Long.parseLong(req.getParameter("phone"));
            if (ServiceSOAP.verify(phoneNo)) {
                resp.sendRedirect("/FindMyServiceApp/providerPage.jsp");
            } else {
                resp.sendRedirect("/FindMyServiceApp/registerPage.jsp");
            }
        } else if (uri.endsWith("register.ws")) {
            long phoneNo = Long.parseLong(req.getParameter("phone"));
            String name = req.getParameter("name");
            double latitude = Double.parseDouble(req.getParameter("latitude"));
            double longitude = Double
                    .parseDouble(req.getParameter("longitude"));
            if (ServiceSOAP.registerProvider(phoneNo, name, latitude, longitude)) {
                resp.sendRedirect("/FindMyServiceApp/providerPage.jsp");
            } else {
                resp.sendRedirect("/FindMyServiceApp/providerPage.jsp");
            }

        } else if (uri.endsWith("add.ws")) {
            long phoneNo = Long.parseLong(req.getParameter("phone"));
            String serviceName = req.getParameter("serviceName");
            String description = req.getParameter("description");
            if (ServiceSOAP.addService(phoneNo, serviceName, description)) {
                ret = gson.toJson(ADD_SERVICE_SUCCESS_MESSAGE);
            } else {
                ret = gson.toJson(ADD_SERVICE_FAILURE_MESSAGE);
            }
            printer.println(ret);
        } else if (uri.endsWith("remove.ws")) {
            long phoneNo = Long.parseLong(req.getParameter("phone"));
            String serviceName = req.getParameter("serviceName");
            if (ServiceSOAP.removeService(phoneNo, serviceName)) {
                ret = gson.toJson(REMOVE_SERVICE_SUCCESS_MESSAGE);
            } else {
                ret = gson.toJson(REMOVE_SERVICE_FAILURE_MESSAGE);
            }
            printer.println(ret);
        } else if (uri.endsWith("avail.ws")) {
            long phoneNo = Long.parseLong(req.getParameter("phone"));
            Boolean avail = req.getParameter("availi") != null;
            if (avail) {
                if (ServiceSOAP.goOnline(phoneNo)) {
                    ret = gson.toJson(AVAILABILITY_SUCCESS_MESSAGE);
                } else {
                    ret = gson.toJson(AVAILABILITY_FAILURE_MESSAGE);
                }
            } else {
                if (ServiceSOAP.goOffline(phoneNo)) {
                    ret = gson.toJson(AVAILABILITY_SUCCESS_MESSAGE);
                } else {
                    ret = gson.toJson(AVAILABILITY_FAILURE_MESSAGE);
                }
            }
            printer.println(ret);
        } else if (uri.endsWith("update.ws")) {
            long phoneNo = Long.parseLong(req.getParameter("phone"));
            double latitude = Double.parseDouble(req.getParameter("latitude"));
            double longitude = Double
                    .parseDouble(req.getParameter("longitude"));
            ServiceSOAP.updateLocation(phoneNo, latitude, longitude);
        } else if (uri.endsWith("request.ws")) {
            String serviceName = req.getParameter("serviceName");
            double latitude = Double.parseDouble(req.getParameter("latitude"));
            double longitude = Double
                    .parseDouble(req.getParameter("longitude"));
            double distance = Double.parseDouble(req.getParameter("distance"));
            List<ResultModel> result = ServiceSOAP.requestService(serviceName, latitude, longitude, distance);
            List<ResultModel> result1 = new ArrayList<>();
            ResultModel mod;
            for (int i = 0; i < 3; i++) {
                mod = new ResultModel();
                mod.setPhoneNo(58345l);
                mod.setName("Business name " + i);
                mod.setLatitude(43.144);
                mod.setLongitude(-77.524);
                mod.setDescription("Its a long long time ago " + i);
                mod.setService("Served " + i);
                result1.add(mod);
            }

            ret = gson.toJson(result1);
            printer.println(ret);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
