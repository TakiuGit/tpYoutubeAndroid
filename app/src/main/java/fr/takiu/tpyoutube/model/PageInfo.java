package fr.takiu.tpyoutube.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by paulu_000 on 26/02/2016.
 */
public class PageInfo implements Serializable {
    @JsonProperty("totalResults")
    Integer totalResults;
    @JsonProperty("resultsPerPage")
    Integer resultsPerPage;
}
