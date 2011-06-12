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
public interface QueueFacadeLocal {

    void create(Queue queue);

    void edit(Queue queue);

    void remove(Queue queue);

    Queue find(Object id);

    List<Queue> findAll();

    List<Queue> findRange(int[] range);

    int count();
    
}
