import java.util.Scanner;

public class TicTacToe {

  static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {

    System.out.println("\nLet's play tic tac toe");

    char[][] board = { { '_', '_', '_' },
        { '_', '_', '_' },
        { '_', '_', '_' } };

    printBoard(board);

    for (int i = 0; i < 9; i++) {
      if (i % 2 == 0) {
        System.out.println("Turn: X");
        System.out.print("- Pick a row and column number: ");
        int[] spot = askUser(board);
        board[spot[0]][spot[1]] = 'X'; // board[spot[askUser(board)[0]]][askUser(board)[1]] = 'X';

      } else {
        System.out.println("Turn: O");
        System.out.print("- Pick a row and column : ");
        int[] spot = askUser(board);
        board[spot[0]][spot[1]] = 'O';
      }
      printBoard(board);
      int count = checkWin(board);
      if (count == 3) {
        System.out.println("X wins!!");
        break;
      } else if (count == -3) {
        System.out.println("O wins!!");
        break;
      }else if (i == 8 ){
        System.out.println("It's a Tie");
      }
    }
    

    scan.close();
  }

  /**
   * Task 2 - Write a function that prints the board.
   * Function name - printBoard()
   * 
   * @param board (char[][])
   * 
   *              Inside the function:
   *              1. print a new line.
   *              2. print the board.
   *              • separate each row by two lines.
   *              • each row precedes a tab of space
   *              • each character in the grid has one space from the other
   *              character
   */
  public static void printBoard(char[][] board) {
    System.out.print("\n");
    for (int i = 0; i < board.length; i++) {
      System.out.print("\t");
      for (int j = 0; j < board[i].length; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.print("\n\n");
    }
  }

 

  /**
   * Task 4 - Write a function that lets the user choose a spot
   * Function name – askUser
   * 
   * @param board (char[][] board)
   * @return spot (int[])
   * 
   *         Inside the function
   *         1. Asks the user: - pick a row and column number:
   *         2. Check if the spot is taken. If so, let the user choose again.
   *         3. Return the row and column in an int[] array.
   * 
   */
  // public static int[] askUser(char[][] board) {
  //   int row = scan.nextInt();
  //   int column = scan.nextInt();

  //   while (true) {

  //     if (board[row][column] != '_') {
  //       System.out.print("\nSorry this spot is already taken!, try again : ");
  //       row = scan.nextInt();
  //       column = scan.nextInt();

  //     } else {
  //       break;
  //     }
  //   }
  //   // int[] spot ={row,column};
  //   return new int[] { row, column };

  // }
  public static int[] askUser(char[][] board) {
    int num = scan.nextInt();
    int[] spot = digitToArray(num);
    int row = spot[0];
    int column = spot[1];

    while (true) {

      if (board[row][column] != '_') {
        System.out.print("\nSorry this spot is already taken!, try again : ");
        num = scan.nextInt();
        spot = digitToArray(num);
        row = spot[0];
        column = spot[1];

      } else {
        break;
      }
    }
    // int[] spot ={row,column};
    return new int[] { row, column };

  }

  
  /**
   * Task 6 - Write a function that determines the winner
   * Function name - checkWin
   * 
   * @param board (char[][])
   * @return count (int)
   * 
   *         Inside the function:
   *         1. Make a count variable that starts at 0.
   *         2. Check every row for a straight X or straight O (Task 7).
   *         3. Check every column for a straight X or straight O (Task 8).
   *         4. Check the left diagonal for a straight X or straight O (Task 9).
   *         5. Check the right diagonal for a straight X or straight O (Task 10).
   */
  public static int checkWin(char[][] board) {
    // check rows
    int count = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == 'X') {
          count++;
        } else if (board[i][j] == 'O') {
          count--;
        }
      }
      if(count == 3 || count == -3){
        return count;
      }else{
        count = 0;
      }
    }

    // check columns
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[j][i] == 'X') {
          count++;
        } else if (board[j][i] == 'O') {
          count--;
        }
      }
      if(count == 3 || count == -3){
        return count;
      }else{
        count = 0;
      }
    }
    // left diagonal
    for (int i = 0 ; i < 3 ; i++){
      if(board[i][i] == 'X'){
        count ++;
      }else if (board[i][i] == 'O'){
        count--;
      }
    }
      
      if(count == 3 || count == -3){
        return count;
      }else{
        count = 0;
      }
    
      // right diagonal
    for (int i = 0 ; i < 3 ; i++){
      int rowIndex = 2- i;
      if(board[i][rowIndex] == 'X'){
        count ++;
      }else if (board[i][rowIndex] == 'O'){
        count --;
      }
      
    }
    if(count == 3 || count == -3){
      return count;
    }else{
      count = 0;
    }
    return count;
  }


  //create a function that converts number to perticular array position
  public static int[] digitToArray(int num){
    if(num == 1) return new int[]{0,0};
    else if(num == 2) return new int[]{0,1};
    else if(num == 3) return new int[]{0,2};
    else if(num == 4) return new int[]{1,0};
    else if(num == 5) return new int[]{1,1};
    else if(num == 6) return new int[]{1,2};
    else if(num == 7) return new int[]{2,0};
    else if(num == 8) return new int[]{2,1};
    else if(num == 9) return new int[]{2,2};
    else return new int[]{-1,-1};
  }
}