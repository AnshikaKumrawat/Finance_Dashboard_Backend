package com.finance_dashboard.backend.repository;
import com.finance_dashboard.backend.models.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavedTransactionRepository extends JpaRepository<SavedTransaction, Long> {
    List<SavedTransaction> findByUserIdOrderByUpcomingDateAsc(long userId);
}
