package math;
//943566
public class FindColumnname_excel {
	public static String convertToTitle(int A) {
        if(A==0){
            return "";
        }
        int div = A/26;
        int rem = A-(div*26);
        char[] st  = new char[1];
        st[0] = (char)('A'+rem);
        String curr = new String(st);
        return convertToTitle(div)+curr;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convertToTitle(943566));
	}

}
