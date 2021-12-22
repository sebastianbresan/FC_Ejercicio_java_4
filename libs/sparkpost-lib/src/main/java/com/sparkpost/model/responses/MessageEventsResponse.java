
package com.sparkpost.model.responses;

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.yepher.jsondoc.annotations.Description;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MessageEventsResponse extends Response {

    // {"results":[],"total_count":0,"links":[]}
    @Description(value = "results", sample = {"\"results\": [ {\"count_injected\": 633,...}]"})
    @SerializedName("results")
    private List<Map<String, Object>> results;

    @Description(
            value = "links",
            sample = {
                    "{ \"next\": \"/api/v1/events/message?events=delivery&per_page=1000&cursor=WycyMDE4LTExLTA1VDIyOjQ1OjM5LjAwMFonLCAnc3BjLTM4MTQ1MjY3MjMyNTA2NTEwJ10=\" }"})
    @SerializedName("links")
    private Map<String, String> links;

    @Description(value = "total_count", sample = {"{ \"total_count\": 0 }"})
    @SerializedName("total_count")
    private int totalCount;

    public boolean hasNext() {
        String next = nextPageUrl();
        return next != null && nextPageUrl().length() > 0;
    }

    public String nextPageUrl() {
        if (this.links == null || this.links.isEmpty()) {
            return "";
        }

        String value = this.links.get("next");
        return value;
    }

}
