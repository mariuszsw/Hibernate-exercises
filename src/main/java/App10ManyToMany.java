import com.sun.xml.bind.v2.schemagen.xmlschema.AttributeType;
import entity.Attribute;
import entity.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App10ManyToMany {

    private static final Logger logger = LogManager.getLogger(App10ManyToMany.class);
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        Product product = em.find(Product.class, 5L);
        logger.info(product);
        logger.info(product.getAttributes());

        Attribute attribute = em.find(Attribute.class, 1L);
        logger.info(attribute);
        logger.info(attribute.getProducts());

        em.getTransaction().commit();
        em.close();
    }
}
