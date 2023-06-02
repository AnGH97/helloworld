package study.spring.project1.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import study.spring.project1.mappers.Category2_has_productMapper;
import study.spring.project1.models.Category2_has_productModel;
import study.spring.project1.services.Category2_has_productService;

@Service
@RequiredArgsConstructor
public class Category2_has_productServiceImpl implements Category2_has_productService{
    private final Category2_has_productMapper category2_has_productMapper;

    @Override
    public Category2_has_productModel insert(Category2_has_productModel input) throws NullPointerException, Exception {
        // insert문 수행
        // 리턴되는 값은 저장된 데이터의 수
        // 생성된 PK는 파라미터로 전달된 parmas 객체의 적절한 멤버변수에 설정된다. --> getter를 통해 취득 가능함        
        int rows = category2_has_productMapper.insert(input);

        // 저장된 데이터가 없다면?
        if (rows == 0) {
            // 객체가 없다는 내용의 에러를 강제 발생시킴
            throw new NullPointerException("저장된 데이터가 없습니다.");
        }
        return category2_has_productMapper.selectItem(input);
    }

    @Override
    public Category2_has_productModel update(Category2_has_productModel input) throws NullPointerException, Exception {
        // update문 수행 -> 리턴되는 값은 수정된 데이터의 수
        int rows = category2_has_productMapper.update(input);
        // 수정된 데이터가 없다면?
        if (rows == 0) {
            // 객체가 없다는 내용의 에러를 강제 발생시킴
            throw new NullPointerException("수정된 데이터가 없습니다.");
        }
        return category2_has_productMapper.selectItem(input);
    }

    @Override
    public void delete(Category2_has_productModel input) throws NullPointerException, Exception {      
        // delete문 수행 -> 리턴되는 값은 수정된 데이터의 수
        int rows = category2_has_productMapper.delete(input);

        // 삭제된 데이터가 없다면?
        if (rows == 0) {
            // 객체가 없다는 내용의 에러를 강제 발생시킴
            throw new NullPointerException("삭제된 데이터가 없습니다.");
        }  
    }

    @Override
    public Category2_has_productModel selectItem(Category2_has_productModel input)
            throws NullPointerException, Exception {
        Category2_has_productModel output = category2_has_productMapper.selectItem(input);

        if(output == null){
            throw new NullPointerException("조회된 데이터가 없습니다.");
        }

        return output;   
    }

    @Override
    public List<Category2_has_productModel> selectList(Category2_has_productModel input)
            throws NullPointerException, Exception {
        return category2_has_productMapper.selectList(input);
    }

    @Override
    public int selectCount(Category2_has_productModel input) throws NullPointerException, Exception {
        return category2_has_productMapper.selectCount(input);
    }
    
}
