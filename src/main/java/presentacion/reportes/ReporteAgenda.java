package presentacion.reportes;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import dto.PersonaDTO;
import dto.Zodiaco;

public class ReporteAgenda
{
	private JasperReport reporte;
	private JasperViewer reporteViewer;
	private JasperPrint	reporteLleno;
	private Logger log = Logger.getLogger(ReporteAgenda.class);
	private Zodiaco zodiaco;
	
	//Recibe la lista de personas para armar el reporte
    public ReporteAgenda(List<PersonaDTO> personas)
    {
		Map<String, Object> parametersMap = new HashMap<String, Object>();
		parametersMap.put("Fecha", new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		ArrayList<String> zodiacos = new ArrayList<String>();
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
		
		
    	try		{
    		for (PersonaDTO persona : personas) {
    			String zodiacoPersona = zodiaco.getZodiaco(persona.getCumpleaños().getDate(), persona.getCumpleaños().getMonth());
    		}
			this.reporte = (JasperReport) JRLoader.loadObjectFromFile( "reportes" + File.separator + "ReporteAgenda.jasper" );
			this.reporteLleno = JasperFillManager.fillReport(this.reporte, parametersMap, 
					new JRBeanCollectionDataSource(personas));
    		log.info("Se cargó correctamente el reporte");
		}
		catch( JRException ex ) 
		{
			log.error("Ocurrió un error mientras se cargaba el archivo ReporteAgenda.Jasper", ex);
		}
    }       
    
    public void mostrar()
	{
		this.reporteViewer = new JasperViewer(this.reporteLleno,false);
		this.reporteViewer.setVisible(true);
	}
   
}	