<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="taglib.jsp"%>
<form:form modelAttribute="newProduct" method="post" action="addproduct"
	cssClass="form-horizontal" enctype="multipart/form-data">

	<c:if test="${param.success eq true}">
		<div class="alert alert-success">Added successfully!</div>
	</c:if>


	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">Name:</label>
		<div class="col-sm-10">
			<form:input path="name" cssClass="form-control" />
		</div>
	</div>
	<div class="form-group">
		<label for="price" class="col-sm-2 control-label">Price:</label>
		<div class="col-sm-10">
			<form:input path="price" cssClass="form-control" />
		</div>
	</div>
	<div class="form-group">
		<label for="stock" class="col-sm-2 control-label">Stock:</label>
		<div class="col-sm-10">
			<form:input path="stock" cssClass="form-control" />
		</div>
	</div>
	<div class="form-group">
		<label for="description" class="col-sm-2 control-label">Description:</label>
		<div class="col-sm-10">
			<form:textarea path="description" cssClass="form-control" />
		</div>
	</div>
	<div class="form-group">
		<label for="description" class="col-sm-2 control-label">Image ID:</label>
		<div class="col-sm-10">
			<form:input path="productImageID" cssClass="form-control" />
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-lg-2" for="productImage">
			Upload product image</label>
		<div class="col-lg-10">
			<form:input id="productImage" path="productImage" type="file"
				class="form:input-large" />
		</div>
	</div>
	<center>
		<div class="form-group">
			<div class="col-sm-2">
				<input type="submit" value="Save" class="btn btn-lg btn-primary" />
			</div>
		</div>
	</center>
</form:form>