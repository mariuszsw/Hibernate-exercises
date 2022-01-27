import entity.Attribute;
import entity.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App12DeleteOneToOne {

    private static final Logger logger = LogManager.getLogger(App12DeleteOneToOne.class);
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

       Product product = em.find(Product.class, 3L);

       if (product.getCategory().getProduct().size() == 1) {
           em.remove(product.getCategory());
       }
        product.setCategory(null);


        em.getTransaction().commit();
        em.close();
    }
}
