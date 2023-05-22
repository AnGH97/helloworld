<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/inc/top.jsp" />
<!--css-->
<link rel="stylesheet" href="${contextPath}/assets/css/shopping_cart.css" />

    <!--메인 내용 영역-->
    <section class="main">
        <div class="content-container">
            <h1>장바구니</h1>
            <div class="cart-table">
                <table align="center">
                    <thead>
                        <tr>
                            <th><input class="all_check"type="checkbox" name="all_check" id="all_check" /></th>
                            <th>상품명 </th>
                            <th>가격</th>
                            <th>수량</th>
                            <th>합계</th>
                            <th>적립금</th>
                            <th>배송비</th>
                            <th>상품삭제</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><input class="check" type="checkbox" name="check1" id="check1" /></td>
                            <td>
                                <img src="${contextPath}/assets/img/xexymix_cart_img1.jpg" />
                                <div class="product-name">
                                    <span>아이스페더 숏슬리브 1+1</span>
                                    <span>선택1: 블랙M, 선택2: 다크그레이XL 1개</span>    
                                </div>
                            </td>
                            <td>
                                <p class="re-price">56,000원</p>
                                <p class="sale-price">29,800원</p>
                            </td>
                            <td>
                                <div>
                                    <button type="button" class="count_down" id="count_down">-</button>
                                    <input type="text" name="count_number" id="count_number" value="1"/>
                                    <button type="button" class="count_up"id="count_up">+</button>
                                </div>
                            </td>
                            <td>
                                <span>29,800원</span>
                            </td>
                            <td>
                                <span>290</span>
                            </td>
                            <td>
                                <span>[기본배송]</span>
                                <br/>
                                <span>조건</span>
                            </td>
                            <td>
                                <button type="button" class="product_del" id="product_del">삭제하기</button>
                            </td>
                        </tr>
                    </tbody>
                </table>

            </div>
            <div class="cart_text">
                <ul>
                    <li><span>젝시믹스 제품은 우체국택배로 배송됩니다.</span></li>
                    <li><span>장바구니에 담은 상품은 14일동안 보관됩니다.</span></li>
                    <li><span>실결제 금액 5만원 이상 구매시 무료배송이 적용됩니다.</span></li>
                </ul>
                <div class="cart-price">
                    <span class="price1">
                        <p class="price1_text">총 구매금액</p>
                        <p class="price1_money">89,400원</p>
                    </span>
                    <span class="price2">
                        <p class="price2_text">배송료</p>
                        <p class="price2_money">+ 0원</p>
                    </span>
                    <span class="price3">   <!--5만원 이상 안넘으면 배송비 붙어서 존재하는거-->
                        <p class="price3_text">결제 예정금액</p>
                        <p class="price3_money">89,400원</p>
                    </span>
                </div>
            </div>
            <div class="cart-bottom">
                <div class="cart-button1">
                    <button type="button" class="choice-del" id="choice-del">선택삭제</button>
                    <button type="button" class="all-del" id="all-del">장바구니 비우기</button>
                </div>

                <div class="cart-button2">
                    <button type="button" class="go-shopping" id="go-shopping" onclick="location.href='#'">쇼핑하기</button>
                    <button type="button" class="order" id="order" onclick="location.href='#'" >주문하기</button>
                </div>
                
            </div>
        </div>
    </section>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>
    $("#all_check").on("change", (e) => {
        $(".check").prop("checked", $(e.currentTarget).prop("checked"));
    });
</script>    
<c:import url="/WEB-INF/views/inc/bottom.jsp" />
