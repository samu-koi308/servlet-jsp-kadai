package forms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ConfirmServlet extends HttpServlet {
    // POSTメソッドのリクエスト受信時に実行されるメソッド
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        // リクエスト・レスポンスの設定
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        // JSPからのリクエストデータ取得
        String name = request.getParameter("user_name");
        String email = request.getParameter("user_email");
        String adress = request.getParameter("user_adress");
        String phone_number = request.getParameter("user_phone_number");
        //String message = request.getParameter("message");

        // リクエストスコープにデータ保存
        request.setAttribute( "name", name );
        request.setAttribute( "email", email );
        request.setAttribute( "adress", adress );
        request.setAttribute( "phone_number", phone_number );
        //request.setAttribute( "message", message );

        // データが存在しない場合は空文字に置き換え
        name = Objects.toString(name, "");
        email = Objects.toString(email, "");
        adress = Objects.toString(adress, "");
        phone_number = Objects.toString(phone_number, "");
        //message = Objects.toString(message, "");

        // バリデーションNG時のメッセージを格納するリスト
        ArrayList<String> errorList = new ArrayList<String>();

        // お名前のバリデーション
        if( "".equals(name.trim()) ) { // 未入力
            // お名前が未入力の場合
            errorList.add("お名前を入力してください。");
        }

        // メールアドレスのバリデーション
        if( "".equals(email.trim()) ) { // 未入力
            errorList.add("メールアドレスを入力してください。");
        } else if( !email.matches("^[a-zA-Z0-9.]+@[a-zA-Z0-9.]+$") ) { // 入力形式
            errorList.add("メールアドレスの入力形式が正しくありません。");
        }
        
        // 住所のバリデーション
        if( "".equals(adress.trim()) ) { // 未入力
            // 住所が未入力の場合
            errorList.add("住所を入力してください。");
        }
        
        // 電話番号のバリデーション
        if( "".equals(phone_number.trim()) ) { // 未入力
            errorList.add("電話番号を入力してください。");
        } else if( !phone_number.matches("^[0-9]+[-][0-9]+[-][0-9]+$") ) { // 入力形式
            errorList.add("電話番号の入力形式が正しくありません。");
        }

        // お問い合わせ内容のバリデーション
        //if( "".equals(message.trim()) ) { // 未入力
            //errorList.add("お問い合わせ内容を入力してください。");
        //} else if( message.length() > 100 ) { // 文字数超過
            //errorList.add("お問い合わせ内容が100文字を超えています。");
        //}

        // エラーリストが空かどうか
        if( !errorList.isEmpty() ) {
            // エラーがある場合はリストをリクエストスコープに登録
            request.setAttribute("errorList", errorList);
         } else {
             // セッションの取得
             HttpSession session = request.getSession();

             // セッションへのデータ登録
             session.setAttribute( "name", name );
             session.setAttribute( "email", email );
             //session.setAttribute( "adress", adress );
             //session.setAttribute( "phone_number", phone_number );
             //session.setAttribute( "message", message );

             // クッキーに保存
             //setCookie(response, "name", name );
             //setCookie(response, "email", email );
             //setCookie(response, "adress", adress );
             //setCookie(response, "phone_number", phone_number );
        }

        // フォワードによる画面遷移
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/confirmPage.jsp");
        dispatcher.forward(request, response);
    }

     // 新しいクッキーを設定するメソッド
     //private void setCookie(HttpServletResponse response, String name, String value ) {
         //Cookie cookie = new Cookie(name, value);
         //cookie.setMaxAge(60 * 60 * 24 * 1); // 有効期限は1日
         //response.addCookie(cookie);
     //}
}

