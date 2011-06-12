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
@Table(name = "APP.QUEUE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Queue.findAll", query = "SELECT q FROM Queue q"),
    @NamedQuery(name = "Queue.findByTicketnumber", query = "SELECT q FROM Queue q WHERE q.ticketnumber = :ticketnumber"),
    @NamedQuery(name = "Queue.findByTicketpriority", query = "SELECT q FROM Queue q WHERE q.ticketpriority = :ticketpriority")})
public class Queue implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "TICKETNUMBER")
    private String ticketnumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TICKETPRIORITY")
    private short ticketpriority;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    @ManyToOne(optional = false)
    private Users userid;

    public Queue() {
    }

    public Queue(String ticketnumber) {
        this.ticketnumber = ticketnumber;
    }

    public Queue(String ticketnumber, short ticketpriority) {
        this.ticketnumber = ticketnumber;
        this.ticketpriority = ticketpriority;
    }

    public String getTicketnumber() {
        return ticketnumber;
    }

    public void setTicketnumber(String ticketnumber) {
        this.ticketnumber = ticketnumber;
    }

    public short getTicketpriority() {
        return ticketpriority;
    }

    public void setTicketpriority(short ticketpriority) {
        this.ticketpriority = ticketpriority;
    }

    public Users getUserid() {
        return userid;
    }

    public void setUserid(Users userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ticketnumber != null ? ticketnumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Queue)) {
            return false;
        }
        Queue other = (Queue) object;
        if ((this.ticketnumber == null && other.ticketnumber != null) || (this.ticketnumber != null && !this.ticketnumber.equals(other.ticketnumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Queue[ ticketnumber=" + ticketnumber + " ]";
    }
    
}
