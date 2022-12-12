package p5a_package;

import java.util.Random;

public class testClass {
	
	public static void main(String[] args)
	{
		Random rand = new Random();
		
		p5_package.StackClass test = new p5_package.StackClass();
		p5_package.IteratorClass it = new p5_package.IteratorClass();
		
		int index;
		int n = 0;
		for(index = 0; index < 25; index++)
		{
			n = rand.nextInt(50) + 1;
			it.setBeforeCurrent(n);
			it.moveNext();
			it.runDiagnosticDisplay();
		}
		it.setToBeginning();
		for(index = 0; index < 12; index++)
		{
			n = rand.nextInt(50) + 1;
			it.moveNext();
			it.runDiagnosticDisplay();
		}
		it.replaceAtCurrent(n);
		it.runDiagnosticDisplay();
		it.removeAtCurrent();
		it.runDiagnosticDisplay();
		p5_package.IteratorClass it2 = new p5_package.IteratorClass(it);
		it.clear();
		it.runDiagnosticDisplay();
		it2.runDiagnosticDisplay();
		
		System.out.println("\n \n \n");
		for(index = 0; index < 25; index++)
		{
			n = rand.nextInt(50) + 1;
			test.push(n);
			test.displayStack();
		}
		
		test.pop();
		test.displayStack();
		p5_package.StackClass test2 = new p5_package.StackClass(test);
		test.clear();
		test.displayStack();
		test2.displayStack();
		
		System.out.println(test2.peekTop());
		System.out.println(test2.isEmpty());
		System.out.println(test.isEmpty());
	}
}
