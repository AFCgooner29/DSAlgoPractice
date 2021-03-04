package september;

public class CompareversionNumbers {
	public static int compareVersion(String version1, String version2) {
		String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int maxLen = Math.max(v1.length , v2.length);
        for(int i=0; i<maxLen; i++){
            int k =0;
            int j =0;
            String v11 = "";
            String v22 = "";
            if(i<v1.length){
                while(k<v1[i].length() && v1[i].charAt(k)=='0')k++;
                v11 = v1[i].substring(k);
            }
            if(i<v2.length){
                while(j<v2[i].length() && v2[i].charAt(j)=='0')j++;
                v22 = v2[i].substring(j);
            }
            if(v11.isEmpty())v11 = "-1";
            if(v22.isEmpty())v22 = "-1";
            //now compare v11 and v22
            if(Integer.parseInt(v11)>Integer.parseInt(v22)){
                return 1;
            }
            else if(Integer.parseInt(v11)<Integer.parseInt(v22)){
                return -1;
            }
        }
        return 0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(compareVersion("1.0", "1"));
	}

}
