/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sintactico;

/**
 *
 * @author HP
 */
public class R {
     public static final String Rr[] = {          "R1 PRINCIPAL -> class id { INSTRUCCION",
        "R2 CONSTRUCTOR -> id ARGS { INSTRUCCION",
      "R3 LLAMAMET -> id . LLAMAMET",
        "R4 LLAMAMET -> id PARAM",
       "R5 DECMET -> LLAMAMET ;",
       "R6 METODO -> TIPOP TIPO id ARGS { INSTRUCCION",
        "R7 METODO -> TIPOP id ARGS { INSTRUCCION",
       "R8 RETORNA -> return id ;",
        "R9 RETORNA -> return NUM ;",
         "R10 BUCLE -> while ( OPERACION ) { INSTRUCCION",
         "R11 CONDICION -> if ( OPERACION ) { INSTRUCCION",
       "R12 CONDICION -> if ( OPERACION ) { INSTRUCCION else { INSTRUCCION"
        , "R13 DECMAIN -> FIRP ( ) { INSTRUCCION"
        , "R14 VAR -> TIPOP TIPO id MASVAR"
        , "R15 VAR -> TIPO id MASVAR"
        , "R16 VAR -> TIPO id MAS"
        , "R17 VAR -> id MAS"
        , "R18 VAR -> id MASVAR"
        , "R19 MASVAR -> = NUM MAS"
        , "R20 MASVAR -> = - NUM MAS"
        , "R21 MASVAR -> = ' id ' MAS"
        , "R22 MASVAR -> = \" MAST MAS"
        , "R23 MASVAR -> = BO MAS"
        , "R24 MASVAR -> = LLAMAMET MAS"
        , "R25 MASVAR -> = OPERACION MAS"
        , "R26 MASVAR -> VECTOR"
        , "R27 MAS -> , id MAS"
        , "R28 MAS -> , id MASVAR"
        , "R29 MAS -> ;"
        , "R30 VECTOR -> [ 300 ] DECV"
        , "R31 DECV -> = { NUM MASV ;"
        , "R32 DECV -> = { ' id ' MASV ;"
        , "R33 DECV -> = { \" MAST MASV ;"
        , "R34 MASV -> , NUM MASV"
        , "R35 MASV -> , ' id ' MASV"
        , "R36 MASV -> , \" MAST MASV"
        , "R37 MASV -> }"
        , "R38 OPERACION -> ( OPERACION ) SIMBOLO MASOP"
        , "R39 OPERACION -> NUM SIMBOLO MASOP"
        , "R40 OPERACION -> id SIMBOLO MASOP"
        , "R41 OPERACION -> LLAMAMET SIMBOLO MASOP"
        , "R42 MASOP -> NUM SIMBOLO MASOP"
        , "R43 MASOP -> id SIMBOLO MASOP"
        , "R44 MASOP -> LLAMAMET SIMBOLO MASOP"
        , "R45 MASOP -> NUM"
        , "R46 MASOP -> id"
        , "R47 MASOP -> LLAMAMET"
        , "R48 SALIDA -> out : \" MAST CONCATENA"
        , "R49 CONCATENA -> + id CONCATENA"
        , "R50 CONCATENA -> + \" MAST CONCATENA"
        , "R51 CONCATENA -> ;"
        , "R52 ENTRADA -> in : id ;"
        , "R53 ENTRADA -> in : id [ id ] ;"
        , "R54 ENTRADA -> in : id [ 300 ] ;"
        , "R55 DECLARAV -> id [ id ] = MASD"
        , "R56 DECLARAV -> id [ 300 ] = MASD"
        , "R57 MASD -> NUM ;"
        , "R58 MASD -> - NUM ;"
        , "R59 MASD -> ' id ' ;"
        , "R60 MASD -> id ;"
        , "R61 MASD -> LLAMAMET"
        , "R62 INSTRUCCION -> CONSTRUCTOR INSTRUCCION"
        , "R63 INSTRUCCION -> LLAMAMET INSTRUCCION"
        , "R64 INSTRUCCION -> DECMET INSTRUCCION"
        , "R65 INSTRUCCION -> RETORNA INSTRUCCION"
        , "R66 INSTRUCCION -> METODO INSTRUCCION"
        , "R67 INSTRUCCION -> BUCLE INSTRUCCION"
        , "R68 INSTRUCCION -> CONDICION INSTRUCCION"
        , "R69 INSTRUCCION -> VAR INSTRUCCION"
        , "R70 INSTRUCCION -> DECLARAV INSTRUCCION"
        , "R71 INSTRUCCION -> ENTRADA INSTRUCCION"
        , "R72 INSTRUCCION -> SALIDA INSTRUCCION"
        , "R73 INSTRUCCION -> DECMAIN INSTRUCCION"
        , "R74 INSTRUCCION -> }"
        , "R75 ARGS -> ( TIPO id MASAR"
        , "R76 ARGS -> ( MASAR"
        , "R77 MASAR -> , TIPO id MASAR"
        , "R78 MASAR -> )"
        , "R79 PARAM -> ( 300 MASP"
        , "R80 PARAM -> ( 301 MASP"
        , "R81 PARAM -> ( ' id ' MASP"
        , "R82 PARAM -> ( \" MAST MASP"
        , "R83 PARAM -> ( LLAMAMET MASP"
        , "R84 PARAM -> ( VACIO"
        , "R85 PARAM -> ( id MASP"
        , "R86 VACIO -> )"
        , "R87 MASP -> , 300 MASP"
        , "R88 MASP -> , 301 MASP"
        , "R89 MASP -> , ' id ' MASP"
        , "R90 MASP -> , \" MAST MASP"
        , "R91 MASP -> , BO MASP"
        , "R92 MASP -> , LLAMAMET MASP"
        , "R93 MASP -> , id MASP"
        , "R94 MASP -> )"
        , "R95 MAST -> id MAST"
        , "R96 MAST -> \""
        , "R97 TIPOP -> pub"
        , "R98 TIPOP -> pri"
        , "R99 TIPO -> int"
        , "R100 TIPO -> real"
        , "R101 TIPO -> ctr"
        , "R102 TIPO -> str"
        , "R103 TIPO -> bool"
        , "R104 TIPO -> id"
        , "R105 SIMBOLO -> +"
        , "R106 SIMBOLO -> -"
        , "R107 SIMBOLO -> *"
        , "R108 SIMBOLO -> /"
        , "R109 SIMBOLO -> mod"
        , "R110 SIMBOLO -> >"
        , "R111 SIMBOLO -> <"
        , "R112 SIMBOLO -> <="
        , "R113 SIMBOLO -> >="
        , "R114 SIMBOLO -> =="
        , "R115 SIMBOLO -> and"
        , "R116 SIMBOLO -> or"
        , "R117 SIMBOLO -> not"
        , "R118 BO -> true"
        , "R119 BO -> false"
        , "R120 NUM -> 300"
        , "R121 NUM -> 301"};
    
     
    
}
