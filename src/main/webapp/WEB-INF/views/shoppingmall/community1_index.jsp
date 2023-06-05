<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/inc/top.jsp" />
<!--community_index stype-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/community1_index.css" />

        <!--메인 내용 영역-->
        <section class="main">
            <div class="content-container">
                <h1>커뮤니티</h1>
                <ul>
                    <!--${pageContext.request.contextPath} => ${pageContext.request.contextPath}
                    배포시 이 자리에 war 혹은 jar파일의 폴더 경로가 지정됨.-->
                    <li><a href="${pageContext.request.contextPath}/shoppingmall/community1_index?contype=content1" class="content-first">공지사항</a></li>
                    <li><a href="${pageContext.request.contextPath}/shoppingmall/community1_index?contype=content2">자주 묻는 질문</a></li>
                    <li><a href="${pageContext.request.contextPath}/shoppingmall/community1_index?contype=content3">상품 문의</a></li>
                    <li><a href="${pageContext.request.contextPath}/shoppingmall/community1_index?contype=content4">반품 문의</a></li>
                    <li><a href="${pageContext.request.contextPath}/shoppingmall/community1_index?contype=content5">교환 문의</a></li>
                    <li><a href="${pageContext.request.contextPath}/shoppingmall/community1_index?contype=content6" class="content-last">전국 매장 안내</a></li>
                </ul>

                <form method="get" action="${pageContext.request.contextPath}/shoppingmall/community1_index" class="search-form" name="search-form" id="search-form">
                    <div class="board-search-subject">
                        <h2>공지사항</h2>
                        <div class="board-search">
                            <div class="board-search-radio">
                                <label>
                                    <input type="radio" name="search" id="search1" value="name" checked />
                                    이름
                                </label>
                                <label>
                                    <input type="radio" name="search" id="search2" value="title" />
                                    제목
                                </label>
                            </div>
                            <div class="board-keyword">
                                <input type="text" name="keyword" id="keyword" />
                                <button type="submit"><i class="fa fa-search" aria-hidden="true"></i></button>
                            </div>
                        </div>
                    </div>
                </form>
                
                <div class="notice-board">
                    <table width="100%" align="center">
                        <thead>
                            <tr>
                                <th>번호</th>
                                <th>제목</th>
                                <th>작성자</th>
                                <th>작성일</th>
                                <th>조회</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:choose>
                                <%-- 조회 결과가 없는 경우 --%>
                                <c:when test="${output == null || fn:length(output) == 0}">
                                    <tr>
                                        <td colspan="5" align="center">조회결과가 없습니다.</td>
                                    </tr>
                                </c:when>
                                <%-- 조회결과가 있는 경우 --%>
                                <c:otherwise>
                                    <%-- 조회 결과에 따른 반복 처리--%>
                                    <c:forEach var="item" items="${output}" varStatus="status">
                
                                        <%-- 출력을 위해 준비한 학과이름과 위치--%>
                                        <c:set var="id" value="${item.id}" />
                                        <c:set var="subject" value="${item.subject}" />
                                        <c:set var="writer" value="${item.writer}" />
                                        <c:set var="reg_date" value="${item.reg_date}" />
                                        <c:set var="hit" value="${item.hit}" />
                                        <%-- 검색어가 있다면? --%>
                                        <c:if test="${keyword != ''}">
                                            <%-- 검색어에 <mark> 태그를 적용한 문자열 변수를 준비 --%>
                                                <c:set var="mark" value="<mark>${keyword}</mark>"></c:set>
                                                
                                                <%-- 출력을 위해 준비한 학과 이름과 위치에서 검색어와 일치하는 단어를 형광팬 효과로 변경 --%>
                                                <c:set var="subject" value="${fn:replace(subject, keyword, mark)}"></c:set>
                                                <c:set var="writer" value="${fn:replace(writer, keyword, mark)}"></c:set>
                                        </c:if>
                                        <%-- 상세페이지로 이동하기 위한 URL --%>
                                        <c:url value="/shoppingmall/community_view" var="viewUrl">
                                            <c:param name="id" value="${item.id}"></c:param>
                                        </c:url>
                
                                        <tr>
                                            <td align="center">${item.id}</td>
                                            <td align="center"><a href="${viewUrl}">${subject}</a></td>
                                            <td align="center">${writer}</td>
                                            <td align="center">${reg_date}</td>
                                            <td align="center">${hit}</td>
                                        </tr>
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>
<!--                           <tr width="100%" align="center">
                                <td>1</td>
                                <td><a href="${pageContext.request.contextPath}/shoppingmall/community_view">제목공간입니다.</a></td>
                                <td>작성자</td>
                                <td>작성일</td>
                                <td>1222222</td>
                            </tr>
                            <tr width="100%" align="center">
                                <td>1</td>
                                <td><a href="${pageContext.request.contextPath}/shoppingmall/community_view">제목공간입니다.</a></td>
                                <td>작성자</td>
                                <td>작성일</td>
                                <td>1222222</td>
                            </tr>
                            <tr width="100%" align="center">
                                <td>1</td>
                                <td><a href="${pageContext.request.contextPath}/shoppingmall/community_view">제목공간입니다.</a></td>
                                <td>작성자</td>
                                <td>작성일</td>
                                <td>1222222</td>
                            </tr>
                            <tr width="100%" align="center">
                                <td>1</td>
                                <td><a href="${pageContext.request.contextPath}/shoppingmall/community_view">제목공간입니다.</a></td>
                                <td>작성자</td>
                                <td>작성일</td>
                                <td>1222222</td>
                            </tr>
                            <tr width="100%" align="center">
                                <td>1</td>
                                <td><a href="${pageContext.request.contextPath}/shoppingmall/community_view">제목공간입니다.</a></td>
                                <td>작성자</td>
                                <td>작성일</td>
                                <td>1222222</td>
                            </tr>
                            <tr width="100%" align="center">
                                <td>1</td>
                                <td><a href="${pageContext.request.contextPath}/shoppingmall/community_view">제목공간입니다.</a></td>
                                <td>작성자</td>
                                <td>작성일</td>
                                <td>1222222</td>
                            </tr>
                            <tr width="100%" align="center">
                                <td>1</td>
                                <td><a href="${pageContext.request.contextPath}/shoppingmall/community_view">제목공간입니다.</a></td>
                                <td>작성자</td>
                                <td>작성일</td>
                                <td>1222222</td>
                            </tr>
                            <tr width="100%" align="center">
                                <td>1</td>
                                <td><a href="${pageContext.request.contextPath}/shoppingmall/community_view">제목공간입니다.</a></td>
                                <td>작성자</td>
                                <td>작성일</td>
                                <td>1222222</td>
                            </tr>
                            <tr width="100%" align="center">
                                <td>1</td>
                                <td><a href="${pageContext.request.contextPath}/shoppingmall/community_view">제목공간입니다.</a></td>
                                <td>작성자</td>
                                <td>작성일</td>
                                <td>1222222</td>
                            </tr>
                            <tr width="100%" align="center">
                                <td>1</td>
                                <td><a href="${pageContext.request.contextPath}/shoppingmall/community_view">제목공간입니다.</a></td>
                                <td>작성자</td>
                                <td>작성일</td>
                                <td>1222222</td>
                            </tr>
                            <tr width="100%" align="center">
                                <td>1</td>
                                <td><a href="${pageContext.request.contextPath}/shoppingmall/community_view">제목공간입니다.</a></td>
                                <td>작성자</td>
                                <td>작성일</td>
                                <td>1222222</td>
                            </tr>
                            <tr width="100%" align="center">
                                <td>1</td>
                                <td><a href="${pageContext.request.contextPath}/shoppingmall/community_view">제목공간입니다.</a></td>
                                <td>작성자</td>
                                <td>작성일</td>
                                <td>1222222</td>
                            </tr>--> 
                        </tbody>
                    </table>
                </div>
            </div>

            <a class="write" href="${pageContext.request.contextPath}/shoppingmall/community_write">글쓰기</a>

            <!-- 페이지 번호 구현-->
            <%-- 이전 그룹에 대한 링크 --%>
            <c:choose>
                <%-- 이전 그룹으로 이동 가능하다면?--%>
                <c:when test="${pagenation.prevPage > 0}">
                    <%-- 이동할 URL 생성 --%>
                    <c:url value="/shoppingmall/community1_index" var="prevPageUrl">
                        <c:param name="page" value="${pagenation.prevPage}"></c:param>
                        <c:param name="keyword" value="${keyword}"></c:param>
                    </c:url>
                    <a href="${prevPageUrl}"><</a>
                </c:when>
                <c:otherwise>
                    <
                </c:otherwise>
            </c:choose>

            <%--페이지 번호(시작 페이지부터 끝 페이지까지 반복) --%>
            <c:forEach var="i" begin="${pagenation.startPage}" end="${pagenation.endPage}" varStatus="status">
                <%--이동할 URL 생성--%>
                <c:url value="/shoppingmall/community1_index" var="pageUrl">
                    <c:param name="page" value="${i}"></c:param>
                    <c:param name="keyword" value="${keyword}"></c:param>
                </c:url>

                <%-- 페이지 번호 출력 --%>
                <c:choose>
                    <%--현재 머물고 있는 페이지 번호를 출력할 경우 링크 적용 안함 --%>
                    <c:when test="${pagenation.nowPage == i}">
                        <strong>[${i}]</strong>
                    </c:when>
                    <%-- 나머지 페이지의 경우 링크 적용함 --%>
                    <c:otherwise>
                        <a href="${pageUrl}">[${i}]</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <%--다음 그룹에 대한 링크 --%>
            <c:choose>
                <%--다음 그룹으로 이동이 가능하다면?--%>
                <c:when test="${pagenation.nextPage > 0}">
                    <%--이동할 URL 생성 --%>
                    <c:url value="/shoppingmall/community1_index" var="nextPageUrl">
                        <c:param name="page" value="${pagenation.nextPage}"></c:param>
                        <c:param name="keyword" value="${keyword}"></c:param>
                    </c:url>
                    <a href="${nextPageUrl}">></a>
                </c:when>
                <c:otherwise>
                    >
                </c:otherwise>
            </c:choose>            
            <!--<div class="pagenation">-->
                <!--페이지 번호-->
            <!--<ul class="paging">
                    <li><a href=#> < </a></li>
                    <li class="active"><a href=#>1</a></li>
                    <li><a href=#>2</a></li>
                    <li><a href=#>3</a></li>
                    <li><a href=#>4</a></li>
                    <li><a href=#>5</a></li>
                    <li><a href=#>></a></li>
                </ul>
            </div>-->       
        </section>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<c:import url="/WEB-INF/views/inc/bottom.jsp" />
