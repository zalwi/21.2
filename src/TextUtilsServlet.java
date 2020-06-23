import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/textUtils")
public class TextUtilsServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Params
        request.setCharacterEncoding("UTF-8");
        String operationType    = request.getParameter("gridRadios");
        String textArea         = request.getParameter("textArea");

        //Log to console inputParams
        System.out.println("Web service request: " + operationType);

        //Set result encoding
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        switch (operationType) {
            case TextUtils.STATISTICS   -> writer.println(TextUtils.getHtmlReportFromTextStatistics(textArea));
            case TextUtils.PALINDROME   -> writer.println(TextUtils.getHtmlReportFromTextPalindomeCheck(textArea));
            default                     -> writer.println("Brak danych do przetworzenia");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Wywołanie doGet nie jest obsługiwane");
    }
}
