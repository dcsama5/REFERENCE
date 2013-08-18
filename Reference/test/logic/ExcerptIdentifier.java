package logic;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;

@Embeddable
    public class ExcerptIdentifier implements Serializable
    {
        String Excerpt;
        @Temporal(javax.persistence.TemporalType.DATE)
        Date date;

    public String getExcerpt() {
        return Excerpt;
    }

    public void setExcerpt(String Excerpt) {
        this.Excerpt = Excerpt;
    }

    public Date getDate() {
        return date;
    }

    public void setDate() {
       this.date = Calendar.getInstance().getTime();
    }
    public ExcerptIdentifier()
    {
        this.date = Calendar.getInstance().getTime();
    }
    
    }