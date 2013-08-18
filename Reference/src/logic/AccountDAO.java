/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.List;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 *
 * @author Administrator
 */
public class AccountDAO extends JdbcDaoSupport implements AccountDAOFunction  {

    @Override
    public void insertAccount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Account> retrieveAccounts() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
