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
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link
	href="http://cdn.datatables.net/plug-ins/a5734b29083/integration/bootstrap/3/dataTables.bootstrap.css"
	rel="stylesheet">
<link
	href="http://cdn.datatables.net/responsive/1.0.1/css/dataTables.responsive.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/myStyle.css" />
<script src="js/jquery.min.js"></script>

<!-- dataTable -->
<script
	src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<script
	src="http://cdn.datatables.net/responsive/1.0.1/js/dataTables.responsive.min.js"></script>
<script
	src="http://cdn.datatables.net/plug-ins/a5734b29083/integration/bootstrap/3/dataTables.bootstrap.js"></script>
<script
	src="https://cdn.datatables.net/rowgroup/1.0.0/css/rowGroup.dataTables.min.css"></script>
<script
	src="https://cdn.datatables.net/rowgroup/1.0.0/js/dataTables.rowGroup.min.js"></script>
<script>
	function autoClick(){
		document.getElementById('click').click();
	}
</script>
<title>Error</title>
</head>
<body onload="setTimeout('autoClick();', 3000);">
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
		</div>
		<div class="body">
			<center>
				<span>Error :</span>
			</center>
			<center>
				
			</center>
		</div>
	</div>
</body>
</html>