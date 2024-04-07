from datetime import datetime
from employee import Employee
from visitor import Visitor
from visit import Visit
from animal import Animal
from maintenance import Maintenance


class Zoo:
    def __init__(self, access_password):
        self.employee_list = []
        self.visitor_list = []
        self.animal_list = []
        self.visit_list = []
        self.maintenance_list = []
        self.access_password = access_password

    # Employee methods

    def get_employees(self):
        return self.employee_list

    def add_employee(self, employee):
        if isinstance(employee, Employee):
            self.employee_list.append(employee)
            print("Employee registered successfully!")
        else:
            print("Invalid employee data. Unable to register.")

    def register_employee(self):
        name = input("Enter employee's name: ")
        last_name = input("Enter employee's last name: ")
        birth_date = input("Enter employee's birth date (DD/MM/YYYY): ")
        hire_date = input("Enter employee's hire date (DD/MM/YYYY): ")
        rfc = input("Enter employee's RFC: ")
        for employee in self.employee_list:
            if employee.rfc == rfc:
                print("The entered RFC is already registered for another employee.")
                return
        curp = input("Enter employee's CURP: ")
        for employee in self.employee_list:
            if employee.curp == curp:
                print("The entered CURP is already registered for another employee.")
                return
        salary = float(input("Enter employee's salary: "))
        entry_time = input("Enter employee's start time (HH:MM): ")
        end_time = input("Enter employee's end time (HH:MM): ")
        role = input("Enter employee's role: (Veterinarian, Guide, Maintenance, Administration): ").lower().capitalize()
        if role in Employee.ROLES:
            employee = Employee(name, last_name, datetime.strptime(birth_date, '%d/%m/%Y'),
                                datetime.strptime(hire_date, '%d/%m/%Y'), rfc, curp,
                                salary, datetime.strptime(entry_time, '%H:%M').time(),
                                datetime.strptime(end_time, '%H:%M').time(), role)
            self.add_employee(employee)
        else:
            print("Invalid role. Employee registration failed.")

    def list_employees(self):
        if not self.employee_list:
            print("There are no registered employees.")
            return

        print("Registered employees:")
        for employee in self.employee_list:
            employee.get_info()
            print("---------------------------------------------------")

    def modify_employee(self):
        emp_rfc = input("Enter the RFC of the employee you want to modify: ")
        employee = next((e for e in self.employee_list if e.rfc == emp_rfc), None)

        if employee is None:
            print(f"Employee with RFC {emp_rfc} not found.")
            return
        else:
            print("Employee found. Please provide new details.")

        while True:
            print("\nWhich detail would you like to modify?")
            print("1. Name")
            print("2. Last Name")
            print("3. Birth Date")
            print("4. Hire Date")
            print("5. RFC")
            print("6. CURP")
            print("7. Salary")
            print("8. Entry Time")
            print("9. End Time")
            print("10. Role")
            print("11. Return to main menu")

            choice = input("Enter your choice: ")

            if choice == '1':
                employee.name = input("Enter the new name: ")
                print("Employee's name updated successfully.")
            elif choice == '2':
                employee.last_name = input("Enter the new last name: ")
                print("Employee's last name updated successfully.")
            elif choice == '3':
                employee.birth_date = datetime.strptime(input("Enter the new birth date (DD/MM/YYYY): "), '%d/%m/%Y')
                print("Employee's birth date updated successfully.")
            elif choice == '4':
                employee.hire_date = datetime.strptime(input("Enter the new hire date (DD/MM/YYYY): "), '%d/%m/%Y')
                print("Employee's hire date updated successfully.")
            elif choice == '5':
                new_rfc = input("Enter the new RFC: ")
                if not any(e.rfc == new_rfc for e in self.employee_list if e != employee):
                    employee.rfc = new_rfc
                    print("Employee's RFC updated successfully.")
                else:
                    print("The RFC is already in use.")
            elif choice == '6':
                new_curp = input("Enter the new CURP: ")
                if not any(e.curp == new_curp for e in self.employee_list if e != employee):
                    employee.curp = new_curp
                    print("Employee's CURP updated successfully.")
                else:
                    print("The CURP is already in use.")
            elif choice == '7':
                employee.salary = float(input("Enter the new salary: "))
                print("Employee's salary updated successfully.")
            elif choice == '8':
                employee.entry_time = datetime.strptime(input("Enter the new start time (HH:MM): "), '%H:%M').time()
                print("Employee's entry time updated successfully.")
            elif choice == '9':
                employee.end_time = datetime.strptime(input("Enter the new end time (HH:MM): "), '%H:%M').time()
                print("Employee's end time updated successfully.")
            elif choice == '10':
                new_role = input("Enter the new role (Veterinarian, Guide, Maintenance, Administration): ")
                if new_role in Employee.ROLES:
                    employee.role = new_role
                    print("Employee's role updated successfully.")
                else:
                    print("Invalid role. Role update failed.")
            elif choice == '11':
                break
            else:
                print("Invalid choice. Please try again.")

    def delete_employee(self):
        emp_rfc = input("Enter the RFC of the employee you want to delete: ")
        for employee in self.employee_list:
            if employee.rfc == emp_rfc:
                self.employee_list.remove(employee)
                print("Employee with RFC '{}' deleted successfully.".format(emp_rfc))
                return
        print(f"Employee with RFC {emp_rfc} not found.")

    # Animal methods

    def get_animals(self):
        return self.animal_list

    def add_animal(self, animal):
        if isinstance(animal, Animal):
            self.animal_list.append(animal)
            print("Animal registered successfully!")
        else:
            print("Invalid animal data. Unable to register.")

    def register_animal(self):
        animal_type = input("Enter the animal type: ")
        birth_date = input("Enter the animal's birth date (DD/MM/YYYY): ")
        arrival_date = input("Enter the animal's arrival date (DD/MM/YYYY): ")
        weight = float(input("Enter the animal's weight: "))
        diseases = input("Enter the animal's diseases (comma-separated): ").split(',')
        feeding_frequency = input("Enter the animal's feeding frequency: ")
        feeding_type = input("Enter the animal's feeding type: ")
        vaccinated = input("Does the animal have vaccines? (y/n): ").lower() == 'y'

        animal = Animal(animal_type, datetime.strptime(birth_date, '%d/%m/%Y'),
                        datetime.strptime(arrival_date, '%d/%m/%Y'), weight, diseases,
                        feeding_frequency, feeding_type, vaccinated)
        self.add_animal(animal)

    def list_animals(self):
        if not self.animal_list:
            print("There are no registered animals.")
            return

        print("Registered animals:")
        for animal in self.animal_list:
            animal.get_info()
            print("---------------------------------------------------")

    def modify_animal(self):
        animal_id = input("Enter the ID of the animal you want to modify: ")
        animal = next((a for a in self.animal_list if str(a.id) == animal_id), None)

        if animal is None:
            print(f"Animal with ID {animal_id} not found.")
            return
        else:
            print("Animal found. Please provide new details.")

        while True:
            print("\nWhich detail would you like to modify?")
            print("1. Animal Type")
            print("2. Birth Date")
            print("3. Arrival Date")
            print("4. Weight")
            print("5. Diseases")
            print("6. Feeding Frequency")
            print("7. Feeding Type")
            print("8. Vaccination Status")
            print("9. Return to main menu")

            choice = input("Enter your choice: ")

            if choice == '1':
                animal.animal_type = input("Enter the new animal type: ")
                print("Animal type updated successfully.")
            elif choice == '2':
                animal.birth_date = datetime.strptime(input("Enter the new birth date (DD/MM/YYYY): "), '%d/%m/%Y')
                print("Animal birth date updated successfully.")
            elif choice == '3':
                animal.arrival_date = datetime.strptime(input("Enter the new arrival date (DD/MM/YYYY): "), '%d/%m/%Y')
                print("Animal arrival date updated successfully.")
            elif choice == '4':
                animal.weight = float(input("Enter the new weight: "))
                print("Animal weight updated successfully.")
            elif choice == '5':
                diseases_input = input("Enter the new list of diseases (comma separated): ")
                animal.diseases = diseases_input.split(",") if diseases_input else []
                print("Animal diseases updated successfully.")
            elif choice == '6':
                animal.feeding_frequency = input("Enter the new feeding frequency: ")
                print("Animal feeding frequency updated successfully.")
            elif choice == '7':
                animal.feeding_type = input("Enter the new feeding type: ")
                print("Animal feeding type updated successfully.")
            elif choice == '8':
                vaccination_input = input("Is the animal vaccinated? (yes/no): ").lower()
                animal.is_vaccinated = True if vaccination_input == "yes" else False
                print("Animal vaccinated updated successfully.")
            elif choice == '9':
                break
            else:
                print("Invalid choice. Please try again.")

    def delete_animal(self):
        animal_id = input("Enter the ID of the animal you want to delete: ")
        for animal in self.animal_list:
            if animal.id == animal_id:
                self.animal_list.remove(animal)
                print("Animal with ID '{}' deleted successfully.".format(animal_id))
                return
        print(f"Animal with ID {animal_id} not found.")

    # Maintenance methods

    def add_maintenance(self, maintenance):
        if isinstance(maintenance, Maintenance):
            self.maintenance_list.append(maintenance)
            print("Maintenance task registered successfully!")
        else:
            print("Invalid maintenance data. Unable to register.")

    def get_maintenance(self):
        return self.maintenance_list

    def register_maintenance(self):
        responsible_employee_rfc = input("Enter the responsible employee's RFC: ")
        responsible_employee = next((emp for emp in self.employee_list if emp.rfc == responsible_employee_rfc), None)
        if responsible_employee is None:
            print("No employee found with the provided RFC.")
            return
        if responsible_employee.role != "Maintenance":
            print("The employee does not have the 'Maintenance' role.")
            return
        
        animal_id = input("Enter the ID of the animal: ")
        animal_exists = any(a for a in self.animal_list if str(a.get_id()) == animal_id)

        if not animal_exists:
            print("No animal found with the provided ID.")
            return

        process_done = input("Enter the process done: ")
        process_date = input("Enter the process date (DD/MM/YYYY): ")
        observations = input("Enter observations: (separate the names using commas ',') ").split(',')

        maintenance = Maintenance(responsible_employee, animal_id, process_done,
                                    datetime.strptime(process_date, '%d/%m/%Y'), observations)
        self.add_maintenance(maintenance)

    def list_maintenance(self):
        if not self.maintenance_list:
            print("There are no maintenance records.")
            return

        print("Maintenance records:")
        for maintenance in self.maintenance_list:
            maintenance.print_info()
            print("---------------------------------------------------")

    '''

    def modify_maintenance(self):
        maintenance_id = input("Enter the ID of the maintenance task you want to modify: ")
        maintenance = next((m for m in self.maintenance_list if str (m.id) == maintenance_id), None)

        if maintenance is None:
            print(f"Maintenance task with ID {maintenance_id} not found.")
        else:
            print("Maintenance task found. Please provide new details.")

        while True:
            print("\nWhich detail would you like to modify?")
            print("1. Employee's name")
            print("2. Process Done")
            print("3. Process Date")
            print("4. Observations")
            print("5. Return to main menu")

            choice = input("Enter your choice: ")

            if choice == '1':
                maintenance.responsible_employee = input("Enter the new Employee's name: ")
            elif choice == '2':
                maintenance.process_done = (input("Enter the new process done: "))
            elif choice == '3':
                maintenance.process_date = datetime.strptime(input("Enter the new process date (DD/MM/YYYY): "), '%d/%m/%Y')
            elif choice == '4':
                observations_input = input("Enter the new list of Observations (comma separated): ")
                maintenance.observations = observations_input.split(",") if observations_input else []
            elif choice == '5':
                break
            else:
                print("Invalid choice. Please try again.")

            print("Maintenance task details updated successfully.")

    def delete_maintenance(self):
        maintenance_id = input("Enter the ID of the maintenance task you want to delete: ")
        for maintenance in self.maintenance_list:
            if maintenance.id == maintenance_id:
                self.maintenance_list.remove(maintenance)
                print("Maintenance task with ID '{}' deleted successfully.".format(maintenance_id))
                return
        print(f"Maintenance task with ID {maintenance_id} not found.")

    '''

    # Visit methods

    def get_visits(self):
        return self.visit_list

    def is_visitor_registered(self, name):
        for visitor in self.visitor_list:
            if visitor.get_full_name() == name:
                return True
        return False

    def add_visit(self, visit):
        if isinstance(visit, Visit):
            self.visit_list.append(visit)
            print("Visit registered successfully!")
        else:
            print("Invalid visit data. Unable to register.")

    def register_visit(self):
        guide_name = input("Enter guide's name: ")
        guide_last_name = input("Enter guide's last name: ")

        # Validate if guide exists and has the correct role
        guide_exists = any(emp for emp in self.employee_list if
                           emp.name == guide_name and emp.last_name == guide_last_name and emp.role.lower() == "guide")
        if not guide_exists:
            print("Guide does not exist or is not assigned the 'Guide' role.")
            return

        visitor_names_input = input("Enter visitor's full names: (separate the names using commas ',') ")
        # Extract visitor names and strip whitespace
        visitor_names = [full_name.strip() for full_name in visitor_names_input.split(',')]
        # Check if all visitors are registered
        registered_visitors = []
        for full_name in visitor_names:
            visitor = next((v for v in self.visitor_list if f"{v.name} {v.last_name}" == full_name), None)
            if visitor:
                registered_visitors.append(visitor)
            else:
                print(f"Visitor '{full_name}' is not registered.")
                return

        visit_date = input("Enter the visit date (DD/MM/YYYY): ")

        # If all checks pass, register the visit
        visit = Visit(guide_name, guide_last_name, registered_visitors, datetime.strptime(visit_date, '%d/%m/%Y'))
        visit.calculate_total_visits()
        visit.calculate_total_cost()
        self.add_visit(visit)

    def list_visits(self):
        if not self.visit_list:
            print("There are no registered visits.")
            return
        else:
            print("Registered visits:")
            for visit in self.visit_list:
                visit.get_visit_info()
                print("---------------------------------------------------")

    '''

    def modify_visit(self):
        visit_id = input("Enter the ID of the visit you want to modify: ")
        visit = next((v for v in self.visit_list if str(v.id) == visit_id), None)

        if visit is None:
            print(f"Visit with ID {visit_id} not found.")
            return
        else:
            print("Visit found. Please provide new details.")

        while True:
            print("\nWhich detail would you like to modify?")
            print("1. Guide's Name")
            print("2. Visit Date")
            print("3. Add a Visitor")
            print("4. Remove a Visitor")
            print("5. Return to main menu")

            choice = input("Enter your choice: ")

            if choice == '1':
                new_guide_name = input("Enter the new guide's name: ")
                new_guide_last_name = input("Enter the new guide's last name: ")
                # Assuming guides are employees, validate the guide exists
                guide = next((e for e in self.employee_list if e.name == new_guide_name and e.last_name == new_guide_last_name), None)
                if guide:
                    visit.guide_name = new_guide_name
                    visit.guide_last_name = new_guide_last_name
                    print("Guide updated successfully.")
                else:
                    print("Guide not found.")
            elif choice == '2':
                new_date = input("Enter the new visit date (DD/MM/YYYY): ")
                visit.visit_date = datetime.strptime(new_date, '%d/%m/%Y')
                print("Visit date updated successfully.")
            elif choice == '3':
                visitor_name = input("Enter the full name of the visitor to add: ")
                # Assuming visitors are stored by full name for simplicity
                visitor = next((v for v in self.visitor_list if f"{v.name} {v.last_name}" == visitor_name), None)
                if visitor and visitor not in visit.visitors:
                    visit.visitors.append(visitor)
                    print("Visitor added successfully.")
                else:
                    print("Visitor not found or already added.")
            elif choice == '4':
                visitor_name = input("Enter the full name of the visitor to remove: ")
                for i, visitor in enumerate(visit.visitors):
                    if f"{visitor.name} {visitor.last_name}" == visitor_name:
                        del visit.visitors[i]
                        print("Visitor removed successfully.")
                        break
                else:
                    print("Visitor not found.")
            elif choice == '5':
                break
            else:
                print("Invalid choice. Please try again.")


    def delete_visit(self):
        visit_id = int(input("Enter the ID of the visit you want to delete: "))
        for visit in self.visit_list:
            if visit.id == visit_id:
                self.visit_list.remove(visit)
                print("Visit with ID '{}' deleted successfully.".format(visit_id))
                return
        print(f"Visit with ID {visit_id} not found.")

    '''

    # Visitor methods

    def get_visitors(self):
        return self.visitor_list

    def add_visitor(self, visitor):
        if isinstance(visitor, Visitor):
            self.visitor_list.append(visitor)
            print("Visitor registered successfully!")
        else:
            print("Invalid visitor data. Unable to register.")

    def register_visitor(self):
        name = input("Enter visitor's name: ")
        last_name = input("Enter visitor's last name: ")
        birth_date = input("Enter visitor's birth date (DD/MM/YYYY): ")
        curp = input("Enter visitor's CURP: ")
        if any(visitor.curp == curp for visitor in self.visitor_list):
            print("The CURP is already registered for another visitor.")
            return

        registration_date = input("Enter visitor's register date (DD/MM/YYYY): ")

        visitor = Visitor(name, last_name, datetime.strptime(birth_date, '%d/%m/%Y'), curp,
                          datetime.strptime(registration_date, '%d/%m/%Y'))
        self.add_visitor(visitor)

    def list_visitors(self):
        if not self.visitor_list:
            print("There are no registered visitors.")
            return

        print("Registered visitors:")
        for visitor in self.visitor_list:
            visitor.get_info()
            print("---------------------------------------------------")

    def modify_visitor(self):
        visitor_curp = input("Enter the CURP of the visitor you want to modify: ")
        visitor = next((v for v in self.visitor_list if v.curp == visitor_curp), None)

        if visitor is None:
            print(f"Visitor with CURP {visitor_curp} not found.")
        else:
            print("Visitor found. Please provide new details.")

        while True:
            print("\nWhich detail would you like to modify?")
            print("1. Name")
            print("2. Last Name")
            print("3. Birth Date")
            print("4. CURP")
            print("5. Registration Date")
            print("6. Return to main menu")

            choice = input("Enter your choice: ")

            if choice == '1':
                visitor.name = input("Enter the new name: ")
                print("Visitor's name updated successfully.")
            elif choice == '2':
                visitor.last_name = input("Enter the new last name: ")
                print("Visitor's last name updated successfully.")
            elif choice == '3':
                visitor.birth_date = datetime.strptime(input("Enter the new birth date (DD/MM/YYYY): "), '%d/%m/%Y')
                print("Visitor's birth date updated successfully.")
            elif choice == '4':
                new_curp = input("Enter the new CURP: ")
                # Validate the new CURP
                if not any(v.curp == new_curp for v in self.visitor_list if v != visitor):
                    visitor.curp = new_curp
                    print("Visitor's CURP updated successfully.")
                else:
                    print("The new CURP is already in use.")
            elif choice == '5':
                visitor.registration_date = datetime.strptime(
                    input("Enter the new registration date (DD/MM/YYYY): "), '%d/%m/%Y')
                print("Visitor's registration date updated successfully.")
            elif choice == '6':
                break
            else:
                print("Invalid choice. Please try again.")

    def delete_visitor(self):
        visitor_curp = input("Enter the CURP of the visitor you want to delete: ")
        for visitor in self.visitor_list:
            if visitor.curp == visitor_curp:
                self.visitor_list.remove(visitor)
                print("Visitor with CURP '{}' deleted successfully.".format(visitor_curp))
                return
        print(f"Visitor with CURP {visitor_curp} not found.")
