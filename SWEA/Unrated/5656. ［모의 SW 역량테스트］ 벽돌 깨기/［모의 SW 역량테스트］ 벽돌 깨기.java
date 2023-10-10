import java.io.*;
import java.util.*;

public class Solution {
	public static int T,N,H,W;
	public static ArrayList<Integer>[] mmap;
	public static int[][] inputmap;
	public static int[] loca;
	public static int[][] storemap;
	public static int[] di = {-1,0,1,0};
	public static int[] dj = {0,1,0,-1};
	public static boolean[][] visited;
	public static int[] maxh;
	public static boolean[] crushline;
	public static int answer = Integer.MAX_VALUE;
	
	public static int countremain() {
		int remain = 0;
		for(int h=0;h<H;h++) {
			for(int w=0;w<W;w++) {
				if(inputmap[h][w]>0) {
					remain++;
				}
			}
		}
		return remain;
	}
	
	public static int findpeek(int[][] nowmap, int w) {
		int peek = 0;
		for(int h =0; h<H;h++) {
			if(nowmap[h][w]>0) {
				peek = h;
				break;
			}
		}
		return peek;
	}
	
	public static void godown() {
		for(int w=0;w<W;w++) {
			if(crushline[w] == true) {
				mmap[w].clear();
				for(int h=H-1;h>=0;h--) {
					if(inputmap[h][w] >0) {
						mmap[w].add(inputmap[h][w]);
					}
				}
				for(int h=0;h<H;h++) {
					inputmap[h][w] = 0;
				}
				for(int h=0;h<mmap[w].size();h++) {
					inputmap[H-1-h][w] = mmap[w].get(h);
				}
			}
		}
	}
	
	public static void printmap() {
		for(int h=0;h<H;h++) {
			System.out.println(Arrays.toString(inputmap[h]));
		}
		System.out.println("----------------------------------");
	}
	
	public static void pung(ArrayList<int[]> nextboom) {
		for(int i=0;i<nextboom.size();i++) {
			int h = nextboom.get(i)[0];
			int w = nextboom.get(i)[1];
			inputmap[h][w] = 0;
			crushline[w] = true;
		}
	}
	
	public static ArrayList<int[]> boom(int h,int w) {
		visited[h][w] = true;
		ArrayDeque<int[]> ad = new ArrayDeque<>();
		ArrayList<int[]> boomlist = new ArrayList<>();
		ad.offer(new int[] {h,w});
		boomlist.add(new int[] {h,w});
		int point = 1;
		while(!ad.isEmpty()) {
			int[] now = ad.poll();
			for(int n=1;n< inputmap[now[0]][now[1]];n++) {
				point++;
				visited[h][w] = true;
				for(int d=0;d<4;d++) {
					int nh = now[0]+(di[d]*n);
					int nw = now[1]+(dj[d]*n);
					if(nh>=0 && nh<H && nw>=0 && nw<W && inputmap[nh][nw]>0) {
						if(visited[nh][nw]==true) continue;
						visited[nh][nw] = true;
						ad.offer(new int[] {nh,nw});
						boomlist.add(new int[] {nh,nw});
					}
				}
			}
		}
		return boomlist;
	}
	
	public static void perm(int cnt) {
		if(cnt == N) {
			//System.out.println(Arrays.toString(loca));
			answer = Math.min(answer, countremain());
			return;
		}
		for(int i = 0;i<W;i++) {
			loca[cnt] = i;
			
			int[][] storemap = new int[H][W];
			for(int h=0;h<H;h++) {
				storemap[h] = Arrays.copyOf(inputmap[h], W);
			}
			
			process(storemap,i);
					
			perm(cnt+1);
			
			for(int h=0;h<H;h++) {
				inputmap[h] = Arrays.copyOf(storemap[h], W);
			}
			
		}
		return;
	}
	
	public static void process(int[][] storemap, int w) {
		ArrayList<int[]> nextboom = boom(findpeek(storemap,w),w);
		crushline = new boolean[W];
		pung(nextboom);
		godown();
		visited = new boolean[H][W];
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for(int t = 1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			mmap = new ArrayList[W];
			inputmap = new int[H][W];
			storemap = new int[H][W];
			visited = new boolean[H][W];
			maxh = new int[W];
			loca = new int[N];
			for(int h=0;h<H;h++) {
				st = new StringTokenizer(br.readLine());
				for(int w=0;w<W;w++) {
					int n = Integer.parseInt(st.nextToken());
					inputmap[h][w] = n;
					mmap[w] = new ArrayList<>();
				}
			}
			answer = Integer.MAX_VALUE;
			sb.append("#").append(t).append(" ");
			perm(0);
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}

}
