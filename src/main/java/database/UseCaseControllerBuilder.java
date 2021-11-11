package database;

import controllers.*;
import usecases.*;

public class UseCaseControllerBuilder implements IUseCaseControllerBuilder {
    @Override
    public void buildUseCaseController(UserList userList, DataSaver dataSaver) {
        LoginRegisterUseCases loginRegisterUseCases = new LoginRegisterUseCases(userList);
        UserAccountUseCases userAccountUseCases = new UserAccountUseCases(userList);
        TaskUseCases taskUseCases = new TaskUseCases(userList);
        TeamUseCases teamUseCases = new TeamUseCases(userList);
        ProjectUseCases projectUseCases = new ProjectUseCases(userList);
        QueryUseCases queryUseCases = new QueryUseCases(userList);
        DataMemoryUseCases dataMemoryUseCases = new DataMemoryUseCases(userList);
        dataMemoryUseCases.setDataSaver(dataSaver); // inject DataSaver into that use case

        LoginRegisterController.getInstance().setInputBoundary(loginRegisterUseCases);
        UserAccountController.getInstance().setInputBoundary(userAccountUseCases);
        TaskController.getInstance().setInputBoundary(taskUseCases);
        TeamController.getInstance().setInputBoundary(teamUseCases);
        ProjectController.getInstance().setInputBoundary(projectUseCases);
        QueryController.getInstance().setInputBoundary(queryUseCases);
        DataMemoryController.getInstance().setInputBoundary(dataMemoryUseCases);
    }
}
