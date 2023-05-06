package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program_Department {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("==== TEST 1: Department findById ====");
		Department department = departmentDao.findById(1);
		System.out.println(department);

		
		System.out.println("==== TEST 2: Department findAll ====");
		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}

		
		System.out.println("==== TEST 3: Department insert ====");
		Department newDepartment = new Department(null, "Logistics");
		departmentDao.insert(newDepartment);
		System.out.println("Department New Id = " + newDepartment.getId());

		
		System.out.println("==== TEST 4: Department Update ====");
		department = departmentDao.findById(1);
		department.setName("Gamers");
		departmentDao.update(department);
		System.out.println("Update Completed");
		
		
		System.out.println("==== TEST 5: Department deleteById ====");
		System.out.print("Insert Id for delete: ");
		int idDelete = sc.nextInt();
		departmentDao.deleteById(idDelete);
		System.out.println("Delete Completed");
		sc.close();


		
		
	}

}
