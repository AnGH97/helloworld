package study.spring.project1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category2_has_productModel {
    private int category2_id;   // 자식 카테고리 참조키
    private int product_id;   // 상품 번호 참조키

    private static int offset;
    private static int listCount;

    public static int getOffset(){
        return offset;
    }

    public static void setOffset(int offset){
        Category2_has_productModel.offset = offset;
    }

    public static int getListCount(){
        return listCount;
    }

    public static void setListCount(int listCount){
        Category2_has_productModel.listCount = listCount;
    }
    
}
