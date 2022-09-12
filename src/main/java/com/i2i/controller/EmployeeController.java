package com.i2i.controller;

import com.i2i.exception.NullListException;
import com.i2i.model.Trainer;
import com.i2i.model.Trainee;
import com.i2i.service.EmployeeService;
import com.i2i.service.impl.EmployeeServiceImpl; 
import com.i2i.util.CommonUtil;

import java.lang.NullPointerException;
import java.lang.StringBuilder;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <h> EmployeeController </h> 
 *  class used to get employee details from user and  
 *  returns details as object to EmployeeServiceImpl vice versa
 * 
 * @version 1.0
 * @author Jaganathan R  
 */
public class EmployeeController {
    
    private static String inValidData = (" ##********* //INVALID DATA// ************## ");
    private static String noData = (" ##********* // NO DATA // ************## ");
    private static String line = ("******************************************************");
    private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    private static EmployeeService employeeService = new EmployeeServiceImpl();

    /**
     * Method used to show menu to get and set employer Details from user to serviceImpl vice vresa 
     * @param {@link Scanner}scanner object
     * @return {@link Trainer}trainer
     */
    public static void showMenu() throws Exception {
    
        try { 

            Scanner scanner = new Scanner(System.in);
            logger.info("  *******************************************************  ");
            logger.info("          *****////  Welcome to Ideas2it /////  ******      ");
            logger.info("  ---------------------^^^^^^^^^^^-----------------------   ");
            boolean flag = true;

        while (flag) {
            StringBuilder stringBuilder = new StringBuilder();
	    System.out.println("***********************************");
            stringBuilder.append(" \n\n  1. Create the Employee Details \n") 
                         .append("  2. Update the Employee Details \n" ).append( "  3. Remove the Employee Details \n") 
                         .append("  4. Display the Employee Details \n" ).append( "  5. Display the All Details \n") 
                         .append( "  6. Assign trainers \n" ).append( "  7. Exit\n");
            logger.info("{}",stringBuilder);
            System.out.println("*****************************************");
            System.out.println(" ------------Choose Any one in Above List------------ ");
            int selectedList = scanner.nextInt();

            switch(selectedList) {
	        case 1 :
		    System.out.println("*****selected for creating Employee Details*********");
                    System.out.println("*****Getting Info from User****");
                    System.out.println("Choose Any One : \n 1. Trainer \n 2. Trainee");
                    int choosenValue = scanner.nextInt();

                    if (choosenValue == 1 ) { 
                        System.out.println("*********Selecting for Adding TrainerlisT*****");
                        scanner.nextLine();
                        logger.info(employeeService.addTrainerDetails(setTrainer(scanner))); 

                    } else if (choosenValue == 2) {
                        System.out.println("*********Selecting for Adding TrainerlisT*****");
                        scanner.nextLine();
                        logger.info(employeeService.addTraineeDetails(setTrainee(scanner)));
                    } else {
                        logger.error("{}",inValidData);
                    } 
                    break;
		case 2 :               
                    System.out.println(" *********selected for Upadating Employee Details********");
                    System.out.println("choose Any One \n 1. Trainer \n 2. Trainee");
                    int listedOne = scanner.nextInt();

                    if (listedOne == 1) {
                        System.out.println("******* Seleted To Update Trainer Details *********");
                        getAllTrainerDetails();
                        System.out.println("Enter The Trainer ID To Update : ");
                        int trainerId = scanner.nextInt();
                        Trainer trainer = updateTrainer(scanner, trainerId);
                        logger.info((trainer != null) ? (employeeService.modifyTrainerDetailsById(trainerId, trainer))
                                          : ("********** THERE IS NO RECORD *********"));

                    } else if (listedOne == 2) {
                        System.out.println("******* Seleted To Update Trainee Details *********");
                        getAllTraineeDetails();
                        System.out.println("Enter The Trainee ID To Update : ");
                        int traineeId = scanner.nextInt();
                        Trainee trainee = updateTrainee(scanner, traineeId);
                        logger.info((trainee != null) ? (employeeService.modifyTraineeDetailsById(traineeId, trainee))
                                          : ("********** THERE IS NO RECORD *********"));
                    
                    } else {
                        logger.error("{}",inValidData);
                    }
                    break;
		case 3 :
                    System.out.println("**********Selected for Deleting Employee Details************");
                    System.out.println("choose any one \n 1. Trainer \n 2. Trainee ");
                    int value = scanner.nextInt();

                    if (1 == value) {
                        getAllTrainerDetails();
                        System.out.println("Enter The Trainer ID to Remove ");
                        int id = scanner.nextInt();
                        logger.info(employeeService.deleteTrainerDetails(id));

                    } else if (2 == value) {
                        getAllTraineeDetails();
                        System.out.println("Enter The Trainee ID to Remove ");
                        int id = scanner.nextInt();
                        logger.info(employeeService.deleteTraineeDetails(id));                   

                    } else {
                        logger.error("{}",inValidData);
                    }
                    break;
		case 4 :
                    System.out.println("Select for Displaying the EmployeeList :\n1.trainee\n2.trainer");
                    int pickedValue = scanner.nextInt();

                    if (pickedValue == 1) {
                        System.out.println("******Displaying the TraineeList *******");
                        logger.info("Enter The Employee Id to Display :");
                        int id = scanner.nextInt(); 
                        Trainee trainee = employeeService.showTraineeDetailsById(id);
                        StringBuilder stringBuild = new StringBuilder();

                        if (trainee != null) {
                            logger.info("{}",stringBuild.append("\n Employee Name : " ).append( trainee.getName())
                                                     .append( "\n Employee ID : " ).append( trainee.getId())
                                                     .append( "\n MobileNumber : " ).append( trainee.getMobileNumber())
                                                     .append( " \nRole Of Employee : " ).append( trainee.getRole()));
                        } else {       
                            logger.error("{}",inValidData);
	       	        }    
                    } else if (pickedValue == 2) {
                        System.out.println("****** Displaying the trinerList******** ");
                        logger.info("Enter the EmployeeId to Display :");
                        int id = scanner.nextInt();
                        Trainer trainer = employeeService.showTrainerDetailsById(id);
                        StringBuilder trainers = new StringBuilder();
 
                        if ( trainer != null) {
                            logger.info("{}",trainers.append( "\n Employee Name : " ).append( trainer.getName())
                                                          .append(" \n EmployeeID : " ).append( trainer.getId())
                                                          .append( " \n MobileNumber : ") .append( trainer.getMobileNumber())
                                                          .append( " \n Role Of Employee : ").append( trainer.getRole()));
                        } else {
                
                            logger.error("{}",inValidData);
                        }
		    }
                    break;           

		case 5 :
                    System.out.println("***********Selected for Displaying Details of Employees**********");
                    logger.info("Select Any One \n  1. TrainerList \n  2. TraineeList ");
                    int choice = scanner.nextInt();

                    if (choice == 1) {
                        getAllTrainerDetails();

                    } else if (choice == 2) {
                        getAllTraineeDetails();

                    } else {
                        logger.error("{}",inValidData);    
                    }
                    break;
		case 6 :

                    System.out.println(" ********** Selecting for Trainers Assign details *******");
                    logger.info(" Select Any One \n 1. Trainees To Trainer \n 2. Trainers To Trainee \n 3. Retrive Details \n 4. Remove Ids ");
                    int selectedValue = scanner.nextInt();

                    if (selectedValue == 1) { 
                        getAllTrainerDetails();
                        System.out.println("Enter The Trainer Id"); 
                        int trainerId = scanner.nextInt();
                        Trainer trainer = employeeService.showTrainerDetailsById(trainerId);
                        trainer.setTraineeDetails(assignTrainees(scanner));
	                logger.info(employeeService.assignTrainees(trainerId, trainer)); 
               
                    } else if (selectedValue == 2) {
                        
                        getAllTraineeDetails();
                        System.out.println("Enter The Trainee Id");  
                        int traineeId = scanner.nextInt();
                        Trainee trainee = employeeService.showTraineeDetailsById(traineeId);
                        trainee.setTrainerDetails(assignTrainers(scanner));
                        logger.info(employeeService.assignTrainers(traineeId, trainee));

                    } else if (selectedValue == 3) {
                        System.out.println("Select For Retrive Details \n 1.Trainees by TrainerId \n 2. Trainers by TraineeId ");
                        int choosedValue = scanner.nextInt();
                        if (choosedValue == 1) {
                            getAllTrainerDetails();
                            System.out.println("Enter the Trainer ID :");
        	            int trainerId = scanner.nextInt();
                            Trainer trainer = employeeService.showTrainerDetailsById(trainerId);
                            StringBuilder trainers = new StringBuilder();
                            List<Trainee> listOfTrainees = trainer.getTraineeDetails();
                            System.out.println(listOfTrainees);
                            trainers.append(" \n  trainerId : " ).append( trainer.getId())
                                                          .append(" Name : " ).append( trainer.getName());
                           
                            listOfTrainees.forEach(list -> {System.out.println(listOfTrainees); trainers.append("TraineesName : " ).append( list.getName())
                                                                                                        .append("TraineesId : " ).append( list.getId());});
                            logger.info("{}", trainers); 
                       
                        } else if (choosedValue == 2) {
                            getAllTraineeDetails();
                            System.out.println("Enter the Trainee ID :");
		            int traineeId = scanner.nextInt();
                            Trainee trainee = employeeService.showTraineeDetailsById(traineeId);
                            List<Trainer> listedTrainee = trainee.getTrainerDetails();
                            StringBuilder trainees = new StringBuilder();
                            System.out.println(listedTrainee);
                            logger.info("{}",trainees.append("\n traineeId : " + trainee.getId())
                                                          .append( " Name : " + trainee.getName()));
                            listedTrainee.forEach(list -> {logger.info("{}",trainees.append("TraineesName : " ).append( list.getName())
                                                                                    .append("TraineesId : " ).append( list.getId())); });
                        }
               
                    } else if (selectedValue == 4) {
                        System.out.println("Selected to Remove ID from  \n 1. trainerIds \n 2. traineeIds");
                        int enteredValue = scanner.nextInt();
                        if (enteredValue == 1) {
                            System.out.println("Enter The Trainer Id :"); 
                            int trainersId = scanner.nextInt();
                            logger.info(employeeService.removeIdFromAssignedTrainee(trainersId));
                        } else if (enteredValue == 2) {
                            System.out.println("Enter The Trainee Id :"); 
                            int traineesId = scanner.nextInt();
                            logger.info(employeeService.removeIdFromAssignedTrainer(traineesId));
                        } else {
                            logger.error("{}",inValidData);
                        }
                    
                    } else {
                        logger.error("{}",noData);   
                    }        
		    break;
		case 7 :		
                    logger.info("You Selected For the Exiting The Form Response ");
                    logger.info("********************* THANK YOU **************************");
                    logger.info("--------------------- !^^^^^! ----------------------------------");
                    flag = false;
                    break;
            }
        }
        }
        catch(InputMismatchException e) {
            throw e;
        }
        catch(HibernateException e) {
            throw e;
        }
        catch(NullPointerException e) {
            throw e;
        }
        catch(Exception e) {
            throw e;
        }
    }

