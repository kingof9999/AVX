<!-- 
	* error.jsp
	*
	* version 1.0
	*
	* Date: 07/04/2017
 	*
 	* Copyright
 	* 
 	* Modification Logs:
 	* DATE				AUTHOR			DECRIPTION
 	* -------------------------------------------
 	* 07/05/2017		TinLQ			Create
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="http://struts.apache.org/tags-faces" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/quanlynhanvien.css" />
<script src="js/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="header">
			<div class="header-top"></div>
			<div class="header-bottom"></div>
			<nav class="navbar navbar-default center-block">
				<div class="container-fluid">
					<div class="navbar-header">
	  					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#menu-collapse" aria-expanded="false">
					        <span class="sr-only">Toggle navigation</span>
					        <span class="icon-bar"></span>
					        <span class="icon-bar"></span>
					        <span class="icon-bar"></span>
	  					</button>
					</div>
	
					<div class="collapse navbar-collapse" id="menu-collapse">
						<ul class="nav navbar-nav">
							<li><a href="#">私のプロフィール</a></li>
							<li><a href="#">アカウントコース</a></li>
							<li><a href="#">アカウント</a></li>
							<li><a href="#">アカウント証明書</a></li>
							<li><a href="#">言語スコア</a></li>
							<li><a href="#">報告する</a></li>
							<li><a href="#">セキュリティ</a></li>
						</ul>
					</div>
				</div>
			</nav>
			<div style="color: red;">
				<label>Error :</label><br>
				<label>
					<html:errors property="dbError"/>
					<html:errors property="sqlUpdateError"/>
				</label>
			</div>
		</div>
		<div class="body">
		</div>
	</div>
</body>
</html>