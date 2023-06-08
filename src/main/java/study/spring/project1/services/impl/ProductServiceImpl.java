package study.spring.project1.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import study.spring.project1.mappers.CartMapper;
import study.spring.project1.mappers.Category2_has_productMapper;
import study.spring.project1.mappers.ImgMapper;
import study.spring.project1.mappers.ProductMapper;
import study.spring.project1.models.CartModel;
import study.spring.project1.models.Category2_has_productModel;
import study.spring.project1.models.ImgModel;
import study.spring.project1.models.ProductModel;
import study.spring.project1.services.ProductService;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductMapper productMapper;
    private final ImgMapper imgMapper;
    private final CartMapper cartMapper;
    private final Category2_has_productMapper category2_has_productMapper;

    @Override
    public ProductModel insert(ProductModel input) throws NullPointerException, Exception {
        // insert문 수행
        // 리턴되는 값은 저장된 데이터의 수
        // 생성된 PK는 파라미터로 전달된 parmas 객체의 적절한 멤버변수에 설정된다. --> getter를 통해 취득 가능함        
        int rows = productMapper.insert(input);

        // 저장된 데이터가 없다면?
        if (rows == 0) {
            // 객체가 없다는 내용의 에러를 강제 발생시킴
            throw new NullPointerException("저장된 데이터가 없습니다.");
        }
        return productMapper.selectItem(input);
    }

    @Override
    public ProductModel update(ProductModel input) throws NullPointerException, Exception {
        // update문 수행 -> 리턴되는 값은 수정된 데이터의 수
        int rows = productMapper.update(input);
        // 수정된 데이터가 없다면?
        if (rows == 0) {
            // 객체가 없다는 내용의 에러를 강제 발생시킴
            throw new NullPointerException("수정된 데이터가 없습니다.");
        }
        return productMapper.selectItem(input);
    }

    @Override
    public void delete(ProductModel input) throws NullPointerException, Exception {
         CartModel cartModel = new CartModel();
         cartModel.setProduct_id1(input.getId());
         cartMapper.delete(cartModel);

         Category2_has_productModel category2_has_productModel = new Category2_has_productModel();
         category2_has_productModel.setProduct_id(input.getId());
         category2_has_productMapper.delete(category2_has_productModel);
         //상품 삭제를 위해 참조 관계에 있는 자식 데이터를 순서대로 삭제
         ImgModel imgModel = new ImgModel();
         imgModel.setProduct_id(input.getId());
         imgMapper.delete(imgModel);
        // delete문 수행 -> 리턴되는 값은 수정된 데이터의 수
        int rows = productMapper.delete(input);

        // 삭제된 데이터가 없다면?
        if (rows == 0) {
            // 객체가 없다는 내용의 에러를 강제 발생시킴
            throw new NullPointerException("삭제된 데이터가 없습니다.");
        } 
    }

    @Override
    public ProductModel selectItem(ProductModel input) throws NullPointerException, Exception {
        ProductModel output = productMapper.selectItem(input);

        if(output == null){
            throw new NullPointerException("조회된 데이터가 없습니다.");
        }

        return output;     
    }

    @Override
    public List<ProductModel> selectList(ProductModel input) throws NullPointerException, Exception {
        return productMapper.selectList(input);
    }

    @Override
    public int selectCount(ProductModel input) throws NullPointerException, Exception {
        return productMapper.selectCount(input);
    }

    @Override
    public List<ProductModel> selectBestList(ProductModel input) throws NullPointerException, Exception {
        return productMapper.selectBestList(input);
    }

    @Override
    public List<ProductModel> selectProductDetailList(ProductModel input) throws NullPointerException, Exception {
        return productMapper.selectProductDetailList(input);
    }

    @Override
    public List<ProductModel> selectItemImg(ProductModel input) throws NullPointerException, Exception {
        return productMapper.selectItemImg(input);
    }

    @Override
    public List<ProductModel> selectListImg(ProductModel input) throws NullPointerException, Exception {
        return productMapper.selectListImg(input);
    }
}
