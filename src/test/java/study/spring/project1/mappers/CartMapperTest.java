package study.spring.project1.mappers;

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
        input.setAdate("2023-05-31");
        input.setCnt(1);
        input.setUser_id1(1);
        input.setColor("블랙");
        

        int output = cartMapper.insert(input);

        log.debug("output : " + output);
        log.debug("new id : " + input.getId());
    }
    
}
