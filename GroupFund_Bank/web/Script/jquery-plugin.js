/*
* jQuery.fn.toggleValue();
*
* Toggle default value on focus/blur, works on:
* input:text, input:password and textarea
*
* $('.element').toggleValue();
*
* Version 0.6.0
* www.labs.skengdon.com/toggleValue
* www.labs.skengdon.com/toggleValue/js/toggleValue.min.js
* Version 0.6.0.m (modified)
* by binhnx218
*/
(function($){
    $.fn.toggleValue = function() {
        return this.each(function() {
            var node = this.nodeName.toLowerCase();
            if( node == 'input' ) {
                if ( !this.type ) this.type = 'text';
                if ( ( this.type == 'text' ) || ( this.type == 'password' ) ) {
                    this.canEdit = true;
                }					
            } else if( node == 'textarea' ) {
                this.canEdit = true;
            }
            
            if ( this.canEdit ) {
                $(this).focus(function() {
                    if ($(document).data("ready") == true)
                    {
                        if (this.edited == null) this.edited = false;
                        if (!this.nfirst)
                        {
                            if (!this.edited)
                            {
                                $(this).val("");
                            }
                        }
                    }
                });
                $(this).blur(function() {
                    if ($(this).val()=="")
                    {
                        $(this).val(this.defaultValue);
                        this.edited=false;
                    }
                    else
                    {
                        if ($(this).caret().text != this.defaultValue)
                            this.edited = true;
                    }
                });
            }
        });
    };
})(jQuery);


/*
 *
 * Copyright (c) 2010 C. F., Wong (<a href="http://cloudgen.w0ng.hk">Cloudgen Examplet Store</a>)
 * Licensed under the MIT License:
 * http://www.opensource.org/licenses/mit-license.php
 *
 */
(function($,len,createRange,duplicate){
	$.fn.caret=function(options,opt2){
		var start,end,t=this[0],browser=$.browser.msie;
		if(typeof options==="object" && typeof options.start==="number" && typeof options.end==="number") {
			start=options.start;
			end=options.end;
		} else if(typeof options==="number" && typeof opt2==="number"){
			start=options;
			end=opt2;
		} else if(typeof options==="string"){
			if((start=t.value.indexOf(options))>-1) end=start+options[len];
			else start=null;
		} else if(Object.prototype.toString.call(options)==="[object RegExp]"){
			var re=options.exec(t.value);
			if(re != null) {
				start=re.index;
				end=start+re[0][len];
			}
		}
		if(typeof start!="undefined"){
			if(browser){
				var selRange = this[0].createTextRange();
				selRange.collapse(true);
				selRange.moveStart('character', start);
				selRange.moveEnd('character', end-start);
				selRange.select();
			} else {
				this[0].selectionStart=start;
				this[0].selectionEnd=end;
			}
			this[0].focus();
			return this
		} else {
			// Modification as suggested by Андрей Юткин
           if(browser){
				var selection=document.selection;
                if (this[0].tagName.toLowerCase() != "textarea") {
                    var val = this.val(),
                    range = selection[createRange]()[duplicate]();
                    range.moveEnd("character", val[len]);
                    var s = (range.text == "" ? val[len]:val.lastIndexOf(range.text));
                    range = selection[createRange]()[duplicate]();
                    range.moveStart("character", -val[len]);
                    var e = range.text[len];
                } else {
                    range = selection[createRange](),
                    stored_range = range[duplicate]();
                    stored_range.moveToElementText(this[0]);
                    stored_range.setEndPoint('EndToEnd', range);
                    s = stored_range.text[len] - range.text[len],
                    e = s + range.text[len]
                }
			// End of Modification
            } else {
				s=t.selectionStart,
					e=t.selectionEnd;
			}
			var te=t.value.substring(s,e);
			return {start:s,end:e,text:te,replace:function(st){
				return t.value.substring(0,s)+st+t.value.substring(e,t.value[len])
			}}
		}
	}
})(jQuery,"length","createRange","duplicate");