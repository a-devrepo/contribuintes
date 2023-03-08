package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		int payers = 0;
		List<TaxPayer> payersList = new ArrayList<>();

		System.out.printf("Quantos contribuintes você vai digitar? ");
		payers = sc.nextInt();

		for (int i = 0; i < payers; i++) {
			TaxPayer payer = new TaxPayer();

			System.out.printf("%nDigite os dados do %dº contribuinte:", i + 1);
			System.out.printf("%nRenda anual com salário: ");
			payer.setSalaryIncome(sc.nextDouble());

			System.out.printf("Renda anual com prestação de serviço: ");
			payer.setServiceIncome(sc.nextDouble());

			System.out.printf("Renda anual com ganho de capital: ");
			payer.setCapitalIncome(sc.nextDouble());

			System.out.printf("Gastos médicos: ");
			payer.setHealthSpending(sc.nextDouble());

			System.out.printf("Gastos educacionais: ");
			payer.setEducationSpending(sc.nextDouble());

			payersList.add(payer);
		}

		for (int i = 0; i < payersList.size(); i++) {
			TaxPayer payer = payersList.get(i);
			System.out.printf("%nResumo do %d contribuinte", i + 1);
			System.out.printf("%nImposto bruto total: %.2f ",payer.grossTax());
			System.out.printf("%nAbatimento: %.2f ",payer.taxRebate());
			System.out.printf("%nImposto devido: %.2f %n",payer.netTax());
		}

	}
}
