<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!--  <script
	src="https://cdn.ckeditor.com/ckeditor5/20.0.0/classic/ckeditor.js"></script>-->
	<!-- ckediter --> 
	<script src="/resources/ckeditor/ckeditor.js"></script>
	
<link rel="stylesheet" type="text/css" href="rating.css">

<html>


<script>
$('.starRev span').click(function(){
	  $(this).parent().children('span').removeClass('on');
	  $(this).addClass('on').prevAll('span').addClass('on');
	  return false;
	});
</script>

<section class="content">
	<div class="box-header">
		<h3 class="box-title">건의사항 및 Q&A</h3>
	</div>

	<form role="form" method="post">
		<div class="box-body">
			<div class="form-group">
				<label>제목</label> <input type="text" name='title'
					class="form-control" placeholder="제목을 입력하세요">
			</div>
			<div class="form-group">
				<label>내용</label>
				<textarea class="form-control" id="content" name="content" rows="3"
					placeholder="내용을 입력하세요"></textarea>
			</div>

			<div class="form-group">
				<label>작성자</label> <input type="text" name="id" class="form-control"
					value="">
			</div>
		</div>

		<br>

		<div class="starRadio"> 별점: 
   <br><label class="starRadio__box">
        <input type="radio" name="rating" value ="1">
        <span class="star__img"><span class="blind"><img src="./resources/img/star.png" >별 1개</span></span>
    </label>

    <label class="starRadio__box">
        <input type="radio" name="rating" value="2">
        <span class="star__img"><span class="blind">별 2개</span></span>
    </label>

    <label class="starRadio__box">
        <input type="radio" name="rating" value="3">
        <span class="star__img"><span class="blind">별 3개</span></span>
    </label>

    <label class="starRadio__box">
        <input type="radio" name="rating" value="4">
        <span class="star__img"><span class="blind">별 4개</span></span>
    </label>

    <label class="starRadio__box">
        <input type="radio" name="rating" value="5">
        <span class="star__img"><span class="blind">별 5개</span></span>
    </label>

</div>

			
		<div class="box-footer">
			<button type="submit" class="btn btn-primary">작성완료</button>
			</div>

			</body>
	</form>

	<script>
		<src="${pageContext.request.contextPath}/resources/admin/js/ckeditor.js"></script>
</section>
</html>
