package fr.takiu.tpyoutube.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by paulu_000 on 26/02/2016.
 */
public class YoutubeRequestResult implements Serializable {
    @JsonProperty("kind")
    public String kind ;
    @JsonProperty("etag")
    public String eTag;
    @JsonProperty("nextPageToken")
    public String nextPageToken ;
    @JsonProperty("prevPageToken")
    public String prevPageToken;
    public String regionCode;
    @JsonProperty("pageInfo")
    public PageInfo pageInfo;

    @JsonProperty("items")
    public YoutubeVideo[] items;
}
