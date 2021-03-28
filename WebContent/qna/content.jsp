<%@ page language="java" contentType="text/html; charset=utf-8"
    import="java.util.*, mvc.domain.Qna"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<meta charset="utf-8">
<center>
<%	
	Qna dto = (Qna)request.getAttribute("content");	
%>


	<hr width='600' size='2' color='gray' noshade>
	<h3>상품문의</h3>

	<a href='mem.do?m=input'>가입하기</a>

	<hr width='600' size='2' color='gray' noshade>

<table border='2' width='600' align='center' noshade>
	<tr>
		<td width='20%' align='center'>No</td>
		<td><%=dto.getQna_id()%></td>
	</tr>
	<tr>
		<td width='20%' align='center'>작성자</td>
		<td><%=dto.getCt_id()%></td>
	</tr>
	<tr>
		<td align='center'>문의 제목</td>
		<td><%=dto.getQna_title()%></td>
	</tr>
	<tr>
		<td align='center'>문의 내용</td>
		<td><%=dto.getQna_content()%></td>
	</tr>
	<tr>
		<td align='center'>작성일</td>
		<td><%=dto.getQna_date()%></td>
	</tr>
</table>

<hr width='600' size='2' color='gray' noshade>

	<a href='qna.do?m=del&qna_id=<%=dto.getQna_id()%>'>삭제</a>
	 &nbsp;&nbsp;| 
	<a href='qna.do'>목록</a>
	
<c:choose>
      <c:when test="${loginPassUser.ct_id =='관리자'}">	
	<h3>답변달기</h3>
	<form name="input" method="post" action="../qna/qna.do?m=insert_re&qna_mgrp=<%=dto.getQna_mgrp()%>">
	   <table border="0" width="600" align="center"  cellpadding="3" cellspacing="1" bordercolor="white">
	      <tr>
		     <td width="30%" align="center">답변제목</td>
			 <div class="ui inverted input">
			 <td><input type="text" value="[re]답변입니다." name="qna_title" size="80"></td>
			 </div>
		  </tr>
		  <tr>
		     <td align="center">작성자</td>
			 <div class="ui inverted input">
			 <td><input type="text" value="관리자" name="ct_id" size="80" readonly="readonly"></td>
			 </div>
		  </tr>
		  <tr>
		     <td align="center">답변내용</td>
			 <div class="ui field">
			 <td><textarea  name="qna_content" rows="14" cols="73.5"></textarea></td>
			 </div>
		  </tr>
		  <tr>
		     <td colspan="2" align="center">
			    <input type="submit" value="전송"  >
				<input type="reset" value="다시입력" onclick="input.writer.focus()">
			 </td>
		  </tr>
	   </table>
	   <hr width="600" size="2" color="white" noshade>
	</form>
	</c:when>
   <c:otherwise> <!-- 여기 기능 안됨 -->
   <c:if test="${loginPassUser.ct_id}==<%=dto.getQna_id()%>">
   	<a href='qna.do?m=del&qna_id=<%=dto.getQna_id()%>'>삭제</a>
   	</c:if>
    </c:otherwise>
  </c:choose>
</font>
<hr width='600' size='2' color='gray' noshade>
</center>
