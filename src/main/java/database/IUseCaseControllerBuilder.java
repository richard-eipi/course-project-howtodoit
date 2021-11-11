package database;

import usecases.UserList;

public interface IUseCaseControllerBuilder {
    void buildUseCaseController(UserList userList, DataSaver dataSaver);
}
