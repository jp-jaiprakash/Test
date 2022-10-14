package interviewproblems.patterns.singletons;

public class LazySingleton {

    private LazySingleton(){

    }

    private static  LazySingleton instance;

    // static factory method
    public static LazySingleton getInstance(){
        if(instance== null)
            return instance = new LazySingleton();

        return instance;

    }
}
