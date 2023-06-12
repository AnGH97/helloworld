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

        input.setName("아이스페더 숏슬리브1+1");
        input.setPrice(58000);
        input.setSale(24800);
        input.setColor("블랙,다크그레이,백아이보리,트로피칼핑크,베이비블루");
        input.setSize("s,m,l,xl");
        input.setBest("Y");
        input.setSort("k");
        input.setProduct_txt("<div class='dt detail-middle-text-img1'>"+
        "<img src='${pageContext.request.contextPath}/assets/img/womens/top/product3_html/product3_detail11.jpg' />"+
        "<div class='detail-middle-inform1'>"+
            "<div class='detail_img11_text1'>"+
                "<span><p>퍼포먼스가 끝나는<br/>순간까지 산뜻하게!</p></span>"+
            "</div>"+
            "<div class='detail_img11_text2'>"+
                "<span><p>아이스페더<br/>숏슬리브</p></span>"+
           "</div>"+
        "</div>"+
    "</div>"+
    "<div class='dt dtimg detail-middle-text-img2'>"+
        "<img src='${pageContext.request.contextPath}/assets/img/womens/top/product3_html/product3_detail21.jpg' />"+
        "<div class='dminform detail-middle-inform2'>"+
            "<div class='ditext1 detail_img21_text1'>
                "<span><p>바디라인을<br/>완성해주는 슬림 핏</p></span>
            "</div>
            "<div class='ditext2 detail_img21_text2'>
                "<span><p>허리에 밀착되는 라인으로<br/>인도어 퍼포먼스 시 신체의 움직임을
                "<br />선명하게 관찰할 수 있어요.</p></span>
            "</div>
            "<hr />
            "<div class='dt ditext3 detail_img21_text3'>
                "<span><p>라피스 블루</p></span>
            "</div>
        "</div>
    "</div>
    "<div class='dt detail-middle-text-img3'>
        "<img src='${pageContext.request.contextPath}/assets/img/womens/top/product3_html/product3_detail31.jpg' />
    "</div>
    "<div class='dt dtimg detail-middle-text-img4'>
        "<img src='${pageContext.request.contextPath}/assets/img/womens/top/product3_html/product3_detail41.jpg' />
        "<div class='dminform detail-middle-inform3'>
            "<div class='ditext1 detail_img41_text1'>
                "<span><p>퍼포먼스를 서포트해주는<br/>기능성 원단</p></span>
            "</div>
            "<div class='ditext2 detail_img41_text2'>
                "<span><p>운동 후 발생하는 열과 땀은 방출하고<br/>외부의 냉기는 차단해줘요</p></span>
            "</div>
            "<hr />
            "<div class='ditext3 detail_img41_text3'>
                "<span><p>미스트 민트</p></span>
            "</div>
        "</div>
    "</div>
    "<div class='dt detail-middle-text-img5'>
        "<img src='${pageContext.request.contextPath}/assets/img/womens/top/product3_html/product3_detail51.jpg' />
    "</div>
    "<div class='dt dtimg detail-middle-text-img6'>
        "<img src='${pageContext.request.contextPath}/assets/img/womens/top/product3_html/product3_detail61.jpg' />
        "<div class='dminform detail-middle-inform4'>
            "<div class='ditext1 detail_img61_text1'>
                "<span><p>산뜻한 착용감</p></span>
            "</div>
            "<div class='ditext2 detail_img61_text2'>
                "<span><p>우수한 흡한속건기능으로<br/>쾌적함과 청량감을 유지해줘요.</p></span>
            "</div>
            "<hr />
            "<div class='ditext3 detail_img61_text3'>
                "<span><p>베티버 카키</p></span>
            "</div>
        "</div>
    "</div>
    "<div class='dt detail-middle-text-img7'>
        "<img src='${pageContext.request.contextPath}/assets/img/womens/top/product3_html/product3_detail71.jpg' />
    "</div>
    "<div class='dt dtimg detail-middle-text-img8'>
        "<img src='${pageContext.request.contextPath}/assets/img/womens/top/product3_html/product3_detail81.jpg' />
        "<div class='dminform detail-middle-inform5'>
            "<hr />
            "<div class='dt ditext3 detail_img81_text3'>
                "<span><p>달리아 와인</p></span>
            "</div>
        "</div>
    "</div>
    "<div class='dt detail-middle-text-img9'>
        "<img src='${pageContext.request.contextPath}/assets/img/womens/top/product3_html/product3_detail91.jpg' />
    "</div>
    "<div class='dt dtimg detail-middle-text-img10'>
        "<img src='${pageContext.request.contextPath}/assets/img/womens/top/product3_html/product3_detail101.jpg' />
        "<div class='dminform detail-middle-inform6'>
            "<hr />
            "<div class='ditext3 detail_img101_text3'>
                "<span><p>도브 베이지</p></span>
            "</div>
        "</div>
    "</div>
    "<div class='dt detail-middle-text-img11'>
        "<img src='${pageContext.request.contextPath}/assets/img/womens/top/product3_html/product3_detail111.jpg' />
    "</div>
    "<div class='dt dtimg detail-middle-text-img12'>
        "<img src='${pageContext.request.contextPath}/assets/img/womens/top/product3_html/product3_detail121.jpg' />
        "<div class='dminform detail-middle-inform7'>
            "<hr />
            "<div class='ditext3 detail_img121_text3'>
                "<span><p>시어스킨</p></span>
            "</div>
        "</div>
    "</div>
    "<div class='dt detail-middle-text-img13'>
        "<img src='${pageContext.request.contextPath}/assets/img/womens/top/product3_html/product3_detail131.jpg' />
    "</div>
    "<div class='dt dtimg detail-middle-text-img14'>
        "<img src='${pageContext.request.contextPath}/assets/img/womens/top/product3_html/product3_detail141.jpg' />
        "<div class='dminform detail-middle-inform8'>
            "<hr />
            "<div class='ditext3 detail_img141_text3'>
                "<span><p>블랙</p></span>
            "</div>
        "</div>
    "</div>
    "<div class='dt detail-middle-text-img15'>
        "<img src='${pageContext.request.contextPath}/assets/img/womens/top/product3_html/product3_detail151.jpg' />
    "</div>
    "<div class='dt dtimg detail-middle-text-img16'>
        "<img src='${pageContext.request.contextPath}/assets/img/womens/top/product3_html/product3_detail161.jpg' />
        "<div class='dminform detail-middle-inform9'>
            "<hr />
            "<div class='ditext3 detail_img161_text3'>
                "<span><p>베이비 블루</p></span>
            "</div>
        "</div>
    "</div>
    "<div class='dt detail-middle-text-img17'>
        "<img src='${pageContext.request.contextPath}/assets/img/womens/top/product3_html/product3_detail171.jpg' />
    "</div>
    "<div class='dt dtimg detail-middle-text-img18'>
        "<img src='${pageContext.request.contextPath}/assets/img/womens/top/product3_html/product3_detail181.jpg' />
        "<div class='dminform detail-middle-inform10'>
            "<hr />
            "<div class='ditext3 detail_img181_text3'>
                "<span><p>다크 그레이</p></span>
            "</div>
        "</div>
    "</div>
    "<div class='dt detail-middle-text-img19'>
        "<img src='${pageContext.request.contextPath}/assets/img/womens/top/product3_html/product3_detail191.jpg' />
    "</div>
    "<div class='dt dtimg detail-middle-text-img20'>
        "<img src='${pageContext.request.contextPath}/assets/img/womens/top/product3_html/product3_detail201.jpg' />
        "<div class='dminform detail-middle-inform11'>
            "<hr />
            "<div class='ditext3 detail_img201_text3'>
                "<span><p>아이보리</p></span>
            "</div>
        "</div>
    "</div>
    "<div class='dt detail-middle-text-img21'>
        "<img src='${pageContext.request.contextPath}/assets/img/womens/top/product3_html/product3_detail211.jpg' />
    "</div>
    "<div class='dt dtimg detail-middle-text-img22'>
        "<img src='${pageContext.request.contextPath}/assets/img/womens/top/product3_html/product3_detail221.jpg' />
        "<div class='dminform detail-middle-inform12'>
            "<hr />
            "<div class='ditext3 detail_img221_text3'>
                "<span><p>크림레몬</p></span>
            </div>
        </div>
    </div>
    <div class='dt detail-middle-text-img23'>
        <img src='${pageContext.request.contextPath}/assets/img/womens/top/product3_html/product3_detail231.jpg' />
    </div>
    <div class='dt dtimg detail-middle-text-img24'>
        <img src='${pageContext.request.contextPath}/assets/img/womens/top/product3_html/product3_detail241.jpg' />
        <div class='dminform detail-middle-inform13'>
            <hr />
            <div class='ditext3 detail_img241_text3'>
                <span><p>블랑 라벤더</p></span>
            </div>
        </div>
    </div>
    <div class='dt detail-middle-text-img25'>
        <img src='${pageContext.request.contextPath}/assets/img/womens/top/product3_html/product3_detail251.jpg' />
    </div>
    <div class='dt dtimg detail-middle-text-img26'>
        <img src='${pageContext.request.contextPath}/assets/img/womens/top/product3_html/product3_detail261.jpg' />
        <div class='dminform detail-middle-inform14'>
            <hr />
            <div class='ditext3 detail_img261_text3'>
                <span><p>트로피칼 핑크</p></span>
            </div>
        </div>
    </div>
    <div class='dt detail-middle-text-img27'>
        <img src='${pageContext.request.contextPath}/assets/img/womens/top/product3_html/product3_detail271.jpg' />
    </div>
    <div class='dt dtimg detail-middle-text-img28'>
        <img src='${pageContext.request.contextPath}/assets/img/womens/top/product3_html/product3_detail281.jpg' />
        <div class='dminform detail-middle-inform14'>
            <hr />
            <div class='ditext3 detail_img281_text3'>
                <span><p>코랄무드</p></span>
            </div>
        </div>  
    </div>
    <div class='dt detail-middle-text-img29'>
        <img src='${pageContext.request.contextPath}/assets/img/womens/top/product3_html/product3_detail291.jpg' />
    </div>
    <div class='dt dtimg detail-middle-text-img30'>
        <img src='${pageContext.request.contextPath}/assets/img/womens/top/product3_html/product3_detail301.jpg' />
        <div class='dminform detail-middle-inform14'>
            <hr />
            <div class='ditext3 detail_img301_text3'>
                <span><p>멜로우 로즈</p></span>
            </div>
        </div>
    </div>
    <div class='dt detail-middle-text-img31'>
        <img src='${pageContext.request.contextPath}/assets/img/womens/top/product3_html/product3_detail311.jpg' />
    </div>
    <div class='dt dtimg detail-middle-text-img32'>
        <img src='${pageContext.request.contextPath}/assets/img/womens/top/product3_html/product3_detail321.jpg' />
        <div class='dminform detail-middle-inform14'>
            <hr />
            <div class='ditext3 detail_img321_text3'>
                <span><p>돌체 그레이</p></span>
            </div>
        </div>
    </div>
    <div class='dt detail-middle-text-img33'>
        <img src='${pageContext.request.contextPath}/assets/img/womens/top/product3_html/product3_detail331.jpg' />
    </div>
    <div class='dt dtimg detail-middle-text-img34'>
        <img src='${pageContext.request.contextPath}/assets/img/womens/top/product3_html/product3_detail341.jpg' />
        <div class='dminform detail-middle-inform14'>
            <hr />
            <div class='ditext3 detail_img341_text3'>
                <span><p>소울핑크</p></span>
            </div>
        </div>
    </div>
    <div class='dt detail-middle-text-img35'>
        <img src='${pageContext.request.contextPath}/assets/img/womens/top/product3_html/product3_detail351.jpg' />
    </div>
    <div class='dt dtimg detail-middle-text-img36'>
        <img src='${pageContext.request.contextPath}/assets/img/womens/top/product3_html/product3_detail361.jpg' />
        <div class='dminform detail-middle-inform14'>
            <hr />
            <div class='ditext3 detail_img361_text3'>
                <span><p>버드 네이비</p></span>
            </div>
        </div>
    </div>
    <div class='dt detail-middle-text-img37'>
        <img src='${pageContext.request.contextPath}/assets/img/womens/top/product3_html/product3_detail371.jpg' />
    </div>
    <div class='dt dtimg detail-middle-text-img38'>
        <img src='${pageContext.request.contextPath}/assets/img/womens/top/product3_html/product3_detail381.jpg' />
        <div class='dminform detail-middle-inform14'>
            <hr />
            <div class='ditext3 detail_img381_text3'>
                <span><p>스마일 옐로우</p></span>
            </div>
        </div>
    </div>
    <div class='dt detail-middle-text-img39'>
        <img src='${pageContext.request.contextPath}/assets/img/womens/top/product3_html/product3_detail391.jpg' />
    </div>
    <div class='dt dtimg detail-middle-text-img40'>
        <img src='${pageContext.request.contextPath}/assets/img/womens/top/product3_html/product3_detail401.jpg' />
        <div class='dminform detail-middle-inform14'>
            <hr />
            <div class='ditext3 detail_img401_text3'>
                <span><p>메이플 베이지</p></span>
            </div>
        </div>
    </div>
    <div class='dt detail-middle-text-img41'>
        <img src='${pageContext.request.contextPath}/assets/img/womens/top/product3_html/product3_detail411.jpg' />
    </div>");
        input.setId(8);

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
        input.setId(8);

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
