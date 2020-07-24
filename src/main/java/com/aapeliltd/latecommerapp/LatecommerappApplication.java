package com.aapeliltd.latecommerapp;

import com.aapeliltd.latecommerapp.v1.backend.model.Employee;
import com.aapeliltd.latecommerapp.v1.backend.model.Setting;
import com.aapeliltd.latecommerapp.v1.backend.service.EmployeeService;
import com.aapeliltd.latecommerapp.v1.backend.service.ResumptionService;
import com.aapeliltd.latecommerapp.v1.backend.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

@SpringBootApplication
public class LatecommerappApplication {

	@Autowired
	private SettingService settingService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private ResumptionService resumptionService;

	//This will run at the start of application
	@PostConstruct
	private void init() throws ParseException {

		//set default time
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));


		//set settings
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		java.util.Date thresholdDate = sdf.parse("08:00:00");
		Setting setting = new Setting(thresholdDate, 0.2);
		settingService.addSetting(setting);
		Employee employeeJames =
				new Employee("James Oladimeji", "james@gmail.com", "no 12 alao street");
		Employee employeehossana =
				new Employee("Hossana Gabe", "gabe@gmail.com", "no 12 maitama street, abuja");
		Employee employeeMax =
				new Employee("Max Oladimeji", "max@gmail.com", "road 5 abeokuta");
		Employee employeeuche =
				new Employee("Uche Okafor", "uche@gmail.com", "road 5 abaliki");
		Employee employeeIbrahim =
				new Employee("Ibrahim Musa", "ibrahim@gmail.com", "road 5 maiduguri");
		Employee employeekehinde =
				new Employee("Kehinde Shata", "kehinde@gmail.com", "road 5 lagos");
		Employee employeechinedu =
				new Employee("Chindedu Okorafor", "chindedy@gmail.com", "road 5 Aba");
		Employee employeeaajayi =
				new Employee("Friday Ajayi", "friday@gmail.com", "road 5 Aba");
		Employee employeeabanji =
				new Employee("Banji Owotaiyese", "banji@gmail.com", "road 5 Offa");
		Employee employekemi =
				new Employee("Kemi Adeoye", "kemi@gmail.com", "road 5 Ibadan");

		employeeService.saveEmployee(employeeJames);
		employeeService.saveEmployee(employeehossana);
		employeeService.saveEmployee(employeeMax);
		employeeService.saveEmployee(employeeuche);
		employeeService.saveEmployee(employeeIbrahim);
		employeeService.saveEmployee(employeekehinde);
		employeeService.saveEmployee(employeechinedu);
		employeeService.saveEmployee(employeeaajayi);
		employeeService.saveEmployee(employeeabanji);
		employeeService.saveEmployee(employekemi);






	}

	public static void main(String[] args) {
		SpringApplication.run(LatecommerappApplication.class, args);
	}

}
