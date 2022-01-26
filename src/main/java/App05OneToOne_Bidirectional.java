import entity.Category;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App05OneToOne_Bidirectional {

    private static final Logger logger = LogManager.getLogger(App05OneToOne_Bidirectional.class);
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        Category category = em.find(Category.class, 1L);
        logger.info(category);
        logger.info(category.getProduct());

        em.getTransaction().commit();
        em.close();
    }
}
