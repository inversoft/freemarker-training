import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class ModelFreeMarkerServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Configuration configuration = new Configuration();
    configuration.setDirectoryForTemplateLoading(new File("web"));
    
    Template template = configuration.getTemplate("model.ftl");

    // Create the map
    Map<String, Object> root = new HashMap<String, Object>();
    root.put("string", "Hello World");

    // Add a user
    User user = new User();
    user.setAge(35);
    user.setMale(true);
    user.setName("Brian Pontarelli");

    Address home = new Address();
    home.setCity("Broomfield");
    home.setState("CO");
    home.setStreet("1234 Main St.");
    home.setZip("80020");

    user.getAddresses().put("home", home);
    root.put("user", user);

    try {
      template.process(root, response.getWriter());
    } catch (TemplateException e) {
      throw new ServletException(e);
    }
  }
}
