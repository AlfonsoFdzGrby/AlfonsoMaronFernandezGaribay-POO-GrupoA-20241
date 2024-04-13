from Producto import Producto

class Alimento(Producto):
    def __init__(self, nombre, numSerie, price, fechaImportacion, stock, fechaCad):
        super().__init__(nombre, numSerie, price, fechaImportacion, stock)
        self.fechaCad = fechaCad