package p5_package;

/**
 * Stack Class that uses BasicArrayClass as data structure
 * 
 * @author zchkfmn1999
 *
 */
public class StackClass 
{

		private BasicArrayClass stackData;
		
		/**
		 * Stack default constructor
		 */
		public StackClass()
		{
			stackData = new BasicArrayClass();
		}
		
		/**
		 * Stack initialization constructor
		 * 
		 * @param capacitySetting - integer value for setting 
		 * initial capacity of array
		 */
		public StackClass(int capacitySetting)
		{
			stackData = new BasicArrayClass(capacitySetting);
		}
		
		/**
		 * Copy constructor
		 * @param copied - StackClass object to be copied
		 */
		public StackClass(StackClass copied)
		{
			stackData = new BasicArrayClass(copied.stackData);
			
		}
		
		/**
		 * Clears stack
		 */
		public void clear()
		{
			stackData.clear();
		}
		
		/**
		 * Displays stack
		 */
		public void displayStack()
		{
			int index;
			for (index = 0; index < stackData.getCurrentSize(); index++)
			{
				System.out.print(stackData.getAtIndex(index));
				if(index < stackData.getCurrentSize() - 1)
				{
					System.out.print(", ");
				}
			}
			if (isEmpty())
			{
				System.out.println("Empty Stack");
			}
			else
			{
				System.out.println("");
			}
		}
		
		/**
		 * Reports stack empty status
		 * 
		 * @return - Boolean evidence of empty list
		 */
		public boolean isEmpty()
		{
			return stackData.isEmpty();
		}
		
		/**
		 * provides peek at top of stack
		 * 
		 * @return - value if successful, FAILED_ACCESS if not
		 */
		public int peekTop()
		{
			return stackData.getAtIndex(stackData.getCurrentSize() - 1);
		}
		
		/**
		 * Removes and returns data from top of stack
		 * 
		 * @return - value if successful, FAILED_ACCESS if not
		 */
		public int pop() 
		{
			return stackData.removeAtIndex(stackData.getCurrentSize() - 1);
		}
		
		/**
		 * Places data item on top of the stack
		 * 
		 * @param newVal - integer value to pushed onto stack
		 */
		public void push(int newVal)
		{
			stackData.setAtIndex(stackData.getCurrentSize() - 1 , 
					newVal, stackData.INSERT_AFTER);
		}
}
