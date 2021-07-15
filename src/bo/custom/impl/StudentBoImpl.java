package bo.custom.impl;


import bo.custom.StudentBO;
import dao.DaoFactory;
import dao.QueryDAO;
import dao.StudentDAO;
import dto.StudentDTO;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentBoImpl implements StudentBO {
    private StudentDAO dao= DaoFactory.getInstance()
            .getDao(DaoFactory.DAOType.STUDENT);
    private QueryDAO qDao= DaoFactory.getInstance()
            .getDao(DaoFactory.DAOType.QUERY);


    @Override
    public boolean saveStudent(StudentDTO dto) throws Exception {
        return dao.save(new Student(dto.getId(),
                dto.getName(),dto.getAddress(),dto.getContact(),dto.getDob(),dto.getGendeer()));
    }

    @Override
    public boolean updateStudent(StudentDTO dto) throws Exception {
        return dao.update(new Student(dto.getId(),
                dto.getName(),dto.getAddress(),dto.getContact(),dto.getDob(),dto.getGendeer()));
    }

    @Override
    public boolean deleteStudent(String id) throws Exception {
        return dao.delete(id);
    }

    @Override
    public StudentDTO getStudent(String id) throws Exception {
        Student s=dao.get(id);
        return new StudentDTO(s.getId(),
                s.getName(),s.getAddress(),s.getContact(),s.getDob(),s.getGendeer());
    }

    @Override
    public ArrayList<StudentDTO> getAllStudents() throws Exception {
        ArrayList<Student> cList= (ArrayList<Student>) dao.getAll();
        ArrayList<StudentDTO> dtoList= new ArrayList();
        for (Student s : cList) {
            dtoList.add(new StudentDTO(s.getId(), s.getName(),s.getAddress(),s.getContact(),s.getDob(),s.getGendeer()));
        }
        return dtoList;
    }

    @Override
    public String getId() throws Exception {
        return qDao.getId();
    }
}
