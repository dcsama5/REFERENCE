package logic;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Administrator
 */
public class JDBCExcerptSpitter implements ExcerptSpitterDAO {

    
    private JdbcTemplate SpitterTemplate; 
    private PreparedStatement createEntrystmt;
    private static final String queryAllExcerpts = "SELECT * FROM REFERENCE";
   
    public void addExcerpt(Excerpt exc) {
        this.SpitterTemplate.update("INSERT INTO REFERENCE (ACCOUNT, EXCERPT, LINK, COMMENTS, DATE) VALUES (?, ?, ?, ?, ?)", 
                exc.getAccount(), exc.getExcerpt(), exc.getLink(), exc.getComments(), exc.getDate());
   }
    public boolean createTable() {
        return false;
    
    }
    public void removeExcerpt() {
//    
    }

        
    public void updateExcerpt() {
    }

    public void setSpitterTemplate(JdbcTemplate jdbcTemplate) {
 this.SpitterTemplate = jdbcTemplate;    }

    @Override
    public Map<String, Object> getMappedExcerpt() {
        Map<String, Object> excerpts = this.SpitterTemplate.queryForMap(queryAllExcerpts);
        return excerpts;
    }
    
    public List<Excerpt> retrieveAllExcerpts()
    {
        List<Excerpt> list = this.SpitterTemplate.query(queryAllExcerpts, new ExcerptMapper());
        return list;
        
    }

    @Override
    public void removeExcerpt(Excerpt exc) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateExcerpt(Excerpt exc) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private static final class ExcerptMapper implements RowMapper<Excerpt> {
        public Excerpt mapRow(ResultSet rs, int rowNum) throws SQLException {
            Excerpt exc = new Excerpt();
            exc.setAccount(rs.getString("ACCOUNT"));
            exc.setComments(rs.getString("COMMENTS"));
            exc.setDate(rs.getDate("DATE"));
            exc.setExcerpt(rs.getString("EXCERPT"));
            exc.setLink(rs.getString("LINK"));
            return exc;
        }
    }
    
   
    
}
