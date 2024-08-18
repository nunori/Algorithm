class Solution {
    public String solution(String rsp) {
        String result = "";
        
        for(int i = 0; i < rsp.length(); i++) {
            char ch = rsp.charAt(i);
            switch(ch) {
                case '2': result += "0";
                    break;
                case '0': result += "5";
                    break;
                case '5': result += "2";
                    break;
            }
        }
        return result;
    }
}