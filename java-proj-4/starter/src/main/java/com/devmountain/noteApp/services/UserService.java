package com.devmountain.noteApp.services;

import com.devmountain.noteApp.dtos.UserDto;
import java.util.*;

import javax.transaction.Transactional;

public interface UserService {
    @Transactional
    List<String> addUser(UserDto userDto);

    List<String> userLogin(UserDto userDto);
}
