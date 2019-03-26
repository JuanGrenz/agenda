package dto;

import java.util.ArrayList;
import java.util.List;

public class Zodiaco
{
	public List<String> obtenerZodiacos() {
		List<String> zodiacos = new ArrayList<String>();
		zodiacos.add("CAPRICORNIO");
		zodiacos.add("ACUARIO");
		zodiacos.add("PISCIS");
		zodiacos.add("ARIES");
		zodiacos.add("TAURO");
		zodiacos.add("GEMINIS");
		zodiacos.add("CANCER");
		zodiacos.add("LEO");
		zodiacos.add("VIRGO");
		zodiacos.add("LIBRA");
		zodiacos.add("ESCORPIO");
		zodiacos.add("SAGITARIO");
		
		return zodiacos;		
	}
	

	public String getZodiaco(int dia, int mes) {
	 
		String signo = "";
	    switch (mes) {
	        case 0:
	            if (dia > 21) {
	                signo = "ACUARIO";
	            } else {
	                signo = "CAPRICORNIO";
	            }
	            break;
	        case 1:
	                if (dia > 19) {
	                    signo = "PISCIS";
	                } else {
	                    signo = "ACUARIO";
	                }
	                break;
	        case 2:
	                if (dia > 20) {
	                    signo = "ARIES";
	                } else {
	                    signo = "PISCIS";
	                }
	                break;
	        case 3:
	                if (dia > 20) {
	                    signo = "TAURO";
	                } else {
	                    signo = "ARIES";
	                }
	                break;
	        case 4:
	                if (dia > 21) {
	                    signo = "GEMINIS";
	                } else {
	                    signo = "TAURO";
	                }
	                break;
	        case 5:
	                if (dia > 20) {
	                    signo = "CANCER";
	                } else {
	                    signo = "GEMINIS";
	                }
	                break;
	        case 6:
	                if (dia > 22) {
	                    signo = "LEO";
	                } else {
	                    signo = "CANCER";
	                }
	                break;
	        case 7:
	                if (dia > 21) {
	                    signo = "VIRGO";
	                } else {
	                    signo = "LEO";
	                }
	                break;
	        case 8:
	                if (dia > 22) {
	                    signo = "LIBRA";
	                } else {
	                    signo = "VIRGO";
	                }
	                break;
	        case 9:
	                if (dia > 22) {
	                    signo = "ESCORPIO";
	                } else {
	                    signo = "LIBRA";
	                }
	                break;
	        case 10:
	                if (dia > 21) {
	                    signo = "SAGITARIO";
	                } else {
	                    signo = "ESCORPIO";
	                }
	                break;
	        case 11:
	                if (dia > 21) {
	                    signo = "CAPRICORNIO";
	                } else {
	                    signo = "SAGITARIO";
	                }
	        break;
	    }
	    return signo;
	}
}