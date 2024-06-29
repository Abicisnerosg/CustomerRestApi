package edu.utvt.attendance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode;

import com.github.javafaker.Facker;

import edu.utvt.attendance.persistence.repositories.StudentRepository;


@SpringBootApplication
@EnableSpringDataWebSupport(pageSerializationMode = PageSerializationMode.VIA_DTO)
public class CustomerRestApiApplication implements CommandLineRunner{
	
	@Autowired
	private StudentRepository repository;
	
	
	
	public static void main(String[]args) {
		SpringApplication.run(CustomerRestApiApplication.class, args);
	}
	
	@Override 
	public void run(String...args)throws Exception {
		// TODO Auto-generated method stub
		
		
		int starElements = 0;
		int totalElements = 10000;
		Faker faker = new Faker();
		List<Student> students = new ArrayList<>();
		
		
		starElements = (int) this.respository.count();
		
		
		for (int i = startElements; i < totalElements; i++){
			
			Student student = null;
			
			student = new Student(faker.idNumber().ssnValid(), faker.name().firstName(), faker.name().lastName(),
					faker.name().username() + "@gmail.com", StudentType.FULL_TIME, new Date(ThreadLocalRandom.current().nextInt() * i), null);
			students.add(student);
		}
		this.repository.saveAll(students);
		
	}

}
