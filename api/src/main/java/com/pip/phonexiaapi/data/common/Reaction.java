package com.pip.phonexiaapi.data.common;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by filipsollar on 18.4.18
 */
public class Reaction {
    @SerializedName("channel_from")
    private int channelFrom;
    @SerializedName("channel_to")
    private int channelTo;
    @SerializedName("speaker_turns")
    private int speakerTurns;
    @SerializedName("avg_reaction")
    private double averageReaction;
    @SerializedName("min_reaction")
    private Response minReaction;
    @SerializedName("max_reaction")
    private Response maxReaction;
    @SerializedName("cross_talks")
    private List<Reaction> crossTalks;

    public int getChannelFrom() {
        return channelFrom;
    }

    public int getChannelTo() {
        return channelTo;
    }

    public int getSpeakerTurns() {
        return speakerTurns;
    }

    public double getAverageReaction() {
        return averageReaction;
    }

    public Response getMinReaction() {
        return minReaction;
    }

    public Response getMaxReaction() {
        return maxReaction;
    }

    public List<Reaction> getCrossTalks() {
        return crossTalks;
    }

    public static class Response {
        private double start;
        private double end;

        public double getStart() {
            return start;
        }

        public double getEnd() {
            return end;
        }
    }
}
