import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MyTcp {
	private Socket socket;
	private ServerSocket server;
	private BufferedReader reader;

	void getserver() {
		try {
			server = new ServerSocket(8998);
			System.out.println("服务套接字已经创建成功");
			while (true) {
				System.out.println("等待客户机的连接");
				// 实例化Socket对象
				socket = server.accept();
				// 实例化BufferedReader对象
				reader = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));
				getClientMessage();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getClientMessage() {
		while (true) {
			try {
				// 获得客户端信息
				System.out.println("客户机：" + reader.readLine());

			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (reader == null) {
					reader.close();
				}
				if (socket == null) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		MyTcp myTcp = new MyTcp();
		myTcp.getserver();
	}
}
