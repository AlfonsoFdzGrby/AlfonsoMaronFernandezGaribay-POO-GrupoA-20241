class Producto:
    nextID = 0

    def __init__(self, nombre, numSerie, price, fechaImportacion, stock):
        self.nombre = nombre
        self.numSerie = numSerie
        self.precio = price
        self.fechaImportacion = fechaImportacion
        self.stock = stock
        self.id = Producto.nextID
        Producto.nextID += 1

    def getID(self):
        return self.id

    def getNombre(self):
        return self.nombre

    def agregarStock(self, stock):
        agregado = False
        if stock > 0:
            self.stock += stock
            agregado = True
        return agregado

    def quitarStock(self, stock):
        quitado = False
        if not (stock < 0 or stock > self.stock):
            self.stock -= stock
            quitado = True
        return quitado

    def getStock(self):
        return self.stock

    def getPrecio(self):
        return self.precio