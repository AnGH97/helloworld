package study.spring.project1.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import study.spring.project1.mappers.CartMapper;
import study.spring.project1.models.CartModel;
import study.spring.project1.services.CartService;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{
    private final CartMapper cartMapper;

    @Override
    public CartModel insert(CartModel input) throws NullPointerException, Exception {
        // insert문 수행
        // 리턴되는 값은 저장된 데이터의 수
        // 생성된 PK는 파라미터로 전달된 parmas 객체의 적절한 멤버변수에 설정된다. --> getter를 통해 취득 가능함        
        int rows = cartMapper.insert(input);

        // 저장된 데이터가 없다면?
        if (rows == 0) {
            // 객체가 없다는 내용의 에러를 강제 발생시킴
            throw new NullPointerException("저장된 데이터가 없습니다.");
        }
        return cartMapper.selectItem(input);
    }

    @Override
    public CartModel update(CartModel input) throws NullPointerException, Exception {
        // update문 수행 -> 리턴되는 값은 수정된 데이터의 수
        int rows = cartMapper.update(input);
        // 수정된 데이터가 없다면?
        if (rows == 0) {
            // 객체가 없다는 내용의 에러를 강제 발생시킴
            throw new NullPointerException("수정된 데이터가 없습니다.");
        }
        return cartMapper.selectItem(input);
    }

    @Override
    public void delete(CartModel input) throws NullPointerException, Exception {
        // delete문 수행 -> 리턴되는 값은 수정된 데이터의 수
        int rows = cartMapper.delete(input);

        // 삭제된 데이터가 없다면?
        if (rows == 0) {
            // 객체가 없다는 내용의 에러를 강제 발생시킴
            throw new NullPointerException("삭제된 데이터가 없습니다.");
        }  
    }

    @Override
    public CartModel selectItem(CartModel input) throws NullPointerException, Exception {
        CartModel output = cartMapper.selectItem(input);

        if(output == null){
            throw new NullPointerException("조회된 데이터가 없습니다.");
        }

        return output;    
    }

    @Override
    public List<CartModel> selectList(CartModel input) throws NullPointerException, Exception {
        return cartMapper.selectList(input);
    }

    @Override
    public int selectCount(CartModel input) throws NullPointerException, Exception {
        return cartMapper.selectCount(input);
    }

    @Override
    public List<CartModel> selectUserList(CartModel input) throws NullPointerException, Exception {
        return cartMapper.selectUserList(input);
    }
    
}
