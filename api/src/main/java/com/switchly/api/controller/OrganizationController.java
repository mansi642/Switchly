package com.switchly.api.controller;

import com.switchly.api.model.Organization;
import com.switchly.api.service.OrganizationService;
import org.springframework.web.bind.annotation.*;
import com.switchly.api.dto.CreateOrganizationRequest;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orgs")
public class OrganizationController {
    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService){
        this.organizationService=organizationService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Organization create(@Valid @RequestBody CreateOrganizationRequest request){
        return organizationService.create(request.name());
    }

    @GetMapping
    public List<Organization> getAll(){
        return organizationService.getAll();
    }

    @GetMapping("/{orgId}")
    public Organization getById(@PathVariable UUID orgId){
        return organizationService.getById(orgId);
    }
}
