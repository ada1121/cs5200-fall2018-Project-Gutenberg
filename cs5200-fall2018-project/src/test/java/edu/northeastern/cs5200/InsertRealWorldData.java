package edu.northeastern.cs5200;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.northeastern.cs5200.models.*;
import edu.northeastern.cs5200.repositories.ActorRepository;
import edu.northeastern.cs5200.repositories.AdminRepository;
import edu.northeastern.cs5200.repositories.CommentRepository;
import edu.northeastern.cs5200.repositories.CustomerRepository;
import edu.northeastern.cs5200.repositories.LocationRepository;
import edu.northeastern.cs5200.repositories.ManagerRepository;
import edu.northeastern.cs5200.repositories.PerformanceRepository;
import edu.northeastern.cs5200.repositories.ShowRepository;
import edu.northeastern.cs5200.repositories.StaffRepository;
import edu.northeastern.cs5200.repositories.TicketRepository;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class InsertRealWorldData {
	
	@Autowired
	TheatreDao td;
	
	@Autowired
	ActorRepository actorR;
	@Autowired
	AdminRepository adminR;
	@Autowired
	CustomerRepository cusR;
	@Autowired
	ManagerRepository mgR;
	@Autowired
	StaffRepository staffR;
	@Autowired
	CommentRepository commentR;
	@Autowired
	LocationRepository locaR;
	@Autowired
	PerformanceRepository performanceR;
	@Autowired
	ShowRepository showR;
	@Autowired
	TicketRepository ticketR;
	
	private static boolean in = false;
	
	@Before
	public void AA_testDelete() {
		if (!in) {
			td.truncateDatabase();
			in = true;
		}
	}
	
	
	@Test
	public void A_createUsers() {
		Manager bob = new Manager("bob","bob","Bob","Smith");
		Manager ada = new Manager("ada","ada","Ada","Lovelace");
		Customer c = new Customer("ca","ca","Ca","C");

		td.createCustomer(c);
		td.createManager(bob);
		td.createManager(ada);
	}

	

}
