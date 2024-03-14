from Book import Book
from User import User

class Library:
    bookList = []
    userList = []
    
    def appendBookToList(self, book):
        self.bookList.append(book)
        
    def appendUserToList(self, user):
        self.userList.append(user)

    def searchBook(self, title, author):
        retBook = None
        for book in self.bookList:
            if title.lower() == str(book.getTitle()).lower() and author.lower() == str(book.getAuthor().lower()):
                retBook = book
        return retBook
    
    def searchUserByID(self, id):
        retUser = None
        for user in self.userList:
            if int(user.getID()) == id:
                retUser = user
        return retUser
    
    def listRentedBooks(self):
        for book in self.bookList:
            if book.isRented():
                print(f"   * '{book.getTitle()}' by {book.getAuthor()}")
    
    def listUnrented(self):
        for book in self.bookList:
            if book.isRented()==False:
                print(f"   * '{book.getTitle()}' by {book.getAuthor()}")
    
    def listBuyers(self):
        for user in self.userList:
            if user.getHasBought():
                print(f"   * {user.getName()}")
                
    def listUsers(self):
        i = 0
        for user in self.userList:
            print(f"User #{i}")
            print(f"   * User Name: {user.getName()}")
            print(f"   * User ID: {user.getID()}")
            i += 1
            
    def listBooks(self):
        i = 0
        for book in self.bookList:
            print(f"Book #{i}")
            print(f"   * '{book.getTitle()}' by {book.getAuthor()}")
            print(f"   * Book ID: {book.getID()}")
            i += 1