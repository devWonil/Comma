<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form action="/auth/loginProc"  method="post">
<div class="d-lg-flex half">
    
    <div class="contents order-2 order-md-1">

      <div class="container">
        <div class="row align-items-center justify-content-center">
          <div class="col-md-7">
            <div class="mb-4">
              <h3>Sign In</h3>
              
            </div>
              <div class="form-group first">
                <label for="username">Username</label>
                <input type="text" class="form-control"  name="username" id="username">

              </div>
              <div class="form-group last mb-3">
                <label for="password">Password</label>
                <input type="password" class="form-control" name="password" id="password">
                
              </div>


</div>
</div>
</div>
              </div>
              </div>
              <button type="submit" id="btn-login" class="btn btn-primary">log in</button>
  </form>
              
  
   <script src="/js/user.js"></script>