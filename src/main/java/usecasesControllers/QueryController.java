package usecasesControllers;

public class QueryController {
    private static final QueryController instance = new QueryController();
    private QueryInputBoundary inputBoundary;

    public QueryController() {

    }

    public static QueryController getInstance(){
        return instance;
    }

    public void setInputBoundary(QueryInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }
}
