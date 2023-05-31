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
    @Insert("INSERT INTO user (name, user_pw, email, birthdate, gender, tel, address, is_out, reg_date, user_id) VALUES (#{name}, #{user_pw}, #{email}, #{birthdate}, #{gender}, #{tel}, #{address}, #{is_out}, #{reg_date}, #{user_id})")
    //INSERT문에서 필요한 PK에 대한 옵션 정의
    // --> userGeneratedKeys: AUTO_INCREMENT가 적용된 테이블인 경우 사용
    // --> keyProperty: 파라미터로 전달되는 DTO객체에서 PK에 대응되는 멤버변수
    // --> keyColumn: 테이블의 Primary Key 칼럼명
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    //INSERT, UPDATE, DELET용 메서드는 반드시 int형 리턴 --> 적용된 행의 수를 반환
    int insert(UserModel input);

    //UPDATE문을 수행하는 메서드 정의
    @Update("UPDATE user SET name=#{name}, user_pw=#{user_pw}, email=#{email}, birthdate=#{birthdate}, gender=#{gender}, tel=#{tel}, address=#{address}, is_out=#{is_out}, reg_date=#{reg_date}, user_id=#{user_id} WHERE id=#{id}")
    int update(UserModel input);

    //DELETE문을 수행하는 메서드 정의
    @Delete("DELETE FROM user WHERE id=#{id}")
    int delete(UserModel input);

    //SELECT문(단일행 조회)을 수행하는 메서드 정의
    @Select("SELECT id, name, user_pw, email, birthdate, gender, tel, address, is_out, reg_date, user_id FROM user WHERE id=#{id}")
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
        @Result(property="user_id", column="user_id" )})
    UserModel selectItem(UserModel input);

    //SELECT문(다중행 조회)을 수행하는 메서드 정의
    @Select("<script>" + // <-- Dynamic SQL이 시작됨을 알림
        "SELECT id, name, user_pw, email, birthdate, gender, tel, address, is_out, reg_date, user_id FROM user" + 
        "<where>" + // <-- 검색 조건 동적 구성 시작
        "<if test='user_id != null'>user_id LIKE concat('%', #{user_id}, '%')</if>" + 
        "<if test='user_pw != null'>OR user_pw LIKE concat('%', #{user_pw}, '%')</if>" + 
        "<if test='email != null'>OR email LIKE concat('%', #{email}, '%')</if>" + 
        "<if test='birthdate != null'>OR birthdate LIKE concat('%', #{birthdate}, '%')</if>" + 
        "<if test='gender != null'>OR gender LIKE concat('%', #{gender}, '%')</if>" + 
        "<if test='tel != null'>OR tel LIKE concat('%', #{tel}, '%')</if>" + 
        "<if test='address != null'>OR address LIKE concat('%', #{address}, '%')</if>" + 
        "<if test='is_out != null'>OR is_out LIKE concat('%', #{is_out}, '%')</if>" + 
        "<if test='reg_date != null'>OR reg_date LIKE concat('%', #{reg_date}, '%')</if>" + 
        "</where>" + 
        "<if test='listCount > 0'>LIMIT #{offset}, #{listCount}</if>" +
        "</script>") // <-- Dynamic SQL이 종료됨을 알림
   @ResultMap("myResultId")
   List<UserModel> selectList(UserModel input);

   @Select("<script>" + // <-- Dynamic SQL이 시작됨을 알림
        "SELECT COUNT(*) AS cnt FROM user" + 
        "<where>" + // <-- 검색 조건 동적 구성 시작
        "<if test='name != null'>name LIKE concat('%', #{name}, '%')</if>" + 
        "<if test='user_pw != null'>OR user_pw LIKE concat('%', #{user_pw}, '%')</if>" + 
        "<if test='email != null'>OR email LIKE concat('%', #{email}, '%')</if>" + 
        "<if test='birthdate != null'>OR birthdate LIKE concat('%', #{birthdate}, '%')</if>" + 
        "<if test='gender != null'>OR gender LIKE concat('%', #{gender}, '%')</if>" + 
        "<if test='tel != null'>OR tel LIKE concat('%', #{tel}, '%')</if>" + 
        "<if test='address != null'>OR address LIKE concat('%', #{address}, '%')</if>" + 
        "<if test='is_out != null'>OR is_out LIKE concat('%', #{is_out}, '%')</if>" + 
        "<if test='reg_date != null'>OR reg_date LIKE concat('%', #{reg_date}, '%')</if>" + 
        "</where>" + 
        "</script>") // <-- Dynamic SQL이 종료됨을 알림
    public int selectCount(UserModel input);

    //로그인 시 DB에 존재하는 아이디, 비밀번호가 일치하는지 확인 할 수 있도록
    //1) ID를 검색해서 나온 user_pw를 controller에서 view로 전송하고 view에서 일치하는지 확인하도록 해야함.
    //2) 회원 가입시 같은 아이디가 존재하는지 확인할 수 있도록 하여 select가 null이 아니라면 가입 할 수 없도록 view에서 처리해야함.
    @Select("<script>" + // <-- Dynamic SQL이 시작됨을 알림
        "SELECT id, name, user_pw, email, birthdate, gender, tel, address, is_out, reg_date, user_idFROM user" + 
        "<where>" + // <-- 검색 조건 동적 구성 시작
        "<if test='user_id != null'>user_id LIKE #{user_id}</if>" + 
        "</where>" + 
        "</script>") // <-- Dynamic SQL이 종료됨을 알림
    public int selectCheck(UserModel input);    

}
