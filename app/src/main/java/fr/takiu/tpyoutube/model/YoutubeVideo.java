package fr.takiu.tpyoutube.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by paulu_000 on 26/02/2016.
 */
public class YoutubeVideo implements Serializable {
    @JsonProperty("kind")
    public String kind ;
    @JsonProperty("etag")
    public String eTag;
    @JsonProperty("id")
    public VideoId id;
    @JsonProperty("snippet")
    public Snippet snippet;

}
