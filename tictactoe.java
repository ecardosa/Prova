import java.util.Scanner;

public class TTTConsoleNonOO {
   // Definim les següents variables: 
   // 1. Jugador: utilitzant CROSS i NUGHT
	// 2. Contingut de la cel·la: utilitzant CROSS, NUGHT i NO_SEED
   public static final int CROSS   = 0;
   public static final int NOUGHT  = 1;
   public static final int NO_SEED = 2;

   // El tauler de joc
   public static final int ROWS = 3, COLS = 3; // nombre de files/columnes
   public static int[][] board = new int[ROWS][COLS]; // Buit, Creu, Cercle

   // El jugador actual
   public static int currentPlayer;  // CREU, RES

   // Definir constants anomenades per representar els diferents estats del joc
   public static final int PLAYING    = 0;
   public static final int DRAW       = 1;
   public static final int CROSS_WON  = 2;
   public static final int NOUGHT_WON = 3;
   // L'estat actual del joc
   public static int currentState;

   public static Scanner in = new Scanner(System.in); // l'escàner d'entrada

   /** El mètode principal d'entrada (el programa comença aquí) */
   public static void main(String[] args) {
	  // Inicialitzar el tauler, currentState i currentPlayer
      initGame();

      // Juga el joc una vegada
      do {
    	 // currentPlayer fa un moviment
    	 // Actualitza el tauler [selectedRow][selectedCol] i currentState
         stepGame();
         // Actualitza la pantalla
         paintBoard();
         // Imprimeix el missatge si el joc acaba
         if (currentState == CROSS_WON) {
            System.out.println("'X' won!\nBye!");
         } else if (currentState == NOUGHT_WON) {
            System.out.println("'O' won!\nBye!");
         } else if (currentState == DRAW) {
            System.out.println("It's a Draw!\nBye!");
         }
         // Canvia el jugador actual
         currentPlayer = (currentPlayer == CROSS) ? NOUGHT : CROSS;
      } while (currentState == PLAYING); // repeteix si no s'ha acabat el joc
   }

   /** Inicialitzar el board[][], currentState i currentPlayer per a un joc nou*/
   public static void initGame() {
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLS; ++col) {
            board[row][col] = NO_SEED;  // totes les cel·les buides
         }
      }
      currentPlayer = CROSS;   // juga en creu primer
      currentState  = PLAYING; // preparat per jugar
   }

   /** El jugador actual fa un moviment (un pas).
   Actualitza el tauler [selectedRow][selectedCol] i currentState. */
   public static void stepGame() {
      boolean validInput = false;  // per a la validació d'entrada
      do {
         if (currentPlayer == CROSS) {
            System.out.print("Player 'X', enter your move (row[1-3] column[1-3]): ");
         } else {
            System.out.print("Player 'O', enter your move (row[1-3] column[1-3]): ");
         }
         int row = in.nextInt() - 1;  // L'índex de matriu comença a 0 en lloc d'1
         int col = in.nextInt() - 1;
         if (row >= 0 && row < ROWS && col >= 0 && col < COLS
                      && board[row][col] == NO_SEED) {
        	// Actualitza el board[][] i torna el nou estat del joc després del moviment
            currentState = stepGameUpdate(currentPlayer, row, col);
            validInput = true;  // entrada d'acord, sortida del bucle
         } else {
            System.out.println("This move at (" + (row + 1) + "," + (col + 1)
                  + ") is not valid. Try again...");
         }
      } while (!validInput);  // repeteix si l'entrada no és vàlida
   }

   /**
    * Funció d'ajuda de stepGame().
    * El jugador donat fa un moviment a (selectedRow, selectedCol).
    * Actualitza el tauler [selectedRow][selectedCol]. Calculeu i retorneu el
    * nou estat del joc (PLAYING, DRAW, CROSS_WON, NOUGHT_WON).
    * @return nou estat del joc
    */
   public static int stepGameUpdate(int player, int selectedRow, int selectedCol) {
	      // Actualitzar el taulerde joc
	      board[selectedRow][selectedCol] = player;

	      // Calcular i tornar al nou estat del joc
	      if (board[selectedRow][0] == player       // 3 a la fila
	                && board[selectedRow][1] == player
	                && board[selectedRow][2] == player
	             || board[0][selectedCol] == player // 3 a la columna
	                && board[1][selectedCol] == player
	                && board[2][selectedCol] == player
	             || selectedRow == selectedCol      // 3 a la diagonal
	                && board[0][0] == player
	                && board[1][1] == player
	                && board[2][2] == player
	             || selectedRow + selectedCol == 2  // 3 a la diagonal oposada
	                && board[0][2] == player
	                && board[1][1] == player
	                && board[2][0] == player) {
	         return (player == CROSS) ? CROSS_WON : NOUGHT_WON;
	      } else {
	         // Ningú ha guanyat. Comprovar si hi ha EMPAT (totes les cel·les estan ocupades) o JUGAR.
	         for (int row = 0; row < ROWS; ++row) {
	            for (int col = 0; col < COLS; ++col) {
	               if (board[row][col] == NO_SEED) {
	                  return PLAYING; // encara hi ha cel·les buides.
	               }
	            }
	         }
	         return DRAW; // no hi ha cel·les buides, és empat.
	      }
	   }

	   /** Es mostra  el tauler de joc */
	   public static void paintBoard() {
	      for (int row = 0; row < ROWS; ++row) {
	         for (int col = 0; col < COLS; ++col) {
	            paintCell(board[row][col]); // es mostren cada una de les cel·les.
	            if (col != COLS - 1) {
	               System.out.print("|");   // es mostra la partició vertical.
	            }
	         }
	         System.out.println();
	         if (row != ROWS - 1) {
	            System.out.println("-----------"); // es mostra la partició horitzontal
	         }
	      }
	      System.out.println();
	   }

	   /** Mostra una cel·la que te contingut a dintre */
	   public static void paintCell(int content) {
	      switch (content) {
	         case CROSS:   System.out.print(" X "); break;
	         case NOUGHT:  System.out.print(" O "); break;
	         case NO_SEED: System.out.print("   "); break;
	      }
	   }
	}
