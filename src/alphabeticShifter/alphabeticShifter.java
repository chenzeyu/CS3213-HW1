package alphabeticShifter;
import java.util.*;

import dataStorage.dataStorage;
import performableInterface.performable;

public class alphabeticShifter implements performable{
	private dataStorage store;
	
	public alphabeticShifter(){
		store = dataStorage.sharedInstance;
	}
	
	@Override
	public boolean performTask() {
		// TODO Auto-generated method stub
		Collections.sort(store.results, ALPHABETICAL_ORDER);
		return true;
	}
	
	private static Comparator<String> ALPHABETICAL_ORDER = new Comparator<String>() {
	    public int compare(String str1, String str2) {
	        int res = String.CASE_INSENSITIVE_ORDER.compare(str1, str2);
	        if (res == 0) {
	            res = str1.compareTo(str2);
	        }
	        return res;
	    }
	};
	

}
