package Program;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Entities.Company;
import Entities.Individual;
import Entities.TaxPayer;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<TaxPayer> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for(int i = 1; i<=n; i++) {
			System.out.println("Tax payer #" + i + "data: ");
			System.out.print("Individual or Company (i/c)?");
			char type = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Anual Income: ");
			Double income
			= sc.nextDouble();
			if(type == 'i') {
				System.out.print("Health expenditures: ");
				Double healthExpenditures = sc.nextDouble();
				list.add(new Individual(name,income,healthExpenditures));
			}else {
				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				list.add(new Company(name,income,numberOfEmployees));
			}
			
		}
		Double sum = 0.0;
		System.out.println();
		System.out.println("Tax Payd");
		for(TaxPayer pay : list) {
			Double tax = pay.tax();
			System.out.println(pay.getName() + ": " + pay.tax());
			sum += tax;
		}
		
		System.out.println();
		System.out.println("Total Tax: " + String.format("%.2f",sum ));

	}

}
