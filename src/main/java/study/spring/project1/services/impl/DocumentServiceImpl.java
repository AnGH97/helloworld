package study.spring.project1.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import study.spring.project1.mappers.DocumentMapper;
import study.spring.project1.models.DocumentModel;
import study.spring.project1.services.DocumentService;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService{
    private final DocumentMapper documentMapper;

    @Override
    public DocumentModel insert(DocumentModel input) throws NullPointerException, Exception {
        // insert문 수행
        // 리턴되는 값은 저장된 데이터의 수
        // 생성된 PK는 파라미터로 전달된 parmas 객체의 적절한 멤버변수에 설정된다. --> getter를 통해 취득 가능함        
        int rows = documentMapper.insert(input);

        // 저장된 데이터가 없다면?
        if (rows == 0) {
            // 객체가 없다는 내용의 에러를 강제 발생시킴
            throw new NullPointerException("저장된 데이터가 없습니다.");
        }
        return documentMapper.selectItem(input);
    }

    @Override
    public DocumentModel update(DocumentModel input) throws NullPointerException, Exception {
        // update문 수행 -> 리턴되는 값은 수정된 데이터의 수
        int rows = documentMapper.update(input);
        // 수정된 데이터가 없다면?
        if (rows == 0) {
            // 객체가 없다는 내용의 에러를 강제 발생시킴
            throw new NullPointerException("수정된 데이터가 없습니다.");
        }
        return documentMapper.selectItem(input);
    }

    @Override
    public void delete(DocumentModel input) throws NullPointerException, Exception {
        // delete문 수행 -> 리턴되는 값은 수정된 데이터의 수
        int rows = documentMapper.delete(input);

        // 삭제된 데이터가 없다면?
        if (rows == 0) {
            // 객체가 없다는 내용의 에러를 강제 발생시킴
            throw new NullPointerException("삭제된 데이터가 없습니다.");
        } 
    }

    @Override
    public DocumentModel selectItem(DocumentModel input) throws NullPointerException, Exception {
        DocumentModel output = documentMapper.selectItem(input);

        if(output == null){
            throw new NullPointerException("조회된 데이터가 없습니다.");
        }

        return output; 
    }

    @Override
    public List<DocumentModel> selectList(DocumentModel input) throws NullPointerException, Exception {
        return documentMapper.selectList(input);
    }

    @Override
    public int selectCount(DocumentModel input) throws NullPointerException, Exception {
        return documentMapper.selectCount(input);
    }

    @Override
    public List<DocumentModel> selectSearch(DocumentModel input) throws NullPointerException, Exception {
        return documentMapper.selectSearch(input);
    }

    @Override
    public List<DocumentModel> selectReview(DocumentModel input) throws NullPointerException, Exception {
        return documentMapper.selectReview(input);
    }
    
}
