package developer.crud.view;

import developer.crud.controller.TeamController;
import developer.crud.model.Team;
import developer.crud.model.TeamStatus;

import java.util.List;
import java.util.Scanner;

public class TeamView {

    private Scanner scanner;
    private TeamController controller;

    public TeamView(TeamController controller, Scanner scanner) {
        this.scanner = scanner;
        this.controller = controller;
    }

    public void create() {
        System.out.println("###################");
        System.out.println("Input name:");
        String name = scanner.next();
        showTeamStatuses();
        int statusIndex = scanner.nextInt();
        controller.create(name, statusIndex);
    }

    public void read() {
        System.out.println("###################");
        System.out.println("Read team");
        System.out.println("Input item id for read:");
        Long statusIndex = scanner.nextLong();
        Team team = controller.read(statusIndex);
        if(team != null) {
            System.out.println(team.toString());
        } else {
            System.out.println("item not exist");
        }

    }

    public void readAll(){
        System.out.println("###################");
        System.out.println("List of teams:");
        List<Team> teams  = controller.readAll();
        for(Team team: teams) {
            System.out.println(team.toString());
        }
    }

    public void update(){
        System.out.println("###################");
        System.out.println("Update team:");
        System.out.println("Input id:");
        Long id = scanner.nextLong();
        System.out.println("Input name:");
        String name = scanner.next();
        showTeamStatuses();
        int statusIndex = scanner.nextInt();
        controller.update(id, name, statusIndex);

    }

    public void delete(){
        System.out.println("###################");
        System.out.println("Delete team:");
        readAll();
        System.out.println("Input item id for delete:");
        Long statusIndex = scanner.nextLong();
        controller.delete(statusIndex);
    }

    private void showTeamStatuses() {
        System.out.println("Choose number of status:");
        System.out.println(TeamStatus.toStringTeamStatuses());
    }

    public void show(){
        showMenu();
        String operation = scanner.next();
        switch(operation) {
            case "1":
                create();
                break;
            case "2":
                update();
                break;
            case "3":
                read();
                break;
            case "4":
                readAll();
                break;
            case "5":
                delete();
                break;
            case "6":
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
