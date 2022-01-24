import entity.Product;
import entity.Review;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class App05OneToMany_Bidirectional {

    private static final Logger logger = LogManager.getLogger(App05OneToMany_Bidirectional.class);
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        List<Review> reviews = em.createQuery("select r from Review r").getResultList();
        for (Review review : reviews) {
            logger.info(review);
            logger.info(review.getProduct());
        }
        
        em.getTransaction().commit();
        em.close();
    }
}
