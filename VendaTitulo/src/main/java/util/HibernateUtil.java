package util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import model.Cliente;
import model.ProdutosVenda;
import model.Titulo;
import model.Venda;
import model.Vendedor;


public class HibernateUtil {
	
	private static SessionFactory sessionFactory;

	//método de construção do singleton
	public static SessionFactory getSessionFactory() {
		//SINGLETON -> SE ESTIVER VAZIO CRIA UMA NOVA CONEXÃO
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();

				// Configuração Hibernate equivalente a hibernate.cfg.xml
				Properties settings = new Properties();
				//settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				//settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate_exemplo?useTimezone=true&serverTimezone=UTC");
				settings.put(Environment.URL, "jdbc:mysql://localhost/Prova?createDatabaseIfNotExist=true&useSSL=false&user=root&password=Hadouken&serverTimezone=UTC");
				//"jdbc:mysql://"+Server+"/"+dbName + "?useSSL=false&user="+userName+"&password="+pws);
				//useSSL=false
				//settings.put(Environment.USER, "root");
				//settings.put(Environment.PASS, "12345678");
				//settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");

				settings.put(Environment.SHOW_SQL, "true");

				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

				settings.put(Environment.HBM2DDL_AUTO, "update");

				configuration.setProperties(settings);

				configuration.addAnnotatedClass(Cliente.class);
				configuration.addAnnotatedClass(ProdutosVenda.class);
				configuration.addAnnotatedClass(Titulo.class);
				configuration.addAnnotatedClass(Venda.class);
				configuration.addAnnotatedClass(Vendedor.class);				
	
				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();

				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}
