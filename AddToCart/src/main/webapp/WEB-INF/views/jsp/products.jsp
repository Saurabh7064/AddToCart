<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="taglib.jsp" %>
 	<div class="row" data-ng-app="myApp">
						
							<c:if test="${username != null }">
						<c:if test="${param.success eq true}">
						<script>
	                    alert("item added to cart");
	                    </script>
	                 </c:if>	
							<div class="pull-left" data-ng-controller="myController">
        						<a class="btn btn-success" href="<c:url value="/userdetail"/>"> <i
								class="fa fa-plus"></i> <sec:authentication property="name" /></a> 
								<a class="btn btn-primary" href="<c:url value="/role"/>"> <i
								class="fa fa-list-ol"></i> <sec:authentication property="authorities" /></a>
            				 
							</div>								
						</c:if>							
					</div>
<div class="table-responsive row">
						<table class="table table-striped table-bordered table-condensed text-center">
							<thead>
								<tr class="success">
									<th width="30%">Products</th>
									<th width="30%">Price</th>
									<th width="30%">Add To Cart</th>
									
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${productlist}" var="product" varStatus="loopCounter">
									<tr>
										<td><c:out value="${product.name}" /></td>
										 
										<td><c:out value="${product.price}" /></td>
										
										<td><nobr>
												<a class="btn btn-primary"	href="<c:url value="/addtocart/${product.id}"/>"> 
													<i class="fa fa-pencil"></i> Add To Cart
												</a> 
										</nobr></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>