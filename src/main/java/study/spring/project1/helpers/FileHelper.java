package study.spring.project1.helpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class FileHelper {
	
	public void write(String filePath, byte[] data) throws Exception {
		OutputStream os = null;
		
		try {
			//저장할 파일 스트림 생성
			os = new FileOutputStream(filePath);
			//파일 쓰기
			os.write(data);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(os != null) {
				try {
					os.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}//end if
		}//try ~ catch ~ finally
	}
	
	public byte[] read(String filePath) throws Exception {
		byte[] data = null;
		
		InputStream is = null;
		try {
			is = new FileInputStream(filePath);
			data = new byte[is.available()];
			is.read(data);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(is != null) {
				try {
					is.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}//end if
		}//try ~ catch ~ finally
		return data;
	}
	
	public void writeString(String filePath, String content) throws Exception {
		try {
			this.write(filePath, content.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public String readString(String filePath) throws Exception {
		String content = null;
		
		byte[] data;
		try {
			data = read(filePath);
			content = new String(data, "utf-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		return content;
		
	}

}
