package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST department findById =====");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);

	
		System.out.println("\n===== TEST List department  =====");
		List<Department> list = departmentDao.findAll();
		for (Department d : list) {
			System.out.println(d);
		}
		
		
		System.out.println("\n===== TEST Update department  =====");
		System.out.println("Enter the Id for department Update");
		int updateId = sc.nextInt();
		Department dep2 = departmentDao.findById(updateId);
		sc.nextLine();
		System.out.println("Insert a new name of Department");
		String setNameDepartment = sc.nextLine();
		dep2.setName(setNameDepartment);
		departmentDao.update(dep2);
		System.out.println("Update completed!!");
		
		System.out.println("\n\t\t=== TEST department delete  =====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete Completed!!");

		System.out.println("===== Test Insert department =======");
		Department newDepartment = new Department(null, "D8");
		departmentDao.insert(newDepartment);

		sc.close();
	}

}
