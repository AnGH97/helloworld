package study.spring.project1.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import study.spring.project1.models.Category2_has_productModel;

@Mapper
public interface Category2_has_productMapper {
        //INSERT문을 수행하는 메서드 정의
        @Insert("INSERT INTO category2_has_productModel (category2_id, product_id) VALUES (#{category2_id}, #{product_id})")
        //INSERT, UPDATE, DELET용 메서드는 반드시 int형 리턴 --> 적용된 행의 수를 반환
        int insert(Category2_has_productModel input);

        //UPDATE문을 수행하는 메서드 정의
        @Update("UPDATE category2_has_productModel SET category2_id=#{category2_id}, product_id=#{product_id} WHERE id=#{id}")
        int update(Category2_has_productModel input);

        //DELETE문을 수행하는 메서드 정의
        @Delete("DELETE FROM category2_has_productModel WHERE id=#{id}")
        int delete(Category2_has_productModel input);

        //SELECT문(단일행 조회)을 수행하는 메서드 정의
        @Select("SELECT id, category2_id, product_id FROM category2_has_productModel WHERE id=#{id}")
        //조회 결과와 리턴할 DTO객체를 연결하기 위한 규칙 정의
        // --> property : DTO 객체의 멤버변수 이름
        // --> column : SELECT문에 명시된 필드 이름(AS 옵션을 사용할 경우 별칭으로 명시)
        @Results(id = "myResultId", value={
            @Result(property="product_id", column="product_id"),
            @Result(property="category2_id", column="category2_id"),
            @Result(property="id", column="id" )})
        Category2_has_productModel selectItem(Category2_has_productModel input);

        //SELECT문(다중행 조회)을 수행하는 메서드 정의
        @Select("<script>" + // <-- Dynamic SQL이 시작됨을 알림
            "SELECT id, category2_id, product_id FROM category2_has_productModel" + 
            "<where>" + // <-- 검색 조건 동적 구성 시작
            "<if test='category2_id != null'>category2_id LIKE concat('%', #{category2_id}, '%')</if>" + 
            "<if test='product_id != null'>OR product_id LIKE concat('%', #{product_id}, '%')</if>" + 
            "</where>" + 
            "<if test='listCount > 0'>LIMIT #{offset}, #{listCount}</if>" +
            "</script>") // <-- Dynamic SQL이 종료됨을 알림
        @ResultMap("myResultId")
        List<Category2_has_productModel> selectList(Category2_has_productModel input);

        @Select("<script>" + // <-- Dynamic SQL이 시작됨을 알림
            "SELECT COUNT(*) AS cnt FROM category2_has_productModel" + 
            "<where>" + // <-- 검색 조건 동적 구성 시작
            "<if test='category2_id != null'>category2_id LIKE concat('%', #{category2_id}, '%')</if>" + 
            "<if test='product_id != null'>OR product_id LIKE concat('%', #{product_id}, '%')</if>" + 
            "</where>" + 
            "</script>") // <-- Dynamic SQL이 종료됨을 알림
        public int selectCount(Category2_has_productModel input);  
    
}
