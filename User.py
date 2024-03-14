import random

class User:
    
    rentedBookList = []
    hasBought = False
    
    def __init__(self, name, age):
        self.name = name
        self.age = age
        self.id = random.randint(1,10000)

    def getID(self):
        return self.id
    
    def getName(self):
        return self.name
    
    def addToRented(self, book):
        self.rentedBookList.append(book)
        
    def setHasBought(self, bought):
        self.hasBought = bought
        
    def listRentedBooks(self):
        for book in self.rentedBookList:
            print(f"    * '{book.getTitle()}' by {book.getAuthor()}")
    
    def getHasBought(self):
        return self.hasBought
    
    def getRentedBookList(self):
        return self.rentedBookList
    
    def setID(self, id):
        self.id = id