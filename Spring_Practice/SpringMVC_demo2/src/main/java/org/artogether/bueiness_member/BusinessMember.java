package org.artogether.bueiness_member;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class BusinessMember {


    private Integer id;
    private String account;
    private String password;
    private String name;

}
