
public class Merge {

	
	public static ListNode mergeSortList(ListNode head) {
		 
		if (head == null || head.next == null)
			return head;
 
		// count total number of elements
		int count = 0;
		ListNode p = head;
		while (p != null) {
			count++;
			p = p.next;
		}
 
		// break up to two list
		int middle = count / 2;
 
		ListNode l = head, r = null;
		ListNode p2 = head;
		int countHalf = 0;
		while (p2 != null) {
			countHalf++;
			ListNode next = p2.next;
 
			if (countHalf == middle) {
				p2.next = null;
				r = next;
			}
			p2 = next;
		}
 
		// now we have two parts l and r, recursively sort them
		ListNode h1 = mergeSortList(l);
		ListNode h2 = mergeSortList(r);
 
		// merge together
		ListNode merged = merge(h1, h2);
 
		return merged;
	}
 
	private static ListNode merge(ListNode l, ListNode r) {
		ListNode p1 = l;
		ListNode p2 = r;
 
		ListNode fakeHead = new ListNode(100);
		ListNode pNew = fakeHead;
 
		while (p1 != null || p2 != null) {
 
			if (p1 == null) {
				pNew.next = new ListNode(p2.val);
				p2 = p2.next;
				pNew = pNew.next;
			} else if (p2 == null) {
				pNew.next = new ListNode(p1.val);
				p1 = p1.next;
				pNew = pNew.next;
			} else {
				if (p1.val < p2.val) {
					// if(fakeHead)
					pNew.next = new ListNode(p1.val);
					p1 = p1.next;
					pNew = pNew.next;
				} else if (p1.val == p2.val) {
					pNew.next = new ListNode(p1.val);
					pNew.next.next = new ListNode(p1.val);
					pNew = pNew.next.next;
					p1 = p1.next;
					p2 = p2.next;
 
				} else {
					pNew.next = new ListNode(p2.val);
					p2 = p2.next;
					pNew = pNew.next;
				}
			}
		}
 

		return fakeHead.next;
	}
	
	
	/**
	 * A standard mergesort algorithm that will work on an array structure
	 * @param list - an array to be sorted
	 * @return a sorted array
	 */
    public static int[] mergeSort(int[] list)
    {

        if(list.length == 1)//checks to see if the list is 1 element long
        {
            return list;
        }

        int[] merge1 = new int[list.length/2]; //lower half
        int[] merge2 = new int[list.length - merge1.length]; //upper half
        
        //copies arrays over
        System.arraycopy(list,0,merge1,0,merge1.length);
        System.arraycopy(list,merge1.length,merge2,0,merge2.length);

        
        merge1 = mergeSort(merge1);//sorts the lower half of the list
        merge2 = mergeSort(merge2);//sorts the upper half of the list

        merge(mergeSort(merge1),mergeSort(merge2),list);//puts the two lists together as one
        return list;
    }
    
    
    /**
     * Helper method to mergesort that merges the lists together
     * @param merge1 - lower half
     * @param merge2 - upper half
     * @param list - final list
     */
    private static void merge(int[] merge1, int[] merge2, int[] list)
    {
        int left = 0;//index for merge1
        int right = 0;//index for merge2
        int whole = 0;//index for original list

        //bounds check
        while(left < merge1.length && right < merge2.length)
        {
            //checks if the current element in left is less than the current element in right
            if(merge1[left] < merge2[right])
            {
                list[whole] = merge1[left];//if left is less than the right this gets placed in the new list
                left++;
            }
            else
            {
                list[whole] = merge2[right];//the right element gets placed in the new list
                right++;
            }
            whole++;
        }
        
        int[] rest;//holds remainder of elements
        int restIndex;
        
        //checks to see which list is longer
        if(left >= merge1.length)
        {
            rest = merge2;//rest = leftover elements in the second list
            restIndex = right;//start where you left off on  the right list
        }
        else
        {
            rest = merge1;//rest = leftover elements in the first list
            restIndex = left;//start where you left off on the left list
        }

        //puts the rest list into the whole list
        for(int i = restIndex; i < rest.length; i++)
        {
            list[whole] = rest[i];
            whole++;
        }
    }
}
