<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="include/header.jsp"%>

<section class="content">
	<div class="box-header">
		<h3 class="box-title">댓글 수정하기</h3>
	</div>
	<form role="form" method="post">
		<div class="box-body">
			<div class="form-group">
				<label>작성자</label> <input type="text" name='rewriter'
					class="form-control" value="${boardreply.rewriter}">
			</div>

			<div class="form-group">
				<label>댓글 내용</label>
				<textarea class="form-control" name="rememo" rows="3">${boardreply.rememo} </textarea>
			</div>

			<div class="form-group">
				<label>작성일자</label> <input type="text" name="id" class="form-control"
				readonly="readonly"	value="${boardreply.redate} ">
			</div>
			<!-- 수정에 사용할 글번호 -->
			<input type="hidden" name="bno" value="${boardreply.bno}" />
		</div>

		<div class="box-footer">
			<button type="submit" class="btn btn-complete">수정완료</button>
		</div>
	</form>
</section>
