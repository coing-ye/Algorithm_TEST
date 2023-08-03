import java.io.*;
import java.util.*;

public class Main{
	static int N, C= 0;
	static int[] sour;
	static int[] bitter;
	static boolean[] v;
	static int  anw = Integer.MAX_VALUE;
	
	static public void subs(int cnt) {
		if(cnt == N) {
			//System.out.println(Arrays.toString(v));
			int sv = 1;
			int bv = 0;
			for(int i=0;i<N;i++) {
				if(v[i] == true) {
					sv *= sour[i];
					bv += bitter[i];
				}
			}
			if(bv !=0) {
				anw = Math.min(anw, (int)Math.abs(sv-bv));
			}
			return;
		}else {
			v[cnt] = true;
			subs(cnt+1);
			v[cnt] = false;
			subs(cnt+1);
		}
		
	}
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		sour = new int[N];
		bitter = new int[N];
		v = new boolean[N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}
		
		subs(0);
		System.out.println(anw);
	}

}