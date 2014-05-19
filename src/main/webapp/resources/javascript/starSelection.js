$(document).ready(function() {
	
	$(".galaxy .star").click(function() {
		gotoStar($(this));
	});
	
	function gotoStar(star) {
		var x = $(star).data("x");
		var y = $(star).data("y");
		alert("Coordinates: x=" + x + " y=" + y);
	}

});