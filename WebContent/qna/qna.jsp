    <%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*, mvc.domain.Qna"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<link href="css/board.css" rel="stylesheet" type="text/css" media="all" />  
<link href="css/main.css" rel="stylesheet" type="text/css" media="all" />  
<script src='js/main.js'></script>
<!-- 본문 시작 -->

<link href="../css/list.css" rel="stylesheet" type="text/css" media="all" />
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all" />
<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all" />
<link href="../css/main.css" rel="stylesheet" type="text/css" media="all" />


<style>
body{
	 margin: 300;
	 font: 12px "Malgun Gothic", Malgun Gothic, Malgun Gothic;
}
.btn{
	border: 1px solid #000;
	background: #000;
	color: #fff;
	padding: 5px 15px;
	box-sizing: border-box;
	transform: translateY(1px);
	transition: all 0.3s;
	font-size: 1em;
	text-decoration: 	none;
}

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


<table class="bbs-table" table style="margin-left: auto; margin-right: auto;">
<!--  게시판 목록 머리말 -->
<h3> Q&A </h3>
<tr id = "t1">

    <td style="width: 60px;">NO</td>
    <td>PRODUCT</td>
    <td>TITLE</td>
    <td>NAME</td>
    <td style="width: 84px;">DATE</td>
    
    <c:choose>
      <c:when test="${empty loginPassUser.ct_id}">
         로그인후에 글쓰기 가능
      </c:when>
   <c:otherwise>
      <a href='../qna/qna.do?m=write&ct_id=${loginPassUser.ct_id}'>글쓰기</a><br/>
   </c:otherwise>
  </c:choose>
</tr>
<!-- 반복 구간 시작 안되면 식으로 바꾸기-->

<tr>
	<c:forEach var='m' items="${list}">
	    <TR align='center' noshade>
			<TD>${m.qna_id}</TD>
			<TD>${m.ct_id}</TD>
		    <TD>
		      <a href="../qna/qna.do?m=content&qna_id=${m.qna_id}"> ${m.qna_title}</a>
			</TD>
			
			<TD>${m.qna_date}</TD>
		   </TR> 
	</c:forEach>
 



<!-- 반복구간 끝 -->
</table>
<br>
<!-- 
<div id="paging">
    <a href="#">Previus</a>
    <span class="bbs-strong">6</span> 
    <a href="#">7</a>
    <a href="#">8</a>
    <a href="#">9</a>
    <a href="#">10</a>
    <a href="#">Next</a>
</div> -->
<br>
<div id="list-menu">

     <a href="write.jsp" type="button" class="btn">새 글쓰기</a>
</div>

<!--  본문 끝 -->

   <!-- NAVIGATION -->
   <div class="navigation">
      <button class="navigation-login">
      <c:choose>
           <c:when test="${empty loginPassUser.name}">
            <a href="main/main.do?m=signup"> SIGN UP </a>
      </c:when>
        <c:otherwise>
           <a href="main/main.do?m=logout">LOGOUT</a>
           <a href="mypage/mypage.do?m=list&ct_id=${loginPassUser.ct_id}">MYPAGE</a>   
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
            <li><a href="index.do?m=board">COMMUNITY</a></li>
            <li><a href="mypage/mypage.do?m=list">CART</a></li>
            <li><a href="#">MY PAGE</a></li>
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