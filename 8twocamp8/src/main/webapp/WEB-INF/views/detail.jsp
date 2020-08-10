<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-Type" content="text/html; charset=UTF-8">
<title>상세보기</title>

</head>
<%@ include file="include/header.jsp"%>
<%// ajax문법 작성하는 곳 %>

<script>
$(document).ready(function(){
	console.log("1");	
	replyList(); //댓글 호출 기능	
});

//댓글 쓰기
$(document).on('click', '#btnReplySave', function(){
  var rememo = $('#rememo').val();
  var rewriter = $('#rewriter').val();

  var url = "${pageContext.request.contextPath}/board/reply";
  var paramData = {"rememo": rememo
        , "rewriter": rewriter
        , "bno":'${board.bno}'
  };      

  $.ajax({
     type: 'POST',
       url: url,
       data : paramData,
       dataType: 'json',
     success: function(result){
    	 replyList();
        
        $('#rememo').val('');
        $('#rewriter').val('');
     }
     , error: function(error){
        console.log("에러 : " + error);
     }
  });
});


//댓글 리스트	
function replyList(){
	var url = "${pageContext.request.contextPath}/board/replywrite";
	var paramData = {"bno" : "${board.bno}"};
	
	$.ajax({
        type: 'POST',
        url: url,
        data : paramData,
        dataType: 'json',
        success: function(result) {
           	var htmls = "";
			if(result.length < 1){
				htmls +="등록된 댓글이 없습니다.";
			} else {
				$(result).each(function(){
					htmls += '<div class="media text-muted pt-3" id="reno' + this.reno + '">';
					htmls += '<span class="d-block">';
					htmls += this.reno + ' - ';
					htmls += '<strong class="text-gray-dark">' + this.rewriter + '</strong>';
					htmls += '<span style="padding-left: 7px; font-size: 9pt">';
					htmls += '<a href="javascript:void(0)" onclick="fn_editReply(' + this.reno + ', \'' + this.rewriter + '\', \'' + this.rememo + '\' )" style="padding-right:5px">수정</a>';
					htmls += '<a href="javascript:void(0)" onclick="fn_deleteReply(' + this.reno + ')" >삭제</a>';
					htmls += '</span>';
					htmls += '</span><br>';
					htmls += this.rememo;
					htmls += '</p>';
					htmls += '</div>';		
				}); // each end				
			}
			$("#replyList").html(htmls);			
		},
		error:function(data){
			alert("에러가 발생했습니다.")
		}
		
	}); 

}

//댓글 업데이트
function fn_updateReply(reno, rewriter){
	   var editrememo = $("#editrememo").val();
	   
	   var url = "${pageContext.request.contextPath}/board/replyUpdate";//수정
	   var paramData = {"reno" : reno,
	         "rememo" : editrememo         
	   };  //수정

	   $.ajax({
	        type: 'POST',
	        url: url,
	        data : paramData,
	        dataType: 'json',
	        success: function(result) {
	          console.log(result);    
	             replyList();  // 댓글리스트 호출
	           
	        },
	        error:function(data){
	         alert("에러가 발생했습니다.")
	      }
	   });
	   
	}
	
function fn_editReply(reno,rewriter,rememo){
	   var htmls = "";

	   htmls += '<div class="media text-muted pt-3" id="reno' + reno + '">';

	   htmls += '<span class="d-block">';
	   htmls +=  reno + ' - ';
	   htmls += '<strong class="text-gray-dark">' + rewriter + '</strong>';
	   htmls += '<span style="padding-left: 7px; font-size: 9pt">';
	   htmls += '<a href="javascript:void(0)" onclick="fn_updateReply(' + reno + ', \'' + rewriter + '\')" style="padding-right:5px">저장</a>';
	   htmls += '<a href="javascript:void(0)" onClick="replyList()">취소<a>';
	   htmls += '</span>';
	   htmls += '</span>';      
	   htmls += '<textarea name="editrememo" id="editrememo" class="form-control" rows="3">';
	   htmls += rememo;
	   htmls += '</textarea>';
	   htmls += '</p>';

	   htmls += '</div>';   

	   $('#reno' + reno).replaceWith(htmls);  //  선택한 요소를 다른 것으로 바꿉니다.변경(바꾸기)
	   $('#reno' + reno + ' #editrememo').focus();


	}
	
//댓글 삭제
	function fn_deleteReply(reno){
	   var url = "${pageContext.request.contextPath}/board/replyDelete";
	   var paramData = {"reno" : reno};  //수정

	   $.ajax({
	        type: 'POST',
	        url: url,
	        data : paramData,
	        dataType: 'json',
	        success: function(result) {
	          console.log(result);    
	          replyList();  // 댓글리스트 호출
	           
	        },
	        error:function(data){
	         alert("에러가 발생했습니다.")
	      }
	   });
	}

</script>

<body>
	<section class="content">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">상세보기</h3>
			</div>
			<div class="box-body">
				<div class="form-group">
					<label>제목</label> <input type="text" name="title"
						class="form-control" value="${board.title}" readonly="readonly"
						size="80" />
				</div>

				<div class="form-group">
					<label>내용</label>
					<div style="width: 800px; height: 100px;">
						<textarea name="content" rows="6" cols="80" readonly="readonly"
							class="form-control">${board.content}</textarea>
					</div>

					<div class="form-group">
						<label>별점 </label> 
						<c:if test="${board.rating ==1}">★</c:if>
						<c:if test="${board.rating ==2}">★★</c:if>
						<c:if test="${board.rating ==3}">★★★</c:if>
						<c:if test="${board.rating ==4}">★★★★</c:if>
						<c:if test="${board.rating ==5}">★★★★★</c:if>
					</div>
					<div class="form-group">
						<label>작성자</label> <input type="text" name="id"
							class="form-control" value="${board.id}" readonly="readonly" />
					</div>
				</div>

			</div>
			<div class="box-footer">
				<button class="btn btn-rewrite">수정</button>
				<button class="btn btn-delete">삭제</button>
				<button class="btn btn-list">목록</button>
			</div>
		</div>
	</section>
	
	<hr><p></p>
 <div>
      <div class="box-body">
      <table>
         <tr>
         <td><input type="text" name="rewriter" id="rewriter" placeholder="댓글 작성자"></td>
         <br>
         <textarea class="form-control" name="rememo"  id="rememo" rows="6" cols="80" placeholder="댓글을 입력하세요."></textarea>
         </tr>
         <tr><td><button type="button" id="btnReplySave" class="btn btn-primary">저장</button></td></tr>   
      </table>         
      </div>
   </div>
   <hr><p></p>
 
	
	<script>
		$(function() {
			//목록버튼 눌렀을 때
			$(".btn-list").click(function() {
				location.href = "list";
			});
			//수정 눌렀을 때 처리
			$(".btn-rewrite").click(function() {
				location.href = "update?bno=" + ${board.bno}
				;
			});
			//수정완료 버튼 눌렀을 때 처리
			$(".btn-complete").click(function() {
				location.href = "detail?bno=" + ${board.bno}
			});
			//삭제 버튼을 눌렀을 때 처리
			$(".btn-delete").click(function() {
				location.href = "delete?bno=" + ${board.bno}
				;
			});		
			

		})
		
	</script>

	<div id="replyList"></div>
	<%@include file="replywrite.jsp" %>
	
</body>
</html>



