import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 입력 정수의 갯수
		int num1 = sc.nextInt();
		
		// 정수의 갯수
		int[] arr = new int[num1];
		
		// arr에 값 넣기
		for(int i = 0; i < num1; i++) {
			arr[i] = sc.nextInt();
		}
		// 정수 제시
		int num2 = sc.nextInt();
		
		
		// 해당 값과 일치하는 변수
		int count = 0;
		
		
		// arr 배열 저장 완료
		
		// 입력 값과 배열의 값이 같으면 cnt++
		for(int i = 0; i < num1; i++) {
			if(arr[i] == num2) {
				count++;
			}
		}
		
		System.out.println(count);
		
	}
}