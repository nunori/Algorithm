class Solution {
    public String solution(String letter) {
        String result = "";
        String[] morseList = {".-", "-...", "-.-.", "-..", ".", "..-.", 
                               "--.", "....", "..", ".---", "-.-", ".-..", 
                               "--", "-.", "---", ".--.", "--.-", ".-.", 
                               "...", "-", "..-", "...-", ".--", "-..-", 
                               "-.--", "--.."}; 
        String[] morse;
        
        morse = letter.split(" ");
        for(String s : morse) {
            for(int i = 0; i < morseList.length; i++) {
                if(s.equals(morseList[i])) {
                    result += Character.toString(i + 'a');
                }
            }
        }
        return result;
    }
}