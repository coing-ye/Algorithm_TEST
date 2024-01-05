import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int endtime = attacks[attacks.length-1][0];

        int attackcount = 0;
        int nowhealth = health;
        
        int count = 1;
        
        for(int i=1;i<=endtime;i++){
            if(i==attacks[attackcount][0]){
                nowhealth -= attacks[attackcount][1];
                if(nowhealth<=0){
                    nowhealth = -1;
                    break;
                }
                attackcount+=1;
                count = 1;
            }
            else{
                if(count < bandage[0]){
                    nowhealth += bandage[1];
                    count+=1;
                }
                else if(count == bandage[0]){
                    nowhealth = nowhealth + bandage[1] + bandage[2];
                    count = 1;
                }
                if(nowhealth > health){
                    nowhealth = health;
                }
            }
            //System.out.println(i+" "+nowhealth);
        }
        if(nowhealth<=0){
            answer = -1;
        }
        else{
            answer = nowhealth;
        }

        return answer;
    }
}