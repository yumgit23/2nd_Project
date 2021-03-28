<%@ page language="java" contentType="text/html; charset=utf-8"
    import="java.util.*, mvc.domain.Orders"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="../css/mypage.css" rel="stylesheet" type="text/css" media="all" />
<!-- <script src='../js/mypage.js'></script> -->
<header id="site-header">
   <div class="container">
      <h1>MyPage <span>[</span> <em><a href="#" target="_blank">${id}님의 장바구니입니다.</a></em> <span class="last-span is-open">]</span></h1>
   </div>
</header>

<div class="container">

   <section id="cart"> 
   <c:forEach var='m' items="${list}">
      <article class="product">
         <header>
            <a class="remove" href="mypage.do?m=del&od_id=${m.od_id}&ct_id=${id}">
               <img src="${m.pd_thumbnail}" alt="">

               <h3>Remove product</h3>
            </a>
         </header>

         <div class="content">

            <h1>${m.pd_name}</h1>

            ${m.pd_disc}

            <div title="You have selected this product to be shipped in the color sliver." style="top: 0" class="color sliver"></div>
            <div style="top: 43px" class="type small">1</div>
         </div>

         <footer class="content">
            <span class="qt-minus" ><a href="mypage.do?m=update_m&od_id=${m.od_id}&ct_id=${id}">-</a></span>
            <span class="qt">${m.od_pd_quantity}</span>
            <span class="qt-plus"><a href="mypage.do?m=update_p&od_id=${m.od_id}&ct_id=${id}">+</a></span>

            <h2 class="full-price">
               ${m.od_pd_price*m.od_pd_quantity}\
            </h2>

            <h2 class="price">
               ${m.od_pd_price}\
            </h2>
         </footer>
      </article>
   </c:forEach>
   </section>

</div>

<footer id="site-footer">
   <div class="container clearfix">
   <%-- <c:if test="${empty list}">
      <script>
          장바구니가 비었어여
      </script>
   </c:if> --%>
   <c:set var="m" value="${dto}"/>
      <div class="left">
         <h2 class="subtotal">Subtotal: <span><c:out value="${m.od_pd_price*m.od_pd_quantity}"/></span>\</h2>
         <h3 class="tax">Discount (coupon): <span>0</span>\</h3>
         <h3 class="shipping">Shipping: <span><c:out value="${m.deliveryfee}"/></span>\</h3>
      </div>

      <div class="right">
         <h1 class="total">Total: <span>${m.totalprice + m.deliveryfee}</span>\</h1>
         <a class="btn">결제하기</a>
      </div>
   </div>
</footer>