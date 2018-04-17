package com.pip.phonexiaapi.data.response;

import com.pip.phonexiaapi.data.BaseResponse;
import com.pip.phonexiaapi.data.Technology;

import java.util.List;

/**
 * Created by filipsollar on 6.4.18.
 */

public class GetTechnologiesResponse extends BaseResponse {

    private List<Technology> technologies;

    public List<Technology> getTechnologies() {
        return technologies;
    }

}
