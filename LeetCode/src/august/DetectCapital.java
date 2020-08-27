package august;

public class DetectCapital {
	public boolean detectCapitalUse(String word) {
        int count = 0;
        for(char i: word.toCharArray()){
            if(i==Character.toUpperCase(i)) {
            	count++;
            }
        }
        if((count==1 && word.charAt(0)==Character.toUpperCase(word.charAt(0))) || (count==word.length())||count==0) {
        	return true;
        }
        return false;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
