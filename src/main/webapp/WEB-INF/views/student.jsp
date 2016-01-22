<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
	<title>Student</title>
</head>
<body>

	<c:choose>
	    <c:when test="${empty student.id}">
	        <c:set var="action" scope="session" value="create"/>
	        <c:set var="title" scope="session" value="Create"/>
	    </c:when>
	    <c:otherwise>
	        <c:set var="action" scope="session" value="update"/>
	        <c:set var="title" scope="session" value="Update"/>
	    </c:otherwise>
	</c:choose>
	
	<div class="row">
		<div class="col-sm-12">
			<div class="page-header">
				<h1>Student</h1>
			</div>	
		</div>
	</div>
	
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>${title} Student</h4>
				</div>
			  	<div class="panel-body">
			   		<f:form action="${pageContext.request.contextPath}/student/${action}" method="POST" commandName="student" 
			   			cssClass="form-inline">
			   			<f:hidden path="id" />
						<div class="form-group">
							<label for="firstName">First Name : </label>
							<f:input type="text" path="firstName" cssClass="form-control" id="firstName" placeholder="First Name" value="${student.firstName}"/>
						</div>
						&nbsp;
						<div class="form-group">
							<label for="lastName">Last Name : </label>
							<f:input type="text" path="lastName" cssClass="form-control" id="lastName" placeholder="Last Name" value="${student.lastName}"/>
						</div>
						<button type="submit" class="btn btn-primary">${title}</button>
					</f:form>
			  	</div>
			</div>
			
			<hr/>
		</div>
	</div>
	
	<br/>
	
	<div class="row">
		<div class=col-sm-12>
			<table class="table table-bordered table-responsive">
				<thead>
					<tr>
						<th>ID</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Created</th>
						<th>Updated</th>
						<th colspan="2">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${students}" var="student">
						<tr>
							<td>${student.id}</td>
							<td>${student.firstName}</td>
							<td>${student.lastName}</td>
							<td>${student.createdDateTime}</td>
							<td>${student.updatedDateTime}</td>
							<td><a class="btn btn-warning" href="${pageContext.request.contextPath}/student/update/${student.id}">Update</a></td>
							<td><a class="btn btn-danger" href="${pageContext.request.contextPath}/student/delete/${student.id}">Delete</a></td>
						</tr>
                  	</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
</body>
</html>