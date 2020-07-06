package easy;

public class RemoveKDigits {
	public static String removeKdigits(String num, int k) {
        if(num.length()<=k){
            return "0";
        }
        StringBuilder sr = new StringBuilder(num);
        int i=0;
        while(k>0 && i<sr.length()-1){
            if(sr.charAt(i)>sr.charAt(i+1)) {
            	sr.replace(i, i+1, "");
            	k--;
            	i = Math.max(0, i-1);
            }
            else {
            	i++;
            }
            
        }
        
       	while(k>0) {
       		i = sr.length()-1;
       		sr.replace(i, i+1, "");
       		k--;
        }
        if(sr.length()==0)return "0";
        while(sr.charAt(0)=='0' && sr.length()>1) {
        	sr.replace(0, 1, "");
        }
        return new String(sr);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeKdigits("1234567890", 9));
	}

}
