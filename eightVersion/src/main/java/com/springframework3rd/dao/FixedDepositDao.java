package com.springframework3rd.dao;

import com.springframework3rd.domain.FixedDepositDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//@Repository(value = "fixedDepositDao")
public class FixedDepositDao implements IFixedDepositDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public int createFixedDeposit(FixedDepositDetails fixedDepositDetails) {
        final String sql = "insert into fixed_deposit_details " +
                "(account_id, fd_creation_date, amount, tenure, active) " +
                "values (?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement ps = conn.prepareStatement(sql,
                        new String[]{"fixed_deposit_id"});
                ps.setInt(1, fixedDepositDetails.getBankAccountId());
                ps.setDate(2, new Date(fixedDepositDetails.getFdCreationDate().getTime()));
                ps.setInt(3, fixedDepositDetails.getFdAmount());
                ps.setInt(4, fixedDepositDetails.getTenure());
                ps.setString(5, fixedDepositDetails.getActive());

                return ps;
            }
        }, keyHolder);

        return keyHolder.getKey().intValue();
    }

    @Override
    public FixedDepositDetails getFixedDeposit(int fixedDepositId) {
        final String sql = "select * from fixed_deposit_details where fixed_deposit_id = :fixedDepositId";
        SqlParameterSource namedParameters = new MapSqlParameterSource(
                "fixedDepositId", fixedDepositId);
        return namedParameterJdbcTemplate.queryForObject(sql, namedParameters,
                (rs, rowNum) -> {
                    FixedDepositDetails fixedDepositDetails = new FixedDepositDetails();
                    fixedDepositDetails.setActive(rs.getString("active"));
                    fixedDepositDetails.setBankAccountId(rs.getInt("account_id"));
                    fixedDepositDetails.setFdAmount(rs.getInt("amount"));
                    fixedDepositDetails.setFdCreationDate(rs.getDate("fd_creation_date"));
                    fixedDepositDetails.setFixedDepositId(rs.getInt("fixed_deposit_id"));
                    fixedDepositDetails.setTenure(rs.getInt("tenure"));
                    return fixedDepositDetails;
                });
    }
}
