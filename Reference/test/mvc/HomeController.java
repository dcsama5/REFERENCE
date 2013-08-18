/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import java.util.Date;
import java.util.Map;
import org.springframework.stereotype.Controller;
import logic.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Administrator
 */
@Controller
public class HomeController {
    

    
    @Autowired
    private ExcerptSpitterDAO hibernateDAO;
    
    @RequestMapping({"/", "/home"})
    
    public String showHomePage(Map<String, Object> model)
    {
        model.put("excerpts", hibernateDAO.retrieveByDate(ExcerptSpitterDAO.date));
        return "home";
    }
}
