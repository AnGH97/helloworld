<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/inc/top.jsp" />
<!--login style-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/login.css" />

<!--메인 내용 영역-->
<section class="main">
    <form method="post" action="${pageContext.request.contextPath}/shoppingmall/login_ok.do" class="login-form" name="login-form" id="login-form">
        <div class="login">
            <span class="login-text"><h1>로그인</h1></span>
            <hr class="login-hr-first"/>
            <div class="input-item">
                <input class="user_id" type="text" name="user_id" id="user_id" maxlength="20" placeholder="아이디" />
                <input class="user_pw" type="password" name="user_pw" id="user_pw" maxlength="20" placeholder="비밀번호" />
            </div>
            <button type="submit">로그인</button>
            <hr class="login-hr-second"/>
            <div class="login-inform">
                <ul>
                    <li><a class="f-grey" href="#">아이디 찾기</a></li>
                    <li><a class="f-grey" href="#">비밀번호 찾기</a></li>
                    <li><a class="sign-in" href="${pageContext.request.contextPath}/shoppingmall/signin">회원가입</a></li>
                </ul>
            </div>
        </div>
    </form>
</section>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<c:import url="/WEB-INF/views/inc/bottom.jsp" />
