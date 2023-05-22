<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko" translage="no">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MyWebSite</title>

    <!-- SEO meta tag -->
    <meta name="google" content="notranslate" />
    <meta name="description" content="검색결과에 표시될 내용" />
    <meta name="robots" content="index,follow" />
    <meta name="keywords" content="SEO,검색엔진 최적화,메타 태그" />
    <meta name="author" content="AnGaHyeon" />

    <!-- SNS meta tag -->
    <meta property="og:type" content="website" />
    <meta property="og:title" content="페이지 제목" />
    <meta property="og:description" content="페이지 설명" />
    <meta property="og:image" content="http://www.mysite.com/myimage.jpg" />
    <meta property="og:url" content="http://www.mysite.com" />

    <!-- reset.css -->
    <link rel="stylesheet" href="${contextPath}/assets/css/reset.css" />

    <!--구글 웹 폰트 사용-->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap"rel="stylesheet"/> 

    <!--아이콘 폰트 사용(Font Awesome)-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"/>

    <!--공통 css-->
    <link rel="stylesheet" href="${contextPath}/assets/css/common.css"/>

    <!--css-->
    <link rel="stylesheet" href="${contextPath}/assets/css/community_write.css"/>

    
</head>

<body>
    <!--사이트의 전체 컨테이너-->
    <div class="container">
        <!--상단 영역-->
        <div class="advertise">
            <a href="#"><h1>카카오톡 채널 추가 시 3천원 추가 할인!</h1></a>
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

        <!--메인 내용 영역-->
        <section class="main">
            <div class="content-container">
                <h1>커뮤니티</h1>
                <ul>
                    <li><a href="#" class="content-first">공지사항</a></li>
                    <li><a href="#">자주 묻는 질문</a></li>
                    <li><a href="#">상품 문의</a></li>
                    <li><a href="#">반품 문의</a></li>
                    <li><a href="#">교환 문의</a></li>
                    <li><a href="#" class="content-last">전국 매장 안내</a></li>
                </ul>
                <form class="form-horizontal" name="join_form" id="join_form">
                    <div class="content-a content0">
                        <span><p>TITLE</p></span>
                        <input class="text_title" type="text" name="text_title" id="text_title" maxlength="30" />
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
                    <div class="content-a content3">
                        <span><p>FILE</p></span>
                        <input class="content3-file" type="file" name="content3-file" id="content3-file" />
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

        <!--하단 영역-->
        <footer class="footer">
            <div class="item-left">
                <div class="top-item">
                    <div class="top-item1">
                        <a href="#" class="footer-logo">
                            <img src="${contextPath}/assets/img/xexymix_header_logo_bk.png"/>
                        </a>
                        <p>애슬레저 1위, 브랜드 고객충성도 애슬레저룩 부문 2년 연속 대상 [2021, 2022]</p>
                    </div>
                    <div class="top-item2">
                        <ul>
                            <li class="no-border">
                                <div><a href="#">브랜드 스토리</a></div>
                            </li>
                            <li>
                                <div><a href="#">회사소개</a></div>
                            </li>
                            <li>
                                <div><a href="#">이용약관</a></div>
                            </li>
                            <li class="bold">
                                <div><a href="#">개인정보처리방침</a></div>
                            </li>
                            <li>
                                <div><a href="#">고객센터</a></div>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="middle-item">
                    <span class="middle-first">사업자명: (주)브랜드엑스코퍼레이션 &nbsp;| &nbsp;대표자명: 이수연, 강민준 &nbsp;|&nbsp; 팩스: 02-2179-9410</span>
                    <span>주소: 서울시 성동구 뚝섬로1길 63 영창디지탈타워 B2F,4F,6F,12F,16F | 대표전화 : 1661-2811</span>
                    <span>반품주소지 : 경기도 의정부시 산단로98번길 65 303호 젝시믹스</span> 
                    <span>사업자등록번호 : 550-86-00867 [사업자정보확인] &nbsp;|&nbsp; 통신판매업신고번호 : 2019-서울성동-01148</span>         
                    <span>제안/제휴문의 : 온라인 <a href="mailto: brx_brmkt@brandxcorp.com">brx_brmkt@brandxcorp.com</a> 
                        / 오프라인 <a href="mailto: brxoffline@brandxcorp.com">brxoffline@brandxcorp.com</a>
                        / 해외 <a href="mailto: xexybiz@brandxcorp.com">xexybiz@brandxcorp.com</a>
                    </span>
                    <span>개인정보보호책임자 : 강교혁 <a href="mailto: asitakak@brandxcorp.com">(asitakak@brandxcorp.com) </a></span>
                </div>
                <div class="bottom-item">
                    <span class="bottom-first">젝시믹스 마케팅은 <a href="https://www.e-ruda.net/">이루다마케팅</a>이 함께합니다. &nbsp;|&nbsp; 호스팅사 : (주)커넥트웨이브</span>
                    <span>Copyright 2015 Xexymix All Rights Reserved.</span>
                </div>
            </div>
            <div class="item-right">
                <div class="right-item-first">
                    <span class="tel-number">1661-2811</span>
                    <span>평일   10:00 - 17:00</span>
                    <span>점심   12:30 - 14:00</span>
                    <span>휴일   토/일/공휴일</span>
                </div>
                <div class="right-item-second">
                    <span class="subject">BANK INFO</span>
                    <span>우리은행   1005-703-294024</span>
                    <span>국민은행   431801-01-213327</span>
                    <span>농       협   301-0259-9190-4</span>
                    <span>(주)브랜드엑스코퍼레이션</span>
                    <span>입금자명 불일치시 자동연동이 되지않습니다.</span>
                    <span>고객센터 또는 Q&A 문의주세요.</span>
                </div>
                <div class="right-item-third">
                    <span class="subject">SHOP MENU</span>
                    <span><a href="#">공지사항</a></span>
                    <span><a href="#">회원정책</a></span>
                    <span><a href="#">전국매장안내</a></span>
                    <span><a href="#">강사회원</a></span>
                    <span><a href="#">기업회원</a></span>
                </div>
            </div>
        </footer>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script>
        $("#menu-open").on("click", (e) =>{
            $("#entire-menu-id").show();
        })

        $("#menu-close").on("click", (e) =>{
            $("#entire-menu-id").hide();
        })
    </script>

    <script>
        $("#search-open").on("click", (e) => {
            $("#main-search-form").show();
        })

        $("#search-close").on("click", (e) => {
            $("#main-search-form").hide();
        })
    </script>

    <script>
        $("#main-search-form").on("submit", (e) => {
            e.preventDefault();

            const searching = $("#main-search");
            if (!searching.val()) {
                alert("검색어를 입력하세요.");
                searching.focus();
                return false;
            }
        });
    </script>
</body>
</html>