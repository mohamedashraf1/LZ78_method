/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lz78;
import java.util.Scanner;
/**
 *
 * @author Elliot
 */
import java.util.Vector;

public class LZ78 {
    static Scanner sc = new Scanner(System.in);
    public static Vector<String> dic = new Vector<>();
    public static String con = "";
    
    public static void Compress(String letter){
        char[] letters = letter.toCharArray();
        dic.add("");//{"",}
        
        Vector<Tag> tags = new Vector<>();
        boolean finish = false;
        int i = 0 , index = 0 ;
        
        Tag test = new Tag();
        test.setIndex(0);
        test.setSymbol(' ');
        for(int j = 0 ; j < letters.length ; j++){
            tags.add(test);
        }
        
        for (int j = 0 ; j < letters.length ; j++){
            con =con + letters[i];
            
            while(dic.contains(con)){
                index = dic.indexOf(con);
                if(i == letters.length -1){
                    tags.elementAt(i).setIndex(0);
                    char[] lastElement = con.toCharArray();
                    tags.elementAt(i).setSymbol(lastElement[0]);
                    System.out.println("<" + tags.elementAt(j).getIndex() + "," + tags.elementAt(j).getSymbol() + ">");
                    finish = true;
                    break;
                }
                else{
                    i++;
                    con = con + letters[i];
                }
                
            }
            if(finish){
                break;
            }
            else{
            dic.add(con);
            
            tags.elementAt(j).setIndex(index);//vector
            String last = con.substring(con.length() - 1);
            char []last2 = last.toCharArray();
            tags.elementAt(j).setSymbol(last2[0]);
            System.out.println("<" + tags.elementAt(j).getIndex() + "," + tags.elementAt(j).getSymbol() + ">");
            con ="";
            i++;
            }
            
        }
                
    }
    public static void Decompress(){
        Vector<Tag> tags = new Vector<Tag>();
        System.out.println("Enter the number of tags : ");
        int  num = sc.nextInt();
        dic.add("");
        
        Tag test = new Tag();
        test.setIndex(0);
        test.setSymbol(' ');
        for(int j = 0 ; j < num ; j++){
            tags.add(test);
        }
        for(int i = 0; i < num; i++)
        {   
            System.out.println("Enter the tag in the form <index,Symbol> ");
            String S = sc.next();
            char[] STR = S.toCharArray();
            int m=Character.getNumericValue(STR[1]);
            tags.elementAt(i).setIndex(m);
            tags.elementAt(i).setSymbol(STR[3]);
            
            con = dic.elementAt(tags.elementAt(i).getIndex());
            //con = dic.elementAt(m)
            con = con + tags.elementAt(i).getSymbol();
            //con = con + STR[3];
            dic.add(con);
            
        }
        
        for(int k = 0 ; k < dic.size() ; k++){
            System.out.print(dic.elementAt(k));
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        LZ78 first = new LZ78();
        String letters = "abcacdcccc";
        //first.Compress(letters);
        first.Decompress();
        //Compress(letters);
    }
    
}
