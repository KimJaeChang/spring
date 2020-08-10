<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>댓글 상세보기</title>
</head>
<body>
<section>
<div class="table-responsive">
  <table class="table">

	<form>
	<div class="form-group1">
<table>
<c:forEach var="boardreply" items="${list}">
<tr>
<td>작성자 : ${boardreply.rewriter}    작성일자 : ${boardreply.redate} </td>
</tr>
<tr>
<td><textarea name="rememo" rows="5" cols="40"
		readonly="readonly" class="form-control1">
${boardreply.rememo}</textarea></td>
<td><button type="button" class="btn btn-default" >댓글수정</button>
<a href="replyupdate?bno=${boardreply.bno}&reno=${boardreply.reno}">댓글수정</a>
</td>
</tr>
</c:forEach>
</table>
</div>
	<script>
	$(function(){
		//댓글수정 버튼을 눌렀을 때 처리
		$(".btn-default").click(function(){
		//	location.href="replyupdate?bno=" + ${boardreply.bno} + "&reno=" + ${boardreply.reno}; 
		});
	});
	</script>

</form>	

</section>		

</body>
</html>