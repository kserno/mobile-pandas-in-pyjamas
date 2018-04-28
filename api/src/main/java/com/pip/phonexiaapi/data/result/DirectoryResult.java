package com.pip.phonexiaapi.data.result;

import com.pip.phonexiaapi.data.common.DirectoryItem;

import java.util.List;

/**
 * Created by filipsollar on 17.4.18
 */
public class DirectoryResult extends BaseResult{
    private List<DirectoryItem> list;

    public List<DirectoryItem> getList() {
        return list;
    }
}
