package study.spring.project1.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;
import study.spring.project1.exceptions.StringFormatException;
import study.spring.project1.helpers.Pagenation;
import study.spring.project1.helpers.RegexHelper;
import study.spring.project1.helpers.WebHelper;
import study.spring.project1.models.DocumentModel;
import study.spring.project1.models.ProductModel;
import study.spring.project1.models.UserModel;
import study.spring.project1.services.DocumentService;
import study.spring.project1.services.ProductService;
import study.spring.project1.services.UserService;

@Controller
@RequiredArgsConstructor
public class ShopController {

    /**WbeHelper 객체 */
    private final WebHelper webHelper;

    private final DocumentService documentService;

    private final RegexHelper regexHelper;

    private final UserService userService;

    private final ProductService productService;
    
    @GetMapping("/shoppingmall/community_view")
    public ModelAndView community_view(Model model,
        @RequestParam(value="id", defaultValue = "0") int id){
            DocumentModel input = new DocumentModel();
            input.setId(id);

            DocumentModel output = null;

            try {
                output = documentService.selectItem(input);
            } catch (Exception e) {
                return webHelper.serverError(e);
            }
            
            model.addAttribute("output", output);


        return new ModelAndView("shoppingmall/community_view");
    }

    @GetMapping("/shoppingmall/community_write")
    public ModelAndView community_write(Model model,
        @RequestParam(value="contype", required = false) String contype){
        model.addAttribute("contype", contype);
        
        return new ModelAndView("shoppingmall/community_write");
    }

