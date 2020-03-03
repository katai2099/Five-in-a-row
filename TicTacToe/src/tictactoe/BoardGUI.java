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

import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author KaTaizZ
 */
public class BoardGUI {
    
    private String n="X";
    private JButton[][] buttons;
    private Board board; 
    private JPanel boardPanel;
    private JLabel turnLabel;
    private ArrayList<Point> points;
    
    private Random random = new Random();
    
    
    public BoardGUI(int boardSize)
    {
        board = new Board(boardSize);
        boardPanel = new JPanel();
        points = new ArrayList<>();
        boardPanel.setLayout(new GridLayout(board.getBoardsize(),board.getBoardsize()));
        buttons = new JButton[board.getBoardsize()][board.getBoardsize()];
        for(int i=0;i<board.getBoardsize();i++)
        {
            for(int j=0;j<board.getBoardsize();j++)
            {
                JButton button = new JButton();
                button.addActionListener(new ButtonListener(i,j));
                button.setPreferredSize(new Dimension(80,40));
                button.setFont(new Font("Times new roman",Font.PLAIN,40));
                buttons[i][j] = button;
                boardPanel.add(button);
                points.add(new Point(i,j));
            }
        }
        
            turnLabel = new JLabel(n +" Turn ");
            turnLabel.setHorizontalAlignment(JLabel.RIGHT);
        
        
      
        
    }
    
    public JPanel getBoardPanel()
    {
        return boardPanel;
    }
    
    public JLabel getTurnLabel()
    {
        return turnLabel;
    }
    
    public void reset(int x,int y)
    {
         JButton button = buttons[x][y];
        Field field = board.get(x, y);
        button.setText(field.getMark());
        
    }
    
    
    class ButtonListener implements ActionListener 
    {
        private int x;
        private int y;
        
        public ButtonListener(int x,int y)
        {
            this.x = x ;
            this.y = y;
        }
        
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(board.get(x,y).isChosen()==false)
            {
                if(board.cnt % 2==0)
                {
                    board.get(x,y).setMark("X");
                    board.cnt++;
                    board.get(x, y).setChosenTrue();
                }
                else
                {
                    board.get(x,y).setMark("O");
                    board.cnt++;
                    board.get(x, y).setChosenTrue();
                }
                reset(x,y);
                
                
                if (board.isFull())
            {
                JOptionPane.showMessageDialog(boardPanel,"Game" + " is tie!" , " Tie Game",JOptionPane.PLAIN_MESSAGE);
                newgame();
            }
            else if(VerticalCheck())
            {
                JOptionPane.showMessageDialog(boardPanel, "You have won " + board.get(x,y).getMark(), "Congrats!",
                            JOptionPane.PLAIN_MESSAGE);
                newgame();
            }
            else if(HorizontalCheck())
            {
                JOptionPane.showMessageDialog(boardPanel, "You have won " + board.get(x,y).getMark(), "Congrats!",
                            JOptionPane.PLAIN_MESSAGE);
                newgame();
            }
            else if(Diagonal45Check())
            {
                JOptionPane.showMessageDialog(boardPanel, "You have won " + board.get(x,y).getMark(), "Congrats!",
                            JOptionPane.PLAIN_MESSAGE);
                newgame();
            }
            else if(Diagonal135Check())
            {
                JOptionPane.showMessageDialog(boardPanel, "You have won " + board.get(x,y).getMark(), "Congrats!",
                            JOptionPane.PLAIN_MESSAGE);
                newgame();
            }
            
            else{
            if(Verticalcheck()==3)
            {
                remove2();   
            } 
            else if(Verticalcheck()==2)
            {
                remove1();
            } 
            
            else if(Horizontalcheck()==3)
            {
                remove2();
            }
            else if(Horizontalcheck()==2)
            {
                remove1();
            }
            else if(Diagonal45check()==3)
            {
                remove2();
            }
            else if(Diagonal45check()==2)
            {
                remove1();
            }
            else if(Diagonal135check()==3)
            {
                remove2();
            }
            else if(Diagonal135check()==2)
            {
                remove1();
            }
            nextturn();
            }       
                
                
            }
            
            
            
                
            
        }
        
        
        public void remove1()
        {
            int indexx;//=random.nextInt(board.getBoardsize());
                int indexy;//=random.nextInt(board.getBoardsize());
                do{
                 indexx=random.nextInt(board.getBoardsize());
                 indexy=random.nextInt(board.getBoardsize());
                }while(!board.get(indexx, indexy).getMark().equals(board.get(x, y).getMark()));
                board.get(indexx, indexy).setMark("");
                board.get(indexx, indexy).setChosenfalse();
                reset(indexx,indexy);  
        }
        
