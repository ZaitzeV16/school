package hu.wurfel.refference.school.student;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentCrudService {

    public final StudentRepository studentRepository;

    public StudentCrudService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student getByStudentId(long id) {
        return studentRepository.findById(id).get();
    }

    public List<Student> getByName(String name) {
        return studentRepository.findAllByName(name);
    }

    public List<Student> getByBirth(String date) {
        return studentRepository.findAllByBirthDate(date);
    }

    public Student getByNameAndBirth(String name, String birth) {
        return studentRepository.findByNameAndBirthDate(name, birth).get();
    }

    public Student save(@NotNull Student student) {
        studentRepository.save(student);
        return getByStudentId(student.getId());
    }

    public List<Student> save(long id, String name, String birth) {
        ArrayList<Student> saved = new ArrayList<>();
        saved.add(save(new Student(id, name, birth)));
        return saved;
    }

    public Student setID(@NotNull Student student, long id) {
        student.setId(id);
        return save(student);
    }

    public Student setName(@NotNull Student student, String name) {
        student.setName(name);
        return save(student);
    }

    public Student setBirthDate(@NotNull Student student, String date) {
        student.setBirthDate(date);
        return save(student);
    }

    public void delete(@NotNull Student student) {
        studentRepository.delete(student);
    }
}
