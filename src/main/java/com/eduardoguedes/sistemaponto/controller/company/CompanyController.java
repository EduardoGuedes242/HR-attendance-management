package com.eduardoguedes.sistemaponto.controller.company;

import com.eduardoguedes.sistemaponto.entity.company.Company;
import com.eduardoguedes.sistemaponto.service.company.CompanyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping(value = "/company", produces = {"application/json"})
@Tag(name = "Nome Api")
public class CompanyController {

  @Autowired
  private CompanyService companyService;



  @GetMapping
  public List<Company> getAllCompany() {
    return  companyService.findAllCompany();
  }

  @Operation(summary = "Cria uma nova empresa", method = "POST")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Empresa criada com sucesso"),
          @ApiResponse(responseCode = "422", description = "Dados invalidos"),
          @ApiResponse(responseCode = "401", description = "Usuario não Autenticado"),
  })
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public void createCompany(@RequestBody Company company) {
    companyService.createCompany(company);
  }
}
