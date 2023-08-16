import java.io.*;
import java.util.*;

public class Main {
	static int R,C,T;
	static int[][] room;
	static int airconu,aircond;
	static ArrayDeque<int[]> dust = new ArrayDeque<>();
	//이동방향 상우하좌
	static int[] di =  {-1,0,1,0};
	static int[] dj = {0,1,0,-1};
	
	public static void printroom() {
		for(int[] i:room) {
			System.out.println(Arrays.toString(i));
		}
		System.out.println("-----------------------");
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		room = new int[R][C];
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			for(int j= 0 ;j<C;j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0;i<R;i++) {
			if(room[i][0] == -1) {
				airconu = i;
				aircond = i+1;
				break;
			}
		}
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(room[i][j] > 0) {
					dust.offer(new int[] {i,j});
				}
			}
		}
		//printroom();
		for(int t = 0;t<T;t++) {
			//먼지 확산시키기
			//int ds = dust.size();
			int[][] plusdust = new int[R][C];
			while(!dust.isEmpty()) {
				int[] td = dust.pollFirst();
				int cnt = 0;
				int r = td[0];
				int c = td[1];
				//만약 이미 날아간 칸이면 그냥 빼기만
				if(room[r][c]>0) {
					for(int d = 0;d<4;d++) {
						int ni = r+ di[d];
						int nj = c+ dj[d];
						if(ni>=0 && ni<R && nj>=0 && nj<C && room[ni][nj]>=0) {
							cnt +=1;						
							plusdust[ni][nj] += (int)room[r][c]/5;
						}
					}
					room[r][c] = room[r][c] - ((int)(room[r][c]/5) * cnt);
				}
			}
			for(int i=0;i<R;i++) {
				for(int j = 0;j<C;j++) {
					room[i][j] += plusdust[i][j];
				}
			}
			//printroom();
			//공기청정기 가동
			//한칸씩 밀어낸다고 했으니, 끝칸부터 하나씩 빼고 그 전칸을 다음칸으로 옮기는 방식으로 적용
			
			//위쪽 공기청정기 작동
			for(int i = airconu-1;i>0;i--) {
				room[i][0] = room[i-1][0];
			}
			for(int j = 0;j<C-1;j++) {
				room[0][j] = room[0][j+1];
			}
			for(int i=0;i<airconu;i++) {
				room[i][C-1] = room[i+1][C-1];
			}
			for(int j = C-1;j>1;j--) {
				room[airconu][j] = room[airconu][j-1];
			}
			room[airconu][1] = 0;
			
			//아래쪽 공기청정기 작동
			for(int i = aircond+1;i<R-1;i++) {
				room[i][0] = room[i+1][0];
			}
			for(int j = 0;j<C-1;j++) {
				room[R-1][j] = room[R-1][j+1];
			}
			for(int i=R-1;i>aircond;i--) {
				room[i][C-1] = room[i-1][C-1];
			}
			for(int j = C-1;j>1;j--) {
				room[aircond][j] = room[aircond][j-1];
			}
			room[aircond][1] = 0;
			
			
			for(int i=0;i<R;i++) {
				for(int j = 0;j<C;j++) {
					if(room[i][j] > 0) {
						dust.offerLast(new int[] {i,j});
					}
				}
			}
			
			//printroom();
			//System.out.println("$$$$$$$$$$$$$$$$$$$$$$$");
		}
		int ans = 0;
		for(int i = 0 ;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(room[i][j] >0) {
					ans += room[i][j];
				}
			}
		}
		System.out.println(ans);
		
		
	}

}