package vask.ostock.organizationservice.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vask.ostock.organizationservice.model.Organization;
import vask.ostock.organizationservice.service.OrganizationService;
import javax.annotation.security.RolesAllowed;




@RestController
@RequestMapping(value="v1/organization")
public class OrganizationController {
    @Autowired
    private OrganizationService service;


    @RolesAllowed({"ADMIN","USER"})
    @GetMapping("/test/123/")
    public ResponseEntity<String >getRt(){
        return ResponseEntity.ok("OK");
    }

    @RequestMapping(value="/{organizationId}",method = RequestMethod.GET)
    public ResponseEntity<Organization> getOrganization(@PathVariable("organizationId") String organizationId) {
        return ResponseEntity.ok(service.findById(organizationId));
    }
    @RolesAllowed({"ADMIN","USER"})
    @RequestMapping(value="/{organizationId}",method = RequestMethod.PUT)
    public void updateOrganization( @PathVariable("organizationId") String id, @RequestBody Organization organization) {
        service.update(organization);
    }
    @RolesAllowed({"ADMIN","USER"})
    @PostMapping
    public ResponseEntity<Organization>  saveOrganization(@RequestBody Organization organization) {
    	return ResponseEntity.ok(service.create(organization));
    }
    @RolesAllowed({"ADMIN"})
    @RequestMapping(value="/{organizationId}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrganization( @PathVariable("id") String id,  @RequestBody Organization organization) {
        service.delete(organization);
    }


}
