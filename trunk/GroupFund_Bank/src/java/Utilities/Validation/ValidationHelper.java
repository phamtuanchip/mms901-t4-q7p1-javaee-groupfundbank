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
    private LinkedList<Validation> _validationList = new LinkedList <Validation>();
    
    public void add(Validation vld) throws Exception
    {
        if (vld.getClass() == LengthValidation.class || vld.getClass() == RegularExpressionValidation.class)
        {
            for (Validation validation : _validationList) {
                if (validation.getClass() == NumberValidation.class || validation.getClass() == RangeValidation.class)
                {
                    _validationList.remove(validation);
                }
                if (validation.getClass() == vld.getClass())
                {
                    return;
                }
            }
        }
        else if (vld.getClass() != RequiredValidation.class)
        {
            for (Validation validation : _validationList) {
                if (vld.getClass() == validation.getClass())
                {
                    return;
                }
                else if (validation.getClass() != RequiredValidation.class)
                {
                    return;
                }
            }
        }
        else 
        {
            for (Validation validation : _validationList) {
                if (validation.getClass() == RequiredValidation.class)
                {
                    return;
                }
            }
        }
        _validationList.add(vld);
    }
    
    public List<Validation> getvalidationList()
    {
        return _validationList;
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
