package study.spring.project1.helpers;

import java.util.regex.Pattern;
import org.springframework.stereotype.Component;
import study.spring.project1.exceptions.StringFormatException;

@Component
public class RegexHelper {
    /**
     * 주어진 문자열이 공백이거나 null 인지를 검사
     * 
     * @param str     - 검사할 문자열
     * @param message - 조건을 충족하지 않은 경우 표시할 에러 메시지
     * @throws StringFormatException
     */
    public void isValue(String str, String message) throws StringFormatException {
        if (str == null || str.trim().equals("")) {
            throw new StringFormatException(message);
        }
    }

    /**
     * 주어진 숫자가 0인지를 검사
     * 
     * @param str     - 검사할 문자열
     * @param message - 조건을 충족하지 않은 경우 표시할 에러 메시지
     * @throws StringFormatException
     */
    public void isZero(int num, String message) throws StringFormatException {
        if (num == 0) {
            throw new StringFormatException(message);
        }
    }

    /**
     * 주어진 숫자가 지정된 값보다 작은지를 검사
     * 
     * @param str     - 검사할 문자열
     * @param message - 조건을 충족하지 않은 경우 표시할 에러 메시지
     * @throws StringFormatException
     */
    public void isUnder(int num, int min, String message) throws StringFormatException {
        if (num < min) {
            throw new StringFormatException(message);
        }
    }

    /**
     * 주어진 숫자가 지정된 값보다 큰지를 검사
     * 
     * @param str     - 검사할 문자열
     * @param message - 조건을 충족하지 않은 경우 표시할 에러 메시지
     * @throws StringFormatException
     */
    public void isOver(int num, int max, String message) throws StringFormatException {
        if (num > max) {
            throw new StringFormatException(message);
        }
    }

    /**
     * 숫자 모양에 대한 형식 검사
     * 
     * @param str     - 검사할 문자열
     * @param message - 조건을 충족하지 않은 경우 표시할 에러 메시지
     * @throws StringFormatException
     */
    public void isNum(String str, String message) throws StringFormatException {
        if (!Pattern.matches("^[0-9]*$", str)) {
            throw new StringFormatException(message);
        }
    }

    /**
     * 영문으로만 구성되었는지에 대한 형식 검사
     * 
     * @param str     - 검사할 문자열
     * @param message - 조건을 충족하지 않은 경우 표시할 에러 메시지
     * @throws StringFormatException
     */
    public void isEng(String str, String message) throws StringFormatException {
        if (!Pattern.matches("^[a-zA-Z]*$", str)) {
            throw new StringFormatException(message);
        }
    }

    /**
     * 한글로만 구성되었는지에 대한 형식 검사
     * 
     * @param str     - 검사할 문자열
     * @param message - 조건을 충족하지 않은 경우 표시할 에러 메시지
     * @throws StringFormatException
     */
    public void isKor(String str, String message) throws StringFormatException {
        if (!Pattern.matches("^[ㄱ-ㅎ가-힣]*$", str)) {
            throw new StringFormatException(message);
        }
    }

    /**
     * 영문과 숫자로만 구성되었는지에 대한 형식 검사
     * 
     * @param str     - 검사할 문자열
     * @param message - 조건을 충족하지 않은 경우 표시할 에러 메시지
     * @throws StringFormatException
     */
    public void isEngNum(String str, String message) throws StringFormatException {
        if (!Pattern.matches("^[a-zA-Z0-9]*$", str)) {
            throw new StringFormatException(message);
        }
    }

    /**
     * 한글과 숫자로만 구성되었는지에 대한 형식 검사
     * 
     * @param str     - 검사할 문자열
     * @param message - 조건을 충족하지 않은 경우 표시할 에러 메시지
     * @throws StringFormatException
     */
    public void isKorNum(String str, String message) throws StringFormatException {
        if (!Pattern.matches("^[ㄱ-ㅎ가-힣0-9]*$", str)) {
            throw new StringFormatException(message);
        }
    }

    /**
     * 이메일 형식인지에 대한 검사.
     * 
     * @param str     - 검사할 문자열
     * @param message - 조건을 충족하지 않은 경우 표시할 에러 메시지
     * @throws StringFormatException
     */
    public void isEmail(String str, String message) throws StringFormatException {
        if (!Pattern.matches("[0-9a-zA-Z]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$", str)) {
            throw new StringFormatException(message);
        }
    }

    /**
     * "-"없이 핸드폰 번호 형식인지에 대한 검사.
     * 
     * @param str     - 검사할 문자열
     * @param message - 조건을 충족하지 않은 경우 표시할 에러 메시지
     * @throws StringFormatException
     */
    public void isCellPhone(String str, String message) throws StringFormatException {
        if (!Pattern.matches("^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$", str)) {
            throw new StringFormatException(message);
        }
    }

    /**
     * "-"없이 집전화번호인지에 형식인지에 대한 검사.
     * 
     * @param str     - 검사할 문자열
     * @param message - 조건을 충족하지 않은 경우 표시할 에러 메시지
     * @throws StringFormatException
     */
    public void isTel(String str, String message) throws StringFormatException {
        if (!Pattern.matches("^\\d{2,3}\\d{3,4}\\d{4}$", str)) {
            throw new StringFormatException(message);
        }
    }

    /**
     * "-"없이 집전화번호 혹은 핸드폰 번호 둘 중 하나를 충족하는지 검사
     * 
     * @param str     - 검사할 문자열
     * @param message - 조건을 충족하지 않은 경우 표시할 에러 메시지
     * @throws StringFormatException
     */
    public void isPhone(String str, String message) throws StringFormatException {
        boolean cellPhone = Pattern.matches("^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$", str);
        boolean telPhone = Pattern.matches("^\\d{2,3}\\d{3,4}\\d{4}$", str);

        if (!cellPhone && !telPhone) {
            throw new StringFormatException(message);
        }
    }

}
