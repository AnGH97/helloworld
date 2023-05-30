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

import study.spring.project1.models.UserModel;

@Mapper
public interface UserMapper {
    //INSERT문을 수행하는 메서드 정의
    @Insert("INSERT INTO user (id, name, user_pw, email, birthdate, gender, tel, address, is_out, reg_date, cart_id) VALUES (#{id}, #{name}, #{user_pw}, #{email}, #{birthdate}, #{gender}, #{tel}, #{address}, #{is_out}, #{reg_date}, #{cart_id})")
    //INSERT문에서 필요한 PK에 대한 옵션 정의
    // --> userGeneratedKeys: AUTO_INCREMENT가 적용된 테이블인 경우 사용
    // --> keyProperty: 파라미터로 전달되는 DTO객체에서 PK에 대응되는 멤버변수
    // --> keyColumn: 테이블의 Primary Key 칼럼명
    @Options(useGeneratedKeys=false, keyProperty="id", keyColumn = "id")
    //INSERT, UPDATE, DELET용 메서드는 반드시 int형 리턴 --> 적용된 행의 수를 반환
    int insert(UserModel input);

    //UPDATE문을 수행하는 메서드 정의
    @Update("UPDATE user SET name=#{name}, user_pw=#{user_pw}, email=#{email}, birthdate=#{birthdate}, gender=#{gender}, tel=#{tel}, address=#{address}, is_out=#{is_out}, reg_date=#{reg_date} WHERE id=#{id}")
    int update(UserModel input);

    //DELETE문을 수행하는 메서드 정의
    @Delete("DELETE FROM user WHERE id=#{id}")
    int delete(UserModel input);

    //SELECT문(단일행 조회)을 수행하는 메서드 정의
    @Select("SELECT id, name, user_pw, email, birthdate, gender, tel, address, is_out, reg_date, cart_id FROM user WHERE id=#{id}")
    //조회 결과와 리턴할 DTO객체를 연결하기 위한 규칙 정의
    // --> property : DTO 객체의 멤버변수 이름
    // --> column : SELECT문에 명시된 필드 이름(AS 옵션을 사용할 경우 별칭으로 명시)
    @Results(id = "myResultId", value={
        @Result( property="id", column="id"),
        @Result( property="name", column="name"),
        @Result( property="user_pw", column="user_pw"),
        @Result( property="email", column="email"),
        @Result( property="birthdate", column="birthdate"),
        @Result( property="gender", column="gender"),
        @Result( property="tel", column="tel"),
        @Result( property="address", column="address"),
        @Result( property="is_out", column="is_out"),
        @Result(property="reg_date", column="reg_date" ),
        @Result(property="cart_id", column="cart_id")})
    UserModel selectItem(UserModel input);

    //SELECT문(다중행 조회)을 수행하는 메서드 정의
    @Select("<script>" + // <-- Dynamic SQL이 시작됨을 알림
        "SELECT id, name, user_pw, email, birthdate, gender, tel, address, is_out, reg_date, cart_id FROM user" + 
        "<where>" + // <-- 검색 조건 동적 구성 시작
        "<if test='name != null'>name LIKE concat('%', #{name}, '%')</if>" + 
        "<if test='user_pw != null'>user_pw LIKE concat('%', #{user_pw}, '%')</if>" + 
        "<if test='email != null'>email LIKE concat('%', #{email}, '%')</if>" + 
        "<if test='birthdate != null'>birthdate LIKE concat('%', #{birthdate}, '%')</if>" + 
        "<if test='gender != null'>gender LIKE concat('%', #{gender}, '%')</if>" + 
        "<if test='tel != null'>tel LIKE concat('%', #{tel}, '%')</if>" + 
        "<if test='address != null'>address LIKE concat('%', #{address}, '%')</if>" + 
        "<if test='is_out != null'>is_out LIKE concat('%', #{is_out}, '%')</if>" + 
        "<if test='reg_date != null'>reg_date LIKE concat('%', #{reg_date}, '%')</if>" + 
        "<if test='cart_id != null'>OR cart_id LIKE concat('%', #{cart_id}, '%')</if>" + 
        "</where>" + 
        "<if test='listCount > 0'>LIMIT #{offset}, #{listCount}</if>" +
        "</script>") // <-- Dynamic SQL이 종료됨을 알림
   @ResultMap("myResultId")
   List<UserModel> selectList(UserModel input);

   @Select("<script>" + // <-- Dynamic SQL이 시작됨을 알림
        "SELECT COUNT(*) AS cnt FROM user" + 
        "<where>" + // <-- 검색 조건 동적 구성 시작
        "<if test='name != null'>name LIKE concat('%', #{name}, '%')</if>" + 
        "<if test='user_pw != null'>user_pw LIKE concat('%', #{user_pw}, '%')</if>" + 
        "<if test='email != null'>email LIKE concat('%', #{email}, '%')</if>" + 
        "<if test='birthdate != null'>birthdate LIKE concat('%', #{birthdate}, '%')</if>" + 
        "<if test='gender != null'>gender LIKE concat('%', #{gender}, '%')</if>" + 
        "<if test='tel != null'>tel LIKE concat('%', #{tel}, '%')</if>" + 
        "<if test='address != null'>address LIKE concat('%', #{address}, '%')</if>" + 
        "<if test='is_out != null'>is_out LIKE concat('%', #{is_out}, '%')</if>" + 
        "<if test='reg_date != null'>reg_date LIKE concat('%', #{reg_date}, '%')</if>" + 
        "<if test='cart_id != null'>OR cart_id LIKE concat('%', #{cart_id}, '%')</if>" + 
        "</where>" + 
        "</script>") // <-- Dynamic SQL이 종료됨을 알림
    public int selectCount(UserModel input);

}
