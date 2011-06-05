/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Account;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author binhnx218
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> implements UsersFacadeLocal {
    @PersistenceContext(unitName = "GroupFund_BankPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }
    
    @Override
    public boolean isValidUser(String username, String password)
    {
        try
        {
            em.createQuery("SELECT u FROM Users u WHERE u.username=:id and u.password=:password").
            setParameter("id", username).
            setParameter("password", password).getSingleResult();
        }
        catch(NoResultException ex)
        {
            return false;
        }
        return true;
    }
    
    @Override
    public boolean isValidUser(Users u)
    {
        try
        {
            if (u.getGroupid() == null)
                em.createQuery("SELECT u FROM Users u WHERE u.userid=:id and u.password=:password ").
                setParameter("id", u.getUserid()).
                setParameter("password", u.getPassword()).
                setMaxResults(0).getResultList().get(0);
            else
                 em.createQuery("SELECT u FROM Users u WHERE u.userid=:id and u.password=:password and u.groupid=:group").
                setParameter("id", u.getUserid()).
                setParameter("password", u.getPassword()).
                setParameter("group", u.getGroupid()).
                setMaxResults(0).getResultList().get(0);
        }
        catch(IndexOutOfBoundsException ex)
        {
            return false;
        }
        return true;
    }
    
    /*
     *     public boolean isValidUser(Users u)
    {
        try
        {
            em.createQuery("SELECT u FROM Users u WHERE u.username=:id and u.password=:password and u.groupid=:groupid").
            setParameter("id", u.getUserid()).
            setParameter("password", u.getPassword()).
            setParameter("groupid", u.getGroupid()).setMaxResults(0).getResultList().get(0);
        }
        catch(IndexOutOfBoundsException ex)
        {
            return false;
        }
        return true;
    }
     */
    @Override
    public Users getUserInfo(String username, String password)
    {
        try
        {
            return (Users)em.createQuery("SELECT u FROM Users u WHERE u.username=:username and u.password=:password").
            setParameter("username", username).
            setParameter("password", password).getResultList().get(0);
        }
        catch(IndexOutOfBoundsException ex)
        {
            return null;
        }
    }
    
}