    /**
     * Method used to get trainer details 
     * @param {@link Scanner}scanner object
     * @return {@link Trainer}trainer
     */
    public static Trainer setTrainer(Scanner scanner) {
 
        Trainer trainer = new Trainer(); 
        System.out.println("Enter the Employee Name :");
        String name = scanner.nextLine();

        while (!CommonUtil.stringValidation( name)) {
            logger.error("{}",inValidData);
            System.out.println("Please Enter the Valid Name : ");
            name = scanner.nextLine();
        }
        trainer.setName(name);
        System.out.println("Enter The Employee Mobile Number : ");

        while (!scanner.hasNext("[6-9]{1}[0-9]{9}")) {
            logger.error("{}",inValidData);
            System.out.println("Please Enter Valid Number : ");
            scanner.next();
        }
	trainer.setMobileNumber(scanner.nextLong());  
	System.out.println(" Enter The mail of the Employee :");
        String mail = scanner.next();

        while (!CommonUtil.mailValidation( mail)) {
            logger.error("{}",inValidData);
            System.out.println("Please Enter the Valid Mail Id : ");
            mail = scanner.next();
        }
        trainer.setMail(mail.toLowerCase());
        boolean flag = false;
        while (!flag) {
            try { 
                System.out.println(" Enter The Date Of Birth in dd/mm/yyyy format ");
                System.out.println("Enter the day(1-31) in date of Birth :");
                int day = (scanner.nextInt());
                System.out.println("Enter the month(1-12) in date of Birth :");
                int month = (scanner.nextInt());
                System.out.println("Enter the year(yyyy) in date of Birth :");
                int year = (scanner.nextInt());
                System.out.println("Changing the date Format :");
                trainer.setDateOfBirth(LocalDate.of(year, month,day));
                flag = true;
            } catch(DateTimeException e) {
                System.out.println(e);
            } catch(Exception e) {
                System.out.println(e);
            }
        }
        System.out.println("Date Of Birth : " + trainer.getDateOfBirth());   
        flag = false;
        while (!flag) {

            try {
                System.out.println("Enter the Date Of Join of an Employee in format of dd/mm/yyyy : ");
                System.out.println("Enter the day in date of Join :");
                int day1 = (scanner.nextInt());
                System.out.println("Enter the month in date of Join :");
                int month1 = (scanner.nextInt());
                System.out.println("Enter the year in date of Join :");
                int year1 = (scanner.nextInt());
                System.out.println("Changing the date Format :");
                trainer.setDateOfJoin(LocalDate.of(year1, month1, day1));
                flag = true;
            } catch(DateTimeException e) {
                System.out.println(e);
            } catch(Exception e) {
                System.out.println(e);
            } 
        } 
        System.out.println("Date Of Join : "+trainer.getDateOfJoin());
        System.out.println(" Enter The Aadhar Card Number :");
        while (!scanner.hasNext("[0-9]{12}")) {
            logger.error("{}",inValidData);
            System.out.println("Enter The Valid Aaadhar Number :");
            scanner.next();
        }
        trainer.setAadharNumber(scanner.nextLong());
        System.out.println(" Enter the Pan Card number :");
        while (!scanner.hasNext("[a-zA-z0-9]{10}")) {
            logger.error("{}",inValidData);
            scanner.next();
        }
        trainer.setPanNumber(scanner.next().toUpperCase());
        scanner.nextLine();
        System.out.println(" Enter the Current Address : ");
        String address = scanner.nextLine();
        while (!CommonUtil.stringValidation(address)) {
            logger.error("{}",inValidData);
            System.out.println("Please Enter Valid Address");
            address = scanner.nextLine();
        }
        trainer.setAddress(address);
        System.out.println("Enter the Previous Company Name of an Employee : ");
        String previousCompanyName = scanner.nextLine();

        while (!CommonUtil.stringValidation(previousCompanyName)) {
            logger.error("{}",inValidData);
            System.out.println("Please Enter Valid Company Name");
            previousCompanyName = scanner.nextLine();
        }

        trainer.setPreviousCompanyName(previousCompanyName);
        System.out.println("Enter The Previous Company Experience ");
        int experience = scanner.nextInt();
        trainer.setExperience(experience);
        System.out.println("*************!_^_^_^!****************");
        return trainer;
    }

