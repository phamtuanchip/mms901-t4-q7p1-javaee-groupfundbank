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
public class BankingofficerFacade extends AbstractFacade<Bankingofficer> implements BankingofficerFacadeLocal {
    @PersistenceContext(unitName = "GroupFund_BankPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BankingofficerFacade() {
        super(Bankingofficer.class);
    }
    
}
