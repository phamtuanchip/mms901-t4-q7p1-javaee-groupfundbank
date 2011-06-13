/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities.Validation;

/**
 *
 * @author BinhNX
 */
public class RangeValidation extends Validation {
    private float _minValue = Float.MIN_VALUE;
    private float _maxValue = Float.MAX_VALUE;
    private String _validationClass = "vld-range";
    private String _validationMsg = "The {0} field must be between {1} and {2}";
    
    public RangeValidation(int minValue, int maxValue)
        {
            _minValue = minValue;
            _maxValue = maxValue;
        }
        
    @Override
    public String getValidationMsg() {
        String validationMsg = _validationMsg.replace("{1}", Float.toString(_minValue));
        validationMsg = validationMsg.replace("{2}", Float.toString(_maxValue));
        return validationMsg;
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
