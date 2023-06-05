package study.spring.project1.services;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import study.spring.project1.models.ProductModel;

@Slf4j
@SpringBootTest
public class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @Test
    @DisplayName("상품 추가 테스트")
    void insertProduct(){
        ProductModel input = new ProductModel();

        input.setName("핀턱&아웃포켓 조거팬츠 1+1");
        input.setPrice(98000);
        input.setSale(61800);
        input.setColor("블랙,오이스터그레이,페일릴리,에어블루밍,소이라떼,앤틱그린");
        input.setSize("S,M,L");
        input.setProduct_txt("HTML로 작성될 부분입니다.");
        input.setBest("N");
        input.setSort("k");
        input.setCategory1_id(5);

        ProductModel output = null;

        try {
            output = productService.insert(input);
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
        input.setId(5);

        ProductModel output = null;

        try {
            output = productService.update(input);
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
    @DisplayName("상품 삭제 테스트")
    void deleteProduct(){
        ProductModel input = new ProductModel();

        input.setId(5);
        try {
            productService.delete(input);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }   

    @Test
    @DisplayName("하나의 상품 조회 테스트")
    void selectProductItem(){
        ProductModel input = new ProductModel();
        input.setId(3);

        ProductModel output = null;

        try {
            output = productService.selectItem(input);
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
    @DisplayName("상품 목록 조회 테스트")
    void selectProductList(){
        ProductModel input = new ProductModel();
        input.setColor("페일릴리");

        List<ProductModel> output = null;

        try {
            output = productService.selectList(input);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(output != null){
            for(ProductModel item : output){
                log.debug("output: " + item.toString());
            }
        }
    }

    @Test
    @DisplayName("BEST 상품 목록 조회 테스트")
    void selectProductBestList(){
        ProductModel input = new ProductModel();
        input.setC1(5);
        input.setId(1);
        input.setOrder("asc");
        
        List<ProductModel> output = null;

        try {
            output = productService.selectBestList(input);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(output != null){
            for(ProductModel item : output){
                log.debug("output: " + item.toString());
            }
        }
    }

    @Test
    @DisplayName("상품 상세 조회 테스트(+이미지)")
    void selectProductDetailList(){
        ProductModel input = new ProductModel();
        input.setId(1);

        List<ProductModel> output = null;

        try {
            output = productService.selectProductDetailList(input);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(output != null){
            for(ProductModel item : output){
                log.debug("output: " + item.toString());
            }
        }
    } 

    @Test
    @DisplayName("Category1 상품 전체 페이지에서 상품 썸네일 조회 테스트")
    void selectItemImg(){
        ProductModel input = new ProductModel();
        input.setId(1);
        input.setC1(5);

        List<ProductModel> output = null;

        try {
            output = productService.selectItemImg(input);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(output != null){
            for(ProductModel item : output){
                log.debug("output: " + item.toString());
            }
        }
    }

    @Test
    @DisplayName("상품 검색 페이지에서 상품 썸네일 조회 테스트")
    void selectListImg(){
        ProductModel input = new ProductModel();
        input.setName("젤라");

        List<ProductModel> output = null;

        try {
            output = productService.selectListImg(input);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(output != null){
            for(ProductModel item : output){
                log.debug("output: " + item.toString());
            }
        }
    }


}
