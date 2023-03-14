package managerserviceconsumer;

import managerservicepublisher.IQuizPublisher;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;


public class ManagerServiceConsumerActivator implements BundleActivator {
	
	ServiceReference serviceReference;

	@Override
	public void start(BundleContext context) throws Exception {
		
		System.out.println("Music teacher consumer started...\n");

		serviceReference = context.getServiceReference(IQuizPublisher.class.getName());
		IQuizPublisher quizPublisher =(IQuizPublisher)context.getService(serviceReference);
		
		int choice;
        boolean ex = true;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Dear Teacher,\nPlease enter your choice to continue:");
            System.out.println("1. Manage courses");
            System.out.println("2. View Quizes");
            System.out.println("3. Add Quizes");
            System.out.println("4. Update Quizes");
            System.out.println("5. Delete Quizes");
            System.out.println("6. Exit");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("modfiying");
                    break;

                case 2:
                    quizPublisher.displayProducts();
                    break;
                case 3:
                    quizPublisher.addNewProduct();
                    break;
                case 4:
                    quizPublisher.updateProduct();
                    break;
                case 5:
                    quizPublisher.removeProduct();
                    break;
                case 6: 
                	System.out.println("Exiting...\n");
                	ex = false;
                	break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (ex);
		
		
		
		

	}

	@Override
	public void stop(BundleContext context) throws Exception {
		
		System.out.println("Music teacher consumer stopped...\n");
		context.ungetService(serviceReference);
	}
}
