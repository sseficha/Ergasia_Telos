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
public class NotAddableTile extends Exception {
    
    public NotAddableTile()
    {
        super("This tile cant be added!");
    }
    
}
