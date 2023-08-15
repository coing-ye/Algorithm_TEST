import java.io.*;
import java.util.*;
public class Main {

	static int N;
	static int[][] connect;
	static int[] a,b;
	static int[] population, area,parent;
	static boolean[] visited;
	static int ans = 1000000000;
	static int chg = 0;
	static boolean[] unionv;
	
	public static void union(int start) {
		unionv[start] = true;
		ArrayDeque<Integer> arr= new ArrayDeque<>();
		arr.offer(start);
		while(!arr.isEmpty()) {
			int now  = arr.poll();
			for(int i: connect[now]) {
				if(unionv[i] == false && area[now] == area[i]) {
					unionv[i] = true;
					arr.offer(i);
					if(parent[now] < parent[i]) {
						parent[i] = parent[now];
					}
				}
			}
		}
	}
	
	public static void subs(int cnt,int start, int size) {
		if (cnt == size) {

			
			int[] anotherteam = new int[N-size];
			int cn = 0;
			//팀 구분. b팀은 1로, a팀은 0으로 표시
			for(int i=0;i<N;i++) {
				if (Arrays.binarySearch(b,i) >= 0) {
					area[i] = 1;
					
				}
				else {
					area[i] = 0;
					anotherteam[cn++] = i;
				}
			}
			//유니온 초기화
			for(int i=0;i<N;i++) {
				parent[i] = i;
			}
			unionv = new boolean[N];
			for(int i=0;i<N;i++) {
				if(unionv[i] == false) {
					union(i);
				}
			}
			
			int flag  = 0;
			for(int i = 0 ;i<size-1;i++) {
				if(parent[b[i]] != parent[b[i+1]]) {
					flag = 1;
					break;
				}
			}
			if (flag  == 0) {
				for(int i = 0; i<N-size-1;i++) {
					if(parent[anotherteam[i]] != parent[anotherteam[i+1]]) {
						flag = 1;
						break;
					}
				}
			}
			
			if(flag == 0) {
				//b팀의 인구수 합
				int pb = 0;
				for(int i :b) {
					pb += population[i];
				}
				int pa = 0;
				for(int i : anotherteam) {
					pa += population[i];
				}
				chg = 1;
				ans = Math.min(ans, Math.abs(pa-pb));
//				System.out.println(Arrays.toString(b) + " " + Arrays.toString(anotherteam));
//				System.out.println(Arrays.toString(area));
//				System.out.println(Arrays.toString(parent));
//				System.out.println(pb+ " "+pa+ " "+ Math.abs(pb-pa)+ "  "+ ans);
//				if(Math.abs(pb-pa)==15) {
//					System.out.println("**************************");
//				}
			}
			
			return;
		}
		for(int i=start;i<N;i++) {
			if(visited[i] == true) continue;
			visited[i] = true;
			b[cnt] = a[i];
			subs(cnt+1,i+1,size);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine().trim());
		population = new int[N];
		area = new int[N];
		parent = new int[N];
		a = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine().trim()," ");
		for(int i=0;i<N;i++) {
			population[i] = Integer.parseInt(st.nextToken());
			a[i]  = i;
			parent[i] = i;
		}

		connect = new int[N][];
	
		for(int i= 0 ; i<N;i++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			int cn = Integer.parseInt(st.nextToken());
			connect[i] = new int[cn];
			for(int j=0;j<cn;j++) {
				connect[i][j] = Integer.parseInt(st.nextToken())-1;
			}
			Arrays.sort(connect[i]);
		}
		for(int i=1;i<=(int)N/2;i++) {
			b = new int[i];
			subs(0,0,i);
		}
		if(chg == 0) ans = -1;
		System.out.println(ans);
	}

}
