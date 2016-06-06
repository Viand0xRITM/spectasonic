/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emides.services;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.PathSegment;
import org.emides.entities.ContenuCommande;
import org.emides.entities.ContenuCommandePK;

/**
 *
 * @author steph
 */
@Stateless
@Path("contenucommande")
public class ContenuCommandeFacadeREST extends AbstractFacade<ContenuCommande> {
    @PersistenceContext(unitName = "spectasonic_locationPU")
    private EntityManager em;

    private ContenuCommandePK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;contenuCommandeIdCommande=contenuCommandeIdCommandeValue;contenuCommandeNumeroProduit=contenuCommandeNumeroProduitValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        org.emides.entities.ContenuCommandePK key = new org.emides.entities.ContenuCommandePK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> contenuCommandeIdCommande = map.get("contenuCommandeIdCommande");
        if (contenuCommandeIdCommande != null && !contenuCommandeIdCommande.isEmpty()) {
            key.setContenuCommandeIdCommande(new java.lang.Integer(contenuCommandeIdCommande.get(0)));
        }
        java.util.List<String> contenuCommandeNumeroProduit = map.get("contenuCommandeNumeroProduit");
        if (contenuCommandeNumeroProduit != null && !contenuCommandeNumeroProduit.isEmpty()) {
            key.setContenuCommandeNumeroProduit(new java.lang.Integer(contenuCommandeNumeroProduit.get(0)));
        }
        return key;
    }

    public ContenuCommandeFacadeREST() {
        super(ContenuCommande.class);
    }

    @POST
    @Override
    @Consumes({"application/json"})
    public void create(ContenuCommande entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    public void edit(@PathParam("id") PathSegment id, ContenuCommande entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        org.emides.entities.ContenuCommandePK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public ContenuCommande find(@PathParam("id") PathSegment id) {
        org.emides.entities.ContenuCommandePK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({"application/json"})
    public List<ContenuCommande> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<ContenuCommande> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
