package com.bankappmvc.dao;

import com.bankappmvc.domain.FixedDepositDetails;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository("fixedDepositDao")
public class FixedDepositDaoImpl implements FixedDepositDao {
    private static final Logger logger = Logger.getLogger(FixedDepositDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<FixedDepositDetails> getFixedDeposits() {
        String sql = "select * from fixed_deposit_details";
        return jdbcTemplate.query(sql, new FixedDepositDetailsMapper());
    }

    public void saveFixedDeposit(FixedDepositDetails fixedDepositDetails) {
        String sql = "INSERT INTO fixed_deposit_details (account_id, fd_creation_date, amount, tenure, active, email)" +
                " VALUES (:bankAccountId, :fdCreationDate, :fdAmount, :tenure, :active, :email)";
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(fixedDepositDetails);
        this.namedParameterJdbcTemplate.update(sql, namedParameters);
    }

    public void closeFixedDeposit(int fixedDepositId) {

    }

    public FixedDepositDetails getFixedDeposit(int fixedDepositId) {
        String sql = "SELECT * FROM fixed_deposit_details WHERE fixed_deposit_id = :fixedDepositId";
        logger.info(sql);
        logger.info("fixedDepositId = "+fixedDepositId);

        SqlParameterSource namedParameters = new MapSqlParameterSource("fixedDepositId", Integer.valueOf(fixedDepositId));
        FixedDepositDetails fixedDepositDetails = namedParameterJdbcTemplate.queryForObject(sql, namedParameters, new FixedDepositDetailsMapper());
        return  fixedDepositDetails;
    }

    public void editFixedDeposit(FixedDepositDetails fixedDepositDetails) {
        String sql = "UPDATE fixed_deposit_details SET account_id = :bankAccountId, " +
                "fd_creation_date = :fdCreationDate, amount = :fdAmount, tenure = :tenure, " +
                "active = :active, email = :email WHERE fixed_deposit_id = :fixedDepositId";
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(fixedDepositDetails);
        logger.info(sql);
        logger.info(fixedDepositDetails);
        namedParameterJdbcTemplate.update(sql, namedParameters);
    }

    private static final class FixedDepositDetailsMapper implements RowMapper<FixedDepositDetails> {
        public FixedDepositDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
            FixedDepositDetails fixedDepositDetails = new FixedDepositDetails();
            fixedDepositDetails.setFixedDepositId(rs.getInt("fixed_deposit_id"));
            fixedDepositDetails.setBankAccountId(rs.getInt("account_id"));
            fixedDepositDetails.setFdCreationDate(rs.getDate("fd_creation_date"));
            fixedDepositDetails.setFdAmount(rs.getInt("amount"));
            fixedDepositDetails.setTenure(rs.getInt("tenure"));
            fixedDepositDetails.setActive(rs.getString("active"));
            fixedDepositDetails.setEmail(rs.getString("email"));
            return fixedDepositDetails;
        }
    }
}
