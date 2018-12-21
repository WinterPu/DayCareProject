
public class BinarySearch {
	private int[] array;
	private int target;

	public BinarySearch(int[] a, int target) {
		this.array = a;
		this.target = target;
	}

	public void demo() {
		int result = -1;
		int lo = 0, hi = array.length-1;
		while(lo <= hi) {
			int mid = lo + (hi - lo)/2;
			if(target > array[mid]) lo = mid+1;
			else if(target < array[mid]) hi = mid-1;
			else {
				result = mid;
				break;
			}
		}
		if(result != -1) System.out.println("Got the element " + array[result] + 
			" on index " + result);
		else System.out.println("The target doesn't exist.");
	}

	public static void main(String[] args) {
		int[] a = new int[]{6, 13, 14, 25, 33, 43, 51, 53, 64, 72, 84, 
			93, 95, 96, 97};
		int target = 97;
		BinarySearch bs = new BinarySearch(a, target);
		bs.demo();
	}
}