package com.utilityhub.apartmentutilityhub.service;

import java.util.Set;

public interface UserService {

    void createUser(String username, String password, String firstName, String lastName, String email, boolean enabled, Set<Long> roleIds);
}
