package study.spring.project1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;
import study.spring.project1.helpers.WebHelper;

@Controller
@RequiredArgsConstructor
public class ShopController {

    /**WbeHelper 객체 */
    private final WebHelper webHelper;
    
    /** top/bottom만 존재하는 페이지 */
    @GetMapping("/shoppingmall/common")
    public ModelAndView common(Model model){
        return new ModelAndView("shoppingmall/common");
    }

    @GetMapping("/shoppingmall/community_write")
    public ModelAndView community_write(Model model){
        return new ModelAndView("shoppingmall/community_write");
    }

    @PostMapping("/shoppingmall/community_write_ok.do")
    public ModelAndView community_write_ok(Model model){
        return webHelper.redirect("/shoppingmall/community1_index", "저장되었습니다.");
    }    

    @GetMapping("/shoppingmall/community1_index")
    public ModelAndView community1_index(Model model){
        return new ModelAndView("shoppingmall/community1_index");
    }

    @GetMapping("/shoppingmall/detail_index")
    public ModelAndView detail_index(Model model){
        return new ModelAndView("shoppingmall/detail_index");
    }

    @PostMapping("/shoppingmall/detail_index_add.do")
    public ModelAndView detail_index_ok(Model model){
        return webHelper.redirect("/shoppingmall/detail_index", "장바구니에 담겼습니다.");
    }

    @GetMapping("/shoppingmall/index")
    public ModelAndView index(Model model){
        return new ModelAndView("shoppingmall/index");
    }

    @GetMapping("/shoppingmall/login")
    public ModelAndView login(Model model){
        return new ModelAndView("shoppingmall/login");
    }

    @PostMapping("/shoppingmall/login_ok.do")
    public ModelAndView login_ok(Model model){
        return webHelper.redirect("/shoppingmall/index", "OOO님 환영합니다.");
    }    

    @GetMapping("/shoppingmall/review_community_write")
    public ModelAndView review_community_write(Model model){
        return new ModelAndView("shoppingmall/review_community_write");
    }

    @PostMapping("/shoppingmall/review_community_write.do")
    public ModelAndView review_community_write_ok(Model model){
        return webHelper.redirect("/shoppingmall/community1_index", "리뷰 작성이 완료되었습니다.");
    }    

    @GetMapping("/shoppingmall/search_index")
    public ModelAndView search_index(Model model){
        return new ModelAndView("shoppingmall/search_index");
    }

    @GetMapping("/shoppingmall/search_index_ok.do")
    public ModelAndView search_index_ok(Model model){
        return new ModelAndView("shoppingmall/search_index");
    }


    @GetMapping("/shoppingmall/shopping_cart")
    public ModelAndView shopping_cart(Model model){
        return new ModelAndView("shoppingmall/shopping_cart");
    }

    @GetMapping("/shoppingmall/signin")
    public ModelAndView signin(Model model){
        return new ModelAndView("shoppingmall/signin");
    }

    @PostMapping("/shoppingmall/signin_ok.do")
    public ModelAndView signin_ok(Model model){
        return webHelper.redirect("/shoppingmall/index", "OOO님 회원가입을 축하합니다.");
    }    

}
