package study.spring.project1.services;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import study.spring.project1.models.UserModel;

@Slf4j
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    @DisplayName("사용자 추가 테스트")
    void insertUser(){
        UserModel input = new UserModel();

        input.setAddress("서울시 영등포구 당산로 61");
        input.setBirthdate("1998-11-30");
        input.setEmail("ccyyan@naver.com");
        input.setGender("M");
        input.setIs_out("N"); 
        input.setName("안정훈");
        input.setReg_date("2023-05-31");
        input.setTel("010-2396-7536");
        input.setUser_id("ccyyan");
        input.setUser_pw("123456");       

        UserModel output = null;

        try {
            output = userService.insert(input);
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
    @DisplayName("사용자 수정 테스트")    
    void updateUser(){
        UserModel input = new UserModel();
        input.setId(6);
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

        UserModel output = null;

        try {
            output = userService.update(input);
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
    @DisplayName("사용자 삭제 테스트")
    void deleteUser(){
        UserModel input = new UserModel();
        input.setId(7);
        try {
            userService.delete(input);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 

    @Test
    @DisplayName("하나의 사용자 조회 테스트")
    void selectUserItem(){
        UserModel input = new UserModel();
        input.setId(1);

        UserModel output = null;

        try {
            output = userService.selectItem(input);
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
    @DisplayName("다중행 사용자 목록 조회 테스트")
    void selectUserList(){
        List<UserModel> output = null;

        UserModel input = new UserModel();
        input.setUser_id("6");

        try {
            output = userService.selectList(input);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(output != null){
            for(UserModel item : output){
                log.debug("output: " + item.toString());
            }
        }
    }

    
    @Test
    @DisplayName("사용자 ID 중복 테스트")
    void selectUserID(){
        UserModel input = new UserModel();
        input.setUser_id("c");

        UserModel output = null;

        try {
            output = userService.selectCheck(input);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(output != null){
            log.debug("output: " + output.toString() + "사용자가 존재합니다.");
        }
    }

    
}
