[when]There is a person younger than {minAge}=$person:Person(age < {minAge})
[when]For an active loan type=$loan:LoanType(active==true)
[when]A person is too old=$person:Person(age > $loan.maxAge)
[when]A person earns too little=$person:Person(income < $loan.minIncome)
[when]A person is of incompatible citizenship=$person:Person($loan.compatibleCitizenships not contains citizenship)
[when]There is a person that=$person:Person()
[when]- is at least {minAge} years old=age >= {minAge}
[when]- is not too old for the loan=age <= $loan.maxAge
[when]- earns more than or equal to the minimum income for the loan=income >= $loan.minIncome
[when]- has compatible citizenship with the loan=$loan.compatibleCitizenships contains citizenship

[then]Tell that person they qualify for the loan=System.out.println($person.getName() + ", you qualify for " + $loan.getName());
[then]Tell that person they do not qualify because of {reason}=System.out.println($person.getName() + ", you do NOT qualify for " + $loan.getName() + " because of the "+{reason});
[then]Tell that person {message}=System.out.println($person.getName() + ", " + {message});
[then]Exclude that person=retract($person);