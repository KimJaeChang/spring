<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>목록</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
<body>

<%@include file ="include/header.jsp"%>
   <div>${msg}</div>
   <div class="table-responsive">
      <table class="table">
         <tr>
            <td>글번호</td>
            <td>제목</td>
            <td>작성일</td>
            <td>작성자</td>
            <td>조회수</td>
         </tr>
         <!-- c:forEach :List, 배열 요소를 순서대로 반복해서 처리할 수 있는 태그-->
         <c:forEach var="board" items="${board}">
            <tr>
               <td>${board.bno}</td>
               <td><a href="detail?bno=${board.bno}"> ${board.title} </a></td>
               <td>${board.regdate}</td>
               <td>${board.id}</td>
               <td><span class="badge">${board.readcnt}</span></td>
            </tr>
         </c:forEach>
         <tr>
            <td colspan="5" align="center"><input
               class="btn-write" type="button" value="글쓰기" id="write" />
            </td>
         </tr>
      </table>
   </div>
<div class="box-footer">
   <div id="text-center">
      <ul class="pagination">
         <c:if test="${pageMaker.prev}">
            <li><a href="${contextPath}/board/list?page=${pageMaker.startPage-1}">이전</a></li>
         </c:if>
         <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
            <li <c:out value="${pageMaker.criteria.page == idx ?'class=active' : ''}"/>>
            <a href="${contextPath}/board/list?page=${idx}">${idx}</a>
            </li>
         </c:forEach>
         <c:if test="${pageMaker.next && pageMaker.endPage>0}">
            <li><a href="${contextPath}/board/list?page=${pageMaker.endPage+1}">다음</a></li>
         </c:if>
      </ul>
   </div>
   
</div>
<div class ="box-footer">
	<div class ="form-group col-sm-2">
		<select class ="form-control" name ="searchType" id ="searchType">
			<option value ="n" <c:out value ="${searchCriteria.searchType ==null?'selected' : ''}"/>>::::선택:::</option>
			<option value ="t" <c:out value ="${searchCriteria.searchType =='t'?'selected' : ''}"/>>제목</option>
			<option value ="c" <c:out value ="${searchCriteria.searchType =='c'?'selected' : ''}"/>>내용</option>
			<option value ="w" <c:out value ="${searchCriteria.searchType =='w'?'selected' : ''}"/>>작성자</option>
			<option value ="tc" <c:out value ="${searchCriteria.searchType =='tc'?'selected' : ''}"/>>제목 +내용</option>
			<option value ="cw" <c:out value ="${searchCriteria.searchType =='cw'?'selected' : ''}"/>>내용+작성자</option>
			<option value ="tcw" <c:out value ="${searchCriteria.searchType =='tcw'?'selected' : ''}"/>>제목 +내용+작성자</option>
			</select>
	</div>	
</div>


</body>
<script>
$(function(){
   //글쓰기 버튼을 눌렀을 때 처리
   $(".btn-write").click(function(){
      location.href="register";
   });
   
})
   
</script>


</html>