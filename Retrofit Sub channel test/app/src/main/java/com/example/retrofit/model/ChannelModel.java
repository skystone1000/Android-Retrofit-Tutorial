package com.example.retrofit.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "description",
        "created_by",
        "timestamp",
        "subchannel_count",
        "videos_count",
        "parent_channel",
        "Videos"
})

public class ChannelModel {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("created_by")
    private Object createdBy;
    @JsonProperty("timestamp")
    private String timestamp;
    @JsonProperty("subchannel_count")
    private Integer subchannelCount;
    @JsonProperty("videos_count")
    private Integer videosCount;
    @JsonProperty("parent_channel")
    private String parentChannel;
    @JsonProperty("Videos")
    private Object videos;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("created_by")
    public Object getCreatedBy() {
        return createdBy;
    }

    @JsonProperty("created_by")
    public void setCreatedBy(Object createdBy) {
        this.createdBy = createdBy;
    }

    @JsonProperty("timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty("subchannel_count")
    public Integer getSubchannelCount() {
        return subchannelCount;
    }

    @JsonProperty("subchannel_count")
    public void setSubchannelCount(Integer subchannelCount) {
        this.subchannelCount = subchannelCount;
    }

    @JsonProperty("videos_count")
    public Integer getVideosCount() {
        return videosCount;
    }

    @JsonProperty("videos_count")
    public void setVideosCount(Integer videosCount) {
        this.videosCount = videosCount;
    }

    @JsonProperty("parent_channel")
    public String getParentChannel() {
        return parentChannel;
    }

    @JsonProperty("parent_channel")
    public void setParentChannel(String parentChannel) {
        this.parentChannel = parentChannel;
    }

    @JsonProperty("Videos")
    public Object getVideos() {
        return videos;
    }

    @JsonProperty("Videos")
    public void setVideos(Object videos) {
        this.videos = videos;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("description", description).append("createdBy", createdBy).append("timestamp", timestamp).append("subchannelCount", subchannelCount).append("videosCount", videosCount).append("parentChannel", parentChannel).append("videos", videos).append("additionalProperties", additionalProperties).toString();
    }

}


