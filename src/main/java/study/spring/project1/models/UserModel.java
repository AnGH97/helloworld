package study.spring.project1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    private String address;   // 회원 주소
    private String birthdate;   // 회원 생년월일
    private String email;   // 회원 이메일
    private String gender;   // 회원 성별('M', 'F')
    private int id;   // 회원 아이디 번호
    private String is_out;   // 회원 탈퇴여부("Y", "N")
    private String name;   // 회원 이름
    private String reg_date;   // 회원 가입 일시
    private String tel;   // 회원 연락처
    private String user_id;   // 회원 가입 아이디
    private String user_pw;   // 회원 비밀번호
    
    private static int offset;
    private static int listCount;

    public static int getOffset(){
        return offset;
    }

    public static void setOffset(int offset){
        UserModel.offset = offset;
    }

    public static int getListCount(){
        return listCount;
    }

    public static void setListCount(int listCount){
        UserModel.listCount = listCount;
    }    
        
    
}
