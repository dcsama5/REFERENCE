

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import logic.*;
import java.util.List;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static java.util.Arrays.*;
import java.util.Date;
import java.util.HashMap;
import static org.junit.Assert.*;
import org.junit.Before;
import mvc.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 *
 * @author Administrator
 */

public class HomeControllerTest {
    

Date date = new Date(113, 7, 1);
    @Before
    public void setUp() throws Exception
    {         
    }
    @Test
    public void shouldDisplayRecentSpittles() {
        List<Excerpt> expectedExcerpt = asList(new Excerpt(), new Excerpt(), new Excerpt());
        ExcerptSpitterDAO exc = mock(HibernateExcerptSpitter.class);
        
        when(exc.retrieveByDate("AMEER")).thenReturn(expectedExcerpt);
        
        HomeController controller = new HomeController(exc);
        
        HashMap<String, Object> model = new HashMap<String, Object>();
        String viewName = controller.showHomePage(model);
        assertEquals("home", viewName);
        assertSame(expectedExcerpt, model.get("excerpts"));
        verify(exc).retrieveByDate("AMEER");
    }
    
}
