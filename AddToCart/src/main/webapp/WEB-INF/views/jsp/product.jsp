<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="taglib.jsp" %>

	<section class="container" >
		<div class="row">
		<div class="col-md-5">
	<img src="<c:url value="/resource/productimages/${product.id}.png"></c:url>" alt="image"  style = "width:100%"/>
</div>
		
			<div class="col-md-5">
				<h3>${product.name}</h3>
				<p>${product.description}</p>
				<p>
					<strong>Item Code : </strong><span class="label label-warning">${product.id}</span>
				</p>
				 
				<p>
					<strong>Available units in stock </strong> : ${product.stock}
				</p>
				<h4>Rs. ${product.price}</h4>
				 <p>
					<a href=" <spring:url value="/addtocart/${product.id}" /> " class="btn btn-warning btn-large"  > 
<span class="glyphicon-shopping-cart glyphicon"></span>Add to cart</a>
<a href="<spring:url value="/displaycart" />" class="btn btn-default">
	<span class="glyphicon-hand-right glyphicon"></span> View Cart
</a>

 <a href="<spring:url value="/productlist" />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span> back
					</a>

				</p>

			</div>
		</div>
	</section>