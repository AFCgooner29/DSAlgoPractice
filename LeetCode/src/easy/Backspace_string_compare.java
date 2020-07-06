package easy;

public class Backspace_string_compare {
	public static boolean backspaceCompare(String S, String T) {
        int i = S.length()-1;
        int j = T.length()-1;
        int backa = 0;
        int backb = 0;
        while(i>=0 || j>=0) {
        	while(i>=0) {
        		if(S.charAt(i)=='#') {
        			backa++;
        			i--;
        		}
        		else if(backa>0) {
        			backa--;
        			i--;
        		}
        		else {
        			break;
        		}
        	}
        	while(j>=0) {
        		if(T.charAt(j)=='#') {
        			backb++;
        			j--;
        		}
        		else if(backb>0) {
        			backb--;
        			j--;
        		}
        		else {
        			break;
        		}
        	}
        	if(i>=0 && j>=0 && S.charAt(i)!=T.charAt(j)) {
        		return false;
        	}
        	if((i>=0)!=(j>=0)) {
        		return false;
        	}
        	i--;
        	j--;
        }
        
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(backspaceCompare("ab#c","ad#c"));
	}

}
