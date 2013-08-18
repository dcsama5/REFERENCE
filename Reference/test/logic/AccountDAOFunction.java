/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.List;

/**
 *
 * @author Administrator
 */
interface AccountDAOFunction {
    
    void insertAccount();
    List<Account> retrieveAccounts();
    
}
