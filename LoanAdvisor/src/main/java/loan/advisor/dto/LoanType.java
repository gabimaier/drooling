package loan.advisor.dto;

import java.util.Set;

import loan.advisor.constants.Country;

public class LoanType {
	private String name;
	private Integer maxAge;
	private Set<Country> compatibleCitizenships;
	private Double minIncome;

	public LoanType(String name, Integer maxAge,
			Set<Country> compatibleCitizenships, double minIncome) {
		this.name = name;
		this.maxAge = maxAge;
		this.compatibleCitizenships = compatibleCitizenships;
		this.minIncome = minIncome;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(Integer maxAge) {
		this.maxAge = maxAge;
	}

	public Set<Country> getCompatibleCitizenships() {
		return compatibleCitizenships;
	}

	public void setCompatibleCitizenships(Set<Country> compatibleCitizenships) {
		this.compatibleCitizenships = compatibleCitizenships;
	}

	public Double getMinIncome() {
		return minIncome;
	}

	public void setMinIncome(Double minIncome) {
		this.minIncome = minIncome;
	}
}
