/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

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
 * @author BinhNX
 */
@Entity
@Table(name = "APP.SERVICEDESK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicedesk.findAll", query = "SELECT s FROM Servicedesk s"),
    @NamedQuery(name = "Servicedesk.findByServicedeskcode", query = "SELECT s FROM Servicedesk s WHERE s.servicedeskcode = :servicedeskcode"),
    @NamedQuery(name = "Servicedesk.findByIsactive", query = "SELECT s FROM Servicedesk s WHERE s.isactive = :isactive")})
public class Servicedesk implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "SERVICEDESKCODE")
    private String servicedeskcode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISACTIVE")
    private short isactive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicedeskcode")
    private Collection<Ticket> ticketCollection;
    @JoinColumn(name = "PRODUCTID", referencedColumnName = "PRODUCTID")
    @ManyToOne(optional = false)
    private Product productid;
    @JoinColumn(name = "BRANCHID", referencedColumnName = "BRANCHID")
    @ManyToOne(optional = false)
    private Branch branchid;
    @OneToMany(mappedBy = "servicedeskcode")
    private Collection<Bankingofficer> bankingofficerCollection;

    public Servicedesk() {
    }

    public Servicedesk(String servicedeskcode) {
        this.servicedeskcode = servicedeskcode;
    }

    public Servicedesk(String servicedeskcode, short isactive) {
        this.servicedeskcode = servicedeskcode;
        this.isactive = isactive;
    }

    public String getServicedeskcode() {
        return servicedeskcode;
    }

    public void setServicedeskcode(String servicedeskcode) {
        this.servicedeskcode = servicedeskcode;
    }

    public short getIsactive() {
        return isactive;
    }

    public void setIsactive(short isactive) {
        this.isactive = isactive;
    }

    @XmlTransient
    public Collection<Ticket> getTicketCollection() {
        return ticketCollection;
    }

    public void setTicketCollection(Collection<Ticket> ticketCollection) {
        this.ticketCollection = ticketCollection;
    }

    public Product getProductid() {
        return productid;
    }

    public void setProductid(Product productid) {
        this.productid = productid;
    }

    public Branch getBranchid() {
        return branchid;
    }

    public void setBranchid(Branch branchid) {
        this.branchid = branchid;
    }

    @XmlTransient
    public Collection<Bankingofficer> getBankingofficerCollection() {
        return bankingofficerCollection;
    }

    public void setBankingofficerCollection(Collection<Bankingofficer> bankingofficerCollection) {
        this.bankingofficerCollection = bankingofficerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (servicedeskcode != null ? servicedeskcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicedesk)) {
            return false;
        }
        Servicedesk other = (Servicedesk) object;
        if ((this.servicedeskcode == null && other.servicedeskcode != null) || (this.servicedeskcode != null && !this.servicedeskcode.equals(other.servicedeskcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Servicedesk[ servicedeskcode=" + servicedeskcode + " ]";
    }
    
}
