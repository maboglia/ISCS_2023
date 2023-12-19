package com.boglia.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.boglia.model.Prodotto;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;


public class ProdottiService {

	public static List<Prodotto> getProdotti() {
		
		HttpURLConnection connection;
		StringBuilder sb = new StringBuilder(); 
		BufferedReader reader;
		String riga;
		try {
			URL url = new URL("https://fakestoreapi.com/products" );
			connection = (HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(3000);
			connection.setReadTimeout(3000);
			int status = connection.getResponseCode();
			
			System.out.println(status);
			
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			while ((riga = reader.readLine()) != null) {
				sb.append(riga);
			}
			reader.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(sb.toString());
		
		Gson gson = new Gson();
		
		Type listType = new TypeToken<List<Prodotto>>(){}.getType();
		List<Prodotto> p = gson.fromJson(sb.toString(), listType);

		return p;
	}
	
	public static Prodotto getProdotto(int id) {
		
		HttpURLConnection connection;
		StringBuilder sb = new StringBuilder(); 
		BufferedReader reader;
		String riga;
		try {
			URL url = new URL("https://fakestoreapi.com/products/" + id);
			connection = (HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(3000);
			connection.setReadTimeout(3000);
			int status = connection.getResponseCode();
			
			System.out.println(status);
			
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			while ((riga = reader.readLine()) != null) {
				sb.append(riga);
			}
			reader.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(sb.toString());
		
		Gson gson = new Gson();
		Prodotto p = gson.fromJson(sb.toString(), Prodotto.class);

		
		
		return p;	
	 }
	
}
