package study.spring.project1.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import study.spring.project1.models.DocumentModel;

import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;

@Mapper
public interface DocumentMapper {
    //INSERT문을 수행하는 메서드 정의
    @Insert("INSERT INTO document (type, writer, password, subject, content, hit, reg_date, star, user_id) VALUES (#{type}, #{writer}, #{password}, #{subject}, #{content}, #{hit}, #{reg_date}, #{star}, #{user_id})")
    //INSERT문에서 필요한 PK에 대한 옵션 정의
    // --> userGeneratedKeys: AUTO_INCREMENT가 적용된 테이블인 경우 사용
    // --> keyProperty: 파라미터로 전달되는 DTO객체에서 PK에 대응되는 멤버변수
    // --> keyColumn: 테이블의 Primary Key 칼럼명
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    //INSERT, UPDATE, DELET용 메서드는 반드시 int형 리턴 --> 적용된 행의 수를 반환
    int insert(DocumentModel input);

    //UPDATE문을 수행하는 메서드 정의
    @Update("UPDATE document SET type=#{type}, writer=#{writer}, password=#{password}, subject=#{subject}, content=#{content}, hit=#{hit}, reg_date=#{reg_date}, star=#{star}, user_id=#{user_id} WHERE id=#{id}")
    int update(DocumentModel input);

    //DELETE문을 수행하는 메서드 정의
    @Delete("DELETE FROM document WHERE id=#{id}")
    int delete(DocumentModel input);

    //커뮤니티 제목을 클릭했을 때 그에 대한 내용을 처리할 때 필요한 SQl
    //SELECT문(단일행 조회)을 수행하는 메서드 정의
    @Select("SELECT id, type, writer, password, subject, content, hit, reg_date, star, user_id FROM document WHERE id=#{id}")
    //조회 결과와 리턴할 DTO객체를 연결하기 위한 규칙 정의
    // --> property : DTO 객체의 멤버변수 이름
    // --> column : SELECT문에 명시된 필드 이름(AS 옵션을 사용할 경우 별칭으로 명시)
    @Results(id = "myResultId", value={
        @Result( property="id", column="id"),
        @Result( property="type", column="type"),
        @Result( property="writer", column="writer"),
        @Result( property="password", column="password"),
        @Result( property="subject", column="subject"),
        @Result( property="content", column="content"),
        @Result( property="hit", column="hit"),
        @Result( property="reg_date", column="reg_date"),
        @Result( property="star", column="star"),
        @Result(property="user_id", column="user_id" )})
    DocumentModel selectItem(DocumentModel input);

    //커뮤니티 게시글 목록에서 게시글 번호, 제목, 작성자, 작성일, 조회횟수 필요
    //즉, DB에서 Document에 존재하는 전체 내용을 다 가져와야함(목록으로 사용하기 때문에)
    //SELECT문(다중행 조회)을 수행하는 메서드 정의
    @Select("<script>" + // <-- Dynamic SQL이 시작됨을 알림
        "SELECT id, type, writer, password, subject, content, hit, reg_date, star, user_id FROM document" + 
        "<where>" + // <-- 검색 조건 동적 구성 시작
        "<if test='type != null'>type LIKE concat('%', #{type}, '%')</if>" + 
        "<if test='writer != null'>OR writer LIKE concat('%', #{writer}, '%')</if>" + 
        "<if test='password != null'>OR password LIKE concat('%', #{password}, '%')</if>" + 
        "<if test='subject != null'>OR subject LIKE concat('%', #{subject}, '%')</if>" + 
        "<if test='content != null'>OR content LIKE concat('%', #{content}, '%')</if>" + 
        "<if test='reg_date != null'>OR reg_date LIKE concat('%', #{reg_date}, '%')</if>" + 
        "<if test='star != null'>OR star LIKE concat('%', #{star}, '%')</if>" + 
        "<if test='user_id != null'>OR user_id LIKE concat('%', #{user_id}, '%')</if>" + 
        "</where>" + 
        "<if test='listCount > 0'>LIMIT #{offset}, #{listCount}</if>" +
        "</script>") // <-- Dynamic SQL이 종료됨을 알림
   @ResultMap("myResultId")
   List<DocumentModel> selectList(DocumentModel input);

   @Select("<script>" + // <-- Dynamic SQL이 시작됨을 알림
        "SELECT COUNT(*) AS cnt FROM document" + 
        "<where>" + // <-- 검색 조건 동적 구성 시작
        "<if test='type != null'>type LIKE concat('%', #{type}, '%')</if>" + 
        "<if test='writer != null'>OR writer LIKE concat('%', #{writer}, '%')</if>" + 
        "<if test='password != null'>OR password LIKE concat('%', #{password}, '%')</if>" + 
        "<if test='subject != null'>OR subject LIKE concat('%', #{subject}, '%')</if>" + 
        "<if test='content != null'>OR content LIKE concat('%', #{content}, '%')</if>" + 
        "<if test='reg_date != null'>OR reg_date LIKE concat('%', #{reg_date}, '%')</if>" + 
        "<if test='star != null'>OR star LIKE concat('%', #{star}, '%')</if>" + 
        "<if test='user_id != null'>OR user_id LIKE concat('%', #{user_id}, '%')</if>" + 
        "</where>" + 
        "</script>") // <-- Dynamic SQL이 종료됨을 알림
    public int selectCount(DocumentModel input);    

    //이름 혹은 제목을 검색 하는 것이 필요
    @Select("<script>" + // <-- Dynamic SQL이 시작됨을 알림
        "SELECT id, type, writer, password, subject, content, hit, reg_date, star, user_id FROM document" + 
        "<where>" + // <-- 검색 조건 동적 구성 시작
        "<if test='search_text != null'>" +
        "CASE " + 
        "WHEN #{search} LIKE 'name' THEN writer LIKE concat('%', #{search_text}, '%') " +
        "WHEN #{search} LIKE 'title' THEN subject LIKE concat('%', #{search_text}, '%') " +
        "END " + 
        "</if>" + 
        "</where>" + 
        "<if test='listCount > 0'>LIMIT #{offset}, #{listCount}</if>" +
        "</script>") // <-- Dynamic SQL이 종료됨을 알림
   @ResultMap("myResultId")
   List<DocumentModel> selectSearch(DocumentModel input);
    
   //Review글만 불러오도록 하는 SQL
    @Select("<script>" + // <-- Dynamic SQL이 시작됨을 알림
        "SELECT id, type, writer, password, subject, content, hit, reg_date, star, user_id FROM document " + 
        "WHERE type LIKE 'review' " + 
        "<if test='sort != null'>ORDER BY star ${sort}</if>" + 
        "<if test='listCount > 0'>LIMIT #{offset}, #{listCount}</if>" +
        "</script>") // <-- Dynamic SQL이 종료됨을 알림
    @ResultMap("myResultId")
    List<DocumentModel> selectReview(DocumentModel input);  
}
