package study.spring.project1.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import study.spring.project1.mappers.ImgMapper;
import study.spring.project1.models.ImgModel;
import study.spring.project1.services.ImgService;

@Service
@RequiredArgsConstructor
public class ImgServiceImpl implements ImgService{
    private final ImgMapper imgMapper;

    @Override
    public ImgModel insert(ImgModel input) throws NullPointerException, Exception {
        // insert문 수행
        // 리턴되는 값은 저장된 데이터의 수
        // 생성된 PK는 파라미터로 전달된 parmas 객체의 적절한 멤버변수에 설정된다. --> getter를 통해 취득 가능함        
        int rows = imgMapper.insert(input);

        // 저장된 데이터가 없다면?
        if (rows == 0) {
            // 객체가 없다는 내용의 에러를 강제 발생시킴
            throw new NullPointerException("저장된 데이터가 없습니다.");
        }
        return imgMapper.selectItem(input);
    }

    @Override
    public ImgModel update(ImgModel input) throws NullPointerException, Exception {
        // update문 수행 -> 리턴되는 값은 수정된 데이터의 수
        int rows = imgMapper.update(input);
        // 수정된 데이터가 없다면?
        if (rows == 0) {
            // 객체가 없다는 내용의 에러를 강제 발생시킴
            throw new NullPointerException("수정된 데이터가 없습니다.");
        }
        return imgMapper.selectItem(input);
    }

    @Override
    public void delete(ImgModel input) throws NullPointerException, Exception {

        // delete문 수행 -> 리턴되는 값은 수정된 데이터의 수
        int rows = imgMapper.delete(input);

        // 삭제된 데이터가 없다면?
        if (rows == 0) {
            // 객체가 없다는 내용의 에러를 강제 발생시킴
            throw new NullPointerException("삭제된 데이터가 없습니다.");
        }  
    }

    @Override
    public ImgModel selectItem(ImgModel input) throws NullPointerException, Exception {
        ImgModel output = imgMapper.selectItem(input);

        if(output == null){
            throw new NullPointerException("조회된 데이터가 없습니다.");
        }

        return output; 
    }

    @Override
    public List<ImgModel> selectList(ImgModel input) throws NullPointerException, Exception {
        return imgMapper.selectList(input);
    }

    @Override
    public int selectCount(ImgModel input) throws NullPointerException, Exception {
        return imgMapper.selectCount(input);
    }

    @Override
    public List<ImgModel> selectDetailList(ImgModel input) throws NullPointerException, Exception {
        return imgMapper.selectDetailList(input);
    }
    
}
