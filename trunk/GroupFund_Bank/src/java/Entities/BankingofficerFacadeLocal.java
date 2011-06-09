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
public interface BankingofficerFacadeLocal {

    void create(Bankingofficer bankingofficer);

    void edit(Bankingofficer bankingofficer);

    void remove(Bankingofficer bankingofficer);

    Bankingofficer find(Object id);

    List<Bankingofficer> findAll();

    List<Bankingofficer> findRange(int[] range);

    int count();
    
}
