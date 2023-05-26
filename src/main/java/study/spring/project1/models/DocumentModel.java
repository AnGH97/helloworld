package study.spring.project1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentModel {
    private String content;   // 게시글 내용
    private int hit;   // 게시글 조회수
    private int id;   // 게시글 번호
    private String password;   // 게시물 비밀번호
    private String reg_date;   // 게시글 작성일
    private int star;   // 리뷰 별점
    private String subject;   // 게시글 제목
    private String type;   // 게시판 종류
    private String user_id;   // 회원 아이디 참조키
    private String writer;   // 작성자 아이디
    
    private static int offset;
    private static int listCount;

    public static int getOffset(){
        return offset;
    }

    public static void setOffset(int offset){
        DocumentModel.offset = offset;
    }

    public static int getListCount(){
        return listCount;
    }

    public static void setListCount(int listCount){
        DocumentModel.listCount = listCount;
    }
    
    
}
