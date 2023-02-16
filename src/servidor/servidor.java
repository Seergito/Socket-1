package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class servidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int puerto=5500;
		Socket socketcliente=null;
		ServerSocket socketservidor=null;
		
		try {
			socketservidor= new ServerSocket(puerto);
			System.out.println("Servidor abierto, esperando conexión...");
			while(true) {
				
				socketcliente=socketservidor.accept();
				System.out.println("Cliente conectado...");
				
				DataInputStream recibir= new DataInputStream(socketcliente.getInputStream());
				
				
				double num1=recibir.readDouble();
				double num2=recibir.readDouble();
				
				double suma=num1+num2;
				double resta=num1-num2;
				
				
				DataOutputStream enviar=new DataOutputStream(socketcliente.getOutputStream());
				enviar.writeDouble(suma);
				enviar.writeDouble(resta);
				System.out.println();
				System.out.println("Respuesta enviada!");
				System.out.println();
				socketcliente.close();
				System.out.println("Cliente desconectado...");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				socketservidor.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
