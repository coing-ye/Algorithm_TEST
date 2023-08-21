import java.io.*;
import java.util.*;

public class Main {

	public static char[][] road;
	public static int N,M;
	public static int nr,nc;
	public static int huboi, huboj;
	public static int[] di = {-1,0,1,0}; //상우하좌
	public static int[] dj = {0,1,0,-1};
	public static int direction = -1;
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		

			st = new StringTokenizer(br.readLine().trim()," ");
			N  = Integer.parseInt(st.nextToken());
			M  = Integer.parseInt(st.nextToken());
			road = new char[N][M];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine().trim());
				String tmp = st.nextToken();
				for(int j=0;j<M;j++) {
					road[i][j] = tmp.charAt(j);
					//집 좌표(출발 좌표)를 미리 저장
					if(road[i][j] == 'M') {
						nr = i;
						nc = j;
					}
					
					//홈 바로 옆에 칸이 지워질 경우를 대비해 Z위치를 후보로 저장
					else if(road[i][j] == 'Z') {
						huboi = i;
						huboj = j;
					}
				}
			}
			
			
			//처음에 시작점을 잡는 부분.
			for(int i=0;i<4;i++) {
				int ni = nr + di[i];
				int nj = nc + dj[i];
				if(ni>=0 && ni<N && nj>=0 && nj<M && road[ni][nj] != '.') {
					if(i==0) {
					//윗방향일 때 갈 수 있는 칸이 있다면
						if(road[ni][nj] == '|' || road[ni][nj] == '+' || road[ni][nj] == '1' || road[ni][nj] == '4') {
							nr = ni;
							nc = nj;
							direction = i;
							break;
						}
					}
					//우측 방향일때 갈 수 있는 칸이 있다면
					else if(i==1) {
						if(road[ni][nj] == '-' || road[ni][nj] == '+' || road[ni][nj] == '3' || road[ni][nj] == '4') {
							nr = ni;
							nc = nj;
							direction = i;
							break;
						}
						
					}
					//아랫 방향일때 갈 수 있는 칸이 있다면
					else if(i==2) {
						if(road[ni][nj] == '|' || road[ni][nj] == '+' || road[ni][nj] == '2' || road[ni][nj] == '3') {
							nr = ni;
							nc = nj;
							direction = i;
							break;
						}
						
					}
					//좌측 방향일 때 칼 수 있는 칸이 있다면
					else if(i==3) {
						if(road[ni][nj] == '-' || road[ni][nj] == '+' || road[ni][nj] == '1' || road[ni][nj] == '2') {
							nr = ni;
							nc = nj;
							direction = i;
							break;
						}
					}
				}
			}
			//홈 주변에 이어진 도로가 하나도 없을때. 즉, 홈 주변 4칸 중 하나가 지워졌을때.
			if(direction == -1) {
				
			}

			
			while(road[nr][nc] != '.') {
				char block = road[nr][nc];
				//만약 현재 블록이 지워진 블록이 아니라면
				//얘들은 방향 변화 X
				if(block == '|' || block =='-' || block == '+') {
					
				}
				else if(block == '1') {
					//좌측에서 들어온다면 방향을 아래로 전환
					if(direction == 3) {
						direction = 2;
					}
					//아래쪽에서 윗방향으로 들어온다면 방향을 오른쪽으로 전환
					else if(direction == 0) {
						direction = 1;
					}
				}
				else if(block =='2') {
					//위에서 아래로 들어온다면 방향을 우측으로 전환
					if(direction == 2) {
						direction = 1;
					}
					//오른쪽에서 좌측으로 들어온다면 방향을 위쪽으로 변환
					else if(direction == 3) {
						direction = 0;
					}
					
				}
				else if(block =='3') {
					//왼쪽에서 오른쪽 방향으로 들어온다면 방향을 위쪽으로 전환
					if(direction == 1) {
						direction = 0;
					}
					//위쪽에서 아래방향으로 들어온다면 방향을 좌측으로 전환
					else if(direction == 2) {
						direction = 3;
					}
					
				}
				else if(block =='4') {
					//왼쪽에서 우측방향으로 들어온다면 방향을 아래로 전환
					if(direction == 1) {
						direction = 2;
					}
					//아래에서 위쪽방향으로 들어온다면 뱡향을 왼쪽으로 전환
					else if(direction == 0) {
						direction = 3;
					}
				}
				//전환된 방향으로 이동
				nr = nr + di[direction];
				nc = nc + dj[direction];
			}
			
			//현재점이 지워진 블록 이라면
			int blocknum = 0;
			char lostblock = '.';
			for(int i =0; i<4;i++) {
				//지금까지 진행해온 방향이 아닌곳만 검사
				//즉 현재 내 진행방향이 1(우)라면, 3(좌)는 검사 X
				if(Math.abs(direction-i)!=2) {
					int ni = nr + di[i];
					int nj = nc + dj[i];
					if(ni>=0 && ni< N && nj>=0 && nj<M && road[ni][nj] != '.') {
						//위쪽 방향에 블록이 존재할때
						if(i == 0) {
							if(road[ni][nj] == '|' || road[ni][nj] == '+' || road[ni][nj] == '1' || road[ni][nj] == '4') {
								if(direction == 0) {
									lostblock = '|';
								}
								else if(direction == 1) {
									lostblock = '3';
								}
								else if(direction == 3) {
									lostblock = '2';
								}
								blocknum++;
							}
						}
						//우측 방향에 블록이 존재할때
						else if(i==1) {
							if(road[ni][nj] == '-' || road[ni][nj] == '+' || road[ni][nj] == '3' || road[ni][nj] == '4') {
								if(direction == 0) {
									lostblock = '1';
								}
								else if(direction == 1) {
									lostblock = '-';
								}
								else if(direction == 2) {
									lostblock = '2';
								}
								blocknum++;
							}
						}
						//아랫 방향에 블록이 존재할 때
						else if(i==2) {
							if(road[ni][nj] == '|' || road[ni][nj] == '+' || road[ni][nj] == '2' || road[ni][nj] == '3') {
								if(direction == 1) {
									lostblock = '4';
								}
								else if(direction == 2) {
									lostblock = '|';
								}
								else if(direction == 3) {
									lostblock = '1';
								}
								blocknum++;
							}
							
						}
						//좌측 방향에 블록이 존재할 때
						else if(i==3) {
							if(road[ni][nj] == '-' || road[ni][nj] == '+' || road[ni][nj] == '1' || road[ni][nj] == '2') {
								if(direction == 0) {
									lostblock = '4';
								}
								else if(direction == 2) {
									lostblock = '3';
								}
								else if(direction == 3) {
									lostblock = '-';
								}
								blocknum++;
							}
						}
					}
				}
			}
			if(blocknum ==3) {
				lostblock = '+';
			}
			sb.append(nr+1).append(" ").append(nc+1).append(" ").append(lostblock).append("\n");
		
		System.out.println(sb);
		
		br.close();
	}

}