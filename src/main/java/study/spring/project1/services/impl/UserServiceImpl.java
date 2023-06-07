package study.spring.project1.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import study.spring.project1.mappers.CartMapper;
import study.spring.project1.mappers.DocumentMapper;
import study.spring.project1.mappers.UserMapper;
import study.spring.project1.models.CartModel;
import study.spring.project1.models.DocumentModel;
import study.spring.project1.models.UserModel;
import study.spring.project1.services.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserMapper userMapper;
    private final CartMapper cartMapper;
    private final DocumentMapper documentMapper;

    @Override
    public UserModel insert(UserModel input) throws NullPointerException, Exception {
        // insert문 수행
        // 리턴되는 값은 저장된 데이터의 수
        // 생성된 PK는 파라미터로 전달된 parmas 객체의 적절한 멤버변수에 설정된다. --> getter를 통해 취득 가능함        
        int rows = userMapper.insert(input);

        // 저장된 데이터가 없다면?
        if (rows == 0) {
            // 객체가 없다는 내용의 에러를 강제 발생시킴
            throw new NullPointerException("저장된 데이터가 없습니다.");
        }
        return userMapper.selectItem(input);
    }

    @Override
    public UserModel update(UserModel input) throws NullPointerException, Exception {
        // update문 수행 -> 리턴되는 값은 수정된 데이터의 수
        int rows = userMapper.update(input);
        // 수정된 데이터가 없다면?
        if (rows == 0) {
            // 객체가 없다는 내용의 에러를 강제 발생시킴
            throw new NullPointerException("수정된 데이터가 없습니다.");
        }
        return userMapper.selectItem(input);
    }

    @Override
    public void delete(UserModel input) throws NullPointerException, Exception {
        //사용자 삭제를 위해 참조 관계에 있는 자식데이터를 순서대로 삭제
        CartModel cartModel = new CartModel();
        cartModel.setUser_id1(input.getId());
        cartMapper.delete(cartModel);

        DocumentModel documentModel = new DocumentModel();
        documentModel.setUser_id(input.getId());
        documentMapper.delete(documentModel);

        // delete문 수행 -> 리턴되는 값은 수정된 데이터의 수
        int rows = userMapper.delete(input);

        // 삭제된 데이터가 없다면?
        if (rows == 0) {
            // 객체가 없다는 내용의 에러를 강제 발생시킴
            throw new NullPointerException("삭제된 데이터가 없습니다.");
        }        
    }

    @Override
    public UserModel selectItem(UserModel input) throws NullPointerException, Exception {

        UserModel output = userMapper.selectItem(input);

        if(output == null){
            throw new NullPointerException("조회된 데이터가 없습니다.");
        }

        return output;        
    }

    @Override
    public List<UserModel> selectList(UserModel input) throws NullPointerException, Exception {
        return userMapper.selectList(input);
    }

    @Override
    public int selectCount(UserModel input) throws NullPointerException, Exception {
        return userMapper.selectCount(input);
    }

    @Override
    public UserModel selectSigninCheck(UserModel input) throws NullPointerException, Exception {
        UserModel output = userMapper.selectSigninCheck(input);
        return output;
    }

    @Override
    public UserModel selectLoginCheck(UserModel input) throws NullPointerException, Exception {
        UserModel output = userMapper.selectLoginCheck(input);

        if (output == null) {
            throw new NullPointerException("아이디나 비밀번호를 확인하세요.");
        }

        return output;
    }
    
}
