import java.util.*;

import org.omg.CosNaming.BindingIterator;

import java.io.*;
import java.math.BigInteger;

public class Main{ 
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		s= br.readLine().trim();
		int N = Integer.parseInt(s);
		BigInteger anw = new BigInteger("0");
		for(int i=1;i<N+1;i++) {
			int tmp = (int)(N/i)*i;
			BigInteger val = new BigInteger(Integer.toString(tmp));
			anw = anw.add(val);
		}
		System.out.println(anw);
	}

}
