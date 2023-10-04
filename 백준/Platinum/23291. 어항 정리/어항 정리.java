import java.util.*;
import javax.swing.plaf.synth.SynthSeparatorUI;

import java.io.*;

public class Main {
	
	public static ArrayList<int[]> bowl = new ArrayList<>();
	
	public static int bowlN =1;
	public static int bowlM =1;
	
	public static int N,K;
	public static PriorityQueue<Integer> pqb = new PriorityQueue<>(Collections.reverseOrder());
	public static PriorityQueue<Integer> pqs = new PriorityQueue<>();
	public static int[] origin;
	public static ArrayDeque<Integer> ad = new ArrayDeque<>();
	
	public static int[] di = {-1,0,1,0};
	public static int[] dj = {0,1,0,-1};
	
	public static int getsmallnum() {
		int smallnum = pqs.poll();
		pqs.offer(smallnum);
		return smallnum;
	}
	
	public static ArrayDeque<Integer> getsmallidx() {
		ArrayDeque<Integer> tmpad = new ArrayDeque<>();
		int smallnum = getsmallnum();
		for(int i=0;i<N;i++) {
			if(origin[i] == smallnum) {
				tmpad.offer(i);
			}
		}
		return tmpad;
	}
	
	public static int getdiff() {
		int diff = pqb.peek() - pqs.peek();
		return diff;
	}
	
