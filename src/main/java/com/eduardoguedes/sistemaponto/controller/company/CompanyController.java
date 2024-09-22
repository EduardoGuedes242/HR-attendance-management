package com.eduardoguedes.sistemaponto.controller.company;

import com.eduardoguedes.sistemaponto.entity.company.Company;
import com.eduardoguedes.sistemaponto.service.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

  @Autowired
  private CompanyService companyService;

  @GetMapping
  public List<Company> getAllCompany() {
    return  companyService.findAllCompany();
  }

  @PostMapping
  public void createCompany(@RequestBody Company company) {
    companyService.createCompany(company);
  }
}
