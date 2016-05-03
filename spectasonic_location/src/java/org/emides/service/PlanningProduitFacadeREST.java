/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emides.service;

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
import org.emides.entities.PlanningProduit;
import org.emides.entities.PlanningProduitPK;

/**
 *
 * @author steph
 */
@Stateless
@Path("planningproduit")
public class PlanningProduitFacadeREST extends AbstractFacade<PlanningProduit> {
    @PersistenceContext(unitName = "spectasonic_locationPU")
    private EntityManager em;

    private PlanningProduitPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;planningProduitIdProduit=planningProduitIdProduitValue;planningProduitDate=planningProduitDateValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        org.emides.entities.PlanningProduitPK key = new org.emides.entities.PlanningProduitPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> planningProduitIdProduit = map.get("planningProduitIdProduit");
        if (planningProduitIdProduit != null && !planningProduitIdProduit.isEmpty()) {
            key.setPlanningProduitIdProduit(new java.lang.Integer(planningProduitIdProduit.get(0)));
        }
        java.util.List<String> planningProduitDate = map.get("planningProduitDate");
        if (planningProduitDate != null && !planningProduitDate.isEmpty()) {
            key.setPlanningProduitDate(new java.util.Date(planningProduitDate.get(0)));
        }
        return key;
    }

    public PlanningProduitFacadeREST() {
        super(PlanningProduit.class);
    }

    @POST
    @Override
    @Consumes({"application/json"})
    public void create(PlanningProduit entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    public void edit(@PathParam("id") PathSegment id, PlanningProduit entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        org.emides.entities.PlanningProduitPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public PlanningProduit find(@PathParam("id") PathSegment id) {
        org.emides.entities.PlanningProduitPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({"application/json"})
    public List<PlanningProduit> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<PlanningProduit> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
