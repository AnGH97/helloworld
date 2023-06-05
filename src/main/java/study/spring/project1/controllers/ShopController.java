package study.spring.project1.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;
import study.spring.project1.helpers.Pagenation;
import study.spring.project1.helpers.WebHelper;
import study.spring.project1.models.DocumentModel;
import study.spring.project1.services.DocumentService;

@Controller
@RequiredArgsConstructor
public class ShopController {

    /**WbeHelper 객체 */
    private final WebHelper webHelper;

    private final DocumentService documentService;
    
    @GetMapping("/shoppingmall/community_view")
    public ModelAndView community_view(Model model){
        return new ModelAndView("shoppingmall/community_view");
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
    public ModelAndView community1_index(Model model,
                        @RequestParam(value="contype", required = false) String contype,
                        @RequestParam(value="keyword", required = false) String keyword,
                        @RequestParam(value="search", defaultValue = "") String search,
                        @RequestParam(value="page", defaultValue = "1") int nowPage){
        int totalCount = 0; //전체 게시글 수
        int listCount = 10; //한 페이지당 표시할 목록 수
        int pageCount = 5;  //한 그룹당 표시할 페이지 번호 수

        List<DocumentModel> output = null; //조회 결과가 저장될 객체
        Pagenation pagenation = null;   //페이지 번호를 계산한 결과가 저장될 객체

        //조회에 필요한 조건값(검색어)를 Beans에 담는다.
        DocumentModel input = new DocumentModel();

        if(contype != null){
            input.setContype(contype);
        }
        
        if(search.equals("writer")){
            input.setWriter(keyword);
        }
        else if(search.equals("subject")){
            input.setSubject(keyword);
        }
        else{
            input.setWriter(keyword);
            input.setSubject(keyword);
        }

        try {
            //전체 게시글 수 조회
            totalCount = documentService.selectCount(input);
            //페이지 번호 계산 --> 계산 결과를 로그로 출력될 것이다.
            pagenation = new Pagenation(nowPage, totalCount, listCount, pageCount);

            //SQL의 LIMIT절에서 사용될 값을 Beans의 static 변수에 저장
            DocumentModel.setOffset(pagenation.getOffset());
            DocumentModel.setListCount(pagenation.getListCount());
            //데이터 조회하기
            output = documentService.selectList(input);
        } catch (Exception e) {
            return webHelper.serverError(e);
        } 

        //view 처리
        model.addAttribute("contype", contype);
        model.addAttribute("output", output);
        model.addAttribute("keyword", keyword);
        model.addAttribute("pagenation", pagenation);
        model.addAttribute("search", search);
        
        return new ModelAndView("shoppingmall/community1_index");
    }

    @GetMapping("/shoppingmall/detail_index")
    public ModelAndView detail_index(Model model){
        return new ModelAndView("shoppingmall/detail_index");
    }

    @PostMapping("/shoppingmall/detail_index_add_ok.do")
    public ModelAndView detail_index_ok(Model model){
        return webHelper.redirect("/shoppingmall/detail_index", "장바구니에 담겼습니다.");
    }

    @GetMapping("/shoppingmall/index")
    public ModelAndView index(Model model){
        return new ModelAndView("shoppingmall/index");
    }

    @GetMapping("/shoppingmall/inner_index")
    public ModelAndView inner_index(Model model){
        return new ModelAndView("shoppingmall/inner_index");
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

    @PostMapping("/shoppingmall/review_community_write_ok.do")
    public ModelAndView review_community_write_ok(Model model){
        return webHelper.redirect("/shoppingmall/detail_index#detail-middle-review", "리뷰 작성이 완료되었습니다.");
    }    

    @GetMapping("/shoppingmall/search_index")
    public ModelAndView search_index(Model model){
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
