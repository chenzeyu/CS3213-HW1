package circularShifter;
import performableInterface.performable;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import dataStorage.dataStorage;

public class circularShifter implements performable{

	dataStorage store;
	
	public circularShifter(){
		store = dataStorage.sharedInstance;
	}
	
	private static List<String> goKWIC(Queue<String> WTI, Queue<String> T){
		List<String> result = new LinkedList<String>();
		int noOfTitles = T.size();
		for(int i=0; i<noOfTitles;i++){
			String tempTitle = T.poll();
			String list[] = tempTitle.split(" ");
			Queue<String> temp = new LinkedList<String>();
			for(int j=0; j<list.length; j++)
				temp.offer(list[j]);
			//Now temp is the title we want to deal with, to circular shift, we need shift times of its length
			int iterationTime = temp.size();
			for(int k=0; k<iterationTime;k++){
				String first = temp.peek();
				//System.out.println("---" + first);
				if(!WTI.contains(first.toUpperCase())){
					result.add(queueToString(temp));
				}	
				temp.poll();
				temp.offer(first);				
			}
		}	
		return result;
	}
	
	private static String queueToString(Queue<String> temp){
		Queue<String> list = new LinkedList<String>(temp);
		if(list.size() == 1)
			return list.peek();
		else if(list.size() == 0)
			return "";
		else{
			String result = "";
			int iterationTime = list.size();
			for(int i=0; i<iterationTime;i++){
				String first = list.poll();
				if(i == 0)
					result = result + first.toUpperCase() + " ";
				else
					result = result + first+ " ";
				list.offer(first);
			}
			return result.substring(0,result.length()-1);
			// get rid of the extra space
		}
	}

	@Override
	public boolean performTask() {
		
		List<String> shiftedResult = goKWIC(store.getWordsToIgnore(), store.getTitles());
		store.results = shiftedResult;
		// TODO Auto-generated method stub
		return true;
	}
	
}
