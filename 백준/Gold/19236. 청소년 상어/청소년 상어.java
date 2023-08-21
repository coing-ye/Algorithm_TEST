import java.io.*;
import java.util.*;

public class Main {
	public static HashMap<Integer,int[]> fishmap = new HashMap<Integer,int[]>();
	public static int[] shark = new int[] {0,0,0};
	//1번칸 부터 상 상좌 좌 하좌 하 하우 우 상우 순으로 설정
	public static int[] di = {0,-1,-1, 0, 1,1,1,0,-1};
	public static int[] dj = {0, 0,-1,-1,-1,0,1,1, 1};
	
	public static int N = 4;
	public static int[][][] sea = new int[N][N][2];
	
	public static int ans=0;
	
	public static int[][][] aftersharkeat(int[][][] beforesea) {
		int[][][] aftersea = new int[N][N][2];
		
		for(int i =0; i<4;i++) {
			for(int j=0;j<4;j++) {
				if(i==shark[0] && j==shark[1]) {
					aftersea[i][j][0] = 0;
					aftersea[i][j][0] = 0;
				}
				else {
					aftersea[i][j][0] = beforesea[i][j][0];
					aftersea[i][j][1] = beforesea[i][j][1];
				}
			}
		}
		return aftersea;
	}
	
	public static int changedirection(int r, int c, int d) {
		int direction = 0;
		
		for(int i=0; i<8;i++) {
			int test = d+i;
			if(test>8) {
				test = test -8;
			}
			int ni = r + di[test];
			int nj = c + dj[test];
			//System.out.println(ni+ " " + nj + " " +(ni!=shark[0] || nj!=shark[1]));
			if(ni>=0 && ni<N && nj>=0 && nj<N && (ni!=shark[0] || nj!=shark[1])) {
				direction = test;
				break;
			}
		}
		//System.out.println("==========");
		return direction;
	}
	
	public static int[][][] changesea(int[][][] beforesea) {
		int[][][] aftersea = new int[N][N][2];
		HashMap<Integer,int[]> fishmap = new HashMap<Integer,int[]>();
		for(int i = 0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(beforesea[i][j][0] != 0) {
					fishmap.put(beforesea[i][j][0], new int[] {i,j,beforesea[i][j][1]});
				}
			}
		}
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				aftersea[i][j][0] = beforesea[i][j][0];
				aftersea[i][j][1] = beforesea[i][j][1];
			}
		}
		
		for(int i=1;i<=16;i++) {
			int[] tmp = fishmap.get(i);
			if(tmp != null) {
				int nextdirection = changedirection(tmp[0],tmp[1],tmp[2]);
				
				if(nextdirection > 0) {
					int ni = tmp[0] + di[nextdirection];
					int nj = tmp[1] + dj[nextdirection];
					
					int changeloca = aftersea[ni][nj][0];
					int chgdirec = aftersea[ni][nj][1];
					
					fishmap.put(changeloca, new int[] {tmp[0],tmp[1],chgdirec});
					//System.out.println(changeloca+ " " + Arrays.toString(fishmap.get(changeloca)));
					
					fishmap.put(i, new int[] {ni,nj,nextdirection});
					//System.out.println(i+ " " + Arrays.toString(fishmap.get(i)));
					
					//System.out.println(i+ " " +changeloca);
					
					aftersea[ni][nj][0] = i;
					aftersea[ni][nj][1] = nextdirection;
					aftersea[tmp[0]][tmp[1]][0] = changeloca;
					aftersea[tmp[0]][tmp[1]][1] = chgdirec;
			
				}
			}
		}

		return aftersea;
	}
	
	public static void printsea(int[][][] ps) {
		StringBuilder sb = new StringBuilder();
		for(int i =0;i<N;i++) {
			for(int j = 0;j<N;j++) {
				sb.append("[").append(ps[i][j][0]).append(",").append(ps[i][j][1]).append("]").append(" ");
			}
			sb.append("\n");
		}
		sb.append("--------------------------------------");
		System.out.println(sb);
	}
	
	public static void game(int[][][] bs, ArrayList<int[]> sharkij,int eat) {
		if(sharkij.size() == 0) {
			//System.out.println(eat);
			ans = Math.max(ans, eat);
			return;
		}
		for(int i=0;i<sharkij.size();i++) {
			int[] hubo = sharkij.get(i);
			
			shark[0] = hubo[0];
			shark[1] = hubo[1];
			shark[2] = bs[hubo[0]][hubo[1]][1];
			//System.out.println( Arrays.toString(hubo) + " "+ shark[2]);
			int[][][] aftereat = aftersharkeat(bs);
			//printsea(aftereat);
			int[][][] aftersea = changesea(aftereat);
			//printsea(aftersea);
			game(aftersea,nextshark(aftersea),eat+bs[hubo[0]][hubo[1]][0]);
		}
	}
	
	public static ArrayList<int[]> nextshark(int[][][] bs){
		ArrayList<int[]> nxt = new ArrayList<>();
		int ni = shark[0] + di[shark[2]];
		int nj = shark[1] + dj[shark[2]];
		
		while(ni>=0 && ni<N && nj>=0 && nj <N) {
			if(bs[ni][nj][0] > 0) {
				nxt.add(new int[] {ni,nj});
			}
			ni = ni + di[shark[2]];
			nj = nj + dj[shark[2]];
		}
		return nxt;
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i = 0; i<4;i++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			for(int j = 0; j<4;j++) {
				int[] tmp = new int[2];
				//물고기 넘버
				tmp[0] = Integer.parseInt(st.nextToken());
				//물고기 방향
				tmp[1] = Integer.parseInt(st.nextToken());
				//HashMap 에 넣을 물고기 정보: {i,j,방향}
				sea[i][j][0] = tmp[0];
				sea[i][j][1] = tmp[1];
			}
		}
		//상어가 0,0 칸에 들어가서 해당 물고기 먹고 방향 전환
//		int eat = sea[0][0][0];
//		shark[2] = sea[0][0][1];
//		int[][][] eatafter = aftersharkeat(sea);
//		
//		int[][][] chgafter = changesea(eatafter);
//		printsea(chgafter);
		
		ArrayList<int[]> initlist = new ArrayList<>();
		initlist.add(new int[] {0,0});
		game(sea,initlist,0);
		System.out.println(ans);
	}

}