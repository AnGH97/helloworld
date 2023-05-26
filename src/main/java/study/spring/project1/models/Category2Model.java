package study.spring.project1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category2Model {
    private int category1_id;   // 부모 카테고리 참조키
    private int id;   // 자식 카테고리 번호
    private String name;   // 자식 카테고리 이름

    private static int offset;
    private static int listCount;

    public static int getOffset(){
        return offset;
    }

    public static void setOffset(int offset){
        Category2Model.offset = offset;
    }

    public static int getListCount(){
        return listCount;
    }

    public static void setListCount(int listCount){
        Category2Model.listCount = listCount;
    }
    
}
