package developer.crud;

import developer.crud.controller.TeamController;
import developer.crud.repository.TeamRepository;
import developer.crud.repository.TeamRepositoryImpl;
import developer.crud.service.TeamService;
import developer.crud.view.TeamView;

import java.util.Scanner;

public class CrudConsole {

    public Scanner scanner;
    private Boolean consoleIsWorking = true;

    private TeamView teamView;

    public CrudConsole() {
        this.scanner = new Scanner(System.in);

        TeamRepository teamRepository = new TeamRepositoryImpl();
        TeamService teamService = new TeamService(teamRepository);
        TeamController teamController = new TeamController(teamService);
        teamView = new TeamView(teamController, scanner);

    }

    public void run() {
        while(consoleIsWorking) {
            showMenu();
            String operation = scanner.next();
            switch(operation) {
                case "1":
                    teamView.handle();
                    break;
                case "2":
                    System.out.println("2");
                    break;
                case "3":
                    System.out.println("3");
                    break;
                case "4":
                    System.out.println("4");
                    consoleIsWorking = false;
                    break;
                default:
                    System.out.println("operator not valid");
                    break;
            }
        }
        System.out.println("close");
        scanner.close();
    }

    private void showMenu() {
        System.out.println("###################");
        System.out.println("Choose entity:");
        System.out.println("1 for choose Team");
        System.out.println("2 for choose Developer");
        System.out.println("3 for choose Skill");
        System.out.println("4 for exit");
        System.out.println("###################");
    }
}



