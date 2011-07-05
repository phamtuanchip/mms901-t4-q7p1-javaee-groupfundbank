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
public interface ProductgroupFacadeLocal {

    void create(Productgroup productgroup);

    void edit(Productgroup productgroup);

    void remove(Productgroup productgroup);

    Productgroup find(Object id);

    List<Productgroup> findAll();

    List<Productgroup> findRange(int[] range);

    int count();
    
}
