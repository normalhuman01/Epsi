package Sintactico;

import java.util.Arrays;


public class TAS_Accion {
    
    private final String ACCION[][] = new String[283][48];
    private final String R[] = new String[122];
    
    public TAS_Accion(){
        int f;
        
        R[1] = "R1 PRINCIPAL -> class id { INSTRUCCION";
        R[2] = "R2 CONSTRUCTOR -> id ARGS { INSTRUCCION";
        R[3] = "R3 LLAMAMET -> id . LLAMAMET";
        R[4] = "R4 LLAMAMET -> id PARAM";
        R[5] = "R5 DECMET -> LLAMAMET ;";
        R[6] = "R6 METODO -> TIPOP TIPO id ARGS { INSTRUCCION";
        R[7] = "R7 METODO -> TIPOP id ARGS { INSTRUCCION";
        R[8] = "R8 RETORNA -> return id ;";
        R[9] = "R9 RETORNA -> return NUM ;";
        R[10] = "R10 BUCLE -> while ( OPERACION ) { INSTRUCCION";
        R[11] = "R11 CONDICION -> if ( OPERACION ) { INSTRUCCION ";
        R[12] = "R12 CONDICION -> if ( OPERACION ) { INSTRUCCION else { INSTRUCCION";
        R[13] = "R13 DECMAIN -> FIRP ( ) { INSTRUCCION";
        R[14] = "R14 VAR -> TIPOP TIPO id MASVAR";
        R[15] = "R15 VAR -> TIPO id MASVAR";
        R[16] = "R16 VAR -> TIPO id MAS";
        R[17] = "R17 VAR -> id MAS";
        R[18] = "R18 VAR -> id MASVAR";
        R[19] = "R19 MASVAR -> = NUM MAS";
        R[20] = "R20 MASVAR -> = - NUM MAS";
        R[21] = "R21 MASVAR -> = ' id ' MAS";
        R[22] = "R22 MASVAR -> = \" MAST MAS";
        R[23] = "R23 MASVAR -> = BO MAS";
        R[24] = "R24 MASVAR -> = LLAMAMET MAS";
        R[25] = "R25 MASVAR -> = OPERACION MAS";
        R[26] = "R26 MASVAR -> VECTOR";
        R[27] = "R27 MAS -> , id MAS";
        R[28] = "R28 MAS -> , id MASVAR";
        R[29] = "R29 MAS -> ;";
        R[30] = "R30 VECTOR -> [ 300 ] DECV";
        R[31] = "R31 DECV -> = { NUM MASV ;";
        R[32] = "R32 DECV -> = { ' id ' MASV ;";
        R[33] = "R33 DECV -> = { \" MAST MASV ;";
        R[34] = "R34 MASV -> , NUM MASV";
        R[35] = "R35 MASV -> , ' id ' MASV";
        R[36] = "R36 MASV -> , \" MAST MASV";
        R[37] = "R37 MASV -> }";
        R[38] = "R38 OPERACION -> ( OPERACION ) SIMBOLO MASOP";
        R[39] = "R39 OPERACION -> NUM SIMBOLO MASOP";
        R[40] = "R40 OPERACION -> id SIMBOLO MASOP";
        R[41] = "R41 OPERACION -> LLAMAMET SIMBOLO MASOP";
        R[42] = "R42 MASOP -> NUM SIMBOLO MASOP";
        R[43] = "R43 MASOP -> id SIMBOLO MASOP";
        R[44] = "R44 MASOP -> LLAMAMET SIMBOLO MASOP";
        R[45] = "R45 MASOP -> NUM";
        R[46] = "R46 MASOP -> id";
        R[47] = "R47 MASOP -> LLAMAMET";
        R[48] = "R48 SALIDA -> out : \" MAST CONCATENA";
        R[49] = "R49 CONCATENA -> + id CONCATENA";
        R[50] = "R50 CONCATENA -> + \" MAST CONCATENA";
        R[51] = "R51 CONCATENA -> ;";
        R[52] = "R52 ENTRADA -> in : id ;";
        R[53] = "R53 ENTRADA -> in : id [ id ] ;";
        R[54] = "R54 ENTRADA -> in : id [ 300 ] ;";
        R[55] = "R55 DECLARAV -> id [ id ] = MASD";
        R[56] = "R56 DECLARAV -> id [ 300 ] = MASD";
        R[57] = "R57 MASD -> NUM ;";
        R[58] = "R58 MASD -> - NUM ;";
        R[59] = "R59 MASD -> ' id ' ;";
        R[60] = "R60 MASD -> id ;";
        R[61] = "R61 MASD -> LLAMAMET";
        R[62] = "R62 INSTRUCCION -> CONSTRUCTOR INSTRUCCION";
        R[63] = "R63 INSTRUCCION -> LLAMAMET INSTRUCCION";
        R[64] = "R64 INSTRUCCION -> DECMET INSTRUCCION";
        R[65] = "R65 INSTRUCCION -> RETORNA INSTRUCCION";
        R[66] = "R66 INSTRUCCION -> METODO INSTRUCCION";
        R[67] = "R67 INSTRUCCION -> BUCLE INSTRUCCION";
        R[68] = "R68 INSTRUCCION -> CONDICION INSTRUCCION";
        R[69] = "R69 INSTRUCCION -> VAR INSTRUCCION";
        R[70] = "R70 INSTRUCCION -> DECLARAV INSTRUCCION";
        R[71] = "R71 INSTRUCCION -> ENTRADA INSTRUCCION";
        R[72] = "R72 INSTRUCCION -> SALIDA INSTRUCCION";
        R[73] = "R73 INSTRUCCION -> DECMAIN INSTRUCCION";
        R[74] = "R74 INSTRUCCION -> }";
        R[75] = "R75 ARGS -> ( TIPO id MASAR";
        R[76] = "R76 ARGS -> ( MASAR";
        R[77] = "R77 MASAR -> , TIPO id MASAR";
        R[78] = "R78 MASAR -> )";
        R[79] = "R79 PARAM -> ( 300 MASP";
        R[80] = "R80 PARAM -> ( 301 MASP";
        R[81] = "R81 PARAM -> ( ' id ' MASP";
        R[82] = "R82 PARAM -> ( \" MAST MASP";
        R[83] = "R83 PARAM -> ( LLAMAMET MASP";
        R[84] = "R84 PARAM -> ( VACIO";
        R[85] = "R85 PARAM -> ( id MASP";
        R[86] = "R86 VACIO -> )";
        R[87] = "R87 MASP -> , 300 MASP";
        R[88] = "R88 MASP -> , 301 MASP";
        R[89] = "R89 MASP -> , ' id ' MASP";
        R[90] = "R90 MASP -> , \" MAST MASP";
        R[91] = "R91 MASP -> , BO MASP";
        R[92] = "R92 MASP -> , LLAMAMET MASP";
        R[93] = "R93 MASP -> , id MASP";
        R[94] = "R94 MASP -> )";
        R[95] = "R95 MAST -> id MAST";
        R[96] = "R96 MAST -> \"";
        R[97] = "R97 TIPOP -> pub";
        R[98] = "R98 TIPOP -> pri";
        R[99] = "R99 TIPO -> int";
        R[100] = "R100 TIPO -> real";
        R[101] = "R101 TIPO -> ctr";
        R[102] = "R102 TIPO -> str";
        R[103] = "R103 TIPO -> bool";
        R[104] = "R104 TIPO -> id";
        R[105] = "R105 SIMBOLO -> +";
        R[106] = "R106 SIMBOLO -> -";
        R[107] = "R107 SIMBOLO -> *";
        R[108] = "R108 SIMBOLO -> /";
        R[109] = "R109 SIMBOLO -> mod";
        R[110] = "R110 SIMBOLO -> >";
        R[111] = "R111 SIMBOLO -> <";
        R[112] = "R112 SIMBOLO -> <=";
        R[113] = "R113 SIMBOLO -> >=";
        R[114] = "R114 SIMBOLO -> ==";
        R[115] = "R115 SIMBOLO -> and";
        R[116] = "R116 SIMBOLO -> or";
        R[117] = "R117 SIMBOLO -> not";
        R[118] = "R118 BO -> true";
        R[119] = "R119 BO -> false";
        R[120] = "R120 NUM -> 300";
        R[121] = "R121 NUM -> 301";
       
                 
        ACCION[0][0] = "201";
        ACCION[1][0] = "D2";
        
        ACCION[0][1] = "100";
        ACCION[3][1] = "D3";
        ACCION[5][1] = "D19";
        for ( int i = 7; i < 19; i++){
            ACCION[i][1] = "D19";
        }
        ACCION[19][1] = R[74];
        ACCION[20][1] = R[104];
        ACCION[21][1] = "D59";
        ACCION[22][1] = "D64";
        ACCION[25][1] = "D67";
        f = 97;
        for (int i = 29 ; i < 36; i++){
            ACCION[i][1] = R[f];
            f++;
        }
        ACCION[36][1] = R[62];
        ACCION[37][1] = R[63];
        ACCION[38][1] = R[5];
        f = 64;
        for (int i = 39; i < 49; i++){
            ACCION[i][1] = R[f];
            f++;
        }
        ACCION[50][1] = "D73";
        ACCION[51][1] = R[4];
        ACCION[52][1] = R[17];
        ACCION[53][1] = R[18];
        ACCION[54][1] = "D74";
        ACCION[55][1] = "D84";
        ACCION[56][1] = "D87";
        ACCION[57][1] = R[29];
        ACCION[58][1] = "D97";
        ACCION[59][1] = R[26];
        ACCION[64][1] = "D101";
        ACCION[65][1] = R[104];
        ACCION[66][1] = "D97";
        ACCION[67][1] = "D97";
        ACCION[69][1] = "D111";
        ACCION[72][1] = "D19";
        ACCION[73][1] = R[3];
        ACCION[77][1] = "D118";
        ACCION[81][1] = "D123";
        ACCION[82][1] = "D125";
        ACCION[84][1] = R[84];
        ACCION[85][1] = R[104];
        ACCION[86][1] = "D130";
        ACCION[87][1] = R[86];
        ACCION[91][1] = "D149";
        ACCION[92][1] = "D125";
        ACCION[99][1] = "D97";
        ACCION[100][1] = R[8];
        ACCION[101][1] = R[9];
        ACCION[104][1] = "D130";
        ACCION[109][1] = R[15];
        ACCION[110][1] = R[16];
        ACCION[113][1] = "D125";
        ACCION[115][1] = R[2];
        ACCION[116][1] = "D168";
        ACCION[120][1] = R[79];
        ACCION[121][1] = "D180";
        ACCION[122][1] = R[94];
        ACCION[123][1] = R[80];
        ACCION[126][1] = "D126";
        ACCION[128][1] = R[83];
        ACCION[129][1] = R[85];
        ACCION[130][1] = "D184";
        ACCION[131][1] = R[104];
        ACCION[132][1] = R[27];
        ACCION[133][1] = R[28];
        ACCION[134][1] = R[19];
        ACCION[135][1] = "D187";
        f = 105;
        for (int i = 136; i < 149; i++){
            ACCION[i][1] = R[f];
            f++;
        }
        ACCION[152][1] = R[23];
        ACCION[153][1] = R[24];
        ACCION[154][1] = "D187";
        ACCION[155][1] = R[25];
        ACCION[156][1] = "D187";
        ACCION[159][1] = R[14];
        ACCION[160][1] = "D19";
        ACCION[165][1] = R[52];
        ACCION[166][1] = "D200";
        ACCION[168][1] = "D19";
        ACCION[170][1] = R[86];
        ACCION[171][1] = "D210";
        ACCION[172][1] = "D210";
        ACCION[173][1] = R[30];
        ACCION[177][1] = "D216";
        ACCION[178][1] = "D125";
        ACCION[183][1] = R[82];
        ACCION[190][1] = R[20];
        ACCION[192][1] = R[22];
        ACCION[196][1] = "D19";
        ACCION[197][1] = R[7];
        ACCION[198][1] = "D19";
        ACCION[199][1] = "D19";
        ACCION[203][1] = R[48];
        ACCION[204][1] = "D234";
        ACCION[205][1] = R[51];
        ACCION[206][1] = R[13];
        ACCION[207][1] = R[55];
        ACCION[210][1] = "D238";
        ACCION[213][1] = R[56];
        ACCION[215][1] = R[87];
        ACCION[216][1] = R[88];
        ACCION[219][1] = R[91];
        ACCION[220][1] = R[92];
        ACCION[221][1] = R[93];
        ACCION[222][1] = R[81];
        ACCION[224][1] = "D187";
        ACCION[225][1] = "D187";
        ACCION[226][1] = "D187";
        ACCION[227][1] = R[21];
        ACCION[228][1] = "D187";
        ACCION[229][1] = R[6];
        ACCION[230][1] = R[10];
        ACCION[231][1] = R[11];
        ACCION[236][1] = "D125";
        ACCION[237][1] = R[57];
        ACCION[240][1] = R[60];
        ACCION[241][1] = R[61];
        ACCION[243][1] = "D260";
        ACCION[244][1] = "D125";
        ACCION[246][1] = R[90];
        ACCION[252][1] = R[53];
        ACCION[253][1] = R[54];
        ACCION[254][1] = R[49];
        ACCION[256][1] = R[58];
        ACCION[263][1] = R[89];
        ACCION[264][1] = "D19";
        ACCION[265][1] = R[50];
        ACCION[266][1] = R[59];
        ACCION[267][1] = R[31];
        ACCION[269][1] = "D274";
        ACCION[270][1] = "D125";
        ACCION[273][1] = R[12];
        ACCION[278][1] = R[33];
        ACCION[281][1] = R[32];
        
        ACCION[0][2] = "502";
        ACCION[4][2] = "D4";
        ACCION[49][2] = "D71";
        ACCION[78][2] = R[76];
        ACCION[87][2] = R[78];
        ACCION[103][2] = "D159";
        ACCION[114][2] = "D167";
        ACCION[158][2] = "D195";
        ACCION[161][2] = R[78];
        ACCION[162][2] = "D197";
        ACCION[163][2] = "D198";
        ACCION[172][2] = "D213";
        ACCION[174][2] = R[75];
        ACCION[223][2] = R[77];
        ACCION[232][2] = "D213";
        ACCION[251][2] = "D263";
        
        ACCION[0][3] = "511";
        ACCION[20][3] = "D49";
        ACCION[74][3] = "D49";
        ACCION[84][3] = "D49";
        ACCION[98][3] = "D49";
        ACCION[169][3] = "D49";
        ACCION[181][3] = "D49";
        ACCION[188][3] = "D49";
        ACCION[211][3] = "D49";
        
        ACCION[0][4] = "506";
        ACCION[8][4] = "D37";
        ACCION[20][4] = "D56";
        Llena(51, 4);
        ACCION[60][4] = "D99";
        ACCION[61][4] = "D100";
        ACCION[62][4] = R[120];
        ACCION[63][4] = R[121];
        ACCION[68][4] = "D56";
        Llena(73, 3);
        Llena(84, 84);
        Llena(87, 86);
        ACCION[88][4] = "D56";
        ACCION[89][4] = "D56";
        ACCION[93][4] = "D56";
        ACCION[94][4] = "D56";
        ACCION[95][4] = "D56";
        ACCION[96][4] = R[118];
        ACCION[97][4] = R[119];
        ACCION[112][4] = "D164";
        Llena(120, 79);
        Llena(122, 94);
        Llena(123, 80);
        ACCION[127][4] = R[96]; 
        Llena(128, 83);
        Llena(129, 85);
        ACCION[149][4] = "D56";
        ACCION[151][4] = "D56";
        ACCION[167][4] = "D204";
        Llena(170, 86);
        Llena(183, 83);
        ACCION[184][4] = R[95];
        ACCION[186][4] = R[39];
        ACCION[187][4] = R[45];
        ACCION[188][4] = R[46];
        ACCION[189][4] = R[47];
        ACCION[191][4] = "D56";
        ACCION[193][4] = R[41];
        ACCION[194][4] = R[40];
        ACCION[208][4] = "D236";
        ACCION[211][4] = "D239";
        ACCION[212][4] = "D240";
        Llena(215, 87);
        Llena(216, 88);
        Llena(219, 91);
        Llena(220, 92);
        Llena(221, 93);
        Llena(222, 81);
        ACCION[233][4] = "D251";
        ACCION[234][4] = "D252";
        ACCION[235][4] = "D204";
        ACCION[238][4] = "D255";
        Llena(246, 90);
        ACCION[247][4] = R[42];
        ACCION[248][4] = R[43];
        ACCION[249][4] = R[44];
        ACCION[250][4] = R[38];
        ACCION[255][4] = "D204";
        ACCION[257][4] = "D265";
        ACCION[258][4] = "D266";
        ACCION[260][4] = R[37];
        Llena(263, 89);
        ACCION[272][4] = "D277";
        ACCION[274][4] = R[34];
        ACCION[277][4] = "D280";
        ACCION[280][4] = R[36];
        ACCION[282][4] = R[35];
        
        ACCION[0][5] = "212";
        ACCION[5][5] = "D20";
        for (int i = 7; i < 19; i++){
            ACCION[i][5] = "D20";
        }
        Llena2(19, 74);
        Llena2(36, 62);
        Llena2(37, 63);
        Llena2(39, 64);
        Llena2(40, 65);
        Llena2(41, 66);
        Llena2(42, 67);
        Llena2(43, 68);
        Llena2(44, 69);
        Llena2(45, 70);
        Llena2(46, 71);
        Llena2(47, 72);
        Llena2(48, 73);
        Llena3(38, 5);
        Llena3(52, 17);
        Llena3(53, 18);
        Llena3(57, 29);
        Llena3(59, 26);
        ACCION[72][5] = "D20";
        Llena3(100, 8);
        Llena3(101, 9);
        Llena3(109, 15);
        Llena3(110, 16);
        Llena3(115, 2);
        ACCION[128][5] = R[83];
        ACCION[129][5] = R[85];
        Llena3(132, 27);
        Llena3(133, 28);
        Llena3(134, 19);
        Llena3(152, 23);
        Llena3(153, 24);
        Llena3(155, 25);
        Llena3(159, 14);
        ACCION[160][5] = "D20";
        Llena3(165, 52);
        ACCION[168][5] = "D20";
        Llena3(173, 30);
        Llena3(190, 20);
        Llena3(192, 22);
        ACCION[196][5] = "D20";
        ACCION[197][5] = R[7];
        ACCION[198][5] = ACCION[199][5] = "D20";
        Llena3(203, 48);
        Llena3(205, 51);
        Llena3(206, 13);
        Llena3(207, 55);
        Llena3(213, 56);
        Llena3(227, 21);
        Llena3(229, 6);
        Llena3(230, 10);
        ACCION[231][5] = R[11];
        Llena3(237, 57);
        Llena3(240, 60);
        Llena3(241, 61);
        Llena3(252, 53);
        Llena3(253, 54);
        Llena3(254, 49);
        Llena3(256, 58);
        ACCION[264][5] = "D20";
        Llena3(265, 50);
        Llena3(266, 59);
        Llena3(267, 31);
        Llena3(273, 12);
        Llena3(278, 33);
        Llena3(281, 32);
        
        ACCION[0][6] = "209";
        ACCION[5][6] = "D22";
        for (int i = 7; i < 19; i++){
            ACCION[i][6] = "D22";
        }
        ACCION[72][6] = "D22";
        Llena4(128, 83);
        Llena4(129, 85);
        ACCION[160][6] = "D22";
        ACCION[168][6] = "D22";
        ACCION[196][6] = ACCION[198][6] = ACCION[199][6] = "D22";
        ACCION[197][6] = R[7];
        ACCION[231][6] = R[11];
        ACCION[264][6] = "D22";
        
        ACCION[0][7] = "500";
        ACCION[20][7] = "D54";
        ACCION[23][7] = "D65";
        ACCION[24][7] = "D66";
        ACCION[28][7] = "D70";
        ACCION[58][7] = "D98";
        ACCION[65][7] = "D103";
        ACCION[66][7] = ACCION[67][7] = "D98";
        ACCION[74][7] = ACCION[85][7] = ACCION[98][7] = "D115";
        ACCION[99][7] = "D98";
        ACCION[102][7] = "D103";
        ACCION[169][7] = ACCION[181][7] = ACCION[188][7] = ACCION[211][7] = "D115";
        
        ACCION[0][8] = "501";
        ACCION[55][8] = "D86";
        ACCION[62][8] = R[120];
        ACCION[63][8] = R[121];
        ACCION[71][8] = "D113";
        ACCION[79][8] = ACCION[80][8] = ACCION[83][8] = ACCION[85][8] = "D121";
        ACCION[96][8] = R[118];
        ACCION[97][8] = R[119];
        ACCION[104][8] = "D160";
        ACCION[105][8] = "D161";
        ACCION[108][8] = "D162";
        ACCION[116][8] = "D169";
        ACCION[119][8] = "D160";
        ACCION[125][8] = "D121";
        ACCION[127][8] = R[96];
        ACCION[157][8] = "D194";
        ACCION[169][8] = ACCION[175][8] = ACCION[176][8] = ACCION[179][8] = 
        ACCION[180][8] = ACCION[181][8] = ACCION[182][8] = "D121";
        ACCION[184][8] = R[95];
        ACCION[185][8] = "D160";
        ACCION[186][8] = R[39];
        ACCION[187][8] = R[45];
        ACCION[188][8] = R[46];
        ACCION[189][8] = R[47];
        ACCION[193][8] = R[41];
        ACCION[194][8] = R[40];
        ACCION[218][8] = ACCION[245][8] = "D121";
        ACCION[247][8] = R[42];
        ACCION[248][8] = R[43];
        ACCION[249][8] = R[44];
        ACCION[250][8] = R[38];
        
        ACCION[0][9] = "215";
        ACCION[5][9] = "D23";
        for (int i = 7; i < 19; i++){
            ACCION[i][9] = "D23";
        }
        ACCION[72][9] = ACCION[160][9] = ACCION[168][9] = ACCION[196][9] = 
        ACCION[198][9] = ACCION[199][9] = "D23";
        ACCION[197][9] = R[7];
        ACCION[231][9] = R[11];
        ACCION[264][9] = "D23";
        
        ACCION[0][10] = "216";
        ACCION[231][10] = "D250";
        
        ACCION[0][11] = "200";
        ACCION[5][11] = "D27";
        for (int i = 7; i < 19; i++){
            ACCION[i][11] = "D27";
        }
        ACCION[72][11] = ACCION[168][11] = ACCION[160][11] = ACCION[196][11] = 
        ACCION[198][11] = ACCION[199][11] = "D27";
        ACCION[197][11] = R[7];
        ACCION[231][11] = R[11];
        ACCION[264][11] = "D27";
        
        ACCION[0][12] = "406";
        ACCION[20][12] = ACCION[68][12] = ACCION[88][12] = ACCION[102][12] = "D57";
        ACCION[117][12] = "D170";
        ACCION[118][12] = "D171";
        ACCION[200][12] = "D231";
        
        ACCION[0][13] = "401";
        ACCION[58][13] = "D89";
        ACCION[62][13] = R[120];
        ACCION[63][13] = R[121];
        ACCION[89][13] = ACCION[94][13] = ACCION[98][13] = ACCION[106][13] = 
        ACCION[107][13] = "D136";
        ACCION[171][13] = ACCION[172][13] = "D208";
        ACCION[187][13] = ACCION[188][13] = ACCION[189][13] = ACCION[195][13] = "D136";
        
        ACCION[0][14] = "510";
        ACCION[55][14] = "D80";
        ACCION[58][14] = "D90";
        ACCION[116][14] = "D80";
        ACCION[121][14] = "D176";
        ACCION[124][14] = "D181";
        ACCION[150][14] = "D190";
        ACCION[171][14] = ACCION[172][14] = "D209";
        ACCION[214][14] = "D242";
        ACCION[217][14] = "D244";
        ACCION[239][14] = "D256";
        ACCION[259][14] = "D268";
        ACCION[261][14] = "D270";
        ACCION[275][14] = "D278";
        
        ACCION[0][15] = "509";
        ACCION[55][15] = "D81";
        ACCION[58][15] = "D91";
        ACCION[70][15] = "D112";
        ACCION[82][15] = ACCION[92][15] = ACCION[113][15] = "D126";
        ACCION[116][15] = "D81";
        ACCION[121][15] = "D177";
        ACCION[126][15] = ACCION[178][15] = "D126";
        ACCION[204][15] = "D235";
        ACCION[214][15] = "D243";
        ACCION[236][15] = ACCION[244][15] = "D126";
        ACCION[259][15] = "D269";
        ACCION[270][15] = "D126";
        
        ACCION[0][16] = "507";
        ACCION[20][16] = "D55";
        ACCION[55][16] = "D85";
        ACCION[62][16] = R[120];
        ACCION[63][16] = R[121];
        ACCION[67][16] = "D55";
        ACCION[79][16] = ACCION[80][16] = ACCION[83][16] = ACCION[85][16] = "D120";
        ACCION[88][16] = ACCION[89][16] = ACCION[93][16] = ACCION[94][16] = ACCION[95][16] = "D55";
        ACCION[96][16] = R[118];
        ACCION[97][16] = R[119];
        ACCION[104][16] = ACCION[119][16] = "D85";
        ACCION[125][16] = "D120";
        ACCION[127][16] = R[96];
        ACCION[149][16] = ACCION[151][16] = "D55";
        ACCION[169][16] = ACCION[175][16] = ACCION[176][16] = ACCION[179][16] = 
        ACCION[180][16] = ACCION[181][16] = ACCION[182][16] = "D120";
        ACCION[184][16] = R[95];
        ACCION[185][16] = "D85";
        ACCION[186][16] = R[39];
        ACCION[187][16] = R[45];
        ACCION[188][16] = R[46];
        ACCION[189][16] = R[47];
        ACCION[191][16] = "D55";
        ACCION[193][16] = R[41];
        ACCION[194][16] = R[40];
        ACCION[218][16] = ACCION[245][16] = "D120";
        ACCION[242][16] = "D258";
        ACCION[247][16] = R[42];
        ACCION[248][16] = R[43];
        ACCION[249][16] = R[44];
        ACCION[250][16] = R[38];
        ACCION[262][16] = ACCION[268][16] = ACCION[271][16] = ACCION[276][16] = ACCION[279][16] = "D258";
        
        ACCION[0][17] = "504";
        ACCION[20][17] = "D53";
        ACCION[68][17] = ACCION[88][17] = ACCION[102][17] = "D110";
        ACCION[112][17] = "D165";
        
        ACCION[0][18] = "300";
        ACCION[21][18] = "D61";
        ACCION[54][18] = "D75";
        ACCION[55][18] = "D78";
        ACCION[58][18] = ACCION[66][18] = ACCION[67][18] = ACCION[90][18] = 
        ACCION[99][18] = "D61";
        ACCION[111][18] = "D163";
        ACCION[116][18] = "D78";
        ACCION[121][18] = "D174";
        ACCION[135][18] = "D61";
        f = 105;
        for (int i = 136; i < 149; i++){
            ACCION[i][18] = R[f];
            f++;
        }
        ACCION[154][18] = ACCION[156][18] = "D61";
        ACCION[166][18] = "D201";
        ACCION[171][18] = ACCION[172][18] = ACCION[209][18] = ACCION[214][18] = 
        ACCION[224][18] = ACCION[225][18] = ACCION[226][18] = ACCION[228][18] = 
        ACCION[259][18] = "D61";
        
        ACCION[0][19] = "505";
        ACCION[75][19] = "D116";
        ACCION[76][19] = "D117";
        ACCION[164][19] = "D199";
        ACCION[201][19] = "D232";
        ACCION[202][19] = "D233";
        
        ACCION[0][20] = "503";
        ACCION[5][20] = "D18";
        for (int i = 7; i < 19; i++){
            ACCION[i][20] = "D18";
        }
        ACCION[62][20] = R[120];
        ACCION[63][20] = R[121];
        ACCION[72][20] = "D18";
        ACCION[127][20] = R[96];
        ACCION[160][20] = ACCION[168][20] ="D18";
        ACCION[184][20] = R[95];
        ACCION[196][20] = ACCION[198][20] = ACCION[199][20] = "D18";
        ACCION[197][20] = R[7];
        ACCION[231][20] = R[11];
        ACCION[242][20] = ACCION[262][20] = ACCION[268][20] = ACCION[271][20] =
        ACCION[276][20] = ACCION[279][20] = "D259";
        ACCION[264][20] = "D18";
        
        ACCION[0][21] = "211";
        Llena1(21, "D26");
        ACCION[72][21] = ACCION[160][21] = ACCION[168][21] = ACCION[196][21] =
        ACCION[198][21] = ACCION[199][21] = "D26";
        ACCION[197][21] = R[7];
        ACCION[231][21] = R[11];
        ACCION[264][21] = R[26];
        
        ACCION[0][22] = "508";
        ACCION[26][22] = "D68";
        ACCION[27][22] = "D69";
        
        ACCION[0][23] = "400";
        ACCION[62][23] = R[120];
        ACCION[63][23] = R[121];
        ACCION[89][23] = ACCION[94][23] = ACCION[98][23] = ACCION[106][23] =
        ACCION[107][23] = "D135";
        ACCION[127][23] = R[96];
        ACCION[167][23] = "D203";
        ACCION[184][23] = R[95];
        ACCION[187][23] = ACCION[188][23] = ACCION[189][23] = ACCION[195][23] = "D135";
        ACCION[235][23] = ACCION[255][23] = "D203";
        
        ACCION[0][24] = "210";
        Llena1(24, "D25");
        ACCION[72][24] = ACCION[160][24] = ACCION[168][24] = ACCION[196][24] = 
        ACCION[198][24] = ACCION[199][24] = "D25";
        ACCION[197][24] = R[7];
        ACCION[230][24] = R[11];
        ACCION[264][24] = "D25";
        
        ACCION[0][25] = "301";
        ACCION[21][25] = "D62";
        ACCION[55][25] = "D79";
        ACCION[58][25] = ACCION[66][25] = ACCION[67][25] = ACCION[90][25] = 
        ACCION[99][25] = "D62";
        ACCION[116][25] = "D79";
        ACCION[121][25] = "D175";
        ACCION[135][25] = "D62";
        f = 105;
        for (int i = 136; i < 149; i++){
            ACCION[i][25] = R[f];
            f++;
        }
        ACCION[154][25] = ACCION[156][25] = ACCION[171][25] = ACCION[172][25] =
        ACCION[209][25] = ACCION[214][25] = ACCION[224][25] = ACCION[225][25] = 
        ACCION[226][25] = ACCION[228][25] = ACCION[259][25] = "D62";
        
        ACCION[0][26] = "203";
        Llena1(26, "D28");
        ACCION[72][26]  = ACCION[160][26] = ACCION[168][26] = ACCION[196][26] = 
        ACCION[198][26] = ACCION[199][26] = ACCION[264][26] = "D28";
        for (int i = 26; i < 33; i++){
            ACCION[197][i] = R[7];
            ACCION[231][i] = R[11];
        }
        
        ACCION[0][27] = "202";
        Llena1(27, "D29");
        ACCION[72][27] = ACCION[160][27] = ACCION[168][27] = ACCION[196][27] = 
        ACCION[198][27] = ACCION[199][27] = ACCION[264][27] = "D29";
        
        ACCION[0][28] = "204";
        Llena1(28, "D30");
        ACCION[22][28] = ACCION[55][28] = ACCION[72][28] = ACCION[86][28] = 
        ACCION[104][28] = ACCION[160][28] = ACCION[168][28] = ACCION[196][28] =
        ACCION[198][28] = ACCION[199][28] = ACCION[264][28] = "D30";
        for(int i = 28; i < 33; i++){
            ACCION[29][i] = R[97];
            ACCION[30][i] = R[98];
        }
        
        ACCION[0][29] = "205";
        Llena1(29, "D31");
        ACCION[22][29] = ACCION[55][29] = ACCION[72][29] = ACCION[86][29] = 
        ACCION[104][29] = ACCION[160][29] = ACCION[168][29] = ACCION[196][29] =
        ACCION[198][29] = ACCION[199][29] = ACCION[264][29] = "D31";
        
        ACCION[0][30] = "207";
        Llena1(30, "D32");
        ACCION[22][30] = ACCION[55][30] = ACCION[72][30] = ACCION[86][30] = 
        ACCION[104][30] = ACCION[160][30] = ACCION[168][30] = ACCION[196][30] =
        ACCION[198][30] = ACCION[199][30] = ACCION[264][30] = "D32";
        
        ACCION[0][31] = "208";
        Llena1(31, "D33");
        ACCION[22][31] = ACCION[55][31] = ACCION[72][31] = ACCION[86][31] = 
        ACCION[104][31] = ACCION[160][31] = ACCION[168][31] = ACCION[196][31] =
        ACCION[198][31] = ACCION[199][31] = ACCION[264][31] = "D33";
        
        ACCION[0][32] = "206";
        Llena1(32, "D34");
        ACCION[22][32] = ACCION[55][32] = ACCION[72][32] = ACCION[86][32] = 
        ACCION[104][32] = ACCION[160][32] = ACCION[168][32] = ACCION[196][32] =
        ACCION[198][32] = ACCION[199][32] = ACCION[264][32] = "D34";
        
        ACCION[0][33] = "403";
        for( int i = 33; i < 44; i++){
            ACCION[62][i] = R[120];
            ACCION[63][i] = R[121];
        }
        Llena5(33, "D137");
        
        ACCION[0][34] = "402";
        Llena5(34, "D138");
        
        ACCION[0][35] = "217";
        Llena5(35, "D139");
        
        ACCION[0][36] = "405";
        Llena5(36, "D140");
        
        ACCION[0][37] = "404";
        Llena5(37, "D141");
        
        ACCION[0][38] = "407";
        Llena5(38, "D142");
        
        ACCION[0][39] = "408";
        Llena5(39, "D143");
        
        ACCION[0][40] = "409";
        Llena5(40, "D144");
        
        ACCION[0][41] = "218";
        Llena5(41, "D145");
        
        ACCION[0][42] = "219";
        Llena5(42, "D146");
        
        ACCION[0][43] = "220";
        Llena5(43, "D147");
        
        ACCION[0][44] = "213";
        ACCION[58][44] = ACCION[121][44] = "D95";
                
        ACCION[0][45] = "214";
        ACCION[58][45] = ACCION[121][45] = "D96";
        
        ACCION[0][46] = "$";
        ACCION[2][46] = "ACEPTAR";
        ACCION[6][46] = R[1];
    }
    
