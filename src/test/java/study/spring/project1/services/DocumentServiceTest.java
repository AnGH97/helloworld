package study.spring.project1.services;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import study.spring.project1.models.DocumentModel;

@Slf4j
@SpringBootTest
public class DocumentServiceTest {
    @Autowired
    private DocumentService documentService;

    @Test
    @DisplayName("게시글 추가 테스트")
    void insertDocument(){
        DocumentModel input = new DocumentModel();
        input.setType("top1");
        input.setWriter("ccyyan");
        input.setPassword("12345");
        input.setSubject("공지사항");
        input.setContent("Hello");
        input.setHit(0);
        input.setReg_date("2023-05-31");
        input.setStar(4);
        input.setUser_id(5);

        DocumentModel output = null;

        try {
            output = documentService.insert(input);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(output != null){
            log.debug("output: " + output.toString());
        }
    }
    
    @Test
    @DisplayName("게시글 수정 테스트")
    void updatetDocument(){
        DocumentModel input = new DocumentModel();
        input.setId(22);
        input.setType("top1");
        input.setWriter("ccyyan");
        input.setPassword("12345");
        input.setSubject("공지사항");
        input.setContent("Hello");
        input.setHit(0);
        input.setReg_date("2023-05-31");
        input.setStar(3);
        input.setUser_id(5);

        DocumentModel output = null;

        try {
            output = documentService.update(input);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(output != null){
            log.debug("output: " + output.toString());
        }
    }

    @Test
    @DisplayName("게시글 삭제 테스트")
    void deleteDocument(){
        DocumentModel input = new DocumentModel();
        input.setId(7);
        try {
            documentService.delete(input);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("하나의 게시글 조회 테스트")
    void selectItemDocument(){
        DocumentModel input = new DocumentModel();
        input.setId(18);
        DocumentModel output = null;

        try {
            output = documentService.selectItem(input);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(output != null){
            log.debug("output: " + output.toString());
        }
    }

    @Test
    @DisplayName("게시글 목록 조회 테스트")
    void selectDocumentList(){
        DocumentModel input = new DocumentModel();
        input.setWriter("ccyyan");

        List<DocumentModel> output = null;

        try {
            output = documentService.selectList(input);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(output != null){
            for(DocumentModel item : output){
                log.debug("output: " + item.toString());
            }
        }
    } 
    
    @Test
    @DisplayName("게시글 검색 테스트")
    void selectSearch(){
        DocumentModel input = new DocumentModel();
        input.setSearch("title");
        input.setSearch_text("공지사항");

        List<DocumentModel> output = null;

        try {
            output = documentService.selectSearch(input);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(output != null){
            for(DocumentModel item : output){
                log.debug("output: " + item.toString());
            }
        }
    }

    @Test
    @DisplayName("게시글 중 리뷰만 검색 테스트")
    void selectReview(){
        DocumentModel input = new DocumentModel();

        input.setSort("desc");

        List<DocumentModel> output = null;

        try {
            output = documentService.selectReview(input);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(output != null){
            for(DocumentModel item : output){
                log.debug("output: " + item.toString());
            }
        }
    }
        
    
}
