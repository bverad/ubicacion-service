package cl.devetel.test.ubicacionservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ciudad")
public class Ciudad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ciudad_generator")
	@SequenceGenerator(name="ciudad_generator", sequenceName = "ciudad_seq", allocationSize=0)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	

}
