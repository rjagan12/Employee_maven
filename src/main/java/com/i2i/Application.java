package com.i2i;

import com.i2i.controller.EmployeeController;

import java.lang.NullPointerException;
import java.util.InputMismatchException;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <h> Application </h> 
 * <p>
 *  Class used to run and view mainMenu  
 *  toget and set details 
 * </p>
 *
 * @version 1.0
 * @author Jaganathan R  
 */
public class Application {
     
    private static Logger logger = LoggerFactory.getLogger(Application.class);
    private static EmployeeController employeeController = new EmployeeController();

    /**
     * Method used to access details of the employee 
     * @param {@link String, args}  
     * @return {@link void} noreturns
     */ 
    public static void main (String[] args) throws Exception {

        try {
            employeeController.showMenu();

        } catch(InputMismatchException e) {
            logger.error("{}",e);
            employeeController.showMenu(); 

        } catch(HibernateException e) {
            logger.error("{}",e);

        } catch(NullPointerException e) {
            logger.error("{}",e);

        } catch(Exception e) {
            logger.error("{}",e);
        }
    }
}