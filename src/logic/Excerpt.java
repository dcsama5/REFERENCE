package logic;/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class Excerpt {
    
    private String account;
    private String excerpt;
    private String link;
    private String comments;
    private Date date;

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setDate() {
            this.date = Calendar.getInstance().getTime();    }

    public String getAccount() {
        return account;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public String getLink() {
        return link;
    }

    public String getComments() {
        return comments;
    }

    public Date getDate() {
        
       return this.date;
    }
    
    public Excerpt()
    {
        
    }
    
}
