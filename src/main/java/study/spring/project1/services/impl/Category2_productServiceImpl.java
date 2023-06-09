package study.spring.project1.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import study.spring.project1.mappers.Category2_productMapper;
import study.spring.project1.mappers.ImgMapper;
import study.spring.project1.models.ImgModel;
import study.spring.project1.models.ProductModel;
import study.spring.project1.services.Category2_productService;

@Service
@RequiredArgsConstructor
public class Category2_productServiceImpl implements Category2_productService {
    private final Category2_productMapper category2_productMapper;
    private final ImgMapper imgMapper;

    @Override
    public List<ProductModel> selectProductDetailList(ProductModel input)
            throws NullPointerException, Exception {
        List<ProductModel> productList = category2_productMapper.selectProductDetailList(input);

        if (productList == null) {
            throw new NullPointerException("조회된 데이터가 없습니다.");
        }

        for (ProductModel item : productList) {
            ImgModel imgModel = new ImgModel();
            imgModel.setProduct_id(item.getId());
            List<ImgModel> imgList = imgMapper.selectList(imgModel);
            item.setImgList(imgList);
        }

        return productList;
    }

    @Override
    public int selectCount(ProductModel input) throws NullPointerException, Exception {
        return category2_productMapper.selectCount(input);
    }

}
