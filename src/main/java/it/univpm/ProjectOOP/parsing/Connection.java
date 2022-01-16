package it.univpm.ProjectOOP.parsing;

import java.io.BufferedReader;
import java.io.InputStream;
import java.net.URLConnection;
import org.json.simple.JSONObject;

/**
 * Classe contenente gli attributi necessari per il parsing
 * 
 * @author Merelli Leonardo
 */
public abstract class Connection {

	private String url = "https://app.ticketmaster.com/discovery/v2/events.json?countryCode=MX&sort=date,asc&size=199&apikey=";
	private String apiKey = "BeSiVKjOMpzq5H2aKcJ2aafJVfDBuaEY";
	protected String data = "";
	
	//per prendere più eventi possibili: max = 5 
	final int max = 1;
	private int page = 0;
	
	private JSONObject obj;
	private BufferedReader bufferedScanner;
	private InputStream input;
	private URLConnection openConnection;

	
	public JSONObject getObj() {
		return obj;
	}

	public void setObj(JSONObject obj) {
		this.obj = obj;
	}

	public BufferedReader getBufferedScanner() {
		return bufferedScanner;
	}

	public void setBufferedScanner(BufferedReader bufferedScanner) {
		this.bufferedScanner = bufferedScanner;
	}

	public InputStream getInput() {
		return input;
	}

	public void setInput(InputStream input) {
		this.input = input;
	}

	public URLConnection getOpenConnection() {
		return openConnection;
	}

	public void setOpenConnection(URLConnection openConnection) {
		this.openConnection = openConnection;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getMax() {
		return max;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
}
