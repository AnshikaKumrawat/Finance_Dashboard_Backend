package com.finance_dashboard.backend.repository;
import com.finance_dashboard.backend.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    boolean existsByCategoryNameAndTransactionType(String categoryName, TransactionType transactionType);

}
