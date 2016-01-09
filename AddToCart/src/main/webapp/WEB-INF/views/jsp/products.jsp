<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="taglib.jsp" %>
 	<div class="row" data-ng-app="myApp">
						
							<c:if test="${username != null }">
						<c:if test="${param.success eq true}">
						<!-- <script>
	                    alert("item added to cart");
	                    </script> -->
	                 </c:if>	
							<div class="pull-left" data-ng-controller="myController">
        						<a class="btn btn-success" href="<c:url value="/userdetail"/>"> <i
								class="fa fa-plus"></i> <sec:authentication property="name" /></a> 
								<a class="btn btn-primary" href="<c:url value="/role"/>"> <i
								class="fa fa-list-ol"></i> <sec:authentication property="authorities" /></a>
            				 
							</div>								
						</c:if>							
					</div>
 
					<section class="container">
		<div class="row">
			<c:forEach items="${productlist}" var="product">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
					<img src="<c:url value="/resource/productimages/${product.productImageID}.png"></c:url>" alt="image"  style = "width:100%"/>
						<div class="caption">
							<h3>${product.name}</h3>
							<p>${product.description}</p>
							<p>Rs. ${product.price}</p>
							<p>Available ${product.stock} units in stock</p>
							<p>
							 
								<a
									href=" <spring:url value="/product/${product.id}" /> "
									class="btn btn-primary"> <span
									class="glyphicon-info-sign glyphicon" /></span>Details
								</a>
								
									<a href=" <spring:url value="/addtocart/${product.id}" /> " class="btn btn-warning btn-large"  > 
<span class="glyphicon-shopping-cart glyphicon"></span>Add to cart</a>
							</p>

						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>