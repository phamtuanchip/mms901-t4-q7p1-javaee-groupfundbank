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
;(function($){
	$.fn.toggleValue = function() {
		return this.each(function() {
			var node = this.nodeName.toLowerCase();
			if( node == 'input' ) {
				
				if ( !this.type ) this.type = 'text';
				
				if ( ( this.type == 'text' ) || ( this.type == 'password' ) ) {
					this.canEdit = true;
				};	
				
			} else if( node == 'textarea' ) {
			
				this.canEdit = true;
				
			};
			if ( this.canEdit ) {
				$(this).focus(function() {
					if (!this.edited)
					{
						this.val = $(this).val();
						$(this).val("");
						this.edited=true;
					}
				});
				$(this).blur(function() {
					if ($(this).val()=="")
					{
						$(this).val(this.val);
						this.edited=false;
					}
				});
			}
		});
	};
})(jQuery);