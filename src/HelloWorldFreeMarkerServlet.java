import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class HelloWorldFreeMarkerServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Create configuration
    Configuration configuration = new Configuration();

    // Setup directory for templates
    configuration.setDirectoryForTemplateLoading(new File("web"));

    // Get the hello-world.ftl template
    Template template = configuration.getTemplate("hello-world.ftl");
    
    // Process template
    try {
      template.process(new HashMap(), response.getWriter());
    } catch (TemplateException e) {
      throw new ServletException(e);
    }
  }
}
