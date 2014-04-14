import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

public class main {
	private static ServerSocket serverSocket;
	private static Socket clientSocket;
	private static InputStreamReader inputStreamReader;
	private static BufferedReader bufferedReader;
	private static String mezua;
	public static void main(String[] args) {
		try {
			serverSocket = new ServerSocket(4444);
			
		} catch (IOException e) {
			System.out.println("Could not listen on port: 4444");
		    JOptionPane.showMessageDialog(null, "Could not listen on port: 4444");
		      
		}
	        mezua = "";
	        JOptionPane.showMessageDialog(null,"Server started. Listening to the port 4444");
		System.out.println("Server started. Listening to the port 4444");
		while (mezua.compareTo("exit") != 0) {
			try {

				clientSocket = serverSocket.accept(); // accept the client connection
				inputStreamReader = new InputStreamReader(
						clientSocket.getInputStream());
				bufferedReader = new BufferedReader(inputStreamReader); // get the client message
				mezua = bufferedReader.readLine();
				if (mezua.compareTo("firefox") == 0) {
					Runtime rt = Runtime.getRuntime();
					@SuppressWarnings("unused")
					Process p = rt.exec(mezua);
				} else if (mezua.compareTo("getlista") == 0) {
					System.out.println("if getlista" + mezua);
				} else if (mezua.compareTo("bilatu") == 0) {
					System.out.println("if bilatu " + mezua);
				} else if (mezua.compareTo("kaixo") == 0) {
					System.out.println("if kaixo " + mezua);
				} else {
				String jaso= JOptionPane.showInputDialog(null,"sakatu edozein tekla hasteko \n");
//					try {
//						System.out.println(message+" kantua iritsi da \n");
//						System.out.println("sakatu edozein tekla hasteko \n");
//				        System.in.read();
//				    } catch (IOException e) {
//				        // TODO Auto-generated catch block
//				        e.printStackTrace();
//				    }
					Runtime rt = Runtime.getRuntime();
					@SuppressWarnings("unused")
					Process p = rt.exec("firefox -new-tab "+mezua);
				}
			} catch (IOException ex) {
				System.out.println("Arazoa mezua irakurtzean");
			}
		}
		if (mezua == "exit") {
			System.out.println("exit");
			try {
				inputStreamReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				clientSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
