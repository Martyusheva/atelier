package com.example.atelier.model.Requests;

import javax.persistence.*;

@Entity(name = "Request")
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue
    protected int id;
    protected int adminid;
    protected String collection;
    protected String model;
    protected String comment;
    protected double price;
    protected int userid;
    protected int progress;

    public void setProgress(int progress) {
        this.progress = progress;
    }



    public Request(int adminid, String collection, String model, String comment, double price, int userid, int progress) {
        this.adminid = adminid;
        this.collection = collection;
        this.model = model;
        this.comment = comment;
        this.price = price;
        this.userid = userid;
        this.progress = progress;
    }

    public Request() {
    }

    public int getId() {
        return id;
    }

    public int getAdminid() {
        return adminid;
    }

    public String getCollection() {
        return collection;
    }

    public String getModel() {
        return model;
    }

    public String getComment() {
        return comment;
    }

    public double getPrice() {
        return price;
    }

    public int getUserid() {
        return userid;
    }

    public String getProgress() {
        return progressToString(intToProgress(progress));
    }

    public enum Progress {
        New, InProgress, Fitting, Done, Closed
    }

    public static String progressToString(Progress progress) {
        String result = "";
        switch (progress) {
            case New:
                result = "New";
                break;
            case InProgress:
                result = "InProgress";
                break;
            case Done:
                result = "Done";
                break;
            case Closed:
                result = "Closed";
                break;
        }
        return result;
    }

    public static int progressToInt(Progress progress) {
        int result = 0;
        switch (progress) {
            case New:
                result = 0;
                break;
            case InProgress:
                result = 1;
                break;
            case Done:
                result = 2;
                break;
            case Closed:
                result = 3;
                break;
        }
        return result;
    }

    public static Progress intToProgress(int intProgress) {
        Progress result = Progress.New;
        switch (intProgress) {
            case 0:
                result = Progress.New;
                break;
            case 1:
                result = Progress.InProgress;
                break;
            case 2:
                result = Progress.Done;
                break;
            case 3:
                result = Progress.Closed;
                break;
        }
        return result;
    }

}
