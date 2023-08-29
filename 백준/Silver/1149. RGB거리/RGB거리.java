import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int [][]  house = new int[N][3];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
			for(int j=0;j<3;j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 1; i<N;i++) {
			for(int j=0;j<3;j++) {
				int[] tmp = new int[2];
				int cnt = 0;
				for(int k=0;k<3;k++) {
					if (k!=j) tmp[cnt++] = house[i-1][k];
				}
				house[i][j] += Math.min(tmp[0], tmp[1]);
			}
		}

		int[] finalcost = Arrays.copyOf(house[N-1], 3);
		Arrays.sort(finalcost);
		System.out.println(finalcost[0]);
	}

}