<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  
<div class="container">
		<form action="/auth/hostJoinProc" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
  <div class="form-group">
    <label for="username">user name:</label>
    <input type="text" class="form-control" placeholder="Enter username" id="username" name="username">
  </div>
  <div class="form-group">
    <label for="password">Password:</label>
    <input type="password" class="form-control" placeholder="Enter password" id="password" name="password">
  </div>
  
  <div class="form-group">
    <label for="email">Email address:</label>
    <input type="email" class="form-control" placeholder="Enter email" id="email" name="email">
  </div>
  
    <div class="form-group">
    <label for="phoneNumber">phoneNumber:</label>
    <input class="form-control"  id="phoneNumber" name="phoneNumber">
  </div>
  	
  	<!-- <div class="container">

	                       
  <div class="dropdown">
    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
      숙박업소 선택
    </button>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="#">호텔</a>
      <a class="dropdown-item" href="#">모텔</a>
      <a class="dropdown-item" href="#">펜션</a>
      <a class="dropdown-item" href="#">게스트하우스</a>
    </div>
    
    <input type="text" value="">
  </div>
</div>
 -->
 	<label for="option">해당 업종 선택</label>
 	<select>
 			<option>호텔</option>
 			<option>모텔</option>
 			<option>펜션</option>
 			<option>게스트하우스</option>
 	</select>
  
  <br/><br/>
  <button id="btn-saveHost"  type="submit" class="btn btn-primary" >회원가입</button>
</form>
	</div>
	<br/>

<!-- <script src="/js/user.js"></script> -->
