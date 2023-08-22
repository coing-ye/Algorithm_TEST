import java.io.*;
import java.util.*;



public class Main {

		
	static int N;
	static int[][] sea;
	static int[] shark = new int[4];
	
	static int[] di = {-1,0,0,1}; // 상좌우하
	static int[] dj = {0,-1,1,0};
	
	static int ans = 0;
	
	
	public static int[] findnextfish() {
		int[] nextfish = new int[3];
		int distance = 1;
		boolean[][] visited = new boolean[N][N];
		ArrayDeque<int[]> que = new ArrayDeque<>();
		
		PriorityQueue<int[]> pque = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[2] != o2[2]) {
					return Integer.compare(o1[2], o2[2]);
				}
				else {
					if(o1[0] != o2[0]) {
						return Integer.compare(o1[0], o2[0]);
					}
					else {
						return Integer.compare(o1[1], o2[1]);
					}
				}
			}	
		});
		
		
		que.offer(new int[] {shark[0],shark[1],distance});
		nextfish[0] = shark[0];
		nextfish[1] = shark[1];
		nextfish[2] = 0;
		//System.out.println(shark[0]+" "+shark[1]+" "+distance);
		while(!que.isEmpty()) {
			int[] now = que.poll();
			//System.out.println(now[0] + " " + now[1] +" "+now[2]);
			for(int i=0;i<4;i++) {
				int ni = now[0] + di[i];
				int nj = now[1] + dj[i];
				if(ni>=0 && ni<N && nj>=0 && nj<N && sea[ni][nj] <= shark[2] && visited[ni][nj] == false) {
					visited[ni][nj] = true;
					if(sea[ni][nj] < shark[2] && sea[ni][nj]>0) {
						pque.offer(new int[] {ni,nj,now[2]});
					}
					que.offer(new int[] {ni,nj,now[2]+1});	
				}
			}
		}
		if(pque.size()>0) {
			nextfish = pque.poll();
		}


		return nextfish;
		
	}
	
	public static void printsea() {
		for(int i=0;i<N;i++) {
			System.out.println(Arrays.toString(sea[i]));
		}
		System.out.println("------------------------");
	}
	
	public static void eatfish(int[] destination) {
		ans += destination[2];
		sea[shark[0]][shark[1]] = 0;
		shark[3] ++;
		if(shark[3] == shark[2]) {
			shark[2] ++;
			shark[3] = 0;
		}
		shark[0] = destination[0];
		shark[1] = destination[1];
		sea[destination[0]][destination[1]] = shark[2];
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine().trim());
		sea = new int[N][N];
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine().trim()," ");
			for(int j=0;j<N;j++) {
				sea[i][j] = Integer.parseInt(st.nextToken());
				if (sea[i][j] == 9) {
					shark[0] = i;
					shark[1] = j;
					shark[2] = 2;
					shark[3] = 0;
				}
			}
		}
		//printsea();
		

		while(true){
			int[] nextij = findnextfish();
			if(nextij[0] == shark[0] && nextij[1] == shark[1]) {
				break;
			}
			eatfish(nextij);
//			printsea();
//			System.out.println("시간 : "+ ans + "s, 현재 상어 크기 : " +shark[2] + ", 지금 크기서 먹은 물고기 : "+ shark[3]);
//			System.out.println("====================");
		}
		//System.out.println("최종 시간 : "+ans);
		System.out.println(ans);
	}

}