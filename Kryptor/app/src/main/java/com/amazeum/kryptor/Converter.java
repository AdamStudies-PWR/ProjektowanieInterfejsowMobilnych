package com.amazeum.kryptor;

import java.util.LinkedList;
import java.util.Random;
import java.util.TreeSet;

public class Converter
{
	public static TreeSet<Integer> eureka = new TreeSet<Integer>();
	private String version = "10042020";

	private int charToInt(char symbol)
	{
		switch(symbol)
		{
			case 0: return 497;case 1: return 38;case 2: return 148;case 3: return 69;case 4: return 388;case 5: return 281;case 6: return 34;case 7: return 295;case 8: return 232;case 9: return 10;case 10: return 32;case 11: return 343;case 12: return 375;case 13: return 175;case 14: return 7;case 15: return 150;case 16: return 214;
			case 17: return 197;case 18: return 498;case 19: return 416;case 20: return 310;case 21: return 195;case 22: return 333;case 23: return 274;case 24: return 279;case 25: return 2;case 26: return 436;case 27: return 507;case 28: return 171;case 29: return 369;case 30: return 24;case 31: return 9;case 32: return 345;
			case 33: return 109;case 34: return 62;case 35: return 85;case 36: return 51;case 37: return 225;case 38: return 500;case 39: return 41;case 40: return 123;case 41: return 509;case 42: return 110;case 43: return 466;case 44: return 64;case 45: return 382;case 46: return 449;case 47: return 84;case 48: return 390;
			case 49: return 164;case 50: return 351;case 51: return 245;case 52: return 502;case 53: return 306;case 54: return 101;case 55: return 389;case 56: return 129;case 57: return 40;case 58: return 323;case 59: return 79;case 60: return 299;case 61: return 35;case 62: return 248;case 63: return 304;case 64: return 65;
			case 65: return 107;case 66: return 139;case 67: return 356;case 68: return 57;case 69: return 404;case 70: return 155;case 71: return 368;case 72: return 269;case 73: return 475;case 74: return 169;case 75: return 246;case 76: return 280;case 77: return 180;case 78: return 236;case 79: return 21;case 80: return 192;
			case 81: return 496;case 82: return 207;case 83: return 115;case 84: return 354;case 85: return 133;case 86: return 499;case 87: return 61;case 88: return 162;case 89: return 45;case 90: return 329;case 91: return 308;case 92: return 379;case 93: return 457;case 94: return 283;case 95: return 99;case 96: return 347;
			case 97: return 503;case 98: return 153;case 99: return 112;case 100: return 453;case 101: return 141;case 102: return 102;case 103: return 117;case 104: return 287;case 105: return 294;case 106: return 213;case 107: return 89;case 108: return 360;case 109: return 413;case 110: return 307;case 111: return 42;case 112: return 461;
			case 113: return 5;case 114: return 478;case 115: return 477;case 116: return 319;case 117: return 54;case 118: return 263;case 119: return 363;case 120: return 81;case 121: return 422;case 122: return 193;case 123: return 36;case 124: return 244;case 125: return 435;case 126: return 492;case 127: return 419;case 128: return 282;
			case 129: return 132;case 130: return 154;case 131: return 121;case 132: return 316;case 133: return 255;case 134: return 458;case 135: return 393;case 136: return 494;case 137: return 140;case 138: return 33;case 139: return 445;case 140: return 202;case 141: return 27;case 142: return 342;case 143: return 394;case 144: return 179;
			case 145: return 240;case 146: return 443;case 147: return 488;case 148: return 163;case 149: return 292;case 150: return 227;case 151: return 471;case 152: return 432;case 153: return 196;case 154: return 361;case 155: return 226;case 156: return 160;case 157: return 126;case 158: return 181;case 159: return 380;case 160: return 261;
			case 161: return 220;case 162: return 49;case 163: return 266;case 164: return 298;case 165: return 474;case 166: return 262;case 167: return 37;case 168: return 411;case 169: return 452;case 170: return 87;case 171: return 59;case 172: return 357;case 173: return 446;case 174: return 337;case 175: return 311;case 176: return 250;
			case 177: return 387;case 178: return 138;case 179: return 359;case 180: return 464;case 181: return 489;case 182: return 275;case 183: return 270;case 184: return 151;case 185: return 501;case 186: return 463;case 187: return 131;case 188: return 290;case 189: return 116;case 190: return 481;case 191: return 26;case 192: return 267;
			case 193: return 407;case 194: return 277;case 195: return 321;case 196: return 444;case 197: return 224;case 198: return 330;case 199: return 285;case 200: return 486;case 201: return 0;case 202: return 212;case 203: return 344;case 204: return 397;case 205: return 58;case 206: return 428;case 207: return 303;case 208: return 324;
			case 209: return 228;case 210: return 186;case 211: return 125;case 212: return 74;case 213: return 118;case 214: return 485;case 215: return 247;case 216: return 216;case 217: return 385;case 218: return 450;case 219: return 230;case 220: return 203;case 221: return 442;case 222: return 505;case 223: return 415;case 224: return 355;
			case 225: return 11;case 226: return 182;case 227: return 511;case 228: return 200;case 229: return 172;case 230: return 455;case 231: return 149;case 232: return 335;case 233: return 184;case 234: return 468;case 235: return 199;case 236: return 400;case 237: return 168;case 238: return 448;case 239: return 353;case 240: return 30;
			case 241: return 111;case 242: return 506;case 243: return 28;case 244: return 264;case 245: return 438;case 246: return 205;case 247: return 12;case 248: return 378;case 249: return 215;case 250: return 72;case 251: return 331;case 252: return 96;case 253: return 338;case 254: return 6;case 255: return 495;case 256: return 268;
			case 257: return 130;case 258: return 222;case 259: return 454;case 260: return 80;case 261: return 147;case 262: return 276;case 263: return 328;case 264: return 185;case 265: return 476;case 266: return 332;case 267: return 284;case 268: return 424;case 269: return 229;case 270: return 318;case 271: return 399;case 272: return 364;
			case 273: return 106;case 274: return 320;case 275: return 403;case 276: return 176;case 277: return 256;case 278: return 417;case 279: return 348;case 280: return 238;case 281: return 340;case 282: return 456;case 283: return 510;case 284: return 374;case 285: return 221;case 286: return 1;case 287: return 427;case 288: return 68;
			case 289: return 187;case 290: return 60;case 291: return 189;case 292: return 372;case 293: return 490;case 294: return 217;case 295: return 173;case 296: return 4;case 297: return 242;case 298: return 122;case 299: return 161;case 300: return 48;case 301: return 243;case 302: return 22;case 303: return 78;case 304: return 108;
			case 305: return 252;case 306: return 293;case 307: return 352;case 308: return 13;case 309: return 309;case 310: return 317;case 311: return 371;case 312: return 95;case 313: return 98;case 314: return 473;case 315: return 119;case 316: return 254;case 317: return 439;case 318: return 398;case 319: return 460;case 320: return 92;
			case 321: return 273;case 322: return 376;case 323: return 194;case 324: return 18;case 325: return 44;case 326: return 166;case 327: return 341;case 328: return 47;case 329: return 433;case 330: return 339;case 331: return 157;case 332: return 76;case 333: return 144;case 334: return 272;case 335: return 288;case 336: return 91;
			case 337: return 174;case 338: return 483;case 339: return 82;case 340: return 487;case 341: return 386;case 342: return 209;case 343: return 88;case 344: return 137;case 345: return 493;case 346: return 377;case 347: return 383;case 348: return 73;case 349: return 467;case 350: return 414;case 351: return 143;case 352: return 29;
			case 353: return 208;case 354: return 142;case 355: return 265;case 356: return 315;case 357: return 104;case 358: return 334;case 359: return 128;case 360: return 286;case 361: return 86;case 362: return 103;case 363: return 19;case 364: return 425;case 365: return 257;case 366: return 165;case 367: return 75;case 368: return 170;
			case 369: return 3;case 370: return 94;case 371: return 134;case 372: return 479;case 373: return 50;case 374: return 145;case 375: return 350;case 376: return 15;case 377: return 349;case 378: return 120;case 379: return 188;case 380: return 39;case 381: return 289;case 382: return 431;case 383: return 251;case 384: return 218;
			case 385: return 235;case 386: return 440;case 387: return 401;case 388: return 231;case 389: return 249;case 390: return 451;case 391: return 233;case 392: return 392;case 393: return 405;case 394: return 301;case 395: return 8;case 396: return 491;case 397: return 459;case 398: return 297;case 399: return 55;case 400: return 406;
			case 401: return 258;case 402: return 384;case 403: return 237;case 404: return 100;case 405: return 67;case 406: return 305;case 407: return 152;case 408: return 43;case 409: return 465;case 410: return 52;case 411: return 420;case 412: return 296;case 413: return 434;case 414: return 408;case 415: return 362;case 416: return 396;
			case 417: return 470;case 418: return 312;case 419: return 322;case 420: return 278;case 421: return 418;case 422: return 198;case 423: return 259;case 424: return 206;case 425: return 412;case 426: return 234;case 427: return 402;case 428: return 156;case 429: return 167;case 430: return 326;case 431: return 373;case 432: return 223;
			case 433: return 114;case 434: return 113;case 435: return 358;case 436: return 46;case 437: return 219;case 438: return 183;case 439: return 325;case 440: return 70;case 441: return 77;case 442: return 90;case 443: return 291;case 444: return 191;case 445: return 17;case 446: return 23;case 447: return 146;case 448: return 409;
			case 449: return 124;case 450: return 53;case 451: return 300;case 452: return 201;case 453: return 336;case 454: return 504;case 455: return 426;case 456: return 462;case 457: return 469;case 458: return 480;case 459: return 178;case 460: return 190;case 461: return 16;case 462: return 429;case 463: return 365;case 464: return 484;
			case 465: return 423;case 466: return 63;case 467: return 421;case 468: return 327;case 469: return 31;case 470: return 346;case 471: return 135;case 472: return 395;case 473: return 25;case 474: return 71;case 475: return 14;case 476: return 482;case 477: return 211;case 478: return 366;case 479: return 127;case 480: return 105;
			case 481: return 210;case 482: return 313;case 483: return 441;case 484: return 239;case 485: return 260;case 486: return 66;case 487: return 159;case 488: return 158;case 489: return 381;case 490: return 136;case 491: return 177;case 492: return 508;case 493: return 20;case 494: return 391;case 495: return 367;case 496: return 56;
			case 497: return 253;case 498: return 93;case 499: return 314;case 500: return 83;case 501: return 410;case 502: return 271;case 503: return 204;case 504: return 437;case 505: return 430;case 506: return 370;case 507: return 472;case 508: return 241;case 509: return 447;case 510: return 302;case 511: return 97;

			default: return (int)'?';
		}
	}
		
