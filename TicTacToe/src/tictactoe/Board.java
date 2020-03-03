// Sayalath Phommachanh
//
// FMXDL2
//
// Tricky five-in-a-row
//
// 2019/11/20 22:37:57
//
// This solution was submitted and prepared by Sayalath Phommachanh, FMXDL2 for the
// Tricky five-in-a-row assignment of the Practical software engineering I. course.
//
// I declare that this solution is my own work.
//
// I have not copied or used third party solutions.
//
// I have not passed my solution to my classmates, neither  made it public.
//
// Students’ regulation of Eötvös Loránd University (ELTE Regulations
// Vol. II. 74/C. § ) states that as long as a student presents another
// student’s work - or at least the significant part of it - as his/her own
// performance, it will count as a disciplinary fault. The most serious
// consequence of a disciplinary fault can be dismissal of the student from
// the University.

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.Point;

/**
 *
 * @author KaTaizZ
 */
public class Board {
    
    private Field[][] board;
    private final int boardSize;
    public int cnt=0;
    
    public Board(int boardSize)
    {
        this.boardSize = boardSize;
        board = new Field[this.boardSize][this.boardSize];
        for(int i=0;i<this.boardSize;i++)
        {
            for(int j=0;j<this.boardSize;j++)
            {
                board[i][j] = new Field(); 
            }
        }
    }
    
    public Field get(int x, int y) {
        return board[x][y];
    }
    
    public Field get(Point point) {
        int x = (int)point.getX();
        int y = (int)point.getY();
        return get(x, y);
    }
    
    public int getBoardsize()
    {
        return boardSize;
    }
    
    public boolean isFull()
    {
        boolean l=true;
        for(int i=0;i<boardSize;i++)
        {
            for(int j=0;j<boardSize;j++)
            {
                if(board[i][j].getMark().isEmpty()) 
                { l= false; }
            }
        }
        return l;
    }
    
    
    
    
            
}