	public static void rotatebowl() {
		for(int i=0;i<bowl.size();i++) {
			int x = bowl.get(i)[0];
			bowl.get(i)[0] = bowlN*(bowlM-((x%bowlM)+1))+(x/bowlM) + bowlN;
		}
		int tmp = bowlM;
		bowlM = bowlN;
		bowlN = tmp;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		origin = new int[N];
		for(int i=0;i<N;i++) {
			origin[i] = Integer.parseInt(st.nextToken());
			pqb.offer(origin[i]);
			pqs.offer(origin[i]);
		}
//		System.out.println("초기 입력 값");
//		System.out.println(Arrays.toString(origin));
		
		int ans = 0;
		while(getdiff() > K) {
			ans++;
//			System.out.println(ans);
			ArrayDeque tad = getsmallidx();
			while(!tad.isEmpty()) {
				origin[(int) tad.poll()] +=1;
			}
//			System.out.println(Arrays.toString(origin));
		
			for(int i=0;i<N;i++) {
				ad.add(origin[i]);
			}
			
			//가장 처음 bowl 삽입
			int front = ad.poll();
			bowl.add(new int[] {0,ad.poll()});
			bowl.add(new int[] {1,front});
			bowlN = 2;
			bowlM = 1;
			

			while(bowlN <= ad.size()) {
				rotatebowl();
				for(int i=0;i<bowlM;i++) {
					bowl.add(new int[] {i,ad.poll()});
				}	
				bowlN++;
			}
				
			
			int[][] reduce = new int[bowlN][bowlM];
			for(int i=0;i<bowl.size();i++) {
				int[] tt = bowl.get(i);
				reduce[bowlN - (tt[0]/bowlM)-1][tt[0]%bowlM] = tt[1];
			}
			
//			System.out.println(bowl.size());
//			for(int i=0;i<reduce.length;i++) {
//				System.out.println(Arrays.toString(reduce[i]));
//			}
			
			int[][] afterreduce = new int[bowlN][bowlM];
			
			
			for(int i=0;i<bowlN;i++) {
				for(int j=0;j<bowlM;j++) {
					for(int d= 0;d<4;d++) {
						int ni = i+di[d];
						int nj = j+dj[d];
						if(ni>=0 && ni<bowlN && nj>=0 && nj<bowlM) {
							if(reduce[i][j] > reduce[ni][nj]) {
								int minus = (reduce[i][j]-reduce[ni][nj])/5;
								afterreduce[i][j]+= -minus;
								afterreduce[ni][nj] += minus;
							}
						}
					}
				}
			}

			int[] floorreduce = new int[ad.size()];
			int[] floor = new int[ad.size()];
			
			for(int i=0;i<floor.length;i++) {
				floor[i] = ad.pollFirst();
			}
			if(floor.length>0) {
				if(floor[0] > reduce[bowlN-1][bowlM-1]) {
					afterreduce[bowlN-1][bowlM-1] += (floor[0]-reduce[bowlN-1][bowlM-1])/5;
					floorreduce[0] += -(floor[0]-reduce[bowlN-1][bowlM-1])/5;
				}
				else if(floor[0] < reduce[bowlN-1][bowlM-1]) {
					afterreduce[bowlN-1][bowlM-1] += -(reduce[bowlN-1][bowlM-1]-floor[0])/5;
					floorreduce[0] += (reduce[bowlN-1][bowlM-1]-floor[0])/5;
				}
			}
			for(int i=0;i<floor.length;i++) {
				int now = floor[i];
				if(i-1>=0) {
					int before = floor[i-1];
					if(now>before) {
						int minus = (now-before)/5;
						floorreduce[i] += -minus;
						floorreduce[i-1] += minus;
					}
				}
				if(i+1<floor.length) {
					int next = floor[i+1];
					if(now>next) {
						int minus = (now-next)/5;
						floorreduce[i] += -minus;
						floorreduce[i+1] += minus;
					}
				}
			}
			
			for(int i=0;i<bowlN;i++) {
				for(int j=0;j<bowlM;j++) {
					reduce[i][j] += afterreduce[i][j];
				}
			}
			
			for(int i=0;i<floor.length;i++) {
				floor[i] += floorreduce[i];
			}
			
			
			for(int j=0;j<bowlM;j++) {
				for(int i=bowlN-1;i>=0;i--) {
					ad.offerLast(reduce[i][j]);
				}
			}
			for(int i=0;i<floor.length;i++) {
				ad.offerLast(floor[i]);
			}

			
			int[] fa = new int[N];
			int[][] sa = new int[2][N/2];
			int[][] la = new int[4][N/4];
			
			int idx=0;
			while(!ad.isEmpty()) {
				fa[idx++] = ad.pollFirst();
			}
			
			for(int i=0;i<N;i++) {
				if(i<N/2) {
					sa[0][N/2-i-1] = fa[i];
				}
				else {
					sa[1][i%(N/2)] =fa[i];
				}
			}
			
			
			for(int i=0;i<2;i++) {
				for(int j=0;j<N/4;j++) {
					la[2-1-i][N/4-1-j] = sa[i][j];
					la[2+i][j] = sa[i][N/4+j];
				}
			}
			
			int[][] finalreduce = new int[4][N/4];
			for(int i=0;i<4;i++) {
				for(int j=0;j<N/4;j++) {
					for(int d=0;d<4;d++) {
						int ni = i+di[d];
						int nj = j+dj[d];
						if(ni>=0 && ni <4 && nj>=0 &&nj<N/4) {
							if(la[i][j] > la[ni][nj]) {
								int minus = (la[i][j]-la[ni][nj])/5;
								finalreduce[i][j] += -minus;
								finalreduce[ni][nj] += minus;
							}
						}
					}
				}
			}
			
			for(int i=0;i<4;i++) {
				for(int j=0;j<N/4;j++) {
					la[i][j] += finalreduce[i][j];
				}
			}
			
			ad.clear();
			pqb.clear();
			pqs.clear();
			bowl.clear();
			for(int j=0;j<N/4;j++) {
				for(int i=3;i>=0;i--) {
					origin[j*4+(3-i)] = la[i][j];
					pqb.add(la[i][j]);
					pqs.add(la[i][j]);
				}
			}
//			System.out.println(Arrays.toString(origin));
//			System.out.println("--------------------------------");
			//break;
			
		}
		System.out.println(ans);
	}

}