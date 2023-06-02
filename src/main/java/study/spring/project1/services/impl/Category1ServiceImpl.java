package study.spring.project1.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import study.spring.project1.mappers.Category1Mapper;
import study.spring.project1.mappers.Category2Mapper;
import study.spring.project1.mappers.ProductMapper;
import study.spring.project1.models.Category1Model;
import study.spring.project1.models.Category2Model;
import study.spring.project1.models.ProductModel;
import study.spring.project1.services.Category1Service;

@Service
@RequiredArgsConstructor
public class Category1ServiceImpl implements Category1Service{
    private final Category1Mapper category1Mapper;
    private final Category2Mapper category2Mapper;
    private final ProductMapper productMapper;

    @Override
    public Category1Model insert(Category1Model input) throws NullPointerException, Exception {
        // insert문 수행
        // 리턴되는 값은 저장된 데이터의 수
        // 생성된 PK는 파라미터로 전달된 parmas 객체의 적절한 멤버변수에 설정된다. --> getter를 통해 취득 가능함        
        int rows = category1Mapper.insert(input);

        // 저장된 데이터가 없다면?
        if (rows == 0) {
            // 객체가 없다는 내용의 에러를 강제 발생시킴
            throw new NullPointerException("저장된 데이터가 없습니다.");
        }
        return category1Mapper.selectItem(input);
    }

    @Override
    public Category1Model update(Category1Model input) throws NullPointerException, Exception {
        // update문 수행 -> 리턴되는 값은 수정된 데이터의 수
        int rows = category1Mapper.update(input);
        // 수정된 데이터가 없다면?
        if (rows == 0) {
            // 객체가 없다는 내용의 에러를 강제 발생시킴
            throw new NullPointerException("수정된 데이터가 없습니다.");
        }
        return category1Mapper.selectItem(input);
    }

    @Override
    public void delete(Category1Model input) throws NullPointerException, Exception {
        //카테고리1 삭제를 위해 참조 관계에 있는 자식 데이터를 순서대로 삭제
        ProductModel productModel = new ProductModel();
        productModel.setCategory1_id(input.getId());
        productMapper.delete(productModel);

        Category2Model category2Model = new Category2Model();
        category2Model.setCategory1_id(input.getId());
        category2Mapper.delete(category2Model);

        // delete문 수행 -> 리턴되는 값은 수정된 데이터의 수
        int rows = category1Mapper.delete(input);

        // 삭제된 데이터가 없다면?
        if (rows == 0) {
            // 객체가 없다는 내용의 에러를 강제 발생시킴
            throw new NullPointerException("삭제된 데이터가 없습니다.");
        }  
    }

    @Override
    public Category1Model selectItem(Category1Model input) throws NullPointerException, Exception {
        Category1Model output = category1Mapper.selectItem(input);

        if(output == null){
            throw new NullPointerException("조회된 데이터가 없습니다.");
        }

        return output;     
    }

    @Override
    public List<Category1Model> selectList(Category1Model input) throws NullPointerException, Exception {
        return category1Mapper.selectList(input);
    }

    @Override
    public int selectCount(Category1Model input) throws NullPointerException, Exception {
        return category1Mapper.selectCount(input);
    }
    
}
