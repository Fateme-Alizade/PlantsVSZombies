package org.example;

public class Bullet {
    private int row;
    private int col;
    public Bullet(int row, int col) {
        this.row = row;
        this.col = col;
    }
    public void move(int col){
        col++;
    }
    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }
}
