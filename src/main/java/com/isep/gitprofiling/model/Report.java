package com.isep.gitprofiling.model;

public class Report {

    private String id;

    private Author author;

    private String dateReport;

    private String repository;

    private String startDate;

    private String endDate;



    public Report(Author author, String date) {
        this.author = author;
        this.dateReport = date;
    }

    public Report(Author author, String date, String repository) {
        this.author = author;
        this.dateReport = date;
        this.repository = repository;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDateReport() {
        return dateReport;
    }

    public void setDateReport(String dateReport) {
        this.dateReport = dateReport;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getDate() {
        return dateReport;
    }

    public void setDate(String date) {
        this.dateReport = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRepository() {
        return repository;
    }

    public void setRepository(String repository) {
        this.repository = repository;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id='" + id + '\'' +
                ", author=" + author +
                ", dateReport='" + dateReport + '\'' +
                ", repository='" + repository + '\'' +
                '}';
    }
}
