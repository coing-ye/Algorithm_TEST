import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int[] tile;
		if(N<3) {
			tile = new int[3];
			tile[1] = 1;
			tile[2] = 3;
		}
		else {
			tile = new int[N+1];
			tile[1] = 1;
			tile[2] = 3;
			for(int n=3;n<=N;n++) {
				tile[n] = (tile[n-1] + 2*tile[n-2])%10007;
			}
		}
		System.out.println(tile[N]);
	}

}