package fr.takiu.tpyoutube.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by paulu_000 on 26/02/2016.
 */
public class VideoId implements Serializable {
    @JsonProperty("kind")
    public String kind ;
    @JsonProperty("videoId")
    public String videoId;
}
