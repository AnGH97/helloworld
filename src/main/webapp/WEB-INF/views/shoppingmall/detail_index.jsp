<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/inc/top.jsp" />
<!--community_index stype-->
<link rel="stylesheet" href="${contextPath}/assets/css/detail_index.css" />

<!--메인 내용 영역-->
<section class="main">
    <form method="post" action="${contextPath}/shoppingmall/detail_index_add_ok.do"class="product-choice" name="product-choice" id="product-choice">
        <div class="detail-top">
            <div class="detail-top-img">
                <img class="preview" id="target" src="${contextPath}/assets/img/andar-deatil-top-img1.jpg"/>
                <ul>
                    <li class="item pull-left"><img class="thumbnail" src="${contextPath}/assets/img/andar-deatil-top-img1.jpg"/></li>
                    <li class="item pull-left"><img class="thumbnail" src="${contextPath}/assets/img/andar-deatil-top-img2.jpg"/></li>
                    <li class="item pull-left"><img class="thumbnail" src="${contextPath}/assets/img/andar-deatil-top-img3.jpg"/></li>
                    <li class="item pull-left"><img class="thumbnail" src="${contextPath}/assets/img/andar-deatil-top-img4.jpg"/></li>
                    <li class="item pull-left"><img class="thumbnail" src="${contextPath}/assets/img/andar-deatil-top-img5.jpg"/></li>
                </ul>
            </div>
            <div class="detail-top-text">
                <div class="detail-top-text-first">
                    <span class="detail-product-name"><p>V업 3D 플러스 레깅스 1+1</p></span>
                    <span class="detail-product-code">XWFMG01H2</span>
                </div>
                <div class="detail-top-text-second">
                    <div class="detail-top-text-second-num1">
                        <div class="detail-top-text-second-left"><p>판매가</p></div>
                        <div class="detail-top-text-second-right"><p class="price1">88,000원</p> <p class="price2">58,800원</p></div>
                    </div>
                    <div class="detail-top-text-second-num2">   
                        <div class="detail-top-text-second-left"><p>멤버쉽 할인가</p></div>
                        <div class="detail-top-text-second-right">
                            <a class="right-first">펼쳐보기<i class="fa fa-angle-down" aria-hidden="true"></i>
                                <ul class="membership">
                                    <li>멤버쉽 할인가</li>
                                    <li><p>VVIP</p> <p>10%</p> <p class="m-price">52,920원</p></li>
                                    <li><p> VIP</p> <p>7%</p> <p class="m-price">54,684원</p></li>
                                    <li><p>PREMIUM</p> <p>5%</p> <p class="m-price">55,860원</p></li>
                                    <li><p>FAMILY</p> <p>3%</p> <p class="m-price">57,036원</p></li>
                                    <li><p>FRIEND</p> <p>1%</p> <p class="m-price">58,212원</p></li>
                                    <li class="right-li-last"><p>HELLO</p> <p class="m-price">58,800원</p></li>
                                </ul>
                            </a>
                        </div>
                    </div>
                    <div class="detail-top-text-second-num3">   
                        <div class="detail-top-text-second-left"><p>포인트</p></div>
                        <div class="detail-top-text-second-right"><p>1% ~ 최대 5%</p></div>
                    </div>
                    <div class="detail-top-text-second-num4">   
                        <div class="detail-top-text-second-left"><p>선택1</p></div>
                        <div  class="detail-top-text-second-right">
                            <label for="choice1">
                                <select name="choice1" id="choice1">
                                    <option value="">옵션 선택</option>
                                    <option value="블랙,S">블랙 S</option>
                                    <option value="블랙,M">블랙 M</option>
                                    <option value="블랙,L">블랙 L</option>
                                    <option value="블랙,XL">블랙 XL</option>
                                    <option value="모로칸블루,S">모로칸블루 S</option>
                                    <option value="모로칸블루,M">모로칸블루 M</option>
                                    <option value="모로칸블루,L">모로칸블루 L</option>
                                    <option value="모로칸블루,XL">모로칸블루 XL</option>
                                    <option value="오팔그레이,S">오팔그레이 S</option>
                                    <option value="오팔그레이,M">오팔그레이 M</option>
                                    <option value="오팔그레이,L">오팔그레이 L</option>
                                    <option value="오팔그레이,XL">오팔그레이 XL</option>
                                    <option value="이브닝그레이,S">이브닝그레이 S</option>
                                    <option value="이브닝그레이,M">이브닝그레이 M</option>
                                    <option value="이브닝그레이,L">이브닝그레이 L</option>
                                    <option value="이브닝그레이,XL">이브닝그레이 XL</option>
                                </select>
                            </label>
                        </div>
                    </div>
                    <div class="detail-top-text-second-num5">   
                        <div class="detail-top-text-second-left"><p>선택2</p></div>
                        <div  class="detail-top-text-second-right">
                            <label for="choice2">
                                <select name="choice2" id="choice2">
                                    <option value="">옵션 선택</option>
                                    <option value="블랙,S">블랙 S</option>
                                    <option value="블랙,M">블랙 M</option>
                                    <option value="블랙,L">블랙 L</option>
                                    <option value="블랙,XL">블랙 XL</option>
                                    <option value="모로칸블루,S">모로칸블루 S</option>
                                    <option value="모로칸블루,M">모로칸블루 M</option>
                                    <option value="모로칸블루,L">모로칸블루 L</option>
                                    <option value="모로칸블루,XL">모로칸블루 XL</option>
                                    <option value="오팔그레이,S">오팔그레이 S</option>
                                    <option value="오팔그레이,M">오팔그레이 M</option>
                                    <option value="오팔그레이,L">오팔그레이 L</option>
                                    <option value="오팔그레이,XL">오팔그레이 XL</option>
                                    <option value="이브닝그레이,S">이브닝그레이 S</option>
                                    <option value="이브닝그레이,M">이브닝그레이 M</option>
                                    <option value="이브닝그레이,L">이브닝그레이 L</option>
                                    <option value="이브닝그레이,XL">이브닝그레이 XL</option>
                                </select>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="detail-top-text-third">
                    <span>총합계</span>
                    <span class="t-price"><p>0</p>&nbsp;원</span>
                </div>
                <div class="detail-top-text-fourth">
                    <button type="submit" class="shopping-cart">장바구니</button>
                    <div class="buying"><a href="#"><p>구매하기</p></a></div>
                </div>
            </div>
        </div> 
    </form>
    <div class="with-item-text"><span>같이 코디한 아이템</span></div>
    <div class="detail-top-with-items">
        <div class="detail-top-with-items-first">
            <a href="${contextPath}/shoppingmall/detail_index"><img src="${contextPath}/assets/img/andar-deatil-top-img1.jpg"/>
                <div class="detail-top-with-items-text">
                    <span class="detail-top-with-items-name"><p>[1+1] 에어쿨링 지니 시그니처 레깅스</p></span>
                    <span class="detail-top-with-items-price"><p class="sale">50%</p> <p class="s-price">49,000원</p> <p class="r-price">98,000원</p></span>
                </div>
            </a></div>
        <div class="detail-top-with-items-second">
            <a href="${contextPath}/shoppingmall/detail_index"><img src="${contextPath}/assets/img/andar-deatil-top-img2.jpg"/>
                <div class="detail-top-with-items-text">
                    <span class="detail-top-with-items-name"><p>[1+1] 에어쿨링 지니 시그니처 레깅스</p></span>
                    <span class="detail-top-with-items-price"><p class="sale">50%</p> <p class="s-price">49,000원</p> <p class="r-price">98,000원</p></span>
                </div>
            </a></div>
        <div class="detail-top-with-items-third">
            <a href="${contextPath}/shoppingmall/detail_index"><img src="${contextPath}/assets/img/andar-deatil-top-img3.jpg"/>
                <div class="detail-top-with-items-text">
                    <span class="detail-top-with-items-name"><p>[1+1] 에어쿨링 지니 시그니처 레깅스</p></span>
                    <span class="detail-top-with-items-price"><p class="sale">50%</p> <p class="s-price">49,000원</p> <p class="r-price">98,000원</p></span>
                </div>
            </a></div>
        <div class="detail-top-with-items-fourth">
            <a href="${contextPath}/shoppingmall/detail_index"><img src="${contextPath}/assets/img/andar-deatil-top-img4.jpg"/>
                <div class="detail-top-with-items-text">
                    <span class="detail-top-with-items-name"><p>[1+1] 에어쿨링 지니 시그니처 레깅스</p></span>
                    <span class="detail-top-with-items-price"><p class="sale">50%</p> <p class="s-price">49,000원</p> <p class="r-price">98,000원</p></span>
                </div>
            </a></div>
    </div> 
    <div class="detail-middle">
        <div class="detail-middle-menu">
            <ul>
                <li class="detail-middle-menu1 dmbt"><a href="#detail-middle-text">상세정보</a></li>
                <li class="detail-middle-menu2 dmbt"><a href="#detail-middle-review">리뷰 3,620</a></li>
                <li class="detail-middle-menu3 dmbt"><a href="#size-recomend">사이즈정보</a></li>
                <li class="detail-middle-menu4 dmbt"><a href="#delivery">구매안내</a></li>
            </ul>
        </div>
        <div class="detail-middle-review" id="detail-middle-review">
            <span class="middle-review-title"><p class="review">리뷰</p><p class="review-count">3,620</p></span>
            <div class="detail-middle-review-star">
                <div class="star-top">
                    <div class="star-emo">
                        <div class="star-emo-top">
                            <i class="fa-solid fa-star" style="color: #fbca18;"></i>
                            <span>4.9</span>
                        </div>
                        <div class="star-emo-bottom">
                            <span>99%의 구매자가 이 상품을 좋아합니다.</span>
                        </div>
                    </div>
                    <div class="star-score">
                        <div class="sscore very-good">
                            <span class="score-text">아주 좋아요</span>
                            <div class="sscore-bar">
                                <div class="sscore-bar-i very-good-score"></div>
                            </div>
                            <span class="score-cnt">761</span>
                        </div>
                        <div class="sscore good">
                            <span class="score-text">맘에 들어요</span>
                            <div class="sscore-bar">
                                <div class="sscore-bar-i good-score"></div>
                            </div>
                            <span class="score-cnt">32</span>
                        </div>
                        <div class="sscore soso">
                            <span class="score-text">보통이에요</span>
                            <div class="sscore-bar">
                                <div class="sscore-bar-i soso-score"></div>
                            </div>
                            <span class="score-cnt">4</span>
                        </div>
                        <div class="sscore bad">
                            <span class="score-text">그냥 그래요</span>
                            <div class="sscore-bar">
                                <div class="sscore-bar-i bad-score"></div>
                            </div>
                            <span class="score-cnt">1</span>
                        </div>
                        <div class="sscore very-bad">
                            <span class="score-text">별로에요</span>
                            <div class="sscore-bar">
                                <div class="sscore-bar-i very-bad-score"></div>
                            </div>
                            <span class="score-cnt">1</span>
                        </div>
                    </div>
                </div>
                <div class="star-middle" id="star-middle">
                    <div class="star-middle1">
                        <button type=button class="bt date-resc" id="date-resc" onclick="location.href='#star-middle'">최신순</button>
                        <button type=button class="bt star-up" id="star-up" onclick="location.href='#star-middle'">높은 별점순</button>
                        <button type=button class="bt star-down" id="star-down" onclick="location.href='#star-middle'">낮은 별점순</button>
                    </div>
                    <div class="star-middle2">
                        <table align="center">
                            <tbody>
                                <tr>
                                    <td class="td1">
                                        <div class="td1-1">
                                            <div class="star-emo">
                                                <label for="star-review1">
                                                    <input type="checkbox" id="star-review1" name="star-review1" class="value1" value="1" />
                                                    <i class="fa-solid fa-star" style="color: #fbca18;"></i>
                                                </label>
                                                <label for="star-review2">
                                                    <input type="checkbox" id="star-review2" name="star-review2" class="value2" value="2" />
                                                    <i class="fa-solid fa-star" style="color: #fbca18;"></i>
                                                </label>
                                                <label for="star-review3">
                                                    <input type="checkbox" id="star-review3" name="star-review3" class="value3" value="3" />
                                                    <i class="fa-solid fa-star" style="color: #fbca18;"></i>
                                                </label>
                                                <label for="star-review4">
                                                    <input type="checkbox" id="star-review4" name="star-review4" class="value1" value="4" />
                                                    <i class="fa-solid fa-star" style="color: #fbca18;"></i>
                                                </label>
                                                <label for="star-review5">
                                                    <input type="checkbox" id="star-review5" name="star-review5" class="value5" value="5" />
                                                    <i class="fa-solid fa-star" style="color: #fbca18;"></i>
                                                </label>
                                            </div>
                                            <div class="star-text">아주 좋아요</div>
                                        </div>
                                        <div class="read-text"><span>리뷰가 작성된 공간입니다.!!!!!!!!!!!!!!!!!!!!!!!!!!!</span></div>
                                    </td>
                                    <td class="td2">2023.05.18</td>
                                </tr>
                                <tr>
                                    <td class="td1">
                                        <div class="td1-1">
                                            <div class="star-emo">
                                                <label for="star-review1">
                                                    <input type="checkbox" id="star-review1" name="star-review1" class="value1" value="1" />
                                                    <i class="fa-solid fa-star" style="color: #fbca18;"></i>
                                                </label>
                                                <label for="star-review2">
                                                    <input type="checkbox" id="star-review2" name="star-review2" class="value2" value="2" />
                                                    <i class="fa-solid fa-star" style="color: #fbca18;"></i>
                                                </label>
                                                <label for="star-review3">
                                                    <input type="checkbox" id="star-review3" name="star-review3" class="value3" value="3" />
                                                    <i class="fa-solid fa-star" style="color: #fbca18;"></i>
                                                </label>
                                                <label for="star-review4">
                                                    <input type="checkbox" id="star-review4" name="star-review4" class="value1" value="4" />
                                                    <i class="fa-solid fa-star" style="color: #fbca18;"></i>
                                                </label>
                                                <label for="star-review5">
                                                    <input type="checkbox" id="star-review5" name="star-review5" class="value5" value="5" />
                                                    <i class="fa-solid fa-star" style="color: #fbca18;"></i>
                                                </label>
                                            </div>
                                            <div class="star-text">아주 좋아요</div>
                                        </div>
                                        <div class="read-text"><span>리뷰가 작성된 공간입니다.!!!!!!!!!!!!!!!!!!!!!!!!!!!</span></div>
                                    </td>
                                    <td class="td2">2023.05.18</td>
                                </tr>
                                <tr>
                                    <td class="td1">
                                        <div class="td1-1">
                                            <div class="star-emo">
                                                <label for="star-review1">
                                                    <input type="checkbox" id="star-review1" name="star-review1" class="value1" value="1" />
                                                    <i class="fa-solid fa-star" style="color: #fbca18;"></i>
                                                </label>
                                                <label for="star-review2">
                                                    <input type="checkbox" id="star-review2" name="star-review2" class="value2" value="2" />
                                                    <i class="fa-solid fa-star" style="color: #fbca18;"></i>
                                                </label>
                                                <label for="star-review3">
                                                    <input type="checkbox" id="star-review3" name="star-review3" class="value3" value="3" />
                                                    <i class="fa-solid fa-star" style="color: #fbca18;"></i>
                                                </label>
                                                <label for="star-review4">
                                                    <input type="checkbox" id="star-review4" name="star-review4" class="value1" value="4" />
                                                    <i class="fa-solid fa-star" style="color: #fbca18;"></i>
                                                </label>
                                                <label for="star-review5">
                                                    <input type="checkbox" id="star-review5" name="star-review5" class="value5" value="5" />
                                                    <i class="fa-solid fa-star" style="color: #fbca18;"></i>
                                                </label>
                                            </div>
                                            <div class="star-text">아주 좋아요</div>
                                        </div>
                                        <div class="read-text"><span>리뷰가 작성된 공간입니다.!!!!!!!!!!!!!!!!!!!!!!!!!!!</span></div>
                                    </td>
                                    <td class="td2">2023.05.18</td>
                                </tr>
                                <tr>
                                    <td class="td1">
                                        <div class="td1-1">
                                            <div class="star-emo">
                                                <label for="star-review1">
                                                    <input type="checkbox" id="star-review1" name="star-review1" class="value1" value="1" />
                                                    <i class="fa-solid fa-star" style="color: #fbca18;"></i>
                                                </label>
                                                <label for="star-review2">
                                                    <input type="checkbox" id="star-review2" name="star-review2" class="value2" value="2" />
                                                    <i class="fa-solid fa-star" style="color: #fbca18;"></i>
                                                </label>
                                                <label for="star-review3">
                                                    <input type="checkbox" id="star-review3" name="star-review3" class="value3" value="3" />
                                                    <i class="fa-solid fa-star" style="color: #fbca18;"></i>
                                                </label>
                                                <label for="star-review4">
                                                    <input type="checkbox" id="star-review4" name="star-review4" class="value1" value="4" />
                                                    <i class="fa-solid fa-star" style="color: #fbca18;"></i>
                                                </label>
                                                <label for="star-review5">
                                                    <input type="checkbox" id="star-review5" name="star-review5" class="value5" value="5" />
                                                    <i class="fa-solid fa-star" style="color: #fbca18;"></i>
                                                </label>
                                            </div>
                                            <div class="star-text">아주 좋아요</div>
                                        </div>
                                        <div class="read-text"><span>리뷰가 작성된 공간입니다.!!!!!!!!!!!!!!!!!!!!!!!!!!!</span></div>
                                    </td>
                                    <td class="td2">2023.05.18</td>
                                </tr>
                                <tr>
                                    <td class="td1">
                                        <div class="td1-1">
                                            <div class="star-emo">
                                                <label for="star-review1">
                                                    <input type="checkbox" id="star-review1" name="star-review1" class="value1" value="1" />
                                                    <i class="fa-solid fa-star" style="color: #fbca18;"></i>
                                                </label>
                                                <label for="star-review2">
                                                    <input type="checkbox" id="star-review2" name="star-review2" class="value2" value="2" />
                                                    <i class="fa-solid fa-star" style="color: #fbca18;"></i>
                                                </label>
                                                <label for="star-review3">
                                                    <input type="checkbox" id="star-review3" name="star-review3" class="value3" value="3" />
                                                    <i class="fa-solid fa-star" style="color: #fbca18;"></i>
                                                </label>
                                                <label for="star-review4">
                                                    <input type="checkbox" id="star-review4" name="star-review4" class="value1" value="4" />
                                                    <i class="fa-solid fa-star" style="color: #fbca18;"></i>
                                                </label>
                                                <label for="star-review5">
                                                    <input type="checkbox" id="star-review5" name="star-review5" class="value5" value="5" />
                                                    <i class="fa-solid fa-star" style="color: #fbca18;"></i>
                                                </label>
                                            </div>
                                            <div class="star-text">아주 좋아요</div>
                                        </div>
                                        <div class="read-text"><span>리뷰가 작성된 공간입니다.!!!!!!!!!!!!!!!!!!!!!!!!!!!</span></div>
                                    </td>
                                    <td class="td2">2023.05.18</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="star-bottom">
                    <button type="button" class="more" id="more" name="more">더보기</button>
                    <a href="${contextPath}/shoppingmall/review_community_write"><p>리뷰 작성하기</p></a>
                </div>
            </div>
        </div>
        <div class="detail-middle-text"id="detail-middle-text">
            <span class="detail-inform"><h4>상세정보</h4></span>
            <div class="detail-middle-text-img1">
                <img src="${contextPath}/assets/img/xexymix_detail_img11.jpg" />
                <div class="detail-middle-inform1">
                    <div class="detail_img11_text1">
                        <span><p>나의 라이프 스타일<br/>플러스 해 줄 레깅스,</p></span>
                    </div>
                    <div class="detail_img11_text2">
                        <span><p>Vup 3D plus<br/>레깅스</p></span>
                    </div>
                </div>
            </div>
            <div class="dtimg detail-middle-text-img2">
                <img src="${contextPath}/assets/img/xexymix_detail_img21.jpg" />
                <div class="dminform detail-middle-inform2">
                    <div class="ditext1 detail_img21_text1">
                        <span><p>어반 라이프를<br/>+하다</p></span>
                    </div>
                    <div class="ditext2 detail_img21_text2">
                        <span><p>일상엔 다 움직임이 있으니깐,<br/>온전히 나만을 위해움직일 수 있게 해주는
                        <br />Vup 3D plus와 완벽한 하루를 만들어 보세요.</p></span>
                    </div>
                    <hr />
                    <div class="ditext3 detail_img21_text3">
                        <span><p>카본네이비</p></span>
                    </div>
                </div>
            </div>
            <div class="detail-middle-text-img3">
                <img src="${contextPath}/assets/img/xexymix_detail_img31.jpg" />
            </div>
            <div class="dtimg detail-middle-text-img4">
                <img src="${contextPath}/assets/img/xexymix_detail_img41.jpg" />
                <div class="dminform detail-middle-inform3">
                    <div class="ditext1 detail_img41_text1">
                        <span><p>업그레이드 된 입체패턴과<br/>20가지 컬러 라인업</p></span>
                    </div>
                    <div class="ditext2 detail_img41_text2">
                        <span><p>Vup 3D plus와<br/>온전히 나만을 위한
                        <br />맞춤 핏을 찾아보세요!</p></span>
                    </div>
                    <hr />
                    <div class="ditext3 detail_img41_text3">
                        <span><p>크라운블루</p></span>
                    </div>
                </div>
            </div>
            <div class="detail-middle-text-img5">
                <img src="${contextPath}/assets/img/xexymix_detail_img51.jpg" />
            </div>
            <div class="dtimg detail-middle-text-img6">
                <img src="${contextPath}/assets/img/xexymix_detail_img61.jpg" />
                <div class="dminform detail-middle-inform4">
                    <div class="ditext1 detail_img61_text1">
                        <span><p>운동 시, 데일리,<br/>어느 상황에도 쾌적하게</p></span>
                    </div>
                    <div class="ditext2 detail_img61_text2">
                        <span><p>체형 보정 효과는 물론,<br/>흡한속건 기능도 뛰어나서
                        <br />쾌적하게 착용 할 수 있어요.</p></span>
                    </div>
                    <hr />
                    <div class="ditext3 detail_img61_text3">
                        <span><p>인디고블루</p></span>
                    </div>
                </div>
            </div>
            <div class="detail-middle-text-img7">
                <img src="${contextPath}/assets/img/xexymix_detail_img71.jpg" />
            </div>
            <div class="dtimg detail-middle-text-img8">
                <img src="${contextPath}/assets/img/xexymix_detail_img81.jpg" />
                <div class="dminform detail-middle-inform5">
                    <div class="ditext1 detail_img81_text1">
                        <span><p>완벽하게<br/>커버되는 Y존</p></span>
                    </div>
                    <div class="ditext2 detail_img81_text2">
                        <span><p>앞부분 절개선을 삭제하고<br/>밑으로 당겨지는 듯한 패턴으로
                        <br />완벽하게 Y존을 커버해 줍니다.</p></span>
                    </div>
                    <hr />
                    <div class="ditext3 detail_img81_text3">
                        <span><p>비쥬블루</p></span>
                    </div>
                </div>
            </div>
            <div class="detail-middle-text-img9">
                <img src="${contextPath}/assets/img/xexymix_detail_img91.jpg" />
            </div>
            <div class="dtimg detail-middle-text-img10">
                <img src="${contextPath}/assets/img/xexymix_detail_img101.jpg" />
                <div class="dminform detail-middle-inform6">
                    <div class="ditext1 detail_img101_text1">
                        <span><p>면과 흡사한 구조로 직조한<br/>부드러운 촉감</p></span>
                    </div>
                    <div class="ditext2 detail_img101_text2">
                        <span><p>면과 흡사한 구조로 직조하여<br/>피부에 닿는 촉감이 부드럽고
                        <br />허리와 배, 허벅지를 탄탄하게 잡아줘요.</p></span>
                    </div>
                    <hr />
                    <div class="ditext3 detail_img101_text3">
                        <span><p>실버파인</p></span>
                    </div>
                </div>
            </div>
            <div class="detail-middle-text-img11">
                <img src="${contextPath}/assets/img/xexymix_detail_img111.jpg" />
            </div>
            <div class="dtimg detail-middle-text-img12">
                <img src="${contextPath}/assets/img/xexymix_detail_img121.jpg" />
                <div class="dminform detail-middle-inform7">
                    <div class="ditext1 detail_img121_text1">
                        <span><p>다리가<br/>더 길어보이는 비밀</p></span>
                    </div>
                    <div class="ditext2 detail_img121_text2">
                        <span><p>프런트 허리선 라인을<br/>U자 형태로 디자인하여
                        <br />다리가 더 길어 보입니다.</p></span>
                    </div>
                    <hr />
                    <div class="ditext3 detail_img121_text3">
                        <span><p>어텀카키</p></span>
                    </div>
                </div>
            </div>
            <div class="detail-middle-text-img13">
                <img src="${contextPath}/assets/img/xexymix_detail_img131.jpg" />
            </div>
            <div class="dtimg detail-middle-text-img14">
                <img src="${contextPath}/assets/img/xexymix_detail_img141.jpg" />
                <div class="dminform detail-middle-inform8">
                    <hr />
                    <div class="ditext3 detail_img141_text3">
                        <span><p>윈저클래식</p></span>
                    </div>
                </div>
            </div>
            <div class="detail-middle-text-img15">
                <img src="${contextPath}/assets/img/xexymix_detail_img151.jpg" />
            </div>
            <div class="dtimg detail-middle-text-img16">
                <img src="${contextPath}/assets/img/xexymix_detail_img161.jpg" />
                <div class="dminform detail-middle-inform9">
                    <hr />
                    <div class="ditext3 detail_img161_text3">
                        <span><p>체스트브라운</p></span>
                    </div>
                </div>
            </div>
            <div class="detail-middle-text-img17">
                <img src="${contextPath}/assets/img/xexymix_detail_img171.jpg" />
            </div>
            <div class="dtimg detail-middle-text-img18">
                <img src="${contextPath}/assets/img/xexymix_detail_img181.jpg" />
                <div class="dminform detail-middle-inform10">
                    <hr />
                    <div class="ditext3 detail_img181_text3">
                        <span><p>루이보스</p></span>
                    </div>
                </div>
            </div>
            <div class="detail-middle-text-img19">
                <img src="${contextPath}/assets/img/xexymix_detail_img191.jpg" />
            </div>
            <div class="dtimg detail-middle-text-img20">
                <img src="${contextPath}/assets/img/xexymix_detail_img201.jpg" />
                <div class="dminform detail-middle-inform11">
                    <hr />
                    <div class="ditext3 detail_img201_text3">
                        <span><p>어텀글레이즈</p></span>
                    </div>
                </div>
            </div>
            <div class="detail-middle-text-img21">
                <img src="${contextPath}/assets/img/xexymix_detail_img211.jpg" />
            </div>
            <div class="dtimg detail-middle-text-img22">
                <img src="${contextPath}/assets/img/xexymix_detail_img221.jpg" />
                <div class="dminform detail-middle-inform12">
                    <hr />
                    <div class="ditext3 detail_img221_text3">
                        <span><p>미네랄핑크</p></span>
                    </div>
                </div>
            </div>
            <div class="detail-middle-text-img23">
                <img src="${contextPath}/assets/img/xexymix_detail_img231.jpg" />
            </div>
            <div class="dtimg detail-middle-text-img24">
                <img src="${contextPath}/assets/img/xexymix_detail_img241.jpg" />
                <div class="dminform detail-middle-inform13">
                    <hr />
                    <div class="ditext3 detail_img241_text3">
                        <span><p>페르시안레드</p></span>
                    </div>
                </div>
            </div>
            <div class="detail-middle-text-img25">
                <img src="${contextPath}/assets/img/xexymix_detail_img251.jpg" />
            </div>
            <div class="dtimg detail-middle-text-img26">
                <img src="${contextPath}/assets/img/xexymix_detail_img261.jpg" />
                <div class="dminform detail-middle-inform14">
                    <hr />
                    <div class="ditext3 detail_img261_text3">
                        <span><p>크러쉬베리</p></span>
                    </div>
                </div>
            </div>
            <div class="detail-middle-text-img27">
                <img src="${contextPath}/assets/img/xexymix_detail_img271.jpg" />
            </div>
            <div class="dtimg detail-middle-text-img28">
                <img src="${contextPath}/assets/img/xexymix_detail_img281.jpg" />
                <div class="dminform detail-middle-inform14">
                    <hr />
                    <div class="ditext3 detail_img281_text3">
                        <span><p>우드로즈</p></span>
                    </div>
                </div>  
            </div>
            <div class="detail-middle-text-img29">
                <img src="${contextPath}/assets/img/xexymix_detail_img291.jpg" />
            </div>
            <div class="dtimg detail-middle-text-img30">
                <img src="${contextPath}/assets/img/xexymix_detail_img301.jpg" />
                <div class="dminform detail-middle-inform14">
                    <hr />
                    <div class="ditext3 detail_img301_text3">
                        <span><p>푸시아로즈</p></span>
                    </div>
                </div>
            </div>
            <div class="detail-middle-text-img31">
                <img src="${contextPath}/assets/img/xexymix_detail_img311.jpg" />
            </div>
            <div class="dtimg detail-middle-text-img32">
                <img src="${contextPath}/assets/img/xexymix_detail_img321.jpg" />
                <div class="dminform detail-middle-inform14">
                    <hr />
                    <div class="ditext3 detail_img321_text3">
                        <span><p>푸딩베이지</p></span>
                    </div>
                </div>
            </div>
            <div class="detail-middle-text-img33">
                <img src="${contextPath}/assets/img/xexymix_detail_img331.jpg" />
            </div>
            <div class="dtimg detail-middle-text-img34">
                <img src="${contextPath}/assets/img/xexymix_detail_img341.jpg" />
                <div class="dminform detail-middle-inform14">
                    <hr />
                    <div class="ditext3 detail_img341_text3">
                        <span><p>월넛베이지</p></span>
                    </div>
                </div>
            </div>
            <div class="detail-middle-text-img35">
                <img src="${contextPath}/assets/img/xexymix_detail_img351.jpg" />
            </div>
            <div class="dtimg detail-middle-text-img36">
                <img src="${contextPath}/assets/img/xexymix_detail_img361.jpg" />
                <div class="dminform detail-middle-inform14">
                    <hr />
                    <div class="ditext3 detail_img361_text3">
                        <span><p>다크그레이</p></span>
                    </div>
                </div>
            </div>
            <div class="detail-middle-text-img37">
                <img src="${contextPath}/assets/img/xexymix_detail_img371.jpg" />
            </div>
            <div class="dtimg detail-middle-text-img38">
                <img src="${contextPath}/assets/img/xexymix_detail_img381.jpg" />
                <div class="dminform detail-middle-inform14">
                    <hr />
                    <div class="ditext3 detail_img381_text3">
                        <span><p>썬더그레이</p></span>
                    </div>
                </div>
            </div>
            <div class="detail-middle-text-img39">
                <img src="${contextPath}/assets/img/xexymix_detail_img391.jpg" />
            </div>
            <div class="dtimg detail-middle-text-img40">
                <img src="${contextPath}/assets/img/xexymix_detail_img401.jpg" />
                <div class="dminform detail-middle-inform14">
                    <hr />
                    <div class="ditext3 detail_img401_text3">
                        <span><p>블랙</p></span>
                    </div>
                </div>
            </div>
            <div class="detail-middle-text-img41">
                <img src="${contextPath}/assets/img/xexymix_detail_img411.jpg" />
            </div>
            <span class="fabric"><h2>FABRIC INFO</h2>
                <hr class="fabric-hr" />
            </span>
            <div class="fabric-info">
                <div class="detail-middle-text-fabric-info1">
                    <img src="${contextPath}/assets/img/xexymix_detail_fabric_info_img11.jpg" />
                    <div class="fabric_info_text1">
                        <span><p>코튼라이크</p></span>
                    </div>
                    <div class="fabric_info_text2">
                        <span><p>면과 흡사한 터치감을 재현하여 피부에<br/>
                            소프트하게 밀착하여 바디를 부드럽게<br/>
                            감싸줍니다.
                        </p></span>
                    </div>
                </div>
                <div class="detail-middle-text-fabric-info2">
                    <img src="${contextPath}/assets/img/xexymix_detail_fabric_info_img21.jpg" />
                    <div class="fabric_info_text1">
                        <span><p>흡한속건</p></span>
                    </div>
                    <div class="fabric_info_text2">
                        <span><p>활동 시 신체에서 분출되는 땀을 빠르게<br/>
                            흡수·건조하여 언제나 쾌적한 착용감을<br/>
                            느낄 수 있습니다.
                        </p></span>
                    </div>
                </div>
                <div class="detail-middle-text-fabric-info3">
                    <img src="${contextPath}/assets/img/xexymix_detail_fabric_info_img31.jpg" />
                    <div class="fabric_info_text1">
                        <span><p>4방 스트레치</p></span>
                    </div>
                    <div class="fabric_info_text2">
                        <span><p>젝시믹스만의 비율로 원사를 혼합하여<br/>
                            모든 활동에 탁월한 사방 스트레치로<br/>
                            완벽한 퍼포먼스가 가능합니다.
                        </p></span>
                    </div>
                </div>
                <div class="detail-middle-text-fabric-info4">
                    <img src="${contextPath}/assets/img/xexymix_detail_fabric_info_img41.jpg" />
                    <div class="fabric_info_text1">
                        <span><p>우수한 내구성과 형태안정성</p></span>
                    </div>
                    <div class="fabric_info_text2">
                        <span><p>우수한 내구성과 형태 안정성으로<br/>
                            여러번의 세탁과 반복적인 움직임에도<br/>
                            변형이 적습니다.
                        </p></span>
                    </div>
                </div>
            </div>
            <span class="design"><h2>DESIGN POINT</h2>
                <hr class="design-hr" />
            </span>
            <div class="detail-middle-text-design-point1">
                <img class="detail-text-design-point" src="${contextPath}/assets/img/xexymix_detail_design_point_img11.gif" />
                <div class="design_point_text1">
                    <span><p>바디쉐입을 정리해 주는<br/>하이라이즈핏</p></span>
                </div>
                <div class="design_point_text2">
                    <span><p>완벽한 하이라이즈핏으로 복부를 넓고 탄탄하게 잡아줘<br/>
                        운동 시 신경 쓰이는 군살까지 정리해 줍니다.
                    </p></span>
                </div>
            </div>
            <div class="detail-middle-text-design-point2">
                <img class="detail-text-design-point" src="${contextPath}/assets/img/xexymix_detail_design_point_img21.gif" />
                <div class="design_point_text1">
                    <span><p>부위별 압박을 달리한<br/>입체 패턴</p></span>
                </div>
                <div class="design_point_text2">
                    <span><p>입체 라인을 따라 만든 3D 입체 패턴으로<br/>
                        허벅지는 탄력있게, 종아리는 슬림하게, 발목은 편안하게!<br/>
                        하체의 각 부위에 맞춰 강도를 달리한 이상적인 압박 설계로<br/>
                        다리의 피로도를 줄여 하체 부종 현상을 최소화했습니다.
                    </p></span>
                </div>
            </div>
            <div class="detail-middle-text-design-point3">
                <img class="detail-text-design-point" src="${contextPath}/assets/img/xexymix_detail_design_point_img31.gif" />
                <div class="design_point_text1">
                    <span><p>완벽한 Y-zone 커버</p></span>
                </div>
                <div class="design_point_text2">
                    <span><p>밑위 봉제선을 삭제하고 아래 방향으로<br/>
                        당겨지듯이 착용하는 특수화 된 입체패턴을 연구하여<br/>
                        Y라인이 접히는 부분을 완벽 커버하였습니다.
                    </p></span>
                </div>
            </div>
            <div class="detail-middle-text-design-point4">
                <img class="detail-text-design-point" src="${contextPath}/assets/img/xexymix_detail_design_point_img41.gif" />
                <div class="design_point_text1">
                    <span><p>탄탄하게 잡아주는<br/>인심라인</p></span>
                </div>
                <div class="design_point_text2">
                    <span><p>허벅지 안쪽살을 탄탄하게 잡아줄 수 있도록<br/>
                        허벅지 라인을 따라 인심 절개를 넣었으며<br/>
                        원단 결의 반대 방향으로 사용하여 안쪽에서<br/>
                        한번 더 잡아 줘 다리를 더욱 슬림하게 보여줍니다.
                    </p></span>
                </div>
            </div>
            <div class="detail-middle-text-design-point5">
                <img class="detail-text-design-point" src="${contextPath}/assets/img/xexymix_detail_design_point_img51.gif" />
                <div class="design_point_text1">
                    <span><p>입체적인<br/>레그라인</p></span>
                </div>
                <div class="design_point_text2">
                    <span><p>자연스럽고 탄탄한 라인을 위해 사이드 봉제선을 없애<br/>
                        레그라인을 더욱 입체적으로 보여주게 합니다.
                    </p></span>
                </div>
            </div>
            <div class="detail-middle-text-design-point6">
                <img class="detail-text-design-point" src="${contextPath}/assets/img/xexymix_detail_design_point_img61.gif" />
                <div class="design_point_text1">
                    <span><p>선 하나로 완성하는<br/>자연스러운 체형 보정</p></span>
                </div>
                <div class="design_point_text2">
                    <span><p>힙라인의 절개선을 V라인으로 잡아<br/>
                        자연스러운 힙 리프팅 효과를 보여주고,<br/>
                        프론트의 U라인 절개선으로 더욱 긴 다리를 연출해줘요.
                    </p></span>
                </div>
            </div>
        </div>
    </div>
    <div class="detail-bottom">
        <div class="washing">
            <img src="${contextPath}/assets/img/xexymix_washing1.jpg">
        </div>
        <span class="size-recomend" id="size-recomend"><p>사이즈추천</p></span>
        <div class="size-info">
            <div class="pants-info">
                <div class="pants-info-text">
                    <span class="size-info"><p>size info</p></span>
                    <img src="${contextPath}/assets/img/xexymix_pants_size_info.jpg">
                    <span class="size-info-announce"><p>※ 재는 방법, 위치에 따라 약 1~2cm의 오차가 발생 할 수 있습니다.</p></span>
                </div>
                <div class="pants-info-table">
                    <span class="size-cm"><p>size / cm</p></span>
                    <table align="center">
                        <thead>
                            <tr>
                                <th align="center">size</th>
                                <th align="center">S(44~55)</th>
                                <th align="center">M(55반~66)</th>
                                <th align="center">L(66반~77)</th>
                                <th align="center">XL(77~88)</th>
                                <th align="center">XXL(88반~99)</th>
                                <th align="center">XXXL(99반~100)</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th align="center">허리A</th>
                                <td align="center">24.5</td>
                                <td align="center">26.5</td>
                                <td align="center">28.5</td>
                                <td align="center">30.5</td>
                                <td align="center">33</td>
                                <td align="center">36.5</td>
                            </tr>
                            <tr>
                                <th align="center">엉덩이 B</th>
                                <td align="center">33.5</td>
                                <td align="center">35.5</td>
                                <td align="center">37.5</td>
                                <td align="center">39.5</td>
                                <td align="center">42</td>
                                <td align="center">45.5</td>
                            </tr>
                            <tr>
                                <th align="center">밑단 C</th>
                                <td align="center">8.5</td>
                                <td align="center">9</td>
                                <td align="center">9.5</td>
                                <td align="center">9.5</td>
                                <td align="center">9.5</td>
                                <td align="center">10</td>
                            </tr>
                            <tr>
                                <th align="center">밑위 D</th>
                                <td align="center">22.5</td>
                                <td align="center">23</td>
                                <td align="center">24</td>
                                <td align="center">25</td>
                                <td align="center">25</td>
                                <td align="center">27</td>
                            </tr>
                            <tr>
                                <th align="center">총기장 E</th>
                                <td align="center">81</td>
                                <td align="center">83</td>
                                <td align="center">84.5</td>
                                <td align="center">84.5</td>
                                <td align="center">87</td>
                                <td align="center">88</td>
                            </tr>
                        </tbody>
                    </table>
                    <span class="unit-cm"><p>단위: cm</p></span>
                </div>
            </div>
        </div>
        <div class="delivery" id="delivery">
            <div class="delivery-block">
                <span class="delivery-subject"><h1>결제 및 입금</h1></span>
                <span class="delivery-content">
                    <p>- 무통장 입금의 경우 주문 시 입력한 입금자명과 실제 입금자가 반드시 일치하여야 하며 입금 금액을 반드시 확인하여 주시기 바랍니다.</p>
                    <p>- 주문 후 7일 이내 입금 완료되어야 하며, 주문자와 입금자명이 일치하지 않을 경우 자동 입금확인이 되지 않을 수 있으니, 반드시 카카오 상담톡으로 문의 후 입금확인 처리를 하시기 바랍니다.</p>
                    <p>- 카드 결제의 경우 상품 대금 결제 후 부분 취소를 원하실 경우 카카오 상담톡으로 문의해 주시면 빠른 처리가 가능합니다.</p>
                </span>
            </div>
            <div class="delivery-block">
                <span class="delivery-subject"><h1>배송 및 배송비</h1></span>
                <span class="delivery-content">
                    <p>- 젝시믹스의 배송업체는 CJ대한통운, 로젠택배입니다.</p>
                    <p>- 실 결제금액 50,000원 이상은 무료배송입니다.</p>
                    <p>- 실 결제금액 50,000원 미만 구매 시에는 2,500원의 배송비가 부과되며, 도서산간 지역의 운임도 동일합니다.</p>
                    <p>- 배송은 상품에 따라 입금확인 일로부터 최소 1일~5일 정도 소요되며, 협력업체의 사정으로 인해 배송이 지연될 경우도 있습니다.</p>
                    <p>- 지연될 경우에는 별도로 연락을 드리거나 상품 설명에 기재를 하고 있으니 구매 전 참고해 주세요.</p>
                </span>
            </div>
            <div class="delivery-block">
                <span class="delivery-subject"><h1>교환 및 반품</h1></span>
                <span class="delivery-content">
                    <p>- 제품에 붙어 있는 택을 제거하지 않았을 경우, 상품 수령일로부터 14일 이내에 교환 및 환불 신청이 가능합니다.</p>
                    <p>- 염색 공정에 따라 동일 색상이어도 색상 차이가 발생될 수 있습니다.</p>
                    <p>- 교환 및 반품 시 젝시믹스 고객센터에 미리 접수된 경우만 가능하며, 접수하지 않은 상태에서의 임의 교환 및 반품 제품이 분실되거나 훼손된 경우, 젝시믹스에서는 책임을 지지 않습니다.</p>
                    <p>- 제품 하자 및 오배송의 경우, 고객센터 상담을 통해 젝시믹스 동일 제품으로 교환 또는 환불을 진행해드립니다.(반품 배송비 무료)</p>
                    <p>- 네이버페이 결제수단으로 구매 후 교환을 원하실 경우 반품 후 재구매 해주시기 바랍니다.</p>
                    <p>- 단순 변심 시, 교환 배송비는 왕복 5,000원, 반품 배송비는 편도 2,500원이 고객님께 부담됩니다.</p>
                    <p>- 교환, 반품 후 구매하는 최종 상품의 금액이 5만 원 미만일 경우, 초기에 지원해 드렸던 배송비 2,500원이 추가 발생됩니다.</p>
                    <p>- 주소/연락처가 정확하지 않거나 연락이 되지 않아 반송될 경우 배송비는 고객님께 부담됩니다.</p>
                    <p>- 브라패드가 포함된 제품의 교환 및 반품 시 반드시 브라패드까지 동봉하여 발송해 주셔야 합니다. 동봉되지 않았을 경우 교환 및 반품 처리가 지연되거나, 브라패드 단품가를 차감하여 환불될 수 있습니다.</p>
                </span>
            </div>
            <div class="delivery-block">
                <span class="delivery-subject"><h1>교환 반품 불가</h1></span>
                <span class="delivery-content">
                    <p>- 제품이 훼손되거나 상품의 가치가 상실된 경우에는 교환 및 반품이 불가능합니다.</p>
                    <p>- 제품의 택이 훼손되거나 제거된 경우에는 교환 및 반품이 불가능합니다.</p>
                    <p>- 하자가 없는 새 제품일 경우에도 세탁 및 수선의 경우 교환 및 반품이 불가능합니다.</p>
                    <p>- 제품의 사이즈는 측정 방법에 따라 약간의 오차가 발생될 수 있으며, 제품의 색상은 사용자의 모니터의 설정과 사양에 따라 차이가 있을 수 있습니다.<br/>이는 불량이 아니므로 교환 및 반품 시 배송비가 발생됩니다.</p>
                    <p>- 염색 과정에 물 빠짐이 발생될 수 있어 세탁하지 않은 옷을 절대로 바로 입고 운동하지 마세요.</p>
                    <p>- 세탁 부주의로 인한 제품 손상은 교환 및 반품, 환불이 불가능하며 젝시믹스에서는 어떠한 보상과 책임도 지지 않으니, 구매 전 세탁 방법을 반드시 확인하신 후 구매하여 주시기 바랍니다.</p>
                    <p>- 패턴 프린팅 디자인의 특성상 배송되는 제품이 실제 이미지와의 패턴 디자인의 위치가 조금씩 차이가 있을 수 있습니다. 이는 불량이 아니므로 교환 및 반품 시 배송비가 발생됩니다.</p>
                    <p>- 시착용을 해도 상품의 가치가 떨어지는 경우에는 교환이나 반품이 불가능합니다.</p>
                    <p>- 판매 상품명은 상품 제작 시기에 따라 달라질 수 있으며, 이는 불량 사유에 해당되지 않습니다.</p>
                </span>
            </div>
            <div class="delivery-block">
                <span class="delivery-subject"><h1>반송지 주소</h1></span>
                <span class="delivery-content">
                    <p>경기도 의정부시 산단로98번길 65 303호 젝시믹스</p>
                </span>
            </div>
        </div>
    </div>
</section>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script type="text/javascript" src="${contextPath}/assets/js/detail_index.js"></script>

<c:import url="/WEB-INF/views/inc/bottom.jsp" />



