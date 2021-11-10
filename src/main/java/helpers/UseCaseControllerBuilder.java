package helpers;

import usecasesControllers.*;

public class UseCaseControllerBuilder implements IUseCaseControllerBuilder {
    @Override
    public void build(UserList userList) {
        LoginRegisterUseCases loginRegisterUseCases = new LoginRegisterUseCases(userList);
        UserAccountUseCases userAccountUseCases = new UserAccountUseCases(userList);
        TaskUseCases taskUseCases = new TaskUseCases(userList);
        TeamUseCases teamUseCases = new TeamUseCases(userList);
        ProjectUseCases projectUseCases = new ProjectUseCases(userList);
        QueryUseCases queryUseCases = new QueryUseCases(userList);

        LoginRegisterController.getInstance().setInputBoundary(loginRegisterUseCases);
        UserAccountController.getInstance().setInputBoundary(userAccountUseCases);
        TaskController.getInstance().setInputBoundary(taskUseCases);
        TeamController.getInstance().setInputBoundary(teamUseCases);
        ProjectController.getInstance().setInputBoundary(projectUseCases);
        QueryController.getInstance().setInputBoundary(queryUseCases);
    }
}
