package java8;

import java.util.*;
import static java.lang.Math.*;
import java.util.stream.*;

public class Java8 {

	static class Book{
	    String name;
	    int id;
	 	String description;
	 	public Book(int id, String name, String description){
	 		this.id = id;
	 		this.name = name;
	 		this.description = description;
	 	}

	 	public String toString(){
	 		return "id: " + id + ", name: " + name + ", description: " + description;
	 	}
	}

	static class Point{
		double x;
		double y;
		public Point(double x, double y){
			this.x = x;
			this.y = y;
		}

		public boolean equals(Object p) {
		    System.out.println("Testing equality.");
		    if(p instanceof Point){
		    	Point point = (Point) p;
		    	return this.x == point.x && this.y == point.y;
		    }else{
		    	return false;
		    }
		}

		public int hashCode(){
			System.out.println("hashing");
			return super.hashCode();
		}
	}

	public List<String> getBookNames(List<Book> books){
		List<String> names = books.stream().map(book -> book.name).collect(Collectors.toList());
		return names;
	}

	/*"""
	- If the cell is alive: if it has 2 or 3 alive neighbors, 
	it stays alive. Otherwise, it dies.
	- If the cell is dead: if it has exactly 3 alive neighbors, 
	it becomes alive. Otherwise, it stays dead.
	- The state of each cell is determined only by the state of 
	its neighbors in the last iteration.
	"""

	neighbors a = d,a,d state = d
	a,d,d =>  d, a, d 
	a,d,a     d, a, d
	     0 1 2
  0// d d d  => d,a,
  1// a a a
  2// a a a
  */

  public char[][] getNextState(char[][] board){
    char[][] newBoard = new char[board.length][board[0].length];
    for(int i=0;i < board.length;i++){
      for(int j=0; j < board[0].length; j++){
        char cell = board[i][j]; //d
        System.out.println("i: " + i + ", j: " + j + ", cell: " + cell);
        if(cell == 'a'){ 
        	if(containsTwoOrThreeNeighborsAlive(board ,i, j)){
          		newBoard[i][j] = 'a';
	        }else{
	          	newBoard[i][j] = 'd';
	      	}
        }else if(cell == 'd'){
        	if(containsThreeNeighborsAlive(board, i, j)){
          		newBoard[i][j] = 'a';
	        }else{
	          	newBoard[i][j] = 'd';	
	        }
      	}
      }  
    }
    return newBoard;
  }
 
  public boolean containsThreeNeighborsAlive(char[][] board, int rowIndex, int columnIndex){
    List<Character> neighbors = getNeighbors(board, rowIndex, columnIndex);
    System.out.println("neighbors: " + neighbors.toString());
    int countAlive = 0;
    for(char neighbor : neighbors){
      if(neighbor == 'a'){
        countAlive++;
      }
    }
    return countAlive == 3;
  }

  public boolean containsTwoOrThreeNeighborsAlive(char[][] board, int rowIndex, int columnIndex){
    List<Character> neighbors = getNeighbors(board, rowIndex, columnIndex);
    System.out.println("neighbors: " + neighbors.toString());
    int countAlive = 0;
    for(char neighbor : neighbors){
      if(neighbor == 'a'){
        countAlive++;
      }
    }
    return countAlive == 3 || countAlive == 2;
  }
  
  public List<Character> getNeighbors(char[][] board, int rowIndex, int columnIndex){
    List<Character> neighbors = new ArrayList<>();

    if(rowIndex + 1 < board.length){
      neighbors.add(board[rowIndex + 1][columnIndex]);//1,1=A
    }
    
    if(rowIndex - 1 >= 0){
      neighbors.add(board[rowIndex - 1][columnIndex]);
    }
    
    if(columnIndex + 1 < board[0].length){
      neighbors.add(board[rowIndex][columnIndex + 1]);//0,2=d
      
    }

    if(columnIndex - 1 >= 0){
      neighbors.add(board[rowIndex][columnIndex - 1]);//0,0 = d
      
    }
    
    if(rowIndex + 1 < board.length && columnIndex + 1 < board[0].length){
      neighbors.add(board[rowIndex + 1][columnIndex + 1]);//1,2=a
      
    }
    
    if(rowIndex - 1 >= 0  && columnIndex + 1 < board[0].length){
      neighbors.add(board[rowIndex - 1][columnIndex + 1]);
      
    }
    
    if(rowIndex - 1 >= 0 && columnIndex - 1 >= 0){
      neighbors.add(board[rowIndex - 1][columnIndex - 1]);
      
    }

    if(rowIndex + 1 < board.length && columnIndex - 1 >= 0){
      neighbors.add(board[rowIndex + 1][columnIndex - 1]);//1,0= a
      
    }
    return neighbors;
  }

