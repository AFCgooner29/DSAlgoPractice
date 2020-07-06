package tries;

import java.util.*;
class TrieNode{
	TrieNode children[] = new TrieNode[26];
    Set<String> l = new HashSet<>();
    TrieNode(Set<String> l){
		this.l = l;
    }
}
public class prad_copied_he {
   public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TrieNode head = new TrieNode(new HashSet<>());
        for(int i=0;i<n;i++){ 
            insert(head,sc.next()); 
        }
		int q = sc.nextInt();
        for(int i=0;i<q;i++){
        String s = sc.next();
            //flag = false;
        TrieNode node = query(head,s);
        if(node == null){
            System.out.println("No suggestions");
			insert(head,s);   
        }
        else { 
            TreeSet<String> set = new TreeSet<>(node.l); 
            set.stream().forEach(str->System.out.println(str)); 
        }
        }
        sc.close();
	}
 
    static void insert(TrieNode head, String s){
		TrieNode cur = head;
        for(int i=0;i<s.length();i++){
            int x = s.charAt(i) - 'a';
			if(cur.children[x] == null){
				cur.children[x] = new TrieNode(new HashSet<>());
            }
            cur.children[x].l.add(s);
            cur = cur.children[x];
        }
    }
    
    static TrieNode query(TrieNode head, String s){
		TrieNode cur = head;
        TrieNode ans = null;
        for(int i=0;i<s.length();i++){
           // System.out.println(s.charAt(i));
			int x =s.charAt(i) - 'a';
            if(cur.children[x] == null){
				//cur.children[x] = new TrieNode(new ArrayList<>());
               //cur.children[x];
                    break;
            }
            cur = cur.children[x];
            if(i == s.length()-1){ ans = cur;}
        }
        return ans;
    }
}