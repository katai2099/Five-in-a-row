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

/**
 *
 * @author KaTaizZ
 */
public class Field {
    
    private String mark ; 
    private boolean Chosen;
    
    public Field()
    {
        mark = ""; 
        Chosen = false;    
    }
    
    public String getMark()
    {
        return mark; 
    }
    
    public void setMark(String n)
    {
        mark = n ;
    }
    
    public void setChosenTrue()
    {
        Chosen = true;
    }
    
    public void setChosenfalse()
    {
        Chosen = false; 
    }
    
    public Boolean isChosen()
    {
        return Chosen;
    }


    
    
        
}
