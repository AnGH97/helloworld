<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/inc/top.jsp" />
<!--css-->
<link rel="stylesheet" href="${contextPath}/assets/css/community_write.css"/>

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
        <form method="post" action="${contextPath}/shoppingmall/community_write_ok.do" class="form-horizontal" name="join_form" id="join_form">
            <div class="content-a content0">
                <span><p>TITLE</p></span>
                <input class="text_title" type="text" name="text_title" id="text_title" maxlength="50" />
            </div>
            <div class="content-a content1">
                <div class="content1-name">
                    <span><p>NAME</p></span>
                    <input class="user_name" type="text" name="user_name" id="user_name" maxlength="30" />
                </div>
                <div class="content1-pw">
                    <span><p>PASSWORD</p></span>
                    <input class="user_pw" type="password" name="user_pw" id="user_pw" maxlength="30" />
                </div>
            </div>
            <div class="content-a content2">
                <span><p>TEXT</p></span>
                <textarea class="content-title" name="content-title" id="content-title" maxlength="1000" placeholder="내용을 입력하세요."
                    onfocus="this.placeholder=''" onblur="this.placeholder='내용을 입력하세요.'"></textarea>
            </div>
            <div class="content-a content4">
                <div>
                    <input class="content4-reset" type="reset" value="다시 쓰기"/>
                    <input class="content4-submit" type="submit" value="작성 완료"/>
                </div>
            </div>
        </form>
    </div>       
</section>
    
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<c:import url="/WEB-INF/views/inc/bottom.jsp" />

