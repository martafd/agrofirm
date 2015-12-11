package org.marta.dbservice;

import java.util.List;

/**
 * Created by dav1nci on 28.10.15.
 */
public interface IUserService
{
    void addContact(UserEntity contact);

    UserEntity getUser(String email);

    List<UserEntity> listContact();

    void removeContact(Integer id);
}
