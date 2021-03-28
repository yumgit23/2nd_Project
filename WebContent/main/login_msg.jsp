<%@page import="ct.mvc.model.loginCase"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<script>
   if(${rCode} == <%=loginCase.NO_ID%>){
	   alert("로긴 실패( 없는 아이디 )");
   }else if(${rCode} == <%=loginCase.NO_PWD%>){
	   alert("로긴 실패( 틀린 비번 )");
   }else{
	   alert("로긴 성공");
   }
   
   location.href="../index.jsp";
</script>