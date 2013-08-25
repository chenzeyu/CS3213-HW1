package inputGetter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import performableInterface.performable;
import dataStorage.dataStorage;
public class inputGetter implements performable{

	dataStorage store = dataStorage.sharedInstance;

	private static Queue<String> getWordsToIgnore() throws IOException
	{
		Queue<String> wordsToIgnore = new LinkedList<String>();
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("please enter the words to ignore, e.g. is the a.");
			String s = in.readLine();
			String[] wti = s.split(" ");
			for(int i=0; i<wti.length; i++){
				wordsToIgnore.offer(wti[i].toUpperCase());
			}
		} catch (IOException e) {
			// handle this
			e.printStackTrace();
		}
		//in.close();
		return wordsToIgnore;
	}


	private static Queue<String> getTitles() throws IOException{

		Queue<String> titles = new LinkedList<String>();

		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("please enter the titles, end with '!'.");
			String s;
			while(!(s = in.readLine()).equals("!")){
				titles.offer(s);
			}
		} catch (IOException e) {
			// handle this
			e.printStackTrace();
		}
		in.close();
		return titles;
	}

	@Override
	public boolean performTask() throws IOException {
		Queue<String>wordsToIgnore = getWordsToIgnore();
		Queue<String>titles = getTitles();
		store.titles = titles;
		store.wordsToIgnore = wordsToIgnore;
		// TODO Auto-generated method stub
		return true;
	}

}
