
package com.kirillmozharov.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Forum Profiles"
})
public class FrequentFlyer {

    @JsonProperty("Forum Profiles")
    private List<ForumProfile> forumProfiles = new ArrayList<ForumProfile>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public FrequentFlyer() {
    }

    /**
     * 
     * @param forumProfiles
     */
    public FrequentFlyer(List<ForumProfile> forumProfiles) {
        super();
        this.forumProfiles = forumProfiles;
    }

    @JsonProperty("Forum Profiles")
    public List<ForumProfile> getForumProfiles() {
        return forumProfiles;
    }

    @JsonProperty("Forum Profiles")
    public void setForumProfiles(List<ForumProfile> forumProfiles) {
        this.forumProfiles = forumProfiles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FrequentFlyer that = (FrequentFlyer) o;
        return Objects.equals(forumProfiles, that.forumProfiles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(forumProfiles);
    }

    @Override
    public String toString() {
        return "FrequentFlyer{" +
                "forumProfiles=" + forumProfiles +
                '}';
    }
}
