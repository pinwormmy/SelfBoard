<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<html>
<head>
	<title>게시판 만들기 공부 : 메인화면 </title>
	<style type="text/css">
		a {color:black;}
		a {text-decoration:none;}
		a:hover {text-decoration:underline;}
		
		div{width: 45%; text-align:right;}
		
		
		table {width: 100%; border-top: 2px solid #444444; border-bottom: 2px solid #444444; border-collapse: collapse;}
		th, td {border-bottom: 1px solid #444444; padding: 10px;}
		
		@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&display=swap');
		
		*{font-family:'Noto Sans KR'; background-color:rgba(255,255,255,0.3);}
		
		body{
			background-image: url('https://vlee.kr/wp-content/uploads/2020/03/%EC%95%84%EC%9D%B4%EC%9C%A0_01_1920.jpg');
		}
				
	</style>
	
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&display=swap" rel="stylesheet">
</head>
<body>
	<p style="font-size:50px;"><a href="/"> 자바:스프링 공부 - 게시판 만들기 </a></p>
	<p>몇 가지 구현 후 홈페이지 제작으로 넘어간다!</p>
	
	<c:if test="${member == null}">
		<form role="form" action="/login" method="post">
			ID : <input type="text" name="userId" value="${member.userId}">
			비밀번호 : <input type="password" name="userPassword">
			<button>로그인</button>
			<button type="button" onclick="location.href='/signup'">회원가입</button>
		</form>
	</c:if>
	
	<c:if test="${member != null}">
		<p>
		${member.userId} 님 로그인 중입니다.
		<button type="button" onclick="location.href='/logout'">로그아웃</button>
		</p>
	</c:if>
	
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
			<c:forEach items="${list}" var="list" begin="${page.postStartNum}" end="${page.postEndNum}">
				<tr>
					<td>${list.sno}  </td>
					
					<td><a href="Bpost?sno=${list.sno}">${list.title}</a>
					<c:if test="${list.countComment > 0}">
					<span style="color:grey;">[${list.countComment}]</span>
					</c:if>
					
					</td>
					
					<td>
					<c:if test="${list.authority == 2}">
						${list.writer}
					</c:if>
					<c:if test="${list.authority == 1}">
						<b>${list.writer}</b>
					</c:if>
					</td>
					
					<td>${list.writingtime}</td>
					
					<td><b>${list.view_cnt}</b></td>
				</tr>
			</c:forEach>			
		</tbody>
	</table>
	
	<br>
	
	<form action="/search">
		<select name="searchOption">
			<option value="tandc" 
			<c:if test="${(page.searchOption) == 'tandc'}">selected</c:if>>제목+내용</option>
			<option value="title" 
			<c:if test="${(page.searchOption) == 'title'}">selected</c:if> >제목</option>
			<option value="content" 
			<c:if test="${(page.searchOption) == 'content'}">selected</c:if> >내용</option>
			<option value="writer" 
			<c:if test="${(page.searchOption) == 'writer'}">selected</c:if> >작성자</option>
		</select>
		<input type="text" name="searchKeyword" value="${page.searchKeyword}">
		<input type="hidden" name="pageNum" value=1>
		<input type="submit" value="검색">
		<input type="button" onclick="location.href='/'" value="목록"/>
		
	</form>
	

	<div>
		<a href="write"><button>글쓰기</button></a>
	</div>
		
	<c:if test="${page.pageStartNum > page.pageLimit}">
			<a href="/search?searchOption=${page.searchOption}
				&searchKeyword=${page.searchKeyword}&pageNum=${page.pageStartNum - 1}">◀</a>
	</c:if> 
	
	<c:forEach var="i" begin="${page.pageStartNum}" end="${page.pageEndNum}">
		<c:choose>
			<c:when test="${page.pageNum == i}">
				<b>${i}</b>
			</c:when>
			<c:otherwise>
				<a href="/search?searchOption=${page.searchOption}
				&searchKeyword=${page.searchKeyword}&pageNum=${i}">${i}</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	
	<c:if test="${page.pageEndNum < page.maxPageNum}">
			<a href="/search?searchOption=${page.searchOption}
				&searchKeyword=${page.searchKeyword}&pageNum=${page.pageEndNum + 1}">▶</a>
	</c:if> 			
	
	<script type="text/javascript">
	
		if(${loginerror == false} ){
			alert("로그인 오류!! 아디 비번 확인하세요!!");
		}
			
	</script>
</body>
</html>
