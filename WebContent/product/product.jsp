<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*, domain.Product"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!-- Custom Theme files -->
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all" />
<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all" /><!-- 없어도될듯 -->
<link href="css/main.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/product.css" rel="stylesheet" type="text/css" media="all" />
<style>
{ margin: 0px; padding: 0px; }
body {
	font-family: "Open Sans", sans-serif; 
	overflow:scroll;
	text-decoration: none;	
	
}
#grid{	
	width: 1335px;
	position: absolute;
	left: 340px;
	height: 1200px;
	top: 180px;
}

.default-image{
	width: 50%
	
}

.hover-image{
	width: 50%;
	
}
.o-product{
text-align: center;
margin: 0 auto;

}


a{
	text-decoration: none;
	font: 13px "Malgun Gothic", Malgun Gothic, Malgun Gothic;
}

.description {
    display: inline-block;
    max-width: 100%;
    margin-bottom: 5px;
    font-weight: 200;
    font-size: 15px;
}



.image-if-hover img:last-child{display:none}
.image-if-hover:hover img:first-child{display:none}
.image-if-hover:hover img:last-child{display:inline-block}
</style>

<body>

<%
	

	ArrayList<Product> list = (ArrayList<Product>)request.getAttribute("list"); 
    System.out.println("#list: " + list);
	if(list !=null && list.size()!=0){
	    for(Product product : list){
	    	
%>



<div class="column">
   <a href="product/product.do?m=detail&pd_id=<%=product.getPd_id() %>" target="_self" class="a-link no-styling"><!-- href 수정요 -->
      <div class="o-product">	
         <div class="image-holder">
                       
            <div class="image-if-hover">
                 <div class="m-product-image">
                     <img class="default-image" src="<%=product.getPd_thumbnail()%>"
                            alt="<%=product.getPd_name()%>">
                     <img class="hover-image" src="<%=product.getPd_hover()%>" 
                            alt="<%=product.getPd_name()%>">
                 </div>
             </div>
         </div>
          <br>
          <br>
         <div class="description">      
            <label class="product-disc"><%=product.getPd_name()%></label>
            <br><%=product.getPd_price()%>
			</label>
         </div>
      </div>

   </a>                  
<%
		}
	}else{
%>
			<tr>
				<td align='center' colspan="4" >등록된 상품이 존재하지 않습니다.</td>
			</tr>
<%
	}
%>

  </section>


  </main>
  

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
                  <div class="big" href="../index.do">2nd</div>
               </div>

            </div>
         </div>
      </section>
   </nav>


   <!-- NAVIGATION -->
   <div class="navigation">
      <button class="navigation-login">
      <c:choose>
           <c:when test="${empty loginPassUser.name}">
            <a href="../signup/signup.jsp"> SIGN UP </a>
      </c:when>
        <c:otherwise>
           <a href="../main/main.do?m=logout">LOGOUT</a>
           <a href="../mypage/mypage.do?m=list&ct_id=${loginPassUser.ct_id}">MYPAGE</a>   
           환영합니다 ${loginPassUser.name} 님
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
<script src='js/list.js'></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.0/handlebars.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="js/main.js"></script>
</body>