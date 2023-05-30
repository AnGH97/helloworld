<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/inc/top.jsp" />
<!--community_index stype-->
<link rel="stylesheet" href="${contextPath}/assets/css/community1_index.css" />

        <!--메인 내용 영역-->
        <section class="main">
            <div class="content-container">
                <h1>커뮤니티</h1>
                <ul>
                    <li><a href="${contextPath}/shoppingmall/community1_index" class="content-first">공지사항</a></li>
                    <li><a href="${contextPath}/shoppingmall/community1_index">자주 묻는 질문</a></li>
                    <li><a href="${contextPath}/shoppingmall/community1_index">상품 문의</a></li>
                    <li><a href="${contextPath}/shoppingmall/community1_index">반품 문의</a></li>
                    <li><a href="${contextPath}/shoppingmall/community1_index">교환 문의</a></li>
                    <li><a href="${contextPath}/shoppingmall/community1_index" class="content-last">전국 매장 안내</a></li>
                </ul>

                <form method="get" action="${contextPath}/shoppingmall/community1_index" class="search-form" name="search-form" id="search-form">
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
                            <div class="board-search-text">
                                <input type="text" name="search-text" id="search" />
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
                            <tr width="100%" align="center">
                                <td>1</td>
                                <td><a href="${contextPath}/shoppingmall/community_view">제목공간입니다.</a></td>
                                <td>작성자</td>
                                <td>작성일</td>
                                <td>1222222</td>
                            </tr>
                            <tr width="100%" align="center">
                                <td>1</td>
                                <td><a href="${contextPath}/shoppingmall/community_view">제목공간입니다.</a></td>
                                <td>작성자</td>
                                <td>작성일</td>
                                <td>1222222</td>
                            </tr>
                            <tr width="100%" align="center">
                                <td>1</td>
                                <td><a href="${contextPath}/shoppingmall/community_view">제목공간입니다.</a></td>
                                <td>작성자</td>
                                <td>작성일</td>
                                <td>1222222</td>
                            </tr>
                            <tr width="100%" align="center">
                                <td>1</td>
                                <td><a href="${contextPath}/shoppingmall/community_view">제목공간입니다.</a></td>
                                <td>작성자</td>
                                <td>작성일</td>
                                <td>1222222</td>
                            </tr>
                            <tr width="100%" align="center">
                                <td>1</td>
                                <td><a href="${contextPath}/shoppingmall/community_view">제목공간입니다.</a></td>
                                <td>작성자</td>
                                <td>작성일</td>
                                <td>1222222</td>
                            </tr>
                            <tr width="100%" align="center">
                                <td>1</td>
                                <td><a href="${contextPath}/shoppingmall/community_view">제목공간입니다.</a></td>
                                <td>작성자</td>
                                <td>작성일</td>
                                <td>1222222</td>
                            </tr>
                            <tr width="100%" align="center">
                                <td>1</td>
                                <td><a href="${contextPath}/shoppingmall/community_view">제목공간입니다.</a></td>
                                <td>작성자</td>
                                <td>작성일</td>
                                <td>1222222</td>
                            </tr>
                            <tr width="100%" align="center">
                                <td>1</td>
                                <td><a href="${contextPath}/shoppingmall/community_view">제목공간입니다.</a></td>
                                <td>작성자</td>
                                <td>작성일</td>
                                <td>1222222</td>
                            </tr>
                            <tr width="100%" align="center">
                                <td>1</td>
                                <td><a href="${contextPath}/shoppingmall/community_view">제목공간입니다.</a></td>
                                <td>작성자</td>
                                <td>작성일</td>
                                <td>1222222</td>
                            </tr>
                            <tr width="100%" align="center">
                                <td>1</td>
                                <td><a href="${contextPath}/shoppingmall/community_view">제목공간입니다.</a></td>
                                <td>작성자</td>
                                <td>작성일</td>
                                <td>1222222</td>
                            </tr>
                            <tr width="100%" align="center">
                                <td>1</td>
                                <td><a href="${contextPath}/shoppingmall/community_view">제목공간입니다.</a></td>
                                <td>작성자</td>
                                <td>작성일</td>
                                <td>1222222</td>
                            </tr>
                            <tr width="100%" align="center">
                                <td>1</td>
                                <td><a href="${contextPath}/shoppingmall/community_view">제목공간입니다.</a></td>
                                <td>작성자</td>
                                <td>작성일</td>
                                <td>1222222</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>

            <a class="write" href="${contextPath}/shoppingmall/community_write">글쓰기</a>
            
            <div class="pagenation">
                <!--페이지 번호-->
                <ul class="paging">
                    <li><a href=#> < </a></li>
                    <li class="active"><a href=#>1</a></li>
                    <li><a href=#>2</a></li>
                    <li><a href=#>3</a></li>
                    <li><a href=#>4</a></li>
                    <li><a href=#>5</a></li>
                    <li><a href=#>></a></li>
                </ul>
            </div>      
        </section>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<c:import url="/WEB-INF/views/inc/bottom.jsp" />