	private char intToChar (int number)
	{
		if (number>511) number-=512;
		if (number<0) number+=512;
		switch(number)
		{
			case 497: return (char)0;case 38: return (char)1;case 148: return (char)2;case 69: return (char)3;case 388: return (char)4;case 281: return (char)5;case 34: return (char)6;case 295: return (char)7;case 232: return (char)8;case 10: return (char)9;case 32: return (char)10;case 343: return (char)11;case 375: return (char)12;case 175: return (char)13;case 7: return (char)14;case 150: return (char)15;case 214: return (char)16;
			case 197: return (char)17;case 498: return (char)18;case 416: return (char)19;case 310: return (char)20;case 195: return (char)21;case 333: return (char)22;case 274: return (char)23;case 279: return (char)24;case 2: return (char)25;case 436: return (char)26;case 507: return (char)27;case 171: return (char)28;case 369: return (char)29;case 24: return (char)30;case 9: return (char)31;case 345: return (char)32;
			case 109: return (char)33;case 62: return (char)34;case 85: return (char)35;case 51: return (char)36;case 225: return (char)37;case 500: return (char)38;case 41: return (char)39;case 123: return (char)40;case 509: return (char)41;case 110: return (char)42;case 466: return (char)43;case 64: return (char)44;case 382: return (char)45;case 449: return (char)46;case 84: return (char)47;case 390: return (char)48;
			case 164: return (char)49;case 351: return (char)50;case 245: return (char)51;case 502: return (char)52;case 306: return (char)53;case 101: return (char)54;case 389: return (char)55;case 129: return (char)56;case 40: return (char)57;case 323: return (char)58;case 79: return (char)59;case 299: return (char)60;case 35: return (char)61;case 248: return (char)62;case 304: return (char)63;case 65: return (char)64;
			case 107: return (char)65;case 139: return (char)66;case 356: return (char)67;case 57: return (char)68;case 404: return (char)69;case 155: return (char)70;case 368: return (char)71;case 269: return (char)72;case 475: return (char)73;case 169: return (char)74;case 246: return (char)75;case 280: return (char)76;case 180: return (char)77;case 236: return (char)78;case 21: return (char)79;case 192: return (char)80;
			case 496: return (char)81;case 207: return (char)82;case 115: return (char)83;case 354: return (char)84;case 133: return (char)85;case 499: return (char)86;case 61: return (char)87;case 162: return (char)88;case 45: return (char)89;case 329: return (char)90;case 308: return (char)91;case 379: return (char)92;case 457: return (char)93;case 283: return (char)94;case 99: return (char)95;case 347: return (char)96;
			case 503: return (char)97;case 153: return (char)98;case 112: return (char)99;case 453: return (char)100;case 141: return (char)101;case 102: return (char)102;case 117: return (char)103;case 287: return (char)104;case 294: return (char)105;case 213: return (char)106;case 89: return (char)107;case 360: return (char)108;case 413: return (char)109;case 307: return (char)110;case 42: return (char)111;case 461: return (char)112;
			case 5: return (char)113;case 478: return (char)114;case 477: return (char)115;case 319: return (char)116;case 54: return (char)117;case 263: return (char)118;case 363: return (char)119;case 81: return (char)120;case 422: return (char)121;case 193: return (char)122;case 36: return (char)123;case 244: return (char)124;case 435: return (char)125;case 492: return (char)126;case 419: return (char)127;case 282: return (char)128;
			case 132: return (char)129;case 154: return (char)130;case 121: return (char)131;case 316: return (char)132;case 255: return (char)133;case 458: return (char)134;case 393: return (char)135;case 494: return (char)136;case 140: return (char)137;case 33: return (char)138;case 445: return (char)139;case 202: return (char)140;case 27: return (char)141;case 342: return (char)142;case 394: return (char)143;case 179: return (char)144;
			case 240: return (char)145;case 443: return (char)146;case 488: return (char)147;case 163: return (char)148;case 292: return (char)149;case 227: return (char)150;case 471: return (char)151;case 432: return (char)152;case 196: return (char)153;case 361: return (char)154;case 226: return (char)155;case 160: return (char)156;case 126: return (char)157;case 181: return (char)158;case 380: return (char)159;case 261: return (char)160;
			case 220: return (char)161;case 49: return (char)162;case 266: return (char)163;case 298: return (char)164;case 474: return (char)165;case 262: return (char)166;case 37: return (char)167;case 411: return (char)168;case 452: return (char)169;case 87: return (char)170;case 59: return (char)171;case 357: return (char)172;case 446: return (char)173;case 337: return (char)174;case 311: return (char)175;case 250: return (char)176;
			case 387: return (char)177;case 138: return (char)178;case 359: return (char)179;case 464: return (char)180;case 489: return (char)181;case 275: return (char)182;case 270: return (char)183;case 151: return (char)184;case 501: return (char)185;case 463: return (char)186;case 131: return (char)187;case 290: return (char)188;case 116: return (char)189;case 481: return (char)190;case 26: return (char)191;case 267: return (char)192;
			case 407: return (char)193;case 277: return (char)194;case 321: return (char)195;case 444: return (char)196;case 224: return (char)197;case 330: return (char)198;case 285: return (char)199;case 486: return (char)200;case 0: return (char)201;case 212: return (char)202;case 344: return (char)203;case 397: return (char)204;case 58: return (char)205;case 428: return (char)206;case 303: return (char)207;case 324: return (char)208;
			case 228: return (char)209;case 186: return (char)210;case 125: return (char)211;case 74: return (char)212;case 118: return (char)213;case 485: return (char)214;case 247: return (char)215;case 216: return (char)216;case 385: return (char)217;case 450: return (char)218;case 230: return (char)219;case 203: return (char)220;case 442: return (char)221;case 505: return (char)222;case 415: return (char)223;case 355: return (char)224;
			case 11: return (char)225;case 182: return (char)226;case 511: return (char)227;case 200: return (char)228;case 172: return (char)229;case 455: return (char)230;case 149: return (char)231;case 335: return (char)232;case 184: return (char)233;case 468: return (char)234;case 199: return (char)235;case 400: return (char)236;case 168: return (char)237;case 448: return (char)238;case 353: return (char)239;case 30: return (char)240;
			case 111: return (char)241;case 506: return (char)242;case 28: return (char)243;case 264: return (char)244;case 438: return (char)245;case 205: return (char)246;case 12: return (char)247;case 378: return (char)248;case 215: return (char)249;case 72: return (char)250;case 331: return (char)251;case 96: return (char)252;case 338: return (char)253;case 6: return (char)254;case 495: return (char)255;case 268: return (char)256;
			case 130: return (char)257;case 222: return (char)258;case 454: return (char)259;case 80: return (char)260;case 147: return (char)261;case 276: return (char)262;case 328: return (char)263;case 185: return (char)264;case 476: return (char)265;case 332: return (char)266;case 284: return (char)267;case 424: return (char)268;case 229: return (char)269;case 318: return (char)270;case 399: return (char)271;case 364: return (char)272;
			case 106: return (char)273;case 320: return (char)274;case 403: return (char)275;case 176: return (char)276;case 256: return (char)277;case 417: return (char)278;case 348: return (char)279;case 238: return (char)280;case 340: return (char)281;case 456: return (char)282;case 510: return (char)283;case 374: return (char)284;case 221: return (char)285;case 1: return (char)286;case 427: return (char)287;case 68: return (char)288;
			case 187: return (char)289;case 60: return (char)290;case 189: return (char)291;case 372: return (char)292;case 490: return (char)293;case 217: return (char)294;case 173: return (char)295;case 4: return (char)296;case 242: return (char)297;case 122: return (char)298;case 161: return (char)299;case 48: return (char)300;case 243: return (char)301;case 22: return (char)302;case 78: return (char)303;case 108: return (char)304;
			case 252: return (char)305;case 293: return (char)306;case 352: return (char)307;case 13: return (char)308;case 309: return (char)309;case 317: return (char)310;case 371: return (char)311;case 95: return (char)312;case 98: return (char)313;case 473: return (char)314;case 119: return (char)315;case 254: return (char)316;case 439: return (char)317;case 398: return (char)318;case 460: return (char)319;case 92: return (char)320;
			case 273: return (char)321;case 376: return (char)322;case 194: return (char)323;case 18: return (char)324;case 44: return (char)325;case 166: return (char)326;case 341: return (char)327;case 47: return (char)328;case 433: return (char)329;case 339: return (char)330;case 157: return (char)331;case 76: return (char)332;case 144: return (char)333;case 272: return (char)334;case 288: return (char)335;case 91: return (char)336;
			case 174: return (char)337;case 483: return (char)338;case 82: return (char)339;case 487: return (char)340;case 386: return (char)341;case 209: return (char)342;case 88: return (char)343;case 137: return (char)344;case 493: return (char)345;case 377: return (char)346;case 383: return (char)347;case 73: return (char)348;case 467: return (char)349;case 414: return (char)350;case 143: return (char)351;case 29: return (char)352;
			case 208: return (char)353;case 142: return (char)354;case 265: return (char)355;case 315: return (char)356;case 104: return (char)357;case 334: return (char)358;case 128: return (char)359;case 286: return (char)360;case 86: return (char)361;case 103: return (char)362;case 19: return (char)363;case 425: return (char)364;case 257: return (char)365;case 165: return (char)366;case 75: return (char)367;case 170: return (char)368;
			case 3: return (char)369;case 94: return (char)370;case 134: return (char)371;case 479: return (char)372;case 50: return (char)373;case 145: return (char)374;case 350: return (char)375;case 15: return (char)376;case 349: return (char)377;case 120: return (char)378;case 188: return (char)379;case 39: return (char)380;case 289: return (char)381;case 431: return (char)382;case 251: return (char)383;case 218: return (char)384;
			case 235: return (char)385;case 440: return (char)386;case 401: return (char)387;case 231: return (char)388;case 249: return (char)389;case 451: return (char)390;case 233: return (char)391;case 392: return (char)392;case 405: return (char)393;case 301: return (char)394;case 8: return (char)395;case 491: return (char)396;case 459: return (char)397;case 297: return (char)398;case 55: return (char)399;case 406: return (char)400;
			case 258: return (char)401;case 384: return (char)402;case 237: return (char)403;case 100: return (char)404;case 67: return (char)405;case 305: return (char)406;case 152: return (char)407;case 43: return (char)408;case 465: return (char)409;case 52: return (char)410;case 420: return (char)411;case 296: return (char)412;case 434: return (char)413;case 408: return (char)414;case 362: return (char)415;case 396: return (char)416;
			case 470: return (char)417;case 312: return (char)418;case 322: return (char)419;case 278: return (char)420;case 418: return (char)421;case 198: return (char)422;case 259: return (char)423;case 206: return (char)424;case 412: return (char)425;case 234: return (char)426;case 402: return (char)427;case 156: return (char)428;case 167: return (char)429;case 326: return (char)430;case 373: return (char)431;case 223: return (char)432;
			case 114: return (char)433;case 113: return (char)434;case 358: return (char)435;case 46: return (char)436;case 219: return (char)437;case 183: return (char)438;case 325: return (char)439;case 70: return (char)440;case 77: return (char)441;case 90: return (char)442;case 291: return (char)443;case 191: return (char)444;case 17: return (char)445;case 23: return (char)446;case 146: return (char)447;case 409: return (char)448;
			case 124: return (char)449;case 53: return (char)450;case 300: return (char)451;case 201: return (char)452;case 336: return (char)453;case 504: return (char)454;case 426: return (char)455;case 462: return (char)456;case 469: return (char)457;case 480: return (char)458;case 178: return (char)459;case 190: return (char)460;case 16: return (char)461;case 429: return (char)462;case 365: return (char)463;case 484: return (char)464;
			case 423: return (char)465;case 63: return (char)466;case 421: return (char)467;case 327: return (char)468;case 31: return (char)469;case 346: return (char)470;case 135: return (char)471;case 395: return (char)472;case 25: return (char)473;case 71: return (char)474;case 14: return (char)475;case 482: return (char)476;case 211: return (char)477;case 366: return (char)478;case 127: return (char)479;case 105: return (char)480;
			case 210: return (char)481;case 313: return (char)482;case 441: return (char)483;case 239: return (char)484;case 260: return (char)485;case 66: return (char)486;case 159: return (char)487;case 158: return (char)488;case 381: return (char)489;case 136: return (char)490;case 177: return (char)491;case 508: return (char)492;case 20: return (char)493;case 391: return (char)494;case 367: return (char)495;case 56: return (char)496;
			case 253: return (char)497;case 93: return (char)498;case 314: return (char)499;case 83: return (char)500;case 410: return (char)501;case 271: return (char)502;case 204: return (char)503;case 437: return (char)504;case 430: return (char)505;case 370: return (char)506;case 472: return (char)507;case 241: return (char)508;case 447: return (char)509;case 302: return (char)510;case 97: return (char)511;
			default:
			return '?';
		}
	}
	
