package dataStorage;
import java.util.LinkedList;
import java.util.Queue;


public class dataStorage {
	public static dataStorage sharedInstance = new dataStorage();
	
	public static Queue<String> wordsToIgnore = new LinkedList<String>();
	public static Queue<String> titles = new LinkedList<String>();
	public static Queue<String> results = new LinkedList<String>();
	
	private dataStorage(){
	}
	
	public Queue<String> getWordsToIgnore(){
		return wordsToIgnore;
	}
	
	public boolean addWordToWordsToIgnore(String s){
		return wordsToIgnore.offer(s);
	}
	
	public boolean addTitleToTitles(String s){
		return titles.offer(s);
	}
	
	public void setResults(Queue<String> q){
		results = q;
	}
}
