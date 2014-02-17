package br.com.cervejaria.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/clientes", loadOnStartup = 1)
public class ClientesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String clientes;
	//private String caminho = "file:///D:/Estudos/JEE/cervejaria/WebContent/resource/clientes.xml";

	public ClientesServlet() {
	}

	public void init(ServletConfig config) throws ServletException {
		try {
			/*BufferedReader br = new BufferedReader(new InputStreamReader(
					ClientesServlet.class.getResourceAsStream(caminho)));*/
			String caminho = "file:///D:/Estudos/JEE/cervejaria/WebContent/resource/clientes.xml";

			URL url = new URL(caminho);
			InputStream inputStream = url.openConnection().getInputStream();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			
			String linha = null;
			StringBuilder builder = new StringBuilder();
			while ((linha = bufferedReader.readLine()) != null ) {
				builder.append(linha);
				builder.append("\n");
			}

			clientes = builder.toString();
		} catch (IOException e) {
			throw new ServletException(e);
		}
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print(clientes);
	}

}
