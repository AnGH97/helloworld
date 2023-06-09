package study.spring.project1.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import study.spring.project1.models.ProductModel;

@Mapper
public interface ProductMapper {
    //INSERT문을 수행하는 메서드 정의
    @Insert("INSERT INTO product (name, price, sale, color, size, product_txt, best, sort, category1_id) VALUES (#{name}, #{price}, #{sale}, #{color}, #{size}, #{product_txt}, #{best}, #{sort}, #{category1_id})")
    //INSERT문에서 필요한 PK에 대한 옵션 정의
    // --> userGeneratedKeys: AUTO_INCREMENT가 적용된 테이블인 경우 사용
    // --> keyProperty: 파라미터로 전달되는 DTO객체에서 PK에 대응되는 멤버변수
    // --> keyColumn: 테이블의 Primary Key 칼럼명
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    //INSERT, UPDATE, DELET용 메서드는 반드시 int형 리턴 --> 적용된 행의 수를 반환
    int insert(ProductModel input); 
    
    //UPDATE문을 수행하는 메서드 정의
    @Update("UPDATE product SET name=#{name}, price=#{price}, sale=#{sale}, color=#{color}, size=#{size}, product_txt=#{product_txt}, best=#{best}, sort=#{sort}, category1_id=#{category1_id} WHERE id=#{id}")
    int update(ProductModel input);

    //DELETE문을 수행하는 메서드 정의
    @Delete("DELETE FROM product WHERE id=#{id}")
    int delete(ProductModel input);   
    
