package com.pip.phonexiaapi.data.result;

import com.pip.phonexiaapi.data.common.User;

import java.util.List;

/**
 * Created by filipsollar on 17.4.18
 */
public class AdminUsersResult extends BaseResult {
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }
}
