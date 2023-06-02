package study.spring.project1.mappers;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import study.spring.project1.models.ProductModel;

@Slf4j
@SpringBootTest
public class Category2_productMapperTest {

    @Autowired
    private Category2_productMapper category2_productMapper;

    @Test
    @DisplayName("카테고리 2의 상품 목록 테스트")
    void selectUserListCart(){
        ProductModel input = new ProductModel();
        input.setC1("5");
        input.setC2("4");

        List<ProductModel> output = category2_productMapper.selectProductDetailList(input);

        for(ProductModel item : output){
            log.debug("output: "+ item.toString());
        }
    }
    
}
