package backtracking;

import java.util.Scanner;

public class Crossword_problem {
	public static void horizreset(String[][] board,int x,int y,String words,String[] changed) {
		int counter = 0;
		for (int i = y; i < y+words.length(); i++) {
			if(!changed[counter].equals("F")) {
				board[x][i]="-";
			}
			
		}
	}
	public static void verireset(String[][] board,int x,int y,String words,String[] changed) {
		int counter = 0;
		for (int i = x; i < x+words.length(); i++) {
			if(!changed[counter].equals("F")) {
				board[i][y]="-";
			}
		}
	}
	public static boolean fillvertical(String[][] board,int x,int y,String words,String[] changed) {
		if(x+words.length()<=10) {
		int wrd_cnt = 0;
		for (int i = x; i < x+words.length(); i++) {
			if(board[i][y].equals("+") ) {//|| !board[x][i].equals(words.substring(wrd_cnt,wrd_cnt+1))) {
				return false;
			}
			else if(board[i][y].equals("-") || board[i][y].equals(words.substring(wrd_cnt,wrd_cnt+1)))
			{
				wrd_cnt++;
				continue;
			}
		else {return false;}
		}
		if(x+words.length()!=10 && board[x+words.length()][y].equals("-")) {
			return false;
		}
		wrd_cnt = 0;
		for (int i = x; i < x+words.length(); i++) {
			if(!board[i][y].equals("+")) {
				if(board[i][y].equals(words.substring(wrd_cnt,wrd_cnt+1))){
					changed[wrd_cnt]="F";
				}
				else {
					changed[wrd_cnt]="T";
				}
				board[i][y]=words.substring(wrd_cnt,wrd_cnt+1);
				wrd_cnt++;
				}
			}
		return true;
		}
		return false;
	}
	public static boolean fillhoriz(String[][] board,int x,int y,String words,String[] changed) {
		if(y+words.length()<=10) {
		int wrd_cnt = 0;
		for (int i = y; i < y+words.length(); i++) {
			if(board[x][i].equals("+") ) {//|| !board[x][i].equals(words.substring(wrd_cnt,wrd_cnt+1))) {
				return false;
			}
			else if(board[x][i].equals("-") || board[x][i].equals(words.substring(wrd_cnt,wrd_cnt+1)))
				{	
					wrd_cnt++;
					continue;
				}
			else {return false;}
		
			
		}
		if(y+words.length()!=10 && board[x][y+words.length()].equals("-")) {
			return false;
		}
		wrd_cnt = 0;
		for (int i = y; i < y+words.length(); i++) {
			if(!board[x][i].equals("+")) {
				if(board[x][i].equals(words.substring(wrd_cnt,wrd_cnt+1))) {
					changed[wrd_cnt]="F";
				}
				else {
					changed[wrd_cnt]="T";
				}
				board[x][i]=words.substring(wrd_cnt,wrd_cnt+1);
				wrd_cnt++;
				}
		}
		return true;
		}
		return false;
	}
	public static void crossword(String[][] board,String[] list,int word,String[] changed) {
		/*
		 * for (int i = 0; i < board.length; i++) { for (int j = 0; j < board.length;
		 * j++) { System.out.print(board[i][j]); } System.out.println(""); }
		 */
		if(word==list.length) {
			//print the board
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					System.out.print(board[i][j]);
				}
				System.out.println("");
			}
			return;
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if(board[i][j].equals("-") || board[i][j].equals(list[word].substring(0,1))) {
					if(fillhoriz(board, i, j, list[word],changed)) {
						crossword(board,list,word+1,changed);
						horizreset(board, i, j, list[word],changed);
					} else if(fillvertical(board, i, j, list[word],changed)) {
						crossword(board,list,word+1,changed);
						verireset(board, i, j, list[word],changed);
					}
				}
			}
		}
		
	
		return;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		String[][] board = new String[10][10];
		String[] changed = new String[10];
		for (int i = 0; i < board.length; i++) {
			board[i]=sf.next().split("");
		}       
		String s1 = sf.next();
		String[] list = s1.split(";");	
		crossword(board,list,0,changed);
		sf.close();
	}

}
