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
public class NothingToPlay extends Exception {
    
    public NothingToPlay(String name)
    {
        super(name+" you cant play anything right now");
    }
}