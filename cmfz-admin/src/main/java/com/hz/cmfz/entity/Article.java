package com.hz.cmfz.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by 11022 on 2018/7/8 0008.
 */
public class Article implements Serializable{
    private String articleId;
    private String articleName;
    private String introduction;
    private String articleStatus;
    private Date articleDate;
    private String articleByName;
    private Integer errno;
    private List<String> data;

    public Article() {
    }

    public Article(String articleId, String articleName, String introduction, String articleStatus, Date articleDate, String articleByName, Integer errno, List<String> data) {
        this.articleId = articleId;
        this.articleName = articleName;
        this.introduction = introduction;
        this.articleStatus = articleStatus;
        this.articleDate = articleDate;
        this.articleByName = articleByName;
        this.errno = errno;
        this.data = data;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticleUrl() {
        return introduction;
    }

    public void setArticleUrl(String articleUrl) {
        this.introduction = articleUrl;
    }

    public String getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(String articleStatus) {
        this.articleStatus = articleStatus;
    }

    public Date getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(Date articleDate) {
        this.articleDate = articleDate;
    }

    public String getArticleByName() {
        return articleByName;
    }

    public void setArticleByName(String articleByName) {
        this.articleByName = articleByName;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId='" + articleId + '\'' +
                ", articleName='" + articleName + '\'' +
                ", introduction='" + introduction + '\'' +
                ", articleStatus='" + articleStatus + '\'' +
                ", articleDate=" + articleDate +
                ", articleByName='" + articleByName + '\'' +
                ", errno=" + errno +
                ", data=" + data +
                '}';
    }
}
