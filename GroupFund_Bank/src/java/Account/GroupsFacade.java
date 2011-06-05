/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Account;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author binhnx218
 */
@Stateless
public class GroupsFacade extends AbstractFacade<Groups> implements GroupsFacadeLocal {
    @PersistenceContext(unitName = "GroupFund_BankPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public GroupsFacade() {
        super(Groups.class);
    }
    
}
