package org.koreait;

public class Article {
    private int id;
    private String content;
    private String author;
    private String regDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Article(int lastId, String content, String author, String regDate) {
        this.id = lastId;
        this.content = content;
        this.author = author;
        this.regDate = regDate;
    }
}
