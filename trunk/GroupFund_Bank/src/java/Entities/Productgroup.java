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
 * @author BinhNX
 */
@Entity
@Table(name = "APP.PRODUCTGROUP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productgroup.findAll", query = "SELECT p FROM Productgroup p"),
    @NamedQuery(name = "Productgroup.findByProductgroupid", query = "SELECT p FROM Productgroup p WHERE p.productgroupid = :productgroupid"),
    @NamedQuery(name = "Productgroup.findByProductgroupname", query = "SELECT p FROM Productgroup p WHERE p.productgroupname = :productgroupname")})
public class Productgroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRODUCTGROUPID")
    private Integer productgroupid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PRODUCTGROUPNAME")
    private String productgroupname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productgroupid")
    private Collection<Product> productCollection;

    public Productgroup() {
    }

    public Productgroup(Integer productgroupid) {
        this.productgroupid = productgroupid;
    }

    public Productgroup(Integer productgroupid, String productgroupname) {
        this.productgroupid = productgroupid;
        this.productgroupname = productgroupname;
    }

    public Integer getProductgroupid() {
        return productgroupid;
    }

    public void setProductgroupid(Integer productgroupid) {
        this.productgroupid = productgroupid;
    }

    public String getProductgroupname() {
        return productgroupname;
    }

    public void setProductgroupname(String productgroupname) {
        this.productgroupname = productgroupname;
    }

    @XmlTransient
    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productgroupid != null ? productgroupid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productgroup)) {
            return false;
        }
        Productgroup other = (Productgroup) object;
        if ((this.productgroupid == null && other.productgroupid != null) || (this.productgroupid != null && !this.productgroupid.equals(other.productgroupid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Productgroup[ productgroupid=" + productgroupid + " ]";
    }
    
}
