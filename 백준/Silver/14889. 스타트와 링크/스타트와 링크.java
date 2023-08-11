import java.io.*;
import java.util.*;

public class Main {

	static int[][] status;
	static int N;
	static int[] a,b,c;
	static boolean[] v;
	static ArrayDeque<int[]> que= new ArrayDeque<>();
	static ArrayDeque<int[]> subq = new ArrayDeque<>();
	
	public static void subs(int[] team, int cnt, int start) {
		if(cnt == 2) {
			//System.out.println(Arrays.toString(c));
			subq.offer(Arrays.copyOf(c, 2));
			return;
		}
		for(int i = start; i<N/2;i++) {
			if (v[i] == true) continue;
			v[i] = true;
			c[cnt] = team[i];
			subs(team,cnt+1,i+1);
			v[i] = false;
		}
		return;
	}
	
	public static void divide(int cnt, int start) {
		if(cnt==N/2) {
			//System.out.println(Arrays.toString(b));
			que.offer(Arrays.copyOf(b, b.length));
			return;
		}
		for(int i = start;i<N;i++) {
			if (v[i] == true) continue;
			v[i] = true;
			b[cnt] = a[i];
			divide(cnt+1,i+1);
			v[i] = false;
		}
		return;
	}
	
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		status = new int[N][N];
		
		//스탯표 입력 받기
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			for(int j=0;j<N;j++) {
				status[i][j]  = Integer.parseInt(st.nextToken());
			}
		}
		//분배 세트용 배열 만들기
		a = new int[N];
		b = new int[N/2];
		c = new int[2];
		v = new boolean[N];
		for(int i=0;i<N;i++) {
			a[i] = i;
		}
		
		divide(0,0);

		int ans = (int)Math.pow(10, 9);
		while(!que.isEmpty()) {
			int[] start = que.pollFirst();
			int[] link = que.pollLast();
			
			//스타트팀 시너지 더하기
			subs(start,0,0);
			int startnum = 0;
			while(!subq.isEmpty()) {
				int[] synergy = subq.poll();
				startnum += status[synergy[0]][synergy[1]] + status[synergy[1]][synergy[0]];
			}
			
			//링크팀 시너지 더하기
			subs(link,0,0);
			int linknum = 0;
			while(!subq.isEmpty()) {
				int[] synergy = subq.poll();
				linknum += status[synergy[0]][synergy[1]] + status[synergy[1]][synergy[0]];
			}
			
			int diff = Math.abs(startnum - linknum);
			ans = Math.min(ans, diff);
			
		}
		System.out.println(ans);
		
	}

}
