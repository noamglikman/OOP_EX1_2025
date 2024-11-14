public class Move {
    private Position pos;
    private Disc disc;//with naama
    private Player current;

    public Move(Position p){
        this.pos=p;
    }

    public Position position() {
        return null;
    }

    public Disc disc() {
        return null;
    }
    public void MakeMove(Disc disc,Position p,Disc[][] board){
        board[p.row()][p.col()]=disc;
    }
}
