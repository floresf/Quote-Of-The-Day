package qotd;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Save extends HttpServlet {
 // get and keep a reference to the shared Model instance
  private Model model = Model.getInstance();
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response) throws IOException, ServletException {
    try {
      model.save();
    } catch (Exception e) {

    }
    ServletContext sc = this.getServletContext();
    RequestDispatcher rd = sc.getRequestDispatcher("/list.jsp");
    request.setAttribute("quotes", model.retrieveAll());
    rd.forward(request, response);
  }
}

