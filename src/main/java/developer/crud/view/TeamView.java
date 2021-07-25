package developer.crud.view;

import developer.crud.controller.TeamController;
import developer.crud.model.Team;

import java.util.List;
import java.util.Scanner;

public class TeamView {

    private Scanner scanner;
    private TeamController controller;

    public TeamView(TeamController controller, Scanner scanner) {
        this.scanner = scanner;
        this.controller = controller;
    }

    public void create(){
        System.out.println("###################");
        System.out.println("Input name:");
        String name = scanner.next();
        controller.create(name);
    }

    public void read(){}

    public void readAll(){
        System.out.println("###################");
        List<Team> teams  = controller.readAll();
    }

    public void update(){}

    public void delete(){}

    public void handle(){
        showMenu();
        String operation = scanner.next();
        switch(operation) {
            case "1":
                System.out.println("Create team");
                create();
                break;
            case "2":
                System.out.println("Update team");
                update();
                break;
            case "3":
                System.out.println("Read team");
                read();
                break;
            case "4":
                System.out.println("Read all teams");
                readAll();
                break;
            case "5":
                System.out.println("Delete team");
                delete();
                break;
            case "6":
                System.out.println("Exit to the main menu");
                break;
            default:
                System.out.println("Operation not valid");
                break;
        }

    }

    private void showMenu() {
        System.out.println("###################");
        System.out.println("Choose action:");
        System.out.println("1 create team");
        System.out.println("2 update team");
        System.out.println("3 read team");
        System.out.println("4 read all team");
        System.out.println("5 delete team");
        System.out.println("6 exit to the main menu");
        System.out.println("###################");
    }

}
