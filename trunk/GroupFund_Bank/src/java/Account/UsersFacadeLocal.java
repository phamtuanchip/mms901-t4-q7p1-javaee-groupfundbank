/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Account;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author binhnx218
 */
@Local
public interface UsersFacadeLocal {

    void create(Users users);

    void edit(Users users);

    void remove(Users users);

    Users find(Object id);

    List<Users> findAll();

    List<Users> findRange(int[] range);

    int count();

    boolean isValidUser(String username, String password);
    
    boolean isValidUser(Account.Users user);

    Users getUserInfo(java.lang.String username, java.lang.String password);    
}
