package study.spring.project1.services;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import study.spring.project1.models.Category2Model;

@Slf4j
@SpringBootTest
public class Category2ServiceTest {
    @Autowired
    private Category2Service category2Service;

    @Test
    @DisplayName("카테고리 추가 테스트")
    void insertCategory2(){
        Category2Model input = new Category2Model();
        input.setName("하의");
        input.setCategory1_id(5);

        Category2Model output = null;

        try {
            output = category2Service.insert(input);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(output != null){
            log.debug("output: " + output.toString());
        }
    }

    @Test
    @DisplayName("카테고리 수정 테스트")
    void updateCategory2(){
        Category2Model input = new Category2Model();
        input.setId(6);
        input.setName("조거팬츠");
        input.setCategory1_id(5);

        Category2Model output = null;
        try {
            output = category2Service.update(input);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(output != null){
            log.debug("output: " + output.toString());
        }
    }

    @Test
    @DisplayName("카테고리 삭제 테스트")
    void deleteCategory2(){
        Category2Model input = new Category2Model();
        input.setId(6);
        try {
            category2Service.delete(input);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("하나의 카테고리 조회 테스트")
    void selectOneCategory2(){
        Category2Model input = new Category2Model();
        input.setId(1);

        Category2Model output = null;

        try {
            output = category2Service.selectItem(input);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(output != null){
            log.debug("output: " + output.toString());
        }
    }

    @Test
    @DisplayName("카테고리 목록 조회 테스트")
    void selectAllDepartment(){
        Category2Model input = new Category2Model();
        input.setName("하의");

        List<Category2Model> output = null;

        try {
            output = category2Service.selectList(input);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(output != null){
            for(Category2Model item : output){
                log.debug("output: " + item.toString());
            }
        }
    }    
}
