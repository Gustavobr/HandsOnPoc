package br.com.poc.Util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.fasterxml.jackson.core.JsonFactory;

public class ObjectMapper {
	
	
	 public static String capitalize(String str) {
	        // Check if the string is null or empty
	        if (str == null || str.isEmpty()) {
	            return str; // Return the original string if it's null or empty
	        }

	        // Convert the first character to uppercase and concatenate the rest of the string
	        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
	    }
	 
	 
	 public static void main(String[] args) {
	        String input = "d003163";
	        String capitalized = capitalize(input);
	        System.out.println(capitalized); 
	    }

	

	private com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper(
			JsonFactory.builder().build());

	ObjectMapper objectMapper = new ObjectMapper();
	
	
	
	public void ConvertObjectAsJson(InputStream inputStream, String jsonBody)throws IOException, Exception{
			InputStreamReader reader = new InputStreamReader(inputStream);
			
			String[]arr = jsonBody.split(jsonBody);
			
			if(arr.length >=1) {
				for(int i=0; i<arr.length; i++) {
					byte[] letter = arr[i].getBytes();
				
				}
			}
	}
	
	
	
	
	
	public static String capitalizeFirstLetter(String word)throws StringIndexOutOfBoundsException, Exception{
		if(word != null && !word.isEmpty() == true) {
			String[] arr = word.split(word);
			for(int i = 0; i< arr.length;) {
				String firstLetter  = arr[0];
				firstLetter = firstLetter.toUpperCase();
				arr[0].replace("", firstLetter);
				System.out.println(arr.toString());
				return arr.toString();
				
			}
		}
		return word;
	}
}
