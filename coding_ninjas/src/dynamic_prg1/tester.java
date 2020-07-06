package dynamic_prg1;



public class tester {

    public static void main(String[] args) throws Exception  {
    	String s1 = "abcd";
    	String s2 = "abcde";
    	int sum1 = 0;
    	int sum2 = 0;
    	for (int i = 0; i < s1.length(); i++) {
			sum1+=(int)s1.charAt(i);
		}
    	for (int i = 0; i < s2.length(); i++) {
			sum2+=(int)s2.charAt(i);
		}
    	System.out.println((char)Math.abs(sum1-sum2));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	//System.out.println(s1^s2);
    	
	}

}


