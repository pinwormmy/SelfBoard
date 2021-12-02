<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<c:if test="${member == null}">
		<form role="form" action="/login" method="post">
			ID : <input type="text" name="userId" value="${member.userId}">
			비밀번호 : <input type="password" name="userPassword">
			<input type="submit" value="로그인">
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
	
		if( ${loginerror == false} ){
			alert("로그인 오류!! 아디 비번 확인하세요!!");
		}
			
	</script>
</body>
</html>
