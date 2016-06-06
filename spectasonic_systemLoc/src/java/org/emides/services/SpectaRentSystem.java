package org.emides.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import org.json.JSONException;

import org.json.JSONObject;
import org.json.JSONArray;


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
    @Path("getCategories")
    @Produces("application/json")
    public String getCategories() {
        String response = "ERROR during request";
        String uri = "http://localhost:8080/spectasonic_location/webresources/categories";
        
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
    @Path("getProducts/{id}")
    @Produces("application/json")
    public String getProduct(@PathParam("id") Integer id) {
        String response = "ERROR during request";
        String uri = "http://localhost:8080/spectasonic_location/webresources/produits/" + id;
        
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
    @Path("getProductAvailability/{id}")
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
    @Path("getProductAvailability")
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
    
    @GET
    @Path("getProductByCategory/{id}")
    @Produces({"application/json"})
    public String getProductByCategory(@PathParam("id") Integer id) {
        String response = "ERROR during request";
        String uri = "http://localhost:8080/spectasonic_location/webresources/produits";
        String productByCategory = "";
        
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
        
        try { 
            JSONArray productList = new JSONArray(response); 
            
            for(int i = 0; i < productList.length(); i++){
                int categoryID;
                JSONObject product = (JSONObject) productList.get(i);
                JSONObject categoryInformation = (JSONObject) product.get("produitsIdCategorie");
                categoryID = (Integer) categoryInformation.get("categorieId");
                if(categoryID == id){
                    productByCategory += product.toString();
                }
            }
        } catch (JSONException ex) {
            Logger.getLogger(SpectaRentSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return productByCategory;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({"application/text"})
    @Path("createOrder")
    public String createOrder(String x) {  
        int orderID = 0;
              
        String response = "NO ERROR";
        
        String uri = "http://localhost:8080/spectasonic_location/webresources/commande/count";
        
        //get order count to know next order id
         try{
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "text/plain");

            BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));

            String output;
            response = "";
            while ((output = br.readLine()) != null) {
                    response += output;
            }
            orderID = Integer.parseInt(response) + 1;
            
            connection.disconnect();
        } catch (MalformedURLException ex) {
            Logger.getLogger(SpectaRentSystem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SpectaRentSystem.class.getName()).log(Level.SEVERE, null, ex);
        }     
         
        try {
            JSONObject inputJSON = new JSONObject(x);
            int customerID = (Integer) inputJSON.get("customerID");
            String date = inputJSON.getString("date");
            
            String customer = getCustomerData(customerID);
            
            response = createOder(orderID, customer, date);         
    
            JSONArray productList = (JSONArray) inputJSON.get("contenuCommande");       
            for(int i = 0; i < productList.length(); i++){
                int productID;
                int quantity;
                
                JSONObject product = (JSONObject) productList.get(i);
                quantity = (Integer) product.get("quantiteProduit");
                productID = (Integer) product.get("idProduit");
                
                response += createOrderContent(customer, date, orderID, productID, quantity);
            }
        } catch (JSONException ex) {
            Logger.getLogger(SpectaRentSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return response;
    }
    
    private String createOder(int orderID, String customer, String date)
    {
        int errorCode = 0;
                
        String uri = "http://localhost:8080/spectasonic_location/webresources/commande/";
        String response = "\nRequest CREATE ORDER\nHTTP status : ";
        
        String request;        
        request = "{\"commandeClientId\":";
        request += customer + ",";
        request += "\"commandeDate\":" + "\"" + date + "\",";
        request += "\"commandeId\":" + orderID + "}";
        
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
        
        return response + errorCode;
    }
    
    private String createOrderContent(String customer, String date, int orderID, int productID, int quantity) {
        String response = "\nRequest CREATE ORDER CONTENT\n";
        String uri = "http://localhost:8080/spectasonic_location/webresources/contenucommande";
        int errorCode = 0;
        
        String produit = getProduct(productID);
        
        String request;
        request = "{\"commande\":{";
        request += "\"commandeClientId\":";
        request += customer + ",";
        request += "\"commandeDate\":" + "\"" + date + "\",";
        request += "\"commandeId\":" + orderID + "},";
        request += "\"contenuCommandePK\":{";
        request += "\"contenuCommandeIdCommande\":" + orderID + ",";
        request += "\"contenuCommandeNumeroProduit\":" + productID + "},";
        request += "\"contenuCommandeQuantiteProduit\":" + quantity + ",";
        request += "\"produits\":" + produit + "}";
        
        response += "CONTENU REQUETE : " + request;
        
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
        
        response += "\nHTTP CODE : " + errorCode;
        
        return response;
    }
}
