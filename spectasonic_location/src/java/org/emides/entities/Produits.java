/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emides.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author steph
 */
@Entity
@Table(name = "produits")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produits.findAll", query = "SELECT p FROM Produits p"),
    @NamedQuery(name = "Produits.findById", query = "SELECT p FROM Produits p WHERE p.id = :id"),
    @NamedQuery(name = "Produits.findByLibelle", query = "SELECT p FROM Produits p WHERE p.libelle = :libelle"),
    @NamedQuery(name = "Produits.findByDescription", query = "SELECT p FROM Produits p WHERE p.description = :description"),
    @NamedQuery(name = "Produits.findByPrixJournalier", query = "SELECT p FROM Produits p WHERE p.prixJournalier = :prixJournalier")})
public class Produits implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "libelle")
    private String libelle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prix_journalier")
    private float prixJournalier;

    public Produits() {
    }

    public Produits(Integer id) {
        this.id = id;
    }

    public Produits(Integer id, String libelle, String description, float prixJournalier) {
        this.id = id;
        this.libelle = libelle;
        this.description = description;
        this.prixJournalier = prixJournalier;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrixJournalier() {
        return prixJournalier;
    }

    public void setPrixJournalier(float prixJournalier) {
        this.prixJournalier = prixJournalier;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produits)) {
            return false;
        }
        Produits other = (Produits) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.emides.entities.Produits[ id=" + id + " ]";
    }
    
}
