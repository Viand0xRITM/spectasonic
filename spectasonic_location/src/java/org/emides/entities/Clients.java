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
@Table(name = "clients")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clients.findAll", query = "SELECT c FROM Clients c"),
    @NamedQuery(name = "Clients.findByClientsId", query = "SELECT c FROM Clients c WHERE c.clientsId = :clientsId"),
    @NamedQuery(name = "Clients.findByClientsNom", query = "SELECT c FROM Clients c WHERE c.clientsNom = :clientsNom"),
    @NamedQuery(name = "Clients.findByClientsPrenom", query = "SELECT c FROM Clients c WHERE c.clientsPrenom = :clientsPrenom"),
    @NamedQuery(name = "Clients.findByClientsAdresse", query = "SELECT c FROM Clients c WHERE c.clientsAdresse = :clientsAdresse")})
public class Clients implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "clients_id")
    private Integer clientsId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "clients_nom")
    private String clientsNom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "clients_prenom")
    private String clientsPrenom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "clients_adresse")
    private String clientsAdresse;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commandeClientId")
    private Collection<Commande> commandeCollection;

    public Clients() {
    }

    public Clients(Integer clientsId) {
        this.clientsId = clientsId;
    }

    public Clients(Integer clientsId, String clientsNom, String clientsPrenom, String clientsAdresse) {
        this.clientsId = clientsId;
        this.clientsNom = clientsNom;
        this.clientsPrenom = clientsPrenom;
        this.clientsAdresse = clientsAdresse;
    }

    public Integer getClientsId() {
        return clientsId;
    }

    public void setClientsId(Integer clientsId) {
        this.clientsId = clientsId;
    }

    public String getClientsNom() {
        return clientsNom;
    }

    public void setClientsNom(String clientsNom) {
        this.clientsNom = clientsNom;
    }

    public String getClientsPrenom() {
        return clientsPrenom;
    }

    public void setClientsPrenom(String clientsPrenom) {
        this.clientsPrenom = clientsPrenom;
    }

    public String getClientsAdresse() {
        return clientsAdresse;
    }

    public void setClientsAdresse(String clientsAdresse) {
        this.clientsAdresse = clientsAdresse;
    }

    @XmlTransient
    public Collection<Commande> getCommandeCollection() {
        return commandeCollection;
    }

    public void setCommandeCollection(Collection<Commande> commandeCollection) {
        this.commandeCollection = commandeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientsId != null ? clientsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clients)) {
            return false;
        }
        Clients other = (Clients) object;
        if ((this.clientsId == null && other.clientsId != null) || (this.clientsId != null && !this.clientsId.equals(other.clientsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.emides.entities.Clients[ clientsId=" + clientsId + " ]";
    }
    
}
