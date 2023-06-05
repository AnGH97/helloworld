package study.spring.project1.services;

import java.util.List;

import study.spring.project1.models.ProductModel;

public interface Category2_productService {

    public List<ProductModel> selectProductDetailList(ProductModel input) throws NullPointerException, Exception;
    
}
