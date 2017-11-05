$(document).ready(function () {
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green',
        });
    });
    
$(document).ready(function(){
	if(window.top !== window.self){ 
		window.top.location = window.location;
	};
});