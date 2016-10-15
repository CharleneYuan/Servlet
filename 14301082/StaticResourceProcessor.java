/**
 * 
 *2016年10月11日
 *下午9:10:31
 *StaticResourceProcessor.java
 *@author Charlene
 */
package server;

import java.io.IOException;

/**
 * StaticResourceProcessor
 * 
 */
public class StaticResourceProcessor {
	public void process(Request request,Response response){
		try{
			//将Web文件写入到OutputStream字节流中
			response.sendStaticResource();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
