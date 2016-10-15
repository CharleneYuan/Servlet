/**
 * 
 *2016年10月11日
 *下午2:35:52
 *HTTPServer.java
 *@author Charlene
 */
package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * HTTPServer
 * 
 */
public class HTTPServer {

	private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";
	
	/**
	 * @param args
	 * main
	 * HTTPServer
	 * @return void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HTTPServer server = new HTTPServer();
		server.await();
	}
	
	public void await(){
		ServerSocket serverSocket = null;
		int port = 8080;
		try{
			//服务器套接字对象
			serverSocket = new ServerSocket(port,1,InetAddress.getByName("127.0.0.1"));
		}catch(IOException e){
			e.printStackTrace();
			System.exit(1);
		}
		
		//循环等待请求,如果输入关闭服务指令则停止循环
		while(true){
			Socket socket = null;
			InputStream input = null;
			OutputStream output = null;
			try{
				//获取Socket对象
				socket = serverSocket.accept();
				input = socket.getInputStream();
				output = socket.getOutputStream();
				
				//创建Request并解析
				Request request = new Request(input);
				request.parse();
				
				if(request.getUri().equals(SHUTDOWN_COMMAND)){
					break;
				}
				
				//如果未接收到关闭服务指令则创建Response对象
				Response response = new Response(output);
				response.setRequest(request);
				
				if(request.getUri().startsWith("/PrimitiveServlet")){
					ServeletProcessor processor = new ServeletProcessor();
					processor.process(request, response);
				}else{
					StaticResourceProcessor processor = new StaticResourceProcessor();
					processor.process(request, response);
				}
				
				//关闭socket
				socket.close();
			}catch(Exception e){
				e.printStackTrace();
				System.exit(1);
			}
		}
	}

}
