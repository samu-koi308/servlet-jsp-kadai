package forms;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet {
    // GETメソッドのリクエスト受信時に実行されるメソッド
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

         // クッキーの取得
         //Cookie[] userCookies = request.getCookies();

         // クッキーが存在する場合
         //if( userCookies != null ) {
             // 配列内のクッキー名を順番にチェック
             //for( Cookie cookie : userCookies ) {
                 // クッキー名に応じてデータを取得・保存
                 //switch( cookie.getName() ) {
                     //case "name": // 氏名
                         //request.setAttribute("userName", cookie.getValue());
                         //break;
                     //case "email": // メールアドレス
                         //request.setAttribute("userEmail", cookie.getValue());
                         //break;
                    // case "adress": // 住所
                         //request.setAttribute("userAdress", cookie.getValue());
                         //break;
                     //case "phone_number": // 電話番号
                         //request.setAttribute("userPhone_Number", cookie.getValue());
                         //break;
                     //default:
                        // break; // 何もしない
                 //}
             //}
         //}

        // フォワードによる画面遷移
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/formPage.jsp");
        dispatcher.forward(request, response);
    }
}