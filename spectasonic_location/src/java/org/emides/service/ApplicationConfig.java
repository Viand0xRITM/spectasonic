/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emides.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author steph
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(org.emides.service.CategoriesFacadeREST.class);
        resources.add(org.emides.service.ClientsFacadeREST.class);
        resources.add(org.emides.service.CommandeFacadeREST.class);
        resources.add(org.emides.service.ContenuCommandeFacadeREST.class);
        resources.add(org.emides.service.PlanningProduitFacadeREST.class);
        resources.add(org.emides.service.ProduitsFacadeREST.class);
        resources.add(org.emides.service.corsFilter.class);
    }
    
}
