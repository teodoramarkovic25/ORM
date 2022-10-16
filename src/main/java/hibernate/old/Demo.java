package hibernate.old;

import hibernate.old.entity.BankAccount;
import hibernate.old.layout.BankFrame;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Demo {
    public static void main(String[] args) throws Exception {

      /*  SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountNumber("999999999");
        bankAccount.setAmount(10000.0);
        session.save(bankAccount);
        session.getTransaction().commit();

       */
       /* Connection connection = DriverManager.getConnection("", "", "");
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO bank_account () values ()");
        preparedStatement.executeUpdate();


        */


        /*BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountNumber("1237689");
        bankAccount.setAmount(10000.0);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(bankAccount);
        session.getTransaction().commit();
        session.close();
         */


       /* BankAccount bankAccount = new BankAccount();
        bankAccount.save();

        */

        BankFrame bankFrame = new BankFrame();
        SwingUtilities.invokeLater(bankFrame::showFrame);
    }
}
