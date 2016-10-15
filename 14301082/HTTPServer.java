/**
 * 
 *2016��10��11��
 *����2:35:52
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
			//�������׽��ֶ���
			serverSocket = new ServerSocket(port,1,InetAddress.getByName("127.0.0.1"));
		}catch(IOException e){
			e.printStackTrace();
			System.exit(1);
		}
		
		//ѭ���ȴ�����,�������رշ���ָ����ֹͣѭ��
		while(true){
			Socket socket = null;
			InputStream input = null;
			OutputStream output = null;
			try{
				//��ȡSocket����
				socket = serverSocket.accept();
				input = socket.getInputStream();
				output = socket.getOutputStream();
				
				//����Request������
				Request request = new Request(input);
				request.parse();
				
				if(request.getUri().equals(SHUTDOWN_COMMAND)){
					break;
				}
				
				//���δ���յ��رշ���ָ���򴴽�Response����
				Response response = new Response(output);
				response.setRequest(request);
				
				if(request.getUri().startsWith("/PrimitiveServlet")){
					ServeletProcessor processor = new ServeletProcessor();
					processor.process(request, response);
				}else{
					StaticResourceProcessor processor = new StaticResourceProcessor();
					processor.process(request, response);
				}
				
				//�ر�socket
				socket.close();
			}catch(Exception e){
				e.printStackTrace();
				System.exit(1);
			}
		}
	}

}
