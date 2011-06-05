/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Account;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author binhnx218
 */
@Entity
@Table(name = "APP.GROUPS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Groups.findAll", query = "SELECT g FROM Groups g")})
public class Groups implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "GROUPID")
    private Short groupid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "GROUPNAME")
    private String groupname;
    @Size(max = 100)
    @Column(name = "GROUPDESCRIPTION")
    private String groupdescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupid")
    private Collection<Users> usersCollection;

    public Groups() {
    }

    public Groups(Short groupid) {
        this.groupid = groupid;
    }

    public Groups(Short groupid, String groupname) {
        this.groupid = groupid;
        this.groupname = groupname;
    }

    public Short getGroupid() {
        return groupid;
    }

    public void setGroupid(Short groupid) {
        this.groupid = groupid;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getGroupdescription() {
        return groupdescription;
    }

    public void setGroupdescription(String groupdescription) {
        this.groupdescription = groupdescription;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupid != null ? groupid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groups)) {
            return false;
        }
        Groups other = (Groups) object;
        if ((this.groupid == null && other.groupid != null) || (this.groupid != null && !this.groupid.equals(other.groupid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Account.Groups[ groupid=" + groupid + " ]";
    }
    
}
