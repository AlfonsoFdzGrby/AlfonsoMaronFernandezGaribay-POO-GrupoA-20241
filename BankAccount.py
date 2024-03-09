class BankAccount:
    def __init__(self, type, user, amount, accountNum):
        self.type = type
        self.user = user
        self.amount = amount
        self.accountNum = accountNum

    def set_type(self, new_type):
        if new_type.upper()=='A':
            if self.type.upper()=='B' or self.type.upper()=='C':
                print("Account cannot be downgraded")
            else:
                self.type = new_type.upper()
                print("Your account has been successfully upgraded!")
                return True
            
        if new_type.upper()=='B':
            if self.type.upper()=='C':
                    print("Account cannot be downgraded")
            else:
                self.type = new_type.upper()
                print("Your account has been successfully upgraded!")
                return True
        
        if new_type.upper()=='C':
            if self.type.upper()=='C':
                    print("Account cannot be downgraded")
            else:
                self.type = new_type.upper()
                print("Your account has been successfully upgraded!")
                return True
        else:
            print("The entered account type is not allowed")
            input()
            return False

    def deposit(self, amount):
        if self.type == 'A':
            deposit_limit = 50000
            if amount > deposit_limit or (amount + self.amount) > deposit_limit or amount <= 0:
                print("The entered amount is not valid")
                return False
            else:
                self.amount += amount
                return True
        elif self.type == 'B':
            deposit_limit = 100000
            if amount > deposit_limit or (amount + self.amount) > deposit_limit or amount <= 0:
                print("The entered amount is not valid")
                return False
            else:
                self.amount += amount
                return True
        else:
            if amount <= 0:
                print("The entered amount is not valid")
                return False
            else:
                self.amount += amount
                return True

    def withdraw(self, amount):
        if self.type == 'A':
            withdraw_limit = 1000
            if amount < withdraw_limit or amount > self.amount or amount <= 0:
                print("The specified amount is not valid")
                print("The withdraw minimum of this type {} account is {}".format(self.type, withdraw_limit))
                return False
            else:
                self.amount -= amount
                return True
        elif self.type == 'B':
            withdraw_limit = 5000
            if amount < withdraw_limit or amount > self.amount or amount <= 0:
                print("The specified amount is not valid")
                print("The withdraw minimum of this type {} account is {}".format(self.type, withdraw_limit))
                return False
            else:
                self.amount -= amount
                return True
        else:
            withdraw_limit = 10000
            if amount < withdraw_limit or amount > self.amount or amount <= 0:
                print("The specified amount is not valid")
                print("The withdraw minimum of this type {} account is {}".format(self.type, withdraw_limit))
                return False
            else:
                self.amount -= amount
                return True

    def get_account_info(self):
        account_info = """
User: {}
Account Number: {}
Account Type: {}
Funds: ${:.2f}
""".format(self.user, self.accountNum, self.type, self.amount)
        return account_info