/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities.Validation;

/**
 *
 * @author BinhNX
 */
public class RegularExpressionValidation extends Validation {
    private String _regEx = "";
    private String _regExTitile = "Regular expression";
    private String _validationClass = "vld-regex";
    private String _validationMsg = "The {0} field is not in a valid {1} format";
    // {0} field name
    // {1} regular expression title (email, url...)

    public RegularExpressionValidation() {
    }  
    public RegularExpressionValidation(String regEx)
    {
        _regEx = regEx;
    }
    public RegularExpressionValidation(String regEx, String title)
    {
        _regEx = regEx;
        _regExTitile = title;
    }
        
    @Override
    public String getValidationMsg() {
        String validationMsg = _validationMsg.replace("{1}", _regExTitile);
        return "data-val-regex = " + _regEx + " data-val-reg-msg = " + validationMsg;
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
