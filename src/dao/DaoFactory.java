package dao;

import dao.impl.CourseDAOImpl;
import dao.impl.QueryDaoImpl;
import dao.impl.StudentDAOImpl;


public class DaoFactory {

    //1st Step
    private static DaoFactory daoFactory;

    //2nd Step
    private DaoFactory() {
    }

    //3rd Step
    public static DaoFactory getInstance() {
        return (daoFactory == null) ?
                (daoFactory = new DaoFactory()) : (daoFactory);
    }

    //4th Step
    public enum DAOType {
        STUDENT, COURSE, REGISTRATION, QUERY
    }


    public <T> T getDao(DAOType type) {
        switch (type) {
            case STUDENT:
                return (T) new StudentDAOImpl();
            case COURSE:
                return (T) new CourseDAOImpl();

            case REGISTRATION:
                return null;
            case QUERY:
                return (T) new QueryDaoImpl();
            default:
                return null;
        }
    }

}
