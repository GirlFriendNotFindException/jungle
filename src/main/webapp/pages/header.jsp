<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"  >
   	<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 	<link href="assets/css/bootstrap-responsive.css" rel="stylesheet">
 -->    <!-- Bootstrap -->
    <link href="../css/bootstrap.css" rel="stylesheet" media="screen">
    <link href="../css/style.css" rel="stylesheet" >
    <link rel="stylesheet" href="../css/login.css" />
    <link href="../css/bootstrap-datetimepicker.css" rel="stylesheet" >
    <script src="../js/jquery-1.9.1.js"></script>
    <script src="../js/util.js"></script>
    <script src="../js/bootstrap-datetimepicker.js"></script>
    <script src="../js/locales/bootstrap-datetimepicker.zh-TW.js"></script>
    <script src="../js/bootstrap.js"></script>
  </head>
 
   <body data-spy="scroll" data-target=".bs-docs-sidebar">

<header class="navbar navbar-static-top bs-docs-nav" id="top" >
  <div class="container">
    <div class="navbar-header">
      <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target="#bs-navbar" aria-controls="bs-navbar" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
    </div>
    <nav id="bs-navbar" class="collapse navbar-collapse">
      <ul class="nav navbar-nav">
        <li>
          <a href="" onclick="">首页</a>
        </li>
        <li>
          <a href="scoring.jsp" onclick="">评分</a>
        </li>
        <li>
          <a href="judges.jsp" onclick="">评委信息</a>
        </li>
        <li >
          <a href="competitor.jsp" onclick="">选手信息</a>
        </li>
        <li>
          <a href="record.jsp" onclick="">得分记录</a>
        </li>
        <li class="active">
         <a href="admin.jsp" onclick="" >管理员</a>
        </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <!-- <li><a href=" onclick="" target="_blank">主题/模板</a></li> -->
        <li><a   id="Login_start_" style="text-align: right">登录&emsp;|&emsp;</a></li>
        <li><a   id="Regist_start_" style="text-align: left">注册</a></li>
        <li><a   id="competitionFnumber" style="display:none">aa</a></li>
      </ul>
    </nav>
  </div>
</header>
		<div class="loginAndregist" id='loginAndregist'>
			<%@ include file="login.jsp"%>
		</div>
		
<body>

