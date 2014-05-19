$(document).ready(function() {
	var terrain = "";
	var starSystem = false;
	var editing = false;
	
	$(".galaxy.paint polygon, .galaxy.paint circle").click(function() {
		selectPaint($(this));
	});
	
	function selectPaint(element) {
		var selecting = false;
		if ($(element).attr("class").contains("selected")) {
			terrain = "";
			starSystem = false;
		} else if ($(element).attr("class").contains("star")) {
			selecting = true;
			terrain = "";
			starSystem = true;
		} else {
			selecting = true;
			terrain = $(element).attr("class");
			starSystem = false;
		}
		$(".galaxy.paint polygon, .galaxy.paint circle").each(function() {
			$(element).attr("class", $(element).attr("class").replace(" selected", ""));
		});
		if (selecting) {
			$(element).attr("class", $(element).attr("class") + " selected");
		}
	}
	
	$("body").mouseup(function() {
		editing = false;
	});
	
	$(".galaxy.editor g").mousedown(function() {
		editing = true;
		changeTerrain($(this));
	}).mouseenter(function() {
		if (editing) {
			changeTerrain($(this));
		}
	});
	
	function changeTerrain(group) {
		var element = $(group).find("polygon");
		if (terrain != "") {
			element.attr("class", terrain);
			element.attr("data-terrain", terrain);
		} else if (starSystem) {
			if (element.attr("data-starSystem") == 'true') {
				element.attr("data-starSystem", 'false');
				$(group).find("circle").remove();
			} else if (element.attr("data-starSystem") == 'false') {
				element.attr("data-starSystem", 'true');
				createStar(group);
			}
		}
	}
	
	function createStar(group) {
		var radius = $("#star-radius").text();
		var star = document.createElementNS("http://www.w3.org/2000/svg", "circle");
		star.setAttribute("class", "star");
		star.setAttribute("r", radius);
		star.setAttribute("cy", radius);
		group.append(star);
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
					if ($("#galaxy-id").text() == "") {
						addGalaxyToTabs(response);
					}
					$("#galaxy-id").text(response);
					$("#saveGalaxySuccess").show();
				} else {
					$("#saveGalaxyFailure").show();
				}
			}
		});
	});
	
	function getGalaxy() {
		var galaxy = { 
			"id" : $("#galaxy-id").text(),
			"radius": $("#galaxy-radius").text()
		};
		var sectors = [];
		$("svg.galaxy.editor polygon").each(function() {
			sectors.push({
				"id" : $(this).data('id'),
				"coordinates" : {
					"x": $(this).data('x'),
					"y" : $(this).data('y')
				},
				"terrain" : $(this).data('terrain'),
				"starSystem" : $(this).data('starsystem')
			});
		});
		galaxy['sectors'] = sectors;
		return galaxy;
	}
	
	function addGalaxyToTabs(id) {
		// TODO
	}
	
});