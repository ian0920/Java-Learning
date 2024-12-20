package evt_coup.service;

import evt_coup.model.EvtCoup;
import evt_coup.model.EvtCoupDAO;
import evt_coup.model.EvtCoupDAOImp;

public class EvtCoupServiceImp implements EvtCoupService {

    private EvtCoupDAO dao;

    public EvtCoupServiceImp() {

        dao = new EvtCoupDAOImp();

    }


    @Override
    public EvtCoup getEvtCoupById(Integer id) {
        return dao.getEvtCoup(id);
    }
}
