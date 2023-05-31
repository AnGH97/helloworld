package study.spring.project1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImgModel {
    private int id;   // 상품 이미지 일련번호
    private String img_path;   // 이미지 경로
    private int product_id;   // 상품 번호 참조키
    private String thumbnail;   // 대표 이미지 설정

    private static int offset;
    private static int listCount;

    public static int getOffset(){
        return offset;
    }

    public static void setOffset(int offset){
        ImgModel.offset = offset;
    }

    public static int getListCount(){
        return listCount;
    }

    public static void setListCount(int listCount){
        ImgModel.listCount = listCount;
    }  
}
