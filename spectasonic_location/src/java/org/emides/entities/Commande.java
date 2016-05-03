/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emides.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author steph
 */
@Entity
@Table(name = "commande")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commande.findAll", query = "SELECT c FROM Commande c"),
    @NamedQuery(name = "Commande.findByCommandeId", query = "SELECT c FROM Commande c WHERE c.commandeId = :commandeId"),
    @NamedQuery(name = "Commande.findByCommandeDate", query = "SELECT c FROM Commande c WHERE c.commandeDate = :commandeDate")})
public class Commande implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "commande_id")
    private Integer commandeId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "commande_date")
    @Temporal(TemporalType.DATE)
    private Date commandeDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commande")
    private Collection<ContenuCommande> contenuCommandeCollection;
    @JoinColumn(name = "commande_client_id", referencedColumnName = "clients_id")
    @ManyToOne(optional = false)
    private Clients commandeClientId;

    public Commande() {
    }

    public Commande(Integer commandeId) {
        this.commandeId = commandeId;
    }

    public Commande(Integer commandeId, Date commandeDate) {
        this.commandeId = commandeId;
        this.commandeDate = commandeDate;
    }

    public Integer getCommandeId() {
        return commandeId;
    }

    public void setCommandeId(Integer commandeId) {
        this.commandeId = commandeId;
    }

    public Date getCommandeDate() {
        return commandeDate;
    }

    public void setCommandeDate(Date commandeDate) {
        this.commandeDate = commandeDate;
    }

    @XmlTransient
    public Collection<ContenuCommande> getContenuCommandeCollection() {
        return contenuCommandeCollection;
    }

    public void setContenuCommandeCollection(Collection<ContenuCommande> contenuCommandeCollection) {
        this.contenuCommandeCollection = contenuCommandeCollection;
    }

    public Clients getCommandeClientId() {
        return commandeClientId;
    }

    public void setCommandeClientId(Clients commandeClientId) {
        this.commandeClientId = commandeClientId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (commandeId != null ? commandeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.commandeId == null && other.commandeId != null) || (this.commandeId != null && !this.commandeId.equals(other.commandeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.emides.entities.Commande[ commandeId=" + commandeId + " ]";
    }
    
}
