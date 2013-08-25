package outputPrinter;
import dataStorage.dataStorage;
import performableInterface.performable;
public class outputPrinter implements performable{

	dataStorage store;
	
	public outputPrinter (){
		store = dataStorage.sharedInstance;
	}
	
	@Override
	public boolean performTask() {
		// TODO Auto-generated method stub
		for(int i = 0; i < store.results.size(); i++){
			System.out.println(store.results.get(i));
		}
		return true;
	}
	
}
