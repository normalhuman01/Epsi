
package Sintactico;


import Lexico.ScannerEpsi;
import java.util.ArrayDeque;
import java.util.Deque;


public class ParserEpsi {
    Deque<String> pila = new ArrayDeque<>();
    String cadena;
    private int apunta;
    private int pos;
   // private final TAS_Accion ta;
    private final TAS_IrA tr;
    private final TAS_Accion ta;
    private String UIpila;
    private String UIentrada;
    private String UIsalida;
    ;
    
    public ParserEpsi(){
        pila.push("0");     // Primer estado en la pila
        apunta = 0;         // Apunto al primer elemento de la cadena ingesada
        pos = 0;            // Posicion actual
        UIpila = pila.toString() + "\n";  // String de la pila a mostrar
        UIsalida = "";      // String de la salida a mostrar
        ta = new TAS_Accion();
        tr = new TAS_IrA();
    }
    
    public String getCadena(){
        return cadena;
    }
      
    public String getPila(){
        return UIpila; 
    } 
    
    public String getEntrada(){
        return UIentrada;
    }
    
    public String getSalida(){
        return UIsalida;
    }
        
    public void Leer(String cadena){
        this.cadena = cadena + "$";
        UIentrada = this.cadena + "\n";
    }
      
    private String Lexico(){
        String a = "";
        ScannerEpsi lex;
        for (int i = pos; i < cadena.length(); i++){
            if(cadena.charAt(i) != ' '){
                a += cadena.charAt(i);
                apunta++;
            }else{
                break;
            }
        }
        lex = new ScannerEpsi(a);
        String token = Integer.toString(lex.obtenerToken());
        
        if (a.equals("$")){
            return "$";
        }
        return token;
    }
    
    private void Error(){
        System.out.println("Cadena no valida.");
        System.exit(1);
    }
    
    public void Sintactico(ScannerEpsi t){  
        String retEntrada = "";   // Retiene la cadena de entrada al momento de reduci
        
        while(true){
            String token = Integer.toString(t.obtenerToken());
            if(!token.equals("600")){
                String s = pila.getFirst();         // Recibe el estado 
                String a = token;    // Recibe simbolo de la cadena
                if (a.equals("0")){
                    a = "$";
                }
                String accion = ta.Accion(s, a);     // Retorna D o R

                if(accion.charAt(0) == 'D'){
                    String estado = "";
    //                String entrada = cadena;

                    for (int i=1; i<accion.length(); i++){
                        estado += accion.charAt(i);
                    }

                    pila.push(a);
                    pila.push(estado);
                    UIpila += pila.toString() + "\n";   // Agregamos los estados de la pila para mostrar en pantalla
                    UIsalida += accion + "\n";
                }else if(accion.charAt(0) == 'R'){
                    String terminal = "";
                    String estado;
                    int nro_t = 0;

                    for(int i = 0; i<accion.length(); i++){
                        if(accion.charAt(i) == ' '){
                            nro_t++;
                        }
                    }

                    nro_t = nro_t - 2;

                    for(int j = 0; j<2*nro_t; j++){
                        pila.pop();
                    }

                    int cont = 1;
                    for (int i = 0; i<accion.length(); i++){
                        if(accion.charAt(i) == ' '){
                            break;
                        }
                        cont++;
                    }

                    for ( int i = cont; i<accion.length(); i++){
                        if(accion.charAt(i) == ' '){
                            break;
                        }
                        terminal += accion.charAt(i);
                    }

                    estado = tr.Ir_A(pila.getFirst(), terminal); 
                    pila.push(terminal);     // Apila el simbolo encontrar el simbolo del lado izquierdo 
                    pila.push(estado);
                    UIpila += pila.toString() + "\n";   // Agregamos los estados de la pila para mostrar en pantalla
//                    UIentrada += retEntrada + "\n";
                    UIsalida += accion + "\n";
                }else if(accion.equals("ACEPTAR")){
                    UIsalida += accion + "\n";
                    break;
                }else{
                    Error();
                }
            }
        }// Fin del while
    }//Fin de Sintactico  
}

