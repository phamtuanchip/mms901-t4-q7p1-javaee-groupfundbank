/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities.Validation;

/**
 *
 * @author BinhNX
 */
public class NumberValidation extends Validation{
    public static enum NumberType {
        Integer {
            @Override
            public String toString()
            {
                return "integer";
            }
        },
        Real {
            @Override
            public String toString()
            {
                return "real";
            }
        },
        Money {
            @Override
            public String toString()
            {
                return "real";
            }
        }
    }
    
    private NumberType _type = NumberType.Integer;
    private String _validationClass = "vld-number";
    private String _validationMsg = "The {0} field must be a {1} number";

    public NumberValidation() {
    }
    public NumberValidation(NumberType type)
    {
        _type = type;
    }
    
    @Override
    public String getValidationMsg() {
        String validationMsg = _validationMsg.replace("{1}", _type.toString());
        return "data-val-num = " + _type.toString() + " data-val-num-msg = " + validationMsg;
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
