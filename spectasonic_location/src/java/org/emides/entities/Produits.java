/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emides.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author steph
 */
@Entity
@Table(name = "produits")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produits.findAll", query = "SELECT p FROM Produits p"),
    @NamedQuery(name = "Produits.findByProduitsId", query = "SELECT p FROM Produits p WHERE p.produitsId = :produitsId"),
    @NamedQuery(name = "Produits.findByProduitsNom", query = "SELECT p FROM Produits p WHERE p.produitsNom = :produitsNom"),
    @NamedQuery(name = "Produits.findByProduitsDescription", query = "SELECT p FROM Produits p WHERE p.produitsDescription = :produitsDescription"),
    @NamedQuery(name = "Produits.findByProduitsPrixJournalier", query = "SELECT p FROM Produits p WHERE p.produitsPrixJournalier = :produitsPrixJournalier"),
    @NamedQuery(name = "Produits.findByProduitImage", query = "SELECT p FROM Produits p WHERE p.produitImage = :produitImage")})
public class Produits implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "produits_id")
    private Integer produitsId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "produits_nom")
    private String produitsNom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "produits_description")
    private String produitsDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "produits_prix_journalier")
    private float produitsPrixJournalier;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "produit_image")
    private String produitImage;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produits")
    private Collection<ContenuCommande> contenuCommandeCollection;
    @JoinColumn(name = "produits_id_categorie", referencedColumnName = "categorie_id")
    @ManyToOne(optional = false)
    private Categories produitsIdCategorie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produits")
    private Collection<PlanningProduit> planningProduitCollection;

    public Produits() {
    }

    public Produits(Integer produitsId) {
        this.produitsId = produitsId;
    }

    public Produits(Integer produitsId, String produitsNom, String produitsDescription, float produitsPrixJournalier, String produitImage) {
        this.produitsId = produitsId;
        this.produitsNom = produitsNom;
        this.produitsDescription = produitsDescription;
        this.produitsPrixJournalier = produitsPrixJournalier;
        this.produitImage = produitImage;
    }

    public Integer getProduitsId() {
        return produitsId;
    }

    public void setProduitsId(Integer produitsId) {
        this.produitsId = produitsId;
    }

    public String getProduitsNom() {
        return produitsNom;
    }

    public void setProduitsNom(String produitsNom) {
        this.produitsNom = produitsNom;
    }

    public String getProduitsDescription() {
        return produitsDescription;
    }

    public void setProduitsDescription(String produitsDescription) {
        this.produitsDescription = produitsDescription;
    }

    public float getProduitsPrixJournalier() {
        return produitsPrixJournalier;
    }

    public void setProduitsPrixJournalier(float produitsPrixJournalier) {
        this.produitsPrixJournalier = produitsPrixJournalier;
    }

    public String getProduitImage() {
        return produitImage;
    }

    public void setProduitImage(String produitImage) {
        this.produitImage = produitImage;
    }

    @XmlTransient
    public Collection<ContenuCommande> getContenuCommandeCollection() {
        return contenuCommandeCollection;
    }

    public void setContenuCommandeCollection(Collection<ContenuCommande> contenuCommandeCollection) {
        this.contenuCommandeCollection = contenuCommandeCollection;
    }

    public Categories getProduitsIdCategorie() {
        return produitsIdCategorie;
    }

    public void setProduitsIdCategorie(Categories produitsIdCategorie) {
        this.produitsIdCategorie = produitsIdCategorie;
    }

    @XmlTransient
    public Collection<PlanningProduit> getPlanningProduitCollection() {
        return planningProduitCollection;
    }

    public void setPlanningProduitCollection(Collection<PlanningProduit> planningProduitCollection) {
        this.planningProduitCollection = planningProduitCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (produitsId != null ? produitsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produits)) {
            return false;
        }
        Produits other = (Produits) object;
        if ((this.produitsId == null && other.produitsId != null) || (this.produitsId != null && !this.produitsId.equals(other.produitsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.emides.entities.Produits[ produitsId=" + produitsId + " ]";
    }
    
}
