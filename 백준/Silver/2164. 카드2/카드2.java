import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		ArrayDeque<Integer> cardset = new ArrayDeque<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		for(int i=1;i<=N;i++) {
			cardset.offerLast(i);
		}
		while(cardset.size()>1) {
			cardset.poll();
			
			int changecard = cardset.poll();
			cardset.offerLast(changecard);
			//System.out.println(cardset);
		}
		System.out.println(cardset.peekFirst());
	}

}
