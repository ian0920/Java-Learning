package com.artogether.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
@Transactional
public class Test {

    @Autowired
    DataSource dataSource;

    Connection con = null;
    PreparedStatement pstmt = null;

    public void getOne(Integer id) {
        try {
            con = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
