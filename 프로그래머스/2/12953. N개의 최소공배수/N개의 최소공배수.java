import java.util.*;

class Solution {
    // 최대공약수를 구하는 함수
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // 최소공배수를 구하는 함수
    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public int solution(int[] arr) {
        int lcmValue = arr[0]; // 첫 번째 원소로 초기화
        for (int i = 1; i < arr.length; i++) {
            lcmValue = lcm(lcmValue, arr[i]); // 각 원소와 현재 lcmValue를 사용해 최소공배수 갱신
        }
        return lcmValue;
    }
}