package newservice;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import net.webservicex.Airport;
import net.webservicex.AirportSoap;
import net.webservicex.GlobalWeatherSoap;
import net.webservicex.GlobalWeather;



@WebService(serviceName = "NewWebService")
public class NewWebService {

    @WebMethod(operationName = "hello")
    public String[] obtenerCiudad(@WebParam(name = "aux") String aux) {
        
        String[] paises = new String[2];
        GlobalWeather gw = new GlobalWeather();
        GlobalWeatherSoap GWsoap = gw.getGlobalWeatherSoap();
        String ciudad = GWsoap.getCitiesByCountry(aux) ;
        Airport aeropuerto = new Airport();
        AirportSoap Asoap = aeropuerto.getAirportSoap();
        paises[0]= GWsoap.getCitiesByCountry(aux);
        paises[1]= Asoap.getAirportInformationByCountry(aux);
        return paises;
        
    }
}
