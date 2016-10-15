/**
 * 
 *2016��10��11��
 *����2:37:11
 *ServeletProcessor.java
 *@author Charlene
 */
package server;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;
import java.util.ArrayList;

import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * ServeletProcessor
 * 
 */
public class ServeletProcessor {
	
	public void process(Request request,Response response){
		String uri = request.getUri();
		String servletName = uri.substring(uri.lastIndexOf("/")+1);
		
		PrimitiveServlet servlet = null;
		try{
			//����servletʵ��
			servlet = new PrimitiveServlet();
			//ִ��servlet��service����
			servlet.service((ServletRequest)request, (ServletResponse)response);
		}catch(Exception e){
			System.out.println(e.toString());
		}catch(Throwable e){
			System.out.println(e.toString());
		}
	}
}
