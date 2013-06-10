package loan.advisor;

import java.util.HashSet;
import java.util.Set;

import loan.advisor.constants.Country;
import loan.advisor.dto.LoanType;
import loan.advisor.dto.Person;
import loan.advisor.services.FeedbackService;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final FeedbackService fs = new FeedbackService();
		
		try {
			// load up the knowledge base
			KnowledgeBase kbase = 
					readDrlKnowledgeBase();
					//readDslKnowledgeBase();
			StatefulKnowledgeSession ksession = kbase
					.newStatefulKnowledgeSession();
			KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory
					.newFileLogger(ksession, "loanAdvisor");
			// go !
			ksession.setGlobal("feedbackService", fs);
			populateSession(ksession);
			ksession.fireAllRules();
			
			logger.close();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		System.out.println(fs.getFeedback());
	}

	private static KnowledgeBase readDrlKnowledgeBase() throws Exception {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory
				.newKnowledgeBuilder();
		kbuilder.add(ResourceFactory.newClassPathResource("LoanAdvisor.drl"),
				ResourceType.DRL);
		KnowledgeBuilderErrors errors = kbuilder.getErrors();
		if (errors.size() > 0) {
			for (KnowledgeBuilderError error : errors) {
				System.err.println(error);
			}
			throw new IllegalArgumentException("Could not parse knowledge.");
		}
		KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
		kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
		return kbase;
	}
	
	private static KnowledgeBase readDslKnowledgeBase() throws Exception {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory
				.newKnowledgeBuilder();
		kbuilder.add(ResourceFactory.newClassPathResource("dictionary.dsl"),
				ResourceType.DSL);
		kbuilder.add(ResourceFactory.newClassPathResource("LoanAdvisor.dslr"),
				ResourceType.DSLR);
		KnowledgeBuilderErrors errors = kbuilder.getErrors();
		if (errors.size() > 0) {
			for (KnowledgeBuilderError error : errors) {
				System.err.println(error);
			}
			throw new IllegalArgumentException("Could not parse knowledge.");
		}
		KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
		kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
		return kbase;
	}

	private static void populateSession(StatefulKnowledgeSession ksession) {
		ksession.insert(new Person("Jhon Adams", 21, Country.UK, 24000));
		ksession.insert(new Person("Jane Miller", 35, Country.UK, 95000));
		ksession.insert(new Person("Mihai Ionescu", 33, Country.Romania, 80000));
		ksession.insert(new Person("Mike Morrison", 71, Country.UK, 190000));
		ksession.insert(new Person("Jean Alessi", 25, Country.France, 86000));
		ksession.insert(new Person("Tom Hopper", 17, Country.UK, 0));

		final Set<Country> compatibleCitizenships = new HashSet<>();
		compatibleCitizenships.add(Country.UK);
		compatibleCitizenships.add(Country.France);

		ksession.insert(new LoanType("The Standard Credit", 65, compatibleCitizenships,
				90000, true));
		ksession.insert(new LoanType("The Platinum Credit", 80, compatibleCitizenships,
				190000, true));
		ksession.insert(new LoanType("The Student Loan", 23, compatibleCitizenships,
				25000, true));
		ksession.insert(new LoanType("The Poor Student Loan", 20, compatibleCitizenships,
				12000, false));
	}
}
