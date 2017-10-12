package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Empleado;

public class TestEmpleado {

	
	//en java ee web
	//@PersistenceUnit( unitName="aplicacion")
	
	
	//otra forma usando EntityManagerFactory 
	
	
	private static EntityManager manager;
	
	private static EntityManagerFactory emf;
	
	public static void main(String[]args){
	  // CREAR EL GESTOR DE PERSISTENCIA (EM)
		emf= Persistence.createEntityManagerFactory("aplicacion");
	    manager = emf.createEntityManager();
	    
	    
	   List<Empleado> empleados= (List<Empleado>) manager.createQuery("FROM Empleado").getResultList();
	
	 System.out.println("hay " +empleados.size());
	}
}
