package sn.isi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.entities.AppUserEntity;

public interface IAppUserRepository extends JpaRepository<AppUserEntity, Integer> {
    //Recuperer un user à partir de son nom ou de son mail
    AppUserEntity findByMail(String email);
}
