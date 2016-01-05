<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="taglib.jsp" %>
 	<div class="row" data-ng-app="myApp">
						
							<c:if test="${orderDetails != null }">
							
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
									<th width="30%">Quantity</th>
									
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${orderDetails}" var="orderDetails" varStatus="loopCounter">
									<tr>
										<td><c:out value="${orderDetails.products.name}" /></td>
										 
										<td><c:out value="${orderDetails.products.price}" /></td>
										
										<td><c:out value="${orderDetails.quantity}" /></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>