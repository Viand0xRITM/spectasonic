/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emides.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author steph
 */
@Entity
@Table(name = "planning_produit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanningProduit.findAll", query = "SELECT p FROM PlanningProduit p"),
    @NamedQuery(name = "PlanningProduit.findByPlanningProduitIdProduit", query = "SELECT p FROM PlanningProduit p WHERE p.planningProduitPK.planningProduitIdProduit = :planningProduitIdProduit"),
    @NamedQuery(name = "PlanningProduit.findByPlanningProduitDate", query = "SELECT p FROM PlanningProduit p WHERE p.planningProduitPK.planningProduitDate = :planningProduitDate"),
    @NamedQuery(name = "PlanningProduit.findByPlanningProduitDisponibilite", query = "SELECT p FROM PlanningProduit p WHERE p.planningProduitDisponibilite = :planningProduitDisponibilite")})
public class PlanningProduit implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PlanningProduitPK planningProduitPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "planning_produit_disponibilite")
    private boolean planningProduitDisponibilite;
    @JoinColumn(name = "planning_produit_id_produit", referencedColumnName = "produits_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produits produits;

    public PlanningProduit() {
    }

    public PlanningProduit(PlanningProduitPK planningProduitPK) {
        this.planningProduitPK = planningProduitPK;
    }

    public PlanningProduit(PlanningProduitPK planningProduitPK, boolean planningProduitDisponibilite) {
        this.planningProduitPK = planningProduitPK;
        this.planningProduitDisponibilite = planningProduitDisponibilite;
    }

    public PlanningProduit(int planningProduitIdProduit, Date planningProduitDate) {
        this.planningProduitPK = new PlanningProduitPK(planningProduitIdProduit, planningProduitDate);
    }

    public PlanningProduitPK getPlanningProduitPK() {
        return planningProduitPK;
    }

    public void setPlanningProduitPK(PlanningProduitPK planningProduitPK) {
        this.planningProduitPK = planningProduitPK;
    }

    public boolean getPlanningProduitDisponibilite() {
        return planningProduitDisponibilite;
    }

    public void setPlanningProduitDisponibilite(boolean planningProduitDisponibilite) {
        this.planningProduitDisponibilite = planningProduitDisponibilite;
    }

    public Produits getProduits() {
        return produits;
    }

    public void setProduits(Produits produits) {
        this.produits = produits;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (planningProduitPK != null ? planningProduitPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanningProduit)) {
            return false;
        }
        PlanningProduit other = (PlanningProduit) object;
        if ((this.planningProduitPK == null && other.planningProduitPK != null) || (this.planningProduitPK != null && !this.planningProduitPK.equals(other.planningProduitPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.emides.entities.PlanningProduit[ planningProduitPK=" + planningProduitPK + " ]";
    }
    
}
