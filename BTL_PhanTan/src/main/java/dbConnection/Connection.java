package dbConnection;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Connection {
	private EntityManagerFactory emf;
	private static Connection instance = null;
	
	public Connection() {
		// TODO Auto-generated constructor stub
		emf = Persistence.createEntityManagerFactory("BTL_PhanTan");
	}
	
	public synchronized static Connection getConnection() {
		if(instance == null)
			instance = new Connection();
		return instance;
	}
	public EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}
}
