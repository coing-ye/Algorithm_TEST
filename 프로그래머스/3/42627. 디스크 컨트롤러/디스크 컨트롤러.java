import java.util.*;

class Solution {
    public static PriorityQueue<int[]> pq = new PriorityQueue<>( new Comparator<int[]>(){
        @Override
        public int compare(int[] o1, int[] o2){
            if(o1[1] == o2[1]){
                return Integer.compare(o1[0],o2[0]);
            }
            return Integer.compare(o1[1],o2[1]);
        }
    });
    public static ArrayList<int[]> al = new ArrayList<>();
    public int solution(int[][] jobs) {
        int answer = 0;
        int totalnum = jobs.length;
        for(int i=0;i<jobs.length;i++){
            al.add(Arrays.copyOf(jobs[i],2));
        }
        Collections.sort(al, (int[] o1,int[] o2) -> { 
            if (o1[0] == o2[0]){
                return Integer.compare(o1[1],o2[1]);
            }
            return Integer.compare(o1[0], o2[0]); 
        });
        
        int nowtime = 0;
        int tasktime = 0;
        boolean ontask = false;
        int[] nowtask;
        int[] nexttask;
        int flag = 1;
        // for(int i=0;i<al.size();i++){
        //     System.out.println(Arrays.toString(al.get(i)));
        // }
        while(al.size()>0){
            if(ontask == false){
                nowtask = al.get(0);
                //System.out.println(Arrays.toString(nowtask));
                al.remove(0);
                nowtime = nowtask[0]+nowtask[1];
                answer += nowtask[1];
                if(al.size()>0){
                    if(al.get(0)[0] > nowtime){
                        continue;
                    }
                    else{
                        ontask= true;
                        for(int i=0;i<al.size();i++){
                            if(al.get(i)[0]<=nowtime){
                                pq.offer(al.get(i));
                            }
                            else{
                                break;
                            }
                        }
                    }
                }
                
            }
            else if(ontask == true){       
                nexttask = pq.poll();
                answer += nexttask[1] + nowtime - nexttask[0];
                nowtime += nexttask[1];
                
                al.remove(al.indexOf(nexttask));
                pq.clear();
                if(al.size()>0){ 
                    if(al.get(0)[0] > nowtime){
                        ontask = false;
                    }
                    else{
                        for(int i=0;i<al.size();i++){
                            if(al.get(i)[0] <= nowtime){
                                pq.offer(al.get(i));
                            }
                            else{
                                break;
                            }
                        }
                    }
                }
                
            }
            //System.out.println(nowtime + " "+ answer+" "+ontask+" "+al.size()+"/"+pq.size());
            flag++;

        }
        

        return (int)(answer/totalnum);
    }
}