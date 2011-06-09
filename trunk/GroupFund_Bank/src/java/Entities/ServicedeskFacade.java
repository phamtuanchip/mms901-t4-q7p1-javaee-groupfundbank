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
public class ServicedeskFacade extends AbstractFacade<Servicedesk> implements ServicedeskFacadeLocal {
    @PersistenceContext(unitName = "GroupFund_BankPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public ServicedeskFacade() {
        super(Servicedesk.class);
    }
    
}
