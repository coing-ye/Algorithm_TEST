import java.io.*;
import java.util.*;

public class Main {

	static int N, M, C;
	static int[] a , b;
	static boolean[] v;
	static void perm(int cnt) {
		if(cnt ==M) {
			//System.out.println(Arrays.toString(b));
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<M;i++) {
				sb.append(b[i]).append(" ");
			}
			System.out.println(sb);
			C++;
			return;
		}else {
			for(int i=0;i<N;i++) {
				if(v[i]) continue;
				v[i] = true;
				b[cnt] = a[i];
				perm(cnt+1);
				v[i] = false;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		a = new int[N];
		b = new int[M];
		v = new boolean[N];
		
		for(int i=0;i<N;i++) {
			a[i] = i+1;
		}
		
		
		C = 0;
		perm(0);
		//System.out.println(C);
	}

}