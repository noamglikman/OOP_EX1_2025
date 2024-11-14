import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GameLogic implements PlayableLogic {
    private Player player1;

    private Player player2;

    private Disc[][] board;

    private List<Position> pos;

    private boolean current;//

    boolean[][] situation;
    boolean[][] neighbord;


    Stack<Position> s = new Stack<>();

    public GameLogic() {
        this.board = new Disc[8][8];
        this.current = true;//true for the first player,false for the second
        this.situation = new boolean[8][8];//booleam arr
        this.neighbord = new boolean[8][8];//oll the neighbord for position
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                situation[i][j] = false;
            }
        }

        situation[3][3] = true;
        situation[4][3] = true;
        situation[4][4] = true;
        situation[3][4] = true;
    }

    @Override
    public boolean locate_disc(Position a, Disc disc) {
        int ro=a.rows;
        int co=a.columns;
         if(ro<7 && ro !=0 &&co<7 && co !=0 ) {                                      //put true to know who is the neighbord
             neighbord[a.row() + 1][a.col()] = true;
             neighbord[a.row() + 1][a.col() + 1] = true;
             neighbord[a.row() + 1][a.col() - 1] = true;
             neighbord[a.row() - 1][a.col()] = true;
             neighbord[a.row() - 1][a.col() + 1] = true;
             neighbord[a.row() - 1][a.col() - 1] = true;
             neighbord[a.row()][a.col() + 1] = true;
             neighbord[a.row()][a.col() - 1] = true;
         } else if(ro==0&&co==0){
             neighbord[a.row() + 1][a.col()] = true;
             neighbord[a.row() ][a.col()+1 ] = true;
             neighbord[a.row() -1][a.col() - 1] = true;
         }else if(ro<7&&ro>0&&co<7&&co>0){
             neighbord[a.row() + 1][a.col()] = true;
             neighbord[a.row() + 1][a.col() + 1] = true;
             neighbord[a.row() + 1][a.col() - 1] = true;
             neighbord[a.row() - 1][a.col()] = true;
         }
        if (!situation[a.row()][a.col()]) {
            if (countFlips(a) == 0)
                return false;
            if (board[a.row()][a.col()] != null && neighbord[a.row()][a.col()]) {
                System.out.println("this position is possible for you");
            }
        }


        board[a.row()][a.col()] = disc;
        Move m1 = new Move(a);
        m1.MakeMove(disc, a, board);//make move
        current = !current;//change player
        return true;
    }

    @Override
    public Disc getDiscAtPosition(Position position) {
        return board[position.row()][position.col()];//return position
    }

    @Override
    public int getBoardSize() {
        return board.length;
    }

    @Override
    public List<Position> ValidMoves() {

        return List.of();
    }


    @Override
    public int countFlips(Position a) {
        int count = 0;
        int x = a.row();
        int y = a.col();
        System.out.println("x is " + x + "," + "y is" + y + ",");
        x++;
        while (x < 8 && y <8 &&board[x][y] != null) {
            if ( board[x][y].getOwner().isPlayerOne != current && !board[x][y].getType().equals("⭕")) {
                x++;
                count++;
            }
            else break;
        }
        x = a.row();
        y = a.col();
        x--;
        while (x >-1&& board[a.row()][a.col()] != null) {
            if (board[x][y].getOwner().isPlayerOne != current && !board[x][y].getType().equals("⭕")) {
                x--;
                count++;
            }
            else break;
        }
        x = a.row();
        y = a.col();
        y++;
        while (y<8 &&board[x][y] != null) {
            if ( board[x][y].getOwner().isPlayerOne != current && !board[x][y].getType().equals("⭕")) {
                y++;
                count++;
            }
            else break;
        }
        x = a.row();
        y = a.col();
        y--;
        while (y >-1 && board[x][y] != null) {
            if ( board[x][y].getOwner().isPlayerOne != current && !board[x][y].getType().equals("⭕")) {
                y--;
                count++;
            }
            else break;
        }
        x = a.row();
        y = a.col();
        y--;
        x--;
        while (x > -1 && y > -1&&board[a.row()][a.col()] != null) {
            if ( board[x][y].getOwner().isPlayerOne != current && !board[x][y].getType().equals("⭕")) {
                x--;
                y--;
                count++;
            }
            else break;
        }
        x = a.row();
        y = a.col();
        x++;
        y++;
        while (x < 8 && y <8 &&board[a.row()][a.col()] != null) {
            if ( board[x][y].getOwner().isPlayerOne != current && !board[x][y].getType().equals("⭕")) {
                x++;
                y++;
                count++;
            }
            else break;
        }
        return count;
    }
    //public void Bomb

    @Override
    public Player getFirstPlayer() {
        return player1;
    }

    @Override
    public Player getSecondPlayer() {
        return player2;
    }

    @Override
    public void setPlayers(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public boolean isFirstPlayerTurn() {
        return current;
    }

    @Override
    public boolean isGameFinished() {
        return false;
    }

    @Override
    public void reset() {
        //do not forget to add colors for each player
        board = new Disc[8][8];
        /*Position middle1 = new Position(3, 3); // (Row 3, Column 3)
        Position middle2 = new Position(3, 4); // (Row 3, Column 4)
        Position middle3 = new Position(4, 3); // (Row 4, Column 3)
        Position middle4 = new Position(4, 4); // (Row 4, Column 4)
        s.push(middle1);
        s.push(middle2);
        s.push(middle3);
        s.push(middle4);
         */
        board[3][4] = new SimpleDisc(player1);
        board[3][3] = new SimpleDisc(player2);
        board[4][3] = new SimpleDisc(player1);
        board[4][4] = new SimpleDisc(player2);

    }

    @Override
    public void undoLastMove() {
        s.pop();
    }
}
