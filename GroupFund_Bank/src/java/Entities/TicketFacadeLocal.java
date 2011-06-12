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
public interface TicketFacadeLocal {

    void create(Ticket ticket);

    void edit(Ticket ticket);

    void remove(Ticket ticket);

    Ticket find(Object id);

    List<Ticket> findAll();

    List<Ticket> findRange(int[] range);

    int count();
    
}
