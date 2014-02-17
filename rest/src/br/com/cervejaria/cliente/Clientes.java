package br.com.cervejaria.cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Clientes {

	public static void main(String[] args) throws IOException {

		String caminho = "file:///D:/Estudos/JEE/cervejaria/WebContent/resource/clientes.xml";

		URL url = new URL(caminho);
		InputStream inputStream = url.openConnection().getInputStream();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		String linha = null;
		
		while((linha = bufferedReader.readLine()) != null){
			System.out.println(linha);
		}
		
		bufferedReader.close();
		inputStream.close();
	}

}
