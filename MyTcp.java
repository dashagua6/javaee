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
			System.out.println("�����׽����Ѿ������ɹ�");
			while (true) {
				System.out.println("�ȴ��ͻ���������");
				// ʵ����Socket����
				socket = server.accept();
				// ʵ����BufferedReader����
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
				// ��ÿͻ�����Ϣ
				System.out.println("�ͻ�����" + reader.readLine());

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
