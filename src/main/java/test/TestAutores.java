package test;

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
        
		Libro libro1 = new Libro (1L,"titulo1",a3);
		Libro libro2 = new Libro (2L,"titulo1",a1);
		Libro libro3 = new Libro (3L,"titulo1",a2);
		em.getTransaction().commit();
		
		
		em.close();
		
		
	}
	
	static void imprimirDatos(){
		EntityManager em = emf.createEntityManager();
	
		
		Autor a2 = em.find(Autor.class, 2L);
		System.out.println(a2);
	
	
		em.close();
	}

}
