/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;
import org.junit.Test;
import logic.*;
import mvc.*;
import static org.mockito.Mockito.*;
import static java.util.Arrays.*;
import java.util.HashMap;
import static org.junit.Assert.*;
/**
 *
 * @author Administrator
 */
public class HomeControllerTest {
    
    @Test
    public void shouldDisplayRecentSpittles() {
        List<Excerpt> expectedExcerpt = asList(new Excerpt(), new Excerpt(), new Excerpt());
        ExcerptSpitterDAO exc = mock(HibernateExcerptSpitter.class);
        
        when(exc.retrieveByDate(exc.date)).thenReturn(expectedExcerpt);
        
        HomeController controller = new HomeController();
        
        HashMap<String, Object> model = new HashMap<String, Object>();
        String viewName = controller.showHomePage(model);
        assertEquals("home", viewName);
        assertSame(expectedExcerpt, model.get("excerpts"));
        verify(exc).retrieveByDate(exc.date);
    }
    
}
