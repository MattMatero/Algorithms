
public class SpeedTest {
	public static void main(String[] args){

		for(int i = 0; i < 20; i ++){
			System.out.println("round #" + i);
			long start = System.currentTimeMillis();
			int[] first = {5,3,1,35,1,35,31,353,1,3431,351,342,1341,668,97,9,0,8,6,8,45,6456456, 2342};
			printArray(first);
			int[] second = Merge.mergeSort(first);
			printArray(second);
			long end = System.currentTimeMillis() - start;
			System.out.println(end +"ms total");

			start = System.currentTimeMillis();
			ListNode head = setUpList();
			printList(head); 
			head = Merge.mergeSortList(head);
			printList(head);
			end = System.currentTimeMillis() - start;
			System.out.println(end + "ms total");
			System.out.println();
		}
	}

	public static void printArray(int[] arr){
		System.out.print("Array: ");
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}


	public static void printList(ListNode x) {
		if(x != null){
			System.out.print("List: " + x.val + " ");
			while (x.next != null) {
				System.out.print(x.next.val + " ");
				x = x.next;
			}
			System.out.println();
		}

	}

	public static ListNode setUpList(){
		ListNode n1 = new ListNode(5);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(1);
		ListNode n4 = new ListNode(35);
		ListNode n5 = new ListNode(1);
		ListNode n6 = new ListNode(35);
		ListNode n7 = new ListNode(31);
		ListNode n8 = new ListNode(353);
		ListNode n9 = new ListNode(1);
		ListNode n10 = new ListNode(3431);
		ListNode n11 = new ListNode(351);
		ListNode n12 = new ListNode(342);
		ListNode n13 = new ListNode(1341);
		ListNode n14 = new ListNode(668);
		ListNode n15 = new ListNode(97);
		ListNode n16 = new ListNode(9);
		ListNode n17 = new ListNode(0);
		ListNode n18 = new ListNode(8);
		ListNode n19 = new ListNode(6);
		ListNode n20 = new ListNode(8);
		ListNode n21 = new ListNode(45);
		ListNode n22 = new ListNode(6456456);
		ListNode n23 = new ListNode(2342);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = n10;
		n10.next = n11;
		n11.next = n12;
		n12.next = n13;
		n13.next = n14;
		n14.next = n15;
		n15.next = n16;
		n16.next = n17;
		n17.next = n18;
		n18.next = n19;
		n19.next = n20;
		n20.next = n21;
		n21.next = n22;
		n22.next = n23;

		return n1;
	}
}
