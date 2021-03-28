<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>장바구니</title>
</head>
<body>


<% 
    ArrayList foodList = (ArrayList)session.getAttribute("foodList");
 
    // 변수명 "fruit"이라는 곳에 폼에서 보낸 값을 입력
    session.setAttribute("fruit", request.getParameter("fruit"));
    // session fruit변수에 저장된 값을 selectedItem변수에 입력
    String selectedItem = (String)session.getAttribute("fruit");
     // 배열에 값 입력
    foodList.add(selectedItem);
     session.setAttribute("key", foodList);
    
    out.println("<script> alert('" + selectedItem + "가 장바구니에 담겼습니다.'); </script>");
    
%>


<script type="text/javascript">
    history.go(-1);
</script>




</body>
</html>