<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*, mvc.domain.Customer.*, mvc.domain.Orders"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="../css/main.css" rel="stylesheet" type="text/css" media="all" />
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all" />
<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.0/handlebars.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="../js/main.js"></script>
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
                       <form action="../main/main.do?m=login" method="post">
                           <input class="input" name="ct_id" type="text" placeholder="ID" class="email text-input">    
                           <input class="input" name="ct_pw" type="text" placeholder="Password" class="password text-input">
                       <button class="button" type="submit">Sign In</button>                       
                    </form>
                    </c:when>
                 <c:otherwise>
                    <a href="../main/main.do?m=logout">LOGOUT</a>
                    <a href="../mypage/mypage.do?m=list&ct_id=${loginPassUser.ct_id}">MYPAGE</a>   환영합니다 ${loginPassUser.name} 님
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
                     <h3>Modern</h3>
                     <section class="hidden-xs">
                        <article>
                           <p>Modern and Simple</p>
                        </article>
                     </section>
                  </li>
                  <li class="out" style="background-image: url('https://image.thehyundai.com/static/9/3/0/26/A1/hnm40A1260395_02_0939477_001_001_720.jpg');">
                     <div class="accordion-overlay"></div>
                     <h3>Clean</h3>
                     <section class="hidden-xs">
                        <article>
                           <p>For the single or couple
                           </p>
                        </article>
                     </section>
                  </li>
                  <li style="background-image: url('https://image.thehyundai.com/static/1/6/2/26/A1/hnm40A1262619_01_0926761_001_001_720.jpg');">
                     <div class="accordion-overlay"></div>
                     <h3>Stylish</h3>
                     <section class="hidden-xs">
                        <article>
                           <p>When people want it stylish</p>
                        </article>
                     </section>
                  </li>
                  <li style="background-image: url('https://image.thehyundai.com/static/1/6/2/26/A1/hnm40A1262616_01_0926764_001_001_720.jpg');">
                     <div class="accordion-overlay"></div>
                     <h3>Family</h3>
                     <section class="hidden-xs">
                        <article>
                           <p>For the family dinner</p>
                        </article>
                     </section>
                  </li>
               </ul>
         </div>
         <!-- BEGIN NEW ROW AFTER ACCORDION -->
         <div class="row mg">
            <!-- FIRST ROW -->
            <div class="container">
               <h1 class="text-center head red">Quality</h1>
               <div class="row">
                  <div class="col-md-4 col-sm-6 col-xs-12">
                     <div class="product-box">
                        <h3 class="text-center">High quality</h3>
                        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
                     </div>
                  </div>
                  <div class="col-md-4 col-sm-6 col-xs-12">
                     <div class="product-box">
                        <h3 class="text-center">Smart design</h3>
                        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
                     </div>
                  </div>
                  <div class="col-md-4 col-sm-6 col-xs-12">
                     <div class="product-box">
                        <h3 class="text-center">Modern or retro</h3>
                        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </section>
   </div>
   <div class="footer">
      <footer class="footer-inner">
         <div class="container">
            <div class="row">
               <div class="col-md-3">
                  <h3 class="h3">About us</h3>
                  <ul class="footer-list">
                     <li><a href="#">Our story</a></li>
                     <li><a href="#">Venue</a></li>
                     <li><a href="#">Other</a></li>
                  </ul>
               </div>
               <div class="col-md-3">
                  <h3 class="h3">Partners</h3>
                  <ul class="footer-list">
                     <li><a href="#">IKEA</a></li>
                     <li><a href="#">MIO</a></li>
                     <li><a href="#">BAUHAUS</a></li>
                  </ul>
               </div>
               <div class="col-md-3">
                  <h3 class="h3">Customer support</h3>
                  <ul class="footer-list">
                     <li><a href="#">Chat with us</a></li>
                     <li><a href="#">+46(0)2453 352</a></li>
                     <li><a href="#">E-mail us</a></li>
                  </ul>
               </div>
               <div class="col-md-3">
                  <h3 class="h3">Socials</h3>
                  <ul class="footer-list footer-list-inline">
                     <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                     <li><a href="#"><i class="fa fa-instagram"></i></a></li>
                     <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                  </ul>
               </div>
            </div>
         </div>
      </footer>
   </div>
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
      <div class="navigation-search">
         <div id="search">
            <input type="text" name="input" class="input" placeholder="Search" />
            <button type="reset" class="search" id="search-button"></button>
         </div>
      </div>
      <div class="navigation-content">
         <ul class="navigation-menu">
            <li><a href="index.do?m=list">SHOP</a></li>
            <li><a href="aboutus.jsp">ABOUT US</a></li>
            <li><a href="index.do?m=board">COMMUNITY</a></li>
            <li><a href="index.do?m=cart">CART</a></li>
            <li><a href="#">MY PAGE</a></li>
         </ul>
      </div>
   </div>
   <!-- CHECKOUT -->
   <aside class="to-checkout">
      <div class="to-checkout-inner">
         <h3>Product list</h3>
         <ul class="to-checkout-list">
            <li><i class="fa fa-check"></i> Kitchens <a href="#" class="remove">Remove</a></li>
         </ul>
      </div>
   </aside>
   <!-- MODAL -->
   <aside id="modal" class="modal fade">
      <div class="modal-dialog" role="document">
         <div class="modal-content">
            <div class="modal-header">
               <div class="modal-header-gradient"></div>
               <div class="row">
                  <h2 class="white text-center">Choose size and color</h2>
                  <p data-modal-id class="text-center white"></p>
               </div>
            </div>
            <div class="modal-body">
               <div class="row">
                  <div class="col-md-8 col-md-offset-2 col-sm-12">
                     <form id="modal-form">
                        <div class="form-group">
                           <div class="input-group">
                              <span class="input-group-addon"><i class="fa fa-plus"></i></span>
                              <select>
                                                                  <option value="">Choose size</option>
                                                                  <option value="1">XS</option>
                                                                  <option value="2">S</option>
                                                                  <option value="3">M</option>
                                                                  <option value="4">L</option>
                                                                  <option value="5">XL</option>
                                                                  <option value="6">XXL</option>
                                                            </select>
                              <div class="input-group-addon-holder">
                                 <select class="select-sibling">
                                                                        <option value="">Choose color</option>
                                                                        <option value="1">Blue</option>
                                                                        <option value="2">Orange</option>
                                                                        <option value="3">Yellow</option>
                                                                  </select>
                              </div>
                           </div>
                        </div>
                        <div class="form-group">
                           <p>
                              <button class="button button-red" id="add-item" data-dismiss="modal">Add to basket</button>
                           </p>

                           <p>
                              <button type="reset" class="button button-transparent" data-dismiss="modal" id="cancel">Cancel</button>
                           </p>
                        </div>
                     </form>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </aside>
</div>n>