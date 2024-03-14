import random

class Book:
    
    rented = False
    
    def __init__(self, title, author):
        self.title = title
        self.author = author
        self.id = random.randint(1,1000)
        
    def getAuthor(self):
        return self.author
    
    def getTitle(self):
        return self.title
    
    def setRent(self, rent):
        self.rented = rent
        
    def isRented(self):
        return self.rented
    
    def getID(self):
        return self.id