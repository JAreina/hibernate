package test;

import java.time.LocalDate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Direccion;
import modelo.Empleado;

public class TestEmpleado2 {

	
	//en java ee web
	//@PersistenceUnit( unitName="aplicacion")
	
	
	//otra forma usando EntityManagerFactory 
	
	
	private static EntityManager manager;
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("aplicacion");
	
	public static void main(String[]args){
	  // CREAR EL GESTOR DE PERSISTENCIA (EM)
	
	     manager = emf.createEntityManager();
	     Empleado e = new Empleado(10L,"Sanchez","Juan",LocalDate.of(1980, 11, 23));
	     
	     //RELACION UNO A UNO EMPLEADO A ENTIDAD DIRECCION
	     e.setDireccion(new Direccion(11L,"calle","localidad","provincia","pais",e));
		 
	  
	 manager.getTransaction().begin();
	 

	
	 manager.persist(e);
		 
	 
	 manager.getTransaction().commit();
	
	 manager.close();
	 
	 imprimirTodo();
	}
	
	
	
	private static void insertarInicial(){
		 Empleado e = new Empleado(10L,"Sanchez","Juan",LocalDate.of(1980, 11, 23));
		 EntityManager manager = emf.createEntityManager();
			//transaccion
			 manager.getTransaction().begin();
			 manager.persist(e);  //guardar en bd 
			 // el gestor está atento a los cambios
			 e.setApellidos("Fernández");
			 manager.getTransaction().commit();
			 manager.close();
	}
	
	

 private static void imprimirTodo(){
	EntityManager manager = emf.createEntityManager();
	 List<Empleado> empleados= (List<Empleado>) manager.createQuery("FROM Empleado").getResultList();
		
		System.out.println("hay " +empleados.size());
		
		for(Empleado emp: empleados){
			System.out.println(emp);
		}
		manager.close();
		
 }
}

