<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*, mvc.domain.Customer.*, mvc.domain.Orders"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all" />
<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all" /><!-- 없어도될듯 -->
<link href="css/main.css" rel="stylesheet" type="text/css" media="all" />




<style>
.navigation-login{
	background-color: black;
	font-size: 3rem;
	font-weight: 700;
}
.container-menu{
	margin:15px;
}
a {
  text-decoration: none;
  text-color: #ffffff;
  margin:10px;
  
  
}

</style>
<body>
<div class="site-outer">
   <nav class="navbar navbar-fixed-top">
      <section class="container-fluid">
         <div class="row">
            <div class="container-menu">
               <nav class="menu" id="hb">
                  <div></div>
                  <div></div>
                  <div></div>
               </nav>
               <div class="logotype">
                  <div class="big">2nd</div>
               </div>
               <div class="checkout">
               <c:choose>
                    <c:when test="${empty loginPassUser.name}">
                       <form action="main/main.do?m=login" method="post">
                           <input class="input" name="ct_id" type="text" placeholder="ID" class="email text-input">    
                           <input class="input" name="ct_pw" type="text" placeholder="Password" class="password text-input">
                       <button class="button" type="submit">Sign In</button>                       
                    </form>
                    </c:when>
                 <c:otherwise>
                    <a href="main/main.do?m=logout">LOGOUT</a>
                    <a href="mypage/mypage.do?m=list&ct_id=${loginPassUser.ct_id}">MYPAGE</a>   환영합니다 ${loginPassUser.name} 님
                 </c:otherwise>
                </c:choose>
                  
               </div>
            </div>
         </div>
      </section>
   </nav>
   <div class="site-inner">
      <section class="container-fluid">
         <!-- ACCORDION ROW -->
         <div class="row">
               <ul class="accordion-group" id="accordion">
                  <li style="background-image: url('https://image.thehyundai.com/static/3/5/6/26/A1/hnm40A1266530_02_0939474_001_001_720.jpg');">
                     <div class="accordion-overlay"></div>
                     <section class="hidden-xs">
                        <article>
                           <p>Modern and Simple</p>
                        </article>
                     </section>
                  </li>
                  <li class="out" style="background-image: url('https://image.thehyundai.com/static/9/3/0/26/A1/hnm40A1260395_02_0939477_001_001_720.jpg');">
                     <div class="accordion-overlay"></div>
                     <section class="hidden-xs">
                        <article>
                           <p>For the single or couple
                           </p>
                        </article>
                     </section>
                  </li>
                  <li style="background-image: url('https://image.thehyundai.com/static/1/6/2/26/A1/hnm40A1262619_01_0926761_001_001_720.jpg');">
                     <div class="accordion-overlay"></div>
                     <section class="hidden-xs">
                        <article>
                           <p>When people want it stylish</p>
                        </article>
                     </section>
                  </li>
                  <li style="background-image: url('https://image.thehyundai.com/static/1/6/2/26/A1/hnm40A1262616_01_0926764_001_001_720.jpg');">
                     <div class="accordion-overlay"></div>
                     <!--<h3>Family</h3>-->
                     <section class="hidden-xs">
                        <article>
                           <p>For the family dinner</p>
                        </article>
                     </section>
                  </li>
               </ul>
         </div>
      </section>
   </div>

   <!-- NAVIGATION -->
   <div class="navigation">
      <button class="navigation-login">
      <c:choose>
           <c:when test="${empty loginPassUser.name}">
            <a href="main/main.do?m=signup"> SIGN UP </a>
      </c:when>
        <c:otherwise>
           <a href="main/main.do?m=logout">LOGOUT</a>
           ${loginPassUser.name} 님
        </c:otherwise>
       </c:choose>
      </button>
   <!--   <div class="navigation-search">
         <div id="search">
            <input type="text" name="input" class="input" placeholder="Search" />
            <button type="reset" class="search" id="search-button"></button>
         </div>
      </div> --> 
      <div class="navigation-content">
         <ul class="navigation-menu">
            <li><a href="index.do?m=list">SHOP</a></li>
            <li><a href="aboutus.jsp">ABOUT US</a></li>
            <li><a href="qna/qna.do?m=list">COMMUNITY</a></li>
            <li><a href="mypage/mypage.do?m=list">MY PAGE</a></li>

         </ul>
      </div>
   </div>

</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.0/handlebars.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="js/main.js"></script>

</body>