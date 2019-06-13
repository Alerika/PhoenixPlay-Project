package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client
{
	public Client(){}
	
	public String controlloAccesso(String username, String password)
	{
		try {
			Socket socket = new Socket("localhost", 8000);
			OutputStream o = socket.getOutputStream();
			PrintWriter out = new PrintWriter(o);
			out.append(username + System.lineSeparator());
			out.append(password + System.lineSeparator());
			out.flush();
			InputStream istream = socket.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(istream));
			String risultato = in.readLine();
			socket.close();
			return risultato;
		} catch (IOException e) {return e.getMessage();}		
	}
	
	public boolean registrazione(String nome, String cognome, String data, String mail, String username, String password) throws UnknownHostException, IOException
	{
		Socket socket = new Socket("localhost",8000);
		OutputStream o = socket.getOutputStream();
		PrintWriter out = new PrintWriter(o);
		out.append(nome + System.lineSeparator());
		out.append(cognome + System.lineSeparator());
		out.append(data + System.lineSeparator());
		out.append(mail + System.lineSeparator());
		out.append(username + System.lineSeparator());
		out.append(password + System.lineSeparator());
		out.flush();
		InputStream istream = socket.getInputStream();
		BufferedReader in = new BufferedReader(new InputStreamReader(istream));
		String risultato = in.readLine();
		socket.close();
		if(risultato.equals(""))
			return true;
		return false;
	}

	public boolean usernameLibero(String username) throws UnknownHostException, IOException
	{		
		Socket socket = new Socket("localhost", 8000);
		OutputStream o = socket.getOutputStream();
		PrintWriter out = new PrintWriter(o);
		out.append(username + System.lineSeparator());
		out.flush();
		InputStream istream = socket.getInputStream();
		BufferedReader in = new BufferedReader(new InputStreamReader(istream));
		String risultato = in.readLine();
		if(risultato.equals(username))
		{
			socket.close();
			return false;
		}
		socket.close();
		return true;
	}
}