    /**
     * Method used to get trainee details 
     * @param {@link Scanner}scanner object
     * @return {@link Trainee}trainee
     */
    public static Trainee setTrainee(Scanner scanner) {

        Trainee trainee = new Trainee(); 
        System.out.println("Enter the Employee Name :");
        String name = scanner.nextLine();

        while (!CommonUtil.stringValidation( name)) {
            logger.error("{}",inValidData);
            System.out.println("Please Enter the Valid Name : ");
            name = scanner.nextLine();
        }
	
        trainee.setName(name);
        System.out.println("Enter The Employee Mobile Number : ");

        while (!scanner.hasNext("[6-9]{1}[0-9]{9}")) {
            logger.error("{}",inValidData);
            System.out.println("Please Enter the Valid Mobile Number : ");
            scanner.next();
        }

	trainee.setMobileNumber(scanner.nextLong());  
	System.out.println(" Enter The mail of the Employee :");
        String mail = scanner.next();

        while (!CommonUtil.mailValidation( mail)) {
            logger.error("{}",inValidData);
            System.out.println("Please Enter the Valid Mail ID : ");
            mail = scanner.next();
        }
        trainee.setMail(mail); 
        boolean flag = false;
        while (!flag) {

            try {

        System.out.println(" Enter The Date Of Birth in dd/mm/yyyy format ");
        System.out.println("Enter the day(1-31) in date of Birth :");
        int day = (scanner.nextInt());
        System.out.println("Enter the month(1-12) in date of Birth :");
        int month = (scanner.nextInt());
        System.out.println("Enter the year(yyyy) in date of Birth :");
        int year = (scanner.nextInt());
        System.out.println("Changing the date Format :");
        trainee.setDateOfBirth(LocalDate.of(year, month,day));
        flag = true;
        } catch(DateTimeException e) {
             System.out.println(e);
        } catch(Exception e) {
             System.out.println(e);
        } 
        } 
        System.out.println("Date Of Birth : " + trainee.getDateOfBirth()); 
        System.out.println(" Enter The Aadhar Card Number :");
        while (!scanner.hasNext("[0-9]{12}")) {
            logger.error("{}",inValidData);
            System.out.println("Please Enter the Valid Aadhar Number : ");
            scanner.next();
        }
        trainee.setAadharNumber(scanner.nextLong());
        System.out.println(" Enter the Pan Card number :");

        while (!scanner.hasNext("[a-zA-z0-9]{10}")) {
            logger.error("{}",inValidData);
            System.out.println("Please Enter the Valid Pan Number : ");
            scanner.next();
        }
        trainee.setPanNumber(scanner.next());
        scanner.next();
        System.out.println(" Enter the Current Address : ");
        String address = scanner.nextLine();
        while (!CommonUtil.stringValidation(address)) {
            logger.error("{}",inValidData);
            System.out.println("Please Enter Valid Address");
            address = scanner.nextLine();
        }
        trainee.setAddress(address);
        flag = false;
        while (!flag) {

            try {
                System.out.println("Enter the Date Of Join of an Employee in format of dd/mm/yyyy : ");
                System.out.println("Enter the day in date of Join :");
                int day1 = (scanner.nextInt());
                System.out.println("Enter the month in date of Join :");
                int month1 = (scanner.nextInt());
                System.out.println("Enter the year in date of Join :");
                int year1 = (scanner.nextInt());
                System.out.println("Changing the date Format :");
                trainee.setDateOfJoin(LocalDate.of(year1, month1, day1));
                flag = true;
            } catch(DateTimeException e) {
                System.out.println(e);
            } catch(Exception e) {
                System.out.println(e);
            } 
        } 
        System.out.println("Date Of Join : "+trainee.getDateOfJoin());
        flag = false;
        while (!flag) {

            try {
                System.out.println("Enter the Year Of Passout of an Employee : ");
                System.out.println("Enter the PassOut Year of an Employee in format of dd/mm/yyyy : ");
                System.out.println("Enter the day  :");
                int day2 = (scanner.nextInt());
                System.out.println("Enter the month :");
                int month2 = (scanner.nextInt());
                System.out.println("Enter the year :");
                int year2 = (scanner.nextInt());
                trainee.setPassOutYear(LocalDate.of(year2, month2, day2)); 
                flag = true;
            } catch(DateTimeException e) {
                System.out.println(e);
            } catch(Exception e) {
                System.out.println(e);
            } 
        }
        System.out.println("Changing the date Format :" + trainee.getPassOutYear()); 
        scanner.next();
        System.out.println("Enter the Role of an Employee : ");
        String role = scanner.nextLine();
        while (!CommonUtil.stringValidation(role)) {
            logger.error("{}",inValidData);
            System.out.println("Please Enter the Valid Role : ");
            role = scanner.nextLine();
        }
        trainee.setRole(role);
        System.out.println("*************!_^_^_^!****************");
        return trainee;
    }

