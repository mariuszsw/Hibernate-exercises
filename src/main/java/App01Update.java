import entity.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App01Update {

    private static final Logger logger = LogManager.getLogger(App01Update.class);
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

//        Product product = em.find(Product.class, 1L);
//        product.setName("Nowy Rower 01");
//        logger.info(product);

//        Product merge = em.merge(product);
//        logger.info(merge);

        Product product = new Product();
        product.setId(1L);
        product.setName("Nowy Rower 02");
        Product merge = em.merge(product);
        logger.info(merge);

        em.getTransaction().commit();
        em.close();
    }
}
