package com.eduardoguedes.sistemaponto.repository.company;

import com.eduardoguedes.sistemaponto.entity.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
