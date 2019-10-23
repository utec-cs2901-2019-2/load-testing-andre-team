package calculator.business;

import calculator.entities.Language;

import java.io.*;
import java.net.*;
import java.util.*;


public class TranslatorImpl implements Translator {
	
    private static Map<String, String> learntWords = new HashMap<String, String>();
    private String transURL = "https://script.google.com/macros/s/AKfycbwoewR66GN4nBRmwKUzAz7dlyOZ2MIN9T5pAsUk56puPV7P0xJa/exec?q=";

    @Override
    public String translate(Language from, Language to, String text) throws IOException {
        if (learntWords.containsKey(text)){
			return learntWords.get(text);
		}

		String requestURL = transURL + URLEncoder.encode(text, "UTF-8") +
					"&target=" + to.getId().toLowerCase() +
					"&source=" + from.getId().toLowerCase();

		URL url = new URL(requestURL);


		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		connection.setRequestProperty("User","Mozilla/5.0");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		
		String inputln;
		StringBuilder response = new StringBuilder();

		while ((inputln = in.readLine()) != null) {
			response.append(inputln);
		}

		in.close();

		String translation = response.toString();
		learntWords.put(text,translation);

		return translation;
    }
}