    //Product_id에 맞는 모든 정보 select
    //SELECT문(단일행 조회)을 수행하는 메서드 정의
    @Select("SELECT id, name, price, sale, color, size, product_txt, best, sort, category1_id FROM product WHERE id=#{id}")
    //조회 결과와 리턴할 DTO객체를 연결하기 위한 규칙 정의
    // --> property : DTO 객체의 멤버변수 이름
    // --> column : SELECT문에 명시된 필드 이름(AS 옵션을 사용할 경우 별칭으로 명시)
    @Results(id = "myResultId1", value={
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
    ProductModel selectItem(ProductModel input);

    //검색 결과에 맞는 상품의 정보 select
    //SELECT문(다중행 조회)을 수행하는 메서드 정의
    /**@Select("<script>" + // <-- Dynamic SQL이 시작됨을 알림
        "SELECT id, name, price, sale, color, size, product_txt, best, sort, category1_id FROM product" + 
        "<where>" + // <-- 검색 조건 동적 구성 시작
        "<if test='name != null'>name LIKE concat('%', #{name}, '%')</if>" + 
        "<if test='color != null'>OR color LIKE concat('%', #{color}, '%')</if>" + 
        "<if test='size != null'>OR size LIKE concat('%', #{size}, '%')</if>" + 
        "<if test='best != null'>OR best LIKE concat('%', #{best}, '%')</if>" + 
        "<if test='sort != null'>OR sort LIKE concat('%', #{sort}, '%')</if>" + 
        "</where>" + 
        "<if test='listCount > 0'>LIMIT #{offset}, #{listCount}</if>" +
        "</script>") // <-- Dynamic SQL이 종료됨을 알림
   @ResultMap("myResultId")
   List<ProductModel> selectList(ProductModel input);*/

   //BEST 상품을 포함한 모든 상품의 정보를 SELECT 하는 함수
    @Select("<script>" + // <-- Dynamic SQL이 시작됨을 알림
        "SELECT p.id, p.name, p.price, p.sale, p.color, p.size, p.best, p.sort, p.category1_id, i.img_path, i.thumbnail FROM product AS p, img as i " +
        "WHERE p.category1_id=(SELECT id FROM category1 WHERE name=#{c1name}) " +
        "AND p.id = i.product_id " + 
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
        @Result(property="sort", column="sort"),
        @Result(property="img_path", column="img_path"),
        @Result(property="c1name", column="c1name"),
        @Result(property="thumbnail", column="thumbnail")})
   List<ProductModel> selectList(ProductModel input);

   @Select("<script>" + // <-- Dynamic SQL이 시작됨을 알림
        "SELECT COUNT(*) AS cnt FROM product " + 
        "WHERE category1_id=${c1} " +
        "</script>") // <-- Dynamic SQL이 종료됨을 알림
    public int selectCount(ProductModel input);    

    //best 상품 노출 + 높은 가격순, 낮은 가격순 정렬이 가능하도록 만듬.
    @Select("<script>" + // <-- Dynamic SQL이 시작됨을 알림
        "SELECT p.id, p.name, p.price, p.sale, p.color, p.size, p.product_txt, p.best, p.sort, p.category1_id, i.id, i.img_path, i.thumbnail FROM product AS p, img as i " +
        "WHERE p.category1_id=(SELECT id FROM category1 WHERE name=#{c1name}) " +
        "AND i.product_id = p.id " + 
        "AND p.best='Y' " + 
        "AND i.thumbnail IS NOT NULL " + 
        "ORDER BY p.sort asc " + 
        "<if test='order != null'>, p.price ${order}</if>" + 
        "<if test='listCount > 0'>LIMIT #{offset}, #{listCount}</if>" +
        "</script>") // <-- Dynamic SQL이 종료됨을 알림
    @ResultMap("myResultId")
    List<ProductModel> selectBestList(ProductModel input);        


    //상품 상세 페이지에 갔을 떄 가져올 상품에 관련된 내용 + 이미지.
    @Select("<script>" + // <-- Dynamic SQL이 시작됨을 알림
        "SELECT p.id, p.name, p.price, p.sale, p.color, p.size, p.product_txt, p.best, p.sort, p.category1_id, i.id, i.img_path, i.thumbnail FROM product AS p " +
        "INNER JOIN img as i " +
        "ON i.product_id = p.id " +
        "</script>") // <-- Dynamic SQL이 종료됨을 알림
    @ResultMap("myResultId")
    List<ProductModel> selectProductDetailList(ProductModel input);   

    
    //어떤 Category1 상품 전체 페이지에서 thumbnail사진만 갖고오도록 하는 SQL
    @Select("<script>" + // <-- Dynamic SQL이 시작됨을 알림
        "SELECT p.id, p.name, p.price, p.sale, p.color, p.size, p.product_txt, p.best, p.sort, p.category1_id, i.id, i.img_path, i.thumbnail FROM product AS p, img as i " +
        "WHERE p.category1_id=(SELECT id FROM category1 WHERE name=#{c1}) " +
        "AND p.id=i.product_id " + 
        "AND i.thumbnail IS NOT NULL " + 
        "ORDER BY p.sort asc " + 
        "<if test='order != null'>, p.price ${order}</if>" + 
        "<if test='listCount > 0'>LIMIT #{offset}, #{listCount}</if>" +
        "</script>") // <-- Dynamic SQL이 종료됨을 알림
    @ResultMap("myResultId")
    List<ProductModel> selectItemImg(ProductModel input);   

    //검색 결과에 맞는 상품의 정보 + 이미지 select
    //SELECT문(다중행 조회)을 수행하는 메서드 정의
    @Select("<script>" + // <-- Dynamic SQL이 시작됨을 알림
        "SELECT p.id, p.name, p.price, p.sale, p.color, p.size, p.product_txt, p.best, p.sort, p.category1_id, i.id, i.img_path, i.thumbnail FROM product AS p, img as i " +
        "<where>" + // <-- 검색 조건 동적 구성 시작
        "<if test='name != null'>name LIKE concat('%', #{name}, '%')</if>" + 
        "<if test='color != null'>OR color LIKE concat('%', #{color}, '%')</if>" + 
        "<if test='size != null'>OR size LIKE concat('%', #{size}, '%')</if>" + 
        "<if test='best != null'>OR best LIKE concat('%', #{best}, '%')</if>" + 
        "<if test='sort != null'>OR sort LIKE concat('%', #{sort}, '%')</if>" +
        "AND p.id=i.product_id " +  
        "AND i.thumbnail IS NOT NULL " + 
        "</where>" + 
        "ORDER BY p.sort asc " + 
        "<if test='order != null'>, p.price ${order}</if>" + 
        "<if test='listCount > 0'>LIMIT #{offset}, #{listCount}</if>" +
        "</script>") // <-- Dynamic SQL이 종료됨을 알림
   @ResultMap("myResultId")
   List<ProductModel> selectListImg(ProductModel input);
}
