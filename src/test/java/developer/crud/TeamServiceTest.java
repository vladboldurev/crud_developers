package developer.crud;

import developer.crud.model.TeamStatus;
import developer.crud.repository.TeamRepository;
import developer.crud.service.TeamService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class TeamServiceTest {

    @Test
    public void createTeam() throws Exception{
        TeamRepository teamRepositoryMock = mock(TeamRepository.class);
        TeamService teamService = new TeamService(teamRepositoryMock);
        when(teamRepositoryMock.create(any())).thenReturn(1);
        int result1 = teamService.create("Test1", TeamStatus.ACTIVE.ordinal());
        int result2 = teamService.create("Test2", TeamStatus.DELETED.ordinal());

        assertEquals(1, result1);
        assertEquals(1, result2);

        verify(teamRepositoryMock, times(2)).create(any());
    }

    @Test
    public void createTeamWithException() throws Exception{
        TeamRepository teamRepositoryMock = mock(TeamRepository.class);
        TeamService teamService = new TeamService(teamRepositoryMock);
        when(teamRepositoryMock.create(any())).thenThrow(new Exception("exception"));
        int result = teamService.create("Test", TeamStatus.ACTIVE.ordinal());
        assertEquals(result, 0);
    }

}
