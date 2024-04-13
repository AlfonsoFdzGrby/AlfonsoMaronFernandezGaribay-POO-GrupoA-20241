from Producto import Producto

class Electrodomestico(Producto):
    def __init__(self, nombre, numSerie, price, fechaImportacion, stock, tipoDeAlimentacion):
        super().__init__(nombre, numSerie, price, fechaImportacion, stock)
        self.tipoDeAlimentacion = tipoDeAlimentacion