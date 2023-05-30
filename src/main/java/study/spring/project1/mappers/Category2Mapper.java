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

import study.spring.project1.models.Category2Model;

@Mapper
public interface Category2Mapper {
        //INSERT문을 수행하는 메서드 정의
        @Insert("INSERT INTO category2 (name, category1_id) VALUES (#{name}, #{category1_id})")
        //INSERT문에서 필요한 PK에 대한 옵션 정의
        // --> userGeneratedKeys: AUTO_INCREMENT가 적용된 테이블인 경우 사용
        // --> keyProperty: 파라미터로 전달되는 DTO객체에서 PK에 대응되는 멤버변수
        // --> keyColumn: 테이블의 Primary Key 칼럼명
        @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
        //INSERT, UPDATE, DELET용 메서드는 반드시 int형 리턴 --> 적용된 행의 수를 반환
        int insert(Category2Model input);

        //UPDATE문을 수행하는 메서드 정의
        @Update("UPDATE category2 SET name=#{name}, category1_id=#{category1_id} WHERE id=#{id}")
        int update(Category2Model input);

        //DELETE문을 수행하는 메서드 정의
        @Delete("DELETE FROM category2 WHERE id=#{id}")
        int delete(Category2Model input);

        //SELECT문(단일행 조회)을 수행하는 메서드 정의
        @Select("SELECT id, name, category1_id FROM category2 WHERE id=#{id}")
        //조회 결과와 리턴할 DTO객체를 연결하기 위한 규칙 정의
        // --> property : DTO 객체의 멤버변수 이름
        // --> column : SELECT문에 명시된 필드 이름(AS 옵션을 사용할 경우 별칭으로 명시)
        @Results(id = "myResultId", value={
            @Result(property="category1_id", column="category1_id"),
            @Result(property="name", column="name"),
            @Result(property="id", column="id" )})
        Category2Model selectItem(Category2Model input);

        //SELECT문(다중행 조회)을 수행하는 메서드 정의
        @Select("<script>" + // <-- Dynamic SQL이 시작됨을 알림
            "SELECT id, name, category1_id FROM category2" + 
            "<where>" + // <-- 검색 조건 동적 구성 시작
            "<if test='name != null'>name LIKE concat('%', #{name}, '%')</if>" + 
            "<if test='category1_id != null'>OR category1_id LIKE concat('%', #{category1_id}, '%')</if>" + 
            "</where>" + 
            "<if test='listCount > 0'>LIMIT #{offset}, #{listCount}</if>" +
            "</script>") // <-- Dynamic SQL이 종료됨을 알림
        @ResultMap("myResultId")
        List<Category2Model> selectList(Category2Model input);

        @Select("<script>" + // <-- Dynamic SQL이 시작됨을 알림
            "SELECT COUNT(*) AS cnt FROM category2" + 
            "<where>" + // <-- 검색 조건 동적 구성 시작
            "<if test='name != null'>name LIKE concat('%', #{name}, '%')</if>" + 
            "<if test='category1_id != null'>OR category1_id LIKE concat('%', #{category1_id}, '%')</if>" + 
            "</where>" + 
            "</script>") // <-- Dynamic SQL이 종료됨을 알림
        public int selectCount(Category2Model input);        
    
}
