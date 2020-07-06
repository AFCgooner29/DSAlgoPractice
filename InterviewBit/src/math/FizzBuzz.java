package math;

import java.util.ArrayList;

public class FizzBuzz {
	public static ArrayList<String> fizzBuzz(int A) {
        ArrayList<String> ans = new ArrayList<String>();
        for(int i=0;i<=A;i++){
            ans.add(String.valueOf(i));
        }
        for(int i=3;i<=A;i=i+3){
            ans.set(i,"Fizz");
        }
        for(int i=5;i<=A;i=i+5){
            if(i%3==0){
                ans.set(i,"FizzBuzz");
            }
            else{
                ans.set(i,"Buzz");
            }
        }
        ans.remove(0);
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fizzBuzz(100));
	}

}
