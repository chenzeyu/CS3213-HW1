package masterManager;
import java.io.IOException;

import alphabeticShifter.alphabeticShifter;
import circularShifter.circularShifter;
import inputGetter.inputGetter;
import outputPrinter.outputPrinter;

public class KWICManager {

	private static inputGetter ig = new inputGetter();
	private static circularShifter cS = new circularShifter();
	private static alphabeticShifter aS= new alphabeticShifter();
	private static outputPrinter oP= new outputPrinter();
	
	public static void main(String[] args) throws IOException{
		if(ig.performTask())
			if(cS.performTask())
				if(aS.performTask())
					if(oP.performTask())
						System.out.println("\nKWIC System finished successfully");
	}
}
