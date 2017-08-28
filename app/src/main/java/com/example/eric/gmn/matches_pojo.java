package com.example.eric.gmn;

import java.io.Serializable;

/**
 * Created by Eric on 23/08/2017.
 */

public class matches_pojo implements Serializable {
    private int match_id;
    private String match_time;
    private String match_date;
    private String match_place;
    private String match_team1_home;
    private String match_team2_away;
    private String match_legue_name;
    private String match_legue_id;
    private String match_team1_score;
    private String match_team2_score;

    public matches_pojo(int match_id, String match_time, String match_date, String match_place, String match_team1_home, String match_team2_away) {
        this.match_id = match_id;
        this.match_time = match_time;
        this.match_date = match_date;
        this.match_place = match_place;
        this.match_team1_home = match_team1_home;
        this.match_team2_away = match_team2_away;
    }

    public matches_pojo(int match_id, String match_time, String match_date, String match_place, String match_team1_home, String match_team2_away, String match_legue_name, String match_legue_id, String match_team1_score, String match_team2_score) {
        this.match_id = match_id;
        this.match_time = match_time;
        this.match_date = match_date;
        this.match_place = match_place;
        this.match_team1_home = match_team1_home;
        this.match_team2_away = match_team2_away;
        this.match_legue_name = match_legue_name;
        this.match_legue_id = match_legue_id;
        this.match_team1_score = match_team1_score;
        this.match_team2_score = match_team2_score;
    }

    public matches_pojo(int match_id, String match_time, String match_date, String match_team1_home, String match_team2_away) {
        this.match_id = match_id;
        this.match_time = match_time;
        this.match_date = match_date;
        this.match_team1_home = match_team1_home;
        this.match_team2_away = match_team2_away;
    }

    public int getMatch_id() {
        return match_id;
    }

    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }

    public String getMatch_time() {
        return match_time;
    }

    public void setMatch_time(String match_time) {
        this.match_time = match_time;
    }

    public String getMatch_date() {
        return match_date;
    }

    public void setMatch_date(String match_date) {
        this.match_date = match_date;
    }

    public String getMatch_place() {
        return match_place;
    }

    public void setMatch_place(String match_place) {
        this.match_place = match_place;
    }

    public String getMatch_team1_home() {
        return match_team1_home;
    }

    public void setMatch_team1_home(String match_team1_home) {
        this.match_team1_home = match_team1_home;
    }

    public String getMatch_team2_away() {
        return match_team2_away;
    }

    public void setMatch_team2_away(String match_team2_away) {
        this.match_team2_away = match_team2_away;
    }

    public String getMatch_legue_name() {
        return match_legue_name;
    }

    public void setMatch_legue_name(String match_legue_name) {
        this.match_legue_name = match_legue_name;
    }

    public String getMatch_legue_id() {
        return match_legue_id;
    }

    public void setMatch_legue_id(String match_legue_id) {
        this.match_legue_id = match_legue_id;
    }

    public String getMatch_team1_score() {
        return match_team1_score;
    }

    public void setMatch_team1_score(String match_team1_score) {
        this.match_team1_score = match_team1_score;
    }

    public String getMatch_team2_score() {
        return match_team2_score;
    }

    public void setMatch_team2_score(String match_team2_score) {
        this.match_team2_score = match_team2_score;
    }
}
