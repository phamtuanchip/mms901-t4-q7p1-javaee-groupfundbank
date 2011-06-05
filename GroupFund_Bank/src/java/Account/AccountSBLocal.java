/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Account;

import javax.ejb.Local;

/**
 *
 * @author binhnx218
 */
@Local
public interface AccountSBLocal {

    public void resetPassword();

    public void changePassword();
    
}
