import entity.Attribute;
import entity.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App13DeleteManyToMany {

    private static final Logger logger = LogManager.getLogger(App13DeleteManyToMany.class);
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

//       Product product = em.find(Product.class, 5L);
//     em.remove(product);
//       product.getAttributes().clear();

        Attribute attribute = em.find(Attribute.class, 1L);
        for (Product product : attribute.getProducts()) {
            attribute.removeProduct(product);
        }
        em.remove(attribute);

        em.getTransaction().commit();
        em.close();
    }
}
