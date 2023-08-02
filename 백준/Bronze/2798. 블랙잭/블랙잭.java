import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
	
	static int N,M;
	static int[] arr, tmp;
	static boolean[] v;
	static int anw = 0;
	
	static public void perm(int cnt,int bsum) {
		if (cnt == 3) {
			//System.out.println(Arrays.toString(tmp)+ " "+ IntStream.of(tmp).sum());
			anw = Math.max(anw, IntStream.of(tmp).sum());
			return;
		}
		for(int i=0;i<N;i++) {
			if(v[i] == true) continue;
			v[i] = true;
			tmp[cnt] = arr[i];
			if(bsum+arr[i] <= M) {
				perm(cnt+1,bsum+arr[i]);
			}
			v[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("res/2805.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		v = new boolean[N];
		tmp = new int[3];
		
		st = new StringTokenizer(br.readLine().trim()," ");
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		perm(0,0);
		System.out.println(anw);
	}

}