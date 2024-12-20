package com.artogether.common.business_member;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class BusinessMemberDAOImp implements BusinessMemberDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public BusinessMember getBusinessMemberById(Integer id) {
        return null;
    }

    @Override
    public BusinessMember getBusinessMemberByEmail(String email) {

        Session session = sessionFactory.getCurrentSession();
        BusinessMember businessMember = (BusinessMember) session.createQuery("from BusinessMember where BusinessMember.email = :email", BusinessMember.class);
        session.setProperty("email", email);
        return businessMember;
    }

    @Override
    public int addBusinessMember(BusinessMember businessMember) {
        return 0;
    }

    @Override
    public int updateBusinessMember(BusinessMember businessMember) {
        return 0;
    }

    @Override
    public void deactivatedBusinessMember(BusinessMember businessMember) {

    }

    @Override
    public List<BusinessMember> getAllBusinessMembers() {
        return List.of();
    }
}
