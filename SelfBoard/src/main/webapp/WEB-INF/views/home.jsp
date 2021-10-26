<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<html>
<head>
	<title>게시판 첫 화면</title>
</head>
<body>
	<h1>
		게시판 공부 다시 시작
	</h1>
	
	<P>  현재시각은 ${serverTime}입니다. </P>
	<P> 
		기능 이것저것 추가하면서 공부해보고, 다듬어서 최종적으론 단독 컬럼형 게시판을 구현하고자함 <br />
		메인 페이지부터 바로 게시판 띄운다
	</P>
	
	<style type="text/css">
		a {color:black;}
		a {text-decoration:none;}
		a:hover {text-decoration:underline;}
	</style>

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
			<c:forEach items="${list}" var="list">
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
	
	<input type="text" name="search" value=" ">
	
	<a href="write"><button>글쓰기</button></a>
	
</body>
</html>
