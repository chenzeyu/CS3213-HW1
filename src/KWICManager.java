import alphabeticShifter.alphabeticShifter;
import circularShifter.circularShifter;
import inputGetter.inputGetter;
import outputPrinter.outputPrinter;

public class KWICManager {

	private static inputGetter ig = new inputGetter();
	private static circularShifter cS = new circularShifter();
	private static alphabeticShifter aS= new alphabeticShifter();
	private static outputPrinter oP= new outputPrinter();
	
	public static void main(String[] args){
		if(ig.performTask())
			if(cS.performTask())
				if(aS.performTask())
					if(oP.performTask())
						System.out.println("KWIC System finished successfully");
	}
}
