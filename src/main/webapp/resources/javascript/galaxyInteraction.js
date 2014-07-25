$(document).ready(function() {
	$('svg.galaxy.interaction').svgPan('viewport');
	
	function centerMap() {
		var galaxy = $('svg.galaxy');
		$('svg.galaxy #viewport').attr('transform', 'translate(0,0)'); // reset to get proper BBox
		var galaxyBBox = galaxy.get(0).getBBox();
		
		var galaxyHeight = galaxyBBox.height;
		var galaxyWidth = galaxyBBox.width;		

		var viewportHeight = galaxy.height();
		var viewportWidth = galaxy.width();

		var verticalOffset = viewportHeight / 2 - galaxyHeight / 2;
		var horizontalOffset = viewportWidth / 2 - galaxyWidth / 2;
		
		$('svg.galaxy #viewport').attr('transform', 'translate(' + horizontalOffset + ',' + verticalOffset + ')');
	}
	
	centerMap();
	 
	$('#centerMap.mapButton').click(function() {
		centerMap();
	});
	
	function toggleFullScreen() {
		if (!document.fullscreenElement && !document.mozFullScreenElement && !document.webkitFullscreenElement && !document.msFullscreenElement) {
			var element = $('.galaxyVoid').get(0);
			request = element.requestFullScreen || element.mozRequestFullScreen || element.webkitRequestFullScreen || element.msRequestFullScreen;
			request.call(element);
		} else {
			request = document.exitFullscreen || document.mozCancelFullScreen || document.webkitExitFullscreen || document.msExitFullscreen;
			request.call(document);
		}
	}
	
	if (document.fullscreenEnabled || document.mozFullScreenEnabled || document.webkitFullscreenEnabled || document.msFullscreenEnabled) {
		$('#fullScreen.mapButton').show();
	}
	
	$('#fullScreen.mapButton').click(function() {
		toggleFullScreen();
	});
	
});