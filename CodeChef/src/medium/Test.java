package medium;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Object> sharan = new ArrayList<Object>();
		for (int j = 0; j < 11; j++) {
			sharan.add("{\"sharan"+j+"\" : \""+j+"\"}");
		}
		sharan.stream().forEach((c)-> System.out.println(c));
	}

}
