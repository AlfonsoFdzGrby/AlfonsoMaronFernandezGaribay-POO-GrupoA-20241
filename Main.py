import os
import random
from Employee import Employee
from Bank import Bank
from BankAccount import BankAccount


def clear_screen():
    os.system('cls')


def print_header(header):
    clear_screen()
    print("=========================================================")
    print(header)
    print("=========================================================")


def executive_menu(bank):
    while True:
        print_header("BANK EXECUTIVE OPTIONS")
        print("1. List users registered in Bank")
        print("2. Show a specific user's information")
        print("3. Return to main menu")
        option = input(">> ")
        if option == '1':
            print_header("USER LIST")
            bank.list_employees()
            input("Press enter to return to the main menu...")
        elif option == '2':
            found = False
            print_header("USER INFORMATION")
            while True:
                userName = input("Enter username: ")
                for employee in bank.employeeList:
                    if userName.lower() == employee.get_user_name().lower():
                        found = True
                        user = employee
                        break
                if not found:
                    print("User not found. Please enter an existent username")
                else:
                    user.print_account_list()
                    input("Press enter to return to bank executive's options...")
                    break
        elif option == '3':
            break


def sign_up(bank):
    print_header("SIGN UP")
    print("To create your new account, please fill up the next data:")
    name = input(">> Name: ")
    print_header("SIGN UP")
    print("Hello {}!".format(name))
    print("There are several account types you can create, which are:")
    print("TYPE A:")
    print("  > Fund limit: $50,000.00")
    print("  > Withdraw Minimum: $1,000.00")
    print("TYPE B:")
    print("  > Fund limit: $100,000.00")
    print("  > Withdraw Minimum: $5,000.00")
    print("TYPE C:")
    print("  > No fund limit")
    print("  > Withdraw Minimum: $10,000.00")

    while True:
        account_type = input(">> Account type: ")
        if account_type.upper() in ['A', 'B', 'C']:
            break
        else:
            print("The defined account type is not valid.")
            print("Please enter a valid account type:")

    while True:
        initial_deposit = float(input(">> Initial deposit/funds for type {} account: ".format(account_type)))
        if account_type.upper() == 'A':
            if initial_deposit > 50000 or initial_deposit < 1000:
                print("The defined amount is not valid.")
                print("Please enter a valid amount:")
            else:
                break
        elif account_type.upper() == 'B':
            if initial_deposit > 100000 or initial_deposit < 5000:
                print("The defined amount is not valid.")
                print("Please enter a valid amount:")
            else:
                break
        else:
            if initial_deposit < 10000:
                print("The defined amount is not valid.")
                print("Please enter a valid amount:")
            else:
                break

    user = Employee(account_type, name, initial_deposit, random.randint(11111111, 99999999))
    bank.store_user(user)
    print_header("SIGN UP")
    print("Your account has been registered correctly with an initial account!")
    input("Press any key to return to the main menu...")


def log_in(bank):
    print_header("LOG IN")
    while True:
        found = False
        userName = input(">> Username: ")
        for employee in bank.employeeList:
            if userName.lower() == employee.get_user_name().lower():
                found = True
                user = employee
                break
        if not found:
            print("User not found. Please enter a valid user:")
        else:
            print("User {} found".format(user.get_user_name()))
            break

    while True:
        account_id = int(input(">> Enter the account id to access: "))
        if not bank.check_account_id(user, account_id):
            print("Account not found. Please enter a valid ID")
        else:
            print("Account {} found".format(account_id))
            input("Press enter to access your account's settings...")
            break

    while True:
        print("=========================================================")
        print_header("ACCOUNT SETTINGS")
        account = user.get_account(account_id)
        print("Account ID: {}".format(account_id))
        print("Account Number: {}".format(account.accountNum))
        print("Account credit: ${:.2f}".format(account.amount))
        print("=========================================================")
        print("1. Withdraw money")
        print("2. Deposit money")
        print("3. Upgrade account type")
        print("4. Show actual account info")
        print("5. Create new account for user {}".format(user.get_user_name()))
        print("6. Show user's accounts:")
        print("7. Return to main menu")
        option = input(">> ")

        if option == '1':
            withdraw_money(user, account_id)
        elif option == '2':
            deposit_money(user, account_id)
        elif option == '3':
            change_type(user, account_id)
        elif option == '4':
            print_header("ACCOUNT INFO")
            print(account.get_account_info())
            input("Press enter to return to account settings...")
        elif option == '5':
            create_new_account(user)
        elif option == '6':
            print_header("{}'S ACCOUNTS".format(user.get_user_name().upper()))
            user.print_account_list()
            input("Press enter to return to account settings...")
        elif option == '7':
            break


