package projectclassnew_CONTROLLER;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Projectclassnew_DTO.Doctor;
import Projectclassnew_DTO.Hospital;
import Projectclassnew_DTO.MedicalRecords;
import Projectclassnew_DTO.Patient;
import projectclassnew_DAO.DoctorDao;
import projectclassnew_DAO.HospitalDao;
import projectclassnew_DAO.MedicalRecordsDao;
import projectclassnew_DAO.PatientDao;

public class InsertController 
{
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		
		while(flag)
				{
					System.out.println("1. Add Hospital");
					System.out.println("2. Add Doctor");
					System.out.println("3. Add Patient");
					System.out.println("4. Add Medical Records to existing patient");
					System.out.println("5. EXIT");
					
					System.out.println("Enter Your Choice");
					
					int choice = sc.nextInt();
					
					switch(choice)
					{
					case 1: 
						{
							System.out.println("Enter hospital name, address and phone#");
							String name = sc.next();
							String address =sc.next();
							Long phone =sc.nextLong();
							
							//Create Hospital
							Hospital h = new Hospital();
							
							h.setHospital_name(name);
							h.setAddress(address);
							h.setPhone(phone);
							
							// send hospital object to DAO class as operation is done in DAO class
							
							HospitalDao hdao = new HospitalDao();
							hdao.createHospital(h);
							System.out.println("Hospital added successfully");
							
							
						}break;
						
					case 2:
						{
							System.out.println("Enter the Hospital ID Doctor want to join");
							int id = sc.nextInt();
							
							HospitalDao hdao = new HospitalDao();
							Hospital h = hdao.getHospitalById(id);
							
							if(h != null)
							{
								System.out.println("Enter Doctor name, qualification, salary");
								String name = sc.next();
								String qualification= sc.next();
								double salary = sc.nextDouble();
								
								//Create Doctor
								Doctor d = new Doctor();
								
								d.setDoc_name(name);
								d.setQualification(qualification);
								d.setSalary(salary);
								
								// create list to store all the doctor details
								List<Doctor> doctors = new ArrayList<Doctor>();
								doctors.add(d);
								
								//set Doctors to Hospital as this is bi-directional
								h.setDoctors(doctors);
								
								//set Hospital to Doctor as this is bi-directional
								d.setHospital(h);
								
								//send doctor object to dao
								DoctorDao da = new DoctorDao();
								da.addDoctor(d);
								System.out.println("Doctor data is added");
	
								
							}
							else 
							{
								System.out.println("Hospital does not exist");
							}
								
						}break;
						
					case 3:
						{
							
							System.out.println("Enter the Hospital ID patient want to visit");
							int id = sc.nextInt();
							
							HospitalDao hdao = new HospitalDao();
							Hospital h = hdao.getHospitalById(id);
							
							if(h != null)
							{	
								System.out.println("Enter patient name, diagnosis and phone#");
								String name = sc.next();
								String diagnosis= sc.next();
								long phone = sc.nextLong();
								
								//Create patient
								Patient p = new Patient();
							
								p.setPat_name(name);
								p.setDiagnosis(diagnosis);
								p.setPhone(phone);
								
								
								// list to store all patients details
								List<Patient> patients = new ArrayList<Patient>();
								patients.add(p);
								
								// set patients list to hospital
								h.setPatients(patients);
								
								// set Hospital to patients
								p.setHospital(h);
								
								//send patients object/details to DAO
								PatientDao dao2 = new PatientDao();
								dao2.addPatient(p);
								System.out.println("Patient details added to the hospital");
								
								//get patients details to add medical records
								
								System.out.println("Enter the date of check for the patient :"+p.getPat_name());
								String date=sc.next();
								
								System.out.println("ENter the problem the patient is facing");
								String problem=sc.next();
								
								//create Medical Records
								
								MedicalRecords record = new MedicalRecords();
								record.setDate_of_checkup(date);
								record.setProblem(problem);
								
								//set patients to Medical Records
								record.setPatient(p);
								
								//set Medical Record to patient
								List<MedicalRecords> list = new ArrayList<MedicalRecords>();
								list.add(record);
								
								p.setRecords(list);
								
								//send medical records to DAO
								MedicalRecordsDao mdao = new MedicalRecordsDao();
								mdao.addMedicalRecords(record);
								
								System.out.println("Medical records added successfully");
										
							}
							else
							{
								System.out.println("Hospital does not Exist");
							}
								
							
						}break;
						
					case 4: 
						{
							System.out.println("Enter patient ID");
							int id = sc.nextInt();
							PatientDao pdao = new PatientDao();
							Patient p = pdao.getPatientById(id);
							
							if(p != null)
							{
								//get patients details to add medical records
								
								System.out.println("Enter the date of check for the patient :"+p.getPat_name());
								String date=sc.next();
								
								System.out.println("ENter the problem the patient is facing");
								String problem=sc.next();
								
								//create Medical Records
								
								MedicalRecords record = new MedicalRecords();
								record.setDate_of_checkup(date);
								record.setProblem(problem);
								
								//set patient to medical records 
								record.setPatient(p);
								
								// set Medical record  to patient
								List<MedicalRecords> list = new ArrayList<MedicalRecords>();
								list.add(record);
								
								p.setRecords(list);
								
								//send medical records to DAO
								MedicalRecordsDao mdao = new MedicalRecordsDao();
								mdao.addMedicalRecords(record);
								
								System.out.println("Medical records added to patient");
							
								
							}
							else
							{
								System.out.println("Patient does not Exist");
							}
							
						}break;
							
						
					case 5:
						{
							flag = false;
						}break;
					
					default : 	
						{
							System.out.println("Enter a valid option");
						}
					
					
					
					
					}
					
					
					
					
					
				}
		
		
		
		sc.close();
		
	}
	
	
}
