package lk.ijse;

import lk.ijse.embed.FullName;
import org.hibernate.Session;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.entity.Student;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        FullName fullName = new FullName("Kamal", "Perera");
        FullName fullName1 = new FullName("Sunil", "Perera");

        Student student = new Student("S001", fullName, "Colombo");

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(student);

        student.setName(fullName);
        session.update(student);

        session.delete(student);

        student = new Student("S001", fullName1, "Kandy");
        session.save(student);

        Student student1= session.get(Student.class, "S001");
        System.out.println(student1);

        
        transaction.commit();

        session.close();
    }
}