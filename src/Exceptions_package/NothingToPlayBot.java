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
public class NothingToPlayBot extends Exception {
    public NothingToPlayBot(String name)
    {
        super(name+" cant play something right now");
    }
    
}
