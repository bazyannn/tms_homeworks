/*Необходимо создать 2 сервлета.
        Один выводит текущую дату.
        Второй выводит имя пользователя, взяв информацию из запроса.
        Необходимо создать фильтр, который будет срабатывать только перед вторым сервлетом.
        Этот фильтр проверяет наличие параметра в запросе, в которое помещено имя клиента.
        Если имя имеет менее 5 символов, то сделать перенаправление из второго сервлета в первый.
        Все конфигурации выполнить при помощи аннотаций.*/

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/home")
public class NameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");

        PrintWriter writer = resp.getWriter();

        if (name == null){
            writer.println("Hello from homepage");
        } else {
            writer.println(name);
        }
    }
}

