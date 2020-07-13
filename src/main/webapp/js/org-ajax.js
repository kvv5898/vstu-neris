$(document).ready(function() {
	 $(document).on('click', '.info', function() {
		 var $this = $(this);
	        if ($this.hasClass('refresh-button')) {
	            return false;
	        }
    	var data = {};
    	var productId = $this.attr('id');
//    	alert(productId);
        data = productId;
        data = {"org":productId};
        $.ajax({
            
        	dataType: 'html',
        	data: data,
            url : 'SelectValidity',     // URL - сервлет
//            contentType: "application/x-www-form-urlencoded;charset=UTF-8",
            success : function(response) {
                                     // обработка ответа от сервера
            	alert(response)
                $('#ajaxOrgforResponse').text(response);
            }
        });
    });
});