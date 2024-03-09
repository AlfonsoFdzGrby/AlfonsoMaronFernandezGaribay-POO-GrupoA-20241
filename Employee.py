from BankAccount import BankAccount

class Employee:
    def __init__(self, type, userName, amount, accountNum):
        self.userName = userName
        self.account = BankAccount(type, userName, amount, accountNum)
        self.accountList = [self.account]

    def get_account(self, id):
        return self.accountList[id]

    def add_account(self, account):
        self.accountList.append(account)

    def set_user_name(self, userName):
        self.userName = userName

    def get_user_name(self):
        return self.userName

    def print_account_list(self):
        print("{}'s accounts:".format(self.userName))
        for index, account in enumerate(self.accountList):
            print("Account #{}".format(index))
            print("  * Number: {}".format(account.accountNum))
            print("  * Type: {}".format(account.type))
            print("  * Funds: ${:.2f}".format(account.amount))
            print()


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