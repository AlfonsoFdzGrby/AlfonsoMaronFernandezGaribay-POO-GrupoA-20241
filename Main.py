from Library import Library
from User import User
from Book import Book
import os

library = Library()
testUser = User("user",23)

library.appendBookToList(Book("1984","George Orwell"))
library.appendBookToList(Book("Cosmos","Carl Sagan"))
library.appendBookToList(Book("The Heart of a Man","Erich Fromm"))
testUser.setID(1234)
library.appendUserToList(testUser)

def printHeader(header):
    os.system('cls')
    print("================================================")
    print(header)
    print("================================================")

############################################################################

def registerUser():
    printHeader("REGISTER USER")
    username = input("Please enter username: ")
    
    while True:
        age = int(input("Please enter age: "))
        if age<18:
            print("User must be at least 18 years old")
        else:
            break
    
    user = User(username, age)
    library.appendUserToList(user)
    print(f"User {user.getName()} was registered correctly!")
    print(f"User ID: {user.getID()}")
    print("WARNING: You'll need your user ID in order to rent books, so write it down!")
    input("Press enter to return to main menu...")
    
############################################################################

def rentBook():
    printHeader("REGISTER BOOK")
    
    while True:
        id = int(input("Please enter user ID: "))
        searchedUser = library.searchUserByID(id)
        
        if searchedUser==None:
            print("The specified ID is not valid")
        else:
            print(f"User {searchedUser.getName()} found!")
            user = searchedUser
            break
    
    while True:
        title = input("Please enter book title: ")
        author = input("Please book author: ")
        searchedBook = library.searchBook(title, author)
        
        if searchedBook==None:
            print("The specified book was not found")
        else:
            print(f"'{searchedBook.getTitle()}' by {searchedBook.getAuthor()} found!")
            if searchedBook.isRented() == True:
                print("The selected book is already rented")
            else:
                user.addToRented(searchedBook)
                print(f"The book has been rented to {user.getName()}")
                input("Press enter to return to main menu...")
                searchedBook.setRent(True)
                break
            
############################################################################

def registerBook():
    printHeader("REGISTER BOOK")
    title = input("Enter the name of the book: ")
    author = input("Enter the author of the book: ")

    book = Book(title, author)
    library.appendBookToList(book)
    
    print(f"'{book.getTitle()}' by {book.getAuthor()} was registered succesfully!")
    input("Press enter to return to main menu...")
    
############################################################################

def buyBook():
    printHeader("BUY BOOK")
    while True:
        id = int(input("Please enter user ID: "))
        searchedUser = library.searchUserByID(id)
        
        if searchedUser==None:
            print("The specified ID is not valid")
        else:
            print(f"User {searchedUser.getName()} found!")
            user = searchedUser
            break
    
    while True:
        title = input("Please enter book title: ")
        author = input("Please book author: ")
        searchedBook = library.searchBook(title, author)
        
        if searchedBook==None:
            print("The specified book was not found")
        else:
            user.setHasBought(True)
            print(f"A copy of '{searchedBook.getTitle()}' was sold to {user.getName()}")
            input("Press enter to return to main menu...")
            break

############################################################################

def listAllRentedBooks():
    printHeader("LIST RENTED BOOKS (LIBRARY)")
    library.listRentedBooks()
    input("Press enter to return to main menu...")
    
############################################################################

def listUnrentedBooks():
    printHeader("LIST UNRENTED BOOKS")
    library.listUnrented()
    input("Press enter to return to main menu...")
    
############################################################################

def listRentedByUser():
    printHeader("LIST RENTED BOOKS (USER)")
    while True:
        id = int(input("Please enter user ID: "))
        searchedUser = library.searchUserByID(id)
        
        if searchedUser==None:
            print("The specified ID is not valid")
        else:
            print(f"User {searchedUser.getName()} found!")
            user = searchedUser
            break
    
    user.listRentedBooks()
    input("Press enter to return to main menu...")
    
############################################################################

def listBuyers():
    printHeader("USERS WHO HAVE BOUGHT BOOKS")
    library.listBuyers()
    input("Press enter to return to main menu...")
    
############################################################################

def listRegisteredUsers():
    printHeader("REGISTERED USERS")
    library.listUsers()
    input("Press enter to return to main menu...")
    
############################################################################

def listRegisteredBooks():
    printHeader("REGISTERED BOOKS")
    library.listBooks()
    input("Press enter to return to main menu...")
    
############################################################################

if __name__ == "__main__":
    
    while True:
        printHeader("L I B R A R Y")
        print("1. Register User")
        print("2. Register Book")
        print("3. Rent Book")
        print("4. Buy Book")
        print("5. List all rented books")
        print("6. List Unrented books")
        print("7. List Rented Books by a single user")
        print("8. List Users who have bought books")
        print("9. List Registered Users")
        print("10. List Registered Books")
        print("11. Exit Library Assistant")
        
        opt = int(input(">> "))
        
        if opt == 1:
            registerUser()
        elif opt == 2:
            registerBook()
        elif opt == 3:
            rentBook()
        elif opt == 4:
            buyBook()
        elif opt == 5:
            listAllRentedBooks()
        elif opt == 6:
            listUnrentedBooks()
        elif opt == 7:
            listRentedByUser()
        elif opt == 8:
            listBuyers()
        elif opt == 9:
            listRegisteredUsers()
        elif opt == 10:
            listRegisteredBooks()
        elif opt > 10:
            break