
import java.io.*;
import java.util.*;

public class Main {

	public static int N;
	public static int[] population;
	public static ArrayList[] city;
	public static int[] dpfield;
	public static boolean[] visited;
	
	
	public static int[] dfs(int now) {
		if(city[now].size()==0) {
			dpfield[now] = population[now];
			return new int[] {population[now],  0};
		}
		int tmp1 = 0;
		int tmp2 = 0;
		int[] tmpset;
		for(int i =0; i<city[now].size();i++) {
			int next = (int) city[now].get(i);
			if(visited[next]==true) continue;
			visited[next] = true;
			tmpset =  dfs(next);
			tmp1 += tmpset[0];
			tmp2 += tmpset[1];
		}
		if((population[now]+tmp2) > tmp1) {
			dpfield[now] = population[now]+tmp2;
		}
		else {
			dpfield[now] = tmp1;
		}
		return new int[] {dpfield[now],tmp1};
	}
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine().trim());
		city = new ArrayList[N+1];
		population = new int[N+1];
		dpfield = new int[N+1];
		visited = new boolean[N+1];
		
		st = new StringTokenizer(br.readLine().trim());
		for(int i=0;i<N;i++) {
			population[i+1] = Integer.parseInt(st.nextToken());
			city[i+1] = new ArrayList<Integer>();
		}
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			//if (a < b) city[a].add(b);
			//else if( b <a) city[b].add(a);
			city[a].add(b);
			city[b].add(a);
		}
		visited[1] = true;
		System.out.println(dfs(1)[0]);
		
	}

}
