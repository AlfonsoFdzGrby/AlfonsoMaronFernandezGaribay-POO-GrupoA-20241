import java.time.LocalDate;
import java.util.*;

public class Zoo {

    // LISTS AND SCANNER

    private static Scanner scanner = new Scanner(System.in);
    private ArrayList<Empleado> employeeList = new ArrayList<>();
    private ArrayList<Visitante> visitorList = new ArrayList<>();
    private ArrayList<Visita> visitList = new ArrayList<>();
    private ArrayList<Animal> animalList = new ArrayList<>();
    private ArrayList<Mantenimiento> maintenanceList = new ArrayList<>();
    
    // OTHERS

    public static void returnToMainMenu(){
        System.out.print("Press enter to return to main menu...");
        scanner.nextLine();
    }
    
    public LocalDate askForDate(){
        int month, day, year;
        while(true){
            System.out.print("Month: ");
            month = scanner.nextInt();
            System.out.print("Day: ");
            day = scanner.nextInt();
            System.out.print("Year: ");
            year = scanner.nextInt();
            scanner.nextLine();
            if(month<1 || month>12 || day<1 || day>31){
                System.out.println("The specified date is not valid!");
                System.out.println("Please enter a valid date...");
            }else{
                break;
            }
        }
        
        LocalDate date = LocalDate.of(year, month, day);

        return date;
    }

    public boolean yesOrNo(char option) {
        boolean answer = false;
        switch (Character.toLowerCase(option)) {
            case 'y':
                answer = true;
                break;
        
            default:
                break;
        }
        return answer;
    }

    // SEARCHERS

    public Empleado searchEmployee(boolean modify) {
        System.out.println("Please enter the name of the employee: ");
        String name, lastName;
        Empleado employee = null;
        while(true){
            System.out.print("First Name: ");
            name = scanner.nextLine();
            System.out.print("Last Name: ");
            lastName = scanner.nextLine();
            for (int i = 0; i < employeeList.size(); i++) {
                if(name.equalsIgnoreCase(employeeList.get(i).getName()) && lastName.equalsIgnoreCase(employeeList.get(i).getLastName())){
                    employee = employeeList.get(i);
                    if(modify){
                        employeeList.remove(i);
                    }
                    System.out.println("Employee found!");
                    break;
                }
            }
            if(employee==null){
                System.out.println("The entered employee was not found. Please enter a valid employee...");
            }else{
                break;
            }
        }

        return employee;
    }
    
