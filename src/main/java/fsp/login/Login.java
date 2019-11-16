package fsp.login;

import fsp.LoginBean;
import fsp.db.LoginDao;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {

        Scanner a = new Scanner(System.in);
        System.out.println("Please Type Your username");
        String username = a.nextLine();
        System.out.println("Please Type Your password");
        String password = a.nextLine();
        LoginDao loginDao = new LoginDao();
        LoginBean login = new LoginBean(username,password);
        boolean aa = loginDao.validate(login);
        if(aa==true) {
            System.out.print("<h1>You have logined successfully</h1>");
        }
        else{
            System.out.print("<h1>You have logined unsuccessfully</h1>");
        }
    }
}
