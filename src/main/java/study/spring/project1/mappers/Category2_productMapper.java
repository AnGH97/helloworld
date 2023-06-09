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
        "SELECT p.id, p.`name`, p.price, p.sale, p.color, p.product_txt, p.size, p.best, p.sort, c1.id as category1_id, c2.id as category2_id " +
        "FROM product AS p " + 
        "INNER JOIN category2_has_product AS cp ON p.id = cp.product_id " +
        "INNER JOIN category2 AS c2 ON cp.category2_id = c2.id " +
        "INNER JOIN category1 AS c1 ON c2.category1_id = c1.id " +
        "<where>" + // <-- 검색 조건 동적 구성 시작
        "c1.id=${c1} " +
        "AND c2.id=${c2} " +
        "</where>" + 
        "<if test='order == null'>ORDER BY p.sort asc</if>" + 
        "<if test='order != null'>ORDER BY p.sale ${order}</if>" +   
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
            @Result(property="category2_id", column="category2_id"),
            @Result(property="sort", column="sort"),
            @Result(property="img_path", column="img_path"),
            @Result(property="c1name", column="c1name"),
            @Result(property="thumbnail", column="thumbnail")})
    List<ProductModel> selectProductDetailList(ProductModel input); 

    
   @Select("<script>" + // <-- Dynamic SQL이 시작됨을 알림
        "SELECT COUNT(*) FROM product AS p " + 
        "INNER JOIN category2_has_product AS cp ON p.id = cp.product_id " +
        "INNER JOIN category2 AS c2 ON cp.category2_id = c2.id " +
        "INNER JOIN category1 AS c1 ON c2.category1_id = c1.id " +
        "<where>" + // <-- 검색 조건 동적 구성 시작
        "c1.id=${c1} " +
        "AND c2.id=${c2} " +
        "</where>" + 
        "</script>") // <-- Dynamic SQL이 종료됨을 알림
    public int selectCount(ProductModel input);  
}
