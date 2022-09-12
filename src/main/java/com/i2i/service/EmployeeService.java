package com.i2i.service;

import java.util.List;

import com.i2i.model.Employee;
import com.i2i.dao.EmployeeDao;
import com.i2i.dao.impl.EmployeeDaoImpl;
import com.i2i.model.Trainer;
import com.i2i.model.Trainee;

/**
 * <h> EmployeeServiceImpl </h> 
 *  class used to get employee details from EmployeeDaoImpl and  
 *  returns details as object to EmployeeController vice versa
 * 
 * @version 1.0
 * @author Jaganathan R  
 */
public interface EmployeeService {

    /**
     * Method used to add All trainees Details 
     * @param {@link Trainee}  
     * @return {@link String }return status
     */
    public String addTraineeDetails(Trainee trainee) throws Exception;

     /**
     * Method used to show All trainees Details 
     * @param {@link noparam}  
     * @return {@link List<Trainee> }return traineeDetails
     */
    public List<Trainee> showAllTraineeDetails() throws Exception;


    /**
     * Method used to remove trainees deatils 
     * @param {@link String }traineeid 
     * @return {@link String }return status
     */
    public String deleteTraineeDetails(int id) throws Exception;
 
    /**
     * Method used to show trainee Details by id 
     * @param {@link String}traineeid  
     * @return {@link Trainee }return traineeDetails
     */
    public Trainee showTraineeDetailsById(int traineeId) throws Exception;

    /**
     * Method used to update trainee Details by id 
     * @param {@link String, Trainee}traineeid, traineeDetails 
     * @return {@link String}return status
     */
    public String modifyTraineeDetailsById(int traineeId, Trainee traineeDetails) throws Exception;

    /**
     * Method used to add All trainers Details 
     * @param {@link Trainer}  
     * @return {@link String }return status
     */
    public String addTrainerDetails(Trainer trainer) throws Exception;
 
    /**
     * Method used to show All trainers Details 
     * @param {@link noparam} 
     * @return {@link List<Trainer> }return trainerDetails
     */
    public List<Trainer> showAllTrainerDetails() throws Exception;

    /**
     * Method used to remove trainers deatils 
     * @param {@link String }trainerid 
     * @return {@link String }return status
     */
    public String deleteTrainerDetails(int id) throws Exception;

    /**
     * Method used to show trainerDetails by id 
     * @param {@link String}trainerid  
     * @return {@link Trainer }return trainerDetails
     */
    public Trainer showTrainerDetailsById(int trainerId) throws Exception;

    /**
     * Method used to modify trainer details by id
     * @param {@link String, Trainer}trainerid and trainer 
     * @return {@link String}
     */
    public String modifyTrainerDetailsById(int id, Trainer trainerDetails) throws Exception;

    /**
     * Method used to assign trainers to trainee 
     * @param {@link String, Trainer}traineeid and  trainer 
     * @return {@link }
     */
    public String assignTrainers(int traineeId, Trainee trainee) throws Exception;

    /**
     * Method used to assign trainees to trainer 
     * @param {@link String, Trainee}traineeid and trainee 
     * @return {@link }
     */
    public String assignTrainees(int trainerId, Trainer trainer) throws Exception;


    /**
     * Method used to remove trainers from trainee 
     * @param {@link String }trainerid 
     * @return {@link String }return status
     */
    public String removeIdFromAssignedTrainee(int trainersId) throws Exception;

    /**
     * Method used to remove trainee from trainer 
     * @param {@link String}traineeid 
     * @return {@link String }return status
     */   
    public String removeIdFromAssignedTrainer(int traineesId) throws Exception;
}