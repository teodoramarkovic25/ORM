package hibernate.old.entity;

import hibernate.old.HibernateUtil;
import hibernate.old.layout.BankFrame;
import jakarta.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class ActiveBankAccount {

    private void executeInsideTransaction(Consumer<Session> sessionConsumer) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            sessionConsumer.accept(session);
            session.getTransaction().commit();

        } catch (HibernateException e) {
            System.err.println(e.getMessage());

        }

    }

    public void save() {
        executeInsideTransaction(session -> session.save(this));
      /*  try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(this);
            session.getTransaction().commit();

        } catch (HibernateException e) {
            System.err.println(e.getMessage());

        }

       */

    }


    public void update() {

        executeInsideTransaction(session -> session.update(this));
       /* try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(this);
            session.getTransaction().commit();

        } catch (HibernateException e) {
            System.err.println(e.getMessage());

        }

        */

    }

    public void delete() {
        executeInsideTransaction(session -> session.delete(this));
    }

    public BankAccount get() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();

            return (BankAccount) session.get(BankAccount.class, getThis().getAccountNumber());


        } catch (HibernateException e) {
            System.err.println(e.getMessage());

        }
        return null;
    }

    public BankAccount getThis() {
        return (BankAccount) this;
    }

    public static List<BankAccount> loadAll() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = (Query) session.createQuery("from BankAccount ");
            session.getTransaction().commit();
            List<BankAccount> bankAccounts = query.getResultList();
            return bankAccounts;

        } catch (HibernateException e) {
            System.err.println(e.getMessage());

        }
        return Collections.emptyList();

    }


    public static boolean transferMoney(BankAccount fromBankAccount, BankAccount toBankAccount, Double amount) {

        if (fromBankAccount == null || fromBankAccount.getAccountNumber() == null) {
            return false;
        }
        if (toBankAccount == null || toBankAccount.getAccountNumber() == null) {
            return false;
        }

        if (amount <= 0) {
            return false;
        }
        if(fromBankAccount.getAmount()<amount){
            System.err.println("nema para na računu");
            return false;
        }
        if(fromBankAccount.getAccountNumber().equals(toBankAccount.getAccountNumber())){
             return false;
        }
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            fromBankAccount.setAmount(fromBankAccount.getAmount()-amount);
            toBankAccount.setAmount(toBankAccount.getAmount()+amount);
            session.update(fromBankAccount);
            session.update(fromBankAccount);

            session.getTransaction().commit();
            return true;


        }catch(HibernateException e){
            System.err.println(e.getMessage());

        }
        return  false;
    }


}
