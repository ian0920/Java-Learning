package evt_coup.model;

import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EvtCoupDAOImp implements EvtCoupDAO {

    private SessionFactory factory;

    public EvtCoupDAOImp() {
        factory = HibernateUtil.getSessionFactory();
    }

    private Session getSession() {
        return factory.getCurrentSession();
    }

    @Override
    public EvtCoup getEvtCoup(Integer evtCoupId) {
//        return getSession().get(EvtCoup.class, evtCoupId);

        Transaction tx = getSession().beginTransaction();

        EvtCoup evtCoup = getSession().get(EvtCoup.class, evtCoupId);
        tx.commit();
        return evtCoup;
    }

}
