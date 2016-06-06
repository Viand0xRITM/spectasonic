/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emides.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author steph
 */
@Embeddable
public class ContenuCommandePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "contenu_commande_id_commande")
    private int contenuCommandeIdCommande;
    @Basic(optional = false)
    @NotNull
    @Column(name = "contenu_commande_numero_produit")
    private int contenuCommandeNumeroProduit;

    public ContenuCommandePK() {
    }

    public ContenuCommandePK(int contenuCommandeIdCommande, int contenuCommandeNumeroProduit) {
        this.contenuCommandeIdCommande = contenuCommandeIdCommande;
        this.contenuCommandeNumeroProduit = contenuCommandeNumeroProduit;
    }

    public int getContenuCommandeIdCommande() {
        return contenuCommandeIdCommande;
    }

    public void setContenuCommandeIdCommande(int contenuCommandeIdCommande) {
        this.contenuCommandeIdCommande = contenuCommandeIdCommande;
    }

    public int getContenuCommandeNumeroProduit() {
        return contenuCommandeNumeroProduit;
    }

    public void setContenuCommandeNumeroProduit(int contenuCommandeNumeroProduit) {
        this.contenuCommandeNumeroProduit = contenuCommandeNumeroProduit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) contenuCommandeIdCommande;
        hash += (int) contenuCommandeNumeroProduit;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContenuCommandePK)) {
            return false;
        }
        ContenuCommandePK other = (ContenuCommandePK) object;
        if (this.contenuCommandeIdCommande != other.contenuCommandeIdCommande) {
            return false;
        }
        if (this.contenuCommandeNumeroProduit != other.contenuCommandeNumeroProduit) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.emides.entities.ContenuCommandePK[ contenuCommandeIdCommande=" + contenuCommandeIdCommande + ", contenuCommandeNumeroProduit=" + contenuCommandeNumeroProduit + " ]";
    }
    
}
