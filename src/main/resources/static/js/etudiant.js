/**
 * 
 */
 $('document').ready(function(){
 	$('.table #editButton').on('click',function(event){
 		event.preventDefault();

 		var href = $(this).attr('href');

 		$.get(href, function(etudiant, status){
 			$('#idEdit').val(etudiant.id);
 			$('#nameEdit').val(etudiant.nom);
 			$('#prenomEdit').val(etudiant.prenom);
 			$('#sexeEdit').val(etudiant.sexe);
 			$('#dateNaissEdit').val(etudiant.dateNaissance);
 			$('#filiereEdit').val(etudiant.filiereid);
 		
 		});

 		$('#editModal').modal();
 	});
 	
 	
 	$('.table #deleteButton').on('click',function(event){
 		event.preventDefault();

 		var href = $(this).attr('href');


 		$('#deleteModal').modal();
 	});
 });
 