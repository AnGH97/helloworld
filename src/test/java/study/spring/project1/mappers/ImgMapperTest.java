package study.spring.project1.mappers;

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
        input.setImg_path("${contextPath}/assets/img/andar-deatil-top-img1.jpg");
        input.setProduct_id(3);

        int output = imgmapper.insert(input);

        log.debug("output : " + output);
        log.debug("new id : " + input.getId());
    }
    
}
