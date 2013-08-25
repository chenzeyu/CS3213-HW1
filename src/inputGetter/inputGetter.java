package inputGetter;

import java.util.*;
import performableInterface.performable;
import dataStorage.dataStorage;
public class inputGetter implements performable{
		
	dataStorage store = dataStorage.sharedInstance;
	
	   private static Queue<String> getWordsToIgnore()
	   {
	      
	      Scanner in = new Scanner(System.in);
	      Queue<String> wordsToIgnore = new LinkedList<String>();
	      System.out.println("Please enter words to ignore, e.g. is the of and");
	      String s = in.nextLine();
	      String[] wti = s.split(" ");
	      for(int i=0; i<wti.length; i++){
	    	  wordsToIgnore.offer(wti[i].toUpperCase());
	      }
	      in.close();
	      return wordsToIgnore;
	   }
	   
	   private static Queue<String> getTitles(){
		   Scanner in = new Scanner(System.in);
		   Queue<String> titles = new LinkedList<String>();
		   System.out.println("Please enter titles, press ! to end.");
	
		   while(in.hasNextLine()){
			   String s = in.nextLine();
			   if(s.equals("!")) break;
			   else titles.offer(s);
		   }
		   in.close();
		   return titles;
	   }

	@Override
	public boolean performTask() {
		Queue<String>wordsToIgnore = getWordsToIgnore();
		Queue<String>titles = getTitles();
		store.titles = titles;
		store.wordsToIgnore = wordsToIgnore;
		// TODO Auto-generated method stub
		return true;
	}
	   
}
