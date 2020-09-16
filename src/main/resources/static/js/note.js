/**
 * 
 */
 
 $(document).ready(function () {              
   					 
   		$('#filiereEdit').change(function(event) {
       		getContent();
    	});

        function getContent() {

           //create url to request fragment  
          var selectedIndex = $("#filiereEdit option:selected").index();
                               
          var url = "/notes/etudiants/"+selectedIndex;                
                    
          //load fragment and replace content
           $('#listeNotes').load(url);
              
         }
                
                
});