def withdraw_money(user, id):
    print_header("WITHDRAW MONEY")
    while True:
        withdraw_amount = float(input("Please enter the amount to withdraw: "))
        if user.get_account(id).withdraw(withdraw_amount):
            print("${:.2f} were withdrawn from account #{}".format(withdraw_amount, id))
            print("Account credit: ${:.2f}".format(user.get_account(id).amount))
            input()
            break


def deposit_money(user, id):
    print_header("DEPOSIT MONEY")
    while True:
        deposit_amount = float(input("Please enter the amount to deposit: "))
        if user.get_account(id).deposit(deposit_amount):
            print("${:.2f} were deposited to account #{}".format(deposit_amount, id))
            print("Account credit: ${:.2f}".format(user.get_account(id).amount))
            input()
            break


def change_type(user, id):
    print_header("CHANGE ACCOUNT TYPE")
    print("Current account type: {}".format(user.get_account(id).type))
    while True:
        if user.get_account(id).type == 'C':
            print("The account is already upgraded!")
            break
        else:
            new_type = input("Please enter a new account type: ")
            if user.get_account(id).set_type(new_type):
                break
    input()


def create_new_account(user):
    print_header("CREATE NEW ACCOUNT")
    print("There are several account types you can create, which are:")
    print("TYPE A:")
    print("  > Fund limit: $50,000.00")
    print("  > Withdraw Minimum: $1,000.00")
    print("TYPE B:")
    print("  > Fund limit: $100,000.00")
    print("  > Withdraw Minimum: $5,000.00")
    print("TYPE C:")
    print("  > No fund limit")
    print("  > Withdraw Minimum: $10,000.00")

    while True:
        account_type = input(">> Account type: ")
        if account_type.upper() in ['A', 'B', 'C']:
            break
        else:
            print("The defined account type is not valid.")
            print("Please enter a valid account type:")

    while True:
        initial_deposit = float(input(">> Initial deposit/funds for type {} account: ".format(account_type)))
        if account_type.upper() == 'A':
            if initial_deposit > 50000 or initial_deposit < 1000:
                print("The defined amount is not valid.")
                print("Please enter a valid amount:")
            else:
                break
        elif account_type.upper() == 'B':
            if initial_deposit > 100000 or initial_deposit < 5000:
                print("The defined amount is not valid.")
                print("Please enter a valid amount:")
            else:
                break
        else:
            if initial_deposit < 10000:
                print("The defined amount is not valid.")
                print("Please enter a valid amount:")
            else:
                break

    account = BankAccount(account_type, user.get_user_name(), initial_deposit, random.randint(11111111, 99999999))
    user.add_account(account)

    print_header("CREATE NEW ACCOUNT")
    print("Your account has been registered correctly with an initial account!")
    input("You will be returned to the main menu. Press enter...")


def main():
    bank = Bank()
    bank.store_user(Employee('A', "User1", 15000, 123456789))

    while True:
        print_header("BANK")
        print("Select an option:")
        print("1. Log in")
        print("2. Sign up")
        print("3. Enter as Bank Executive")
        print("4. Exit")
        opt = input(">> ")

        if opt == '1':
            log_in(bank)
        elif opt == '2':
            sign_up(bank)
        elif opt == '3':
            executive_menu(bank)
        else:
            break


if __name__ == "__main__":
    main()