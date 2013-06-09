package loan.advisor.dto;

import java.util.Set;

import loan.advisor.constants.Country;

public class LoanType {
	private String name;
	private Integer maxAge;
	private Set<Country> compatibleCitizenships;
	private Double minIncome;
	private boolean active;

	public LoanType(String name, Integer maxAge,
			Set<Country> compatibleCitizenships, double minIncome,
			boolean isActive) {
		this.name = name;
		this.maxAge = maxAge;
		this.compatibleCitizenships = compatibleCitizenships;
		this.minIncome = minIncome;
		this.active = isActive;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean isActive) {
		this.active = isActive;
	}

}
