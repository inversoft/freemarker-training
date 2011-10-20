import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.ObjectWrapper;
import freemarker.template.SimpleHash;
import freemarker.template.SimpleNumber;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

public class ObjectWrapperFreeMarkerServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Configuration configuration = new Configuration();
    configuration.setDirectoryForTemplateLoading(new File("web"));
    configuration.setObjectWrapper(new FortyTwoObjectWrapper());
    
    Template template = configuration.getTemplate("object-wrapper.ftl");

    // Create the map
    Map<String, Object> root = new HashMap<String, Object>();
    root.put("string", "Hello World");

    try {
      template.process(new SimpleHash(root, configuration.getObjectWrapper()), response.getWriter());
    } catch (TemplateException e) {
      throw new ServletException(e);
    }
  }

  public static class FortyTwoObjectWrapper implements ObjectWrapper {
    public TemplateModel wrap(Object obj) throws TemplateModelException {
      return new SimpleNumber(42);
    }
  }
}
