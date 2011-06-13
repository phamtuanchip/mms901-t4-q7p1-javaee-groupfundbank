/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities.Validation;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author BinhNX
 */
public class ValidationHelper {
    
    private LinkedList<Validation> validationList = new LinkedList <Validation>();
    
    public void add(Validation vld)
    {
        validationList.add(vld);
    }
    
    public List<Validation> getvalidationList()
    {
        return validationList;
    }
    
    public String getValidationClass()
    {
        return "";
    }
    
    public String getValidationString()
    {
        return "";
    }
    
}
