package developer.crud;

import developer.crud.dbmanager.DBManager;

public class CrudApp {
    public static void main(String[] args) {
        DBManager.init();
        CrudConsole console = new CrudConsole();
        console.run();
        System.out.println("exit");
    }
}
