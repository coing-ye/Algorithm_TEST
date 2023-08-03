import java.util.*;
import java.io.*;

public class Main{

	public static int change(String s) {
		int chg = 0;
		
		if (s.equals("A")) {
			chg = 0;
		}
		else if(s.equals("C")) {
			chg = 1;
		}
		else if(s.equals("G")) {
			chg = 2;
		}
		else if(s.equals("T")) {
			chg = 3;
		}
		return chg;
	}
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		String[] dna = new String[S];
		st = new StringTokenizer(br.readLine().trim());
		String tmp = st.nextToken();
		for(int i=0;i<S;i++) {
			dna[i] = Character.toString(tmp.charAt(i));
		}
		//ACGT
		int[] cnt = new int[4];
		st = new StringTokenizer(br.readLine().trim()," ");
		for(int i=0;i<4;i++) {
			cnt[i] = Integer.parseInt(st.nextToken());
		}
		int[] acgt = new int[4];
		Arrays.fill(acgt, 0);
		
		String last = "";
		int anw=0;
		for(int i=0;i<=S-P;i++) {
			if(i==0) {
				for(int j=0;j<P;j++) {
					acgt[change(dna[j])] +=1;
				}
				last = dna[i];
			}
			else {
				acgt[change(last)] -=1;
				last = dna[i];
				acgt[change(dna[i+P-1])] +=1;
			}
			if(acgt[0] >= cnt[0] && acgt[1] >= cnt[1] && acgt[2]>=cnt[2] && acgt[3] >= cnt[3]) {
				anw+=1;
			}
		}
		System.out.println(anw);
	}

}