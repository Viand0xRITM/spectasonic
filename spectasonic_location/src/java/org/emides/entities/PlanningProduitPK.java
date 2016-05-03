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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author steph
 */
@Embeddable
public class PlanningProduitPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "planning_produit_id_produit")
    private int planningProduitIdProduit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "planning_produit_date")
    @Temporal(TemporalType.DATE)
    private Date planningProduitDate;

    public PlanningProduitPK() {
    }

    public PlanningProduitPK(int planningProduitIdProduit, Date planningProduitDate) {
        this.planningProduitIdProduit = planningProduitIdProduit;
        this.planningProduitDate = planningProduitDate;
    }

    public int getPlanningProduitIdProduit() {
        return planningProduitIdProduit;
    }

    public void setPlanningProduitIdProduit(int planningProduitIdProduit) {
        this.planningProduitIdProduit = planningProduitIdProduit;
    }

    public Date getPlanningProduitDate() {
        return planningProduitDate;
    }

    public void setPlanningProduitDate(Date planningProduitDate) {
        this.planningProduitDate = planningProduitDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) planningProduitIdProduit;
        hash += (planningProduitDate != null ? planningProduitDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanningProduitPK)) {
            return false;
        }
        PlanningProduitPK other = (PlanningProduitPK) object;
        if (this.planningProduitIdProduit != other.planningProduitIdProduit) {
            return false;
        }
        if ((this.planningProduitDate == null && other.planningProduitDate != null) || (this.planningProduitDate != null && !this.planningProduitDate.equals(other.planningProduitDate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.emides.entities.PlanningProduitPK[ planningProduitIdProduit=" + planningProduitIdProduit + ", planningProduitDate=" + planningProduitDate + " ]";
    }
    
}
