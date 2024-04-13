class Compra:
    nextID = 1

    def __init__(self, productos, total, cliente):
        self.id = Compra.nextID
        Compra.nextID += 1
        self.productos = productos
        self.total = total
        self.cliente = cliente

    def imprimirListaDeCompras(self):
        print("Compra #" + str(self.id))
        print("  * Lista de productos:")
        for producto in self.productos:
            print("     * {} \t ${:.2f}".format(producto.getNombre(), producto.getPrecio()))

    def imprimirInfoCompra(self):
        print("Compra {}\t Total: ${:.2f}\t Cliente: {}".format(self.id, self.total, self.cliente.getNombre()))

    def getID(self):
        return self.id

    def getTotal(self):
        return self.total