    @PostMapping("/shoppingmall/community_write_ok.do")
    public ModelAndView community_write_ok(Model model,
        @RequestParam(value="contype", required = false) String contype,
        @RequestParam(value="text_title") String subject,
        @RequestParam(value="user_name") String writer,
        @RequestParam(value="user_pw") String password,
        @RequestParam(value="content-title") String content){

            LocalDate now = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String date = now.format(formatter);
            
            try {
                regexHelper.isValue(subject, "제목을 입력하세요.");
                regexHelper.isValue(writer, "이름을 입력하세요.");
                regexHelper.isValue(password, "비밀번호를 입력하세요.");
                regexHelper.isValue(content, "내용을 입력하세요.");
            } catch (StringFormatException e) {
                return webHelper.badRequest(e);
            }

            DocumentModel input = new DocumentModel();
            input.setContype(contype);
            input.setSubject(subject);
            input.setWriter(writer);
            input.setPassword(password);
            input.setContent(content);
            input.setType(contype);
            input.setHit(0);
            input.setReg_date(date);

            try {
                documentService.insert(input);
            } catch (Exception e) {
                return webHelper.serverError(e);
            }

        return webHelper.redirect("/shoppingmall/community1_index?contype=" + input.getContype(), "저장되었습니다.");
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

        String conname = null;
        int number = 0;

        List<DocumentModel> output = null; //조회 결과가 저장될 객체
        Pagenation pagenation = null;   //페이지 번호를 계산한 결과가 저장될 객체

        //조회에 필요한 조건값(검색어)를 Beans에 담는다.
        DocumentModel input = new DocumentModel();

        if(contype.equals("content1")){
            input.setContype(contype);
            conname = "공지사항";
        }
        else if(contype.equals("content2")){
            input.setContype(contype);
            conname = "자주 묻는 질문";
        }
        else if(contype.equals("content3")){
            input.setContype(contype);
            conname = "상품 문의";
        }
        else if(contype.equals("content4")){
            input.setContype(contype);
            conname = "반품 문의";
        }
        else if(contype.equals("content5")){
            input.setContype(contype);
            conname = "교환 문의";
        }
        else if(contype.equals("content6")){
            input.setContype(contype);
            conname = "전국 매장 안내";
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
        model.addAttribute("number", number);
        model.addAttribute("conname", conname);
        model.addAttribute("contype", contype);
        model.addAttribute("output", output);
        model.addAttribute("keyword", keyword);
        model.addAttribute("pagenation", pagenation);
        model.addAttribute("search", search);
        
        return new ModelAndView("shoppingmall/community1_index");
    }

    @GetMapping("/shoppingmall/detail_index")
    public ModelAndView detail_index(Model model,
        @RequestParam(value="sort", required = false) String sort){
        DocumentModel dinput = new DocumentModel();
        if(sort != null){
            dinput.setSort(sort);
        }

        List<DocumentModel> doutput = null;

        try {
            doutput = documentService.selectReview(dinput);
        }catch (Exception e) {
            return webHelper.serverError(e);
        }

        model.addAttribute("doutput", doutput);

        return new ModelAndView("shoppingmall/detail_index");
    }

    @PostMapping("/shoppingmall/detail_index_add_ok.do")
    public ModelAndView detail_index_ok(Model model){
        return webHelper.redirect("/shoppingmall/detail_index", "장바구니에 담겼습니다.");
    }

    @GetMapping({"/shoppingmall/index", "/shoppingmall/index?category1=베스트"})
    public ModelAndView index(Model model,
        @RequestParam(value="category1", required = false) String cn1,
        @RequestParam(value="page", defaultValue = "1") int nowPage){

        ProductModel input = new ProductModel();

        if(cn1 != null){
            if(cn1.equals("우먼즈")){
                input.setC1(11);
                input.setC1name(cn1);
            }
            else if(cn1.equals("맨즈")){
                input.setC1(12);
                input.setC1name(cn1);
            }
            else if(cn1.equals("용품")){
                input.setC1(14);
                input.setC1name(cn1);
            }
            else if(cn1.equals("베스트")){
                input.setC1(9);
                input.setC1name(cn1);
            }
        }

        int totalCount = 0; //전체 게시글 수
        int listCount = 10; //한 페이지당 표시할 목록 수
        int pageCount = 5;  //한 그룹당 표시할 페이지 번호 수

        Pagenation pagenation = null;   //페이지 번호를 계산한 결과가 저장될 객체

        List<ProductModel> output = null;

        
        try {
            //전체 게시글 수 조회
            totalCount = productService.selectCount(input);
            //페이지 번호 계산 --> 계산 결과를 로그로 출력될 것이다.
            pagenation = new Pagenation(nowPage, totalCount, listCount, pageCount);

            //SQL의 LIMIT절에서 사용될 값을 Beans의 static 변수에 저장
            ProductModel.setOffset(pagenation.getOffset());
            ProductModel.setListCount(pagenation.getListCount());
            //데이터 조회하기
            output=productService.selectList(input);

        } catch (Exception e) {
            return webHelper.serverError(e);
        }
        
        model.addAttribute("c1name", input.getC1name());
        model.addAttribute("output", output);
        model.addAttribute("pagenation", pagenation);

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
    public ModelAndView login_ok(Model model, 
        @RequestParam(value="user_id") String user_id,
        @RequestParam(value="user_pw") String user_pw){

            try {
                regexHelper.isValue(user_id, "아이디를 입력하세요.");
                regexHelper.isValue(user_pw, "비밀번호를 입력하세요.");
            } catch (StringFormatException e) {
                return webHelper.badRequest(e);
            }

            UserModel input = new UserModel();
            input.setUser_id(user_id);
            input.setUser_pw(user_pw);
            
            UserModel output = null;

            try {
                output = userService.selectLoginCheck(input);
            }catch (Exception e) {
                return webHelper.redirect("/shoppingmall/login", "아이디 비밀번호가 잘못되었습니다.");
            }


        return webHelper.redirect("/shoppingmall/index", output.getName()+"님 환영합니다.");
    }    

    @GetMapping("/shoppingmall/review_community_write")
    public ModelAndView review_community_write(Model model){
        return new ModelAndView("shoppingmall/review_community_write");
    }

    @PostMapping("/shoppingmall/review_community_write_ok.do")
    public ModelAndView review_community_write_ok(Model model,
        @RequestParam(value="text_title") String subject,
        @RequestParam(value="user_name") String writer,
        @RequestParam(value="user_pw") String password,
        @RequestParam(value="review-star") String star,
        @RequestParam(value="content-title") String content){
            LocalDate now = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String date = now.format(formatter);

            try {
                regexHelper.isValue(subject, "제목을 입력하세요.");
                regexHelper.isValue(writer, "아이디를 입력하세요.");
                regexHelper.isValue(password, "비밀번호를 입력하세요.");
                regexHelper.isValue(star, "만족도를 입력하세요.");
                regexHelper.isValue(content, "내용을 입력하세요.");
            } catch (StringFormatException e) {
                return webHelper.badRequest(e);
            }


            DocumentModel input = new DocumentModel();
            input.setSubject(subject);
            input.setWriter(writer);
            input.setPassword(password);
            input.setStar(Integer.parseInt(star));
            input.setContent(content);
            input.setType("review");
            input.setHit(0);
            input.setReg_date(date);

            try {
                documentService.insert(input);
            }  catch (Exception e) {
                e.printStackTrace();
            }

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
