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
	
	function getGalaxy() {
		var galaxy = { 
			"id" : $("#galaxy-id").text(),
			"radius": $("#galaxy-radius").text()
		};
		var sectors = [];
		$("svg.galaxy.editor polygon").each(function() {
			sectors.push({
				"coordinates" : {
					"x": $(this).data('x'),
					"y" : $(this).data('y')
				},
				"terrain" : $(this).data('terrain')
			});
		});
		galaxy['sectors'] = sectors;
		return galaxy;
	}
	
	$("#saveGalaxy").click(function () {
		$("#saveGalaxySuccess").hide();
		$("#saveGalaxyFailure").hide();
		$.ajax({
			type: "POST",
			url: "/starfarers/editor/galaxy/save",
			contentType: 'application/json',
			data: JSON.stringify(getGalaxy()),
			success: function(response) {
				if (response) {
					$("#galaxy-id").text(response);
					$("#saveGalaxySuccess").show();
				} else {
					$("#saveGalaxyFailure").show();
				}
			}
		});
	});
	
});