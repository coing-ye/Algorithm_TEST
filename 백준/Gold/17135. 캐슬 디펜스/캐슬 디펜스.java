import java.util.*;
import java.io.*;
public class Main {
	static int P = 3;
	static int N,M,D;
	static int[][] range;
	static int[][] field;
	static int[] a,b;
	static int phase;
	static ArrayList<int[]> tower = new ArrayList<>();
	static int ans= 0;
	static int[][] storefield;
	
	public static int shoot(int[] nowarchor) {
		int kill = 0;

		int[] di = {0,-1,0}; //좌상하
		int[] dj = {-1,0,1};

		ArrayDeque<int[]> dis = new ArrayDeque<>();
		
		int d = 1;
		for(int ar:nowarchor) {
			dis.offerLast(new int[] {N-1,ar,d,ar});
		}
		int[] duty = new int [M];
		
		ArrayDeque<int[]> shootpoint = new ArrayDeque<>();
		while(!dis.isEmpty()) {
			int[] now = dis.pollFirst();
			//System.out.println(Arrays.toString(now));
			int r = now[0];
			int c = now[1];
			int nowdistance = now[2];
			if(duty[now[3]]==1) continue;
			if(field[r][c] ==1) {
				//field[r][c] = 0;
				//System.out.println("kill : " +r+" "+ c + " by "+ ar);
				duty[now[3]] = 1;
				shootpoint.offer(new int[]{r,c});
				continue;
			}
			for(int n=0;n<3;n++) {
				int ni = r+di[n];
				int nj = c+dj[n];
				if(ni>=0 && ni<N && nj>=0 && nj<M && nowdistance<D) {
					dis.offerLast(new int[] {ni,nj,nowdistance+1,now[3]});
				}
			}
			//System.out.println("?????????");
		}
		while(!shootpoint.isEmpty()) {
			int[] die = shootpoint.poll();
			if(field[die[0]][die[1]]==1) {
				field[die[0]][die[1]] = 0;
				kill += 1;
			}
		}
		return kill;
	}
	
	public static void enemydown() {
		for(int i = N-1;i>0;i--) {
			for(int j=0;j<M;j++) {
				field[i][j] = field[i-1][j];
			}
		}
		for(int j=0;j<M;j++) {
			field[0][j] = 0;
		}
	}

	
	public static void subs(int cnt,int start) {
		if(cnt ==P) {
			tower.add(Arrays.copyOf(b, 3));
			return;
		}
		for(int i = start;i<M;i++) {
			b[cnt] = a[i];
			subs(cnt+1,i+1);
		}
	}
	

	public static void printfield() {
		for(int i=0;i<N;i++) {
			System.out.println(Arrays.toString(field[i]));
		}
		System.out.println("------------------------");
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		range = new int[N][M];
		field = new int[N][M];
		storefield = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			for(int j=0;j<M;j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
				storefield[i][j] = field[i][j];
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if (field[i][j]==1) {
					phase = N-i;
					break;
				}
			}
			if(phase>0) {
				break;
			}
		}
		
		a= new int[M];
		b = new int[P];

		for(int i=0;i<M;i++) {
			a[i] = i;
		}
		subs(0,0);
		
		for(int i=0;i<tower.size();i++) {
			int[] now = tower.get(i);
			
			
//			System.out.println(Arrays.toString(now));
//			System.out.println("llllllllllllllllllll");
			for(int s=0;s<N;s++) {
				field[s] = Arrays.copyOf(storefield[s], M);
			}
			
			int tmp = 0;
			for(int p = 0; p<phase;p++) {
				tmp += shoot(now);
				//printfield();
				enemydown();
			}
//			System.out.println(tmp);
//			System.out.println("^^^^^^^^^^^^^^^^");
			ans = Math.max(ans, tmp);
			
			
			
		}
		System.out.println(ans);
	}

}
