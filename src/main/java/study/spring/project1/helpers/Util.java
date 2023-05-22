package study.spring.project1.helpers;
/**
 * 기본적인 공통 기능들을 묶어 놓은 클래스
 * @author user
 *
 */

public class Util {
	
	public int random(int min, int max) {
		int num = (int)((Math.random() * (max - min + 1)) + min);
		return num;
	}

}
