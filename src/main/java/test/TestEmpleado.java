package test;

import java.util.GregorianCalendar;
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
	    
	    
	  
	 
	 
	 Empleado e = new Empleado(10L,"Sanchez","Juan",new GregorianCalendar(1980, 11, 23).getTime());
	
	//transaccion
	 manager.getTransaction().begin();
	 manager.persist(e);
	 manager.getTransaction().commit();
	
	 imprimirTodo();
	 
	}

 private static void imprimirTodo(){
	 
	 List<Empleado> empleados= (List<Empleado>) manager.createQuery("FROM Empleado").getResultList();
		
		System.out.println("hay " +empleados.size());
		
		for(Empleado emp: empleados){
			System.out.println(emp);
		}
 }
}

