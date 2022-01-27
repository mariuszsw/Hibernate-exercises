import entity.Attribute;
import entity.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Attr;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App11ManyToMany {

    private static final Logger logger = LogManager.getLogger(App11ManyToMany.class);
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

       Product product = em.find(Product.class, 5L);
//       Attribute attribute = em.find(Attribute.class, 1L);
//       product.addAttributes(attribute);

        Attribute attribute = new Attribute();
        attribute.setName("COLOR");
        attribute.setValue("BLACK");

        product.addAttributes(attribute);

        em.getTransaction().commit();
        em.close();
    }
}
