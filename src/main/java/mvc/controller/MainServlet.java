package mvc.controller;

import TelegramBot.Bot;
import mvc.dao.entity.User;
import mvc.dao.repository.UserRepository;
import mvc.view.IndexView;
import mvc.view.UserView;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MainServlet", urlPatterns = {"/"}, loadOnStartup = 1)
public class MainServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        int chat_id = Integer.parseInt(password);

        if (email != null) {
            UserRepository userRepository = new UserRepository();
            User user = userRepository.getUserByID(chat_id);
            if (user != null){
                session.setAttribute("email", email);
            }

        }
        resp.sendRedirect("/TelegramBot_war_exploded");


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        IndexView indexView = IndexView.getInstance();

        if (session.getAttribute("email") != null) {
            out.println("Welcome " + session.getAttribute("email"));
        } else {
            UserView userView = new UserView();
            out.println(userView.getLoginPage());

        }
    }

    @Override
    public void init() throws ServletException {
        super.init();
        IndexView indexView = IndexView.getInstance();
        indexView.setPath(getServletContext().getRealPath("/html/"));

        ApiContextInitializer.init();

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        Bot Bot = new Bot();
                try{
                    telegramBotsApi.registerBot(Bot);
                }catch (TelegramApiException e){
                    e.printStackTrace();
                }
    }
}
