package modelo;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="AUTORES")
public class Autor {

	@Id
	@Column(name="AUTOR_ID")
	private Long id;
	@Column(name= "NOMBRE")
	private String nombre;
	@Column(name="NACIONALIDAD")
	private String nacionalidad;

	
	
	
	// para cargar de forma eager  : fetch = FetchType.EAGER
    @OneToMany(mappedBy ="autor",cascade= CascadeType.ALL) //lista por defecto tipo lazy
	private List<Libro> libros = new ArrayList<>();

	public Autor(){}




	public List<Libro> getLibros() {
		return libros;
	}




	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}




	public Autor(Long id, String nombre, String nacionalidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getNacionalidad() {
		return nacionalidad;
	}




	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}




	@Override
	public String toString() {
		return "Autor [id=" + id + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad + "]";
	}




}
