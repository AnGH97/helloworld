package study.spring.project1.mappers;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import study.spring.project1.models.CartModel;

@Mapper
public interface CartMapper {
    //INSERT문을 수행하는 메서드 정의
    @Insert("INSERT INTO cart (user_id, adate, cnt, user_id1, color, size, user_id1) VALUES (#{user_id}, #{adate}, #{cnt}, #{user_id1}, #{color}, #{size}, #{user_id1})")
    //INSERT문에서 필요한 PK에 대한 옵션 정의
    // --> cartGeneratedKeys: AUTO_INCREMENT가 적용된 테이블인 경우 사용
    // --> keyProperty: 파라미터로 전달되는 DTO객체에서 PK에 대응되는 멤버변수
    // --> keyColumn: 테이블의 Primary Key 칼럼명
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    //INSERT, UPDATE, DELET용 메서드는 반드시 int형 리턴 --> 적용된 행의 수를 반환
    int insert(CartModel input);

    //UPDATE문을 수행하는 메서드 정의
    @Update("UPDATE cart SET user_id=#{user_id}, product_id=#{product_id}, adate=#{adate}, cnt=#{cnt}, user_id1=#{user_id1}, color=#{color}, size=#{size} WHERE id=#{id}")
    int update(CartModel input);

    //DELETE문을 수행하는 메서드 정의
    @Delete("DELETE FROM cart WHERE id=#{id}")
    int delete(CartModel input);

    //SELECT문(단일행 조회)을 수행하는 메서드 정의
    @Select("SELECT id, user_id, product_id, adate, cnt, user_id1, color, size FROM cart WHERE id=#{id}")
    //조회 결과와 리턴할 DTO객체를 연결하기 위한 규칙 정의
    // --> property : DTO 객체의 멤버변수 이름
    // --> column : SELECT문에 명시된 필드 이름(AS 옵션을 사용할 경우 별칭으로 명시)
    @Results(id = "myResultId", value={
        @Result( property="id", column="id"),
        @Result( property="user_id", column="user_id"),
        @Result( property="product_id", column="product_id"),
        @Result( property="adate", column="adate"),
        @Result( property="cnt", column="cnt"),
        @Result( property="user_id1", column="user_id1"),
        @Result( property="color", column="color"),
        @Result( property="size", column="size")})
    CartModel selectItem(CartModel input);

    //SELECT문(다중행 조회)을 수행하는 메서드 정의
    @Select("<script>" + // <-- Dynamic SQL이 시작됨을 알림
        "SELECT id, user_id, product_id, adate, cnt, user_id1, color, size FROM cart" + 
        "<where>" + // <-- 검색 조건 동적 구성 시작
        "<if test='user_id != null'>user_id LIKE concat('%', #{user_id}, '%')</if>" + 
        "<if test='product_id != null'>OR product_id LIKE concat('%', #{product_id}, '%')</if>" + 
        "<if test='adate != null'>OR adate LIKE concat('%', #{adate}, '%')</if>" + 
        "<if test='cnt != null'>OR cnt LIKE concat('%', #{cnt}, '%')</if>" + 
        "<if test='user_id1 != null'>OR user_id1 LIKE concat('%', #{user_id1}, '%')</if>" + 
        "<if test='color != null'>OR color LIKE concat('%', #{color}, '%')</if>" + 
        "<if test='size != null'>OR size LIKE concat('%', #{size}, '%')</if>" + 
        "</where>" + 
        "<if test='listCount > 0'>LIMIT #{offset}, #{listCount}</if>" +
        "</script>") // <-- Dynamic SQL이 종료됨을 알림
   @ResultMap("myResultId")
   List<CartModel> selectList(CartModel input);

   @Select("<script>" + // <-- Dynamic SQL이 시작됨을 알림
        "SELECT COUNT(*) AS cnt FROM cart" + 
        "<where>" + // <-- 검색 조건 동적 구성 시작
        "<if test='user_id != null'>user_id LIKE concat('%', #{user_id}, '%')</if>" + 
        "<if test='product_id != null'>OR product_id LIKE concat('%', #{product_id}, '%')</if>" + 
        "<if test='adate != null'>OR adate LIKE concat('%', #{adate}, '%')</if>" + 
        "<if test='cnt != null'>OR cnt LIKE concat('%', #{cnt}, '%')</if>" + 
        "<if test='user_id1 != null'>OR user_id1 LIKE concat('%', #{user_id1}, '%')</if>" + 
        "<if test='color != null'>OR color LIKE concat('%', #{color}, '%')</if>" + 
        "<if test='size != null'>OR size LIKE concat('%', #{size}, '%')</if>" + 
        "</where>" + 
        "</script>") // <-- Dynamic SQL이 종료됨을 알림
    public int selectCount(CartModel input);    
    
}
