$( document ).ready(function() {
  
  // GET REQUEST
  $("#getAllCustomerId").click(function(event){
    event.preventDefault();
    ajaxGet();
  });
  
  // DO GET
  function ajaxGet(id){
    $.ajax({
      type : "GET",
      url : window.location + "api/filiere/"+id,
      success: function(result){
        if(result.status == "200"){
          $('#getResultDiv ul').empty();
          var custList = "";
          $.each(result.data, function(i, customer){
            var customer = "- Customer with Id = " + i + ", firstname = " + customer.firstname + ", lastName = " + customer.lastname + "<br>";
            $('#getResultDiv .list-group').append(customer)
              });
          console.log("Success: ", result);
        }else{
          $("#getResultDiv").html("<strong>Error</strong>");
          console.log("Fail: ", result);
        }
      },
      error : function(e) {
        $("#getResultDiv").html("<strong>Error</strong>");
        console.log("ERROR: ", e);
      }
    });  
  }
})