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
@Table(name = "BRANCH", catalog = "", schema = "APP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Branch.findAll", query = "SELECT b FROM Branch b"),
    @NamedQuery(name = "Branch.findByBranchid", query = "SELECT b FROM Branch b WHERE b.branchid = :branchid"),
    @NamedQuery(name = "Branch.findByBranchname", query = "SELECT b FROM Branch b WHERE b.branchname = :branchname"),
    @NamedQuery(name = "Branch.findByBranchlocation", query = "SELECT b FROM Branch b WHERE b.branchlocation = :branchlocation"),
    @NamedQuery(name = "Branch.findByBranchphone", query = "SELECT b FROM Branch b WHERE b.branchphone = :branchphone")})
public class Branch implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "BRANCHID")
    private Integer branchid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "BRANCHNAME")
    private String branchname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "BRANCHLOCATION")
    private String branchlocation;
    @Size(max = 15)
    @Column(name = "BRANCHPHONE")
    private String branchphone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "branchid")
    private Collection<Servicedesk> servicedeskCollection;

    public Branch() {
    }

    public Branch(Integer branchid) {
        this.branchid = branchid;
    }

    public Branch(Integer branchid, String branchname, String branchlocation) {
        this.branchid = branchid;
        this.branchname = branchname;
        this.branchlocation = branchlocation;
    }

    public Integer getBranchid() {
        return branchid;
    }

    public void setBranchid(Integer branchid) {
        this.branchid = branchid;
    }

    public String getBranchname() {
        return branchname;
    }

    public void setBranchname(String branchname) {
        this.branchname = branchname;
    }

    public String getBranchlocation() {
        return branchlocation;
    }

    public void setBranchlocation(String branchlocation) {
        this.branchlocation = branchlocation;
    }

    public String getBranchphone() {
        return branchphone;
    }

    public void setBranchphone(String branchphone) {
        this.branchphone = branchphone;
    }

    @XmlTransient
    public Collection<Servicedesk> getServicedeskCollection() {
        return servicedeskCollection;
    }

    public void setServicedeskCollection(Collection<Servicedesk> servicedeskCollection) {
        this.servicedeskCollection = servicedeskCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (branchid != null ? branchid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Branch)) {
            return false;
        }
        Branch other = (Branch) object;
        if ((this.branchid == null && other.branchid != null) || (this.branchid != null && !this.branchid.equals(other.branchid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Branch[ branchid=" + branchid + " ]";
    }
    
}
