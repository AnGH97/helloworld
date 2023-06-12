package study.spring.project1.services;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import study.spring.project1.models.ImgModel;

@Slf4j
@SpringBootTest
public class ImgServiceTest {
    @Autowired
    private ImgService imgService;

    @Test
    @DisplayName("이미지 추가 테스트")
    void insertImg(){
        ImgModel input = new ImgModel();
        input.setImg_path("${pageContext.request.contextPath}/assets/img/xexymix_detail_img31.jpg");
        input.setProduct_id(3);
        input.setThumbnail("1");

        ImgModel output = null;

        try {
            output = imgService.insert(input);
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
    @DisplayName("이미지 수정 테스트")
    void updateImg(){
        ImgModel input = new ImgModel();
        
        input.setImg_path("${pageContext.request.contextPath}/assets/img/xexymix_detail_img41.jpg");
        input.setProduct_id(3);
        input.setThumbnail("2");
        input.setId(8);

        ImgModel output = null;
        try {
            output = imgService.update(input);
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
    @DisplayName("이미지 삭제 테스트")
    void deleteImg(){
        ImgModel input = new ImgModel();

        input.setId(8);

        try {
            imgService.delete(input);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("하나의 이미지 조회 테스트")
    void selectImgItem(){
        ImgModel input = new ImgModel();
        input.setId(8);

        ImgModel output = null;

        try {
            output = imgService.selectItem(input);
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
    @DisplayName("이미지 목록 조회 테스트")
    void selectUserList(){
        ImgModel input = new ImgModel();
        input.setImg_path("1");

        List<ImgModel> output = null;

        try {
            output = imgService.selectList(input);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(output != null){
            for(ImgModel item : output){
                log.debug("output: " + item.toString());
            }
        }
    }
    
}
