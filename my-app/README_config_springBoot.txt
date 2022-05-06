/*@CrossOrigin(origins = "*", methods = { RequestMethod.GET , RequestMethod.POST , 
		                                RequestMethod.PUT , RequestMethod.DELETE ,
		                                RequestMethod.OPTIONS})*/
@CrossOrigin(origins = GesproUrlBase.url,  
             methods = { RequestMethod.GET , RequestMethod.POST , 
            		 	 RequestMethod.PUT , RequestMethod.DELETE ,
            		 	 RequestMethod.OPTIONS} , 
             maxAge = GesproUrlBase.maxAge)
//@CrossOrigin(origins = GesproUrlBase.url, maxAge = GesproUrlBase.maxAge)
@RestController
@RequestMapping("/projectManager")
public class GpProjectManagerController {
    ...
}

==========================

NB: les autorisations CORS (coté serveur) ne sont pas toujours nécessaires.
On peut s'en passer avec un serveur intermédiaire (reverse-proxy ou api-gateway).
Ex:  ng serve --proxy-config proxy.conf.json (page 125 environ)