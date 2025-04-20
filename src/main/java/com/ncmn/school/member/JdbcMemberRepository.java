package com.ncmn.school.member;

import org.springframework.jdbc.datasource.DataSourceUtils;
import javax.sql.DataSource;
import java.sql.*;
import java.util.*;


public class JdbcMemberRepository implements MemberRepository {

    private final DataSource dataSource;
    private List<Member> members;

    public JdbcMemberRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Member save(Member member) {
        String sql = "INSERT INTO STUDENT (name, phone, email, birthday, address, church, job) " +
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
            return member; // 그냥 저장된 객체 반환

        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
    @Override
    public List<Member> findAll() {
        String sql = "SELECT * FROM STUDENT";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            List<Member> members = new ArrayList<>();
            while (rs.next()) {
                Member member = new Member();
                member.setName(rs.getString("name"));
                member.setPhone(rs.getString("phone"));
                member.setEmail(rs.getString("email"));
                member.setBirthday(rs.getString("birthday"));
                member.setAddress(rs.getString("address"));
                member.setChurch(rs.getString("church"));
                member.setJob(rs.getString("job"));
                // Timestamp가 null일 경우 처리
                Timestamp timestamp = rs.getTimestamp("timestamp");
                if (timestamp != null) {
                    member.setTimestamp(timestamp.toLocalDateTime());
                } else {
                    member.setTimestamp(null);  // null인 경우 처리
                }

                members.add(member);
            }


            return members;  // 예외가 나지 않도록 members 리스트를 반환
        } catch (SQLException e) {
            // SQLException을 좀 더 구체적으로 처리하여 원인 파악을 돕기
            throw new RuntimeException("데이터베이스 조회 오류: " + e.getMessage(), e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

}