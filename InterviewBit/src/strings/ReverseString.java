package strings;

public class ReverseString {
	public static String solve(String A) {
        if(A.isEmpty())return "";
        String[] al = A.split(" ");
        String ans = "";
        for(int i=al.length-1;i>-1;i--){
        	if(i==al.length-1) {
        		ans = al[i];
        	}
        	else {
        		ans = ans+" "+al[i];
        	}
        }
        return ans;
    }
	public static String solve2(String A) {
        if(A.isEmpty())return "";
		String ans = "";
		String temp = "";
		for (int i = A.length()-1; i >=0; i--) {
			if(A.charAt(i)==' ') {
				//space found
				ans=ans+temp+" ";
				temp = "";
			}
			else {
				temp =A.substring(i,i+1)+temp;
			}
		}
		ans=ans+temp;
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve2("Hello i am sharan"));
	}
}
