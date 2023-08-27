import java.io.*;
import java.util.*;

public class Main {
	static public int N,L;
	static public int[][] field;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		field = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			for(int j=0;j<N;j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
		for(int i=0;i<N;i++) {
			int nowstair = field[i][0];
			int samestair = 1;
			int flag = 0;
			for(int j=1;j<N;j++) {
				if(field[i][j] != nowstair) {
					//층수 차이가 2층 이상인 경우
					if(Math.abs(field[i][j]-nowstair)>1) {
						//어차피 길 못만드니까 빠른 break
						flag = 1;
						break;
					}
					//층수 차이가 1층인 경우
					else {
						//층수가 올라가는 경우인지, 내려가는 경우인지 구분 필
						
						//층수가 올라갈 때
						if(field[i][j] == nowstair+1) {
							//만약 현재층의 받침이 L 보다 같거나 크다면 가능
							if(samestair >= L) {
								//현재 층수를 갱신하고, 같은 층수 타일을 1로 초기화
								nowstair = field[i][j];
								samestair = 1;
							}
							else {
								flag = 1;
								break;
							}
						}
						//층수가 내려갈 때
						else if(field[i][j] == nowstair-1) {
							int cnt = 0;
							for(int k=0;k<L;k++) {
								if(j+k<N && field[i][j+k] == nowstair-1) cnt++;
							}
							if(cnt != L) {
								flag = 1;
								break;
							}
							else if(cnt == L){
								nowstair = field[i][j];
								j = j+ L-1;
								samestair = 0;
							}
						}
					}
				}
				//층수 차이가 없는 경우
				else {
					samestair++;
				}
			}
			if(flag == 0) {
				ans++;
			}
		}
		//System.out.println(ans);
		
		
		for(int j=0;j<N;j++) {
			int nowstair = field[0][j];
			int samestair = 1;
			int flag = 0;
			for(int i=1;i<N;i++) {
				if(field[i][j] != nowstair) {
					//층수 차이가 2층 이상인 경우
					if(Math.abs(field[i][j]-nowstair)>1) {
						//어차피 길 못만드니까 빠른 break
						flag = 1;
						break;
					}
					//층수 차이가 1층인 경우
					else {
						//층수가 올라가는 경우인지, 내려가는 경우인지 구분 필
						
						//층수가 올라갈 때
						if(field[i][j] == nowstair+1) {
							//만약 현재층의 받침이 L 보다 같거나 크다면 가능
							if(samestair >= L) {
								//현재 층수를 갱신하고, 같은 층수 타일을 1로 초기화
								nowstair = field[i][j];
								samestair = 1;
							}
							else {
								flag = 1;
								break;
							}
						}
						//층수가 내려갈 때
						else if(field[i][j] == nowstair-1) {
							int cnt = 0;
							for(int k=0;k<L;k++) {
								if(i+k<N && field[i+k][j] == nowstair-1) cnt++;
							}
							if(cnt != L) {
								flag = 1;
								break;
							}
							else if(cnt == L){
								nowstair = field[i][j];
								i = i+ L-1;
								samestair = 0;
							}
						}
					}
				}
				//층수 차이가 없는 경우
				else {
					samestair++;
				}
			}
			if(flag == 0) {
				ans++;
			}
		}
		System.out.println(ans);
		br.close();
	}
}