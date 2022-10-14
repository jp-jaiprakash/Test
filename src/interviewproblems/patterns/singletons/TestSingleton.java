package interviewproblems.patterns.singletons;

public class TestSingleton {
    public static void main(String[] args) {

        /**
         * Challenge with approach is that instance will be created irrespective
         * of it being called or not
         * Ok if obj is simple and does not hold any resource
         */
        EagerSingleton eagerSingleton1 = EagerSingleton.getInstance();
        System.out.println(eagerSingleton1.hashCode());

        EagerSingleton eagerSingleton2 = EagerSingleton.getInstance();
        System.out.println(eagerSingleton2.hashCode());


        System.out.println("==================================");

        LazySingleton lazySingleton1 = LazySingleton.getInstance();
        System.out.println(lazySingleton1.hashCode());

        LazySingleton lazySingleton2 = LazySingleton.getInstance();
        System.out.println(lazySingleton2.hashCode());
    }
}
