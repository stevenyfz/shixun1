package com.demo.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 李小宁
 * @since 2020-02-04
 */
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer bid;
    private String bname;
    private String author;
    private Date time;
    private String content;


    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Book{" +
        ", bid=" + bid +
        ", bname=" + bname +
        ", author=" + author +
        ", time=" + time +
        ", content=" + content +
        "}";
    }
}
