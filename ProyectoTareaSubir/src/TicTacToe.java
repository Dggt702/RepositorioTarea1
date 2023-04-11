import java.util.Scanner;

public class TicTacToe {
    static char[] board = new char[9];
    static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int move;
        //Comentario segundo COMMIT
        // Inicializa el tablero
        for (int i = 0; i < 9; i++) {
            board[i] = '-';
        }

        // Juego
        while (true) {
            // Imprime el tablero
            System.out.println("Tablero:");
            printBoard();

            // Solicita movimiento al usuario
            System.out.println(currentPlayer + ", es tu turno. Ingresa una posición (1-9):");
            move = sc.nextInt();

            // Valida el movimiento
            if (isValidMove(move)) {
                // Realiza el movimiento
                board[move-1] = currentPlayer;

                // Verifica si hay ganador o empate
                if (hasWinner()) {
                    System.out.println("¡Felicidades, " + currentPlayer + " ha ganado!");
                    break;
                } else if (isBoardFull()) {
                    System.out.println("¡Empate!");
                    break;
                }

                // Cambia de jugador
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Movimiento inválido. Inténtalo de nuevo.");
            }
        }
    }

    // Imprime el tablero
    public static void printBoard() {
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
    }

    // Valida si el movimiento es válido
    public static boolean isValidMove(int move) {
        return (move >= 1 && move <= 9 && board[move-1] == '-');
    }

    // Verifica si hay ganador
    public static boolean hasWinner() {
        // Verifica las filas
        for (int i = 0; i <= 6; i += 3) {
            if (board[i] != '-' && board[i] == board[i+1] && board[i+1] == board[i+2]) {
                return true;
            }
        }

        // Verifica las columnas
        for (int i = 0; i <= 2; i++) {
            if (board[i] != '-' && board[i] == board[i+3] && board[i+3] == board[i+6]) {
                return true;
            }
        }

        // Verifica las diagonales
        if (board[0] != '-' && board[0] == board[4] && board[4] == board[8]) {
            return true;
        }
        if (board[2] != '-' && board[2] == board[4] && board[4] == board[6]) {
            return true;
        }

        return false;
    }

    // Verifica si el tablero está lleno
    public static boolean isBoardFull() {
        for (int i = 0; i < 9; i++) {
            if (board[i] == '-') {
                return false;
            }
        }
        return true;
    }
}
