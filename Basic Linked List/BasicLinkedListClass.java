package p6_package;

/**
 * 
 * @author zchkf
 * Class Wrapper for a Java linked list, with management operations
 */
public class BasicLinkedListClass
{
	public static final int FAILED_ACCESS = -999999;
	
	public static final int INSERT_AFTER = 1003;
	
	public static final int INSERT_BEFORE = 1002;
	
	public static final int REMOVE = 1004;
	
	public static final int REPLACE = 1001;
	
	public static final int RETREIVE = 1005;
	
	private NodeClass headRef;
	
	/**
	 * 
	 * @author zchkf
	 *
	 * Internal node class for managing data in the linked list
	 */
	private class NodeClass 
	{
		NodeClass nextRef;
		
		int nodeData;
		
		
		/**
		 * Initialization constructor for NodeClass
		 * 
		 * @param copied - NodeClass Object to be copied into this node
		 */
		private NodeClass (NodeClass copied)
		{ 
			nextRef = null;
			nodeData = copied.nodeData;
			
		}
		
		/**
		 * Initialization constructor for NodeClass
		 * 
		 * @param newData - integer value to be place in node
		 */
		private NodeClass(int newData)
		{
			nodeData = newData;
			nextRef = null;
		}
	}
	
	/**
	 * Default constructor, initializes linked list
	 * 
	 */
	protected BasicLinkedListClass()
	{
		headRef = null;
	}
	
	/**
	 * Copy constructor, initializes linked list, the copies all
	 * nodes to local(this) linked list
	 * 
	 * @param copied
	 */
	protected BasicLinkedListClass(BasicLinkedListClass copied)
	{
		this.headRef = new NodeClass (copied.getAtIndex(0));
		
		int index;
		NodeClass wrkNode = this.headRef;
		for (index = 1; index < copied.getCurrentSize(); index++)
		{
			wrkNode.nextRef = new NodeClass (copied.getAtIndex(index));
			wrkNode = wrkNode.nextRef;
			
		}
	}
	
	/**
	 * Utility method used by getAtIndex and removeAtIndex to access 
	 * and possibly remove element depending on control code
	 * 
	 * Note: Data is managed with virtual index found by getRefAtIndex
	 *
     * Note: Uses maximum one loop
     * 
	 * @param controlCode - integer value with either RETRIEVE 
	 * or REMOVE to control operations
	 * 
	 * @param index - integer virtual index of element to be 
	 * retrieved or removed
	 * @return - integer value at element or FAILED_ACCESS if 
	 * attempt to access data out of bounds
	 */
	private int accessAtIndex(int controlCode, int index)
	{
		if (index < 0 || index >= getCurrentSize())
		{
			return FAILED_ACCESS;
		}
		int returnValue = getRefAtIndex(headRef, index).nodeData;
		NodeClass befRef = getRefAtIndex(headRef, index - 1);
		NodeClass aftRef = getRefAtIndex(headRef, index + 1);
		if (controlCode == REMOVE)
		{
			if (befRef != null)
			{
				befRef.nextRef = aftRef;
			}
			else if (index == 0)
			{
				headRef = aftRef;
			}
			return returnValue;
		}
		else if(controlCode == RETREIVE)
		{
			return returnValue; 
		}
		return FAILED_ACCESS;
	}
	
	/**
	 * Clears linked list of all valid values 
	 * by setting linked list head reference to null
	 * 
	 */
	protected void clear()
	{
		headRef = null;
	}
	
	/**
	 * Accesses item in linked list at specified virtual 
	 * index if it is within linked list limits
	 * 
	 * Note: Linked list value specified by 
	 * virtual index is returned to calling program
	 * 
	 * Note: Calls accessAtIndex with RETRIEVE to conduct action
	 * 
	 * @param accessIndex - integer virtual index of requested 
	 * element value
	 * 
	 * @return - integer accessed value if successful, 
	 * FAILED_ACCESS if not
	 */
	protected int getAtIndex(int accessIndex)
	{
		return accessAtIndex(RETREIVE, accessIndex);
	}
	
	/**
	 * Gets size of linked list
	 * 
	 * Note: Uses getCurrentSizeHelper
	 * 
	 * Note: Handles empty list prior to calling helper if needed
	 * 
	 * @return - integer virtual index
	 */
	protected int getCurrentSize()
	{
		if(isEmpty())
		{
			return 0;
		}
		return getCurrentSizeHelper(headRef);
	}
	
	/**
	 * Uses recursion to find linked list size
	 * 
	 * @param wkgRef- NodeClass current reference in recursion, 
	 * initially called with head reference
	 * 
	 * @return - integer linked list size
	 */
	private int getCurrentSizeHelper(NodeClass wkgRef)
	{
		if (wkgRef.nextRef != null)
		{
			return getCurrentSizeHelper(wkgRef.nextRef) + 1;
		}
		return 1;
	}
	
