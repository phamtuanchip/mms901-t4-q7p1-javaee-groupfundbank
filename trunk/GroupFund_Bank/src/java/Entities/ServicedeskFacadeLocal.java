/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author BinhNX
 */
@Local
public interface ServicedeskFacadeLocal {

    void create(Servicedesk servicedesk);

    void edit(Servicedesk servicedesk);

    void remove(Servicedesk servicedesk);

    Servicedesk find(Object id);

    List<Servicedesk> findAll();

    List<Servicedesk> findRange(int[] range);

    int count();
    
}
