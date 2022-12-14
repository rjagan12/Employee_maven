package com.i2i.service.impl;

import java.util.List;

import com.i2i.dao.EmployeeDao;
import com.i2i.dao.impl.EmployeeDaoImpl;
import com.i2i.model.Employee;
import com.i2i.model.Trainer;
import com.i2i.model.Trainee;
import com.i2i.service.EmployeeService;

/**
 * <h> EmployeeServiceImpl </h> 
 * <p>
 *  Class used to get employee details from EmployeeDaoImpl and  
 *  returns details as object to EmployeeController vice versa
 *  which is implemented from EmployeeService
 *  </p>
 *
 * @version 1.0
 * @author Jaganathan R  
 */
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao = new EmployeeDaoImpl();

    /**
     * Method used to add All trainees Details 
     * @param {@link Trainee}  
     * @return {@link String }return status
     */
    @Override
    public String addTraineeDetails(Trainee trainee) throws Exception {

        return employeeDao.insertTraineeDetails(trainee);
    }

    /**
     * Method used to show All trainees Details 
     * @param {@link noparam}  
     * @return {@link List<Trainee> }return traineeDetails
     */
    @Override
    public List<Trainee> showAllTraineeDetails() throws Exception {

        return employeeDao.retrieveTraineesDetails();
    }

    /**
     * Method used to remove trainees deatils 
     * @param {@link int }traineeid 
     * @return {@link String }return status
     */
    @Override
    public String deleteTraineeDetails(int id) throws Exception {

        return employeeDao.removeTraineeDetails(id);
    }

    /**
     * Method used to show trainee Details by id 
     * @param {@link int}traineeid  
     * @return {@link Trainee }return traineeDetails
     */
    @Override
    public Trainee showTraineeDetailsById(int traineeId) throws Exception {

        return employeeDao.displayTraineeDetailsById(traineeId);
    }

    /**
     * Method used to update trainee Details by id 
     * @param {@link int, Trainee}traineeid, traineeDetails 
     * @return {@link String}return status
     */
    @Override
    public String modifyTraineeDetailsById(int traineeId, Trainee traineeDetails) throws Exception {

        return employeeDao.updateTraineeDetails(traineeId, traineeDetails);
    }

    /**
     * Method used to add All trainers Details 
     * @param {@link Trainer}  
     * @return {@link String }return status
     */
    @Override
    public String addTrainerDetails(Trainer trainer) throws Exception {

        return employeeDao.insertTrainerDetails(trainer);
    }

    /**
     * Method used to show All trainers Details 
     * @param {@link noparam} 
     * @return {@link List<Trainer> }return trainerDetails
     */
    @Override
    public List<Trainer> showAllTrainerDetails() throws Exception {

        return employeeDao.retrieveTrainersDetails();
    }

    /**
     * Method used to remove trainers deatils 
     * @param {@link int }trainerid 
     * @return {@link String }return status
     */
    @Override
    public String deleteTrainerDetails(int id) throws Exception {

        return employeeDao.removeTrainerDetails(id);
    }

    /**
     * Method used to show trainerDetails by id 
     * @param {@link int}trainerid  
     * @return {@link Trainer }return trainerDetails
     */
    @Override
    public Trainer showTrainerDetailsById(int trainerId) throws Exception {

        return employeeDao.displayTrainerDetailsById(trainerId);
    }

    /**
     * Method used to modify trainer details by id
     * @param {@link int, Trainer}trainerid and trainer 
     * @return {@link String}
     */
    @Override
    public String modifyTrainerDetailsById(int id, Trainer trainerDetails) throws Exception {

        return employeeDao.updateTrainerDetails(id, trainerDetails);
    }

    /**
     * Method used to assign trainers to trainee 
     * @param {@link int, Trainer}traineeid and  trainer 
     * @return {@link }
     */
    @Override
    public String assignTrainers(int traineeId, Trainee trainee) throws Exception {

        return employeeDao.updateTraineeDetails( traineeId, trainee);
    }   

    /**
     * Method used to assign trainees to trainer 
     * @param {@link int, Trainee}traineeid and trainee 
     * @return {@link }
     */
    @Override
    public String assignTrainees(int trainerId, Trainer trainer) throws Exception {
    
        return employeeDao.updateTrainerDetails( trainerId, trainer);
    }   

    /**
     * Method used to remove trainees from trainer 
     * @param {@link int, Trainer}trainerid trainerDetails
     * @return {@link String }return status
     */
    @Override
    public String removeIdFromAssignedTrainer(int trainersId, Trainer trainer) throws Exception {
        
	return employeeDao.updateTrainerDetails(trainersId, trainer); 
    }
 
    /**
     * Method used to remove trainer from trainee 
     * @param {@link int Trainee}traineeid traineeDetails
     * @return {@link String }return status
     */
    @Override   
    public String removeIdFromAssignedTrainee(int traineesId, Trainee trainee) throws Exception {

	return employeeDao.updateTraineeDetails(traineesId,trainee); 
    }                  
  
}