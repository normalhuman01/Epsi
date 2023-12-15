
package Lexico;


public class ScannerEpsi {
    
    private int pos = 0;
    private final String entrada;
    private String buffer;
    private String operadorC;   
    // Se usará este string en vez de buffer para operadores de dos caracteres
    
    public ScannerEpsi(String entrada){
        String text = entrada.replaceAll("\n", "! ");
        this.entrada = text.replaceAll("\t", " ") + "$";
    };
    
    public String getEntrada(){
        return entrada;
    }
    
    public String getBuffer(){
        return buffer;
    }
    
    public String getoperadorC(){
        return operadorC;
    }
    
    String Reservada[] = 
        {"FIRP", "class", "pri", "pub",         // main y declaraciones
        "int", "real", "bool", "ctr", "str",    // tipos de variable
        "while", "in", "out", "return",         // iteracion, E/S y retorno
        "true", "false", "if", "else",          // condicion 
        "mod", "and", "or", "not"};             // operador logico
    
    //Operadores relacionales
    char OperadorS[] = {'+', '-', '/', '*', '<', '>', '='}; 
    String OperadorC[] = {"<=", ">=", "=="};                     
    char Delimitador[] = {'(', ')', '{', '}', '[', ']',';', ',', ':', '"', '\'', '.'}; 
    
    public int getTamReservada(){
        return Reservada.length;
    }
    
    public int getTamOperadorS(){
        return OperadorS.length;
    }
    
    public int getTamOperadorC(){
        return OperadorC.length;
    }
    
    public int getTamDelimitador(){
        return Delimitador.length;
    }
    
    private int BuscarReservado(String x){
        for(int i=0; i<Reservada.length; i++){
            if(x.equals(Reservada[i])){
                return 200+i;
            }
        }
        return 100;
    }
    
    private int BuscarNumero(String x){
        int cont = 0;
        boolean entero = true;
        //Guardo cada caracter del buffer en un arreglo
        char a[] = x.toCharArray(); 
        for(int i=0; i<a.length; i++){
            if(a[i]=='.'){//Si el arreglo contiene un punto es real
                cont++;
                entero = false;
            }
        }
        if(entero){
            return 300;
        }else if(!entero && cont == 1){
            return 301;
        }else{
            return 911;
        }
    }
    
    private int BuscarOperadorS(String x){
        int i;
        for(i=0; i<OperadorS.length; i++){
            if(x.equals(Character.toString(OperadorS[i]))){
                break;
            }
        }
        return 400+i;
    }
    
    private int BuscarOperadorC(String x){
        int i;
        for(i=0; i<OperadorC.length; i++){
            if(x.equals(OperadorC[i])){
                break;
            }
        }
        return 407+i;
    }
    
    private int BuscarDelimitador(String x){
        int i;
        for(i=0; i<Delimitador.length; i++){
            if(x.equals(Character.toString(Delimitador[i]))){
                break;
            }
        }
        return 500+i;
    }

    private int BuscarSalto(String x){
        if(x.equals("!")){
            return 600;
        }
        return 911;
    }   
    
     private boolean esSalto(char x){
        return x == '!';
    }
            
    private boolean esOperadorS(char x){
        for(int i=0; i<OperadorS.length;i++){
            if(x == OperadorS[i]){
                return true;
            }
        }
        return false;
    }
    
    private boolean esOperadorC(String x){
        for (String OperadorC1 : OperadorC) {
            if (x.equals(OperadorC1)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean esDelimitador(char x) {
        for (int i = 0; i < Delimitador.length; i++) {
            if (x == Delimitador[i]) {
                return true;
            }
        }
        return false;
    }
    
    private boolean esComentario(char x){
        return x == '#' || x == '%';
    }
    
    public int obtenerToken(){
        buffer = "";
        int flag = 0, opc = 0;
        char sgte;
        
        for(;;){
            sgte = entrada.charAt(pos);     //Guarda el primer caracter en sgte
            if(sgte == '$' && flag == 0){   //Si no hay ningun caracter retorna 0
                return 0;
            }else if(sgte == '$'){          //lee el ultimo caracter '$'
                switch (opc){
                    case 1: return BuscarReservado(buffer);
                    case 2: return BuscarNumero(buffer);
                    case 3: return BuscarOperadorC(operadorC);
                    case 4: return BuscarOperadorS(buffer);
                    case 5: return BuscarDelimitador(buffer);
                    case 6: return BuscarSalto(buffer);
                }//Fin switch
            }else{
                buffer = buffer.trim();
                
                // Para operadoresC 
                char aux = entrada.charAt(pos+1);
                String aux2 = Character.toString(sgte) + Character.toString(aux);
                switch(opc){
                    case 0:
                        buffer += sgte;
                        if(Character.isLetter(sgte)){
                            opc = 1; flag++;
                        }else if(Character.isDigit(sgte)){
                            opc = 2; flag++;
                        }else if(esOperadorC(aux2)){
                            operadorC = aux2;
                            opc = 3; flag++;
                        }else if(esOperadorS(sgte)){
                            opc = 4; flag++;
                        }else if(esDelimitador(sgte)){
                            opc = 5; flag++;
                        }else if(esSalto(sgte)){
                            opc = 6; flag++;
                        }else if(esComentario(sgte)){
                            opc = 7; flag++;
                        }else if(sgte != ' '){
                            return 555;
                        }else{
                            opc = 0;
                        }
                        break;
                        
                    case 1:
                        if(Character.isLetterOrDigit(sgte)){
                            buffer += sgte; opc = 1;
                        }else{
                            return BuscarReservado(buffer);
                        }
                        break;
                        
                    case 2:
                        if(Character.isDigit(sgte) || sgte == '.'){
                            buffer += sgte; opc = 2;
                        }else{
                            return BuscarNumero(buffer);
                        }
                        break;
                        
                    case 3:
                        pos++;
                        return BuscarOperadorC(operadorC);
                        
                    case 4:
                        return BuscarOperadorS(buffer);

                    case 5: 
                        return BuscarDelimitador(buffer);
                        
                    case 6:
                        return BuscarSalto(buffer);
                        
                    case 7:
                        
                        if (entrada.charAt(pos-1) == '#'){
                           while(entrada.charAt(pos) != '!'){
                            pos++;
                            } 
                        }else if (entrada.charAt(pos-1) == '%'){
                            while(entrada.charAt(pos) != '%'){
                            pos++;
                            }
                            pos++;
                        }
                        
                    return 600;
                    
                }//Fin switch
            }//Fin if
            
            pos++;
            
        }//Fin for  
    }
}