    /**
     * Method used to print All details of the trainer 
     * @param{@noparam} 
     * @return {@link void} no returns
     */   
    public static void getAllTrainerDetails() throws Exception {

        try {
            List<Trainer> listOfTrainers = employeeService.showAllTrainerDetails();
             
            if (CommonUtil.validateTrainers(listOfTrainers)) {
                System.out.println(line);
                StringBuilder stringBuilder = new StringBuilder();
                listOfTrainers.forEach(list ->{ stringBuilder.append(" \n Employee Name : " ).append( list.getName())
                                                            .append(" \n EmployeeID : " ).append( list.getId())
                                                            .append(" \n MobileNumber : " ).append( list.getMobileNumber())
                                                            .append(" \n Role Of Employee : " ).append( list.getRole()).append("\n")
                                                            .append(line);});
                System.out.println(stringBuilder);         
            }
 
        } catch(NullListException e) {
        
            System.out.println(e.getMessage());
        } catch(HibernateException e) {
            throw e;
        } 
    } 
     
    /**
     * Method used to print All details of the trainee 
     * @noparam  
     * @return {@link void} no returns
     */ 
    public static void getAllTraineeDetails() throws Exception {
       
        List<Trainee> listOfTrainees = employeeService.showAllTraineeDetails();

        try {
      
            if (CommonUtil.validateTrainees(listOfTrainees)) {
                StringBuilder stringBuilder = new StringBuilder();
                System.out.println(line);  
                listOfTrainees.forEach(list -> { stringBuilder.append(" \n Employee Name : ").append( list.getName())
                                                            .append(" \n EmployeeID : ").append( list.getId())
                                                            .append( " \n MobileNumber : ").append( list.getMobileNumber())
                                                            .append( " \n Role Of Employee : ").append( list.getRole())
                                                            .append("\n").append(line);}); 
                System.out.println(stringBuilder);  
            }

        } catch(NullListException e) {
             System.out.println(e.getMessage());
        }      
    } 

