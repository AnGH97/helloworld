package study.spring.project1.mappers;

import org.apache.catalina.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import study.spring.project1.models.UserModel;

@Slf4j
@SpringBootTest
public class UserMapperTest {
    
    @Autowired
    private UserMapper userMapper;

    @Test
    @DisplayName("사용자 추가 테스트")
    void insertUser(){
        UserModel input = new UserModel();

        input.setAddress("경기도 의왕시 내손로 57");
        input.setBirthdate("1996-09-21");
        input.setEmail("cyj960921@naver.com");
        input.setGender("M");
        input.setIs_out("N"); 
        input.setName("조용진");
        input.setReg_date("2023-05-31");
        input.setTel("010-9876-6433");
        input.setUser_id("cyj960921");
        input.setUser_pw("56789");       

        int output = userMapper.insert(input);

        log.debug("output : " + output);
        log.debug("new id : " + input.getId());
    }


    @Test
    @DisplayName("사용자 수정 테스트")    
    void updateUser(){
        UserModel input = new UserModel();
        input.setId(2);
        input.setAddress("경기도 의왕시 내손로 57");
        input.setBirthdate("1996-09-21");
        input.setEmail("cyj960921@naver.com");
        input.setGender("M");
        input.setIs_out("N"); 
        input.setName("조용진");
        input.setReg_date("2023-05-31");
        input.setTel("010-9876-6433");
        input.setUser_id("cyj960921");
        input.setUser_pw("567890"); 

        int output = userMapper.update(input);
        log.debug("result: " + output);
    }

    @Test
    @DisplayName("사용자 삭제 테스트")
    void deleteUser(){
        UserModel input = new UserModel();
        input.setId(3);

        int output = userMapper.delete(input);
        log.debug("output : " + output);
    }    
    
}