  private void solve(int[][] sudoku, int index){
        int size = sudoku.length;
        if(index == size * size){
            if(isSolution(sudoku)){
                System.out.println("Found a solution via very naive algorithm: " + Arrays.deepToString(sudoku));
            }
        } else{
            int row = index / size;
            int col = index % size;
            if(sudoku[row][col] != 0){ // the square is already filled in, don't do anything 
                solve(sudoku, index + 1);
            } else{
                for(int i = 1; i <= 9; i++){
                    sudoku[row][col] = i;
                    solve(sudoku, index + 1); // continue with the next square
                    sudoku[row][col] = 0; // unmake move
                }
            }
        }
    }

    private boolean isSolution(int[][] sudoku){
        final int N = 9;
        final int side = 3;
        boolean[] mask = new boolean[N+1];
        
        // Check rows
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                int num = sudoku[i][j];
                if(mask[num]) return false;
                mask[num] = true;
            }
            Arrays.fill(mask,false);
        }
        
        // Check columns
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                int num = sudoku[j][i];
                if(mask[num]) return false;
                mask[num] = true;
            }
            Arrays.fill(mask,false);
        }
        
        // Check subsquares
        
        for(int i = 0; i < N; i += side){
            for(int j = 0; j < N; j+= side){
                Arrays.fill(mask,false);
                for(int di = 0; di < side; di++){
                    for(int dj = 0; dj < side; dj++){
                        int num = sudoku[i+di][j+dj];
                        if(mask[num]) return false;
                    }
                }
            }
        }
        
        return true; // Everything validated!
    }

  public boolean isSudoku(int[][] board){
      boolean columns = areColumnsFromOnetoNine(board);
      boolean rows = areRowsFromOnetoNine(board);
      boolean grids = areGridsFromOnetoNine(board);
      return columns && rows;
  }

  public boolean areGridsFromOnetoNine(int[][] board){
    int rows = board.length;
    int columns = board[0].length;
    //starting points
    for(int row = 0; row < rows; row+=3){
      for(int column = 0; column < columns; column+=3){
        //System.out.println("start row: " + row + ", column: " + column);
        //System.out.println("end row: " + (row+3) + ", column: " + (column+3));
        checkGridFromOneToNine(row, column, row + 3, column + 3, board);
      }
    }
    return false;

  }

  public boolean checkGridFromOneToNine(int rowOrigin, int columnOrigin, int rowEnd, int columnEnd, int[][] board){
     List<Integer> numberOnetoNine = new ArrayList<>();
      numberOnetoNine.add(1);
      numberOnetoNine.add(2);
      numberOnetoNine.add(3);
      numberOnetoNine.add(4);
      numberOnetoNine.add(5);
      numberOnetoNine.add(6);
      numberOnetoNine.add(7);
      numberOnetoNine.add(8);
      numberOnetoNine.add(9);

    for(int row = rowOrigin; row < rowEnd; row+=1){
      for(int column = columnOrigin; column < columnEnd; column+=1){
        //System.out.println("grid row: " + row + ", column: " + column);
        numberOnetoNine.remove(new Integer(board[row][column]));
      }
    }
    return numberOnetoNine.isEmpty();
  }

  public boolean areColumnsFromOnetoNine(int[][] board){
    List<Integer> numberOnetoNine = new ArrayList<>();
    
    int rows = board.length;
    int columns = board[0].length;

    for(int row = 0; row < rows; row++){
      numberOnetoNine.clear();
      numberOnetoNine.add(1);
      numberOnetoNine.add(2);
      numberOnetoNine.add(3);
      numberOnetoNine.add(4);
      numberOnetoNine.add(5);
      numberOnetoNine.add(6);
      numberOnetoNine.add(7);
      numberOnetoNine.add(8);
      numberOnetoNine.add(9);

      for(int column = 0; column < columns; column++){
        numberOnetoNine.remove(new Integer(board[row][column]));
      }
    }

    return numberOnetoNine.isEmpty();
  }

  public boolean areRowsFromOnetoNine(int[][] board){
    List<Integer> numberOnetoNine = new ArrayList<>();
    
    int rows = board.length;
    int columns = board[0].length;

    for(int column = 0; column < columns; column++){
      numberOnetoNine.clear();
      numberOnetoNine.add(1);
      numberOnetoNine.add(2);
      numberOnetoNine.add(3);
      numberOnetoNine.add(4);
      numberOnetoNine.add(5);
      numberOnetoNine.add(6);
      numberOnetoNine.add(7);
      numberOnetoNine.add(8);
      numberOnetoNine.add(9);

      for(int row = 0; row < rows; row++){
        //System.out.println("cells: " + board[row][column]);
        numberOnetoNine.remove(new Integer(board[row][column]));
      }
      //System.out.println("numberOnetoNine: " + numberOnetoNine);
    }

    return numberOnetoNine.isEmpty();
  }

    //combinations approach
   public void fillUpNumbers(int[][] board, int rowOrigin){
      int rows = board.length;
      int columns = board[0].length;
      int[] newBoard = new int[board.length]; 

      List<Integer> numberOnetoNine = new ArrayList<>();
      numberOnetoNine.add(1);
      numberOnetoNine.add(2);
      numberOnetoNine.add(3);
      numberOnetoNine.add(4);
      numberOnetoNine.add(5);
      numberOnetoNine.add(6);
      numberOnetoNine.add(7);
      numberOnetoNine.add(8);
      numberOnetoNine.add(9);

      //by each column
      for(int column = 0; column < columns; column++){
        numberOnetoNine.remove(new Integer(board[rowOrigin][column]));
      }
      List<List<Integer>> remainingNumbers = getAllCombinations(numberOnetoNine);
      //put them on new array empty spaces
      for(List<Integer> combination : remainingNumbers){
        int[] newRow = assignNumbersToMissingCells(combination, board[rowOrigin]);
        System.out.println("newRow: " + Arrays.toString(newRow));
      }
      //System.out.println("combi: " + remainingNumbers.toString());
  }

  public int[] assignNumbersToMissingCells(List<Integer> combination, int[] row){
    int[] newRow = new int[row.length];
    int indexCombination = 0;
    for(int i = 0; i < row.length; i++){
      if(row[i] != 0){
        newRow[i] = row[i];
      }else{
        newRow[i] = combination.get(indexCombination++);
      }
    }
    return newRow;
  }

  public List<List<Integer>> getAllCombinations(List<Integer> remainingNumbers){
    List<List<Integer>> allCombinations = new ArrayList<>();
    allCombinations.add(remainingNumbers);
    for(int i = 0; i < remainingNumbers.size(); i++){
      for(int j = i+1; j< remainingNumbers.size(); j++){
        List<Integer> newList = new ArrayList<>(remainingNumbers);
        //swap function 
        int temp = newList.get(i);
        newList.set(i, newList.get(j));
        newList.set(j, temp);
        allCombinations.add(newList);
      }
    }
    return allCombinations;
  }

  public List<String> getSubStrings(String input, int num){
    List<String> candidates = getCandidates(input, num);
    Set<String> uniques = new HashSet<>();
    for(String candidate : candidates){
      if(isOnlyOneDuplicate(candidate)){
        uniques.add(candidate);
      }
    }
    return new ArrayList(uniques);
  }

  public boolean isOnlyOneDuplicate(String input){
    Map<Character, Integer> occurrences = new HashMap<>();
    int i = 0;
    for(char letter : input.toCharArray()){
      if(occurrences.containsKey(letter)){
        int occurrence = occurrences.get(letter);
        if(occurrence >= 2){
          return false;
        }
      }else{
        occurrences.put(letter, 1);
      }
      i++;
    }

    return (occurrences.size() == input.length() -1);
  }

  public List<String> getCandidates(String input, int num){
    List<String> candidates = new ArrayList<>();
    //Slidding window
    for(int j = 0; j < input.length(); j++){
      for(int i = j; i <= input.length() - num; i = i+num){
        String sub = input.substring(i, i + num);
        candidates.add(sub);
        //System.out.println("sub: " + sub);
      }
    }
    return candidates;
  }  

  public List<Integer> getIndexes(String input){
    Map<Character, Integer> lastIndex = getLastIndexes(input);
    System.out.println("map: " + lastIndex.toString());
    Set<Character> uniques = new HashSet<>();
    List<Integer> indexes = new ArrayList<>();

    int i = 0;
    int previousIndex = 0;
    for(char letter : input.toCharArray()){
       System.out.println("letter: " + letter);
      if(lastIndex.containsKey(letter)){
        int index = lastIndex.get(letter);
        if(index == i){
          uniques.remove(letter);
        }else{
          uniques.add(letter);
        }
      }
      System.out.println("uniques: " + uniques.toString());
      if(uniques.isEmpty()){
        System.out.println("i: " + i);
        System.out.println("prev: " + previousIndex);
        indexes.add((i+1) - previousIndex);
        previousIndex = i+1;
      }

      i++;
    }
    //last transformation
    return indexes;
  }

  public Map<Character, Integer> getLastIndexes(String input){
    Map<Character, Integer> lastIndex = new HashMap<>();
    Set<Character> uniques = new HashSet<>();

    int index = 0;
    for(char letter : input.toCharArray()){
      if(!uniques.add(letter)){
        lastIndex.put(letter, index);
      }
      index++;
    }

    return lastIndex;
  }

  public String[] getWordParts(String[] words, String[] parts){
      Map<String, String> wordParts = new HashMap<>();
      for(String word : words){
        for(String part : parts){
          if(word.contains(part)){
            if(wordParts.containsKey(word)){
              String previousPart = wordParts.get(word);
              if(part.length() > previousPart.length()){
                wordParts.put(word, part);
              }
            }else{
              wordParts.put(word, part);
            }
          }
        }
        if(!wordParts.containsKey(word)){
            wordParts.put(word, "");
        }
      }
      String[] output = new String[wordParts.size()];
      int indexOutput = 0;

      for(String word : wordParts.keySet()){
        String part = wordParts.get(word);
        if("".equals(part)){
          output[indexOutput++] = word;
        }else{ 
          int indexBeginingPart = word.indexOf(part); 
          String beforePart = word.substring(0, indexBeginingPart);
          String afterPart = word.substring(indexBeginingPart + part.length());

          StringBuilder wordWithPart = new StringBuilder();
          //part at the beggining of the word
          if("".equals(beforePart)){
              wordWithPart.append(new String("["));
              wordWithPart.append(part);
              wordWithPart.append(new String("]"));
              wordWithPart.append(afterPart);
          //part is at the end of the word    
          }else if("".equals(afterPart)){
              wordWithPart.append(beforePart);
              wordWithPart.append(new String("["));
              wordWithPart.append(part);
              wordWithPart.append(new String("]"));
          //part is between the word   
          }else{
              wordWithPart.append(beforePart);
              wordWithPart.append(new String("["));
              wordWithPart.append(part);
              wordWithPart.append(new String("]"));
              wordWithPart.append(afterPart);
          }
          //System.out.println("beforePart: " + beforePart);
          //System.out.println("afterPart: " + afterPart);
          //System.out.println("wordWithPart: " + wordWithPart.toString());
          output[indexOutput++] = wordWithPart.toString();
        }
      }
      return output;
  }

  public boolean parseJSON(String input){
    Stack<Character> stack = new Stack<>();
    String element = "";
    StringBuilder word = new StringBuilder();
    List<String> elements = new ArrayList<>();
    char openBracket = Character.MIN_VALUE;
    for(Character letter : input.toCharArray()){
      if(letter == '['){
        openBracket = letter;
        stack.add(letter);
      }else if(letter == ']'){
        if(stack.isEmpty()){
          System.out.println("invalid input: "  + input);
          return false;
        }else{
          char closeBracket = stack.pop();
        }
      }else if(letter == ','){
        if(openBracket == Character.MIN_VALUE){
          System.out.println("invalid input: "  + input);
          return false;
        }else{
          elements.add(word.toString());
          word = new StringBuilder();
        }
      }else {
        word.append("" + letter);
      }
    }

    if(!"".equals(word.toString())){
      elements.add(word.toString());
    }

    if(!stack.isEmpty()){
      System.out.println("invalid input: "  + input);
      return false;
    }else{
     return printElements(elements);
    }
  }

  public boolean printElements(List<String> elements){
    for(String element : elements){
      int quotesNumber = element.replaceAll("\"\"|[^\"]", "").length();
      if(quotesNumber == 1){
          System.out.println("invalid input: " + element);
          return false;
      }else if(quotesNumber == 2){
          System.out.println("string: " + element);
      }else{
          System.out.println("number: " + element);
      }
    }
    return true;
  }

}

