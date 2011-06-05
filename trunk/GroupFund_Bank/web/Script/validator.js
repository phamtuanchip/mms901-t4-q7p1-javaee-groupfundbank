function validate()
{
    
    $(".require-validation").each( function() {
        if (jQuery.trim($(this).val()) == "") 
            {
                $(this).nextAll(".require-validation-err:first").show(500);
                var error = true;
            }
        else
            {
                $(this).nextAll(".require-validation-err:first").hide(200);
                error = false
            }
    });
    if (!error) return false;
    else return true;
}

