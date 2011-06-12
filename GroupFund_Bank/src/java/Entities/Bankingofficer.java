/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BinhNX
 */
@Entity
@Table(name = "APP.BANKINGOFFICER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bankingofficer.findAll", query = "SELECT b FROM Bankingofficer b"),
    @NamedQuery(name = "Bankingofficer.findByBankingofficerid", query = "SELECT b FROM Bankingofficer b WHERE b.bankingofficerid = :bankingofficerid"),
    @NamedQuery(name = "Bankingofficer.findByBankingofficerfname", query = "SELECT b FROM Bankingofficer b WHERE b.bankingofficerfname = :bankingofficerfname"),
    @NamedQuery(name = "Bankingofficer.findByBankingofficerlname", query = "SELECT b FROM Bankingofficer b WHERE b.bankingofficerlname = :bankingofficerlname"),
    @NamedQuery(name = "Bankingofficer.findByBankingofficeraddress", query = "SELECT b FROM Bankingofficer b WHERE b.bankingofficeraddress = :bankingofficeraddress"),
    @NamedQuery(name = "Bankingofficer.findByBankingofficerphone", query = "SELECT b FROM Bankingofficer b WHERE b.bankingofficerphone = :bankingofficerphone"),
    @NamedQuery(name = "Bankingofficer.findByBankingofficermail", query = "SELECT b FROM Bankingofficer b WHERE b.bankingofficermail = :bankingofficermail")})
public class Bankingofficer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "BANKINGOFFICERID")
    private Integer bankingofficerid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "BANKINGOFFICERFNAME")
    private String bankingofficerfname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "BANKINGOFFICERLNAME")
    private String bankingofficerlname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "BANKINGOFFICERADDRESS")
    private String bankingofficeraddress;
    @Size(max = 15)
    @Column(name = "BANKINGOFFICERPHONE")
    private String bankingofficerphone;
    @Size(max = 100)
    @Column(name = "BANKINGOFFICERMAIL")
    private String bankingofficermail;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    @ManyToOne
    private Users userid;
    @JoinColumn(name = "SERVICEDESKCODE", referencedColumnName = "SERVICEDESKCODE")
    @ManyToOne
    private Servicedesk servicedeskcode;

    public Bankingofficer() {
    }

    public Bankingofficer(Integer bankingofficerid) {
        this.bankingofficerid = bankingofficerid;
    }

    public Bankingofficer(Integer bankingofficerid, String bankingofficerfname, String bankingofficerlname, String bankingofficeraddress) {
        this.bankingofficerid = bankingofficerid;
        this.bankingofficerfname = bankingofficerfname;
        this.bankingofficerlname = bankingofficerlname;
        this.bankingofficeraddress = bankingofficeraddress;
    }

    public Integer getBankingofficerid() {
        return bankingofficerid;
    }

    public void setBankingofficerid(Integer bankingofficerid) {
        this.bankingofficerid = bankingofficerid;
    }

    public String getBankingofficerfname() {
        return bankingofficerfname;
    }

    public void setBankingofficerfname(String bankingofficerfname) {
        this.bankingofficerfname = bankingofficerfname;
    }

    public String getBankingofficerlname() {
        return bankingofficerlname;
    }

    public void setBankingofficerlname(String bankingofficerlname) {
        this.bankingofficerlname = bankingofficerlname;
    }

    public String getBankingofficeraddress() {
        return bankingofficeraddress;
    }

    public void setBankingofficeraddress(String bankingofficeraddress) {
        this.bankingofficeraddress = bankingofficeraddress;
    }

    public String getBankingofficerphone() {
        return bankingofficerphone;
    }

    public void setBankingofficerphone(String bankingofficerphone) {
        this.bankingofficerphone = bankingofficerphone;
    }

    public String getBankingofficermail() {
        return bankingofficermail;
    }

    public void setBankingofficermail(String bankingofficermail) {
        this.bankingofficermail = bankingofficermail;
    }

    public Users getUserid() {
        return userid;
    }

    public void setUserid(Users userid) {
        this.userid = userid;
    }

    public Servicedesk getServicedeskcode() {
        return servicedeskcode;
    }

    public void setServicedeskcode(Servicedesk servicedeskcode) {
        this.servicedeskcode = servicedeskcode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bankingofficerid != null ? bankingofficerid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bankingofficer)) {
            return false;
        }
        Bankingofficer other = (Bankingofficer) object;
        if ((this.bankingofficerid == null && other.bankingofficerid != null) || (this.bankingofficerid != null && !this.bankingofficerid.equals(other.bankingofficerid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Bankingofficer[ bankingofficerid=" + bankingofficerid + " ]";
    }
    
}
