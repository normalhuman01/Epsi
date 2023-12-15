

package Easy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ArchivoCSV {
    
    public static void main(String args[]) throws IOException{
        
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\HP\\Desktop\\TT.csv"))){
            String line;
            boolean linea = true;
            String s = "{";
            while((line = br.readLine()) != null){
                String[] values = line.split(";");
                s += "{";
                for(int i = 0; i < values.length-1; i++){
//                    s += "\"" + values[i] + "\",";
                    if(!values[i].equals("0")){
                        String n = "";
                        switch (values[i].charAt(0)) {
                            case 'R':
                                for(int j = 1; j < values[i].length(); j++){
                                    n += values[i].charAt(j);
                                }   
                                s += "R[" + n + "],";
                                break;
                            case 'D':
                                s += "\"" + values[i] + "\",";
                                break;
                            default:
//                                s += "\"" + values[i] + "\",";
                                s += null +",";
                                break;
                        }
                    }else if(values[i].equals("0")){
//                        s += "\"" + "\",";
                          s += null +",";
                    }
                }
                
                if(values[values.length-1].charAt(0) == 'R'){
                    String n = "";
                    for(int j = 1; j < values[values.length-1].length(); j++){
                        n += values[values.length-1].charAt(j);
                    }
                    s += "R["+ n + "]},\n";
                }else if (values[values.length-1].equals("0")){
//                    s += "\"" + "\"},\n";
                    s += null +",\n";
                }else{
                    s += "\"" + values[values.length-1] + "\"},\n";
                }
            }
            s += "};";
            System.out.println(s);
        }catch (FileNotFoundException ex){
            Logger.getLogger(ArchivoCSV.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex){
            Logger.getLogger(ArchivoCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
