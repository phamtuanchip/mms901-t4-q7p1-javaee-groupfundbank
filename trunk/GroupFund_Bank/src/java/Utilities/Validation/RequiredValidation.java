/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities.Validation;

/**
 *
 * @author BinhNX
 */
public class RequiredValidation extends Validation {
    private String _validationClass = "vld-required";
    private String _validationMsg = "The {0} field is required";

    public RequiredValidation() {
    }
    public RequiredValidation(String validationMsg) {
        _validationMsg = validationMsg;
    }
    @Override
    public String getValidationMsg() {
        return "data-val-required-msg = " + _validationMsg;
    }

    @Override
    public void setValidationMsg(String validationMsg) {
        _validationMsg = validationMsg;
    }

    @Override
    public String getValidationClass() {
        return _validationClass;
    }

    
    
}
