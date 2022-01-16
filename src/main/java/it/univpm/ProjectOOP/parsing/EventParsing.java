package it.univpm.ProjectOOP.parsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Vector;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import it.univpm.ProjectOOP.model.Event;
import it.univpm.ProjectOOP.projectTool.Tool;


/**
 * Classe effettuante il parsing degli eventi
 * 
 * @author Merelli Leonardo
 * @see Connection
 */

@Service
public class EventParsing extends Connection 
{
	private List<Event> eventList;

	/**
	 * Metodo setter che effettua il parsing degli eventi:
	 * apre la connessione con la API,
	 * effettua lo scan e genera una lista di eventi
	 */
	public void setEventList() throws ParseException, MalformedURLException, IOException {

		Tool converter = new Tool();
		List<Event> eventList = new Vector<>();

		try {
			do {
				setOpenConnection(new URL(getUrl() + getApiKey() + "&page=" + getPage()).openConnection());
				setInput(getOpenConnection().getInputStream());
				setBufferedScanner(new BufferedReader(new InputStreamReader(getInput())));

				while ((data = getBufferedScanner().readLine()) != null) {
					setObj((JSONObject) JSONValue.parseWithException(data));
					JSONObject embedded1 = (JSONObject) getObj().get("_embedded");
					JSONArray events = (JSONArray) embedded1.get("events");

					for (Object e : events) {
						JSONObject objectE = (JSONObject) e;
						Event event = new Event();
						event.setName(String.valueOf(objectE.get("name")));
						JSONObject dates = (JSONObject) objectE.get("dates");
						JSONObject start = (JSONObject) dates.get("start");
						event.setLocalDate(converter.converterDate(String.valueOf(start.get("localDate")))); 
						event.setLocalTime(String.valueOf(start.get("localTime")));
						JSONArray classifications = (JSONArray) objectE.get("classifications");

						for (Object c : classifications) {
							JSONObject objectC = (JSONObject) c;
							JSONObject genre = (JSONObject) objectC.get("genre");
							event.setGenre(String.valueOf(genre.get("name")));
						}
						JSONObject embedded2 = (JSONObject) objectE.get("_embedded");
						JSONArray venues = (JSONArray) embedded2.get("venues");
						
						for (Object v : venues) {
							JSONObject objectV = (JSONObject) v;
							JSONObject state = (JSONObject) objectV.get("state");
							event.setState(String.valueOf(state.get("name")));
						}
						eventList.add(event);
					}
				}
				setPage(getPage() + 1);
				getBufferedScanner().close();

			} while (getPage() < max);
		} catch (MalformedURLException m) {
			System.out.println("Eccezione MalformedURLException");
		} catch (IOException i) {
			System.out.println("Eccezione IOException");
		}
		setPage(0);
		this.eventList = eventList;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public List<Event> getEventList() {
		return eventList;
	}
}
