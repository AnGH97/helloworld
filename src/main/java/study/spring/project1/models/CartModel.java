package study.spring.project1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartModel {
    private String adate;   // 장바구니 추가 날짜
    private int cnt;   // 상품 수량
    private String color;   // 상품 색상
    private int id;   // 주문번호
    private int product_id1;   // 장바구니 상품 참조키
    private String size;   // 상품 사이즈
    private String user_id;   // 회원 정보
    private int user_id1;   // 사용자 ID

    private static int offset;
    private static int listCount;

    public static int getOffset(){
        return offset;
    }

    public static void setOffset(int offset){
        CartModel.offset = offset;
    }

    public static int getListCount(){
        return listCount;
    }

    public static void setListCount(int listCount){
        CartModel.listCount = listCount;
    }
    
}
