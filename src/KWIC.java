import java.util.*;

public class KWIC {
	public static void main(String[] args){
		
		Queue<String> wordsToIgnore = new LinkedList<String>();
		Queue<String> title = new LinkedList<String>();
		wordsToIgnore.offer("IS");
		wordsToIgnore.offer("THE");
		wordsToIgnore.offer("OF");
		wordsToIgnore.offer("AND");
		wordsToIgnore.offer("AS");
		wordsToIgnore.offer("A");
		wordsToIgnore.offer("AFTER");
		//System.out.println(queueToString(wordsToIgnore));
		title.offer("The Day after Tomorrow");
		title.offer("Fast and Furious");
		title.offer("Man of Steel");
		List<String> result = goKWIC(wordsToIgnore, title);
		Collections.sort(result, ALPHABETICAL_ORDER);
		
		int iterationTime = result.size();
		for(int i=0; i<iterationTime;i++)
			System.out.println(result.get(i));
	}
	
	
	public static List<String> goKWIC(Queue<String> WTI, Queue<String> T){
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
	
	private static Comparator<String> ALPHABETICAL_ORDER = new Comparator<String>() {
	    public int compare(String str1, String str2) {
	        int res = String.CASE_INSENSITIVE_ORDER.compare(str1, str2);
	        if (res == 0) {
	            res = str1.compareTo(str2);
	        }
	        return res;
	    }
	};

	
	
	public static String queueToString(Queue<String> temp){
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
				result = result + first + " ";
				list.offer(first);
			}
			return result.substring(0,result.length()-1);
			// get rid of the extra space
		}
	}
}
