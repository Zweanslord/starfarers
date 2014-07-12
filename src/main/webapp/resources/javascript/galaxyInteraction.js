$(document).ready(function() {
	 $('svg.galaxy.interaction').svgPan('viewport');
	 
	 function fixWebkitHeightBug(){
		var svgWidth = $(".galaxyVoid .galaxyWidth").html();
		var svgHeight = $(".galaxyVoid .galaxyHeight").html();
		var currentSVGWidth = $(".galaxyVoid svg.galaxy").width();
		var newSVGHeight = heightInRatio(svgWidth, svgHeight, currentSVGWidth);
		$(".galaxyVoid svg.galaxy").height(newSVGHeight);

		function heightInRatio(oldHeight, oldWidth, newWidth){
			return (oldHeight / oldWidth * newWidth);
		}

	}

	$(window).resize(function() {
	//	fixWebkitHeightBug();
	});

	//fixWebkitHeightBug();
});