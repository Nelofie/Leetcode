package Leetcode_79;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * For example, Given board =
 * 
 * [ ['A','B','C','E'], ['S','F','C','S'], ['A','D','E','E'] ] word = "ABCCED",
 * -> returns true, word = "SEE", -> returns true, word = "ABCB", -> returns
 * false.
 * 
 * @author Nelofie
 *
 */

public class Solution {
	public boolean exist(char[][] board, String word) {
		if(board==null){
			return false;
		}
		boolean[][] visited = new boolean[board.length][board[0].length];
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				if(board[i][j]==word.charAt(0)){
					if(dfs(board, visited, word, i, j)){
						return true;
					}
				}else{
					continue;
				}
			}
		}
		return false;
	}
	
	private boolean dfs(char[][] board,boolean[][] visited,String word,int i,int j){
		if(word.length()==0){
			return true;
		}
		if(i<0||i>board.length-1||j<0||j>board[0].length-1){
			return false;
		}
		if(visited[i][j]==true){
			return false;
		}
		if(board[i][j]!=word.charAt(0)){
			return false;
		}
			
		visited[i][j] = true;
		word = word.substring(1);
		boolean result = dfs(board, visited, word, i-1, j) ||
				dfs(board, visited, word, i+1, j) ||
				dfs(board, visited, word, i, j-1) ||
				dfs(board, visited, word, i, j+1);
		visited[i][j] = false;
		return result;
	}
}
