package test;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;





import model.HibernateUtil;
import model.TipoUsuario;
import model.Usuario;

public class MiTest {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernaterelaciones"); 
		EntityManager em = factory.createEntityManager();  
		//Produto p = new Produto(); 
		//p.setNome("camiseta"); 
		//p.setPreco(12.23);  
		//em.getTransaction().begin();  
		//em.persist(p);  
		//em.getTransaction().commit();
		
		/*
		Cliente cli1 = new Cliente();
		cli1.setNombre("greis");
		Produto prod1=new Produto();
		prod1.setNome("ace");
		Produto prod2=new Produto();
		prod2.setNome("jabon");
		Produto prod3=new Produto();
		prod3.setNome("cepillo");
		
		cli1.addProduto(prod1);
		cli1.addProduto(prod2);
		cli1.addProduto(prod3);
		
		Session sesion = HibernateUtil.getSessionFactory().openSession();
	    sesion.beginTransaction();
	    sesion.save(cli1);
	    //sesion.save(estudiante2);
	    sesion.getTransaction().commit();
	    sesion.close();
		*/
		
		TipoUsuario tip1 = new TipoUsuario();
		//tip1.setIdTipUsu(1);
		tip1.setNomTipUsu("Administrador");
		
		TipoUsuario tip2 = new TipoUsuario();
		//tip2.setIdTipUsu(2);
		tip2.setNomTipUsu("Bibliotecario");
		
		TipoUsuario tip3 = new TipoUsuario();
		//tip3.setIdTipUsu(3);
		tip3.setNomTipUsu("Estudiante");
		
		/*
		Usuario user1 = new Usuario();
		user1.setDocIdeUsu(12345678);
		user1.setNomUsu("pedro");
		user1.setIdeTipUsu(tip1);
		*/
		// sesion = HibernateUtil.getSessionFactory().openSession();
	    //sesion.beginTransaction();
	    //sesion.save(tip1);
	    //sesion.persist(tip1);
	    //sesion.persist(tip2);
	    //sesion.persist(tip3);
	    //sesion.getTransaction().commit();
	    //sesion.close();
		/*
		    Estudiante estudiante1 = new Estudiante();
    estudiante1.setNombre("estudiante1");

    Materia materia1 = new Materia();
    materia1.setNombre("materia1");
    Materia materia2 = new Materia();
    materia2.setNombre("materia2");
    Materia materia3 = new Materia();
    materia3.setNombre("materia3");

    estudiante1.addMateria(materia1);
    estudiante1.addMateria(materia2);
    estudiante1.addMateria(materia3);


    Estudiante estudiante2 = new Estudiante();
    estudiante2.setNombre("estudiante2");

    Materia materia4 = new Materia();
    materia4.setNombre("materia4");
    Materia materia5 = new Materia();
    materia5.setNombre("materia5");
    Materia materia6 = new Materia();
    materia6.setNombre("materia6");

    estudiante2.addMateria(materia4);
    estudiante2.addMateria(materia5);
    estudiante2.addMateria(materia6);

    Session sesion = HibernateUtil.getSessionFactory().openSession();
    sesion.beginTransaction();
    sesion.save(estudiante1);
    sesion.save(estudiante2);
    sesion.getTransaction().commit();
    sesion.close();

    sesion = HibernateUtil.getSessionFactory().openSession();
    sesion.beginTransaction();
    sesion.delete(estudiante1);
    sesion.getTransaction().commit();
    sesion.close();
		 */

	}

}
