package com.pip.phonexiaapi.data.common;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by filipsollar on 18.4.18
 */
public class Conversation {
    @SerializedName("reaction")
    private List<Reaction> reactions;

    public List<Reaction> getReactions() {
        return reactions;
    }
}
