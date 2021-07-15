package dao.impl;


import dao.CourseDAO;
import dao.CrudUtil;
import entity.Course;

import java.util.List;

public class CourseDAOImpl implements CourseDAO {

    @Override
    public boolean save(Course course) throws Exception {
        return CrudUtil.execute
                ("INSERT INTO Course VALUES(?,?,?,?)",
                        course.getCode(),course.getCourseName(),
                        course.getClass(),course.getDuration());
    }

    @Override
    public boolean update(Course course) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public Course get(String s) throws Exception {
        return null;
    }

    @Override
    public List<Course> getAll() throws Exception {
        return null;
    }
}
