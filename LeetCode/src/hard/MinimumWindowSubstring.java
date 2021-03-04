package hard;

import java.util.HashMap;

public class MinimumWindowSubstring {
	public static String minWindow(String A, String B) {
        HashMap<Character,Integer> hashMap = generateHash(B);
        int i = 0;
        int j = hashMap.size();
        String ans = "";
        HashMap<Character,Integer> temp = generateHash(A.substring(i,j));
        while(j<=A.length()){
            //HashMap<Character,Integer> temp = generateHash(A.substring(i,j));
            int strikes = 0;
            System.out.println(temp);
            for(Character z : temp.keySet()){
                if(hashMap.containsKey(z) && hashMap.get(z)<=temp.get(z))strikes++;
            }
            if(strikes==hashMap.size()){
                if(ans.equals("") || ans.length()>(j-i))
                    ans = A.substring(i,j);
                if(temp.get(A.charAt(i))==1)temp.remove(A.charAt(i));
                else temp.put(A.charAt(i), temp.get(A.charAt(i))-1);
                i++;
            }
            else if(strikes<hashMap.size() || (j-i)<hashMap.size()){
                j++;
                if(j<=A.length())
                	temp.put(A.charAt(j-1),temp.getOrDefault(A.charAt(j-1), 0)+1);
            }
        }
        return ans;
    }
    public static HashMap<Character,Integer> generateHash(String S){
        HashMap<Character,Integer> hashMap = new HashMap<Character,Integer>();
        for(char i : S.toCharArray()){
            if(!hashMap.containsKey(i)){
                hashMap.put(i,1);
                continue;
            }
            hashMap.put(i,hashMap.get(i)+1);
        }
        return hashMap;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minWindow("ADOBECODEBANC","ABC"));
		/*
		 * "ADOBECODEBANC"
"ABC"
		 */
	}

}
