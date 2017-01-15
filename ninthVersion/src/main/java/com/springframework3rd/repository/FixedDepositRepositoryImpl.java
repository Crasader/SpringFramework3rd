package com.springframework3rd.repository;

import com.springframework3rd.domain.FixedDepositDetails;
import com.springframework3rd.exceptions.NoFixedDepositFoundException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class FixedDepositRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;

    public List<FixedDepositDetails> findByTenure(int tenure) {
        List<FixedDepositDetails> fds = entityManager
                .createQuery("select details from FixedDepositDetails details " +
                        "where details.tenure = :tenure", FixedDepositDetails.class)
                        .setParameter("tenure", tenure).getResultList();
        if(fds.isEmpty()) {
            throw new NoFixedDepositFoundException("No fixed deposit found");
        }
        return fds;
    }
}
