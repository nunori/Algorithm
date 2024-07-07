class Solution {
    public int solution(int price) {
        double result = -1;
        if (price < 100000) {
            result = price;
        } else if (price >= 10000 && price < 300000) {
            result = price * 0.95;
        } else if (price >= 300000 && price < 500000) {
            result = price * 0.9;
        } else if (price >= 500000) {
            result = price * 0.8;
        }
        return (int) result;
    }
}