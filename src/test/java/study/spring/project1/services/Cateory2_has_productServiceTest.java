package study.spring.project1.services;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import study.spring.project1.models.Category2_has_productModel;

@Slf4j
@SpringBootTest
public class Cateory2_has_productServiceTest {
    
    @Autowired
    private Category2_has_productService category2_has_productservice;

    @Test
    @DisplayName("카테고리, 상품 ID 추가 테스트")
    void insertCategory2(){
        Category2_has_productModel input = new Category2_has_productModel();

        input.setCategory2_id(1);
        input.setProduct_id(3);

        Category2_has_productModel output = null;

        try {
            output = category2_has_productservice.insert(input);
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
        Category2_has_productModel input = new Category2_has_productModel();

        input.setCategory2_id(1);
        input.setProduct_id(2);
        input.setId(3);

        Category2_has_productModel output = null;
        try {
            output = category2_has_productservice.update(input);
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
        Category2_has_productModel input = new Category2_has_productModel();

        input.setId(3);

        try {
            category2_has_productservice.delete(input);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("하나의 카테고리 조회 테스트")
    void selectOneCategory2(){
        Category2_has_productModel input = new Category2_has_productModel();
        
        Category2_has_productModel output = null;
        input.setId(1);

        try {
            output = category2_has_productservice.selectItem(input);
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
    void selectAlleCategory2(){
        Category2_has_productModel input = new Category2_has_productModel();
        input.setCategory2_id(4);


        List<Category2_has_productModel> output = null;

        try {
            output = category2_has_productservice.selectList(input);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(output != null){
            for(Category2_has_productModel item : output){
                log.debug("output: " + item.toString());
            }
        }
    }       
}
