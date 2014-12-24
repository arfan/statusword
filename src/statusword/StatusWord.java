/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statusword;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.StringTokenizer;

/**
 *
 * @author arfan
 */
public class StatusWord {

    Hashtable<String, String> table = new Hashtable<String, String>();
    public StatusWord() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(StatusWord.class.getResourceAsStream("listerror")));
            String line;
            
            
            while((line=reader.readLine())!=null) {
                StringTokenizer token = new StringTokenizer(line, "/");
                
                String sw1sw2=null, type=null, desc=null;
                
                try {
                    sw1sw2 = token.nextToken().trim();
                    type = token.nextToken().trim();
                    desc = token.nextToken().trim();
                    
                    sw1sw2 = sw1sw2.replace("X", "");
                    sw1sw2 = sw1sw2.replace("-", "");
                    
                    table.put(sw1sw2, "["+type+"] "+desc);
                }
                catch (Exception e) {
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StatusWord sw = new StatusWord();
        System.out.println(sw.getMeaningSW1SW2("6A83"));
    }
    
    public String getMeaningSW1SW2(String statusWord){
        int len = statusWord.length();
        statusWord = statusWord.substring(len-4,len);
        
        String result = table.get(statusWord);
        int i=3;
        while(i>=0 && result==null) {
            result = table.get(statusWord.substring(0,i));
            i--;
        }
        return result;
    }
}