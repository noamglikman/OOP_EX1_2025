public class Position {
    public int rows;
    public int columns;

    public Position (int rows,int columns){
        this.rows=rows;
        this.columns=columns;
    }
    public void setColumns(int columns) {
        this.columns = columns;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int row() {
        return rows;
    }

    public int col() {
        return columns;
    }
}
