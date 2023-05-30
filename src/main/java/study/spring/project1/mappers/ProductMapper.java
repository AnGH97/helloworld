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
    @Insert("INSERT INTO product (name, price, sale, color, size, product_txt, best, sort) VALUES (#{name}, #{price}, #{sale}, #{color}, #{size}, #{product_txt}, #{best}, #{sort})")
    //INSERT문에서 필요한 PK에 대한 옵션 정의
    // --> userGeneratedKeys: AUTO_INCREMENT가 적용된 테이블인 경우 사용
    // --> keyProperty: 파라미터로 전달되는 DTO객체에서 PK에 대응되는 멤버변수
    // --> keyColumn: 테이블의 Primary Key 칼럼명
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    //INSERT, UPDATE, DELET용 메서드는 반드시 int형 리턴 --> 적용된 행의 수를 반환
    int insert(ProductModel input); 
    
    //UPDATE문을 수행하는 메서드 정의
    @Update("UPDATE product SET name=#{name}, price=#{price}, sale=#{sale}, color=#{color}, size=#{size}, product_txt=#{product_txt}, best=#{best}, sort=#{sort} WHERE id=#{id}")
    int update(ProductModel input);

    //DELETE문을 수행하는 메서드 정의
    @Delete("DELETE FROM product WHERE id=#{id}")
    int delete(ProductModel input);   
    
    //SELECT문(단일행 조회)을 수행하는 메서드 정의
    @Select("SELECT id, name, price, sale, color, size, product_txt, best, sort FROM product WHERE id=#{id}")
    //조회 결과와 리턴할 DTO객체를 연결하기 위한 규칙 정의
    // --> property : DTO 객체의 멤버변수 이름
    // --> column : SELECT문에 명시된 필드 이름(AS 옵션을 사용할 경우 별칭으로 명시)
    @Results(id = "myResultId", value={
        @Result(property="id", column="id"),
        @Result(property="name", column="name"),
        @Result(property="price", column="price"),
        @Result(property="sale", column="sale"),
        @Result(property="color", column="color"),
        @Result(property="size", column="size"),
        @Result(property="product_txt", column="product_txt"),
        @Result(property="best", column="best"),
        @Result(property="sort", column="sort")})
    ProductModel selectItem(ProductModel input);

    //SELECT문(다중행 조회)을 수행하는 메서드 정의
    @Select("<script>" + // <-- Dynamic SQL이 시작됨을 알림
        "SELECT id, name, price, sale, color, size, product_txt, best, sort FROM product" + 
        "<where>" + // <-- 검색 조건 동적 구성 시작
        "<if test='name != null'>name LIKE concat('%', #{name}, '%')</if>" + 
        "<if test='price != null'>OR price LIKE concat('%', #{price}, '%')</if>" + 
        "<if test='sale != null'>OR sale LIKE concat('%', #{sale}, '%')</if>" + 
        "<if test='color != null'>OR color LIKE concat('%', #{color}, '%')</if>" + 
        "<if test='size != null'>OR size LIKE concat('%', #{size}, '%')</if>" + 
        "<if test='best != null'>OR best LIKE concat('%', #{best}, '%')</if>" + 
        "<if test='sort != null'>OR sort LIKE concat('%', #{sort}, '%')</if>" + 
        "</where>" + 
        "<if test='listCount > 0'>LIMIT #{offset}, #{listCount}</if>" +
        "</script>") // <-- Dynamic SQL이 종료됨을 알림
   @ResultMap("myResultId")
   List<ProductModel> selectList(ProductModel input);

   @Select("<script>" + // <-- Dynamic SQL이 시작됨을 알림
        "SELECT COUNT(*) AS cnt FROM product" + 
        "<where>" + // <-- 검색 조건 동적 구성 시작
        "<if test='name != null'>name LIKE concat('%', #{name}, '%')</if>" + 
        "<if test='price != null'>OR price LIKE concat('%', #{price}, '%')</if>" + 
        "<if test='sale != null'>OR sale LIKE concat('%', #{sale}, '%')</if>" + 
        "<if test='color != null'>OR color LIKE concat('%', #{color}, '%')</if>" + 
        "<if test='size != null'>OR size LIKE concat('%', #{size}, '%')</if>" + 
        "<if test='best != null'>OR best LIKE concat('%', #{best}, '%')</if>" + 
        "<if test='sort != null'>OR sort LIKE concat('%', #{sort}, '%')</if>" + 
        "</where>" + 
        "</script>") // <-- Dynamic SQL이 종료됨을 알림
    public int selectCount(ProductModel input);    

    //best 상품 노출 여부 -> 우먼스, 맨스, 등 따로 가능하도록 select를 만들어야함
    @Select("<script>" + // <-- Dynamic SQL이 시작됨을 알림
        "SELECT p.id, p.name, p.price, p.sale, p.color, p.size, p.product_txt, p.best, p.sort FROM product AS p " +
        "INNER JOIN category1 AS c " +
        "ON #{c1} = c.name " + 
        "WHERE p.best = Y " +
        "ORDER BY #{sort}" + 
        "<if test='listCount > 0'>LIMIT #{offset}, #{listCount}</if>" +
        "</script>") // <-- Dynamic SQL이 종료됨을 알림
    @ResultMap("myResultId")
    List<ProductModel> selectBestList(ProductModel input);        

    //sort 정렬 순서 -> 정렬할 경우 가격 높은 순, 낮은 순 model에 정렬을 받을 문자열 하나를 추가하여 'asc' 혹은 'desc'에 따라 정렬이 가능하도록 만들것.
    @Select("<script>" + // <-- Dynamic SQL이 시작됨을 알림
        "SELECT id, name, price, sale, color, size, product_txt, best, sort FROM product " + 
        "ORDER BY price #{order}" + 
        "<if test='listCount > 0'>LIMIT #{offset}, #{listCount}</if>" +
        "</script>") // <-- Dynamic SQL이 종료됨을 알림
    @ResultMap("myResultId")
    List<ProductModel> selectSortList(ProductModel input);    
    
}
