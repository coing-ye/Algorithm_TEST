import java.util.*;
import java.io.*;
public class Main {
	
	static int[] light;
	static int N;
	
	
	static public int checkdistance(int idx) {
		int cnt = 0;
		
		while(true) {
			cnt++;
			if((idx-cnt) < 1 || (idx+cnt)>N ) {
				cnt --;
				break;
			}
			else {
				if(light[idx-cnt] != light[idx+cnt]) {
					cnt--;
					break;
				}
			}
		}
		return cnt;
	}
	
	static public void changebulb(int idx, int distance) {
		if(distance>0) {
			if(idx-distance>0) {
				light[idx-distance] = light[idx-distance]^1;
			}
			if(idx+distance <=N) {
				light[idx+distance] = light[idx+distance]^1;
			}
		}
		else if(distance ==0) {
			light[idx] = light[idx]^1;
		}
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		// System.setIn(new FileInputStream("res/1244.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		//전구생성
		light  = new int[N+1];
		st = new StringTokenizer(br.readLine().trim()," ");
		for(int i=0;i<N;i++) {
			light[i+1] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine().trim());
		int S = Integer.parseInt(st.nextToken());
		

		for(int i=0;i<S;i++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			int Sung  = Integer.parseInt(st.nextToken());
			int ln = Integer.parseInt(st.nextToken());
			
			//남학생
			if(Sung ==1) {
				for(int j=1;j<=(int)(N/ln);j++) {
					changebulb(ln*j,0);
				}
			}
			//여학생
			else if(Sung ==2) {
				int dis = checkdistance(ln);
				for(int j=0;j<=dis;j++) {
					changebulb(ln, j);

				}
			}	
		}
		for(int j=1;j<=N;j++) {
			System.out.print(light[j] + " ");
			if((j%20) ==0){
				System.out.println();
			}
		}
	}

}
