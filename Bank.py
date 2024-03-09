class Bank:
    def __init__(self):
        self.employeeList = []

    def list_employees(self):
        for employee in self.employeeList:
            print(" * {}".format(employee.get_user_name()))

    def get_user(self):
        return self.employeeList[0]

    def check_user(self, emp):
        for employee in self.employeeList:
            if emp == employee.get_user_name():
                return True
        return False

    def check_account_id(self, emp, id):
        if id < 0 or id >= len(emp.accountList):
            return False
        else:
            return True

    def store_user(self, user):
        self.employeeList.append(user)