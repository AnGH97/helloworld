<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/inc/top.jsp" />
<!--index stype-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/index.css" />

    <!--메인 내용 영역-->
    <section class="main">
        <div class="main_img">
            <img src="${pageContext.request.contextPath}/assets/img/andar_main_img.jpg" />
        </div>
        <div class="main-category">
            <span><h1>${c1name}</h1></span>
            <ul>
                <li><a href="${pageContext.request.contextPath}/shoppingmall/index?category1=${cn1}">전체</a></li>
                <c:forEach var="item1" items="${coutput}" varStatus="status">
                    <c:set var="name" value="${item1.name}" />
                    <c:set var="category1_id" value="${item.category1_id}" />

                    <li><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=${cn1}&&category2=${item1.name}">${item1.name}</a></li>
                </c:forEach>
                <!--<li><a href="${pageContext.request.contextPath}/shoppingmall/index#main-category" class="entire mcbt">전체</a></li>
                <li><a href="${pageContext.request.contextPath}/shoppingmall/index?category1=${cn1}#main-category-img" class="mcbt">우먼즈</a></li>
                <li><a href="${pageContext.request.contextPath}/shoppingmall/index?category1=맨즈#main-category-img" class="mcbt">맨즈</a></li>
                <li><a href="${pageContext.request.contextPath}/shoppingmall/index?category1=용품#main-category-img" class="mcbt">용품</a></li>-->
            </ul>
        </div>
        <div class="main-category-img" id="main-category-img">
            <div class="sort-list">
                <span>${totalCount}개의 상품</span>
                <ul>
                    <!--Get방식으로 query string으로 해서 데이터를 Mapper에 넘길 수 있도록-->
                    <!--href 링크에 ?value=값으로 컨트롤러에 전송해서 그 값을 model에 넘겨 mapper가 받을 수 있도록 하라는 의미임. -->
                    <li class="first-sort-list"><a href="${pageContext.request.contextPath}/shoppingmall/index?category1=${cn1}">상품정렬</a></li>
                    <li><a href="${pageContext.request.contextPath}/shoppingmall/index?category1=${cn1}&&order=asc">낮은가격</a></li>
                    <li><a href="${pageContext.request.contextPath}/shoppingmall/index?category1=${cn1}&&order=desc">높은가격</a></li>
                </ul>
            </div>
            <div class="sort-img">
                <ul>
                    <c:choose>
                        <%-- 조회 결과가 없는 경우 --%>
                        <c:when test="${output == null || fn:length(output) == 0}">
                            <li>
                                <h1>열심히 상품을 준비중입니다.</h1>
                            </li>
                        </c:when>
                        <%-- 조회결과가 있는 경우 --%>
                        <c:otherwise>
                            <%-- 조회 결과에 따른 반복 처리--%>
                            <c:forEach var="item" items="${output}" varStatus="status">
        
                                <%-- 출력을 위해 준비한 학과이름과 위치--%>
                                <c:set var="img" value="${item.img_path}" />
                                <c:set var="name" value="${item.name}" />
                                <c:set var="price" value="${item.price}" />
                                <c:set var="sale" value="${item.sale}" />
                                <c:set var="thumbnail" value="${item.thumbnail}" />

                                <%-- 상세페이지로 이동하기 위한 URL --%>
                                <c:url value="${pageContext.request.contextPath}/shoppingmall/detail_index" var="viewUrl">
                                    <c:param name="id" value="${item.id}"></c:param>
                                </c:url>
                                <c:if test="${item.thumbnail == '1'}">
                                <li>
                                    <a href="${viewUrl}">
                                        <div class="combine-img">
                                                <div class="img-first"><img src="${item.img_path}" /></div>
                                                <div class="combine-img-tag">
                                                    <span class="review">리뷰 127,438</span>
                                                    <span class="product-name">${item.name}</span>
                                                </div>
                                                <span class="money"><p class="sale"><fmt:formatNumber value="${(item.price-item.sale)/item.price}" type="percent" /></p> <p class="sale-price">${item.sale}원</p> <p class="just-price">${item.price}원</p></span>
                                        </div>
                                    </a>
                                </li> 
                                </c:if> 
                                <c:if test="${item.thumbnail == '2'}">
                                    <img class="img-second" src="${item.img_path}" /> 
                                </c:if>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                    <!--<li>
                        <a href="${pageContext.request.contextPath}/shoppingmall/detail_index">
                            <div class="combine-img">
                                <div class="img-first"><img src="${pageContext.request.contextPath}/assets/img/andar_sort_img12.jpg" /></div>
                                <div class="img-second"><img src="${pageContext.request.contextPath}/assets/img/andar_sort_img11.jpg" /></div>
                            </div>

                            <div class="combine-img-tag">
                                <span class="review">리뷰 127,438</span>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <span class="product-name">[1+1]에어쿨링 지니 시그니처 레깅스</span>
                            </div>
                        </a>
                        <span class="money"><p class="sale">50%</p> <p class="sale-price">49000원</p> <p class="just-price">98000원</p></span>
                    </li>

                    <li>
                        <a href="${pageContext.request.contextPath}/shoppingmall/detail_index">
                            <div class="combine-img">
                                <div class="img-first"><img src="${pageContext.request.contextPath}/assets/img/andar_sort_img22.jpg" /></div>
                                <div class="img-second"><img src="${pageContext.request.contextPath}/assets/img/andar_sort_img21.jpg" /></div>
                            </div>
                            <div class="combine-img-tag">
                                <span class="review">리뷰 127,438</span>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <span class="product-name">[1+1]에어쿨링 지니 시그니처 레깅스</span>
                            </div>
                        </a>
                        <span class="money"><p class="sale">50%</p> <p class="sale-price">49000원</p> <p class="just-price">98000원</p></span>
                    </li>

                    <li>
                        <a href="${pageContext.request.contextPath}/shoppingmall/detail_index">
                            <div class="combine-img">
                                <div class="img-first"><img src="${pageContext.request.contextPath}/assets/img/andar_sort_img32.jpg" /></div>
                                <div class="img-second"><img src="${pageContext.request.contextPath}/assets/img/andar_sort_img31.jpg" /></div>
                            </div>
                            <div class="combine-img-tag">
                                <span class="review">리뷰 127,438</span>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <span class="product-name">[1+1]에어쿨링 지니 시그니처 레깅스</span>
                            </div>
                        </a>
                        <span class="money"><p class="sale">50%</p> <p class="sale-price">49000원</p> <p class="just-price">98000원</p></span>
                    </li>

                    <li>
                        <a href="${pageContext.request.contextPath}/shoppingmall/detail_index">
                            <div class="combine-img">
                                <div class="img-first"><img src="${pageContext.request.contextPath}/assets/img/andar_sort_img42.jpg" /></div>
                                <div class="img-second"><img src="${pageContext.request.contextPath}/assets/img/andar_sort_img41.jpg" /></div>
                            </div>
                            <div class="combine-img-tag">
                                <span class="review">리뷰 127,438</span>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <span class="product-name">[1+1]에어쿨링 지니 시그니처 레깅스</span>
                            </div>
                        </a>
                        <span class="money"><p class="sale">50%</p> <p class="sale-price">49000원</p> <p class="just-price">98000원</p></span>
                    </li>

                    <li>
                        <a href="${pageContext.request.contextPath}/shoppingmall/detail_index">
                            <div class="combine-img">
                                <div class="img-first"><img src="${pageContext.request.contextPath}/assets/img/andar_sort_img52.jpg" /></div>
                                <div class="img-second"><img src="${pageContext.request.contextPath}/assets/img/andar_sort_img51.jpg" /></div>
                            </div>
                            <div class="combine-img-tag">
                                <span class="review">리뷰 127,438</span>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <span class="product-name">[1+1]에어쿨링 지니 시그니처 레깅스</span>
                            </div>
                        </a>
                        <span class="money"><p class="sale">50%</p> <p class="sale-price">49000원</p> <p class="just-price">98000원</p></span>
                    </li>

                    <li>
                        <a href="${pageContext.request.contextPath}/shoppingmall/detail_index">
                            <div class="combine-img">
                                <div class="img-first"><img src="${pageContext.request.contextPath}/assets/img/andar_sort_img62.jpg" /></div>
                                <div class="img-second"><img src="${pageContext.request.contextPath}/assets/img/andar_sort_img61.jpg" /></div>
                            </div>
                            <div class="combine-img-tag">
                                <span class="review">리뷰 127,438</span>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <span class="product-name">[1+1]에어쿨링 지니 시그니처 레깅스</span>
                            </div>
                        </a>
                        <span class="money"><p class="sale">50%</p> <p class="sale-price">49000원</p> <p class="just-price">98000원</p></span>
                    </li>

                    <li>
                        <a href="${pageContext.request.contextPath}/shoppingmall/detail_index">
                            <div class="combine-img">
                                <div class="img-first"><img src="${pageContext.request.contextPath}/assets/img/andar_sort_img72.jpg" /></div>
                                <div class="img-second"><img src="${pageContext.request.contextPath}/assets/img/andar_sort_img71.jpg" /></div>
                            </div>
                            <div class="combine-img-tag">
                                <span class="review">리뷰 127,438</span>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <span class="product-name">[1+1]에어쿨링 지니 시그니처 레깅스</span>
                            </div>
                        </a>
                        <span class="money"><p class="sale">50%</p> <p class="sale-price">49000원</p> <p class="just-price">98000원</p></span>
                    </li>

                    <li>
                        <a href="${pageContext.request.contextPath}/shoppingmall/detail_index">
                            <div class="combine-img">
                                <div class="img-first"><img src="${pageContext.request.contextPath}/assets/img/andar_sort_img82.jpg" /></div>
                                <div class="img-second"><img src="${pageContext.request.contextPath}/assets/img/andar_sort_img81.jpg" /></div>
                            </div>
                            <div class="combine-img-tag">
                                <span class="review">리뷰 127,438</span>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <span class="product-name">[1+1]에어쿨링 지니 시그니처 레깅스</span>
                            </div>
                        </a>
                        <span class="money"><p class="sale">50%</p> <p class="sale-price">49000원</p> <p class="just-price">98000원</p></span>
                    </li>

                    <li>
                        <a href="${pageContext.request.contextPath}/shoppingmall/detail_index">
                            <div class="combine-img">
                                <div class="img-first"><img src="${pageContext.request.contextPath}/assets/img/andar_sort_img92.jpg" /></div>
                                <div class="img-second"><img src="${pageContext.request.contextPath}/assets/img/andar_sort_img91.jpg" /></div>
                            </div>
                            <div class="combine-img-tag">
                                <span class="review">리뷰 127,438</span>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <span class="product-name">[1+1]에어쿨링 지니 시그니처 레깅스</span>
                            </div>
                        </a>
                        <span class="money"><p class="sale">50%</p> <p class="sale-price">49000원</p> <p class="just-price">98000원</p></span>
                    </li>

                    <li>
                        <a href="${pageContext.request.contextPath}/shoppingmall/detail_index">
                            <div class="combine-img">
                                <div class="img-first"><img src="${pageContext.request.contextPath}/assets/img/andar_sort_img102.jpg" /></div>
                                <div class="img-second"><img src="${pageContext.request.contextPath}/assets/img/andar_sort_img101.jpg" /></div>
                            </div>
                            <div class="combine-img-tag">
                                <span class="review">리뷰 127,438</span>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <span class="product-name">[1+1]에어쿨링 지니 시그니처 레깅스</span>
                            </div>
                        </a>
                        <span class="money"><p class="sale">50%</p> <p class="sale-price">49000원</p> <p class="just-price">98000원</p></span>
                    </li>

                    <li>
                        <a href="${pageContext.request.contextPath}/shoppingmall/detail_index">
                            <div class="combine-img">
                                <div class="img-first"><img src="${pageContext.request.contextPath}/assets/img/andar_sort_img112.jpg" /></div>
                                <div class="img-second"><img src="${pageContext.request.contextPath}/assets/img/andar_sort_img111.jpg" /></div>
                            </div>
                            <div class="combine-img-tag">
                                <span class="review">리뷰 127,438</span>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <span class="product-name">[1+1]에어쿨링 지니 시그니처 레깅스</span>
                            </div>
                        </a>
                        <span class="money"><p class="sale">50%</p> <p class="sale-price">49000원</p> <p class="just-price">98000원</p></span>
                    </li>

                    <li>
                        <a href="${pageContext.request.contextPath}/shoppingmall/detail_index">
                            <div class="combine-img">
                                <div class="img-first"><img src="${pageContext.request.contextPath}/assets/img/andar_sort_img122.jpg" /></div>
                                <div class="img-second"><img src="${pageContext.request.contextPath}/assets/img/andar_sort_img121.jpg" /></div>
                            </div>
                            <div class="combine-img-tag">
                                <span class="review">리뷰 127,438</span>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <span class="product-name">[1+1]에어쿨링 지니 시그니처 레깅스</span>
                            </div>
                        </a>
                        <span class="money"><p class="sale">50%</p> <p class="sale-price">49000원</p> <p class="just-price">98000원</p></span>
                    </li>

                    <li>
                        <a href="${pageContext.request.contextPath}/shoppingmall/detail_index">
                            <div class="combine-img">
                                <div class="img-first"><img src="${pageContext.request.contextPath}/assets/img/andar_sort_img132.jpg" /></div>
                                <div class="img-second"><img src="${pageContext.request.contextPath}/assets/img/andar_sort_img131.jpg" /></div>
                            </div>
                            <div class="combine-img-tag">
                                <span class="review">리뷰 127,438</span>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <span class="product-name">[1+1]에어쿨링 지니 시그니처 레깅스</span>
                            </div>
                        </a>
                        <span class="money"><p class="sale">50%</p> <p class="sale-price">49000원</p> <p class="just-price">98000원</p></span>
                    </li>

                    <li>
                        <a href="${pageContext.request.contextPath}/shoppingmall/detail_index">
                            <div class="combine-img">
                                <div class="img-first"><img src="${pageContext.request.contextPath}/assets/img/andar_sort_img142.jpg" /></div>
                                <div class="img-second"><img src="${pageContext.request.contextPath}/assets/img/andar_sort_img141.jpg" /></div>
                            </div>
                            <div class="combine-img-tag">
                                <span class="review">리뷰 127,438</span>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <span class="product-name">[1+1]에어쿨링 지니 시그니처 레깅스</span>
                            </div>
                        </a>
                        <span class="money"><p class="sale">50%</p> <p class="sale-price">49000원</p> <p class="just-price">98000원</p></span>
                    </li>

                    <li>
                        <a href="${pageContext.request.contextPath}/shoppingmall/detail_index">
                            <div class="combine-img">
                                <div class="img-first"><img src="${pageContext.request.contextPath}/assets/img/andar_sort_img152.jpg" /></div>
                                <div class="img-second"><img src="${pageContext.request.contextPath}/assets/img/andar_sort_img151.jpg" /></div>
                            </div>
                            <div class="combine-img-tag">
                                <span class="review">리뷰 127,438</span>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <span class="product-name">[1+1]에어쿨링 지니 시그니처 레깅스</span>
                            </div>
                        </a>
                        <span class="money"><p class="sale">50%</p> <p class="sale-price">49000원</p> <p class="just-price">98000원</p></span>
                    </li>

                    <li>
                        <a href="${pageContext.request.contextPath}/shoppingmall/detail_index">
                            <div class="combine-img">
                                <div class="img-first"><img src="${pageContext.request.contextPath}/assets/img/andar_sort_img162.jpg" /></div>
                                <div class="img-second"><img src="${pageContext.request.contextPath}/assets/img/andar_sort_img161.jpg" /></div>
                            </div>
                            <div class="combine-img-tag">
                                <span class="review">리뷰 127,438</span>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <span class="product-name">[1+1]에어쿨링 지니 시그니처 레깅스</span>
                            </div>
                        </a>
                        <span class="money"><p class="sale">50%</p> <p class="sale-price">49000원</p> <p class="just-price">98000원</p></span>
                    </li>

                    <li>
                        <a href="${pageContext.request.contextPath}/shoppingmall/detail_index">
                            <div class="combine-img">
                                <div class="img-first"><img src="${pageContext.request.contextPath}/assets/img/andar_sort_img172.jpg" /></div>
                                <div class="img-second"><img src="${pageContext.request.contextPath}/assets/img/andar_sort_img171.jpg" /></div>
                            </div>
                            <div class="combine-img-tag">
                                <span class="review">리뷰 127,438</span>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <span class="product-name">[1+1]에어쿨링 지니 시그니처 레깅스</span>
                            </div>
                        </a>
                        <span class="money"><p class="sale">50%</p> <p class="sale-price">49000원</p> <p class="just-price">98000원</p></span>
                    </li>

                    <li>
                        <a href="${pageContext.request.contextPath}/shoppingmall/detail_index">
                            <div class="combine-img">
                                <div class="img-first"><img src="${pageContext.request.contextPath}/assets/img/andar_sort_img182.jpg" /></div>
                                <div class="img-second"><img src="${pageContext.request.contextPath}/assets/img/andar_sort_img181.jpg" /></div>
                            </div>
                            <div class="combine-img-tag">
                                <span class="review">리뷰 127,438</span>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <span class="product-name">[1+1]에어쿨링 지니 시그니처 레깅스</span>
                            </div>
                        </a>
                        <span class="money"><p class="sale">50%</p> <p class="sale-price">49000원</p> <p class="just-price">98000원</p></span>
                    </li>

                    <li>
                        <a href="${pageContext.request.contextPath}/shoppingmall/detail_index">
                            <div class="combine-img">
                                <div class="img-first"><img src="${pageContext.request.contextPath}/assets/img/andar_sort_img192.jpg" /></div>
                                <div class="img-second"><img src="${pageContext.request.contextPath}/assets/img/andar_sort_img191.jpg" /></div>
                            </div>
                            <div class="combine-img-tag">
                                <span class="review">리뷰 127,438</span>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <span class="product-name">[1+1]에어쿨링 지니 시그니처 레깅스</span>
                            </div>
                        </a>
                        <span class="money"><p class="sale">50%</p> <p class="sale-price">49000원</p> <p class="just-price">98000원</p></span>
                    </li>

                    <li>
                        <a href="${pageContext.request.contextPath}/shoppingmall/detail_index">
                            <div class="combine-img">
                                <div class="img-first"><img src="${pageContext.request.contextPath}/assets/img/andar_sort_img202.jpg" /></div>
                                <div class="img-second"><img src="${pageContext.request.contextPath}/assets/img/andar_sort_img201.jpg" /></div>
                            </div>
                            <div class="combine-img-tag">
                                <span class="review">리뷰 127,438</span>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <span class="product-name">[1+1]에어쿨링 지니 시그니처 레깅스</span>
                            </div>
                        </a>
                        <span class="money"><p class="sale">50%</p> <p class="sale-price">49000원</p> <p class="just-price">98000원</p></span>
                    </li>-->
                </ul>
            </div>
        </div>
        <div class="paging">
            <!-- 페이지 번호 구현-->
            <%-- 이전 그룹에 대한 링크 --%>
            <c:choose>
                <%-- 이전 그룹으로 이동 가능하다면?--%>
                <c:when test="${pagenation.prevPage > 0}">
                    <%-- 이동할 URL 생성 --%>
                    <c:url value="${pageContext.request.contextPath}/shoppingmall/index?category1=${cn1}" var="prevPageUrl">
                        <c:param name="page" value="${pagenation.prevPage}"></c:param>
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
                <c:url value="${pageContext.request.contextPath}/shoppingmall/index?category1=${cn1}" var="pageUrl">
                    <c:param name="page" value="${i}"></c:param>
                </c:url>

                <%-- 페이지 번호 출력 --%>
                <c:choose>
                    <%--현재 머물고 있는 페이지 번호를 출력할 경우 링크 적용 안함 --%>
                    <c:when test="${pagenation.nowPage == i}">
                        <strong>&nbsp&nbsp${i}&nbsp&nbsp</strong>
                    </c:when>
                    <%-- 나머지 페이지의 경우 링크 적용함 --%>
                    <c:otherwise>
                        <a href="${pageUrl}">${i}</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <%--다음 그룹에 대한 링크 --%>
            <c:choose>
                <%--다음 그룹으로 이동이 가능하다면?--%>
                <c:when test="${pagenation.nextPage > 0}">
                    <%--이동할 URL 생성 --%>
                    <c:url value="${pageContext.request.contextPath}/shoppingmall/index?category1=${cn1}" var="nextPageUrl">
                        <c:param name="page" value="${pagenation.nextPage}"></c:param>
                    </c:url>
                    <a href="${nextPageUrl}">></a>
                </c:when>
                <c:otherwise>
                    >
                </c:otherwise>
            </c:choose>
            </div>   
    </section>
    
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/index.js"></script>

<c:import url="/WEB-INF/views/inc/bottom.jsp" />

