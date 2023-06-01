package study.spring.project1.mappers;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import study.spring.project1.models.ImgModel;

@Slf4j
@SpringBootTest
public class ImgMapperTest {
    @Autowired
    private ImgMapper imgmapper;

    @Test
    @DisplayName("이미지 추가 테스트")
    void insertImg(){
        ImgModel input = new ImgModel();
        input.setImg_path("${pageContext.request.contextPath}/assets/img/andar-deatil-top-img5.jpg");
        input.setProduct_id(1);
        input.setThumbnail(null);

        int output = imgmapper.insert(input);

        log.debug("output : " + output);
        log.debug("new id : " + input.getId());
    }

    @Test
    @DisplayName("이미지 수정 테스트")
    void updateImg(){
        ImgModel input = new ImgModel();
        
        input.setImg_path("${pageContext.request.contextPath}/assets/img/andar-deatil-top-img5.jpg");
        input.setProduct_id(1);
        input.setThumbnail("2");
        input.setId(7);

        int output = imgmapper.update(input);
        log.debug("result: " + output);
    }

    @Test
    @DisplayName("이미지 삭제 테스트")
    void deleteImg(){
        ImgModel input = new ImgModel();

        input.setId(7);

        int output = imgmapper.delete(input);
        log.debug("output : " + output);
    }

    @Test
    @DisplayName("하나의 이미지 조회 테스트")
    void selectImgItem(){
        ImgModel input = new ImgModel();
        input.setId(6);

        ImgModel output = imgmapper.selectItem(input);
        log.debug("result: " + output);
    }

        
    @Test
    @DisplayName("이미지 목록 조회 테스트")
    void selectUserList(){
        ImgModel input = new ImgModel();
        input.setImg_path("1");

        List<ImgModel> output = imgmapper.selectList(input);

        for(ImgModel item : output){
            log.debug("output: "+ item.toString());
        }
    }
    
    
}
