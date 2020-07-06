package medium;

public class Game_Of_Life {
	public static void getLive(int[][] board,int x,int y) {
		//check all the niegbours and give back live count
		int[] xmoves = null;	}
    public void gameOfLife(int[][] board) {
    	for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				int live = 0;//getLive(board,i,j);
				if(live<2 ||(board[i][j]==1 && live>3)) {
					board[i][j]=-1;
				}
				else if(board[i][j]==0 && live==3) {
					board[i][j]=2;
				}
			}
		}
    	for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if(board[i][j]==2) {
					board[i][j]=1;
				}
				else if(board[i][j]==-1) {
					board[i][j]=0;
				}
			}
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
