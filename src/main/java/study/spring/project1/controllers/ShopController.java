package study.spring.project1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopController {
    
    /** top/bottom만 존재하는 페이지 */
    @GetMapping("/shoppingmall/common")
    public String common(Model model){
        return "shoppingmall/common";
    }

    @GetMapping("/shoppingmall/community_write")
    public String community_write(Model model){
        return "shoppingmall/community_write";
    }

    @GetMapping("/shoppingmall/community1_index")
    public String community1_index(Model model){
        return "shoppingmall/community1_index";
    }

    @GetMapping("/shoppingmall/detail_index")
    public String detail_index(Model model){
        return "shoppingmall/detail_index";
    }

    @GetMapping("/shoppingmall/index")
    public String index(Model model){
        return "shoppingmall/index";
    }

    @GetMapping("/shoppingmall/login")
    public String login(Model model){
        return "shoppingmall/login";
    }

    @GetMapping("/shoppingmall/review_community_write")
    public String review_community_write(Model model){
        return "shoppingmall/review_community_write";
    }

    @GetMapping("/shoppingmall/search_index")
    public String search_index(Model model){
        return "shoppingmall/search_index";
    }

    @GetMapping("/shoppingmall/shopping_cart")
    public String shopping_cart(Model model){
        return "shoppingmall/shopping_cart";
    }

    @GetMapping("/shoppingmall/signin")
    public String signin(Model model){
        return "shoppingmall/signin";
    }
}
