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

    public RangeValidation() {
    }
    public RangeValidation(float minValue, float maxValue)
    {
        _minValue = minValue;
        _maxValue = maxValue;
    }
        
    @Override
    public String getValidationMsg() {
        String validationMsg = _validationMsg.replace("{1}", Float.toString(_minValue));
        validationMsg = validationMsg.replace("{2}", Float.toString(_maxValue));
        return "data-val-range-min = " + _minValue + " data-val-range-max = " + _maxValue + " data-val-length-msg = " + validationMsg;
    }

    @Override
    public void setValidationMsg(String validationMsg) {
        _validationMsg = validationMsg;
    }

    @Override
    public String getValidationClass() {
        return _validationClass;
    }
    
    public float getMinValue()
    {
        return _minValue;
    }
    
    public float getMaxValue()
    {
        return _maxValue;
    }
    
    public void setMinValue(float minValue)
    {
        _minValue = minValue;
    }
        
    public void setMaxValue(float maxValue)
    {
        _maxValue = maxValue;
    }
}
