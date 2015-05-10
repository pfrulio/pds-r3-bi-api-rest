package fr.esiag.isies.pds.dao.staging.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


/**
 * util class to use hibernate library
 * 
 * @author PFR
 *
 */
public class HibernateUtils {

	/*
	 * SessionFactory
	 */
	private static SessionFactory sessionFactory = createSessionFactory();
	
	/**
	 * ServiceRegistry
	 */
	private static ServiceRegistry serviceRegistry;

	/**
	 * Build Service Registry and configure Session Factory
	 * @return SessionFactory
	 */
	public static SessionFactory createSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
				configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}

	/**
	 * 
	 * @return Session Factory
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Shutdown
	 */
	public static void shutdown() {
		// Close caches and connection pools
		sessionFactory.close();
	}

}
