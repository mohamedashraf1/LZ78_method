/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lz78;

/**
 *
 * @author Elliot
 */
public class Tag {
    int index;
    char symbol;
                              
    public Tag(int index, char symbol) {
        this.index = index;
        this.symbol = symbol;
    }
    
    public Tag(){};
    
    public void setIndex(int index){
        this.index = index;
    }
    
    public void setSymbol(char symbol){
        this.symbol = symbol;
    }
    
    public int getIndex() {
        return index;
    }

    public char getSymbol() {
        return symbol;
    }
    
    
}
