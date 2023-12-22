package sn.isi.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sn.isi.dto.AppRoles;
import sn.isi.service.AppRolesService;

import javax.management.relation.Role;
import java.util.List;

@RestController
@RequestMapping("/roles")
@AllArgsConstructor
public class AppRolesController {
    private
    AppRolesService appRolesService;

    @GetMapping
    public List<AppRoles> getAppRoles(){
        return appRolesService.getAppRoles();
    }

    @GetMapping("/{id}")
    public AppRoles getAppRole(@PathVariable("id") int id){
        return appRolesService.getAppRole(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public AppRoles createAppRoles(@Valid @RequestBody AppRoles appRoles){
        return  appRolesService.createAppRoles(appRoles);
    }

    @PutMapping("/{id}")
    public AppRoles updateAppRoles(@PathVariable("id") int id, @Valid @RequestBody AppRoles appRoles){
        return appRolesService.updateAppRoles(id, appRoles);
    }

    @DeleteMapping 
    public void deleteAppRole(@PathVariable("id") int id){
         appRolesService.deleteAppRoles(id);
    }

}
