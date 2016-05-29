package org.emides.services;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * REST Web Service
 *
 * @author steph
 */
@Stateless
@Path("SpectaRentSystem")
public class SpectaRentSystem {

    @Context
    private UriInfo context;

    public SpectaRentSystem() {
    }

    @GET
    @Path("getProducts")
    @Produces("application/json")
    public String getProducts() {
        String response = "ERROR during request";
        String uri = "http://localhost:8080/spectasonic_location/webresources/produits";
        
        try{
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));

            String output;
            response = "";
            while ((output = br.readLine()) != null) {
                    response += output;
            }
            
            connection.disconnect();
        } catch (MalformedURLException ex) {
            Logger.getLogger(SpectaRentSystem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SpectaRentSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return response;
    }
    
    @GET
    @Path("getCustomer/{id}")
    @Produces({"application/json"})
    public String getCustomer(@PathParam("id") Integer id) {
        return getCustomerData(id);
    }
    
    private String getCustomerData(int id){
        String response = "ERROR during request" + id;
        String uri = "http://localhost:8080/spectasonic_location/webresources/clients/" + id;
        
        try{
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));

            String output;
            response = "";
            while ((output = br.readLine()) != null) {
                    response += output;
            }
            
            connection.disconnect();
        } catch (MalformedURLException ex) {
            Logger.getLogger(SpectaRentSystem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SpectaRentSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return response;
    }
    
    @GET
    @Path("getProductAvailabilty/{id}")
    @Produces({"application/json"})
    public String getProductAvailability(@PathParam("id") Integer id) {
        String response = "ERROR during request";
        String uri = "http://localhost:8080/spectasonic_location/webresources/planningproduit/" + id;
        
        try{
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));

            String output;
            response = "";
            while ((output = br.readLine()) != null) {
                    response += output;
            }
            
            connection.disconnect();
        } catch (MalformedURLException ex) {
            Logger.getLogger(SpectaRentSystem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SpectaRentSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return response;
    }
    
    @GET
    @Path("getProductAvailabilty")
    @Produces({"application/json"})
    public String getProductAvailability() {
        String response = "ERROR during request";
        String uri = "http://localhost:8080/spectasonic_location/webresources/planningproduit/";
        
        try{
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));

            String output;
            response = "";
            while ((output = br.readLine()) != null) {
                    response += output;
            }
            
            connection.disconnect();
        } catch (MalformedURLException ex) {
            Logger.getLogger(SpectaRentSystem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SpectaRentSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return response;
    }
    
    @GET
    @Path("getOrder/{id}")
    @Produces({"application/json"})
    public String getOrder(@PathParam("id") Integer id) {
        String response = "ERROR during request";
        String uri = "http://localhost:8080/spectasonic_location/webresources/commande/" + id;
        
        try{
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));

            String output;
            response = "";
            while ((output = br.readLine()) != null) {
                    response += output;
            }
            
            connection.disconnect();
        } catch (MalformedURLException ex) {
            Logger.getLogger(SpectaRentSystem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SpectaRentSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return response;
    }
    
    @POST
    @Path("createOrder/{customerID}/{productID}/{productQuantity}")
    @Produces({"application/text"})
    public String createOrder(@PathParam("customerID") Integer customerID, @PathParam("productID") Integer productID, @PathParam("productQuantity") Integer productQuantity) {      
        String customer = getCustomerData(customerID);
        String response = "HTTP status : ";
        int errorCode = 0;
        String request;
        String uri = "http://localhost:8080/spectasonic_location/webresources/commande/";
        
        request = "{\"commandeClientId\":";
        request += customer + ",";
        request += "\"commandeDate\":" + "\"2016-05-30T00:00:00+02:00\",";
        request += "\"commandeId\":" + 10 + "}";
       
        try{
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);
            
            connection.connect();
            
            OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
            wr.write(request);
            wr.flush();
            
            errorCode = connection.getResponseCode();
                      
            connection.disconnect();
        } catch (MalformedURLException ex) {
            Logger.getLogger(SpectaRentSystem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SpectaRentSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return request;
        //return response + errorCode;
    }
    
    private String createOrderContent(int orderID, int productID, int quantity) {
        String response = "HTTP status : ";
        int errorCode = 0;
        String request = "";
        String uri = "http://localhost:8080/spectasonic_location/webresources/commande/";
       
        try{
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);
            
            connection.connect();
            
            OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
            wr.write(request);
            wr.flush();
            
            errorCode = connection.getResponseCode();
                      
            connection.disconnect();
        } catch (MalformedURLException ex) {
            Logger.getLogger(SpectaRentSystem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SpectaRentSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return response;
    }
}
