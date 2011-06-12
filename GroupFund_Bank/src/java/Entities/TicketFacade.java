/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author BinhNX
 */
@Stateless
public class TicketFacade extends AbstractFacade<Ticket> implements TicketFacadeLocal {
    @PersistenceContext(unitName = "GroupFund_BankPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public TicketFacade() {
        super(Ticket.class);
    }
    
}
