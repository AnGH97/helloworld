package study.spring.project1.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import study.spring.project1.models.ProductModel;

@Mapper
public interface Category2_productMapper {
    //Category2를 클릭했을 때 나오는 상품 목록
    //SELECT문(다중행 조회)을 수행하는 메서드 정의
    @Select("<script>" + // <-- Dynamic SQL이 시작됨을 알림
        "SELECT p.id, p.name, p.price, p.sale, p.color, p.size, p.product_txt, p.best, p.sort, p.category1_id, i.id, i.img_path, i.thumbnail " + 
        "FROM product AS p, category2_has_product AS c2p, img AS i, category1 AS ca1, category2 AS ca2 " + 
        "<where>" + // <-- 검색 조건 동적 구성 시작
        "${c2}=c2p.category2_id " +
        "AND c2p.category2_id=ca2.id " + 
        "AND c2p.product_id=p.id " +
        "AND p.category1_id=ca1.id " +
        "AND ca2.category1_id=ca1.id " +
        "AND ca1.id=${c1} " +
        "AND p.id=i.product_id " + 
        "AND i.thumbnail IS NOT NULL " +
        "</where>" + 
        "ORDER BY p.sort asc " + 
        "<if test='order != null'>, p.price ${order}</if>" + 
        "<if test='listCount > 0'>LIMIT #{offset}, #{listCount}</if>" +
        "</script>") // <-- Dynamic SQL이 종료됨을 알림
        @Results(id = "myResultId", value={
            @Result(property="id", column="id"),
            @Result(property="name", column="name"),
            @Result(property="price", column="price"),
            @Result(property="sale", column="sale"),
            @Result(property="color", column="color"),
            @Result(property="size", column="size"),
            @Result(property="product_txt", column="product_txt"),
            @Result(property="best", column="best"),
            @Result(property="category1_id", column="category1_id"),
            @Result(property="sort", column="sort")})
    List<ProductModel> selectProductDetailList(ProductModel input); 
}
