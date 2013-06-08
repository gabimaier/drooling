package loan.advisor.dto;

import loan.advisor.constants.Country;

public class Person {
	private String name;
	private Integer age;
	private Country citizenship;
	private Double income;

	public Person(String name, int age, Country citizenship, double income) {
		this.name = name;
		this.age = age;
		this.citizenship = citizenship;
		this.income = income;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Country getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(Country citizenship) {
		this.citizenship = citizenship;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	@Override
	public int hashCode() {
		if (name == null) {
			return 0;
		}
		return name.hashCode();
	}

	@Override
	public String toString() {
		return String.format("%S, aged %d, citizen of %s, yearly income of %,.2f €",
				name, age, citizenship, income);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person == false || obj == null) {
			return false;
		}
		return toString().equals(obj.toString());
	}
}
