/**
 * 
 *2016年10月11日
 *下午2:36:15
 *Request.java
 *@author Charlene
 */
package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Request
 * 
 */
public class Request implements ServletRequest{

	private InputStream input;
	private String uri;
	private static final int BUFFER_SIZE = 2048;
	
	public Request(InputStream input){
		this.input = input;
	}
	
	public String getUri(){
		return uri;
	}
	
	//解析请求字符串
	//requestString 格式为：
	//Get /index.html HTTP/1.1...
	public String parseUri(String requestString){
		int index1,index2;
		index1 = requestString.indexOf(' ');
		if(index1 != -1){
			index2 = requestString.indexOf(' ',index1+1);
			if(index2>index1){
				//获取/index.html部分，从第一个空格到第二各空格截止
				return requestString.substring(index1+1,index2);
				}
		}
		return null;	
	}
		
	
	public void parse(){
		StringBuffer request = new StringBuffer(BUFFER_SIZE);
		int i;
		byte[] buffer = new byte[BUFFER_SIZE];
		try{
			i = input.read(buffer);
		}catch(IOException e){
			e.printStackTrace();
			i = -1;
		}
		
		//读取input之后转换字符串
		for(int j = 0;j<i;j++){
			request.append((char) buffer[j]);
		}
		System.out.print(request.toString());
		uri = parseUri(request.toString());
	}

	
	/**
	 * ServletRequest
	 * getAsyncContext
	 * @return
	 * @see javax.servlet.ServletRequest#getAsyncContext()
	 * 
	 */
	@Override
	public AsyncContext getAsyncContext() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ServletRequest
	 * getAttribute
	 * @param arg0
	 * @return
	 * @see javax.servlet.ServletRequest#getAttribute(java.lang.String)
	 * 
	 */
	@Override
	public Object getAttribute(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ServletRequest
	 * getAttributeNames
	 * @return
	 * @see javax.servlet.ServletRequest#getAttributeNames()
	 * 
	 */
	@Override
	public Enumeration<String> getAttributeNames() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ServletRequest
	 * getCharacterEncoding
	 * @return
	 * @see javax.servlet.ServletRequest#getCharacterEncoding()
	 * 
	 */
	@Override
	public String getCharacterEncoding() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ServletRequest
	 * getContentLength
	 * @return
	 * @see javax.servlet.ServletRequest#getContentLength()
	 * 
	 */
	@Override
	public int getContentLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * ServletRequest
	 * getContentLengthLong
	 * @return
	 * @see javax.servlet.ServletRequest#getContentLengthLong()
	 * 
	 */
	@Override
	public long getContentLengthLong() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * ServletRequest
	 * getContentType
	 * @return
	 * @see javax.servlet.ServletRequest#getContentType()
	 * 
	 */
	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ServletRequest
	 * getDispatcherType
	 * @return
	 * @see javax.servlet.ServletRequest#getDispatcherType()
	 * 
	 */
	@Override
	public DispatcherType getDispatcherType() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ServletRequest
	 * getInputStream
	 * @return
	 * @throws IOException
	 * @see javax.servlet.ServletRequest#getInputStream()
	 * 
	 */
	@Override
	public ServletInputStream getInputStream() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ServletRequest
	 * getLocalAddr
	 * @return
	 * @see javax.servlet.ServletRequest#getLocalAddr()
	 * 
	 */
	@Override
	public String getLocalAddr() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ServletRequest
	 * getLocalName
	 * @return
	 * @see javax.servlet.ServletRequest#getLocalName()
	 * 
	 */
	@Override
	public String getLocalName() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ServletRequest
	 * getLocalPort
	 * @return
	 * @see javax.servlet.ServletRequest#getLocalPort()
	 * 
	 */
	@Override
	public int getLocalPort() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * ServletRequest
	 * getLocale
	 * @return
	 * @see javax.servlet.ServletRequest#getLocale()
	 * 
	 */
	@Override
	public Locale getLocale() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ServletRequest
	 * getLocales
	 * @return
	 * @see javax.servlet.ServletRequest#getLocales()
	 * 
	 */
	@Override
	public Enumeration<Locale> getLocales() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ServletRequest
	 * getParameter
	 * @param arg0
	 * @return
	 * @see javax.servlet.ServletRequest#getParameter(java.lang.String)
	 * 
	 */
	@Override
	public String getParameter(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ServletRequest
	 * getParameterMap
	 * @return
	 * @see javax.servlet.ServletRequest#getParameterMap()
	 * 
	 */
	@Override
	public Map<String, String[]> getParameterMap() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ServletRequest
	 * getParameterNames
	 * @return
	 * @see javax.servlet.ServletRequest#getParameterNames()
	 * 
	 */
	@Override
	public Enumeration<String> getParameterNames() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ServletRequest
	 * getParameterValues
	 * @param arg0
	 * @return
	 * @see javax.servlet.ServletRequest#getParameterValues(java.lang.String)
	 * 
	 */
	@Override
	public String[] getParameterValues(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ServletRequest
	 * getProtocol
	 * @return
	 * @see javax.servlet.ServletRequest#getProtocol()
	 * 
	 */
	@Override
	public String getProtocol() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ServletRequest
	 * getReader
	 * @return
	 * @throws IOException
	 * @see javax.servlet.ServletRequest#getReader()
	 * 
	 */
	@Override
	public BufferedReader getReader() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ServletRequest
	 * getRealPath
	 * @param arg0
	 * @return
	 * @deprecated
	 * @see javax.servlet.ServletRequest#getRealPath(java.lang.String)
	 * 
	 */
	@Override
	public String getRealPath(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ServletRequest
	 * getRemoteAddr
	 * @return
	 * @see javax.servlet.ServletRequest#getRemoteAddr()
	 * 
	 */
	@Override
	public String getRemoteAddr() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ServletRequest
	 * getRemoteHost
	 * @return
	 * @see javax.servlet.ServletRequest#getRemoteHost()
	 * 
	 */
	@Override
	public String getRemoteHost() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ServletRequest
	 * getRemotePort
	 * @return
	 * @see javax.servlet.ServletRequest#getRemotePort()
	 * 
	 */
	@Override
	public int getRemotePort() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * ServletRequest
	 * getRequestDispatcher
	 * @param arg0
	 * @return
	 * @see javax.servlet.ServletRequest#getRequestDispatcher(java.lang.String)
	 * 
	 */
	@Override
	public RequestDispatcher getRequestDispatcher(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ServletRequest
	 * getScheme
	 * @return
	 * @see javax.servlet.ServletRequest#getScheme()
	 * 
	 */
	@Override
	public String getScheme() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ServletRequest
	 * getServerName
	 * @return
	 * @see javax.servlet.ServletRequest#getServerName()
	 * 
	 */
	@Override
	public String getServerName() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ServletRequest
	 * getServerPort
	 * @return
	 * @see javax.servlet.ServletRequest#getServerPort()
	 * 
	 */
	@Override
	public int getServerPort() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * ServletRequest
	 * getServletContext
	 * @return
	 * @see javax.servlet.ServletRequest#getServletContext()
	 * 
	 */
	@Override
	public ServletContext getServletContext() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ServletRequest
	 * isAsyncStarted
	 * @return
	 * @see javax.servlet.ServletRequest#isAsyncStarted()
	 * 
	 */
	@Override
	public boolean isAsyncStarted() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * ServletRequest
	 * isAsyncSupported
	 * @return
	 * @see javax.servlet.ServletRequest#isAsyncSupported()
	 * 
	 */
	@Override
	public boolean isAsyncSupported() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * ServletRequest
	 * isSecure
	 * @return
	 * @see javax.servlet.ServletRequest#isSecure()
	 * 
	 */
	@Override
	public boolean isSecure() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * ServletRequest
	 * removeAttribute
	 * @param arg0
	 * @see javax.servlet.ServletRequest#removeAttribute(java.lang.String)
	 * 
	 */
	@Override
	public void removeAttribute(String arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * ServletRequest
	 * setAttribute
	 * @param arg0
	 * @param arg1
	 * @see javax.servlet.ServletRequest#setAttribute(java.lang.String, java.lang.Object)
	 * 
	 */
	@Override
	public void setAttribute(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * ServletRequest
	 * setCharacterEncoding
	 * @param arg0
	 * @throws UnsupportedEncodingException
	 * @see javax.servlet.ServletRequest#setCharacterEncoding(java.lang.String)
	 * 
	 */
	@Override
	public void setCharacterEncoding(String arg0)
			throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * ServletRequest
	 * startAsync
	 * @return
	 * @throws IllegalStateException
	 * @see javax.servlet.ServletRequest#startAsync()
	 * 
	 */
	@Override
	public AsyncContext startAsync() throws IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ServletRequest
	 * startAsync
	 * @param arg0
	 * @param arg1
	 * @return
	 * @throws IllegalStateException
	 * @see javax.servlet.ServletRequest#startAsync(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
	 * 
	 */
	@Override
	public AsyncContext startAsync(ServletRequest arg0, ServletResponse arg1)
			throws IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

}
