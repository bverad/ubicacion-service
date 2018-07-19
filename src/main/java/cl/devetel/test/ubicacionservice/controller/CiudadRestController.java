package cl.devetel.test.ubicacionservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.devetel.test.ubicacionservice.domain.Ciudad;
import cl.devetel.test.ubicacionservice.repository.CiudadRepository;

@RestController
@RequestMapping("/api")
public class CiudadRestController {
	
	@Autowired
	private CiudadRepository ciudadRepository;
	
	@RequestMapping(value="ciudad/{id}", method=RequestMethod.GET)
	public ResponseEntity<Ciudad> obtenerCiudadPorId(@PathVariable(name="id") Integer id){
		Ciudad ciudad = ciudadRepository.findById(id).get();
		return new ResponseEntity<Ciudad>(ciudad, HttpStatus.OK);
	}
	
	/**
	 * Elimina una ciudad mediante su identificador
	 * @param id
	 * @return
	 * @author bverad
	 */
	@RequestMapping(value="ciudad/eliminar/{id}", method=RequestMethod.GET)
	public ResponseEntity<String> elinarCiudadPorId(@PathVariable(name="id") Integer id){
		Ciudad ciudad = ciudadRepository.findById(id).get();
		String mensaje = "Ciudad eliminada con exito : " + ciudad.getDescripcion();
		if(ciudad == null) {
			mensaje = "No existe la ciudad que desea eliminar.";
		}
		ciudadRepository.delete(ciudad);
		return new ResponseEntity<String>(mensaje, HttpStatus.OK);
	}
	
	/**
	 * Elimina una ciudad mediante su descripcion
	 * @param id
	 * @return
	 * @author bverad
	 */
	@RequestMapping(value="ciudad/eliminar/descripcion/{descripcion}", method=RequestMethod.GET)
	public ResponseEntity<String> elinarCiudadPorId(@PathVariable(name="descripcion") String descripcion){
		Ciudad ciudad = ciudadRepository.findByDescripcion(descripcion);
		String mensaje = "Ciudad eliminada con exito : " + ciudad.getDescripcion();
		if(ciudad == null) {
			mensaje = "No existe la ciudad que desea eliminar.";
		}
		ciudadRepository.delete(ciudad);
		return new ResponseEntity<String>(mensaje, HttpStatus.OK);
	}
	
	/**
	 * Actualiza una ciudad
	 * @param id
	 * @return
	 * @author bverad
	 */
	@RequestMapping(value="ciudad/actualizar/{id}/descripcion/{descripcion}", method=RequestMethod.GET)
	public ResponseEntity<String> elinarCiudadPorId(@PathVariable(name="id") Integer id,
			@PathVariable(name="descripcion") String descripcion){
		Ciudad ciudad = ciudadRepository.findById(id).get();
		String mensaje = "Error";
		if(ciudad == null) {
			mensaje = "No existe la ciudad que desea actualizar.";
		}else {
			ciudad.setDescripcion(descripcion);
			ciudadRepository.save(ciudad);
			mensaje = "Ciudad actualizada con exito : " + ciudad.getDescripcion();
		}
		
		return new ResponseEntity<String>(mensaje, HttpStatus.OK);
	}

}
