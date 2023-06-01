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
public class ProdcutMapperTest {

    @Autowired
    private ProductMapper productMapper;

    @Test
    @DisplayName("상품 추가 테스트")
    void insertProduct(){
        ProductModel input = new ProductModel();

        input.setName("아이스페더 컴포트 숏슬리브 1+1");
        input.setPrice(78000);
        input.setSale(29800);
        input.setColor("블랙,백아이보리,블러쉬핑크,시어스킨,피치허니,쉐도우민트,솔져네이비,레몬블링");
        input.setSize("S,M,L,XL,XXL");
        input.setProduct_txt("HTML로 작성될 부분입니다.");
        input.setBest("N");
        input.setSort("f");
        input.setCategory1_id(5);

        int output = productMapper.insert(input);

        log.debug("output : " + output);
        log.debug("new id : " + input.getId());
    }    

    @Test
    @DisplayName("상품 수정 테스트")
    void updateProduct(){
        ProductModel input = new ProductModel();

        input.setName("젤라 인텐션 레깅스 1+1");
        input.setPrice(78000);
        input.setSale(29800);
        input.setColor("블랙,멜로우그레이,토프그레이,잉크그레이,마젠타헤이즈,옐로우오렌지,애쉬블루,멜론,마멀레이즈");
        input.setSize("S,M,L,XL,XXL");
        input.setProduct_txt("HTML로 작성될 부분입니다.");
        input.setBest("Y");
        input.setSort("A");
        input.setCategory1_id(5);
        input.setId(1);

        int output = productMapper.update(input);

        log.debug("output : " + output);
    }    

    @Test
    @DisplayName("상품 삭제 테스트")
    void deleteProduct(){
        ProductModel input = new ProductModel();
        input.setId(2);

        int output = productMapper.delete(input);
        log.debug("output : " + output);
    }   

    @Test
    @DisplayName("하나의 상품 조회 테스트")
    void selectProductItem(){
        ProductModel input = new ProductModel();
        input.setId(3);

        ProductModel output = productMapper.selectItem(input);
        log.debug("output : " + output);
    } 

    @Test
    @DisplayName("상품 목록 조회 테스트")
    void selectProductList(){
        ProductModel input = new ProductModel();
        input.setColor("블랙");

        List<ProductModel> output = productMapper.selectList(input);

        for(ProductModel item : output){
            log.debug("output: "+ item.toString());
        }
    }

    @Test
    @DisplayName("BEST 상품 목록 조회 테스트")
    void selectProductBestList(){
        ProductModel input = new ProductModel();
        input.setC1("우먼즈");
        input.setId(1);
        input.setOrder("asc");
        
        List<ProductModel> output = productMapper.selectBestList(input);

        for(ProductModel item : output){
            log.debug("output: "+ item.toString());
        }
    }

    @Test
    @DisplayName("상품 상세 조회 테스트(+이미지)")
    void selectProductDetailList(){
        ProductModel input = new ProductModel();
        input.setId(1);

        List<ProductModel> output = productMapper.selectProductDetailList(input);

        for(ProductModel item : output){
            log.debug("output: "+ item.toString());
        }
    } 

    @Test
    @DisplayName("Category1 상품 전체 페이지에서 상품 썸네일 조회 테스트")
    void selectItemImg(){
        ProductModel input = new ProductModel();
        input.setId(1);
        input.setC1("우먼즈");

        List<ProductModel> output = productMapper.selectItemImg(input);

        for(ProductModel item : output){
            log.debug("output: "+ item.toString());
        }
    }

    @Test
    @DisplayName("상품 검색 페이지에서 상품 썸네일 조회 테스트")
    void selectListImg(){
        ProductModel input = new ProductModel();
        input.setName("젤라");

        List<ProductModel> output = productMapper.selectListImg(input);

        for(ProductModel item : output){
            log.debug("output: "+ item.toString());
        }
    }
}
