package com.eduardoguedes.sistemaponto.service;

import com.eduardoguedes.sistemaponto.entity.Company;
import com.eduardoguedes.sistemaponto.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

  @Autowired
  private CompanyRepository companyRepository;

  public List<Company> findAllCompany() {
    return companyRepository.findAll();
  }

  public void createCompany(Company company) {
    companyRepository.save(company);
  }
}
