/**
 * 
 *2016年10月11日
 *下午2:37:11
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
			//生产servlet实例
			servlet = new PrimitiveServlet();
			//执行servlet的service方法
			servlet.service((ServletRequest)request, (ServletResponse)response);
		}catch(Exception e){
			System.out.println(e.toString());
		}catch(Throwable e){
			System.out.println(e.toString());
		}
	}
}
