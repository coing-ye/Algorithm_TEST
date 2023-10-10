import java.io.*;
import java.util.*;

public class Solution {

	public static int T,N,M;
	public static int[] people;
	public static ArrayList<Integer>[] relation;
	public static boolean[] checked;
	
	public static void find(int person, int head) {
		for(int i=0;i<relation[person].size();i++) {
			if(checked[relation[person].get(i)]==true) continue;
			checked[relation[person].get(i)] = true;
			people[relation[person].get(i)] = head;
			find(relation[person].get(i),head);
		}
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T;t++) {
			StringTokenizer st=  new StringTokenizer(br.readLine());
			int ans = 0;
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			people = new int[N+1];
			relation = new ArrayList[N+1];
			checked = new boolean[N+1];
			
			for(int i=1;i<=N;i++) {
				relation[i] = new ArrayList<>();
			}
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int p1 = Integer.parseInt(st.nextToken());
				int p2 = Integer.parseInt(st.nextToken());
				relation[p1].add(p2);
				relation[p2].add(p1);
			}
			for(int i=1;i<=N;i++) {
				if(checked[i] == false) {
					ans++;
					checked[i] = true;
					people[i] = i;
					find(i,i);
				}	
			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}

}