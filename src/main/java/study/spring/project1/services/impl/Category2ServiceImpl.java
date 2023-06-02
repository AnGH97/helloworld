package study.spring.project1.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import study.spring.project1.mappers.Category2Mapper;
import study.spring.project1.mappers.Category2_has_productMapper;
import study.spring.project1.mappers.ProductMapper;
import study.spring.project1.models.Category2Model;
import study.spring.project1.models.Category2_has_productModel;
import study.spring.project1.models.ProductModel;
import study.spring.project1.services.Category2Service;

@Service
@RequiredArgsConstructor
public class Category2ServiceImpl implements Category2Service{
    private final Category2_has_productMapper category2_has_productMapper;
    private final Category2Mapper category2Mapper;
    private final ProductMapper productMapper;

    @Override
    public Category2Model insert(Category2Model input) throws NullPointerException, Exception {
        // insert문 수행
        // 리턴되는 값은 저장된 데이터의 수
        // 생성된 PK는 파라미터로 전달된 parmas 객체의 적절한 멤버변수에 설정된다. --> getter를 통해 취득 가능함        
        int rows = category2Mapper.insert(input);

        // 저장된 데이터가 없다면?
        if (rows == 0) {
            // 객체가 없다는 내용의 에러를 강제 발생시킴
            throw new NullPointerException("저장된 데이터가 없습니다.");
        }
        return category2Mapper.selectItem(input);
    }

    @Override
    public Category2Model update(Category2Model input) throws NullPointerException, Exception {
        // update문 수행 -> 리턴되는 값은 수정된 데이터의 수
        int rows = category2Mapper.update(input);
        // 수정된 데이터가 없다면?
        if (rows == 0) {
            // 객체가 없다는 내용의 에러를 강제 발생시킴
            throw new NullPointerException("수정된 데이터가 없습니다.");
        }
        return category2Mapper.selectItem(input);
    }

    @Override
    public void delete(Category2Model input) throws NullPointerException, Exception {
        //카테고리2 삭제를 위해 참조 관계에 있는 자식 데이터를 순서대로 삭제
        Category2_has_productModel category2_has_productModel = new Category2_has_productModel();
        category2_has_productModel.setCategory2_id(input.getId());
        int p1 = category2_has_productModel.getProduct_id();

        ProductModel productModel = new ProductModel();
        productModel.setId(p1);
        
        category2_has_productMapper.delete(category2_has_productModel);
        productMapper.delete(productModel);

        // delete문 수행 -> 리턴되는 값은 수정된 데이터의 수
        int rows = category2Mapper.delete(input);

        // 삭제된 데이터가 없다면?
        if (rows == 0) {
            // 객체가 없다는 내용의 에러를 강제 발생시킴
            throw new NullPointerException("삭제된 데이터가 없습니다.");
        }  
    }

    @Override
    public Category2Model selectItem(Category2Model input) throws NullPointerException, Exception {
        Category2Model output = category2Mapper.selectItem(input);

        if(output == null){
            throw new NullPointerException("조회된 데이터가 없습니다.");
        }

        return output;    
    }

    @Override
    public List<Category2Model> selectList(Category2Model input) throws NullPointerException, Exception {
        return category2Mapper.selectList(input);
    }

    @Override
    public int selectCount(Category2Model input) throws NullPointerException, Exception {
        return category2Mapper.selectCount(input);
    }
    
}
