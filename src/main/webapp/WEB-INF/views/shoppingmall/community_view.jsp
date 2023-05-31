<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/inc/top.jsp" />
<!--css-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/community_view.css"/>

<!--메인 내용 영역-->
<section class="main">
    <div class="content-container">
        <h1>커뮤니티</h1>
        <ul>
            <li><a href="${pageContext.request.contextPath}/shoppingmall/community1_index" class="content-first">공지사항</a></li>
            <li><a href="${pageContext.request.contextPath}/shoppingmall/community1_index">자주 묻는 질문</a></li>
            <li><a href="${pageContext.request.contextPath}/shoppingmall/community1_index">상품 문의</a></li>
            <li><a href="${pageContext.request.contextPath}/shoppingmall/community1_index">반품 문의</a></li>
            <li><a href="${pageContext.request.contextPath}/shoppingmall/community1_index">교환 문의</a></li>
            <li><a href="${pageContext.request.contextPath}/shoppingmall/community1_index" class="content-last">전국 매장 안내</a></li>
        </ul>

        <div class="content-a content1">
            <div class="content1-title">
                <span class="title"><p>TITLE</p></span>
                <span class="title_text"><p>여기는 제목 영역 입니다.</p></span>
            </div>
            <div class="content1-name">
                <span class="name"><p>NAME</p></span>
                <span class="name_text"><p>여기는 이름 영역 입니다.</p></span>
            </div>
        </div>
        <div class="content-a content2">
            <span class="text"><p>TEXT</p></span>
            <span class="text_txt"><p>게시판 글을 불러오는 공간입니다.</p></span>
        </div>
        <div class="content-a content4">
            <a href="${pageContext.request.contextPath}/shoppingmall/community1_index"><p>목록보기</p></a>
        </div>
    </div>       
</section>
    
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<c:import url="/WEB-INF/views/inc/bottom.jsp" />

