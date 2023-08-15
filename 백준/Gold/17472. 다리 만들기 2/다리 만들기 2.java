import java.io.*;
import java.util.*;

public class Main {
	
	static int N,M;
	static int[][] imap;
	static boolean[][] visited;
	static int[] di = {-1,0,1,0};	//상우하좌
	static int[] dj = {0,1,0,-1};
	static int[][] bridgelong;
	static boolean[] islandvisit;
	static int ans = -1;
	static int[] parent;
	static int[][] connect;
	static int[] ip;
	static boolean[] uv;

	
	public static void makeparent(int start) {
		uv[start] = true;
		ArrayDeque<Integer> arr= new ArrayDeque<>();
		arr.offer(start);
		while(!arr.isEmpty()) {
			int now  = arr.poll();
			for(int i: connect[now]) {
				//같은 area 이어야만 유니온 갱신
				if(uv[i] == false && i>0) {
					uv[i] = true;
					arr.offer(i);
					//가장 앞쪽 노드를 부모노드로 갱신
					if(ip[now] < ip[i]) {
						ip[i] = ip[now];
					}
				}
			}
		}
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x<y) parent[y] = x;
		else parent[x] = y;
	}
	
	public static int find(int x) {
		if (parent[x] == x) return x;
		else return find(parent[x]);
	}
	
	public static void kruskal(int inum) {
		parent = new int[inum+1];
		PriorityQueue<int[]> kr = new PriorityQueue<>(new Comparator<int []>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if (o1[0]==o2[0]) {
					if(o1[1]==o2[1]) return o1[2]-o2[2];
					return o1[1]-o2[1];
				}
				return o1[0]-o2[0];
			}
		 });
		for(int i=1;i<=inum;i++) {
			for(int j= i;j<=inum;j++) {
				if(bridgelong[i][j] < 1000) {
					kr.offer(new int[] {bridgelong[i][j], i, j});
				}
			}
			parent[i] = i;
		}
		int cost = 0;
		while(!kr.isEmpty()) {
			int[] now = kr.poll();
			//System.out.println(Arrays.toString(now));
			if(find(now[1])!= find(now[2])) {
				cost += now[0];
				union(now[1],now[2]);
			}
		}
		if(cost ==0) cost = -1;
		ans = cost;
		
	}
	
	public static void printmap() {
		for(int i = 0;i<N;i++) {
			System.out.println(Arrays.toString(imap[i]));
		}
	}
	
	public static void makemap(int r, int c, int island) {
		visited[r][c] = true;
		imap[r][c] = island;
		ArrayDeque<int[]> arr = new ArrayDeque<>();
		arr.offer(new int[] {r,c});
		while(!arr.isEmpty()) {
			int[] ij = arr.poll();
			int i = ij[0];
			int j = ij[1];
			for(int d = 0; d<4;d++) {
				int ni = i+di[d];
				int nj = j+dj[d];
				if(ni>=0 && ni<N && nj>=0 && nj<M && visited[ni][nj] == false && imap[ni][nj]!=0) {
					visited[ni][nj] = true;
					imap[ni][nj] = island;
					arr.offer(new int[] {ni,nj});
				}
			}
		}
	}
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine().trim()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		imap = new int[N][M];
		visited =  new boolean[N][M]; 
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			for(int j=0;j<M;j++) {
				imap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int inum = 1;
		for(int i = 0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(visited[i][j] == false && imap[i][j] !=0) {
					makemap(i,j,inum++);
				}
			}
		}
		
		inum = inum-1;
		//printmap();
		int prev = 0;
		int bridge;
		bridgelong = new int[inum+1][inum+1];
		for(int i=0;i<=inum;i++) {
			Arrays.fill(bridgelong[i],1000);
		}


		//가로 다리 체크
		for(int i=0;i<N;i++) {
			int pi = -1;
			int ni = -1;
			bridge = 0;
			for(int j = 1;j<M;j++) {
				prev = imap[i][j-1];
				if(prev != imap[i][j]) {
					if(imap[i][j] ==0) {
						pi = prev;
					}
					else {
						if(pi !=-1) {
							if(bridge >1) {
								ni = imap[i][j];
								if(pi != ni) {
									//System.out.println(pi+ " "+ni+ " "+bridge);
									bridgelong[pi][ni] = Math.min(bridgelong[pi][ni], bridge);
									bridgelong[ni][pi] = Math.min(bridgelong[ni][pi], bridge);
								}
								
							}
							
							bridge = 0;
						}
					}
				}
				if(imap[i][j] ==0 && pi!=-1) {
					bridge ++;
				}
			}
		}
		
		//세로 다리 체크
		for(int j=0;j<M;j++) {
			int pj = -1;
			int nj = -1;
			bridge = 0;
			for(int i = 1;i<N;i++) {
				prev = imap[i-1][j];
				if(prev != imap[i][j]) {
					if(imap[i][j] ==0) {
						pj = prev;
					}
					else {
						if(pj !=-1) {
							if(bridge>1) {
								nj = imap[i][j];
								if(pj!=nj) {
									//System.out.println(pi+ " "+ni+ " "+bridge);
									bridgelong[pj][nj] = Math.min(bridgelong[pj][nj], bridge);
									bridgelong[nj][pj] = Math.min(bridgelong[nj][pj], bridge);
								}
								
							}
							bridge = 0;
						}
					}
				}
				if(imap[i][j] ==0 && pj!=-1) {
					bridge ++;
				}
			}
		}
		
		islandvisit = new boolean[inum+1];
		
		connect = new int[inum+1][inum+1];
		for(int i =1;i<=inum;i++) {
			int tmp =0;
			for(int j=1;j<=inum;j++) {
				if(bridgelong[i][j]<1000) {
					connect[i][tmp++] = j;
				}
			}
		}

//		for(int i = 0; i<=inum;i++) {
//			System.out.println(Arrays.toString(bridgelong[i]));
//		}
		
		ip = new int[inum+1];
		for(int i = 1;i<=inum;i++) {
			ip[i] = i;
		}
		uv = new boolean[inum+1];
		for(int i = 1;i<=inum;i++) {
			if(uv[i] == false) {
				makeparent(i);
			}
		}
		//System.out.println(Arrays.toString(ip));
		for(int i = 1;i<inum;i++) {
			if (ip[i] != ip[i+1]) {
				System.out.println("-1");
				return;
			}
		}
		kruskal(inum);
		System.out.println(ans);
		
		
	}

}