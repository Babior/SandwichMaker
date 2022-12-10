package org.byt;

/*
If you are not familiar with Singleton, run Main class.
 */
public class AssistantSingleton {
    private static String workingPoints;
    private static int salary= 0;
    private static AssistantSingleton instance = null;

    private AssistantSingleton(){}

    public static AssistantSingleton getInstance(String wp){
        if(instance == null){
            instance = new AssistantSingleton();
            workingPoints = wp;
            salary = calculateSalary();
        }

        return instance;
    }

    public static int calculateSalary(){
        return 0;
    }

    public String getWorkingPoints(){
        return workingPoints;
    }
}
