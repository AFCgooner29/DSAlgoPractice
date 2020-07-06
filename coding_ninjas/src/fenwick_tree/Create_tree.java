package fenwick_tree;
/*
 * #include<bits/stdc++.h>
using namespace std;


void update(int index,int value,int* BIT,int n){

	for(;index <= n;index += index&(-index)){
		BIT[index] += value;
	}
}

int query(int index,int* BIT){
	int sum=0;
	for(;index >0;index -= index&(-index)){
		sum += BIT[index];
	}
	return sum;
}
int main(){

	int n;
	cin >> n;

	int* arr = new int[n+1]();
	int* BIT = new int[n+1]();

	for(int i=1;i<=n;i++){
		cin >> arr[i];
		update(i,arr[i],BIT,n);
	}
	
	cout << "Sum of first 5 elements " << query(5,BIT) <<endl;
	cout << "Sum of elements from 2 index to 6 index " << query(6,BIT) - query(1,BIT) <<endl;
	return 0;
}
 */
import java.util.Arrays;
import java.util.Scanner;

public class Create_tree {
	public static void update_tree(int idx, int value, int[] BIT) {
		for (; idx < BIT.length; idx+= idx&(-idx)) {
			BIT[idx]+=value;
		}
	}
	public static int query(int idx, int[] BIT) {
		int ans = 0;
		for (; idx > 0; idx-= idx&(-idx)) {
			ans+=BIT[idx];
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		int[] arr = new int[n+1];
		int[] BIT = new int[n+1];
		Arrays.fill(BIT, 0);
		for (int i = 1; i < n; i++) {
			arr[i] = sf.nextInt();
			update_tree(i, arr[i], BIT);
		}
		System.out.println(query(2,BIT));
 		sf.close();
	}

}
