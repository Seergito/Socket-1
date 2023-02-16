package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class cliente {

	public static void main(String[] args) {
		
		Scanner entrada=new Scanner(System.in);
		int puerto=5500;
		String ipServidor="localhost";
		Socket socketcliente=null;
		
		try {
			
			boolean fin=false;
			
			while(fin!=true) {
				
				socketcliente=new Socket(ipServidor,puerto);
				System.out.println("CONECTADO AL SERVIDOR");
				
				DataInputStream recibir= new DataInputStream(socketcliente.getInputStream());
				DataOutputStream enviar=new DataOutputStream(socketcliente.getOutputStream());
				
				System.out.println("Indicame un número, 0 para terminar");
				double num=entrada.nextDouble();entrada.nextLine();
				if(num==0) fin=true; 
				System.out.println("Indicame otro numero");
				double num2=entrada.nextDouble();entrada.nextLine();
				
				enviar.writeDouble(num);enviar.writeDouble(num2);
				
				System.out.println("Suma: "+recibir.readDouble());
				System.out.println("Resta: "+recibir.readDouble());
				System.out.println();
				
				System.out.println();
				
				socketcliente.close();
				System.out.println("Desconectado");
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				socketcliente.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			entrada.close();
		}
		
		
	}
	
}
