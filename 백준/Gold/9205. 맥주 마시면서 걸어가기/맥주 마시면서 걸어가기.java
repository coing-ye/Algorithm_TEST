import java.io.*;
import java.util.*;

public class Main {

	public static int[] startpoint = new int[2];
	public static int[] endpoint = new int[2];
	public static int[][] cs;
	public static boolean[] visited;
	public static int n;
	
	public static int getdistance(int[] from, int[] to) {
		int distance = (int)(Math.abs(from[0]-to[0]) + Math.abs(from[1]-to[1]));
		return distance;
	}
	
	public static boolean dfs(int cnt, int[] now) {
		//System.out.println(Arrays.toString(now));
		if(getdistance(now,endpoint) <= 1000) {
			return true;
		}
		if(cnt == n) {
			return false;
		}
		for(int i = 0;i<n;i++) {
			if(visited[i] == true) continue;
			if(getdistance(now,cs[i]) > 1000) continue;
			visited[i] = true;
			if(dfs(cnt+1,cs[i])) return true;

			//visited[i]  = false;
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("res/D/random6.in"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc = 0;tc<T;tc++) {
			n = Integer.parseInt(br.readLine().trim());
			cs = new int[n][2];
			visited = new boolean[n];
			st = new StringTokenizer(br.readLine().trim()," ");
			startpoint[0] = Integer.parseInt(st.nextToken());
			startpoint[1] = Integer.parseInt(st.nextToken());
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine().trim()," ");
				cs[i][0] = Integer.parseInt(st.nextToken());
				cs[i][1] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine().trim()," ");
			endpoint[0] = Integer.parseInt(st.nextToken());
			endpoint[1] = Integer.parseInt(st.nextToken());
		
			//Arrays.sort(cs, (int[] o1, int[] o2)-> getdistance(startpoint,o1)-getdistance(startpoint,o2));
		
			if(dfs(0,startpoint)) System.out.println("happy");
			else System.out.println("sad");
//			if(flag == 0) sb.append("sad").append("\n");
//			else if(flag ==1) sb.append("happy").append("\n");
		}
		//System.out.println(sb);
	}

}