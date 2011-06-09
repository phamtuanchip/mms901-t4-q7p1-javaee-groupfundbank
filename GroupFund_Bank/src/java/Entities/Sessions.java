/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

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
 * @author BinhNX
 */
@Entity
@Table(name = "SESSIONS", catalog = "", schema = "APP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sessions.findAll", query = "SELECT s FROM Sessions s"),
    @NamedQuery(name = "Sessions.findBySessionid", query = "SELECT s FROM Sessions s WHERE s.sessionid = :sessionid")})
public class Sessions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "SESSIONID")
    private String sessionid;

    public Sessions() {
    }

    public Sessions(String sessionid) {
        this.sessionid = sessionid;
    }

    public String getSessionid() {
        return sessionid;
    }

    public void setSessionid(String sessionid) {
        this.sessionid = sessionid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sessionid != null ? sessionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sessions)) {
            return false;
        }
        Sessions other = (Sessions) object;
        if ((this.sessionid == null && other.sessionid != null) || (this.sessionid != null && !this.sessionid.equals(other.sessionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Sessions[ sessionid=" + sessionid + " ]";
    }
    
}
