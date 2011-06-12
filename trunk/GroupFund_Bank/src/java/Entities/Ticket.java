/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BinhNX
 */
@Entity
@Table(name = "APP.TICKET")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t"),
    @NamedQuery(name = "Ticket.findByTicketnumber", query = "SELECT t FROM Ticket t WHERE t.ticketnumber = :ticketnumber"),
    @NamedQuery(name = "Ticket.findByTicketdate", query = "SELECT t FROM Ticket t WHERE t.ticketdate = :ticketdate"),
    @NamedQuery(name = "Ticket.findByIsprocessed", query = "SELECT t FROM Ticket t WHERE t.isprocessed = :isprocessed")})
public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "TICKETNUMBER")
    private String ticketnumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TICKETDATE")
    @Temporal(TemporalType.DATE)
    private Date ticketdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISPROCESSED")
    private short isprocessed;
    @JoinColumn(name = "SERVICEDESKCODE", referencedColumnName = "SERVICEDESKCODE")
    @ManyToOne(optional = false)
    private Servicedesk servicedeskcode;

    public Ticket() {
    }

    public Ticket(String ticketnumber) {
        this.ticketnumber = ticketnumber;
    }

    public Ticket(String ticketnumber, Date ticketdate, short isprocessed) {
        this.ticketnumber = ticketnumber;
        this.ticketdate = ticketdate;
        this.isprocessed = isprocessed;
    }

    public String getTicketnumber() {
        return ticketnumber;
    }

    public void setTicketnumber(String ticketnumber) {
        this.ticketnumber = ticketnumber;
    }

    public Date getTicketdate() {
        return ticketdate;
    }

    public void setTicketdate(Date ticketdate) {
        this.ticketdate = ticketdate;
    }

    public short getIsprocessed() {
        return isprocessed;
    }

    public void setIsprocessed(short isprocessed) {
        this.isprocessed = isprocessed;
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
        hash += (ticketnumber != null ? ticketnumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.ticketnumber == null && other.ticketnumber != null) || (this.ticketnumber != null && !this.ticketnumber.equals(other.ticketnumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Ticket[ ticketnumber=" + ticketnumber + " ]";
    }
    
}
