package strings;

public class ValidNumber {
    public void isNumber(final String A) {
    	int i = 0;
    	boolean dot = false;
    	boolean efound = false;
    	if(A.charAt(i)=='-')i++;
    	while(A.charAt(i)>='0' && A.charAt(i)<='9') {
    		i++;
    	}
    	if(i<A.length()) {
    		if(A.charAt(i)=='.' || A.charAt(i)=='e') {
    			
    		}
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
