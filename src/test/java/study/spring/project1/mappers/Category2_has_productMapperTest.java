package study.spring.project1.mappers;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import study.spring.project1.models.Category2_has_productModel;

@Slf4j
@SpringBootTest
public class Category2_has_productMapperTest {

    @Autowired
    private Category2_has_productMapper category2_has_productMapper;

    @Test
    @DisplayName("카테고리, 상품 ID 추가 테스트")
    void insertCategory2(){
        Category2_has_productModel input = new Category2_has_productModel();

        input.setCategory2_id(4);
        input.setProduct_id(1);

        int output = category2_has_productMapper.insert(input);

        log.debug("output : " + output);
        log.debug("new id : " + input.getId());
    }

    @Test
    @DisplayName("카테고리 수정 테스트")
    void updateCategory2(){
        Category2_has_productModel input = new Category2_has_productModel();

        input.setCategory2_id(1);
        input.setProduct_id(2);
        input.setId(2);

        int output = category2_has_productMapper.update(input);

        log.debug("result: " + output);
    }

    @Test
    @DisplayName("카테고리 삭제 테스트")
    void deleteCategory2(){
        Category2_has_productModel input = new Category2_has_productModel();

        input.setId(3);

        int output = category2_has_productMapper.delete(input);

        log.debug("output : " + output);
    }

    @Test
    @DisplayName("하나의 카테고리 조회 테스트")
    void selectOneCategory2(){
        Category2_has_productModel input = new Category2_has_productModel();
        
        input.setId(1);

        Category2_has_productModel output = category2_has_productMapper.selectItem(input);

        log.debug("result: " + output.toString());
    }

    @Test
    @DisplayName("카테고리 목록 조회 테스트")
    void selectAllDepartment(){
        Category2_has_productModel input = new Category2_has_productModel();
        input.setCategory2_id(1);


        List<Category2_has_productModel> output = category2_has_productMapper.selectList(input);

        for(Category2_has_productModel item : output){
            log.debug("output: "+ item.toString());
        }
    }    
    
}
