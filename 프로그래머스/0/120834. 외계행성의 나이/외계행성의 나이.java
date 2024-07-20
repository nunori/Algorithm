class Solution {
    public String solution(int age) {
        StringBuilder sb = new StringBuilder();
        String s = Integer.toString(age);
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char ch = (char)(c + '1');
            String temp = Character.toString(ch);
            sb.append(temp);
        }
        return sb.toString();
    }
}