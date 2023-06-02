package study.spring.project1.mappers;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import study.spring.project1.models.CartModel;

@Slf4j
@SpringBootTest
public class CartMapperTest {
    @Autowired
    private CartMapper cartMapper;

    @Test
    @DisplayName("카트 추가 테스트")
    void insertCart(){
        CartModel input = new CartModel();
        input.setUser_id("angachi576");
        input.setAdate("2023-06-01");
        input.setCnt(3);
        input.setProduct_id1(1);
        input.setUser_id1(2);
        input.setColor("솔져네이비");
        input.setSize("XXL");
        

        int output = cartMapper.insert(input);

        log.debug("output : " + output);
        log.debug("new id : " + input.getId());
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

        int output = cartMapper.update(input);

        log.debug("result: " + output);
    }

    @Test
    @DisplayName("카트 삭제 테스트")
    void deleteCart(){
        CartModel input = new CartModel();
        input.setId(5);

        int output = cartMapper.delete(input);

        log.debug("result: " + output);
    }

    @Test
    @DisplayName("하나의 카트 선택 테스트")
    void selectItemCart(){
        CartModel input = new CartModel();
        input.setId(3);

        CartModel output = cartMapper.selectItem(input);

        log.debug("result: " + output.toString());
    }

    @Test
    @DisplayName("하나의 카트 선택 테스트")
    void selectListCart(){
        CartModel input = new CartModel();
        input.setSize("M");

        List<CartModel> output = cartMapper.selectList(input);

        for(CartModel item : output){
            log.debug("output: "+ item.toString());
        }
    }

    @Test
    @DisplayName("한 사용자의 카트 테스트")
    void selectUserListCart(){
        CartModel input = new CartModel();
        input.setCuser_id("angachi576");

        List<CartModel> output = cartMapper.selectUserList(input);

        for(CartModel item : output){
            log.debug("output: "+ item.toString());
        }
    }

}
