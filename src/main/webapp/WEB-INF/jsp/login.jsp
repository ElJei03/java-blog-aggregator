<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 

<style>

.form-signin {
	max-width: 330px;
	padding: 15px;
	margin: 0 auto; 
}

.form-signin .form-signin-heading,.form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin .checkbox {
	font-weight: normal;
}

.form-signin .form-control {
	position: relative;
	height: auto;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	padding: 10px;
	font-size: 16px;
}

.form-signin .form-control:focus {
	z-index: 2;
}

.form-signin input[type="email"] {
	margin-bottom: -1px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
</style>

<form class="form-signin" role="form" action="<spring:url value="/login" />" method="POST">
	<h2 class="form-signin-heading">Please sign in</h2>
	<input type="text" name="username" class="form-control" placeholder="Name" required autofocus> 
	
	<input type="password" name="password" class="form-control" placeholder="Password" required> 
	<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
	<input name="_csrf" type="hidden" value="a0d3249a-355a-4523-9eb8-a970f2f7cc3d" />
</form>
