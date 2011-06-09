/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author BinhNX
 */
@Local
public interface SessionsFacadeLocal {

    void create(Sessions sessions);

    void edit(Sessions sessions);

    void remove(Sessions sessions);

    Sessions find(Object id);

    List<Sessions> findAll();

    List<Sessions> findRange(int[] range);

    int count();
    
}
