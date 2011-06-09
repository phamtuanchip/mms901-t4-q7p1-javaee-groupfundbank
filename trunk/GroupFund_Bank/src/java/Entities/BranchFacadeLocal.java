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
public interface BranchFacadeLocal {

    void create(Branch branch);

    void edit(Branch branch);

    void remove(Branch branch);

    Branch find(Object id);

    List<Branch> findAll();

    List<Branch> findRange(int[] range);

    int count();
    
}
