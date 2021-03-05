import java.io.Console;
import Controllers.AccountController;
import Models.Users.User;

public class Main {
    public static void main(String[] args) {
        // Instanciando os controllers
        AccountController acctrl = new AccountController();
        Console console = System.console();

        if (console == null) {
            System.out.println("Num foi possivel iniciar a instancia do console");
            System.exit(0);
        }

        System.out.println("\n\n\t\t~ ~ ~ SEJA BEM-VINDO AO CRAPDNDMANAGER ~ ~ ~ \n");

        Boolean successLogin = false;
        
        do {
            successLogin = login(console, acctrl);
        } while (!successLogin);
    }

    private static Boolean login(Console console, AccountController acctrl){
        User currentUser = new User();

        currentUser.setNickname(console.readLine("\nNickname: "));
        currentUser.setPassword(new String(console.readPassword("Senha: ")));

        if(acctrl.CheckPassword(currentUser.getPassword(), currentUser.getNickname())){
            acctrl.setCurrentUser(currentUser);
            System.out.println("\nLogin realizado com sucesso!");
            return true;
        } else {
            System.out.println("Falha ao realizar o login! Usuario ou senha informados num saum validos");
            return false;
        }
    }
}
