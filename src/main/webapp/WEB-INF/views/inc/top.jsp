<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/inc/header.jsp"></c:import>
    <!--상단 영역-->
    <div class="advertise">
        <a href="#">
            <h1>카카오톡 채널 추가 시 3천원 추가 할인!</h1>
        </a>
    </div>
    <!--상단 영역-->
    <header class="header">
        <div class="header-container">
            <div class="menu menu-item1">
                <a href="${pageContext.request.contextPath}/shoppingmall/index?category1=베스트">
                    <img src="${pageContext.request.contextPath}/assets/img/xexymix_header_logo_bk.png" />
                </a>
            </div>
            <div class="menu menu-item2">
                <ul class="menu-item2-line">
                    <li><a href="${pageContext.request.contextPath}/shoppingmall/community1_index?contype=content0">프로모션</a></li>
                    <li><a href="${pageContext.request.contextPath}/shoppingmall/community1_index?contype=content1">커뮤니티</a>
                        <ul class="item-in-item">
                            <li><a href="${pageContext.request.contextPath}/shoppingmall/community1_index?contype=content1" class="content-first">공지사항</a></li>
                            <li><a href="${pageContext.request.contextPath}/shoppingmall/community1_index?contype=content2">자주 묻는 질문</a></li>
                            <li><a href="${pageContext.request.contextPath}/shoppingmall/community1_index?contype=content3">상품 문의</a></li>
                            <li><a href="${pageContext.request.contextPath}/shoppingmall/community1_index?contype=content4">반품 문의</a></li>
                            <li><a href="${pageContext.request.contextPath}/shoppingmall/community1_index?contype=content5">교환 문의</a></li>
                            <li><a href="${pageContext.request.contextPath}/shoppingmall/community1_index?contype=content6" class="content-last">전국 매장 안내</a></li>
                        </ul>
                    </li>
                    <li><a href="${pageContext.request.contextPath}/shoppingmall/index?category1=베스트">베스트</a></li>
                    <li><a href="${pageContext.request.contextPath}/shoppingmall/index?category1=opo">1+1</a>
                        <ul class="item-in-item">
                            <li class="in-item-first"><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=opo&&category2=상의">상의</a></li>
                            <li><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=opo&&category2=하의">하의</a></li>
                            <li><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=opo&&category2=용품">용품</a></li>
                        </ul>
                    </li>
                    <li><a href="${pageContext.request.contextPath}/shoppingmall/index?category1=우먼즈">우먼즈</a>
                        <ul class="item-in-item">
                            <li class="in-item-first"><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=우먼즈&&category2=상의">상의</a></li>
                            <li><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=우먼즈&&category2=하의">하의</a></li>
                            <li><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=우먼즈&&category2=아우터">아우터</a></li>
                            <li><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=우먼즈&&category2=조거팬츠">조거팬츠</a></li>
                            <li><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=우먼즈&&category2=세트">세트</a></li>
                        </ul>
                    </li>
                    <li><a href="${pageContext.request.contextPath}/shoppingmall/index?category1=맨즈">맨즈</a>
                        <ul class="item-in-item">
                            <li class="in-item-first"><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=맨즈&&category2=상의">상의</a></li>
                            <li><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=맨즈&&category2=하의">하의</a></li>
                            <li><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=맨즈&&category2=아우터">아우터</a></li>
                            <li><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=맨즈&&category2=조거팬츠">조거팬츠</a></li>
                            <li><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=맨즈&&category2=세트">세트</a></li>
                        </ul>
                    </li>
                    <li><a href="${pageContext.request.contextPath}/shoppingmall/index?category1=테니스">테니스</a>
                        <ul class="item-in-item">
                            <li class="in-item-first"><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=테니스&&category2=맨즈">맨즈</a></li>
                            <li><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=테니스&&category2=우먼즈">우먼즈</a></li>
                            <li><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=테니스&&category2=용품">용품</a></li>
                        </ul>
                    </li>
                    <li><a href="${pageContext.request.contextPath}/shoppingmall/index?category1=용품">용품</a>
                        <ul class="item-in-item">
                            <li class="in-item-first"><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=용품&&category2=양말">양말</a></li>
                            <li><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=용품&&category2=모자">모자</a></li>
                            <li><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=용품&&category2=가방">가방</a></li>
                            <li><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=용품&&category2=홈트용품">홈트용품</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
            <div class="menu menu-item3">
                <div class="main-search-menu">
                    <img class="main-search" id="search-open" src="${pageContext.request.contextPath}/assets/img/xexymix_menu_view.png" />
                    <form method="get" action="${pageContext.request.contextPath}/shoppingmall/search_index" class="main-search" name="main-search" id="main-search-form">
                        <span id="search-close" class="search-close">X</span>
                        <div class="keyword">
                            <span>검색</span>
                        </div>
                        <div class="search-button">
                            <label for="main-search">
                                <input name="search" type="text" class="main-search" id="main-search" placeholder="검색어를 입력하세요."
                                    onfocus="this.placeholder=''" onblur="this.placeholder='검색어를 입력하세요.'" />
                                <input type="submit" class="main-search-button" value="검색" />
                            </label>
                        </div>
                    </form>
                </div>
                <a href="${pageContext.request.contextPath}/shoppingmall/shopping_cart">
                    <img src="${pageContext.request.contextPath}/assets/img/xexymix_menu_cart.png" />
                </a>
                <a href="${pageContext.request.contextPath}/shoppingmall/login">
                    <img src="${pageContext.request.contextPath}/assets/img/xexymix_login_logo.png" />
                </a>
                
                <div class="entire-menu">
                    <img class="entire-menu-icon" id="menu-open" src="${pageContext.request.contextPath}/assets/img/andar_icon_menu.png" />
                    <div class="entire-menu-list" id="entire-menu-id">
                        <ul class="menu-item3-line">
                            <li class="x" id="menu-close">
                                <h1>X</h1>
                            </li>
                            <li class="mtitle"><a href="${pageContext.request.contextPath}/shoppingmall/community1_index?contype=content0">프로모션</a></li>
                            <li class="mtitle"><a href="${pageContext.request.contextPath}/shoppingmall/community1_index?contype=content1">커뮤니티</a>
                                <ul class="item-in-item">
                                    <li><a href="${pageContext.request.contextPath}/shoppingmall/community1_index?contype=content1" class="content-first">공지사항</a></li>
                                    <li><a href="${pageContext.request.contextPath}/shoppingmall/community1_index?contype=content2">자주 묻는 질문</a></li>
                                    <li><a href="${pageContext.request.contextPath}/shoppingmall/community1_index?contype=content3">상품 문의</a></li>
                                    <li><a href="${pageContext.request.contextPath}/shoppingmall/community1_index?contype=content4">반품 문의</a></li>
                                    <li><a href="${pageContext.request.contextPath}/shoppingmall/community1_index?contype=content5">교환 문의</a></li>
                                    <li><a href="${pageContext.request.contextPath}/shoppingmall/community1_index?contype=content6" class="content-last">전국 매장 안내</a></li>
                                </ul>
                            </li>
                            <li class="mtitle"><a href="${pageContext.request.contextPath}/shoppingmall/index?category1=베스트">베스트</a></li>
                            <li class="mtitle"><a href="${pageContext.request.contextPath}/shoppingmall/index?category1=opo">1+1</a>
                                <ul class="item-in-item">
                                    <li class="in-item-first"><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=opo&&category2=상의">상의</a></li>
                                    <li><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=opo&&category2=하의">하의</a></li>
                                    <li><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=opo&&category2=용품">용품</a></li>
                                </ul>
                            </li>
                            <li class="mtitle"><a href="${pageContext.request.contextPath}/shoppingmall/index?category1=우먼즈">우먼즈</a>
                                <ul class="item-in-item">
                                    <li class="in-item-first"><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=우먼즈&&category2=상의">상의</a></li>
                                    <li><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=우먼즈&&category2=하의">하의</a></li>
                                    <li><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=우먼즈&&category2=아우터">아우터</a></li>
                                    <li><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=우먼즈&&category2=조거팬츠">조거팬츠</a></li>
                                    <li><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=우먼즈&&category2=세트">세트</a></li>
                                </ul>
                            </li>
                            <li class="mtitle"><a href="${pageContext.request.contextPath}/shoppingmall/index?category1=맨즈">맨즈</a>
                                <ul class="item-in-item">
                                    <li class="in-item-first"><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=맨즈&&category2=상의">상의</a></li>
                                    <li><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=맨즈&&category2=하의">하의</a></li>
                                    <li><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=맨즈&&category2=아우터">아우터</a></li>
                                    <li><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=맨즈&&category2=조거팬츠">조거팬츠</a></li>
                                    <li><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=맨즈&&category2=세트">세트</a></li>
                                </ul>
                            </li>
                            <li class="mtitle"><a href="${pageContext.request.contextPath}/shoppingmall/index?category1=테니스">테니스</a>
                                <ul class="item-in-item">
                                    <li class="in-item-first"><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=테니스&&category2=맨즈">맨즈</a></li>
                                    <li><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=테니스&&category2=우먼즈">우먼즈</a></li>
                                    <li><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=테니스&&category2=용품">용품</a></li>
                                </ul>
                            </li>
                            <li class="mtitle"><a href="${pageContext.request.contextPath}/shoppingmall/index?category1=용품">용품</a>
                                <ul class="item-in-item">
                                    <li class="in-item-first"><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=용품&&category2=양말">양말</a></li>
                                    <li><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=용품&&category2=모자">모자</a></li>
                                    <li><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=용품&&category2=가방">가방</a></li>
                                    <li><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=용품&&category2=홈트용품">홈트용품</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </header>
