package study.spring.project1.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import study.spring.project1.mappers.Category2_productMapper;
import study.spring.project1.models.ProductModel;
import study.spring.project1.services.Category2_productService;

@Service
@RequiredArgsConstructor
public class Category2_productServiceImpl implements Category2_productService{
    private final Category2_productMapper category2_productMapper;

    @Override
    public List<ProductModel> selectProductDetailList(ProductModel input) throws NullPointerException, Exception {
        return category2_productMapper.selectProductDetailList(input);
    }

    @Override
    public int selectCount(ProductModel input) throws NullPointerException, Exception {
        return category2_productMapper.selectCount(input);
    }
    
}
