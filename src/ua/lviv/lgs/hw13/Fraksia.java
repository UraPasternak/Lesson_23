package ua.lviv.lgs.hw13;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Stream;

public class Fraksia {
	private List<Deputy> frak = new ArrayList<Deputy>();

	public void addDeputy() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Введіть вагу депутата:");
		int weight = scan.nextInt();
		System.out.println("Введіть ріст депутата:");
		int growth = scan.nextInt();
		System.out.println("Введіть прізвище депутата:");
		String surname = scan.next();
		System.out.println("Введіть ім'я депутата:");
		String name = scan.next();
		System.out.println("Введіть вік депутата:");
		int ag = scan.nextInt();
		System.out.println("Депутат хабарник? (true/false):");
		boolean habarnyk = scan.nextBoolean();
		Deputy deputy = new Deputy(weight, growth, surname, name, ag, habarnyk);
		frak.add(deputy);
		System.out.println("Депутата внесено до фракції!!!");

	}

	public void addDeputy(Deputy a) {
		frak.add(a);
	}

	public void dellDeputy() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Для видалення депутата введіть індекс:");
		int i = scan.nextInt();
		frak.remove(i);
		System.out.println("Депутата видалено з фракції");

	}

	public void listDeputyHabarnyky() {
		System.out.println(frak.stream().filter((frak)->frak.isHabarnyk()==true).toString());
	}

	public void maxHabarDeputy() {
		System.out.println("Найбільший хабарник фракції: " + frak.stream().max(Comparator.comparing(Deputy::getSizeHabar)).orElseThrow(NoSuchElementException::new));
	}

	public void listDeputy() {
		System.out.println("Всі депутати фракції:");
		frak.stream().forEach(System.out::println);
	}

	public void dellAllDeputy() {
		frak.clear();
		System.out.println("Всі депутати вигнані з фракції");
	}

	@Override
	public String toString() {
		return "Fraksia [frak=" + frak + "]";
	}

}
