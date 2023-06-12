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

import study.spring.project1.models.ImgModel;

@Mapper
public interface ImgMapper {
    //INSERT문을 수행하는 메서드 정의
    @Insert("INSERT INTO img (img_path, product_id, thumbnail) VALUES (#{img_path}, #{product_id}, #{thumbnail})")
    //INSERT문에서 필요한 PK에 대한 옵션 정의
    // --> userGeneratedKeys: AUTO_INCREMENT가 적용된 테이블인 경우 사용
    // --> keyProperty: 파라미터로 전달되는 DTO객체에서 PK에 대응되는 멤버변수
    // --> keyColumn: 테이블의 Primary Key 칼럼명  
    @Options(useGeneratedKeys = true, keyProperty ="id", keyColumn ="id")
    //INSERT, UPDATE, DELET용 메서드는 반드시 int형 리턴 --> 적용된 행의 수를 반환
    int insert(ImgModel input); 

    //UPDATE문을 수행하는 메서드 정의
    @Update("UPDATE img SET img_path=#{img_path}, product_id=#{product_id}, thumbnail=#{thumbnail} WHERE id=#{id}")
    int update(ImgModel input);

    //DELETE문을 수행하는 메서드 정의
    @Delete("DELETE FROM img WHERE id=#{id}")
    int delete(ImgModel input);

    //SELECT문(단일행 조회)을 수행하는 메서드 정의
    @Select("SELECT id, img_path, product_id, thumbnail FROM img WHERE id=#{id}")
    //조회 결과와 리턴할 DTO객체를 연결하기 위한 규칙 정의
    // --> property : DTO 객체의 멤버변수 이름
    // --> column : SELECT문에 명시된 필드 이름(AS 옵션을 사용할 경우 별칭으로 명시)
    @Results(id = "myResultId", value={
        @Result(property="id", column="id"),
        @Result(property="img_path", column="img_path" ),
        @Result(property="thumbnail", column="thumbnail" ),
        @Result(property="product_id", column="product_id")})
    ImgModel selectItem(ImgModel input);

    //SELECT문(다중행 조회)을 수행하는 메서드 정의
    @Select("<script>" + // <-- Dynamic SQL이 시작됨을 알림
        "SELECT id, img_path, product_id, thumbnail FROM img" + 
        "<where>" + // <-- 검색 조건 동적 구성 시작
        //"<if test='img_path != null'>img_path LIKE concat('%', #{img_path}, '%')</if>" + 
        "<if test='product_id != null'>product_id=#{product_id}</if> " +
        "AND thumbnail IS NOT NULL " +  
        "</where>" + 
        //"<if test='listCount > 0'>LIMIT #{offset}, #{listCount}</if>" +
        "</script>") // <-- Dynamic SQL이 종료됨을 알림
   @ResultMap("myResultId")
   List<ImgModel> selectList(ImgModel input);

       //SELECT문(다중행 조회)을 수행하는 메서드 정의
    @Select("<script>" + // <-- Dynamic SQL이 시작됨을 알림
        "SELECT id, img_path, product_id, thumbnail FROM img" + 
        "<where>" + // <-- 검색 조건 동적 구성 시작
        //"<if test='img_path != null'>img_path LIKE concat('%', #{img_path}, '%')</if>" + 
        "<if test='product_id != null'>product_id=#{product_id}</if> " + 
        "AND thumbnail IS NULL " +
        "</where>" + 
        //"<if test='listCount > 0'>LIMIT #{offset}, #{listCount}</if>" +
        "</script>") // <-- Dynamic SQL이 종료됨을 알림
   @ResultMap("myResultId")
   List<ImgModel> selectDetailList(ImgModel input);

   @Select("<script>" + // <-- Dynamic SQL이 시작됨을 알림
        "SELECT COUNT(*) AS cnt FROM img" + 
        "<where>" + // <-- 검색 조건 동적 구성 시작
        //"<if test='img_path != null'>img_path LIKE concat('%', #{img_path}, '%')</if>" + 
        "<if test='product_id != null'>product_id=#{product_id}</if>" + 
        "</where>" + 
        "</script>") // <-- Dynamic SQL이 종료됨을 알림
    public int selectCount(ImgModel input);

}
