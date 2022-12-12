package p6_package;

public class IteratorClass 
	extends BasicLinkedListClass
{
	private int currentIndex;
	
	private final char LEFT_BRACKET = '[';
	
	private final char RIGHT_BRACKET = ']';
	
	private final char SPACE = ' ';
	
	public IteratorClass()
	{
		currentIndex = 0;
	}
	
	public IteratorClass(IteratorClass copied)
	{
		super(copied);
		currentIndex = 0;
	}
	
	public void clear()
	{
		super.clear();
		currentIndex = 0;
	}
	
	public int getAtCurrent()
	{
		return super.getAtIndex(currentIndex);
	}
	
	public boolean isAtBeginning()
	{
		return (!isEmpty() && currentIndex == 0);
	}
	
	public boolean isAtEnd()
	{
		return (!isEmpty() && 
				currentIndex == super.getCurrentSize());
	}
	
	public boolean isEmpty()
	{
		return super.isEmpty();
	}
	
	public boolean moveNext()
	{
		if(isEmpty())
		{
			return false;
		}
		if (currentIndex < super.getCurrentSize())
		{
			currentIndex++;
			return true;
		}
		return false;
	}
	
	public boolean movePrev()
	{
		if(isEmpty())
		{
			return false;
		}
		if(currentIndex > 0)
		{
			currentIndex--;
			return true;
		}
		return false;
	}
	
	public int removeAtCurrent()
	{
		if(currentIndex == super.getCurrentSize() - 1)
		{
			currentIndex--;
			return super.removeAtIndex(currentIndex + 1);
		}
		return super.removeAtIndex(currentIndex);
	}
	
	public boolean replaceAtCurrent(int newValue)
	{
		return super.setAtIndex(currentIndex, 
				newValue, super.REPLACE);
	}
	
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
	
	public boolean setAfterCurrent(int newValue)
	{
		return super.setAtIndex(currentIndex, 
				newValue, super.INSERT_AFTER);
	}
	
	public boolean setBeforeCurrent(int newValue)
	{
		return super.setAtIndex(currentIndex, 
				newValue, super.INSERT_BEFORE);
	}
	
	public boolean setToBeginning()
	{
		if(isEmpty())
		{
			return false;
		}
		currentIndex = 0;
		return true;
	}
	
	public boolean setToEnd()
	{
		if(isEmpty())
		{
			return false;
		}
		currentIndex = super.getCurrentSize() - 1;
		return true;
	}

}
