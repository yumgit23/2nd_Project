    <%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*, mvc.domain.Qna"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<link href="../css/write.css" rel="stylesheet" type="text/css" media="all" />
<script src='js/main.js'></script>
<!-- Custom Theme files -->

<html>
  <head>
    <meta charset="utf-8">
    <title>작성하기</title>
  
	<script language="javascript">
	   function check()
	   {
	       for(var i=0; i<document.input.elements.length; i++)
		   {
		      if(document.input.elements[i].value == "")
			  {
			     alert("모든 값을 입력 하셔야 합니다. ");
				 return false;
			  }
		   }
		   document.input.submit();
       }
	</script>
  </head>
  <!-- 본문 시작 -->
<body>
			<br>
			<br>
<a href='../index.do?m=board' type= "button" class="btn">LIST</a>
			&nbsp;&nbsp;&nbsp;
			<a href='../' type= "button" class="btn">HOME</a>
			<br>
			<br>
</div>
	<form name="input" method="post" action="qna.do?m=insert">
<input type="hidden" name="boardCd" value="chat" />
<table id="write-form" class="bbs-table">


<tr>
    <td>제목</td>
    <td><input type="text" name="qna_title" style="width: 90%;" /></td>
</tr>
<tr>
	<td align="center">작성자</td>
			 <div class="ui inverted input">
			 <td><input type="text" value="${loginPassUser.ct_id}" name="ct_id" size="80" readonly="readonly"></td>
			 </div>
</tr>
<tr>
    <td colspan="2">
        <textarea name="qna_content" rows="17" cols="50"></textarea>
    </td>
</tr>

</table>
			<br>
<div style="text-align: center;padding-bottom: 15px;">
    <input type="submit" value="전송" type="button" class="btn"/>&nbsp;&nbsp;

</div>
</form>
<!-- 본문 끝 -->
  </body>
</html>




