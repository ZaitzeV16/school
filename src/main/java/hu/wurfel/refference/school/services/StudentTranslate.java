package hu.wurfel.refference.school.services;


import hu.wurfel.refference.school.model.daos.Student;
import hu.wurfel.refference.school.model.dtos.StudentDto;
import org.springframework.stereotype.Service;

@Service
public class StudentTranslate {


//	public static StudentSearchDto translateToSSDTO(StudentRequestDto requestDto) {
//		return new StudentSearchDto(Long.parseLong(requestDto.getID()), requestDto.getName(), requestDto.getBirth(), Integer.parseInt(requestDto.getDiary()));
//	}

	public static Student translateToStudent(StudentDto requestDto) {
		return new Student(requestDto.getSId(), requestDto.getName(), requestDto.getBirthDate());
	}

	//public static Student translateToStudent(StudentDto requestDto) {
	//	return new Student(Long.parseLong(requestDto.getSId()), requestDto.getName(), requestDto.getBirth());
	//}

}