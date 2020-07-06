package codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Overrandomize {
	public static void input(HashMap<Integer, HashMap<String, Integer>> hp,int u) {
		Scanner sf = new Scanner(System.in);
		StringBuilder ans = new StringBuilder(new Integer(10));
		for (int i = 0; i < 10; i++) {
			ans.append("0");
		}
		int counter = 0;
		while(true) {
			counter++;
			if(counter==10001) {
				break;
			}
			String s11= sf.nextLine();
			String[] arrr = s11.split(" ");
			int n = Integer.valueOf(arrr[0]);
			String s1 = arrr[1];
			if(hp.containsKey(n)) {
				if(!hp.get(n).containsKey(s1)) {
					hp.get(n).put(s1, 1);
				}
			}
			else {
				hp.put(n, new HashMap<String, Integer>());
				hp.get(n).put(s1, 1);
			}
			System.out.println(counter);
		}
		int i = 1;
		int decrementer = 1;
		while(i<10) {
			if(hp.get(i).size()==1) {
				decrementer =1;
				ans.replace(i,i+1, hp.get(i).keySet().iterator().next());
				i++;
			}
			else {
				int j = i-decrementer;
				
				for(String keys : hp.get(j).keySet()) {
					hp.get(i).remove(keys);
				}
				decrementer++;
			}
		}
		HashSet<String> hs = new HashSet<String>();
		for (int j = 0; j < ans.length(); j++) {
			hs.add(ans.substring(j,j+1));
		}
		while(i<10001) {
			if(hp.containsKey(i)) {
				for(String keys : hp.get(i).keySet()) {
					for(String temp : keys.split("")) {
						if(!hs.contains(temp)) {
							ans.replace(0, 1, temp);
						}
					}
				}
			}
			i++;
		}
		System.out.println("Case #"+u+": "+ans);
		sf.close();
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		InputStreamReader r=new InputStreamReader(System.in);    
	    BufferedReader br=new BufferedReader(r); 
		String nn = br.readLine();
		HashMap<Integer, HashMap<String, Integer>> hp = new HashMap<Integer, HashMap<String,Integer>>();
		input(hp,1);
		s.close();
	}

}
