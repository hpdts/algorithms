package accelerator;

import java.util.*;
import java.util.Queue;
import java.util.LinkedList;

public class ShortestPath{
	public static class Point{
		int x;
		int y;

		Point(int x, int y){

			this.x = x;
			this.y = y;
		}

		public int getX(){
			return x;
		}

		public int getY(){
			return y;
		}

		public String toString(){
			return x + "_" + y;
		}

		public boolean equals(Point point2){
			return this.x == point2.x && this.y == point2.y;
		}
	}

	class Node{
		Point point;
		int distance;

		Node(Point point, int distance){
			this.point = point;
			this.distance = distance;
		}

		public Point getPoint(){
			return point;
		}

		public int getDistance(){
			return distance;
		}
	}

	public int getSmallestSumDistance(int[][] input){
		List<Point> houses = getHouses(input);
		//System.out.println("houses: " + houses);
		int minSum = Integer.MAX_VALUE;
		for(int row = 0; row < input.length; row++){
			for(int col = 0; col < input[0].length; col++){
				Point origin = new Point(row, col);
				if(input[row][col] == 0){
					int sumDistance = 0;
					boolean reachAllHouses = true;
					//System.out.println("origin: " + origin);
					for(Point house : houses){
						int dist = shortestPath(input, origin, house);
						//System.out.println("house: " + house);
						//System.out.println("dist: " + dist);
						if(dist == -1){
							reachAllHouses = false;
							break;
						}else{
						 sumDistance+=dist;
						}
					}
					if(reachAllHouses){
						//System.out.println("origin: " + origin);
						//System.out.println("sumDistance: " + sumDistance);
						//System.out.println("minSum: " + minSum);
						minSum = Math.min(minSum, sumDistance);
					}
				}
			}
		}
		return minSum;
	} 

	public List<Point> getHouses(int[][] input){
		List<Point> houses = new ArrayList<>();
		for(int row = 0; row < input.length; row++){
			for(int col = 0; col < input[0].length; col++){
				if(input[row][col] == 1){
					houses.add(new Point(row, col));
				}
			}
		}
		return houses;
	}

	public int shortestPath(int[][] input, Point origin, Point destination){
		int rows = input.length;
		int cols = input[0].length;
		boolean[][] visited = new boolean[rows][cols];
		Queue<Node> queue = new LinkedList<>();
		Node node = new Node(origin, 0);
		queue.add(node);
		visited[origin.getX()][origin.getY()] = true;

		while (!queue.isEmpty()){
			Node currNode = queue.remove();
			//System.out.println("Point: " + currNode.getPoint());
			Point currPoint = currNode.getPoint();
			int currX = currPoint.getX();
			int currY = currPoint.getY();
			visited[currX][currY] = true;

			if(currPoint.equals(destination)){
				//get minimal
				return currNode.getDistance();
			}
			if(input[currX][currY] == 0){
				//left
				Point move = new Point(currX-1, currY);
				if(isValid(move, rows, cols) && !visited[move.getX()][move.getY()]){
					queue.add(new Node(move, currNode.getDistance() + 1));
				}
				//right
				move = new Point(currX+1, currY);
				if(isValid(move, rows, cols) && !visited[move.getX()][move.getY()]){
					queue.add(new Node(move, currNode.getDistance() + 1));
				}
				//up
				move = new Point(currX, currY+1);
				if(isValid(move, rows, cols) && !visited[move.getX()][move.getY()]){ 
					queue.add(new Node(move, currNode.getDistance() + 1));
				}
				//down
				move = new Point(currX, currY-1);
				if(isValid(move, rows, cols) && !visited[move.getX()][move.getY()]){
					queue.add(new Node(move, currNode.getDistance() + 1));
				}
			}
		}
		return -1;
	}       

	public boolean isValid(Point point, int rows, int cols){
		return point.getX() >= 0 && point.getY() >= 0
		       && point.getX() < rows && point.getY() < cols;
	}      


}