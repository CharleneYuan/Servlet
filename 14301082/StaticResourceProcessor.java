/**
 * 
 *2016��10��11��
 *����9:10:31
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
			//��Web�ļ�д�뵽OutputStream�ֽ�����
			response.sendStaticResource();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
