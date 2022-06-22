package com.isep.gitprofiling.model;

public class Author {

    private String authorName;

    private Integer numCommits;

    private Integer insertions;

    private Integer deletions;

    private Float changesPercentage;

    private AdditionalInfo addInfo;

    public Author(String authorName, Integer numCommits, Integer insertions, Integer deletions, Float changesPercentage,AdditionalInfo addInfo) {
        this.authorName = authorName;
        this.numCommits = numCommits;
        this.insertions = insertions;
        this.deletions = deletions;
        this.changesPercentage = changesPercentage;
        this.addInfo = addInfo;
    }

    public Author(String authorName, Integer numCommits, Integer insertions, Integer deletions, Float changesPercentage) {
        this.authorName = authorName;
        this.numCommits = numCommits;
        this.insertions = insertions;
        this.deletions = deletions;
        this.changesPercentage = changesPercentage;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Integer getNumCommits() {
        return numCommits;
    }

    public void setNumCommits(Integer numCommits) {
        this.numCommits = numCommits;
    }

    public Integer getInsertions() {
        return insertions;
    }

    public void setInsertions(Integer insertions) {
        this.insertions = insertions;
    }

    public Integer getDeletions() {
        return deletions;
    }

    public void setDeletions(Integer deletions) {
        this.deletions = deletions;
    }

    public Float getChangesPercentage() {
        return changesPercentage;
    }

    public void setChangesPercentage(Float changesPercentage) {
        this.changesPercentage = changesPercentage;
    }

    public AdditionalInfo getAddInfo() {
        return addInfo;
    }

    public void setAddInfo(AdditionalInfo addInfo) {
        this.addInfo = addInfo;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorName='" + authorName + '\'' +
                ", numCommits=" + numCommits +
                ", insertions=" + insertions +
                ", deletions=" + deletions +
                ", changesPercentage=" + changesPercentage +
                ", addInfo=" + addInfo +
                '}';
    }
}
