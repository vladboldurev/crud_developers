package developer.crud;

import developer.crud.dbmanager.DBManager;

public class CrudApp {
    public static void main(String[] args) {
        CrudConsole console = new CrudConsole();
        console.run();
        System.out.println("exit");
    }
}
