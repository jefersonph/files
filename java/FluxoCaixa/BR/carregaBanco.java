package BR;

import BR.pais;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.cfg.Configuration;

public class carregaBanco {
	public static void main(String args[]) {
		Transaction trans = null;
		try {
			Configuration cfg = new Configuration();
			cfg.configure();

			SessionFactory factory = cfg.buildSessionFactory();
			Session session = factory.openSession();

			System.out.println("Conexão ok");

			//pais p1 = (pais) session.load(pais.class, new Integer("1"));

			//System.out.println("Nome do País: " + p1.getNmpais());
			
			trans = session.beginTransaction();
			pais pais = new pais();
			pais.setIdpais(new Integer(1));
			
			Estado est = new Estado();
			est.setPais(pais);
			
			est.setNmEstado("Bahia");
			session.save(est);
			trans.commit();
			
			
			//session.flush();
			//session.close();

		} catch (Exception e) {
			try {
				e.printStackTrace();
				trans.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}