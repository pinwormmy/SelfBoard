<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<html>
<head>
	<title>ㅁㅁㅁ요충이 게시판ㅁㅁㅁ</title>
	<style type="text/css">
		a {color:black;}
		a {text-decoration:none;}
		a:hover {text-decoration:underline;}
		
		div{width: 45%; text-align:right;}
	</style>
</head>
<body>
	<h1>
		<a href="/">스프링 공부 - 게시판 만들기</a>
	</h1>
	
	<P> 
		기능 이것저것 추가하면서 공부해보고, 다듬어서 최종적으론 단독 컬럼형 게시판을 구현해봅시다~~ <br />
	</P>
	
	<table>
		<thead>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="list" begin="${postStartNum}" end="${postEndNum}">
				<tr>
					<td>${list.sno}  </td>
					<td><a href="Bpost?sno=${list.sno}">${list.title}</a></td>
					<td>${list.writer}  </td>
					<td>${list.writingtime}</td>
					<td>${list.view_cnt}  </td>
					
				</tr>
			</c:forEach>			
		</tbody>
	</table>
	
	<form action="/search">
		<select name="searchOption">
			<option value="tandc">제목+내용</option>
			<option value="title">제목</option>
			<option value="content">내용</option>
			<option value="writer">작성자</option>
		</select>
		<input type="text" name="searchKeyword">
		<input type="submit" value="검색">
		<input type="button" onclick="location.href='/'" value="목록"/>
	</form>
	
	<div>
		<a href="write"><button>글쓰기</button></a>
	</div>
	
	<script>
		function nowpage(){
			window.location.href + "/page?pageNum=${i}";
		}
	</script>
	
	
	<c:forEach var="i" begin="1" end="${MaxPageNum}">
		<a href="javascript:void(0);" onclick="nowpage(); return false;">${i}</a>
	</c:forEach>			
	
	
</body>
</html>
