package p5_package;

/**
 * Iterator class inherited from BasicArrayClass,
 * Conducts iterator operations
 * 
 * @author zchkfmn1999
 *
 */
public class IteratorClass extends BasicArrayClass
{
	
	private int currentIndex;
	
	private final char LEFT_BRACKET = '[';
	
	private final char RIGHT_BRACKET = ']';
	
	private final char SPACE = ' ';
	
	/**
	 * Default constructor for iterator class
	 */
	public IteratorClass()
	{
		super();
		currentIndex = 0;
	}
	
	/**
	 * Initialization constructor for IteratorClass
	 * 
	 * @param initCapacity - integer value at which to set initial array capacity
	 */
	public IteratorClass(int initCapacity)
	{
		super(initCapacity);
		currentIndex = 0;
	}
	
	/**
	 * Copy constructor for IteratorClass
	 * 
	 * @param copied - IteratorClass object to be copied
	 */
	public IteratorClass(IteratorClass copied)
	{
		super(copied.getCurrentCapacity());
		int index;
		copied.setToBeginning();
		currentIndex = 0;
		
		for(index = 0; index < copied.getCurrentSize(); index++)
		{
			setBeforeCurrent(copied.getAtCurrent());
			moveNext();
			copied.moveNext();
		}
		movePrev();
		int temp = removeAtCurrent();
		setToBeginning();
		setBeforeCurrent(temp);
		setToEnd();
	}
	
	/**
	 * Clears Array
	 * 
	 */
	public void clear()
	{
		super.clear();
		currentIndex = 0;
	}
	
	/**
	 * Gets value at iterator cursor location
	 * 
	 * @return - integer Value returned; FAILED_ACCESS if not found
	 */
	public int getAtCurrent()
	{
		return super.getAtIndex(currentIndex);
	}
	
	/**
	 * Reports if iterator cursor is at beginning
	 * 
	 * @return - Boolean result of action; true if at beginning, false otherwise
	 */
	public boolean isAtBeginning()
	{
		return (isEmpty() || currentIndex == 0);
	}
	
	/**
	 * Reports if iterator cursor is at end
	 * 
	 * @return - boolean result of action; true if at end, false otherwise
	 */
	public boolean isAtEnd()
	{
		return (isEmpty() || currentIndex == (super.getCurrentSize()));
	}
	
	/**
	 * Reports if list is empty
	 * 
	 * @return - Boolean result of action; true if empty, false otherwise
	 */
	public boolean isEmpty()
	{
		return (super.isEmpty() && currentIndex == 0);
	}
	
	/**
	 *  if possible, moves iterator cursor one position to the right or next
	 *  
	 * @return - Boolean result of action; true if successful, false otherwise
	 */
	public boolean moveNext()
	{
		if (!isEmpty() && !isAtEnd())
		{
			currentIndex++;
			return true;
		}
		return false;
	}
	
	/**
	 * If possible, moves iterator cursor one position to the left, or previous
	 * 
	 * @return - Boolean result of action; true if successful, false otherwise
	 */
	public boolean movePrev()
	{
		if (!isEmpty() && !isAtBeginning())
		{
			currentIndex--;
			return true;
		}
		return false;
	}
	
	/**
	 * Removes and returns a data value from iterator cursor position
	 * 
	 * @return - integer value removed from list, or FAILED_ACCESS if not found
	 */
	public int removeAtCurrent()
	{
		int tempIndex = currentIndex;
		if (isAtEnd())
		{
			currentIndex--;
		}
		return super.removeAtIndex(tempIndex);
	}
	
	/**
	 * Replaces value at iterator cursor with new value
	 * 
	 * @param newValue - integer value to be inserted in list
	 * 
	 * @return - Boolean result of action; true if successful, false otherwise
	 */
	public boolean replaceAtCurrent(int newValue)
	{
		return super.setAtIndex(currentIndex, newValue, REPLACE);
	}
	
	/**
	 * Shows space-delimited list with cursor location indicated.
	 */
	public void runDiagnosticDisplay()
	{
		int index;
		for(index = 0; index < super.getCurrentSize(); index++)
		{
			if(index == currentIndex)
			{
				System.out.print(LEFT_BRACKET + "" + getAtCurrent() +
						"" + RIGHT_BRACKET);
			}
			else
			{
				System.out.print(super.getAtIndex(index));
			}
			System.out.print(SPACE);
		}
		if(isAtEnd())
		{
			System.out.print(LEFT_BRACKET + "" + 0 + 
					"" + (char)RIGHT_BRACKET);;
		}
		System.out.println("");
	}
	
	/**
	 * Inserts new value after value at iterator cursor
	 * 
	 * @param newValue - integer value to be inserted in list
	 * 
	 * @return - boolean result of action; true if successful, false otherwise
	 */
	public boolean setAfterCurrent(int newValue)
	{
		return super.setAtIndex(currentIndex, newValue, INSERT_AFTER);
	}
	
	/**
	 * Inserts new before value at iterator cursor
	 * 
	 * @param newValue - integer value to be inserted in list
	 * 
	 * @return - Boolean result of action; true if successful, false otherwise
	 */
	public boolean setBeforeCurrent(int newValue)
	{
		int tempIndex = currentIndex;
		if (!isEmpty())
		{
			currentIndex++;
		}
		if (tempIndex == 0)
		{
			return super.setAtIndex(tempIndex, newValue, INSERT_BEFORE);
		}
		return super.setAtIndex(tempIndex - 1, newValue, INSERT_BEFORE);
	}
	
	/**
	 * Sets iterator cursor to beginning of list
	 * 
	 * @return - Boolean result of action; true if successful, false otherwise
	 */
	public boolean setToBeginning()
	{
		if(!isEmpty())
		{
			currentIndex = 0;
			return true;
		}
		return false;
	}
	
	/**
	 * Sets iterator cursor to the end of the list
	 * 
	 * @return - Boolean result of action; true if successful, false otherwise
	 */
	public boolean setToEnd()
	{
		if(!isEmpty())
		{
			currentIndex = super.getCurrentSize();
			return true;
		}
		return false;
	}
}


