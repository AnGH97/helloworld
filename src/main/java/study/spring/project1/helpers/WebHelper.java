package study.spring.project1.helpers;

import java.io.PrintWriter;
import java.util.Map;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class WebHelper {
    /** 기본 인코딩 타입 설정 */
    private String encType = "UTF-8";

    /**
     * 메시지 표시 후, 페이지를 지정된 곳으로 이동한다.
     *
     * @param url - 이동할 페이지의 URL, Null일 경우 이전페이지로 이동
     * @param msg - 화면에 표시할 메시지. Null일 경우 표시 안함
     * @return ModelAndView
     */
    public ModelAndView printView(String url, String msg, int statusCode) {

        // 획득한 정보를 로그로 표시한다.
        log.debug(String.format(" --> [printView] %s >> %s", url, msg));

        // 가상의 View로 만들기 위한 HTML 태그 구성
        String html = "<!doctype html>";
        html += "<html>";
        html += "<head>";
        html += "<meta charset='" + this.encType + "'>";

        // 메시지 표시
        if (msg != null) {
            html += "<script type='text/javascript'>alert('" + msg + "');</script>";
        }

        // 페이지 이동
        if (url != null) {
            html += "<meta http-equiv='refresh' content='0; url=" + url + "' />";
        } else {
            html += "<script type='text/javascript'>history.back();</script>";
        }

        html += "</head>";
        html += "<body></body>";
        html += "</html>";

        return this.virtualView(html, statusCode);
    }

    /**
     * 정상적인 상황에서 페이지를 이동하기 위한 기능
     * @param url - 이동할 페이지의 URL, Null일 경우 이전페이지로 이동
     * @param msg - 화면에 표시할 메시지. Null일 경우 표시 안함
     * @return ModelAndView
     */
    public ModelAndView redirect(String url, String msg) {
        return this.printView(url, msg, 200);
    }

    /**
     * 파라미터가 잘못된 경우에 호출할 이전 페이지 이동 기능
     * @param e 에러정보를 담고 있는 객체. 
     *        Exception으로 선언했으므로 어떤 하위 객체가 전달되더라도 형변환되어 받는다.
     * @return ModelAndView
     */
    public ModelAndView badRequest(Exception e) {
        return this.printView(null, e.getMessage(), 400);
    }

    /**
     * 파라미터가 잘못된 경우에 호출할 이전 페이지 이동 기능
     * @param message 개발자가 직접 전달하는 에러 메시지
     * @return ModelAndView
     */
    public ModelAndView badRequest(String message) {
        return this.printView(null, message, 400);
    }

    /**
     * JAVA혹은 SQL쪽에서 잘못된 경우에 호출할 이전 페이지 이동 기능
     * @param e 에러정보를 담고 있는 객체. 
     *        Exception으로 선언했으므로 어떤 하위 객체가 전달되더라도 형변환되어 받는다.
     * @return ModelAndView
     */
    public ModelAndView serverError(Exception e) {
        String message = e.getMessage().trim().replace("'", "\\'").split(System.lineSeparator())[0];
        return this.printView(null, message, 500);
    }

    /**
     * JAVA혹은 SQL쪽에서 잘못된 경우에 호출할 이전 페이지 이동 기능
     * @param message 개발자가 직접 전달하는 에러 메시지
     * @return ModelAndView
     */
    public ModelAndView serverError(String message) {
        return this.printView(null, message, 500);
    }

    /**
     * 파라미터로 받은 내용을 가상의 View로 생성후 리턴한다.
     * 브라우저에게 전달할 HTML,CSS,JS 조합을 출력하기 위해 사용한다.
     * @param body - 브라우저에게 전달할 HTML,CSS,JS 조합 문자열
     * @return ModelAndView
     */
    public ModelAndView virtualView(final String body, final int statusCode) {
        /** 가상의 View를 익명 클래스 방식으로 생성하여 리턴 */
        // --> import org.springframework.web.servlet.View;
        // --> import org.springframework.web.servlet.view.AbstractView;
        View view = new AbstractView() {
            @Override
            protected void renderMergedOutputModel(Map<String, Object> map,
                    HttpServletRequest request, HttpServletResponse response) throws Exception {
                response.setCharacterEncoding(encType);
                response.setStatus(statusCode);
                PrintWriter out = response.getWriter();
                out.println(body);
                out.flush();
            }
        };

        // 가상의 뷰를 리턴한다.
        return new ModelAndView(view);
    }
}
