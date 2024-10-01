package com.eduardoguedes.sistemaponto.controller.company;

import com.eduardoguedes.sistemaponto.entity.company.Company;
import com.eduardoguedes.sistemaponto.entity.company.CompanyRequestDTO;
import com.eduardoguedes.sistemaponto.service.company.CompanyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping(value = "/company", produces = {"application/json"})
@Tag(name = "Company")
public class CompanyController {

  @Autowired
  private CompanyService companyService;


  @GetMapping
  public List<Company> getAllCompany() {
    return  companyService.findAllCompany();
  }

  @Operation(summary = "Register new company", method = "POST", security = @SecurityRequirement(name = "bearerAuth"))
  @ApiResponses(value = {
          @ApiResponse(responseCode = "201", description = "New company register with success"),
          @ApiResponse(responseCode = "400", description = "Data invalid"),
          @ApiResponse(responseCode = "403", description = "User not authenticated"),
          @ApiResponse(responseCode = "500", description = "Problem server"),
  })
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> createCompany(@Valid @RequestBody CompanyRequestDTO companyDTO) {
    Company companyData = new Company(companyDTO);
    companyService.createCompany(companyData);

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
}
