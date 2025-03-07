package com.crudapp;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.crudapp.dao.UserRepo;
import com.crudapp.entities.User;

@SpringBootApplication
public class CrudappApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CrudappApplication.class, args);
		UserRepo userRepo = context.getBean(UserRepo.class);

		boolean bo = true;
		while (bo) {
			System.out.println("Choose What you wanna do: " + "\n 1 for create" + "\n 2 for retrive" + "\n 3 for update"
					+ "\n 4 for delete");
			Scanner sc = new Scanner(System.in);
			int a = sc.nextInt();
			switch (a) {
			case 1:
				User user = new User();
				System.out.println("set name:");
				sc.nextLine();
				user.setName(sc.nextLine());
				System.out.println("set city:");
				user.setCity(sc.nextLine());
				System.out.println("set status:");
				user.setStatus(sc.nextLine());
				System.out.println("saving in db ................done");

				userRepo.save(user);
				break;
			case 2:
				System.out.println("1 for Show All data"
						+ "\n2 for find by ID"
						+ "\n3 for find by Name");
				int choice = sc.nextInt();
				switch(choice) {
				case 1:
					List<User> list = userRepo.findAll();
					System.out.println("id    name    city    status");
					list.forEach(e->System.out.println(e.toString()));
					break;
				case 2:
					System.out.println("Enter Id");
					int id = sc.nextInt();
					System.out.println(userRepo.findById(id));
					break;
				case 3:
					System.out.println("Enter your Name");
					sc.nextLine();
					String s = sc.nextLine();
					List<User> users = userRepo.findByName(s);
					users.forEach(e->System.out.println(e));
					default:
					System.out.println("Invalid operation");
				}
				break;
			case 3:
				System.out.println("Enter ID to update");
				int id = sc.nextInt();
				Optional<User> optional = userRepo.findById(id);
				User user1 = optional.get();
				System.out.println("set name:");
				sc.nextLine();
				user1.setName(sc.nextLine());
				System.out.println("set city:");
				user1.setCity(sc.nextLine());
				System.out.println("set status:");
				user1.setStatus(sc.nextLine());
				userRepo.save(user1);
				
				break;
			case 4:
				System.out.println("1 for delete all"
						+ "\n2for delete By id");
				int c = sc.nextInt();
				switch(c) {
				case 1:
					userRepo.deleteAll();
					System.out.println("everything is deleted"
							+ "\n are you happy now"
							+ "\n ab acchi neend ayegi?"
							+ "\n ki abhi bhi mnn nhi bhaar");
					break;
				case 2:
					int id2 = sc.nextInt();
					userRepo.deleteById(id2);
					System.out.println("Id deleted");
					break;
				default:
					System.out.println("Invalid operation");
				}
				break;
			default:
				System.out.println("invalid operation");
			}
			System.out.println("++++++++++++++++++++++++++");
			System.out.println("press 1 for retry other for exit");
			int temp = sc.nextInt();
			if (temp != 1)
				bo = false;
		}
		System.out.println("EXITING.....................................");
	}

}
