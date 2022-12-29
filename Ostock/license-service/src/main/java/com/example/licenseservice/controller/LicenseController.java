package com.example.licenseservice.controller;

import com.example.licenseservice.model.License;
import com.example.licenseservice.service.LicenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;


@RestController
@RequestMapping(value="v1/organization/" +
        "{organizationId}/license")
@RequiredArgsConstructor
public class LicenseController {
    private final LicenseService licenseService;


    @GetMapping(value="/{licenseId}")
    public ResponseEntity<License> getLicense(
            @PathVariable("organizationId") String organizationId,
            @PathVariable("licenseId") String licenseId) {

            License license =
                    licenseService.getLicense(licenseId,organizationId);
        license.add(linkTo(methodOn(LicenseController.class)
                        .getLicense(organizationId, license.getLicenseId()))
                        .withSelfRel(),
                linkTo(methodOn(LicenseController.class)
                        .createLicense(organizationId, license, null))
                        .withRel("createLicense"),
                linkTo(methodOn(LicenseController.class)
                        .updateLicense(organizationId, license))
                        .withRel("updateLicense"));
//                ,linkTo(methodOn(LicenseController.class)
//                        .deleteLicense(organizationId, license.getLicenseId()))
//                        .withRel("deleteLicense"));
              return ResponseEntity.ok(license);
    }

    @PutMapping
    public ResponseEntity<String> updateLicense(
            @PathVariable("organizationId") String organizationId,
            @RequestBody License request) {
        return ResponseEntity.ok(licenseService.updateLicense(request,
                organizationId));
    }

    @PostMapping
    public ResponseEntity<String> createLicense(
            @PathVariable("organizationId") String organizationId,
            @RequestBody License request,
            @RequestHeader(value = "Accept-Language",required = false)
                    Locale locale) {
        return ResponseEntity.ok(licenseService.createLicense(request,
                organizationId,locale));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteLicense(
            @PathVariable("organizationId") String organizationId,
            @PathVariable("licenseId") String licenseId) {
        return ResponseEntity.ok(licenseService.deleteLicense(licenseId,
                organizationId));
    }
}



