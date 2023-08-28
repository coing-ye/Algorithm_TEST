import java.io.*;
import java.util.*;

public class Main {
	
	static public ArrayDeque<Integer>[] gear = new ArrayDeque[4];
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i =0;i<4;i++) {
			st = new StringTokenizer(br.readLine().trim());
			String tmp = st.nextToken();
			gear[i] = new ArrayDeque<Integer>();

			for(int j=0;j<8;j++) {
				gear[i].offerLast(tmp.charAt(j)-'0');
			}
			gear[i].offerFirst(gear[i].pollLast());
			gear[i].offerFirst(gear[i].pollLast());
			
		}
		int K = Integer.parseInt(br.readLine().trim());
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			int mg = Integer.parseInt(st.nextToken())-1;
			int direc = Integer.parseInt(st.nextToken());
			//움직이는 기어들 판단
			boolean[] move = new boolean[4];
			move[mg] = true;
			ArrayList<Object[]> tl = new ArrayList<>();
			for(int d=0;d<4;d++) {
				tl.add(gear[d].toArray());
			}
			
			//오른쪽 부터
			for(int d = mg+1; d<4;d++) {
				if(tl.get(d)[0] == tl.get(d-1)[4]) break;
				else move[d] = true;
			}
			//왼쪽 탐색
			for(int d= mg-1;d>=0; d--) {
				if(tl.get(d)[4] == tl.get(d+1)[0]) break;
				else move[d] = true;
			}
			//System.out.println("Move gear: "+ mg+" moving gear: " + Arrays.toString(move));
			
			//이제 움직여야할 톱니바퀴들을 확인했으니 이동!
			int origindirec = direc;
			//오른쪽부터 돌리기!
			for(int d = mg+1;d<4;d++) {
				direc = direc*-1;
				if(move[d] == false) break;
				else {
					//시계방향 회전
					if(direc ==1) {
						gear[d].offerFirst(gear[d].pollLast());
					}
					//반시계 방향 회전
					else if(direc == -1) {
						gear[d].offerLast(gear[d].pollFirst());
					}
				}
			}			
			//왼쪽 돌리기!
			direc = origindirec;
			for(int d= mg-1;d>=0; d--) {
				direc = direc*-1;
				if(move[d] == false) break;
				else {
					//시계방향 회전
					if(direc ==1) {
						gear[d].offerFirst(gear[d].pollLast());
					}
					//반시계 방향 회전
					else if(direc == -1) {
						gear[d].offerLast(gear[d].pollFirst());
					}
				}
			}
			//현재 톱니바퀴 돌리기
			direc = origindirec;
			if(direc ==1) {
				gear[mg].offerFirst(gear[mg].pollLast());
			}
			//반시계 방향 회전
			else if(direc == -1) {
				gear[mg].offerLast(gear[mg].pollFirst());
			}
		}
		int score = 0;
		ArrayList<Object[]> tl = new ArrayList<>();
		for(int d=0;d<4;d++) {
			tl.add(gear[d].toArray());
		}
		for(int i=0;i<4;i++) {
			if((int)tl.get(i)[2] == 1) {
				score += (int)Math.pow(2, i);
			}
		}
		System.out.println(score);
		br.close();
	}

}