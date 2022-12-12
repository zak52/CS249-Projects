package p5_package;

/**
 * Class wrapper for Java array, with management operations
 * @author zchkfmn1999
 *
 */
public class BasicArrayClass 
{
	
	private int arrayCapacity;
	
	private int arraySize;
	
	private static final int DEFAULT_CAPACITY = 10;
	
	public static final int FAILED_ACCESS = -999999;
	
	public static final int INSERT_AFTER = 1003;
	
	public static final int INSERT_BEFORE = 1002;
	
	private int[] localArray;
	
	public static final int REMOVE = 1004;
	
	public static final int RETRIEVE = 1005;
	
	public static final int REPLACE = 1001;
	
	/**
	 * Default Constructor class
	 * 
	 * initializes array to default capacity
	 */
	protected BasicArrayClass()
	{
		arrayCapacity = DEFAULT_CAPACITY;
		arraySize = 0;
		localArray = new int[arrayCapacity];
	}
	
	/**
	 * copy constructor, initializes array to size and capacity
	 * of copied array then copies only the elements up to the given size
	 * 
	 * @param copied - BasicArrayClass object to be copied
	 */
	protected BasicArrayClass(BasicArrayClass copied)
	{
		this.arrayCapacity = copied.getCurrentCapacity();
		this.arraySize = copied.getCurrentSize();
		this.localArray = new int[arrayCapacity];
		int index;
		for (index = 0; index < this.arraySize; index++)
		{
			this.localArray[index] = copied.getAtIndex(index);
		}
	}
	
	/**
	 * initializing constructor, initializes array to specified capacity
	 * 
	 * @param capacity - integer maximum capacity specification
	 */ 
	protected BasicArrayClass(int capacity)
	{
		arrayCapacity = capacity;
		arraySize = 0;
		localArray = new int[arrayCapacity];
		
	}
	/**
	 * Utility methoud used by getAtIndex and removeAtIndex
	 * to access and possibly remove element depending on control code
	 * 
	 * note: only use one loop
	 * 
	 * @param controlCode - integer value with either RETRIEVE or REMOVE
	 * to control operations
	 * 
	 * @param index - integer index of element to retrieved or removed
	 * 
	 * @return - integer value at element or FAILED_ACCESS if attempt to
	 * access data out of bounds
	 */
	private int accessAtIndex(int controlCode, int index)
	{
		if (index < 0 || index >= arraySize)
		{
			return FAILED_ACCESS;
		}
		int returnValue = localArray[index];
		int loopIndex;
		if (controlCode == REMOVE)
		{
			arraySize = arraySize - 1;
			for (loopIndex = index; loopIndex < arraySize; loopIndex++)
			{
				localArray[loopIndex] = localArray[loopIndex + 1];
			}
			return returnValue;
		}
		else if(controlCode == RETRIEVE)
		{
			return returnValue;
		}
		return FAILED_ACCESS;
	}
	
	/**
	 * Checks for need to resize; if necessary creates new array
	 * 
	 * with double original capacity, loads data from original array 
	 * 
	 * to new one then sets localArray to newArray;
	 */
	protected void checkForResize()
	{
		if (arraySize == arrayCapacity)
		{ 
			arrayCapacity = arrayCapacity * 2;
			int[] tempArray = new int[arrayCapacity];
			int index;
			for (index = 0; index < arraySize; index++)
			{
				tempArray[index] = localArray[index];
			}
			localArray = new int[arrayCapacity];
			for (index = 0; index < arraySize; index++)
			{
				localArray[index] = tempArray[index];
			}
		}
	}
	
	/**
	 * Clears array of all valid values by setting arraySize to 
	 * 
	 * Zero, value remain in array but are not accessible
	 * 
	 */
	protected void clear()
	{
		arraySize = 0;
	}
	
	/**
	 * Accesses item in array at specified index if 
	 * 
	 * index within array size bounds
	 * 
	 * @param accessIndex - integer index of requested element value
	 * 
	 * @return - integer accessed value if successful, FAILED_ACCESS if not
	 */
	protected int getAtIndex(int accessIndex)
	{
		return accessAtIndex(RETRIEVE, accessIndex);
	}
	
	/**
	 * Gets current capacity of array
	 * 
	 * @return - integer capacity of array
	 */
	protected int getCurrentCapacity()
	{
		return arrayCapacity;
	}
	
	/**
	 * gets current size of array
	 * 
	 * @return - integer size of array
	 */
	protected int getCurrentSize()
	{
		return arraySize;
	}
	
	/**
	 * Tests for size of array equal to zero
	 * 
	 * @return - boolean result of test for empty
	 */
	protected boolean isEmpty()
	{
		return (arraySize == 0);
	}
	
	/**
	 * Removes item from array at specified index if index within array size bounds
	 * 
	 * @param removeIndex - integer index of element value to be removed
	 * 
	 * @return - removed integer value if successful, FAILED_ACCESS if not
	 */
	protected int removeAtIndex(int removeIndex)
	{
		return accessAtIndex(REMOVE, removeIndex);
	}
	
	/**
	 * Sets item in array at specified index
	 * 
	 * @param setIndex - integer index of element at which value is to be inserted
	 * @param newValue - integer value to be placed in array
	 * @param replaceFlag - integer flag to indicate insertion or replacement 
	 * in the array
	 * 
	 * @return - Boolean success if inserted, or failure if incorrect index was used
	 */
	protected boolean setAtIndex(int setIndex, int newValue, int replaceFlag)
	{
		checkForResize();
		int loopIndex;
		int tempValue;
		int tempValueTwo;
		if (isEmpty())
		{
			arraySize += 1;
			localArray[0] = newValue;
			return true;
		}
		else if (setIndex >= 0 && setIndex < arraySize)
		{
			if(replaceFlag == INSERT_BEFORE)
			{
				arraySize += 1;
				tempValue = localArray[setIndex];
				localArray[setIndex] = newValue;
				for(loopIndex = setIndex + 1; loopIndex < arraySize; loopIndex++)
				{
					tempValueTwo = localArray[loopIndex];
					localArray[loopIndex] = tempValue;
					tempValue = tempValueTwo;
					
				}
				return true;
			}
			else if(replaceFlag == INSERT_AFTER)
			{
				arraySize += 1;
				tempValue = localArray[setIndex + 1];
				localArray[setIndex + 1] = newValue;
				for(loopIndex = setIndex + 2; loopIndex < arraySize; loopIndex++)
				{
					tempValueTwo = localArray[loopIndex];
					localArray[loopIndex] = tempValue;
					tempValue = tempValueTwo;
					
				}
				return true;
			}
			else if(replaceFlag == REPLACE)
			{
				localArray[setIndex] = newValue;
				return true;
			}
		}
		return false;
	}
	
	
}