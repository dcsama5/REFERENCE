package logic;/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Administrator
 */
@Entity
@Table(schema="PUBLIC", name="REFERENCE")
public class Excerpt implements Serializable {
    
    private String account;
   /* private String excerpt;
      public String getExcerpt() {
        return excerpt;
    }
      
    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }
    */
    @EmbeddedId
            ExcerptIdentifier id;
    
    
    private String link;
    public void setLink(String link) {
        this.link = link;
    }
    
    public void setId(ExcerptIdentifier id)
    {
        this.id = id;
    }
    public String getLink() {
        return link;
    }
    
    private String comments;
    public void setDate() {
        id.setDate();
        
    }
    
    public Date getDate() {
        
        return id.getDate();
    }
    /*    private Date date;
     *
     *
     *
     * public void setDate() {
     * this.date = Calendar.getInstance().getTime();    }
     */
    public void setAccount(String account) {
        this.account = account;
    }
    
    
    
    public void setComments(String comments) {
        this.comments = comments;
    }
    
    
    public String getAccount() {
        return account;
    }
    
  
    
    
    public String getComments() {
        return comments;
    }
    
    
    
    public Excerpt()
    {
        
    }
    
    

}


