package com.markteplace.domain.user;


import com.markteplace.core.generic.AbstractEntityService;

public interface UserService extends AbstractEntityService<User> {
    User findByUsername(String username);
    User preSave(User entity);
}

