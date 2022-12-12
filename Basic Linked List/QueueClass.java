package p6_package;

public class QueueClass 
{
	private BasicLinkedListClass queueData;
	
	public QueueClass()
	{
		queueData = new BasicLinkedListClass();
	}
	
	public QueueClass(QueueClass copied)
	{
		queueData = new BasicLinkedListClass();
		BasicLinkedListClass copiedData = new BasicLinkedListClass();
		int copiedValue = copied.dequeue();
		while(copiedValue != queueData.FAILED_ACCESS)
		{
			queueData.setAtIndex(0, copiedValue, queueData.INSERT_BEFORE);
			copiedData.setAtIndex(0, copiedValue, queueData.INSERT_BEFORE);
			copiedValue = copied.dequeue();
		}
		int index;
		for (index = 0; index < copiedData.getCurrentSize(); index++)
		{
			copied.enqueue(copiedData.getAtIndex(index));
		}
		
	}
	
	public void clear()
	{
		queueData.clear();
	}
	
	public void displayQueue()
	{
		System.out.print("Queue Tail-> ");
		int index;
		for (index = 0; index < queueData.getCurrentSize(); index++)
		{
			System.out.print(queueData.getAtIndex(index));
			if (index != queueData.getCurrentSize() - 1)
			{
				System.out.print(", ");
			}
		}
		System.out.print("<- Queue Front");
		System.out.println("");
	}
	
	public void enqueue(int newValue)
	{
		queueData.setAtIndex(queueData.getCurrentSize() - 1,
				newValue, queueData.INSERT_AFTER);
	}
	
	public int dequeue()
	{
		return queueData.removeAtIndex(queueData.getCurrentSize() - 1);
	}
	
	public boolean isEmpty()
	{
		return queueData.isEmpty();
	}
	
	public int peekFront()
	{
		return queueData.getAtIndex(queueData.getCurrentSize() - 1);
	}
}