        public void remove2()
        {
             int loop=2;
                while(loop!=0){
                int indexx;//=random.nextInt(board.getBoardsize());
                int indexy;//=random.nextInt(board.getBoardsize());
                do{
                 indexx=random.nextInt(board.getBoardsize());
                 indexy=random.nextInt(board.getBoardsize());
                }while(!board.get(indexx, indexy).getMark().equals(board.get(x, y).getMark()));
                board.get(indexx, indexy).setMark("");
                board.get(indexx, indexy).setChosenfalse();
                reset(indexx,indexy);
                loop--;
                } 
        }
        
        
        public boolean VerticalCheck()
        {
            boolean ans=false;
            ArrayList<Field> tmp = new ArrayList();
            
            for(int i=x+1;i<x+5;i++)
            {
                if(i==board.getBoardsize()) break;
                if(!board.get(x,y).getMark().equals(board.get(i,y).getMark())) break;
              //  if(!board.get(i,y).getMark().equals(board.get(x,y).getMark())) break;
                else tmp.add(board.get(i,y));
           
            }
            for(int k=x-1;k>x-5;k--)
            {
                if(k==-1) break;
                if(!board.get(x,y).getMark().equals(board.get(k,y).getMark())) break;
                //if(!board.get(k,y).getMark().equals(board.get(x, y).getMark())) break;
                else tmp.add(board.get(k,y));
             
            }
            if(tmp.size()==4) 
            {
                ans=true;
            }
            else ans=false;
            return ans;
            
        }
        public int Verticalcheck()
        {
            ArrayList<Field> tmp = new ArrayList();
            
            for(int i=x+1;i<x+5;i++)
            {
                if(i==board.getBoardsize()) break;
                if(!board.get(x, y).getMark().equals(board.get(i,y).getMark())) break;
              //  if(!board.get(i,y).getMark().equals(board.get(x, y).getMark())) break;
                else tmp.add(board.get(i,y));
           
            }
            for(int k=x-1;k>x-5;k--)
            {
                if(k==-1) break;
                if(!board.get(x,y).getMark().equals(board.get(k,y).getMark())) break;
               // if(!board.get(k,y).getMark().equals(board.get(x, y).getMark())) break;
                else tmp.add(board.get(k,y));
             
            }
            
            return tmp.size();
        }
        
        public boolean HorizontalCheck()
        {
            boolean ans=false;
            ArrayList<Field> tmp = new ArrayList();
            
            for(int i=y+1;i<y+5;i++)
            {
                if(i==board.getBoardsize()) break;
                if(!board.get(x,y).getMark().equals(board.get(x,i).getMark())) break;
                //if(!board.get(x,i).getMark().equals(board.get(x, y).getMark())) break;
                else tmp.add(board.get(x,i));
           
            }
            for(int k=y-1;k>y-5;k--)
            {
                if(k==-1) break;
                if(!board.get(x,y).getMark().equals(board.get(x,k).getMark())) break;
              //  if(!board.get(x,k).getMark().equals(board.get(x, y).getMark())) break;
                else tmp.add(board.get(x,k));
             
            }
            if(tmp.size()==4) 
            {
                ans=true;
            }
            else ans=false;
            return ans;
        }
        
        public int Horizontalcheck()
        {
            ArrayList<Field> tmp = new ArrayList();
            
            for(int i=y+1;i<y+5;i++)
            {
                if(i==board.getBoardsize()) break;
                if(!board.get(x,y).getMark().equals(board.get(x, i).getMark())) break;
             //   if(!board.get(x,i).getMark().equals(board.get(x, y).getMark())) break;
                else tmp.add(board.get(x,i));
           
            }
            for(int k=y-1;k>y-5;k--)
            {
                if(k==-1) break;
                if(!board.get(x,y).getMark().equals(board.get(x,k).getMark())) break;
             //   if(!board.get(x,k).getMark().equals(board.get(x, y).getMark())) break;
                else tmp.add(board.get(x,k));
             
            }
            return tmp.size();
        }
        
