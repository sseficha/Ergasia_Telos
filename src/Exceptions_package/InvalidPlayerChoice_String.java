/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions_package;

/**
 *
 * @author Solon
 */
public class InvalidPlayerChoice_String extends Exception{
    
    public InvalidPlayerChoice_String()
    {
        super("Give a valid choice! Number 2-4!");
    }
           
    
}
