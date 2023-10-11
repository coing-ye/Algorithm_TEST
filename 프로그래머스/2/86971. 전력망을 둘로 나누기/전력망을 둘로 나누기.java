import java.util.*;
class Solution {
    public static int[] parent;
    
    public static int find(int x){
        if(x==parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    
    public static boolean union(int x, int y){
        x = find(x);
        y = find(y);
        if(x==y) return false;
        if(x >y) parent[x] = y;
        else parent[y] = x;
        return true;
    }
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        for(int i=0;i<n-1;i++){
            parent = new int[n+1];
            for(int j=1;j<=n;j++){
                parent[j] = j;
            }
            for(int j=0;j<n-1;j++){
                if(j!=i){
                    union(wires[j][0],wires[j][1]);
                }
            }
            for(int j=1;j<=n;j++){
                parent[j] = find(parent[j]);
            }
            //System.out.println(Arrays.toString(parent));
            HashMap<Integer,Integer> hm = new HashMap<>();
            for(int j=1;j<=n;j++){
                if(hm.containsKey(parent[j])){
                    int bn = hm.get(parent[j]);
                    hm.put(parent[j],bn+1);
                }
                else{
                    hm.put(parent[j],1);
                }
            }
            int n1 = 0;
            int n2 = 0;
            ArrayList<Integer> al = new ArrayList<>();
            for(int key:hm.keySet()){
                al.add(hm.get(key));
            }
            n1 = al.get(0);
            n2 = al.get(1);
            int minus = Math.abs(n1-n2);
            answer = Math.min(answer,minus);
        }
        return answer;
    }
}