	private LinkedList<Integer> shuffling(LinkedList<Integer> text , int var)
	{
		int half=(text.size()/2)+(text.size()%2);
		int choice;
		LinkedList<Integer> result	 = new LinkedList<Integer>();
		LinkedList<Integer> part1	 = new LinkedList<Integer>();
		LinkedList<Integer> part2	 = new LinkedList<Integer>();
		if(var<0)
		{
			choice=(-var)%4;
			choice= -1*choice;
			var=-1*var;
		} 
		else choice=var%4;
		
		switch(choice)
		{
			case -3:
				for(int i=0; i<text.size();i++)
				{
					result.add(text.get(i) - (i%(var/2)));
				}
				return result;
			
			case -1:
				for(int i=0; i<half;i++)
				{
					result.add(text.get(i));
					if(half+i<text.size())result.add(text.get(half+i));
				}
				return result;
			
			case 1:
				for(int i=0; i<text.size();i++)
				{
					if (i%2==1) part2.add(text.get(i));
					else part1.add(text.get(i));
				}
				result.addAll(part1);
				result.addAll(part2);
				return result;
				
			case -2:
			case 2:
				for(int i=1; i<=text.size();i++)
				{
					result.add(text.get(text.size()-i));
				}
				return result;
				
			case 3:
				for(int i=0; i<text.size();i++)
				{
					result.add(text.get(i) + (i%(var/2)));
				}
				return result;
				
			default:
				return text;
		}
	}
		
