<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript">

function listusers(){
	
	console.debug("kistusers")
	$.ajax({
        url: 'listusersjson',
        type: 'GET',
        success: function(response) {
            var trHTML = '';
            var count =0;
            $.each(response, function(i, item) {
            	console.debug("i is"+i);
            	
            	var success="success";
            	var danger="danger";
            	var info="info";
            	
                 var color ;
              
               
                 if(count==0)
                	 {
                	 color =success;
                	 count++;
                	 }else if(count==1){
                		 color =danger;
                		 count++;
                	 }else{
                		 color =info;
                		 count=0;
                		 
                	 }
             
             
            	
                trHTML += '<tr class="'+color+'" ><td>' + item.name + '</td><td>' + item.id + '</td><td>' + item.password +  '</td><td>' + item.email+
                    '</td><td>' + '<button type="button" class="btn btn-danger" id="' + item.id + '" >Delete</button>'
                '</td></tr>';
            });
            $('#delTable').append(trHTML);
            $('button').click(function() {
               var val = $(this).attr("id");
               console.debug("saurabh userid", val);
               var rowElement = $(this).parent().parent();
               $.ajax({
                    type: "DELETE",
                   
                url: "ajaxuserr/"+val,
                success: function(result) {
                    rowElement.find('td').fadeOut('3000',
                        function() {
                            rowElement.remove();
                        }
                    );
                }
            });
        });
        }
    });
}
$(document).ready(function() {
	listusers();
	(function ($) {
	    $.fn.serializeFormJSON = function () {

	        var o = {};
	        var a = this.serializeArray();
	        $.each(a, function () {
	            if (o[this.name]) {
	                if (!o[this.name].push) {
	                    o[this.name] = [o[this.name]];
	                }
	                o[this.name].push(this.value || '');
	            } else {
	                o[this.name] = this.value || '';
	            }
	        });
	        return o;
	    };
	})(jQuery);

	$('form').submit(function (e) {
	    e.preventDefault();
	    var data = $(this).serializeFormJSON();
	    console.log(data);
	    console.log(JSON.stringify(data));
	     $.ajax({
             type: "POST",
             contentType: "application/json",
             dataType: "json",

         url: "createajaxuser",
         data:JSON.stringify(data),
			error: function(jqXHR, textStatus, errorThrown) {
				console.debug("saurabh error");
				console.log(textStatus, errorThrown);			},
         success: function(result) {
        	 $('#delTable tbody').html(''); 
            console.debug("success")
        	 listusers();
         }
     });
	    

	});
	
	
    

});

</script>


</head>
<body>

<form action="#" method="post">
    <div>
        <label for="name">Name</label>
        <input type="text" name="name" id="name" />
    </div>
    <div>
        <label for="email">Email</label>
        <input type="text" name="email" id="email" />
    </div>
    <div>
        <label for="password">Password</label>
        <input type="password" name="password" id="password" />
    </div>
    <p>
        <input type="submit" value="Send" />
    </p>
</form>
    <div class="container">
    <table  class="table table-bordered table-hover" id="delTable" >
    <thead>
            <tr>
                <th width="100">Name</th>
                <th width="100">ID</th>
                <th width="100">Password</th>
                <th width="100">Email</th>
              <th width="100">Delete</th>
               	
            </tr>
        </thead>
        
  
        </tbody>
    </table>
    </div>
 </body>
</html>