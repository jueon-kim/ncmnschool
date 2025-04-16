package com.ncmn.school.member;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

public class JdbcMemberRepository implements MemberRepository {

    private final DataSource dataSource;

    public JdbcMemberRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Optional<Member> findByName(String name) {
        String sql = "SELECT * FROM members WHERE name = ?";

    }

    @Override
    public Member save(Member member) {
        String sql = "INSERT INTO student (name, phone, email, birthday, address, church, job) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getPhone());
            pstmt.setString(3, member.getEmail());
            pstmt.setString(4, member.getBirthday());
            pstmt.setString(5, member.getAddress());
            pstmt.setString(6, member.getChurch());
            pstmt.setString(7, member.getJob());

            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();

            if (rs.next()) {
                member.setName(rs.getString(1));
            } else {
                throw new SQLException("id 조회 실패");
            }
            return member;

        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }
    private Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    private void close(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}