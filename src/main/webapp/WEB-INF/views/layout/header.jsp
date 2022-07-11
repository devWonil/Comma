<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal" />
</sec:authorize>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Shop Homepage - Start Bootstrap Template</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link href="../css/style.css" rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<link rel="stylesheet" href="../css/icomoon/style.css">
<link href="../css/main.550dcf66.css" rel="stylesheet">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>

<!-- 테스트 -->
<meta name="userid" id="1" />
<meta name="hostid" id="2" />
<meta name="houseid" id="3" />

</head>

<body>
	<input id="isNaviFocus" type="hidden" value=0 />
	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark fiexed-top">
		<div id="naviBar" class="container fixed-top"
			style="background-color: #1763e9; width: 100%;">
			<a class="navbar-brand text-warning" href="#">JMT HOUSE</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item" style="margin-right: 10px;"><a
						class="nav-link" href="/"><span class="icon-home2"></span>&nbsp;&nbsp;Home</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="/"><span
							class="icon-list-alt"></span>&nbsp;&nbsp;ssss</a></li>
					<li id="user-content" class="nav-item"
						style="position: relative; left: 700px;"><a
						class="btn nav-link"><span class="icon-user-circle"></span>&nbsp;&nbsp;user</a>
						<div id="user-table" class="list-group"
							style="width: 180px; font-size: 20px; position: fixed; left: 75%; top: 7%;">
							<input id="isUserTable" type="hidden" value=0 />
							<button type="button"
								class="list-group-item list-group-item-action">
								<span class="icon-drivers-license-o"></span>&nbsp;&nbsp;로그인
							</button>
							<button type="button"
								class="list-group-item list-group-item-action">
								<span class="icon-user-plus"></span>&nbsp;&nbsp;회원가입
							</button>
							<button type="button"
								class="list-group-item list-group-item-action">
								<span class="icon-black-tie"></span>&nbsp;&nbsp;호스트 되기
							</button>
							<button type="button"
								class="list-group-item list-group-item-action">
								<span class="icon-shopping-bag"></span>&nbsp;&nbsp;예약 확인
							</button>
							<button type="button"
								class="list-group-item list-group-item-action">
								<span class="icon-users"></span>&nbsp;&nbsp;예약자 확인
							</button>
							<button type="button"
								class="list-group-item list-group-item-action">
								<span class="icon-handshake-o"></span>&nbsp;&nbsp;숙소 등록
							</button>
						</div></li>
				</ul>
			</div>
		</div>
	</nav>