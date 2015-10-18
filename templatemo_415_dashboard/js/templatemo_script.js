/* Credit: http://www.templatemo.com */
    
$(document).ready( function() {        

	// sidebar menu click
	$('.templatemo-sidebar-menu li.sub a').click(function(){
		if($(this).parent().hasClass('open')) {
			$(this).parent().removeClass('open');
			$(this).children.removeClass('fa fa-caret-down');
			$(this).children.addClass('fa fa-caret-up');
		} else {
			$(this).parent().addClass('open');
			$(this).children.removeClass('fa fa-caret-up');
			$(this).children.addClass('fa fa-caret-down');
		}
	});  // sidebar menu click

}); // document.ready
