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

[then]Exclude that person=retract($person);
[then]Use {feedbackService} to tell that person {message}=feedbackService.addFeedback($person, {message});
[then]Use {feedbackService} to give this negative feedback {message}=feedbackService.addFeedback($person, String.format("You do NOT qualify for '%s': %s", $loan.getName(), {message}));
[then]Use {feedbackService} to give positive feedback=feedbackService.addFeedback($person, String.format("You qualify for '%s'! One of our agents will contact you shortly.", $loan.getName()));