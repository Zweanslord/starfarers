$(document).ready(function() {
	var terrain = "";
	var editing = false;
	
	$(".galaxy.paint polygon").click(function() {
		var selectingTerrain = false;
		if ($(this).attr("class").contains("selected")) {
			terrain = "";
		} else {
			selectingTerrain = true;
			terrain = $(this).attr("class");
		}
		$(".galaxy.paint polygon").each(function() {
			$(this).attr("class", $(this).attr("class").replace(" selected", ""));
		});
		if (selectingTerrain) {
			$(this).attr("class", $(this).attr("class") + " selected");
		}
	});
	
	$("body").mouseup(function() {
		editing = false;
	});
	
	$(".galaxy.editor polygon").mousedown(function() {
		editing = true;
		changeTerrain($(this));
	}).mouseover(function() {
		changeTerrain($(this));
	});
	
	function changeTerrain(element) {
		if (terrain != "" && editing) {
			element.attr("class", terrain);
		}
	}
	
});