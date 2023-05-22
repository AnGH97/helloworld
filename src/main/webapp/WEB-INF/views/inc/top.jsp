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
                <a href="#">
                    <img src="${contextPath}/assets/img/xexymix_header_logo_bk.png" />
                </a>
            </div>
            <div class="menu menu-item2">
                <ul class="menu-item2-line">
                    <li><a href="#">프로모션</a></li>
                    <li><a href="#">커뮤니티</a>
                        <ul class="item-in-item">
                            <li class="in-item-first"><a href="#">공지사항</a></li>
                            <li><a href="#">자주 묻는 질문</a></li>
                            <li><a href="#">상품 문의</a></li>
                            <li><a href="#">반품 문의</a></li>
                            <li><a href="#">교환 문의</a></li>
                            <li><a href="#">전국 매장 안내</a></li>
                        </ul>
                    </li>
                    <li><a href="#">베스트</a>
                        <ul class="item-in-item">
                            <li class="in-item-first"><a href="#">맨즈</a></li>
                            <li><a href="#">우먼즈</a></li>
                            <li><a href="#">테니스</a></li>
                            <li><a href="#">용품</a></li>
                        </ul>
                    </li>
                    <li><a href="#">1+1</a>
                        <ul class="item-in-item">
                            <li class="in-item-first"><a href="#">상의</a></li>
                            <li><a href="#">하의</a></li>
                            <li><a href="#">용품</a></li>
                        </ul>
                    </li>
                    <li><a href="#">우먼즈</a>
                        <ul class="item-in-item">
                            <li class="in-item-first"><a href="#">상의</a></li>
                            <li><a href="#">하의</a></li>
                            <li><a href="#">아우터</a></li>
                            <li><a href="#">조거팬츠</a></li>
                            <li><a href="#">세트</a></li>
                        </ul>
                    </li>
                    <li><a href="#">맨즈</a>
                        <ul class="item-in-item">
                            <li class="in-item-first"><a href="#">상의</a></li>
                            <li><a href="#">하의</a></li>
                            <li><a href="#">아우터</a></li>
                            <li><a href="#">조거팬츠</a></li>
                            <li><a href="#">세트</a></li>
                        </ul>
                    </li>
                    <li><a href="#">테니스</a>
                        <ul class="item-in-item">
                            <li class="in-item-first"><a href="#">맨즈</a></li>
                            <li><a href="#">우먼즈</a></li>
                            <li><a href="#">용품</a></li>
                        </ul>
                    </li>
                    <li><a href="#">용품</a>
                        <ul class="item-in-item">
                            <li class="in-item-first"><a href="#">양말</a></li>
                            <li><a href="#">모자</a></li>
                            <li><a href="#">가방</a></li>
                            <li><a href="#">홈트용품</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
            <div class="menu menu-item3">
                <div class="main-search-menu">
                    <img class="main-search" id="search-open" src="${contextPath}/assets/img/xexymix_menu_view.png" />
                    <form class="main-search" name="main-search" id="main-search-form">
                        <span id="search-close" class="search-close">X</span>
                        <div class="search-text">
                            <span>검색</span>
                        </div>
                        <div class="search-button">
                            <label for="main-search">
                                <input type="text" class="main-search" id="main-search" placeholder="검색어를 입력하세요."
                                    onfocus="this.placeholder=''" onblur="this.placeholder='검색어를 입력하세요.'" />
                                <input type="submit" class="main-search-button" value="검색" />
                            </label>
                        </div>
                    </form>
                </div>
                <a href="#">
                    <img src="${contextPath}/assets/img/xexymix_menu_cart.png" />
                </a>
                <a href="#">
                    <img src="${contextPath}/assets/img/xexymix_login_logo.png" />
                </a>
                
                <div class="entire-menu">
                    <img class="entire-menu-icon" id="menu-open" src="${contextPath}/assets/img/andar_icon_menu.png" />
                    <div class="entire-menu-list" id="entire-menu-id">
                        <ul class="menu-item3-line">
                            <li class="x" id="menu-close">
                                <h1>X</h1>
                            </li>
                            <li class="mtitle"><a href="#">프로모션</a></li>
                            <li class="mtitle"><a href="#">커뮤니티</a>
                                <ul class="item-in-item">
                                    <li class="in-item-first"><a href="#">공지사항</a></li>
                                    <li><a href="#">자주 묻는 질문</a></li>
                                    <li><a href="#">상품 문의</a></li>
                                    <li><a href="#">반품 문의</a></li>
                                    <li><a href="#">교환 문의</a></li>
                                    <li><a href="#">전국 매장 안내</a></li>
                                </ul>
                            </li>
                            <li class="mtitle"><a href="#">베스트</a>
                                <ul class="item-in-item">
                                    <li class="in-item-first"><a href="#">맨즈</a></li>
                                    <li><a href="#">우먼즈</a></li>
                                    <li><a href="#">테니스</a></li>
                                    <li><a href="#">용품</a></li>
                                </ul>
                            </li>
                            <li class="mtitle"><a href="#">1+1</a>
                                <ul class="item-in-item">
                                    <li class="in-item-first"><a href="#">상의</a></li>
                                    <li><a href="#">하의</a></li>
                                    <li><a href="#">용품</a></li>
                                </ul>
                            </li>
                            <li class="mtitle"><a href="#">우먼즈</a>
                                <ul class="item-in-item">
                                    <li class="in-item-first"><a href="#">상의</a></li>
                                    <li><a href="#">하의</a></li>
                                    <li><a href="#">아우터</a></li>
                                    <li><a href="#">조거팬츠</a></li>
                                    <li><a href="#">세트</a></li>
                                </ul>
                            </li>
                            <li class="mtitle"><a href="#">맨즈</a>
                                <ul class="item-in-item">
                                    <li class="in-item-first"><a href="#">상의</a></li>
                                    <li><a href="#">하의</a></li>
                                    <li><a href="#">아우터</a></li>
                                    <li><a href="#">조거팬츠</a></li>
                                    <li><a href="#">세트</a></li>
                                </ul>
                            </li>
                            <li class="mtitle"><a href="#">테니스</a>
                                <ul class="item-in-item">
                                    <li class="in-item-first"><a href="#">맨즈</a></li>
                                    <li><a href="#">우먼즈</a></li>
                                    <li><a href="#">용품</a></li>
                                </ul>
                            </li>
                            <li class="mtitle"><a href="#">용품</a>
                                <ul class="item-in-item">
                                    <li class="in-item-first"><a href="#">양말</a></li>
                                    <li><a href="#">모자</a></li>
                                    <li><a href="#">가방</a></li>
                                    <li><a href="#">홈트용품</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </header>
