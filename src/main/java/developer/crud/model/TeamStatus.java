package developer.crud.model;

import java.util.HashMap;
import java.util.Map;

public enum TeamStatus {
    ACTIVE,
    DELETED;

    private static Map<Integer, TeamStatus> teamStatuses = new HashMap<>();
    private static String stringTeamStatuses = "";

    static {
        for(TeamStatus teamStatus: TeamStatus.values()) {
            teamStatuses.put(teamStatus.ordinal(), teamStatus);
            writeToStringTeamStatuses(teamStatus.ordinal(), teamStatus.name());
        }

    }

    private static void writeToStringTeamStatuses(int ordinal, String name) {
        stringTeamStatuses += ordinal + ": " + name + System.lineSeparator();
    }

    public static String toStringTeamStatuses() {
        return stringTeamStatuses;
    }

    public static TeamStatus getTeamStatusByIndex(Integer index) {
        return teamStatuses.get(index);
    }

    public static boolean isValidStatus(Integer index) {
        return teamStatuses.containsKey(index);
    }
}


