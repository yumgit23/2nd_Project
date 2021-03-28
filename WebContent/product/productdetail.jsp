<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, domain.Customer, domain.Product, domain.Qna"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script src='js/main.js'></script>

<!-- Custom Theme files -->
<link href="css/main.css" rel="stylesheet" type="text/css" media="all" />  
<link href="css/productdetail.css" rel="stylesheet" type="text/css" media="all" /> 


<style>
.title {	text-decoration: none; font: 14px "Malgun Gothic", Malgun Gothic, Malgun Gothic;
	text-align:center;}
.row {	text-align: center;	margin: 30px 500px 0px 400;	width: 20%;	}
.img-fluid{	width: 720px;	height:	1080px;}
#tothetop { position: fixed; bottom: 1rem; right: 1rem; cursor: pointer; 
font-size:24px; color:black; text-decoration: none;}
.btn{
	border: 1px solid #000;
	background: #000;
	color: #fff;
	padding: 15px 15px;
	box-sizing: border-box;
	transform: translateY(1px);
	transition: all 0.3s;
	font-size: 1em;
	text-decoration: 	none;
}
</style>


<!DOCTYPE html>
<html lang="en">

<head>
  <title>2nd</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>

<body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">
  <div class="site-wrap">

<%	
    ArrayList<Product> contents = (ArrayList<Product>)request.getAttribute("contents");
    if(contents !=null && contents.size()!=0){
        for(Product product : contents){
%>
    
    <div class="title" id="backpoint">
      <div class="container">

      
        <h1><%=product.getPd_name()%></h1>
        <p><%=product.getPd_price()%></p>
        <p><%=product.getPd_disc()%></p>
        <br>
        <br>
     <!-- pd_id안넘어감 -->
        <a href='../index.do?m=board&pd_id=<%=product.getPd_id() %>' type= "button" class="btn">문의하기</a>&nbsp;	
        <c:choose>
                    <c:when test="${empty loginPassUser.name}">
                       로그인 후에 장바구니 가능
                    </c:when>
                 <c:otherwise>
                     <a href='../mypage/mypage.do?m=add&pd_id=<%=product.getPd_id()%>&pd_price=<%=product.getPd_price()%>&ct_id=${loginPassUser.ct_id}' type= "button" class="btn">장바구니에 담기</a>
                 </c:otherwise>
                </c:choose>
       
        <br>
        <br>
        <br>
      </div>
    </div>

    <div class="site-section mt-5" >
      <div class="container">
        <div class="row">
          <div class="col-lg-6">
            <div class="owl-carousel hero-slide owl-style">
              <img src="<%=product.getPd_thumbnail()%>" alt="Image" class="img-fluid">
              <img src="<%=product.getPd_hover()%>" alt="Image" class="img-fluid">
              <img src="<%=product.getPd_infoimg()%>" alt="Image" class="img-fluid">
            </div>
          </div>
     
      


<%
		}
	}else{
%>
			<tr>
				<td align='center' colspan="4" >데이터가 없음</td>
			</tr>
<%
	}
%>

	<!-- 문의 및 리뷰게시판 -->
	
	
        </div>
        
      </div>
<a href="#backpoint" id="tothetop">TOP</a>

      