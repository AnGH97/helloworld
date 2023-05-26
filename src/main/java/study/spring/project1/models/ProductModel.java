package study.spring.project1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {
    private String best;   // best 상품 노출 여부
    private String color;   // 상품 색상
    private int id;   // 상품 번호
    private String name;   // 상품 이름
    private int price;   // 정가
    private String product_txt;   // 상품 설명 글
    private int sale;   // 판매가
    private String size;   // 상품 사이즈
    private String sort;   // 정렬 순서   
    
    private static int offset;
    private static int listCount;

    public static int getOffset(){
        return offset;
    }

    public static void setOffset(int offset){
        ProductModel.offset = offset;
    }

    public static int getListCount(){
        return listCount;
    }

    public static void setListCount(int listCount){
        ProductModel.listCount = listCount;
    }    
    
}
