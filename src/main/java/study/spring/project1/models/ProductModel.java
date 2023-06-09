package study.spring.project1.models;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {
    private String best;   // best 상품 노출 여부
    private int category1_id;   // 카테고리 1의 아이디
    private int category2_id;   // 카테고리 2의 아이디
    private String color;   // 상품 색상
    private int id;   // 상품 번호
    private String name;   // 상품 이름
    private int price;   // 정가
    private String product_txt;   // 상품 설명 글
    private int sale;   // 판매가
    private String size;   // 상품 사이즈
    private String sort;   // 정렬 순서

    private String order;   // view에서 파라미터로 넘어 왔을 때 'desc' 혹은 'asc'인지 확인 할 수 있도록 하는 변수
    private Integer c1;   // view에서 파라미터로 넘어 왔을 때 베스트, 맨즈, 우먼즈 인지를 확인 할 수 있도록 하는 변수
    private Integer c2;      // view에서 파라미터로 넘어 왔을 때 c1의 내부 카테고리를 확인 할 수 있도록 하는 변수
    private String c1name;
    private String c2name;

    List<ImgModel> imgList;   // 상품 이미지 리스트

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
