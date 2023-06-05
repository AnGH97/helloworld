package study.spring.project1.services;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import study.spring.project1.models.CartModel;

@Slf4j
@SpringBootTest
public class CartServiceTest {
    @Autowired
    private CartService cartService;

    @Test
    @DisplayName("카트 추가 테스트")
    void insertCart(){
        CartModel input = new CartModel();
        input.setUser_id("cyj960921");
        input.setAdate("2023-05-31");
        input.setCnt(3);
        input.setProduct_id1(1);
        input.setUser_id1(2);
        input.setColor("솔져네이비");
        input.setSize("L");
        

        CartModel output = null;

        try {
            output = cartService.insert(input);
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
    @DisplayName("카트 수정 테스트")
    void updateCart(){
        CartModel input = new CartModel();
        input.setUser_id("angachi576");
        input.setAdate("2023-06-01");
        input.setCnt(3);
        input.setProduct_id1(1);
        input.setUser_id1(1);
        input.setColor("솔져네이비");
        input.setSize("XXL");
        input.setId(2);

        CartModel output = null;

        try {
            output = cartService.update(input);
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
    @DisplayName("카트 삭제 테스트")
    void deleteCart(){
        CartModel input = new CartModel();
        input.setId(3);
        try {
            cartService.delete(input);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("하나의 카트 선택 테스트")
    void selectItemCart(){
        CartModel input = new CartModel();
        input.setId(2);

        CartModel output = null;

        try {
            output = cartService.selectItem(input);
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
    @DisplayName("하나의 카트 선택 테스트")
    void selectListCart(){
        CartModel input = new CartModel();
        input.setSize("M");

        List<CartModel> output = null;

        try {
            output = cartService.selectList(input);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(output != null){
            for(CartModel item : output){
                log.debug("output: " + item.toString());
            }
        }
    }

    @Test
    @DisplayName("한 사용자의 카트 테스트")
    void selectUserListCart(){
        CartModel input = new CartModel();
        input.setCuser_id("angachi576");

        List<CartModel> output = null;

        try {
            output = cartService.selectUserList(input);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(output != null){
            for(CartModel item : output){
                log.debug("output: " + item.toString());
            }
        }
    }
    
}
