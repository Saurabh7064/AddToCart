<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	<style type="text/css">
	.modal-body .form-horizontal .col-sm-2,
.modal-body .form-horizontal .col-sm-10 {
    width: 100%
}

.modal-body .form-horizontal .control-label {
    text-align: left;
}
.modal-body .form-horizontal .col-sm-offset-2 {
    margin-left: 15px;
}
	</style>
	
	
	
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
           /*  $('button').click(function() {
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
        }); */
        
        
        $('#delTable').on('click','button', function() {
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
        })
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
             /* dataType: "json"  this specifies what we are returning from controller ,in this case nothing just 200 */ 

         url: "createajaxuser",
         data:JSON.stringify(data),
			
         success: function(result) {
        	 $('#delTable tbody').html(''); 
            console.debug("saurabh success")
        	 listusers();
         },error: function(jqXHR, textStatus, errorThrown) {
				console.debug("saurabh error");
				console.log(textStatus, errorThrown);		
				},
     });
	    

	});
	
	/*               */
    

});

</script>


</head>
<body>
<!-- Normal form -->
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


<!-- modal form -->
<!-- Button trigger modal -->
<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModalHorizontal">
   Register me
</button>

<!-- Modal -->
<div class="modal fade" id="myModalHorizontal" tabindex="-1" role="dialog" 
     aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
                <button type="button" class="close" 
                   data-dismiss="modal">
                       <span aria-hidden="true">&times;</span>
                       <span class="sr-only">Close</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    Modal title
                </h4>
            </div>
            
            <!-- Modal Body -->
            <div class="modal-body">
                
                <form class="form-horizontal" role="form">
                  <div class="form-group">
                    <label  class="col-sm-2 control-label"
                              for="inputEmail3">Email</label>
                    <div class="col-sm-10">
                        <input type="email" class="form-control" 
                        id="inputEmail3" placeholder="Email"/>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 control-label"
                          for="inputPassword3" >Password</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control"
                            id="inputPassword3" placeholder="Password"/>
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                      <div class="checkbox">
                        <label>
                            <input type="checkbox"/> Remember me
                        </label>
                      </div>
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                      <button type="submit" class="btn btn-default">Sign in</button>
                    </div>
                  </div>
                </form>
                
                
                
                
                
                
            </div>
            
            <!-- Modal Footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-default"
                        data-dismiss="modal">
                            Close
                </button>
                <button type="button" class="btn btn-primary">
                    Save changes
                </button>
            </div>
        </div>
    </div>
</div>


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