    /**
     * Method used to get update details of the trainer 
     * @param {@link Scanner} scanner object 
     * @return {@link Trainer} returns trainer object
     */ 
    public static Trainer updateTrainer(Scanner scanner, int id) throws Exception{

        Trainer trainer = null;
        try {
            trainer = employeeService.showTrainerDetailsById(id);
        } catch (HibernateException e) {
            logger.error("{}",e);
        }
        if (trainer != null) {
        logger.info("---------^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^-------");
        logger.info("IF THERE IS NO UPDATE  PRESS ENTER :");
        logger.info("---------^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^-------");
        scanner.nextLine();
        System.out.println("Enter the Updated Name : or Enter ");
        String name = scanner.nextLine();

        if (!name.isEmpty()) { 
            trainer.setName(name);

        } else {
            logger.error("{}",noData);
        } 

        logger.info("Enter The Updated Mobile Number or Enter");
        String mobileNumber = scanner.nextLine();

        if (!mobileNumber.isEmpty()) {
            long number = Long.valueOf(mobileNumber);
	    trainer.setMobileNumber(number);
        } else {
            logger.error("{}",noData);
        }

        logger.info(" Enter The updated mail or Enter "); 
        String mail = scanner.nextLine();

        if (!mail.isEmpty()) {
            trainer.setMail(mail);
        } else {
             logger.error("{}",noData);
        }
        logger.info(" Enter The Updated Aadhar Card Number or Enter");
        String cardNumber = scanner.nextLine();

        if (!cardNumber.isEmpty()) {
            long aadharNumber = Long.valueOf(cardNumber);
            trainer.setAadharNumber(aadharNumber);
        } else {
            logger.error("{}",noData);
        }

        logger.info(" Enter the Updated Pan Card number or Enter"); 
        String panNumber = scanner.nextLine();

        if (!panNumber.isEmpty()) { 
            trainer.setPanNumber(panNumber);

        } else {
             logger.error("{}",noData);
        }
        logger.info("Enter the Role of an Employee or Enter ");
        String role = scanner.nextLine();

        if (!role.isEmpty()) {
            trainer.setRole(role);
        } else {
             logger.error("{}",noData);

        }
       
        } else {
            System.out.println("***** THERE IS NO RECORD *****");

        }
        return trainer;
    }

