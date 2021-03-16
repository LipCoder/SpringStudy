<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@include file="../includes/header.jsp" %>


<script type="text/javascript">
	$(document).ready(function() {
		
		var formObj = $("form");
		
		$('button').on("click",function(e) {
			
			e.preventDefault();
			
			var operation = $(this).data("oper");
			
			console.log(operation);
			
			if(operation === 'remove') {
				formObj.attr("action", "/board/remove");
			} else if(operation === 'list') {
				// move to list
				formObj.attr("action", "/board/list").attr("method", "get");
				var pageNumTag = $("input[name='pageNum']").clone();
				var amountTag = $("input[name='amount']").clone();
				var typeTag = $("input[name='type']").clone();
				var keywordTag = $("input[name='keyword']").clone();
				
				formObj.empty(); // 수정이 필요없기 때문에 form에 있는 모든 태그를 삭제한다.
				// list로 이동하므로 페이징에 필요한 정보는 담는다.
				formObj.append(pageNumTag);
				formObj.append(amountTag);
				formObj.append(typeTag);
				formObj.append(keywordTag);
			}
			formObj.submit();
		});
	});
</script>

<div class="row">
	<div class="col-lg-12">
		<h1 class="header">Board Read</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="co-lg-12">
		<div class="panel panel-default">
			
			<div class="panel-heading">Board Read Page</div>
			<!-- ./panel-heading -->
			<div class="panel-body">
			
			<form role="form" action="/board/modify" method="post">
			
				<!--  리스트 버튼 클릭시 해당 페이지가 아닌 
		              1번 페이지로 가지는 것을 막기위함 -->
				<!-- 페이지 정보 -->
               	<input type="hidden" name="pageNum" value='<c:out value="${cri.pageNum}"/>'>
               	<input type="hidden" name="amount" value='<c:out value="${cri.amount}"/>'>
               	<input type="hidden" name="type" value='<c:out value="${cri.type}"/>'>
               	<input type="hidden" name="keyword" value='<c:out value="${cri.keyword}"/>'>
			
				<div class="form-group">
					<label>Bno</label> <input class="form-control" name='bno'
						value='<c:out value="${board.bno }"/>' readonly="readonly">
				</div>
				
				<div class="form-group">
					<label>Title</label> <input class="form-control" name='title'
						value='<c:out value="${board.title }"/>'>
				</div>
				
				<div class="form-group">
					<label>Text area</label>
					<textarea class="form-control" rows="3" name='content'>
					<c:out value="${board.content }"/></textarea>
				</div>
				
				<div class="form-group">
					<label>Writer</label> <input class="form-control" name='writer'
						value='<c:out value="${board.writer }"/>'>
				</div>
				
				<button type="submit" data-oper="modify" class="btn btn-default">
						Modify
				</button>
				<button type="submit" data-oper="remove" class="btn btn-danger">
						Remove
				</button>
				<button type="submit" data-oper="list" class="btn btn-info"> 
						List
				</button>
				

			</form>
				
			</div>
			<!-- end panel-body -->
		</div>
		<!-- end panel-body -->
	</div>
	<!-- end panel -->
</div>
<!-- /.row -->

<%@include file="../includes/footer.jsp" %>