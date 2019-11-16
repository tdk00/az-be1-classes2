package fsp.db;

import fsp.LoginBean;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class LoginDao {
    public static void main(String[]args) {
        System.out.println("Please Please Select Seat entering this id");
        int n = 8;
        int[][] airplane = new int[n][4];

        for(int i = 1; i <= 4; i++) {
            System.out.printf("\t%8d\t", i);
        }
        System.out.println("");

        for(int j = 1; j <= n; j++) {
            System.out.printf("%d", j);
            for (int k = 1; k <= 4; k++) {
                System.out.print("\tfree(id:"+j*k+")\t");
            }
            System.out.println("");
        }
        Scanner a = new Scanner(System.in);

        String username = a.nextLine();

    }
    public boolean validate(LoginBean loginBean)  {
        boolean status = false;
        String file = "C:\\Users\\LordGamer\\Desktop\\sstp\\az-be1-classes\\src\\main\\java\\fsp\\db\\users.txt";
        File Users = new File(file);
        String ID = "";
        String username= "";
        String password = "";
        try  {
            FileReader fr = new FileReader(Users);
            BufferedReader br = new BufferedReader(fr);
            Scanner x = new Scanner(new File(file));
            x.useDelimiter("[,\n]");

            while (x.hasNext()){
                String inUsername =  loginBean.getUsername();
                String inPassword =   loginBean.getPassword();
                ID = x.next();
                username = x.next();
                password = x.next().replace("\n", "").replace("\r", "");
                if(username.equals(inUsername) && password.equals(inPassword)){
                    status=true;
                }
            }
        } catch (FileNotFoundException fnf) {
            return true;
        }
        return status;
    }
}