import java.io.*;
import java.util.*;

public class Main {
	static int N,M,H;
	static int[][] laddermap;
	static ArrayDeque<Integer> ladder  = new ArrayDeque<>();
	static boolean[] visited;
	static int[] a,b;
	static int ls;
	static int ans = -1;
	
	public static void paintmap(int[] newladder,int val,int ll) {
		for(int i=0;i<ll;i++) {
			int r = (int)newladder[i]/(N-1);
			int c = 2*((int)newladder[i]%(N-1))+1;
			laddermap[r][c] = val;
		}
	}
	
	public static void subs(int cnt,int start, int cl) {
		if(cnt == cl) {
			//System.out.println(Arrays.toString(b));
			paintmap(Arrays.copyOf(b, cl),1,cl);
			//printmap();
//			System.out.println(countpath());
//			System.out.println("**************************");
			if(countpath() == N) {
				//System.out.println(Arrays.toString(b));
				//printmap();
				ans = cl;
			}
			paintmap(Arrays.copyOf(b, cl),0,cl);
			return;
		}
		for(int i=start;i<ls;i++) {
			if(visited[i]==true) continue;
			int flag = 0;
			//첫째 칸
			if (a[i]%(N-1)==0) {
				if(Arrays.binarySearch(Arrays.copyOf(b, cnt), a[i]+1)>=0) {
					flag = 1;
				}
			}
			else if(a[i]%(N-1)==(N-2)) {
				//System.out.println(Arrays.toString(b)+ " "+ a[i]);
				if(Arrays.binarySearch(Arrays.copyOf(b, cnt), a[i]-1)>=0) {
					flag = 1;
				}
			}
			else {
				if( (Arrays.binarySearch(Arrays.copyOf(b, cnt), a[i]-1)>=0) || (Arrays.binarySearch(Arrays.copyOf(b,cnt), a[i]+1)>=0)) {
					flag = 1;
				}
			}
			if(flag == 0) {
				b[cnt] = a[i];
				subs(cnt+1,i+1,cl);
				if(ans>-1) {
					break;
				}
			}
		}
		if(ans>-1) {
			return;
		}
	}
	
	public static int countpath() {
		int cnt = 0;
		for(int i =0;i<N;i++) {
			if((i*2) == destination(i*2)) {
				cnt ++;
			}
		}
		return cnt;
	}
	
	static public int destination(int start) {
		int des = start;
		int depth = 1;
		while(depth<H+1) {
			if(des+1 <2*N-1 && laddermap[depth-1][des+1] == 1) {
				des= des+2;
				depth++;
			}
			else if(des-1> 0 && laddermap[depth-1][des-1] == 1) {
				des = des-2;
				depth++;
			}
			else {
				depth++;
			}
		}
		return des;
	}
	
	public static void printmap() {
		for(int i = 0;i<H+1;i++) {
			System.out.println(Arrays.toString(laddermap[i]));
		}
		System.out.println("-----------------------");
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		laddermap = new int[H+1][2*N-1];
		for(int i = 0;i<M;i++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			laddermap[r-1][2*c-1] = 1;
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<H+1;j++) {
				laddermap[j][i*2] = 1;
			}
		}
//		printmap();
//		System.out.println();
		
		if (countpath() == N) {
			ans = 0;
			System.out.println(ans);
			return;
		}
		else {
			
			for(int i =0;i<(N-1)*H;i++) {
				int r = (int) i/(N-1);
				int c = 2*((int) i%(N-1))+1;
				if(laddermap[r][c] == 0) {
					int flag = 0;
					if(c-2>=0 && laddermap[r][c-2] == 1) {
						flag = 1;
					}
					if(c+2<2*N-1 && laddermap[r][c+2] == 1) {
						flag = 1;
					}
					if(flag == 0) {
						ladder.offerLast(i);
					}
				}
			}
			
			ls = ladder.size();
			a = new int[ls];
			for(int i=0;i<ls;i++) {
				a[i] = ladder.pollFirst();
			}
			visited = new boolean[ls];
			
			for(int i= 1;i<=3;i++) {
				b= new int[i];
				Arrays.fill(b, -1);
				subs(0,0,i);
				if(ans>-1) {
					break;
				}
			}
			
			System.out.println(ans);
		}
		
	}
}