package ua.com.hav.herokudeploy.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.hav.herokudeploy.model.Expense;

import java.util.List;

public interface ExpenseRepo extends JpaRepository<Expense, Long> {
    List<Expense> findAllByClientId(Long id);
}
