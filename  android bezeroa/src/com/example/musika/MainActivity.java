package com.example.musika;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import android.os.StrictMode;
import android.widget.Button;
import android.widget.EditText;
public class MainActivity extends Activity {

	private Socket client;
	private PrintWriter printwriter;
	private EditText textField;
	private Button konektaBotoi;
	//private Button bilatuBotoi;
	private Button listaBotoi;
	private Button itxiBotoi;
	public String message="";
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (android.os.Build.VERSION.SDK_INT > 9) { 
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy); 
			}
		textField = (EditText) findViewById(R.id.editText1); // reference to the
		konektaBotoi = (Button) findViewById(R.id.buttonKO);
		// Button press event listener
		konektaBotoi.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {

				message = textField.getText().toString(); // get the text
															// message on the
															// text field
				textField.setText(""); // Reset the text field to blank

				try {

					client = new Socket("zure.zerbitzari.helbidea", 4444); // connect to server
					printwriter = new PrintWriter(client.getOutputStream(),
							true);
					 if(message.compareTo("firefox")==0){
						 printwriter.write(message);
					 }else{
						 printwriter.write("kaixo");
					}
					
					printwriter.flush();
					printwriter.close();
					client.close(); // closing the connection
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
//		bilatuBotoi = (Button) findViewById(R.id.buttonBI);
//		// Button press event listener
//		bilatuBotoi.setOnClickListener(new View.OnClickListener() {
//
//			public void onClick(View v) {
//
//				message = textField.getText().toString(); // get the text
//															// message on the
//															// text field
//				textField.setText(""); // Reset the text field to blank
//
//				try {
//
//					client = new Socket("utolosa.no-ip.biz", 4444); // connect to server
//					printwriter = new PrintWriter(client.getOutputStream(),
//							true);
//				
//					printwriter.flush();
//					printwriter.close();
//					client.close(); // closing the connection
//				} catch (UnknownHostException e) {
//					e.printStackTrace();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		});
		listaBotoi = (Button) findViewById(R.id.buttonLI);
		// Button press event listener
		listaBotoi.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {

				message = textField.getText().toString();
				textField.setText("");
				try {

					client = new Socket("zure.zerbitzari.helbidea", 4444); // connect to server
					printwriter = new PrintWriter(client.getOutputStream(),
							true);
					printwriter.write("getlista");
					printwriter.flush();
					printwriter.close();
					client.close(); // closing the connection
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		itxiBotoi = (Button) findViewById(R.id.buttonEX);
		// Button press event listener
		itxiBotoi.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				
				try {

					client = new Socket("zure.zerbitzari.helbidea", 4444); // connect to server
					printwriter = new PrintWriter(client.getOutputStream(),
							true);
					printwriter.write("exit");
					printwriter.flush();
					printwriter.close();
					client.close(); // closing the connection
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

	}

   
}
