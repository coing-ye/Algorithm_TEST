import java.util.*;
class Solution {
    static public ArrayList<int[]>[] al;
    static public int N;
    static public boolean[] visited;
    static public boolean[] summitlist;
    static public boolean[] gatelist;
    
    static public PriorityQueue<int[]> pq = new PriorityQueue<>(
        new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[1] == o2[1]){
                    return Integer.compare(o1[0],o2[0]);
                }
                return Integer.compare(o1[1],o2[1]);
            }
        });
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {};
        N = n;
        al = new ArrayList[N+1];
        summitlist = new boolean[N+1];
        gatelist = new boolean[N+1];
        
        for(int gate:gates){
            gatelist[gate] = true;
        }
        
        for(int summit:summits){
            summitlist[summit] = true;
        }
        
        for(int i=1;i<=N;i++){
            al[i] = new ArrayList<int[]>();
        }
        for(int[] path:paths){
            int n1 = path[0];
            int n2 = path[1];
            int cost = path[2];
            al[n1].add(new int[] {n2,cost});
            al[n2].add(new int[] {n1,cost});
        }
        Arrays.sort(gates);
        Arrays.sort(summits);
        int resultsummit = Integer.MAX_VALUE;
        int resultintensity = Integer.MAX_VALUE;
        for(int gate:gates){
            visited = new boolean[N+1];
            pq.clear();
            int intensity = 0;
            int summit = Integer.MAX_VALUE;
            for(int i=0;i<al[gate].size();i++){
                pq.offer(al[gate].get(i));
            }
            while(!pq.isEmpty()){
                int[] now = pq.poll();
                int node = now[0];
                int cost = now[1];
                intensity = Math.max(intensity,cost);
                if(gatelist[node] == false && visited[node] == false){
                    visited[node] = true;
                    if(summitlist[node] == true){
                        //System.out.println("도착!!!! 출발점은 "+gate+" 도착점은 "+node+" 피로도는 "+intensity);
                        summit = node;

                        if(intensity < resultintensity){
                            resultsummit = summit;
                            resultintensity = intensity;
                        }
                        else if(intensity == resultintensity && summit < resultsummit){
                            resultsummit = summit;
                        }
                    }
                    else{
                        for(int i=0;i<al[node].size();i++){
                            int nextnode = al[node].get(i)[0];
                            int nextcost = al[node].get(i)[1];
                            if(gatelist[nextnode] == false && visited[nextnode] == false ){
                                if(nextcost <= resultintensity){
                                    pq.offer(new int[] {nextnode, al[node].get(i)[1]});    
                                }
                            }
                        }
                    }
                }
            }
        }
        answer = new int[] {resultsummit, resultintensity};
        //System.out.println(Arrays.toString(answer));
        return answer;
    }
}