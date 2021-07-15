package bo;


import bo.custom.impl.CourseBOImpl;
import bo.custom.impl.StudentBoImpl;

public class BoFactory {
    //1st Step
    private static BoFactory boFactory;

    //2nd Step
    private BoFactory() {
    }

    //3rd Step
    public static BoFactory getInstance() {
        return (boFactory == null) ?
                (boFactory = new BoFactory()) : (boFactory);
    }

    //4th Step
    public enum BOType {
        STUDENT, COURSE, REGISTRATION
    }

    //5th Step
    public <T> T getBo(BOType type) {
        switch (type) {
            case STUDENT:
                return (T) new StudentBoImpl();
            case COURSE:
                return (T) new CourseBOImpl();
            case REGISTRATION:
                return null;

            default:
                return null;
        }
    }

}
