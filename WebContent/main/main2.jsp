<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*, mvc.domain.Customer.*, mvc.domain.Orders"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="../css/main2.css" rel="stylesheet" type="text/css" media="all" />  
<!-- <link href="../css/main.css" rel="stylesheet" type="text/css" media="all" /> -->
  <nav>
  <div class="container">
    <ul class="navbar-left">
      <li><a href="index.do?m=list">SHOP</a></li>
      <li><a href="aboutus.jsp">ABOUT US</a></li>
      <li><a href="index.do?m=board">COMMUNITY</a></li>
      <li><a href="index.do?m=cart">장바구니</a></li>
      <li><a href="in.jsp">연습</a></li>
      
    </ul> <!--end navbar-left -->
	<div>   
     <form action="../main/main.do?m=login" method="post">
            <input name="ct_id" type="text" placeholder="ID" class="email text-input">
        
            <input name="ct_pw" type="text" placeholder="Password" class="password text-input">
        <button type="submit">Sign In</button>
     </form>    
    </div>
    <ul class="navbar-right">
    <c:choose>
         <c:when test="${empty loginPassUser.name}">
            <strong>로그인 하세요</strong>
            <li><a href="../signup/signup.jsp">SIGN UP</a></li>
         </c:when>
      <c:otherwise>
         <li><a href="../main/main.do?m=logout">LOGOUT</a></li>
         <li><a href="../main/main.do?m=cart&ct_id=${loginPassUser.ct_id}" id="cart"><i class="fa fa-shopping-cart"></i> Cart <span class="badge"></span></a></li>
         <li><a href="../mypage/mypage.do?m=list&ct_id=${loginPassUser.ct_id}">MYPAGE</a></li>   환영합니다 ${loginPassUser.name} 님
      </c:otherwise>
     </c:choose>
 
    </ul> <!--end navbar-right -->
  </div> <!--end container -->
</nav>


<div class="container">
  <div class="shopping-cart">
    <div class="shopping-cart-header">
      <i class="fa fa-shopping-cart cart-icon"></i><span class="badge"></span>
      <div class="shopping-cart-total">
        <span class="lighter-text">Total:</span>
        <span class="main-color-text">$2,229.97</span>
      </div>
    </div> <!--end shopping-cart-header -->

    <ul class="shopping-cart-items">
    <c:forEach var='m' items="${list}">
      <li class="clearfix">
        <img src="${m.pd_thumbnail}" alt="item1" />
        <span class="item-name">${m.pd_name}</span>
        <span class="item-price">${m.totalprice}\</span>
        <span class="item-quantity">Quantity: ${m.od_pd_quantity}</span>
      </li>
	</c:forEach>

   
    <a href="#" class="button">결제하기</a>
    </ul>
  </div> <!--end shopping-cart -->
</div> <!--end container --> 

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="../js/cart.js"></script>
</body>
 
 
 
 
  
  
  


