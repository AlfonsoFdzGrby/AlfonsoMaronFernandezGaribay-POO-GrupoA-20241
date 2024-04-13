from Producto import Producto

class Maquillaje(Producto):
    def __init__(self, nombre, numSerie, price, fechaImportacion, stock, tipo, pigmento):
        super().__init__(nombre, numSerie, price, fechaImportacion, stock)
        self.tipo = tipo
        self.pigmento = pigmento