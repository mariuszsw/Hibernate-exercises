import entity.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PostRemove;

public class App05OneToOne_Unidirectional {

    private static final Logger logger = LogManager.getLogger(App05OneToOne_Unidirectional.class);
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        Product product = em.find(Product.class, 4L);
        logger.info(product);
        logger.info(product.getCategory().getName());

        em.getTransaction().commit();
        em.close();
    }
}
