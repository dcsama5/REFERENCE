/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import java.util.Date;
import java.util.Map;
import javax.inject.Inject;
import logic.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Administrator
 */
//@Controller
public class HomeController {
    

    
    @Inject
    private ExcerptSpitterDAO hibernateExcerptSpitter;
    Date date = new Date(113, 7, 1);
    public HomeController(ExcerptSpitterDAO hibernateExcerptSpitter)
    {
        this.hibernateExcerptSpitter = hibernateExcerptSpitter;
    }
    @RequestMapping({"/", "/home"})
    
    public String showHomePage(Map<String, Object> model)
    {
            model.put("excerpts", hibernateExcerptSpitter.retrieveByDate("AMEER"));
        return "home";
    }
}
