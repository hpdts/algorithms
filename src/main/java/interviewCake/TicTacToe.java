package interviewCake;

import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Map.Entry;

public class TicTacToe{

	char[][] board = new char[3][3];

	public TicTacToe(){
		for(int i =0; i<board.length;i++){
			for(int j =0; j<board[0].length;j++){
				board[i][j] = '-';
			}
		}
	}

	public void addToken(char token, int x, int y){
		board[x][y] = token;
	}

	public void displayBoard(){
		for(int i =0; i<board.length;i++){
			for(int j =0; j<board[0].length;j++){
				//System.out.println("i:" +i);
				//System.out.println("j:" +j);
				if(j == 1){
					System.out.print("|" + board[i][j] + "|");
				}else{
					System.out.print(board[i][j]);
				}
				
			}
			System.out.println();
		}
	}

	public boolean isBoardFull(){
		for(int i =0; i<board.length;i++){
			for(int j =0; j<board[0].length;j++){
				//System.out.println("board[i][j]: " + board[i][j]);
				if(board[i][j] != 'X' && board[i][j] != 'O'){
					//System.out.println("ghere board[i][j]: " + board[i][j]);
					return false;
				}
			}
		}
		return true;
	}

	public void move(){
		if(isBoardFull()){
			throw new RuntimeException("The board is full");
		}
		for(int i =0; i<board.length;i++){
			for(int j =0; j<board[0].length;j++){
				if(board[i][j] == '-'){
					board[i][j] = 'O';
					return;
				}
			}
		}
	}
}
