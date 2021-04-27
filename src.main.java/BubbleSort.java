import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = new int[] {4,3,5,2,5,19};
		BubbleSort sort = new BubbleSort();
		sort.bubbleSort(arr);
		
		Arrays.stream(arr).forEach(System.out::println);
		
	}
	
	public void bubbleSort(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length-1; j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
}
