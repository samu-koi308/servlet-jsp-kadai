package forms;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CompleteServlet extends HttpServlet {
    // GETメソッドのリクエスト受信時に実行されるメソッド
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
         // フォワードによる画面遷移
         RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/completePage.jsp");
         dispatcher.forward(request, response);
    }
}