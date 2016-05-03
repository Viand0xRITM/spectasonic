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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "categories")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categories.findAll", query = "SELECT c FROM Categories c"),
    @NamedQuery(name = "Categories.findByCategorieId", query = "SELECT c FROM Categories c WHERE c.categorieId = :categorieId"),
    @NamedQuery(name = "Categories.findByCategorieNom", query = "SELECT c FROM Categories c WHERE c.categorieNom = :categorieNom"),
    @NamedQuery(name = "Categories.findByCategoriesDesc", query = "SELECT c FROM Categories c WHERE c.categoriesDesc = :categoriesDesc")})
public class Categories implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "categorie_id")
    private Integer categorieId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "categorie_nom")
    private String categorieNom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "categories_desc")
    private String categoriesDesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produitsIdCategorie")
    private Collection<Produits> produitsCollection;

    public Categories() {
    }

    public Categories(Integer categorieId) {
        this.categorieId = categorieId;
    }

    public Categories(Integer categorieId, String categorieNom, String categoriesDesc) {
        this.categorieId = categorieId;
        this.categorieNom = categorieNom;
        this.categoriesDesc = categoriesDesc;
    }

    public Integer getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(Integer categorieId) {
        this.categorieId = categorieId;
    }

    public String getCategorieNom() {
        return categorieNom;
    }

    public void setCategorieNom(String categorieNom) {
        this.categorieNom = categorieNom;
    }

    public String getCategoriesDesc() {
        return categoriesDesc;
    }

    public void setCategoriesDesc(String categoriesDesc) {
        this.categoriesDesc = categoriesDesc;
    }

    @XmlTransient
    public Collection<Produits> getProduitsCollection() {
        return produitsCollection;
    }

    public void setProduitsCollection(Collection<Produits> produitsCollection) {
        this.produitsCollection = produitsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categorieId != null ? categorieId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categories)) {
            return false;
        }
        Categories other = (Categories) object;
        if ((this.categorieId == null && other.categorieId != null) || (this.categorieId != null && !this.categorieId.equals(other.categorieId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.emides.entities.Categories[ categorieId=" + categorieId + " ]";
    }
    
}
