package dataStorage;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class dataStorage {
	public static dataStorage sharedInstance = new dataStorage();
	
	public Queue<String> wordsToIgnore = new LinkedList<String>();
	public Queue<String> titles = new LinkedList<String>();
	public List<String> results = new LinkedList<String>();
	
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
	
	public void setResults(List<String> l){
		results = l;
	}
	
	public Queue<String> getTitles(){
		return titles;
	}
	public List<String> getResults(){
		return results;
	}
}
