/**
 * 
 *2016年10月11日
 *下午2:36:34
 *Response.java
 *@author Charlene
 */
package server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;

/**
 * Response
 * 
 */
public class Response implements ServletResponse{

	private static final int BUFFER_SIZE = 1024;
	Request request;
	OutputStream output;
	PrintWriter writer;
	
	public Response(OutputStream output){
		this.output = output;
	}
	
	public void setRequest(Request request){
		this.request = request;
	}
	
	//将Web文件写入到OutputStream字节流中
	public void sendStaticResource() throws IOException{
		byte[] bytes = new byte[BUFFER_SIZE];
		FileInputStream fis = null;
		try{
			/* request.getUri has been replaced by request.getRequestURI */
			 File file = new File(Constants.WEB_ROOT,request.getUri());
			 fis = new FileInputStream(file);
			 /*
			 * HTTP Response = Status-Line(( general-header | response-header |
			 * entity-header ) CRLF) CRLF [ message-body ] Status-Line =
			 * HTTP-Version SP Status-Code SP Reason-Phrase CRLF
			 */
			 int ch = fis.read(bytes, 0, BUFFER_SIZE);
			 while (ch != -1) {
				 output.write(bytes, 0, ch);
				 ch = fis.read(bytes, 0, BUFFER_SIZE);
			 }
			} catch (FileNotFoundException e) {
			 String errorMessage = "HTTP/1.1 404 File Not Found\r\n"
					 + "Content-Type: text/html\r\n" + "Content-Length: 23\r\n"
					 + "\r\n" + "<h1>File Not Found</h1>";
			 output.write(errorMessage.getBytes());
		} finally {
			if (fis != null)
			fis.close();
		}
	}
	
	
	/**
	 * ServletResponse
	 * flushBuffer
	 * @throws IOException
	 * @see javax.servlet.ServletResponse#flushBuffer()
	 * 
	 */
	@Override
	public void flushBuffer() throws IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * ServletResponse
	 * getBufferSize
	 * @return
	 * @see javax.servlet.ServletResponse#getBufferSize()
	 * 
	 */
	@Override
	public int getBufferSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * ServletResponse
	 * getCharacterEncoding
	 * @return
	 * @see javax.servlet.ServletResponse#getCharacterEncoding()
	 * 
	 */
	@Override
	public String getCharacterEncoding() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ServletResponse
	 * getContentType
	 * @return
	 * @see javax.servlet.ServletResponse#getContentType()
	 * 
	 */
	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ServletResponse
	 * getLocale
	 * @return
	 * @see javax.servlet.ServletResponse#getLocale()
	 * 
	 */
	@Override
	public Locale getLocale() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ServletResponse
	 * getOutputStream
	 * @return
	 * @throws IOException
	 * @see javax.servlet.ServletResponse#getOutputStream()
	 * 
	 */
	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ServletResponse
	 * getWriter
	 * @return
	 * @throws IOException
	 * @see javax.servlet.ServletResponse#getWriter()
	 * 
	 */
	@Override
	public PrintWriter getWriter() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ServletResponse
	 * isCommitted
	 * @return
	 * @see javax.servlet.ServletResponse#isCommitted()
	 * 
	 */
	@Override
	public boolean isCommitted() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * ServletResponse
	 * reset
	 * @see javax.servlet.ServletResponse#reset()
	 * 
	 */
	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * ServletResponse
	 * resetBuffer
	 * @see javax.servlet.ServletResponse#resetBuffer()
	 * 
	 */
	@Override
	public void resetBuffer() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * ServletResponse
	 * setBufferSize
	 * @param arg0
	 * @see javax.servlet.ServletResponse#setBufferSize(int)
	 * 
	 */
	@Override
	public void setBufferSize(int arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * ServletResponse
	 * setCharacterEncoding
	 * @param arg0
	 * @see javax.servlet.ServletResponse#setCharacterEncoding(java.lang.String)
	 * 
	 */
	@Override
	public void setCharacterEncoding(String arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * ServletResponse
	 * setContentLength
	 * @param arg0
	 * @see javax.servlet.ServletResponse#setContentLength(int)
	 * 
	 */
	@Override
	public void setContentLength(int arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * ServletResponse
	 * setContentLengthLong
	 * @param arg0
	 * @see javax.servlet.ServletResponse#setContentLengthLong(long)
	 * 
	 */
	@Override
	public void setContentLengthLong(long arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * ServletResponse
	 * setContentType
	 * @param arg0
	 * @see javax.servlet.ServletResponse#setContentType(java.lang.String)
	 * 
	 */
	@Override
	public void setContentType(String arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * ServletResponse
	 * setLocale
	 * @param arg0
	 * @see javax.servlet.ServletResponse#setLocale(java.util.Locale)
	 * 
	 */
	@Override
	public void setLocale(Locale arg0) {
		// TODO Auto-generated method stub
		
	}

}
