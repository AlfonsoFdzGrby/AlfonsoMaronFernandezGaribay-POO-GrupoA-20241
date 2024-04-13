from Producto import Producto

class Limpieza(Producto):
    def __init__(self, nombre, numSerie, price, fechaImportacion, stock, marca):
        super().__init__(nombre, numSerie, price, fechaImportacion, stock)
        self.marca = marca