    /**
     * Method used to get update details of the trainee 
     * @param {@link Scanner} scanner object
     * @return {@link Trainee} returns trainee object
     */
    public static Trainee updateTrainee(Scanner scanner, int id) throws Exception {

        Trainee trainee = null;
        try {
            trainee = employeeService.showTraineeDetailsById(id);
        } catch(HibernateException e) {
            logger.error("{}",e);
        }
        if (trainee != null) {

        logger.info("---------^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^-------");
        logger.info("IF THERE IS NO UPDATE PRESS ENTER :");
        logger.info("---------^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^-------");
        scanner.nextLine();
        System.out.println("Enter the Updated Name or Enter ");     
        String name = scanner.nextLine();

        if (!name.isEmpty()) {
             trainee.setName(name);
        } else {
             logger.error("{}",noData);
        }

        logger.info("Enter The Updated Mobile Number or Enter  ");
        String number = scanner.nextLine();

        if (!number.isEmpty()) {
            long mobileNumber = Long.valueOf(number);
	    trainee.setMobileNumber(mobileNumber);
        } else {
             
             logger.error("{}",noData);
        }
        logger.info(" Enter The Updated Aadhar Card Number or Enter ");
        String aadharNumber = scanner.nextLine();

        if (!aadharNumber.isEmpty()) {
            long cardNumber = Long.valueOf(aadharNumber);
            trainee.setAadharNumber(cardNumber);
        } else {
            logger.error("{}",noData);
        }
        logger.info(" Enter the Updated Pan Card number or Enter  ");
        String panNumber = scanner.nextLine();

        if (!panNumber.isEmpty()) { 

            trainee.setPanNumber(panNumber);
        } else {
            logger.error("{}",noData);
        }
        logger.info("Enter the Updated Role or Enter ");
        String role = scanner.nextLine();

        if (!role.isEmpty()) {
            trainee.setRole(role);
        } else {
            logger.error("{}",noData);

        }
        } else {
            System.out.println("***** THERE IS NO RECORD *****");
        } 

        return trainee;
    }

