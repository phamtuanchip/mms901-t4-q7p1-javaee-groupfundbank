/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities.Validation;

/**
 *
 * @author BinhNX
 */
public class LengthValidation extends Validation{
    private int _minLength = 0;
    private int _maxLength = 100;
    private String _validationClass = "vld-length";
    private String _validationMsg = "The {0} field length must be between {1} and {2}";
    // {0} field label
    // {1} min value
    // {2} max value

    public LengthValidation() {
    }
    
    public LengthValidation(int minLength, int maxLength)
    {
        _minLength = minLength;
        _maxLength = maxLength;
    }
    public LengthValidation(int minLength, int maxLength, String validationMsg) {
        _minLength = minLength;
        _maxLength = maxLength;
        _validationMsg = validationMsg;
    }
        
    @Override
    public String getValidationMsg() {
        String validationMsg = _validationMsg.replace("{1}", Integer.toString(_minLength));
        validationMsg = validationMsg.replace("{2}", Integer.toString(_maxLength));
        return "data-val-length-min = " + _minLength + " data-val-length-max = " + _maxLength + " data-val-length-msg = " + validationMsg;
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