	/**
	 * Private recursive method that finds a node represented
	 *  by a virtual index
	 * 
	 * Note: if requested index is less than zero or outside 
	 * linked list boundary, returns null
	 * 
	 * @param wkgRef - NodeClass reference that initially called with the head
	 *  reference, and is used for recursive operations
	 *  
	 * @param requestedIndex - integer value representing virtual index 
	 * requested by the user
	 * 
	 * @return - NodeClass reference to the element at the virtual index
	 */
	private NodeClass getRefAtIndex(NodeClass wkgRef,
			int requestedIndex)
	{
		if (requestedIndex < 0 || requestedIndex > getCurrentSize() - 1)
		{
			return null;
		}
		if (requestedIndex == 0 || wkgRef == null)
		{
			return wkgRef;
		}
		return getRefAtIndex(wkgRef.nextRef, requestedIndex-1 );
		
	}
	
	/**
	 * Test for empty linked list
	 * 
	 * @return - Boolean result of test for empty
	 */
	protected boolean isEmpty()
	{
		return (headRef == null);
	}
	
	/**
	 * Removes item from linked list at specified virtual index 
	 * if index within linked list size bounds
	 * 
	 * Note: Linked list node specified by 
	 * virtual index is removed from list
	 * 
	 * Note: Calls accessAtIndex with REMOVE to conduct action
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
	 * Displays formatted list with virtual indices
	 * 
	 * @param showIndex - Boolean value turns on display of 
	 * index under value if set to true, otherwise only shows
	 * pipe delimited values
	 * 
	 */
	protected void runDiagnosticDisplay(boolean showIndex)
	{
		if (!isEmpty())
		{
			int index;
			NodeClass currentNode = headRef;
			System.out.print("List:  ");
			for(index = 0; index < getCurrentSize(); index++)
			{
				System.out.format("|  %d  | ", currentNode.nodeData);
				if(currentNode.nextRef != null)
				{
					currentNode = currentNode.nextRef;
				}
			}
			System.out.println("");
			if (showIndex)
			{
				System.out.print("Index: |  ");
				for(index = 0; index < getCurrentSize(); index++)
				{
					System.out.print(index + "        ");
				}
			}
			System.out.println("");
			System.out.print("       ");
			for(index = 0; index < getCurrentSize(); index++)
			{
				System.out.print("--------");
			}
			System.out.println("");
		}
	}
	
	/**
	 * Description: sets item in linked list at specified 
	 * virtual index
	 * 
	 * Note: If constant REPLACE is used, new value overwrites
	 *  value at current virtual index
	 *  
	 * Note: If constant INSERT_BEFORE is used, new value is inserted
	 *  prior to the value at the current virtual index
	 *   
	 * Note: If constant INSERT_AFTER is used, new value is inserted
	 *  after the value at the current virtual index
	 *  
	 * Note: Method must check for correct virtual array boundaries;
	 *  if index requested is below zero or above list size - 1,
	 *  method must take no action and return false
	 * 
	 * Note: Method must check for correct replace flag; if it is 
	 * not one of the three specified flags, it must take no 
	 * action and return false
	 * 
	 * @param setIndex - integer index of element at which value is
	 *  to be replaced, or value is to be inserted before or after
	 *  
	 * @param newValue - integer value to be placed in linked list
	 * 
	 * @param replaceFlag - integer flag to indicate insertion or 
	 * replacement in the linked list
	 * 
	 * @return - Boolean success if inserted, or failure if incorrect
	 *  index or replace flag was used
	 */
	protected boolean setAtIndex(int setIndex, 
			int newValue, int replaceFlag)
	{
		NodeClass befRef;
		NodeClass aftRef;
		NodeClass currentNode;
		if(isEmpty())
		{
			headRef = new NodeClass(newValue);
			return true;
		}else if(setIndex < getCurrentSize() && setIndex >= 0)
		{
			if (replaceFlag == INSERT_BEFORE)
			{
				if(setIndex == 0)
				{
					aftRef = getRefAtIndex(headRef, setIndex);
					headRef = new NodeClass(newValue);
					headRef.nextRef = aftRef;
							
				}
				else
				{
					befRef = getRefAtIndex(headRef, setIndex - 1);
					aftRef = getRefAtIndex(headRef, setIndex);
					befRef.nextRef = new NodeClass(newValue);
					currentNode = befRef.nextRef;
					currentNode.nextRef = aftRef;
				}
				
				return true;
			}
			else if(replaceFlag == INSERT_AFTER)
			{
				befRef = getRefAtIndex(headRef, setIndex);
				aftRef = getRefAtIndex(headRef, setIndex + 1);
				currentNode = new NodeClass(newValue);
				befRef.nextRef = currentNode;
				currentNode.nextRef = aftRef;
				return true;
				
			}
			else if(replaceFlag == REPLACE)
			{
				currentNode = getRefAtIndex(headRef, setIndex);
				currentNode.nodeData = newValue;
				return true;
			}
		}
		
		return false;
	}
}
