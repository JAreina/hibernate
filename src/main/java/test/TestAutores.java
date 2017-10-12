package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Autor;
import modelo.Libro;

public class TestAutores {

	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("aplicacion");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
              crearDatos();
              imprimirDatos();
		
		
	}
	
	
	static void crearDatos(){
		EntityManager em = emf.createEntityManager();
		
		
		
		em.getTransaction().begin();
		Autor a1 = new Autor(1L,"Vargas Llosa1", "Perú1");
		Autor a2 = new Autor(2L,"Vargas Llosa2", "Perú2");
		Autor a3 = new Autor(3L,"Vargas Llosa3", "Perú3");
		
		em.persist(a1);
		em.persist(a2);
        em.persist(a3);
        
		em.persist(new Libro (1L,"titulo1",a3));
		em.persist(new Libro (2L,"titulo2",a1));
		em.persist( new Libro (3L,"titulo3",a2));
		em.persist( new Libro (4L,"titulo4",a2));
		em.persist( new Libro (5L,"titulo5",a2));
		em.getTransaction().commit();
		
		
		em.close();
		
		
	}
	
	static void imprimirDatos(){
		EntityManager em = emf.createEntityManager();
	
		
		Autor a2 = em.find(Autor.class, 2L);
		System.out.println(a2);
	
	List<Libro> libros = a2.getLibros();
	
	libros.size(); // solucion para que no falle al cerrar cargando en lazy
	em.close();// cerrar al final porque esta cargando una colleccion lazy
	for(Libro l: libros){
		System.out.println(l);
	}
		
	}

}
