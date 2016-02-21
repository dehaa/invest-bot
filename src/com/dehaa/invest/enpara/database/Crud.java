package com.dehaa.invest.enpara.database;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by sefa on 15.01.2016.
 */
public class Crud {
    public void addData(DataEntity data) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(data);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
}
