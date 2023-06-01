package study.spring.project1.mappers;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import study.spring.project1.models.Category1Model;

@Slf4j
@SpringBootTest

public class Category1MapperTest {
    @Autowired
    private Category1Mapper category1Mapper;

    @Test
    @DisplayName("카테고리 추가 테스트")
    void insertCategory1(){
        Category1Model input = new Category1Model();
        input.setName("우먼즈");

        int output = category1Mapper.insert(input);

        log.debug("output : " + output);
        log.debug("new id : " + input.getId());
    }

    @Test
    @DisplayName("카테고리 수정 테스트")
    void updateCategory1(){
        Category1Model input = new Category1Model();
        input.setId(2);
        input.setName("커뮤니티");
        int output = category1Mapper.update(input);

        log.debug("result: " + output);
    }

    @Test
    @DisplayName("카테고리 삭제 테스트")
    void deleteCategory1(){
        Category1Model input = new Category1Model();
        input.setId(2);

        int output = category1Mapper.delete(input);

        log.debug("output : " + output);
    }

    @Test
    @DisplayName("하나의 카테고리 조회 테스트")
    void selectOneCategory1(){
        Category1Model input = new Category1Model();
        input.setId(1);

        Category1Model output = category1Mapper.selectItem(input);

        log.debug("result: " + output.toString());
    }

    @Test
    @DisplayName("카테고리 목록 조회 테스트")
    void selectAllDepartment(){
        Category1Model input = new Category1Model();
        input.setName("커뮤니티");

        List<Category1Model> output = category1Mapper.selectList(input);

        for(Category1Model item : output){
            log.debug("output: "+ item.toString());
        }
    }    
    
}
