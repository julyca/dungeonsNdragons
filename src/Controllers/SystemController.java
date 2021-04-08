package Controllers;

import java.io.Console;
import java.util.Random;

import Models.Dice;
import Models.Users.User;

public class SystemController {
    
    private Boolean exeSys;
    private Boolean successLogin;
    private Boolean cmdMode;
    private Console console;
    private User currentUser;

    private AccountController acctrl;

    public SystemController(){
        this.exeSys = true;
        this.successLogin = false;
        this.cmdMode = false;
        this.console = System.console();

        this.acctrl = new AccountController();

        if (console == null) {
            System.out.println("Num foi possivel iniciar a instancia do console");
            System.exit(0);
        }

        System.out.println("\n\n\t\t~ ~ ~ SEJA BEM-VINDO AO CRAPDNDMANAGER ~ ~ ~ \n");
    }

    public void execSys() {
        while(exeSys){
            if(!this.successLogin){
                this.successLogin = this.login();
                this.currentUser = this.acctrl.getCurrentUser();
            } else {
                int choice = 0;

                this.showStarterMenu();
                try {
                    choice = Integer.parseInt(console.readLine("\nEscolha: "));
                    this.checkChoice(choice);
                } catch (Exception e) {
                    System.out.println("A opcao deve ser informada pelo numero.");
                }
            }
        }
    }
    
    private Boolean login(){
        User currentUser = new User();

        currentUser.setNickname(this.console.readLine("\nNickname: "));
        currentUser.setPassword(new String(this.console.readPassword("Senha: ")));

        if(this.acctrl.CheckPassword(currentUser.getPassword(), currentUser.getNickname())){
            this.acctrl.setCurrentUser(currentUser);
            System.out.println("\nLogin realizado com sucesso!");
            return true;
        } else {
            System.out.println("Falha ao realizar o login! Usuario ou senha informados num saum validos");
            return false;
        }
    }

    private void showStarterMenu(){
        System.out.println("\nOlah " + this.currentUser.getNickname() + ", o que deseja fazer?");
        System.out.println("1) Minhas Campanhas");
        System.out.println("2) Meus Personagens");
        System.out.println("3) Minha Conta");
        System.out.println("4) Roll the Dice");
        System.out.println("5) Sou Pro! CMD MOD");
        System.out.println("6) Sair");
    }

    private void checkChoice(int choice){
        switch (choice) {
            case 1:
                System.out.println("Ainda n implementado");
                break;
            case 2:
                System.out.println("Ainda n implementado");
                break;
            case 3:
                this.showUserInfo();
                break;
            case 4:
                this.rollTheDice();
                break;
            case 5:
                this.cmdMode = true;
                System.out.println("O modo de console foi ativado!");
                break;
            case 6:
                this.exeSys = false;
                break;
            default:
                System.out.println("O valor informado estah incorreto! Por favor, informe um numero de 1 a 6");
                break;
        }

    }

    private void showUserInfo(){
        User u = this.acctrl.getCurrentUser();

        System.out.println("\n\n\t\t~ ~ ~ MINHA CONTA ~ ~ ~ \n");
        
        System.out.println("Nome: " + (u.getName().isEmpty()? "Naum informado" : u.getName()));
        System.out.println("Nickname: " + u.getNickname());
        System.out.println("Idade: " + (u.getAge()==0 ? "Naum informado" : u.getAge()));

        if(Integer.parseInt(this.console.readLine("\n1) Editar\t2) Voltar ao Menu\n\nEscolha: "))==1){
            int choice = Integer.parseInt(this.console.readLine("\n1) Nome\t2) Nickname\t3) Idade\n\nEscolha: "));
            switch (choice) {
                case 1:
                    u.setName(this.console.readLine("Digite o seu nome: "));
                    // TODO: Salvar alteração no arquivo/BD
                    System.out.println("\n\n\t\t~ ~ ~ Nome alterado com sucesso ~ ~ ~ \n");
                    break;
                case 2:
                    u.setNickname(this.console.readLine("Digite o seu apelido: "));
                    // TODO: Salvar alteração no arquivo/BD
                    System.out.println("\n\n\t\t~ ~ ~ Apelido alterado com sucesso ~ ~ ~ \n");
                    break;
                case 3:
                    u.setAge(Integer.parseInt(this.console.readLine("Digite a sua idade: ")));
                    // TODO: Salvar alteração no arquivo/BD
                    System.out.println("\n\n\t\t~ ~ ~ Idade alterada com sucesso ~ ~ ~ \n");
                    break;
            
                default:
                    break;
            }
        }
    }

    private void rollTheDice(){
        Boolean keepRolling = true;
        System.out.println("\n\n\t\t~ ~ ~ ROLL THE DICE ~ ~ ~ \n");
        do {// HACK: forçando erro pra sair do loop
            try {
                Dice d = new Dice(Integer.parseInt(this.console.readLine("Digite o dado a ser rodado (ex. d20, d10, d12) [digite somente 'q' p/ sair]: ").toLowerCase().replace("d", "")));
                System.out.println("\n\nResultado: " + (d.rollTheDice()));
            } catch (Exception e) {
                keepRolling = false;
            }
        } while (keepRolling);
    }
}
