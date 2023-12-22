package sn.isi.service;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.isi.dao.IAppRolesRepository;
import sn.isi.dto.AppRoles;
import sn.isi.exception.EntityNotFoundException;
import sn.isi.exception.RequestException;
import sn.isi.mapping.AppRolesMapper;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AppRolesService {
    private IAppRolesRepository iAppRolesRepository;
    private AppRolesMapper appRolesMapper;
    MessageSource messageSource;

    public AppRolesService(IAppRolesRepository iAppRolesRepository, AppRolesMapper appRolesMapper, MessageSource messageSource) {
        this.iAppRolesRepository = iAppRolesRepository;
        this.appRolesMapper = appRolesMapper;
        this.messageSource = messageSource;
    }

    //All Roles
    @Transactional(readOnly = true)
    public List<AppRoles> getAppRoles(){
        List<AppRoles> appRoles = Arrays
                                        .asList(new AppRoles(), new AppRoles());

        List<String> nomsAppRoles = appRoles.stream()
                .map(appRole -> appRole.getNom())
                .collect(Collectors.toList());

        return StreamSupport.stream(iAppRolesRepository.findAll().spliterator(), false)
                .map(appRolesMapper::toAppRoles)
                .collect(Collectors.toList());
    }

    //GetRole By Id
    @Transactional(readOnly = true)
    public AppRoles getAppRole(int id){
        return appRolesMapper.toAppRoles(iAppRolesRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException(messageSource.getMessage("role.notfound", new Object[]{id},
                        Locale.getDefault()))));
    }

    //GetRole By Nom


    //ADD
    @Transactional(readOnly = true)
    public AppRoles createAppRoles(AppRoles appRoles){
        return appRolesMapper.toAppRoles(iAppRolesRepository.save(appRolesMapper.fromAppRoles(appRoles)));
    }

    //UPDATE
    @Transactional
    public AppRoles updateAppRoles(int id, AppRoles appRoles){
        return iAppRolesRepository.findById(id)
                .map(entity ->{
                    appRoles.setId(id);
                    return appRolesMapper.toAppRoles(
                            iAppRolesRepository.save(appRolesMapper.fromAppRoles(appRoles))
                    );

                }).orElseThrow(()-> new EntityNotFoundException(messageSource.getMessage("role.notfound", new Object[]{id},
                    Locale.getDefault())));
    }

    //DELETE
    @Transactional
    public void deleteAppRoles(int id){
        try {
            iAppRolesRepository.deleteById(id);
        }catch (Exception e){
            throw new RequestException(messageSource.getMessage("role.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }


}