	public String encryption(String text)
	{
		//--------------------------------------------------------------23102018
		String result 				="";
		if (text.length()<1) return result;
		LinkedList<Integer> temp 	= new LinkedList<Integer>();
		Random random 				= new Random();
		
		
		int A1 = (random.nextInt(27)+44);						temp.add(A1);
		int A2 = (random.nextInt(27)+44);
		while(A1==A2) A2 = (random.nextInt(27)+44);				temp.add(A2);
		int A3 = (random.nextInt(27)+44);
		while(A3==A2||A3==A1) A3 = (random.nextInt(27)+44);
		int A4 = (random.nextInt(27)+44);
		int B1=1,B2=1,B3=1,B4=1;
		
		if		((A1+A2+A3+A4)%3==1) {B2*=-1;B4*=-1;}
		else if	((A1+A2+A3+A4)%3==2) {B1*=-1;B2*=-1;B3*=-1;B4*=-1;}
			
		for(int i=0; i<text.length();i++)
		{
			if		(i%4==0) temp.add(charToInt(text.charAt(i))+B1*A1);
			else if	(i%4==1) temp.add(charToInt(text.charAt(i))+B2*A2);
			else if	(i%4==2) temp.add(charToInt(text.charAt(i))+B3*A3);
			else if	(i%4==3) temp.add(charToInt(text.charAt(i))+B4*A4);
		}
		
																	temp.add(A3);
		
		temp = shuffling(temp,A4);
							
																	temp.add(A4);
		for(int var : temp)
		{
			result=result+this.intToChar(var);
		}
		
		
		return result;
	}
	
