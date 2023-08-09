import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] cmap = new int[100][100];
	static int space;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc = 1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
			int sj = Integer.parseInt(st.nextToken());
			int si = 99-Integer.parseInt(st.nextToken())-9;
			for(int i=0;i<10;i++) {
				for(int j=0;j<10;j++) {
					if (cmap[i+si][j+sj] != 1){
						cmap[i+si][j+sj] = 1;
						space +=1;
					}
				}
			}
		}
		System.out.println(space);
		
		
	}

}
