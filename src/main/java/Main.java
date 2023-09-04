import org.hibernate.SessionFactory;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        SessionFactory session = HibernateUtil.getSessionFactory();
    }
}
