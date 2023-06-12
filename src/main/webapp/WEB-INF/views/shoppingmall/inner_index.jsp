<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ page trimDirectiveWhitespaces="true"%> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/inc/top.jsp" />
<!--index stype-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/inner_index.css" />

<!--메인 내용 영역-->
<section class="main">
    <div class="main-category">
        <span><h1>${c1name}</h1></span>
        <ul>
            <li><a href="${pageContext.request.contextPath}/shoppingmall/index?category1=${c1name}">전체</a></li>
            <c:forEach var="item1" items="${coutput}" varStatus="status">
                <c:set var="name" value="${item1.name}" />
                <c:if test="${item.category1_id != '1+1'}">
                    <c:set var="category1_id" value="${item.category1_id}" />
                </c:if>
                <c:if test="${item.category1_id == '1+1'}">
                    <c:set var="category1_id" value="opo" />
                </c:if>
                <li><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=${c1name}&&category2=${item1.name}">${item1.name}</a></li>
            </c:forEach>
        </ul>
    </div>
    <div class="main-category-img" id="main-category-img">
        <div class="sort-list" id="sort-list">
            <span>${totalCount}개의 상품</span>
            <ul>
                <li class="first-sort-list"><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=${c1name}&&category2=${c2name}">상품정렬</a></li>
                <li><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=${c1name}&&category2=${c2name}&&order=asc">낮은가격</a></li>
                <li><a href="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=${c1name}&&category2=${c2name}&&order=desc">높은가격</a></li>
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
                            <c:set var="name" value="${item.name}" />
                            <c:set var="price" value="${item.price}" />
                            <c:set var="sale" value="${item.sale}" />

                            <%-- 상세페이지로 이동하기 위한 URL --%>
                            <c:url value="${pageContext.request.contextPath}/shoppingmall/detail_index" var="viewUrl">
                                <c:param name="id" value="${item.id}"></c:param>
                            </c:url>
                            <li>
                                <a href="${viewUrl}">
                                    <div class="combine-img">
                                        <div class="img-first">
                                            <c:if test="${fn:length(item.imgList) == 1}">
                                                <img src="${item.imgList[0].img_path}" alt="${item.name}" />
                                            </c:if>
                                            <c:if test="${fn:length(item.imgList) == 2}">
                                                <img class="hover-img" src="${item.imgList[0].img_path}" alt="${item.name}" data-over="${item.imgList[1].img_path}" />
                                            </c:if>
                                        </div>
                                        <div class="combine-img-tag">
                                            <span class="review">리뷰 127,438</span>
                                            <span class="product-name">${item.name}</span>
                                        </div>
                                        <span class="money"
                                            ><p class="sale"><fmt:formatNumber value="${(item.price-item.sale)/item.price}" type="percent" /></p>
                                            <p class="sale-price"><fmt:formatNumber value="${item.sale}" pattern="#,###" />원</p>
                                            <p class="just-price"><fmt:formatNumber value="${item.price}" pattern="#,###" />원</p>
                                        </span>
                                    </div>
                                </a>
                            </li>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
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
                <c:url value="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=${c1name}&&category2=${c2name}" var="prevPageUrl">
                    <c:param name="page" value="${pagenation.prevPage}"></c:param>
                </c:url>
                <a href="${prevPageUrl}"><</a>
            </c:when>
            <c:otherwise> < </c:otherwise>
        </c:choose>

        <%--페이지 번호(시작 페이지부터 끝 페이지까지 반복) --%>
        <c:forEach var="i" begin="${pagenation.startPage}" end="${pagenation.endPage}" varStatus="status">
            <%--이동할 URL 생성--%>
            <c:url value="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=${c1name}&&category2=${c2name}" var="pageUrl">
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
                <c:url value="${pageContext.request.contextPath}/shoppingmall/inner_index?category1=${c1name}&&category2=${c2name}" var="nextPageUrl">
                    <c:param name="page" value="${pagenation.nextPage}"></c:param>
                </c:url>
                <a href="${nextPageUrl}">></a>
            </c:when>
            <c:otherwise> > </c:otherwise>
        </c:choose>
    </div>
</section>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/inner_index.js"></script>
<c:import url="/WEB-INF/views/inc/bottom.jsp" />
