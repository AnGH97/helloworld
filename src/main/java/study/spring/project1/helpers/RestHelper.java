package study.spring.project1.helpers;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RestHelper {

    private final HttpServletResponse response;

    /**
     * 전달받은 Map객체와 status와 timestamp 값을 추가한 후 리턴한다.
     * @param status    - HTTP 결과코드(200, 404, 500 등)
     * @param message   - 결과메시지(성공일 경우 OK, 그 밖의 경우 에러메시지)
     * @param data      -JSON으로 변환할 데이터 컬렉션
     * @return Map<String, Object>
     */
    public Map<String, Object> sendJson(int status, String message, Map<String, Object> data){

        /** 1) JSON 형식 출력을 위한 HTTP 헤더 설정 */
        //JSON 형식임을 명시함
        response.setContentType("application/json");

        //HTTP 상태 코드 설정(200, 404, 500 등)
        response.setStatus(status);

        //CrossDomain에 의한 접근 허용
        //(보안에 좋지 않기 때문에 이 옵션을 허용할 경우 인증키 등의 보안 장치가 필요함)
        // 여기서는 실습을 위해 허용함
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        response.setHeader("Access-Control-Allow-Origin", "*");

        /**2) 파라미터로 전달된 Map객체에 status와 timestamp 값을 추가한 새로운 Map 생성하기 */
        //JSON 생성일시를 위한 현재 시각 문자열 만들기 -->JAVA8 이상에서 추가된 기능
        //ex) 2021-05-25T15:00.000
        String timestamp = LocalDateTime.now().toString();

        //JSON 구성을 위한 컬렉션 객체 생성
        Map<String, Object> map = new LinkedHashMap<String, Object>();

        //생성일시 추가
        map.put("timestamp", timestamp);
        map.put("status", status);

        if(status != 200){
            switch(status){
                case 404:
                    map.put("error", "Page Not Found");
                    break;
                case 400:
                    map.put("error", "Bad Request");
                    break;
                case 500:
                    map.put("error", "Server Error");
                    break;
                default:
                    map.put("error", "Unknown Error");
                    break;
            }
        }

        //메시지 추가
        map.put("message", message);

        //data가 전달되었다면 map에 병합한다.
        if(data != null){
            map.putAll(data);
        }

        return map;
    }

    /**
     * JSON 형식으로 결과 메시지를 리턴하기 위한 메서드 오버로드 HTTP 상태코드는 200으로 설정하고, 결과 메시지는 "OK" 라는 값을 설정하여 getJsonData(int statusCode, String status, Map<String, Object>data)를 호출한다.
     * 
     * JSON으로 표현하고자 하는 컬렉션이 있을때 사용하는 가장 일반적인 메서드이다.
     * @param data JSON으로 변환할 데이터 컬렉션
     * @return Map<String, Object>
     */
    public Map<String, Object> sendResult(Map<String, Object> data){
        return this.sendJson(200, "OK", data);
    } 

        /**
     * JSON 형식으로 결과 메시지를 리턴하기 위한 메서드 오버로드 HTTP 상태코드는 200으로 설정하고, 결과 메시지는 "OK" 라는 값을 설정하여 getJsonData(int statusCode, String status, Map<String, Object>data)를 호출한다.
     * 
     * JSON으로 표현하고자 하는 컬렉션이 있을때 사용하는 가장 일반적인 메서드이다.
     * ex) 데이터 입력, 수정, 삭제 등을 수행하고 특별히 조회 결과를 반환하지 않을 경우
     * @return Map<String, Object>
     */
    public Map<String, Object> sendResult(){
        return this.sendJson(200, "OK", null);
    } 

    /**
     * JSON 형식으로 에러 메시지를 리턴한다. HTTP 상태코드는 500으로 설정하고, 결과 메시지는 파라미터로 전달되는 값을 설정하여 JSON 문자열을 리턴한다.
     * @param message - 에러 메시지
     * @return MAP<String, Object>
     */
    public Map<String, Object> serverError(String message){
        return this.sendJson(500, message, null);
    }

    /**
     * JSON 형식으로 에러 메시지를 리턴한다. HTTP 상태코드는 500으로 설정하고, 결과 메시지는 에러 객체에 포함된 메시지 내용을 사용하여 전달한다.
     * @param e - 에러 객체
     * @return MAP<String, Object>
     */
    public Map<String, Object> serverError(Exception e){
        return this.sendJson(500, e.getMessage(), null);
    }    

    /**
     * JSON 형식으로 잘못된 접근에 대한 경고 메시지를 리턴한다. HTTP 상태 코드는 400으로 설정하고, 결과 메시지는 파라미터로 전달되는 값을 설정하여 JSON문자열을 리턴한다.
     * 
     * 파라미터 점검 과정에서 유효성 검증에 통과하지 못한 경우 사용.
     * 
     * @param message - 에러 메시지
     * @return Map<String, Object>
     */
    public Map<String, Object> badRequest(String message){
        return this.sendJson(400, message, null);
    }

    /**
     * JSON 형식으로 잘못된 접근에 대한 경고 메시지를 리턴한다. HTTP 상태 코드는 400으로 설정하고, 결과 메시지는 에러 객체에 포함된 메시지 내용을 사용하여 전달한다.
     * 
     * 파라미터 점검 과정에서 유효성 검증에 통과하지 못한 경우 사용.
     * 
     * @param e - 에러 객체
     * @return Map<String, Object>
     */
    public Map<String, Object> badRequest(Exception e){
        return this.sendJson(400, e.getMessage(), null);
    }
    
}
