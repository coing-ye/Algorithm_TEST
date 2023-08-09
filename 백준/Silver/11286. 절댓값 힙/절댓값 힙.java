import java.io.*;
import java.util.*;


public class Main {
	
	static public class absnum implements Comparable<absnum>{
		int orin;
		int absn;
		public absnum(int ori, int ab) {
			this.orin = ori;
			this.absn = ab;
		}
		@Override
		public int compareTo(absnum o) {
			// TODO Auto-generated method stub
			if (this.absn > o.absn) {
				return 1;
			}
			else if(this.absn == o.absn) {
				if(this.orin >= o.orin) {
					return 1;
				}
				else {
					return -1;
				}
			}
			else {
				return -1;
			}
		}
		
		@Override
		public String toString() {
			return Integer.toString(orin);
		}
		
	}
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		PriorityQueue<absnum> pq = new PriorityQueue<>();
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());
		for(int i = 0; i<T;i++) {
			int inp = Integer.parseInt(br.readLine().trim());
			if (inp !=0) {
				int absn = Math.abs(inp);
				pq.offer(new absnum(inp,absn));
			}
			else {
				if(!pq.isEmpty()) sb.append(pq.poll()).append("\n");
				else sb.append(0).append("\n");
			}
		}
		System.out.println(sb);
	}

}