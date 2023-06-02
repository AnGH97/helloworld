package study.spring.project1.services;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import study.spring.project1.models.Category1Model;

@Slf4j
@SpringBootTest
public class Category1ServiceTest {
    @Autowired
    private Category1Service category1Service;
    
    
    @Test
    @DisplayName("카테고리 추가 테스트")
    void insertCategory1(){
        Category1Model input = new Category1Model();
        input.setName("테니스");

        Category1Model output = null;

        
        try {
            output = category1Service.insert(input);
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
    void updateCategory1(){
        Category1Model input = new Category1Model();
        input.setId(6);
        input.setName("골프");
        
        Category1Model output = null;
        try {
            output = category1Service.update(input);
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
    void deleteCategory1(){
        Category1Model input = new Category1Model();
        input.setId(6);
        try {
            category1Service.delete(input);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("하나의 카테고리 조회 테스트")
    void selectOneCategory1(){
        Category1Model input = new Category1Model();
        input.setId(1);

        Category1Model output = null;


        try {
            output = category1Service.selectItem(input);
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
        List<Category1Model> output = null;
        
        Category1Model input = new Category1Model();
        input.setName("커뮤니티");

        try {
            output = category1Service.selectList(input);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(output != null){
            for(Category1Model item : output){
                log.debug("output: " + item.toString());
            }
        }
    }    
}
