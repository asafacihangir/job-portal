package com.cihangir;

import com.cihangir.dao.UserRepository;
import com.cihangir.enums.UserType;
import com.cihangir.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private final UserRepository userRepository;



	public Application(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {


		User user = new User();
		user.setFirstname("Sefa");
		user.setLastname("Cihangir");
		user.setUserType(UserType.COMPANY_USER);
		user.setUsername("cihangir");
		user.setPassword("cihangir");
		user.setMail("cihangir@mail.com");
		user.setActivated(true);

		userRepository.save(user);
	}
}