        public boolean Diagonal135Check()
        {
            boolean ans = false; 
            ArrayList<Field> tmp = new ArrayList();
            int i=x+1;
            int j=y+1;
            while(i<x+5 && j<y+5 && i != board.getBoardsize() && j != board.getBoardsize())
            {
                if(!board.get(x, y).getMark().equals(board.get(i, j).getMark()))
                {
                    break;
                }
                else
                {
                    tmp.add(board.get(i,j));
                }
                i++;
                j++;
            }
            i = x-1;
            j = y-1; 
            while(i>x-5 && j>y-5 && i!= -1 && j!= -1 )
            {
                if(!board.get(x, y).getMark().equals(board.get(i, j).getMark()))
                {
                    break;
                }
                else
                {
                    tmp.add(board.get(i,j));
                }
                i--;
                j--;
            }
            if(tmp.size()==4) 
            {
                ans=true;
            }
            else ans=false;
            return ans;
        }
        
        public int Diagonal135check()
        {
            ArrayList<Field> tmp = new ArrayList();
            int i=x+1;
            int j=y+1;
            while(i<x+5 && j<y+5 && i != board.getBoardsize() && j != board.getBoardsize())
            {
                if(!board.get(x, y).getMark().equals(board.get(i, j).getMark()))
                {
                    break;
                }
                else
                {
                    tmp.add(board.get(i,j));
                }
                i++;
                j++;
            }
            i = x-1;
            j = y-1; 
            while(i>x-5 && j>y-5 && i!= -1 && j!= -1 )
            {
                if(!board.get(x, y).getMark().equals(board.get(i, j).getMark()))
                {
                    break;
                }
                else
                {
                    tmp.add(board.get(i,j));
                }
                i--;
                j--;
            }
            return tmp.size();
        }
        
        public boolean Diagonal45Check()
        {
           boolean ans=false;
           ArrayList<Field> tmp = new ArrayList();
           int i = x+1;
           int j = y-1;
           while(i<x+5 && j > y-5 && i!= board.getBoardsize() && j!= -1)
           {
               if(!board.get(x, y).getMark().equals(board.get(i,j).getMark()))
               {
                   break;
               }
               else
               {
                   tmp.add(board.get(i,j));
               }
               i++;
               j--;
           }
           i = x-1;
           j = y+1;
           while(i>x-5 && j < y+5 && i!=-1 && j != board.getBoardsize())
           {
               if(!board.get(x,y).getMark().equals(board.get(i,j).getMark()))
               {
                   break;
               }
               else 
               {
                   tmp.add(board.get(i,j));
               }
               i--;
               j++;
               
           }
           if(tmp.size()==4)
           {
               ans= true; 
           }
           else ans = false;
           return ans;
        }
        
        public int Diagonal45check()
        {
            ArrayList<Field> tmp = new ArrayList();
           int i = x+1;
           int j = y-1;
           while(i<x+5 && j > y-5 && i!= board.getBoardsize() && j!= -1)
           {
               if(!board.get(x, y).getMark().equals(board.get(i,j).getMark()))
               {
                   break;
               }
               else
               {
                   tmp.add(board.get(i,j));
               }
               i++;
               j--;
           }
           i = x-1;
           j = y+1;
           while(i>x-5 && j < y+5 && i!=-1 && j != board.getBoardsize())
           {
               if(!board.get(x,y).getMark().equals(board.get(i,j).getMark()))
               {
                   break;
               }
               else 
               {
                   tmp.add(board.get(i,j));
               }
               i--;
               j++;
               
           }
           return tmp.size();
        }
       
        public void nextturn()
        {
            
             if(board.cnt %2==0)
                n="X";
            else if(board.cnt %2!=0)
                n="O";
             turnLabel.setText(n + " Turn ");
        }
   
           }
        public void newgame()
        {
            for(int i=0;i<board.getBoardsize();i++)
            {
                for(int j=0;j<board.getBoardsize();j++)
                {
                    board.get(i, j).setMark("");
                    board.get(i, j).setChosenfalse();
                    reset(i,j);
                }
            }
        }
}
    



    
    
    

