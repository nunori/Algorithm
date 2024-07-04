class Solution
{
    public int solution(int n, int a, int b)
    {
        int cnt = 1;
        while(true) {
            if(a < b && a % 2 == 1 && b - a == 1) {
                break;
            } else if(a > b && b % 2 == 1 && a - b == 1) {
                break;
            }
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;
            
            cnt++;
            System.out.println("cnt: " + cnt);
            
        }
        return cnt;
    }
    
}