    public Animal searchAnimal(boolean modify){
        Animal animal = null;
        System.out.println("Please enter the animal's ID");
        while (true) {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < animalList.size(); i++) {
                if(animalList.get(i).getID()==id){
                    animal = animalList.get(i);
                    if(modify){
                        animalList.remove(i);
                    }
                    System.out.println("The animal " + animal.getKind() +" was found!");
                    break;
                }
            }
            if(animal==null){
                System.out.println("The animal was not found. Please enter a valid ID");
            }else{
                break;
            }
        }
        return animal;
    }

    public Visitante searchVisitor(boolean modify){
        System.out.println("Please enter the name of the visitor: ");
        String name, lastName;
        Visitante visitor = null;

        while(true){
            System.out.print("First Name: ");
            name = scanner.nextLine();
            System.out.print("Last Name: ");
            lastName = scanner.nextLine();
            for (int i = 0; i < visitorList.size(); i++) {
                if(name.equalsIgnoreCase(visitorList.get(i).getName()) && lastName.equalsIgnoreCase(visitorList.get(i).getLastName())){
                    visitor = visitorList.get(i);
                    if(modify){
                        visitorList.remove(i);
                    }
                    System.out.println("Visitor found!");
                    break;
                }
            }
            if(visitor==null){
                System.out.println("The entered visitor was not found. Please enter a valid visitor...");
            }else{
                break;
            }
        }
        return visitor;
    }

    public Visita searchVisit(boolean modify){
        Visita visit = null;
        System.out.println("Please enter the visit ID: ");
        while (true) {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < visitList.size(); i++) {
                if(id==visitList.get(i).getID()){
                    visit = visitList.get(i);
                    System.out.println("Visit found!");
                    if(modify){
                        visitList.remove(visit);
                    }
                    break;
                }
            }
            if(visit == null){
                System.out.println("The entered visit was not found. Please enter a valid visit ID...");
            }else{
                break;
            }
        }    
        
        return visit;
    }

    public Mantenimiento searchMaintenance(boolean modify){
        Mantenimiento maintenance = null;
        System.out.println("Please enter the maintenance record's ID: ");

        while (true) {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < maintenanceList.size(); i++) {
                if(id==maintenanceList.get(i).getID()){
                    maintenance = maintenanceList.get(i);
                    System.out.println("Maintenance record found!");
                    if(modify){
                        maintenanceList.remove(maintenance);
                    }
                    break;
                }
            }
            if(maintenance == null){
                System.out.println("The entered ID is not valid. Please enter a valid ID...");
            }else{
                break;
            }
        }
        return maintenance;
    }

    // REGISTRATION

    public void registerEmployee(){

        LocalDate birthDate;

        System.out.println("Please enter your personal data");
        System.out.print("First Name: ");
        String name=scanner.nextLine();
        System.out.print("Last name: ");
        String lastName=scanner.nextLine();

        while(true){
            System.out.println("Please enter your birth date (ONLY WITH NUMBERS)");
            birthDate = askForDate();
            if(birthDate.getYear()>2006){
                System.out.println("The employee must bee 18 years or older");
            }else{
                break;
            }
        }
        

        System.out.println("Please enter your registration date (ONLY WITH NUMBERS)");
        LocalDate entryDate = askForDate();

        System.out.println("Please enter your finantial and legal data:");
        System.out.print("RFC: ");
        long RFC = scanner.nextLong();
        scanner.nextLine();
        System.out.print("CURP: ");
        String CURP=scanner.nextLine();
        System.out.print("Salary: ");
        float salary=scanner.nextFloat();
        scanner.nextLine();

        System.out.println("Please enter your schedule: ");
        System.out.print("Enter your start time (e.g., 7:00 AM): ");
        String startTime = scanner.nextLine();
        System.out.print("Enter your end time (e.g., 2:00 PM): ");
        String endTime = scanner.nextLine();

        System.out.println("Please enter your role (Veterinarian, Guide, Maintenance, Administration): ");
        String role;

        while(true){
            System.out.print("Role: ");
            role = scanner.nextLine();
            if(role.equalsIgnoreCase("veterinarian") || role.equalsIgnoreCase("guide") || role.equalsIgnoreCase("administration") || role.equalsIgnoreCase("maintenance")){
                break;
            }else{
                System.out.println("The specified role is not valid. Please enter a valid role:");
            }
        }
        
        employeeList.add(new Empleado(name, lastName, birthDate, CURP, RFC, salary, startTime, endTime, entryDate, role));

        System.out.println("The employee has been successfully registered!");
        returnToMainMenu();
    }

    public void registerVisitor(){
        System.out.println("Please enter your personal data");
        System.out.print("First Name: ");
        String name=scanner.nextLine();
        System.out.print("Last name: ");
        String lastName=scanner.nextLine();

        System.out.println("Please enter your birth date (ONLY WITH NUMBERS)");
        LocalDate birthDate = askForDate();

        System.out.println("Please enter your legal data:");
        System.out.print("CURP: ");
        String CURP=scanner.nextLine();

        System.out.println("Please enter your registration date (ONLY WITH NUMBERS)");
        LocalDate registerDate = askForDate();

        visitorList.add(new Visitante(name, lastName, birthDate, CURP, registerDate));
        System.out.println("The visitor has been successfully registered!");
        returnToMainMenu();
    }

    public void registerVisit(){
        ArrayList<Visitante> visitorsInVisit = new ArrayList<>();

        System.out.println("Please enter the date of the visit: ");
        LocalDate visitDate = askForDate();

        System.out.println("Please enter the name of guide in charge: ");
        String guideFirstName, guideLastName;

        Empleado guide = null;

        while(true){
            System.out.print("First Name: ");
            guideFirstName = scanner.nextLine();
            System.out.print("Last Name: ");
            guideLastName = scanner.nextLine();
            for (int i = 0; i < employeeList.size(); i++) {
                if(guideFirstName.equalsIgnoreCase(employeeList.get(i).getName()) && guideLastName.equalsIgnoreCase(employeeList.get(i).getLastName())){
                    guide = employeeList.get(i);
                    if(guide.getRole().equalsIgnoreCase("guide")){
                        System.out.println("The employee was found and will now be guide");
                        break;
                    }else{
                        System.out.println("The employee was found but is not a guide!");
                        guide = null;
                    }
                }
            }
            if(guide==null){
                System.out.println("Please enter a valid guide...");
            }else{
                break;
            }
        }

        System.out.println("Please enter the visitors that will participate:");
        System.out.println("Type and enter 'exit' when every user has been registered");
        Visitante visitor = null;
        String visitorFirstName = "", visitorLastName = "";
        int visitNum = 1;

        while(!visitorFirstName.equalsIgnoreCase("exit")){
            System.out.println("Visitor #" + visitNum);
            boolean found = false;
            System.out.print("First Name: ");
            visitorFirstName = scanner.nextLine();
            if(visitorFirstName.equalsIgnoreCase("exit") || visitorLastName.equalsIgnoreCase("exit")){
                System.out.println("All the visitors have been registered!");
                break;
            }
            System.out.print("Last Name: ");
            visitorLastName = scanner.nextLine();
            for (int i = 0; i < visitorList.size(); i++) {
                if(visitorFirstName.equalsIgnoreCase(visitorList.get(i).getName()) && visitorLastName.equalsIgnoreCase(visitorList.get(i).getLastName())){
                    visitor = visitorList.get(i);
                    found = true;
                    if(visitorsInVisit.contains(visitor)){
                        System.out.println("The user is already registered. Please enter another user.");
                        break;
                    }
                    visitor.añadirVisita();
                    System.out.println("User found! User registered!");
                    visitorsInVisit.add(visitor);
                    visitNum++;
                    if(visitor.getVisitNum()%5==0){
                        System.out.println("This is " + visitor.getFullName() + "'s visit #" + visitor.getVisitNum());
                        System.out.println("The visitor gets a 25% disccount!");
                    }
                    break;
                }
            }
            if(!found){
                System.out.println("The user was not found. Please enter a valid user");
            }
        }

        Visita visit = new Visita(guide, visitorsInVisit, visitDate);
        visitList.add(visit);

        System.out.println("A visit has been successfully booked!");
        System.out.println("VISIT ID: " + visit.getID());
        returnToMainMenu();
    }

    public void registerAnimal(){
        ArrayList<String> diseaseList = new ArrayList<>();
        System.out.println("Please enter the kind of animal: ");
        System.out.print("Kind: ");
        String kind = scanner.nextLine();

        System.out.println("Please enter the animal's birth date: (ONLY WITH NUMBERS)");
        LocalDate birthDate = askForDate();

        System.out.println("Please enter the animal's arrival date: ");
        LocalDate arrivDate = askForDate();

        System.out.println("Please enter the animal's weight (in kg): ");
        System.out.print("Weight: ");
        float weight = scanner.nextFloat();
        scanner.nextLine();
        
        System.out.println("Please enter the animal's deseases (Type 'exit' when finished):");
        String disease = "";
        int diseaseNum = 0;

        while(true){
            System.out.print(String.format("Disease #%d: ", diseaseNum));
            disease = scanner.nextLine();
            if(diseaseList.contains(disease)){
                System.out.println("The disease is already registered. Please enter another disease");
            }else{
                if(disease.equalsIgnoreCase("exit")){
                    System.out.println("The diseases have been registered correctly!");
                    break;
                }else{
                    diseaseList.add(disease);
                    diseaseNum++;
                }
            }
        }

        System.out.println("Please enter the feeding frequency of the animal (# hours): ");
        System.out.print("Must be fed every: ");
        String feedingFreq = scanner.nextLine();
        System.out.println("Please enter the type of feeding the animal needs: ");
        System.out.print("Feeding Type: ");
        String feedingType = scanner.nextLine();

        System.out.println("Please enter if the animal is vaccinated (y/n)");
        boolean isVaccinated = false;
        char option = ' ';

        while(true){
            System.out.print(">> ");
            option = scanner.nextLine().charAt(0);
    
            switch (Character.toLowerCase(option)) {
                case 'y':
                    isVaccinated = true;
                    break;
                
                case 'n':
                    isVaccinated = false;
                    break;
            
                default:
                    System.out.println("Please enter a valid option (y/n)");
                    break;
            }
            
            if(Character.toLowerCase(option)=='y' || Character.toLowerCase(option)=='n'){
                break;
            }
        }

        Animal animal = new Animal(kind, birthDate, arrivDate, weight, diseaseList, feedingFreq, feedingType, isVaccinated);
        animalList.add(animal);

        System.out.println("The animal has been succesfully registered!");
        System.out.println("ANIMAL'S ID: " + animal.getID());
        returnToMainMenu();
    }

    public void registerMaintenance(){
        ArrayList<String> observationList = new ArrayList<>();

        Empleado employee;
        
        int obsNum = 0;

        while (true) {
            employee = searchEmployee(false);
            if(employee.getRole().equalsIgnoreCase("maintenance")){
                System.out.println("The employee was found and will now be in charge of maintenance");
                break;
            }else{
                System.out.println("The employee was found but is not from the maintenance staff!");
            }
        }

        Animal animal = searchAnimal(false);
        System.out.println("Please enter the date of the process (ONLY WITH NUMBERS)");
        LocalDate date = askForDate();
        System.out.println("Please enter the process to be done: ");
        System.out.print("Process: ");
        String process = scanner.nextLine();
        System.out.println("Please enter the observations made during the process:");
        System.out.println("Type 'exit' when finished");
        while (true) {
            obsNum++;
            System.out.print("Observation #" + obsNum + ": ");
            String observation = scanner.nextLine();
            if(observation.equalsIgnoreCase("exit")){
                break;
            }else{
                observationList.add(observation);
            }
        }

        Mantenimiento maintenance = new Mantenimiento(employee, animal, process, date, observationList);
        maintenanceList.add(maintenance);
        System.out.println("The maintenance record was sucesfully saved!");
        System.out.println("MAINTENANCE PROCESS ID: " + maintenance.getID());
        returnToMainMenu();
    }

    // MODIFIERS

    public void modifyEmployee(){
        Empleado employee = searchEmployee(true);

        System.out.println("What would you like to modify?");
        System.out.println("1. First and Last Name");
        System.out.println("2. Birth date");
        System.out.println("3. CURP");
        System.out.println("4. RFC");
        System.out.println("5. Salary");
        System.out.println("6. Schedule");
        System.out.println("7. Role");
        System.out.println("8. Nothing (return to main menu)");
        System.out.print(">> ");

        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                System.out.println("CURRENT NAME: " + employee.getName() + " " + employee.getLastName());
                System.out.println("Please enter the employee's new name: ");
                System.out.print("First Name: ");
                String newFirstName = scanner.nextLine();
                System.out.print("Last Name: ");
                String newLastName = scanner.nextLine();
                employee.setNames(newFirstName, newLastName);
                System.out.println("The employee's names were succesfully changed!");
                employeeList.add(employee);
                returnToMainMenu();
                break;
            case 2:
                System.out.println("CURRENT BIRTH DATE: " + employee.getBirthDate().toString());
                System.out.println("Please enter the new birth date (ONLY WITH NUMBERS)");
                LocalDate birthDate = askForDate();
                employee.setBirthDate(birthDate);
                employeeList.add(employee);
                System.out.println("The employee's birth date was succesfully changed!");
                returnToMainMenu();
                break;
            case 3:
                System.out.println("CURRENT CURP: " + employee.getCURP());
                System.out.println("Please enter the new CURP");
                System.out.print("CURP: ");
                String CURP = scanner.nextLine();
                employee.setCURP(CURP);
                employeeList.add(employee);
                System.out.println("The employee's CURP was succesfully changed!");
                returnToMainMenu();
                break;
            case 4:
                System.out.println("CURRENT RFC: " + employee.getRFC());
                System.out.println("Please enter the new RFC");
                System.out.print("RFC: ");
                int RFC = scanner.nextInt();
                scanner.nextLine();
                employee.setRFC(RFC);
                employeeList.add(employee);
                System.out.println("The employee's RFC was succesfully changed!");
                returnToMainMenu();
                break;
            case 5:
                System.out.println("CURRENT SALARY: " + employee.getSalary());
                System.out.println("Please enter the new salary");
                System.out.print("Salary: ");
                float salary = scanner.nextFloat();
                scanner.nextLine();
                employee.setSalary(salary);
                employeeList.add(employee);
                System.out.println("The employee's salary was succesfully changed!");
                returnToMainMenu();
                break;
            case 6:
                System.out.println("CURRENT SCHEDULE: " + employee.getSchedule());
                System.out.println("Please enter your new schedule: ");
                System.out.print("Enter your start time (e.g., 7:00 AM): ");
                String startTime = scanner.nextLine();
                System.out.print("Enter your end time (e.g., 2:00 PM): ");
                String endTime = scanner.nextLine();
                employee.setStartTime(startTime);
                employee.setEndTime(endTime);
                employeeList.add(employee);
                System.out.println("The employee's schedule was succesfully changed!");
                returnToMainMenu();
                break;
            case 7:
                System.out.println("CURRENT ROLE: " + employee.getRole());
                System.out.println("Please enter your new role (Veterinarian, Guide, Maintenance, Administration): ");
                String role="";

                while(true){
                    System.out.print("Role: ");
                    role = scanner.nextLine();
                    if(role.equalsIgnoreCase("veterinarian") || role.equalsIgnoreCase("guide") || role.equalsIgnoreCase("administration") || role.equalsIgnoreCase("maintenance")){
                        break;
                    }else{
                        System.out.println("The specified role is not valid. Please enter a valid role:");
                    }
                }

                employee.setRole(role);
                employeeList.add(employee);
                System.out.println("The employee's role was succesfully changed!");
                returnToMainMenu();
                break;
        
            default:
                employeeList.add(employee);
                break;
        }
    }

    public void modifyVisitor(){
        Visitante visitor = searchVisitor(true);

        System.out.println("What would you like to modify?");
        System.out.println("1. First and Last Name");
        System.out.println("2. Birth date");
        System.out.println("3. CURP");
        System.out.println("4. Return to main menu");
        System.out.print(">> ");
        int option = scanner.nextInt();
        scanner.nextLine();
        

        switch (option) {
            case 1:
                System.out.println("CURRENT NAME: " + visitor.getFullName());
                System.out.println("Please enter the visitor's new name: ");
                System.out.print("First Name: ");
                String newFirstName = scanner.nextLine();
                System.out.print("Last Name: ");
                String newLastName = scanner.nextLine();
                visitor.setNames(newFirstName, newLastName);
                System.out.println("The visitor's names were succesfully changed!");
                visitorList.add(visitor);
                returnToMainMenu();
                break;
            case 2:
                System.out.println("CURRENT BIRTHDATE: " + visitor.getBirthDate().toString());
                System.out.println("Please enter the new birth date (ONLY WITH NUMBERS)");
                LocalDate birthDate = askForDate();
                visitor.setBirthDate(birthDate);
                visitorList.add(visitor);
                System.out.println("The visitor's birth date was succesfully changed!");
                returnToMainMenu();
                break;
            case 3:
                System.out.println("CURRENT CURP: " + visitor.getCURP());
                System.out.println("Please enter the new CURP");
                System.out.print("CURP: ");
                String CURP = scanner.nextLine();
                visitor.setCURP(CURP);
                visitorList.add(visitor);
                System.out.println("The visitor's CURP was succesfully changed!");
                returnToMainMenu();
                break;

            default:
                visitorList.add(visitor);
                break;
        }

    }

    public void modifyAnimal(){
        Animal animal = searchAnimal(true);
        System.out.println("What would you like to modify?");
        System.out.println("1. Weight");
        System.out.println("2. Add diseases");
        System.out.println("3. Remove diseases");
        System.out.println("4. Feeding Frequency");
        System.out.println("5. Feeding Type");
        System.out.println("6. Vaccinated status");
        System.out.println("7. Exit");
        System.out.print(">> ");
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1:
                System.out.println("CURRENT WEIGHT: " + animal.getWeight());
                System.out.println("Please enter the animal's new weight:");
                System.out.print("Weight: ");
                float weight = scanner.nextFloat();
                scanner.nextLine();
                animal.setWeight(weight);
                animalList.add(animal);
                System.out.println("The animal's weight was successfully modified!");
                returnToMainMenu();
                break;
        
            case 2:
                ArrayList<String> diseaseList = new ArrayList<>();
                int diseaseID = 0;
                System.out.println("Please enter the new diseases to add:");
                System.out.println("Type 'exit' when finished...");
                while(true){
                    diseaseID++;
                    System.out.print("Disease #" + diseaseID + ": ");
                    String disease = scanner.nextLine();

                    if(disease.equalsIgnoreCase("exit")){
                        animal.addDiseases(diseaseList);
                        System.out.println("The diseases have been succesfully registered!");
                        returnToMainMenu();
                        break;
                    }
                    diseaseList.add(disease);
                }
                animalList.add(animal);
                break;
        
            case 3:
                System.out.println("Please enter the disease ID to remove: ");
                System.out.println("Type 'exit when finished...'");
                int ID=0;

                    while(true){
                        System.out.print("Disease ID: ");
                        ID = scanner.nextInt();
                        scanner.nextLine();
                        if(ID>animal.getDiseaseList().size() || ID<0){
                            System.out.println("Please enter a valid ID between 0 and " + animal.getDiseaseList().size());
                        }else{
                            System.out.println("Disease " + ID + "found");
                            String disease = animal.getDiseaseList().get(ID);
                            System.out.println("Disease: " + disease);
                            break;
                        }
                    }

                    System.out.println("Are you sure you want to delete this disease? (y/n)");
                    System.out.print(">> ");
                    char opt = scanner.nextLine().charAt(0);

                    switch (Character.toLowerCase(opt)) {
                        case 'y':
                            animal.getDiseaseList().remove(ID);
                            System.out.println("The disease was deleted succesfully");
                            break;
                    
                        default:
                            System.out.println("The disease was not deleted");
                            break;
                    }
                    animalList.add(animal);
                    returnToMainMenu();
                break;
        
            case 4:
                System.out.println("CURRENT FEEDING FREQUENCY: " + animal.getFeedingFreq());
                System.out.println("Please enter the new feeding frequency of the animal:");
                System.out.print("Must be fed every: ");
                String feedFreq = scanner.nextLine();
                animal.setFeedingFrequency(feedFreq);
                animalList.add(animal);
                System.out.println("The feeding frequency was succesfully modified!");
                returnToMainMenu();
                break;
        
            case 5:
                System.out.println("CURRENT FEEDING TYPE: " + animal.getFeedingType());
                System.out.println("Please enter the new feeding type for the animal:");
                System.out.print("Feeding type: ");
                String feedType = scanner.nextLine();
                animal.setFeedingType(feedType);
                animalList.add(animal);
                System.out.println("The feeding type was succesfully modified!");
                returnToMainMenu();
                break;

            case 6:
                boolean success = false;
                boolean vacStatus = false;
                System.out.println("CURRENT VACCINATED STATUS: " + animal.getVaccinationStatus());
                System.out.println("Please enter the new vaccination status (y/n):");
                while (!success) {
                    System.out.print("Is the animal vaccinated? ");
                    char vacStatusChar = scanner.nextLine().charAt(0);

                    switch (Character.toLowerCase(vacStatusChar)) {
                        case 'y':
                            vacStatus = true;
                            success = true;
                            break;

                        case 'n':
                            success = true;
                            break;
                    
                        default:
                            System.out.println("The entered option is not valid. Please enter a valid option (y/n)");
                            break;
                    }
                }
                
                animal.setVaccineStatus(vacStatus);
                animalList.add(animal);
                System.out.println("The vaccination status was succesfully modified!");
                returnToMainMenu();
                break;
        
            default:
                animalList.add(animal);
                break;
        }
    }

    // CONSULTERS

    public void consultEmployee(){
        Empleado employee = searchEmployee(false);
        System.out.println(employee.getName() + " " + employee.getLastName() + "'s data:");
        employee.getInfo();
        returnToMainMenu();
    }

    public void consultVisitor(){
        Visitante visitor = searchVisitor(false);
        System.out.println(visitor.getName() + " " + visitor.getLastName() + "'s data:");
        visitor.getInfo();
        returnToMainMenu();
    }

    public void consultAnimal(){
        Animal animal = searchAnimal(false);
        animal.getInfo();
        returnToMainMenu();
    }

    public void consultVisit(){
        Visita visit = searchVisit(false);
        visit.getVisitInfo();
        returnToMainMenu();
    }

    public void consultMaintenance(){
        Mantenimiento maintenance = searchMaintenance(false);
        maintenance.printInfo();
        returnToMainMenu();
    }

    // DELETERS

    public void deleteEmployee(){
        Empleado employee = searchEmployee(false);
        System.out.println("Are you sure you want to delete this employee? (y/n)");
        char option = scanner.nextLine().charAt(0);
        boolean answer = yesOrNo(option);
        if(answer){
            employeeList.remove(employee);
            System.out.println("The employee was succesfully deleted");
        }else{
            System.out.println("The employee was not deleted");
        }
        returnToMainMenu();
    }

    public void deleteVisitor(){
        Visitante visitor = searchVisitor(false);
        System.out.println("Are you sure you want to delete this visitor? (y/n)");
        char option = scanner.nextLine().charAt(0);
        boolean answer = yesOrNo(option);
        if(answer){
            visitorList.remove(visitor);
            System.out.println("The visitor was succesfully removed");
        }else{
            System.out.println("The visitor was not deleted");
        }
        returnToMainMenu();
    }

    public void deleteAnimal(){
        Animal animal = searchAnimal(false);
        System.out.println("Are you sure you want to delete this animal?");
        char option = scanner.nextLine().charAt(0);
        boolean answer = yesOrNo(option);
        if(answer){
            animalList.remove(animal);
            System.out.println("The animal was succesfully removed");
        }else{
            System.out.println("The animal was not deleted");
        }
        returnToMainMenu();
    }

}