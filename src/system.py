from datetime import datetime
from employee import Employee
from visitor import Visitor
from visit import Visit
from animal import Animal
from maintenance import Maintenance
from zoo import Zoo


class System:
    def __init__(self):
        self.zoo = Zoo("password")

    def execute(self):

        option = 0

        while option != 5:
            print("\n*************************************************")
            print("Welcome to the Morelia Zoo Management System")
            print("*************************************************")
            print("1. Register (Employee, Visitor, Visit, Animal or Maintenance)")
            print("2. Consult (Employee, Visitor, Visit, Animal or Maintenance)")
            print("3. Modify (Employee, Visitor or Animal)")
            print("4. Delete (Employee, Visitor or Animal)")
            print("5. Exit")
            print("*************************************************")

            option = int(input(">> "))

            if option == 1:
                print("********************************************************")
                print("REGISTER (Employee, visitor, visit, animal or maintenance)")
                print("********************************************************")
                sub_option = int(input("Please enter the element to register: \n"
                                       "\n1. Employee"
                                       "\n2. Visitor"
                                       "\n3. Animal"
                                       "\n4. Visit"
                                       "\n5. Maintenance"
                                       "\n6. Return to main menu\n"))

                if sub_option == 1:
                    self.zoo.register_employee()
                elif sub_option == 2:
                    self.zoo.register_visitor()
                elif sub_option == 3:
                    self.zoo.register_animal()
                elif sub_option == 4:
                    self.zoo.register_visit()
                elif sub_option == 5:
                    self.zoo.register_maintenance()
                elif sub_option == 6:
                    continue
                else:
                    print("Invalid choice! Please try again.")
                    continue

            elif option == 2:
                print("********************************************************")
                print("CONSULT (Employee, visitor, visit, animal or maintenance)")
                print("********************************************************")
                sub_option = int(input("Please enter the element to consult: "
                                       "\n1. Employee"
                                       "\n2. Visitor"
                                       "\n3. Animal"
                                       "\n4. Visit"
                                       "\n5. Maintenance"
                                       "\n6. Return to main menu\n"))
                if sub_option == 1:
                    self.zoo.list_employees()
                elif sub_option == 2:
                    self.zoo.list_visitors()
                elif sub_option == 3:
                    self.zoo.list_animals()
                elif sub_option == 4:
                    self.zoo.list_visits()
                elif sub_option == 5:
                    self.zoo.list_maintenance()
                elif sub_option == 6:
                    continue
                else:
                    print("Invalid choice! Please try again.")
                    continue

            elif option == 3:
                print("********************************************************")
                print("MODIFY (Employee, visitor or animal)")
                print("********************************************************")
                sub_option = int(input("Please enter the element to modify: "
                                       "\n1. Employee"
                                       "\n2. Visitor"
                                       "\n3. Animal"
                                       "\n4. Return to main menu\n"))
                if sub_option == 1:
                    self.zoo.modify_employee()
                elif sub_option == 2:
                    self.zoo.modify_visitor()
                elif sub_option == 3:
                    self.zoo.modify_animal()
                elif sub_option == 4:
                    continue
                else:
                    print("Invalid choice! Please try again.")
                    continue

            elif option == 4:
                print("********************************************************")
                print("DELETE (Employee, visitor or animal)")
                print("********************************************************")
                sub_option = int(input("Please enter the element to delete: "
                                       "\n1. Employee"
                                       "\n2. Visitor"
                                       "\n3. Animal"
                                       "\n4. Return to main menu\n"))
                if sub_option == 1:
                    self.zoo.delete_employee()
                elif sub_option == 2:
                    self.zoo.delete_visitor()
                elif sub_option == 3:
                    self.zoo.delete_animal()
                elif sub_option == 4:
                    continue
                else:
                    print("Invalid choice! Please try again.")
                    continue

            elif option == 5:
                print("Exiting program...")
                break
            else:
                print("Invalid choice! Please try again.")
                continue