	public String decryption(String text)
	{
		String result 				="";
		if (text.length()<1) return result;
		LinkedList<Integer> temp 	= new LinkedList<Integer>();
		
		int A1, A2,A3,A4=charToInt(text.charAt(text.length()-1));
		int B1=1,B2=1,B3=1,B4=1;
		for(int i=0; i<text.length()-1;i++)	temp.add(charToInt(text.charAt(i)));
		temp=shuffling(temp, -A4);
		A1 = temp.get(0);				temp.remove(0);
		A2 = temp.get(0); 				temp.remove(0);
		A3 = temp.get(temp.size()-1);	temp.remove(temp.size()-1);

		if		((A1+A2+A3+A4)%3==1) {B2*=-1;B4*=-1;}
		else if	((A1+A2+A3+A4)%3==2) {B1*=-1;B2*=-1;B3*=-1;B4*=-1;}

		for(int i=0; i<temp.size();i++)
		{
			if		((i)%4==0) temp.set(i,temp.get(i)-(B1*A1));
			else if	((i)%4==1) temp.set(i,temp.get(i)-(B2*A2));
			else if	((i)%4==2) temp.set(i,temp.get(i)-(B3*A3));
			else if	((i)%4==3) temp.set(i,temp.get(i)-(B4*A4));
		}
		
		
		for(int var : temp) result=result+this.intToChar(var);
		
		return result;
	}

	public String getVersion() { return version; }
	
}
	