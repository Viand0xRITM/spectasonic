/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emides.entities;

import java.io.Serializable;
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
@Table(name = "contenu_commande")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContenuCommande.findAll", query = "SELECT c FROM ContenuCommande c"),
    @NamedQuery(name = "ContenuCommande.findByContenuCommandeIdCommande", query = "SELECT c FROM ContenuCommande c WHERE c.contenuCommandePK.contenuCommandeIdCommande = :contenuCommandeIdCommande"),
    @NamedQuery(name = "ContenuCommande.findByContenuCommandeNumeroProduit", query = "SELECT c FROM ContenuCommande c WHERE c.contenuCommandePK.contenuCommandeNumeroProduit = :contenuCommandeNumeroProduit"),
    @NamedQuery(name = "ContenuCommande.findByContenuCommandeQuantiteProduit", query = "SELECT c FROM ContenuCommande c WHERE c.contenuCommandeQuantiteProduit = :contenuCommandeQuantiteProduit")})
public class ContenuCommande implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ContenuCommandePK contenuCommandePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "contenu_commande_quantite_produit")
    private int contenuCommandeQuantiteProduit;
    @JoinColumn(name = "contenu_commande_id_commande", referencedColumnName = "commande_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Commande commande;
    @JoinColumn(name = "contenu_commande_numero_produit", referencedColumnName = "produits_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produits produits;

    public ContenuCommande() {
    }

    public ContenuCommande(ContenuCommandePK contenuCommandePK) {
        this.contenuCommandePK = contenuCommandePK;
    }

    public ContenuCommande(ContenuCommandePK contenuCommandePK, int contenuCommandeQuantiteProduit) {
        this.contenuCommandePK = contenuCommandePK;
        this.contenuCommandeQuantiteProduit = contenuCommandeQuantiteProduit;
    }

    public ContenuCommande(int contenuCommandeIdCommande, int contenuCommandeNumeroProduit) {
        this.contenuCommandePK = new ContenuCommandePK(contenuCommandeIdCommande, contenuCommandeNumeroProduit);
    }

    public ContenuCommandePK getContenuCommandePK() {
        return contenuCommandePK;
    }

    public void setContenuCommandePK(ContenuCommandePK contenuCommandePK) {
        this.contenuCommandePK = contenuCommandePK;
    }

    public int getContenuCommandeQuantiteProduit() {
        return contenuCommandeQuantiteProduit;
    }

    public void setContenuCommandeQuantiteProduit(int contenuCommandeQuantiteProduit) {
        this.contenuCommandeQuantiteProduit = contenuCommandeQuantiteProduit;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
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
        hash += (contenuCommandePK != null ? contenuCommandePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContenuCommande)) {
            return false;
        }
        ContenuCommande other = (ContenuCommande) object;
        if ((this.contenuCommandePK == null && other.contenuCommandePK != null) || (this.contenuCommandePK != null && !this.contenuCommandePK.equals(other.contenuCommandePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.emides.entities.ContenuCommande[ contenuCommandePK=" + contenuCommandePK + " ]";
    }
    
}
