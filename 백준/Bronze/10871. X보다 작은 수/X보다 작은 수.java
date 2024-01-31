import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int X = sc.nextInt();
		int[] arr = new int[N];
		int R = 0;
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] < X) {
				R = arr[i];
				System.out.print(R + " ");
			}
		}
		
	}
}