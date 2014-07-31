package ru.yamoney.test;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by def on 31.07.14.
 */
public class SettingsService extends HttpServlet {

    private String responseTemplate =
            "<html>\n" +
                    "<body>\n" +
                    "${BODY}\n" +
                    "</body>\n" +
                    "</html>";
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.process(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        FileWorker fileWorker = new FileWorker();
        String file = request.getParameter("file");
        String edit = request.getParameter("edit");
        StringBuffer outText = new StringBuffer();
        ServletContext context = getServletContext();
        if (file != null) {
            String fullPath = context.getRealPath("/WEB-INF/files/" + file);
            if (edit != null) {
                fileWorker.editFile(fullPath);
            }
            else {
                outText.append(fileWorker.viewFile(fullPath));
            }
        }
        else {
            outText.append("Example file=TK21.properties");
        }
        response.getWriter().print(outText);


    }
}
