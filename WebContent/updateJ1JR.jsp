<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ｊ１／ＪＲ情報簡易修正</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link
	href="http://cdn.datatables.net/plug-ins/a5734b29083/integration/bootstrap/3/dataTables.bootstrap.css"
	rel="stylesheet">
<link
	href="http://cdn.datatables.net/responsive/1.0.1/css/dataTables.responsive.css"
	rel="stylesheet">
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
		</div>
		<div class="body">
			<div class="main-form col-sm-12">
				<div class="top-text col-sm-12">
					<div class="col-sm-5" style="float: left;">
						<label class="my-label">AUTA321</label>
					</div>
					<div class="col-sm-4" style="float: left;">
						<label class="my-label">Ｊ１／ＪＲ情報簡易修正</label>
					</div>
					<div class="col-sm-3" style="float: left;">
						<label id="clock" style="padding-left: 78%;" class="my-label"></label>
						<script type="text/javascript"> function refrClock() {
								var d=new Date();
								var s=d.getSeconds();
								var m=d.getMinutes();
								var h=d.getHours();
								var day=d.getDay();
								var date=d.getDate();
								var month=d.getMonth();
								var year=d.getFullYear();
								var days=new Array("Sunday,","Monday,","Tuesday,","Wednesday,","Thursday,","Friday,","Saturday,");
								var months=new Array("1","2","3","4","5","6","7","8","9","10","11","12"); var am_pm;
									if (s<10) {s="0" + s}
									if (m<10) {m="0" + m}
									if (h>12){
											h-=12;AM_PM = "PM"
									}
									else {AM_PM="AM"}
									if (h<10) {
										h="0" + h
									}
								   document.getElementById("clock").innerHTML= year + "/" +months[month] + "/" + date; 
								   setTimeout("refrClock()",1000); } refrClock();
						</script>
					</div>
				</div>
				<html:form action="/search-J1JR" styleClass="form-group" method="post">
				<div class="top-message col-sm-12">
					<label id="message" style="color: red;margin-left: 50px;"><html:errors property="nullStokError"/></label>
					<label style="color: red;margin-left: 50px;">
						<html:errors property="reloadPageError"/>
						<html:errors property="updateSuccess"/>
					</label>
				</div>
				<div class="body-filter col-sm-12" style="height: 80px;">
					<div style="margin: 24px 0 0 50px;">
						<table>
							<tr>
								<td>
									<div class="body-main-label-text"><label class="my-label2">ストック・ナンバー</label></div>
								</td>
								<td style="padding-left: 20px;width: 87%;">
									<html:text property="iTEMMSTOK" styleClass="form-control" style="width: 37%;"></html:text>
								</td>
							</tr>
						</table>
					</div>
				</div>
				<div class="body-button col-sm-12">
					<div style="margin: 10px 0 0 83%;">
						<html:submit styleClass="m-btn m-btn-success my-btn" style="width: 69px;height: 34px;">検索(S)</html:submit>
						<input type="reset" class="m-btn m-btn-success my-btn" style="width: 110px;height: 34px;" onclick="location.href='updateJ1JR.jsp';" value="'キャンセル(C)"/>
					</div>
				</div>
				</html:form>
				<div class="body-main-top col-sm-12">
					<div style="margin-left: 15px;">
						<label class="my-label2">1/24べ ー ジ </label>
						<button style="margin-left: 5px;background-color: #c0ccd8;" disabled="true"><i class="glyphicon glyphicon-arrow-left"></i></button>
						<button style="margin: 0 10px 0 10px;background-color: #c0ccd8;"><i class="glyphicon glyphicon-arrow-right"></i></button>
						<label class="my-label2">べ ー ジ</label>
						<input style="margin: 0 10px 0 10px; width: 50px;" type="text" value="1">
						<button class="m-btn m-btn-success my-btn">表示</button>
					</div>
				</div>
				<html:form styleId="infoForm" action="/update-J1JR" styleClass="form-group" method="post">
				<div class="body-main col-sm-12">
					<div style="margin: 24px 0 0 50px;">
						<table>
							<tr>
								<td class="body-main-label">
									<div class="body-main-label-text"><label class="my-label2"> ストック・ナンバー</label></div>
								</td>
								<td style="padding-left: 20px;width: 87%;">
									<html:text property="iTEMMSTOK" styleClass="form-control" style="width: 20%;" readonly="true" maxlength="14"></html:text>
								</td>
							</tr>
							<tr>
								<td class="body-main-label">
									<div class="body-main-label-text"><label class="my-label2">主保管地コード</label></div>
								</td>
								<td style="padding-left: 20px;width: 87%;">
									<html:text property="iTEMMSKCD" styleClass="form-control" style="width: 5%;" maxlength="2"></html:text>
									<label style="color: red;">
										<html:errors property="updateHalfSizeError"/>
										<html:errors property="existError"/>
									</label>
								</td>
							</tr>
							<tr>
								<td class="body-main-label">
									<div class="body-main-label-text"><label class="my-label2">担当者コード</label></div>
								</td>
								<td style="padding-left: 20px;width: 87%;">
									<html:text property="iTEMMTNTO" styleClass="form-control" style="width: 5%;" readonly="true" maxlength="2"></html:text>
								</td>
							</tr>
							<tr>
								<td class="body-main-label">
									<div class="body-main-label-text"><label class="my-label2">氏名・通名</label></div>
								</td>
								<td style="padding-left: 20px;width: 87%;">
									<html:text property="eMPFLEMPNM" styleClass="form-control" style="width: 8%;" readonly="true"  maxlength="5"></html:text>
								</td>
							</tr>
							<tr>
								<td class="body-main-label">
									<div class="body-main-label-text"><label class="my-label2">ＤＣＣ名称</label></div>
								</td>
								<td style="padding-left: 20px;width: 87%;">
									<html:text property="dCCFLNAME" styleClass="form-control" style="width: 37%;" readonly="true" maxlength="25"></html:text>
								</td>
							</tr>
							<tr>
								<td class="body-main-label">
									<div class="body-main-label-text"><label class="my-label2">修正前・品名</label></div>
								</td>
								<td style="padding-left: 20px;width: 87%;">
									<html:text property="iTEMMHNME" styleClass="form-control" style="width: 37%;" readonly="true" maxlength="25"></html:text>
								</td>
							</tr>
							<tr>
								<td class="body-main-label">
									<div class="body-main-label-text"><label class="my-label2">修正後・品名</label></div>
								</td>
								<td style="padding-left: 20px;width: 87%;">
									<html:text property="iTEMMHNME" styleClass="form-control" style="width: 37%;" readonly="true" maxlength="25"></html:text>
								</td>
							</tr>
							<tr>
								<td class="body-main-label">
									<div class="body-main-label-text"><label class="my-label2">修正前メーカー名</label></div>
								</td>
								<td style="padding-left: 20px;width: 87%;">
									<html:text property="mAKERDATA" styleClass="form-control" style="width: 10%;" readonly="true" maxlength="6"></html:text>
								</td>
							</tr>
							<tr>
								<td class="body-main-label">
									<div class="body-main-label-text"><label class="my-label2">修正後ﾒｰｶｰ・コード</label></div>
								</td>
								<td style="padding-left: 20px;width: 87%;">
									<html:text property="iTEMMMKCD" styleClass="form-control" style="width: 5%;" readonly="true" maxlength="2"></html:text>
								</td>
							</tr>
							<tr>
								<td class="body-main-label">
									<div class="body-main-label-text"><label class="my-label2">修正前・車種名</label></div>
								</td>
								<td style="padding-left: 20px;width: 87%;">
									<html:text property="cARNMNAME" styleClass="form-control" style="width: 15%;" readonly="true" maxlength="10"></html:text>
								</td>
							</tr>
							<tr>
								<td class="body-main-label">
									<div class="body-main-label-text"><label class="my-label2">修正後車種コード</label></div>
								</td>
								<td style="padding-left: 20px;width: 87%;">
									<html:text property="iTEMMSYCD" styleClass="form-control" style="width: 4%;" readonly="true" maxlength="1"></html:text>
								</td>
							</tr>
							<tr>
								<td class="body-main-label">
									<div class="body-main-label-text"><label class="my-label2">ﾛｯﾄ別単価適用ﾏｰｸ</label></div>
								</td>
								<td style="padding-left: 20px;width: 87%;">
									<html:text property="iTEMMTNKMK" styleClass="form-control" style="width: 4%;" readonly="true" maxlength="1"></html:text>
								</td>
							</tr>
							<tr>
								<td class="body-main-label">
									<div class="body-main-label-text"><label class="my-label2">ﾊﾟｰﾂ化年度（ﾗｲﾝ=0）</label></div>
								</td>
								<td style="padding-left: 20px;width: 87%;">
									<html:text property="iTEMMPART" styleClass="form-control" style="width: 7%;text-align-last: end;" readonly="true" maxlength="4"></html:text>
								</td>
							</tr>
						</table>
						<br>
					</div>
				</div>
				<div class="body-button col-sm-12">
					<div style="margin: 10px 0 0 69%;">
						<button class="m-btn m-btn-success my-btn" style="width: 69px;height: 34px;margin-left: 10px;">'更新(U)</button>
						<input type="button" class="m-btn m-btn-success my-btn" style="width: 110px;height: 34px;margin-left: 10px;" value="'クリアー(R)"/>
						<button class="m-btn m-btn-success my-btn" style="width: 120px;height: 34px;margin-left: 10px;">エクスポート(E)</button>
					</div>
				</div>
				</html:form>
			</div>
		<div class="footer">
		</div>
		</div>
	</div>
</body>
<script>
	$( document ).ready(function() {
		var message = $("#message").text();
		var x = document.getElementById('infoForm');
		if(message.length == 0){
			x.style.display = 'block';
		}
		if(message.length > 0){
			x.style.display = 'none';
		}
	});
</script>
</html>