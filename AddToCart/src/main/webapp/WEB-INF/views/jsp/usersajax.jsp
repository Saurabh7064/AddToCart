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


$(document).ready(function() {
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

});

</script>


</head>
<body>
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