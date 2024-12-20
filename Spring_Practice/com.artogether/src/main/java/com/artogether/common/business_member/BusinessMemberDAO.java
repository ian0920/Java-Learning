package com.artogether.common.business_member;

import java.util.List;

public interface BusinessMemberDAO {

    BusinessMember getBusinessMemberById(Integer id);
    BusinessMember getBusinessMemberByEmail(String email);
    int addBusinessMember(BusinessMember businessMember);
    int updateBusinessMember(BusinessMember businessMember);
    void deactivatedBusinessMember(BusinessMember businessMember);
    List<BusinessMember> getAllBusinessMembers();



}
