<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��ٱ���</title>
</head>
<body>


<% 
    ArrayList foodList = (ArrayList)session.getAttribute("foodList");
 
    // ������ "fruit"�̶�� ���� ������ ���� ���� �Է�
    session.setAttribute("fruit", request.getParameter("fruit"));
    // session fruit������ ����� ���� selectedItem������ �Է�
    String selectedItem = (String)session.getAttribute("fruit");
     // �迭�� �� �Է�
    foodList.add(selectedItem);
     session.setAttribute("key", foodList);
    
    out.println("<script> alert('" + selectedItem + "�� ��ٱ��Ͽ� �����ϴ�.'); </script>");
    
%>


<script type="text/javascript">
    history.go(-1);
</script>




</body>
</html>