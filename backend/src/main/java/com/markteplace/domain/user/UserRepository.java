package com.markteplace.domain.user;

import com.markteplace.core.generic.AbstractEntityRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends AbstractEntityRepository<User> {
    User findByUsername(String username);
}