    private void Llena (int fila, int reduce){
            ACCION[fila][4] = ACCION[fila][5] = ACCION[fila][6] = ACCION[fila][8] = 
            ACCION[fila][9] = ACCION[fila][11] = ACCION[fila][13] = ACCION[fila][16] =
            ACCION[fila][20] = ACCION[fila][21] = ACCION[fila][23] = ACCION[fila][24] = R[reduce];
            for (int i = 26; i < 44; i++){
            ACCION[fila][i] = R[reduce];
            }
    }
    
    private void Llena1 (int c, String desplaza){
        ACCION[5][c] = desplaza;
        for (int i = 7; i < 19; i++){
            ACCION[i][c] = desplaza;
        }
    }
    
    private void Llena2 (int fila, int reduce){
        ACCION[fila][5] = ACCION[fila][6] = ACCION[fila][9] = ACCION[fila][10] = 
        ACCION[fila][11] = ACCION[fila][20] = ACCION[fila][21] = ACCION[fila][24] = 
        ACCION[fila][46] = R[reduce];
        for (int i = 26; i < 33; i++){
              ACCION[fila][i] = R[reduce];  
        }      
    }
    
    private void Llena3 (int fila, int reduce){
        ACCION[fila][5] = ACCION[fila][6] = ACCION[fila][9] = ACCION[fila][11] =
        ACCION[fila][20] = ACCION[fila][21] = ACCION[fila][24] = R[reduce]; 
        for (int i = 26; i < 33; i++){
            ACCION[fila][i] = R[reduce];
        }        
    }
    
    private void Llena4 (int fila, int reduce){
        ACCION[fila][6] = ACCION[fila][8] = ACCION[fila][9] = ACCION[fila][11] = 
        ACCION[fila][13] = ACCION[fila][16] = ACCION[fila][20] = ACCION[fila][21] = 
        ACCION[fila][23] = ACCION[fila][24] = R[reduce];
        for (int i = 26; i < 44; i++){
            ACCION[fila][i] = R[reduce];
        }
    }
    
    private void Llena5 (int c, String desplaza){
        ACCION[89][c] = ACCION[94][c] = ACCION[98][c] = ACCION[106][c] =
        ACCION[107][c] = ACCION[187][c] = ACCION[188][c] = ACCION[189][c] =
        ACCION[195][c] = desplaza;
    }
    
    public String Accion(String estado, String terminal){
        int e = Integer.parseInt(estado) + 1;
        int t = 0;
        
        for(int i = 0;  i < 47; i++){
            if(ACCION[0][i].equals(terminal)){
                t = i;
            }
        }
        
        return ACCION[e][t];
    }
      
}