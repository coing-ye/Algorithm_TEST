import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int[] tile = new int[N+1];
		if(N<=2) {
			System.out.println(N);
		}
		else {
			tile[1] = 1;
			tile[2] = 2;
			for(int n=3;n<=N;n++) {
				tile[n] = (tile[n-2] + tile[n-1])%10007;
			}
			System.out.println(tile[N]);
		}	
	}
}