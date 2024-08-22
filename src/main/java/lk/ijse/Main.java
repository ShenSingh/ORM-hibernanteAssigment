package lk.ijse;

import lk.ijse.embed.FullName;
import org.hibernate.Session;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.entity.Student;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        FullName fullName = new FullName("Kasun", "Kalhara"); // create a FullName object
        FullName fullName1 = new FullName("Sunil", "Perera"); // create a FullName object

        Student student = new Student("S001", fullName, "Galle"); // create a Student object

        Session session = FactoryConfiguration.getInstance().getSession(); 
        Transaction transaction = session.beginTransaction();


        session.save(student); // save the student object

        student.setName(fullName);
        session.update(student); // update the student object

        session.delete(student); // delete the student object

        student = new Student("S001", fullName1, "Kandy");
        session.save(student); // save the student object

        Student student1= session.get(Student.class, "S001");
        System.out.println(student1);

        
        transaction.commit(); // commit the transaction

        session.close(); // close the session
    }
}