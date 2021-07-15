package bo.custom.impl;


import bo.custom.CourseBo;
import dao.CourseDAO;
import dao.DaoFactory;
import dao.QueryDAO;
import dto.CourseDTO;
import entity.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseBOImpl implements CourseBo {
    private CourseDAO dao= DaoFactory.getInstance()
            .getDao(DaoFactory.DAOType.COURSE);
    private QueryDAO qDao= DaoFactory.getInstance()
            .getDao(DaoFactory.DAOType.QUERY);

    @Override
    public boolean saveCourse(CourseDTO dto) throws Exception {
        return dao.save(new Course(dto.getCode(),
                dto.getCourseName(),dto.getCourseType(),dto.getDuration()));
    }

    @Override
    public boolean updateCourse(CourseDTO dto) throws Exception {
        return dao.update(new Course(dto.getCode(),
                dto.getCourseName(),dto.getCourseType(),dto.getDuration()));
    }

    @Override
    public boolean deleteCourse(String code) throws Exception {
        return dao.delete(code);
    }

    @Override
    public CourseDTO getCourse(String code) throws Exception {
        Course c=dao.get(code);
        return new CourseDTO(c.getCode(),
                c.getCourseName(),c.getCourseType(),c.getDuration());
    }

    @Override
    public ArrayList<CourseDTO> getAllCourses() throws Exception {
        List<Course> cList=dao.getAll();
        ArrayList<CourseDTO> dtoList= new ArrayList();
        for (Course c : cList) {
            dtoList.add(new CourseDTO(c.getCode(),
                    c.getCourseName(),c.getCourseType(),c.getDuration()));
        }
        return dtoList;
    }
}
