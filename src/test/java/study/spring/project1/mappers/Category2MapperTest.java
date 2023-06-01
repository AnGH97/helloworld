package study.spring.project1.mappers;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import study.spring.project1.models.Category2Model;

@Slf4j
@SpringBootTest

public class Category2MapperTest {
    @Autowired
    private Category2Mapper category2Mapper;

    @Test
    @DisplayName("카테고리 추가 테스트")
    void insertCategory2(){
        Category2Model input = new Category2Model();
        input.setName("레깅스");
        input.setCategory1_id(5);

        int output = category2Mapper.insert(input);

        log.debug("output : " + output);
        log.debug("new id : " + input.getId());
    }

    @Test
    @DisplayName("카테고리 수정 테스트")
    void updateCategory2(){
        Category2Model input = new Category2Model();
        input.setId(3);
        input.setName("하의");
        input.setCategory1_id(5);
        int output = category2Mapper.update(input);

        log.debug("result: " + output);
    }

    @Test
    @DisplayName("카테고리 삭제 테스트")
    void deleteCategory2(){
        Category2Model input = new Category2Model();
        input.setId(2);

        int output = category2Mapper.delete(input);

        log.debug("output : " + output);
    }

    @Test
    @DisplayName("하나의 카테고리 조회 테스트")
    void selectOneCategory2(){
        Category2Model input = new Category2Model();
        input.setId(4);

        Category2Model output = category2Mapper.selectItem(input);

        log.debug("result: " + output.toString());
    }

    @Test
    @DisplayName("카테고리 목록 조회 테스트")
    void selectAllDepartment(){
        Category2Model input = new Category2Model();
        input.setName("상의");

        List<Category2Model> output = category2Mapper.selectList(input);

        for(Category2Model item : output){
            log.debug("output: "+ item.toString());
        }
    }    
    
}
