package medium;

public class String_to_Integer_atoi {
	public static int myAtoi(String str) {
		if(str.isEmpty())return 0;
        int i = 0;
        int mul = 1;
        int ans = 0;
        boolean isneg = false;
        //remove all the starting whitespace
        while(!str.isEmpty() && str.charAt(0)<'0' && str.charAt(0)>'9' && str.charAt(0)!='-') {
        	str = str.substring(1);
        }
        if(str.charAt(0)=='-') {
        	isneg = true;
        	str = str.substring(1);
        }
        while(i<str.length() && str.charAt(i)>='0' && str.charAt(i)<='9') {
        	i++;
        }
        if(i==0) {
        	return 0;
        }
        else {
        	str = str.substring(0,i);
        	for (int j = str.length()-1; j >= 0; j--) {
				ans = ans + mul*(str.charAt(j)-'0');
				mul*=10;
				if(ans>Integer.MAX_VALUE/10) {
					if(isneg)return Integer.MIN_VALUE;
					else return Integer.MAX_VALUE;
				}
			}
        }
        if(isneg)return ans - 2*ans;
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(myAtoi("9 202"));
	}

}
