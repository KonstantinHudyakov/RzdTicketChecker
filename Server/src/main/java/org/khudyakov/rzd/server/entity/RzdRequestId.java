package org.khudyakov.rzd.server.entity;

import com.fasterxml.jackson.annotation.JsonAlias;

public class RzdRequestId {
    private String result;
    @JsonAlias({"RID"})
    private String rid;
    private String timestamp;

    public RzdRequestId() {
    }

    public RzdRequestId(String result, String rid, String timestamp) {
        this.result = result;
        this.rid = rid;
        this.timestamp = timestamp;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
