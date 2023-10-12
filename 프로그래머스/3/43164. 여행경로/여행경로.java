import java.util.*;

class Solution {
    public static HashMap<String,Integer> idx = new HashMap<>();
    public static HashMap<Integer,String> portnum = new HashMap<>();
    public static HashSet<String> airport = new HashSet<>();
    public static HashMap<String,Integer> airline = new HashMap<>();
    public static ArrayList<Integer>[] fromto;
    public static ArrayList<String> ans = new ArrayList<>();
    public static int flag = 0;
    
    public static void dfs(int now,int line, int goal){
        if(line == goal){
            System.out.println(ans.toString());
            flag = 1;
            return;
        }
        for(int i=0;i<fromto[now].size();i++){
            String nowair = portnum.get(now);
            int next = fromto[now].get(i);
            String nextair = portnum.get(next);
            String hash = nowair.concat(nextair);
            if(airline.get(hash)>0){
                airline.put(hash,airline.get(hash)-1);
                ans.add(nextair);
                dfs(next,line+1,goal);
                if(flag == 0){
                    airline.put(hash,airline.get(hash)+1);
                    ans.remove(ans.size()-1);
                }
                
            }
        }
        
    }
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        for(int i=0;i<tickets.length;i++){
            for(int j=0;j<2;j++){
                airport.add(tickets[i][j]);
            }
        }
        ArrayList<String> tmp = new ArrayList<>();
        for(String air:airport){
            tmp.add(air);
        }
        Collections.sort(tmp);
        //System.out.println(tmp.toString());

        int startnum = -1;
        for(int i=0;i<tmp.size();i++){
            if(tmp.get(i).equals("ICN")){
                startnum = i;
            }
            idx.put(tmp.get(i),i);
            portnum.put(i,tmp.get(i));
        }
        int airportnum = tmp.size();
        
        fromto = new ArrayList[airportnum];
        for(int i=0;i<airportnum;i++){
            fromto[i] = new ArrayList<>();
        }
        
        
        
        for(int i=0;i<tickets.length;i++){
            String from = tickets[i][0];
            String to = tickets[i][1];
            String hash = from.concat(to);
            if(airline.get(hash)==null){
                airline.put(hash,1);
            }
            else{
                airline.put(hash,airline.get(hash)+1);
            }
            fromto[idx.get(from)].add(idx.get(to));
        }
        
        for(int i=0;i<airportnum;i++){
            Collections.sort(fromto[i]);
        }
        ans.add("ICN");
        //System.out.println(portnum.toString()+" "+startnum);
        
        dfs(startnum,0,tickets.length);
        
        answer = new String[ans.size()];
        for(int i =0;i<ans.size();i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}