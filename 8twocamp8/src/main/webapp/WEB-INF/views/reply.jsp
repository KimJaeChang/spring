<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글쓰기</title>
</head>
<body>
<%@include file="include/header.jsp"%>
      
   <section class="content">
      <div class="box-header">
      <h3 class="box-title">댓글 쓰기</h3>
      </div>   
      <form role="form" method="post">
         <div class="box-body">
         <div class="form-group">
   <label>작성자</label> <input type="text" name="rewriter" >      
   <textarea class="form-control" name="rememo"  placeholder="댓글을 입력하세요."></textarea>
      </div>
               
<!-- 수정에 사용할 글번호 -->
   <input type="hidden" name="bno" value="${boardreply.reno}" />
         </div>
   <div class="box-footer">
 <button type="submit" class="btn btn-primary">작성완료</button>   
 
    
   </form>
   </section>
   
   </script>
   </body>
   </html>
         