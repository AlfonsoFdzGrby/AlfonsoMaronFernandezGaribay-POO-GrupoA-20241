from Persona import Persona

class Cliente(Persona):
    def __init__(self, nombre, cURP, fechaNacimiento, numTarjeta):
        super().__init__(nombre, cURP, fechaNacimiento)
        self.numCompras = 0
        self.numTarjeta = numTarjeta
        self.productosComprados = []
        self.compras = []

    def agregarCompra(self, compra):
        if compra is not None:
            self.compras.append(compra)
        self.numCompras += 1

    def imprimirListaDeCompras(self):
        total = 0
        for compra in self.compras:
            print(f"ID: {compra.getID()}\tTotal: ${compra.getTotal()}")
            total += compra.getTotal()
        print(f"TOTAL DE TODAS LAS COMPRAS DE {self.getNombre().upper()}: ${total}")