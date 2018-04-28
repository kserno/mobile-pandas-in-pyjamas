package com.pip.phonexiaapi.data.result;

import java.util.List;

/**
 * Created by filipsollar on 17.4.18
 */
public class SpeakerIdentificationModelsResult extends BaseResult {
    private List<String> models;
    private List<String> groups;

    public List<String> getModels() {
        return models;
    }

    public List<String> getGroups() {
        return groups;
    }
}
