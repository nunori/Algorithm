class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        // bandage: t(시전 시간), x(초당 회복량), y(추가 회복량)
        // attacks: 공격 시간, 피해량
        // 죽으면 -1 return
        
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        int continuousTime = 0;
        int currTime = 0;
        int currHealth = health;
        
        for(int i = 0; i < attacks.length; i++) {
            int atkTime = attacks[i][0];
            int dmg = attacks[i][1];
            while(currTime != atkTime) {
                currTime++;
                if(currTime == atkTime) {
                    continuousTime = 0;
                    currHealth -= dmg;
                    if(currHealth <= 0) return -1;
                } else {
                    if(currHealth >= health) continue;
                    else {
                        continuousTime++;
                        currHealth += x;
                        if(continuousTime % t == 0) {
                            currHealth += y;
                            continuousTime = 0;
                        }
                        if(currHealth >= health) currHealth = health;
                    }
                }
            }
        }   
        return currHealth;
    }
}