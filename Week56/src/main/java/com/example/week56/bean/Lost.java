package com.example.week56.bean;

import javax.persistence.Table;
import java.util.Date;

@Table(name = "lost")
public class Lost {
    private Long lost_id;
    private String lost_name;
    private String lost_position;
    private Date lost_date;
    private String lost_description;
    private String claim_position;
    private boolean is_returned;

    public Long getLost_id() {
        return lost_id;
    }

    public void setLost_id(Long lost_id) {
        this.lost_id = lost_id;
    }

    public String getLost_name() {
        return lost_name;
    }

    public void setLost_name(String lost_name) {
        this.lost_name = lost_name;
    }

    public String getLost_position() {
        return lost_position;
    }

    public void setLost_position(String lost_position) {
        this.lost_position = lost_position;
    }

    public Date getLost_date() {
        return lost_date;
    }

    public void setLost_date(Date lost_date) {
        this.lost_date = lost_date;
    }

    public String getLost_description() {
        return lost_description;
    }

    public void setLost_description(String lost_description) {
        this.lost_description = lost_description;
    }

    public String getClaim_position() {
        return claim_position;
    }

    public void setClaim_position(String claim_position) {
        this.claim_position = claim_position;
    }

    public boolean getIs_returned() {
        return is_returned;
    }

    public void setIs_returned(boolean is_returned) {
        this.is_returned = is_returned;
    }
}
