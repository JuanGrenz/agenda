package dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public enum Zodiaco { 
	 
    ARIES(newDate("03" ,"21"), newDate("04","20")), 
    TAURUS(newDate("04","21"), newDate("05","21")), 
    GEMINI(newDate("05","22"), newDate("06","21")), 
    CANCER(newDate("06","22"), newDate("07","22")), 
    LEO(newDate("07","23"), newDate("08","22")), 
    VIRGO(newDate("08","23"), newDate("09","23")), 
    LIBRA(newDate("09","24"), newDate("10","23")), 
    SCORPIO(newDate("10","24"), newDate("11","22")), 
    SAGITTARIUS(newDate("11","23"), newDate("12","21")), 
    CAPRICORN(newDate("12","22"), newDate("01","20")), 
    AQUARIUS(newDate("01","21"), newDate("02","19")), 
    PISCES(newDate("02","20"), newDate("03","20")); 
 
    private Date from; 
    private Date to; 
     
    private Zodiaco(Date from, Date to) { 
        this.from = from; 
        this.to = to; 
    } 
 
    private static Date newDate(String mes, String dia) {
    	Date date = null;
		try {
			SimpleDateFormat originalFormat = new SimpleDateFormat("MMdd");
			return date = originalFormat.parse(mes.concat(dia));
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return date; 
    } 
     
    public static Zodiaco toZodiac(Date cumpleaños) { 
		
        for (Zodiaco zodiaco: values()) { 
           Date inicio = zodiaco.from;
           Date fin = zodiaco.to; 
           
 
            if (cumpleaños.after(inicio)) { 
            	if(cumpleaños.before(fin)) {
            		return zodiaco;
            	}
            }
 
            if (cumpleaños.after(fin)) { 
            	continue; 
            } 
        } 
         
        throw new IllegalArgumentException("Cannot find zodiac sign for date: " + cumpleaños); 
    } 
}