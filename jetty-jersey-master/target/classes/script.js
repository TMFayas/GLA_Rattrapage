
function detail(id){
	$.ajax({
		async: false,
		type:'GET',
		dataType:'json',
		url:'ws/films/'+id
	}).done(function(film){
		console.log(film);
		$("#detailDiv").html("");
		var template = _.template($('#templateDetail').html());
		var resultat = template({ 
				"Name":film.name,
				"resume":film.synopsis,
				"critique":film.critique+""
			});
		$("#detailDiv").append(resultat);
		
	});
}

function listeFilm(id){
	$.ajax({
		async: false,
		type:'GET',
		dataType:'json',
		url:'ws/salles/'+id+'/films'
	}).done(function(films){
		console.log(films);
		$("#colonne").html("");
		$("#detailDiv").html("");
		for(var i = 0; i < films.length; i++){
			if(films[i].name != null){
				var template = _.template($('#templateFilm').html());
				var resultat = template({ 
					"id":films[i].id+"",
					"nom":films[i].name
				});
				$("#colonne").append(resultat);
			}
			
		}
	});
}


$(function (){
	$.ajax({
		async: false,
		type:'GET',
		dataType:'json',
		url:'ws/salles'
	}).done(function(salles){
		console.log(salles);
		$("#SalleList").html("");
		for(var i = 0; i < salles.length; i++){
			if(salles[i].name != null){
				var template = _.template($('#templateSalle').html());
				var resultat = template({ 
					"idSalle": salles[i].id+"",
					"nomSalle":salles[i].name
				});
				$("#SalleList").append(resultat);
			}
			
		}
	});
	$.ajax({
		async: false,
		type:'GET',
		dataType:'json',
		url:'ws/films'
	}).done(function(films){
		console.log(films);
		$("#colonne").html("");
		for(var i = 0; i < films.length; i++){
			if(films[i].name != null){
				var template = _.template($('#templateFilm').html());
				var resultat = template({ 
					"id":films[i].id+"",
					"nom":films[i].name
				});
				$("#colonne").append(resultat);
			}
			
		}
	});
});