   /**
     * method is used to assign trainers to trainee 
     * @param {Scanner} scanner
     * @return {@link List<Trainer>}returns list of trainers
     */
    private static List<Trainer> assignTrainers(Scanner scanner) throws Exception {
        
        List<Trainer> list = new ArrayList<>();

        try {            
            getAllTrainerDetails();
            System.out.println("Enter The TrainerIds : ");
            int trainerId = scanner.nextInt();
            list.add(employeeService.showTrainerDetailsById(trainerId));   
            
        }
        catch(HibernateException e) {
            throw e;
        } 
        return list;  
    }
 
    /**
     * method is used to assign trainees to trainer 
     * @param{@link Scanner}scanner
     * @return {@link void}returns nothing
     */
    private static List<Trainee> assignTrainees(Scanner scanner) throws Exception {
        
        List<Trainee> list = new ArrayList<>();
        
        try {
	    getAllTraineeDetails();
            System.out.println("How many Trainees to Add :(1-9)");
            int count = scanner.nextInt();
                   
            for (int i = 1; i <= count; i++) {
                System.out.println("Enter The TraineeIds : ");
                int traineeId = scanner.nextInt();
                list.add(employeeService.showTraineeDetailsById(traineeId));   
            } 
        }
        catch (HibernateException e) {
           throw e;
        }
        return list;  
    }   
        
}