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
public class HasNoTiles extends Exception{
    
    public HasNoTiles(String name)
    {
        super("Player "+name+" has no more Tiles");
    }
}
