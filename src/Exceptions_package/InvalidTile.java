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
public class InvalidTile extends Exception{
    
    public InvalidTile()
    {
       super("You chose an invalid tile, please select any last tile!");
    }
    
}
