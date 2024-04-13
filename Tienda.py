from Limpieza import Limpieza
from Alimento import Alimento
from Cliente import Cliente
from Empleado import Empleado
from Electrodomestico import Electrodomestico
from Maquillaje import Maquillaje
from Compra import Compra

class Tienda:
    def __init__(self):
        self.productos = []
        self.empleados = []
        self.clientes = []
        self.compras = []
        
    def registrarProducto(self):
        self.printHeader("REGISTRAR PRODUCTO")
        opc = self.seleccionDeProducto()
        if opc==1:
            self.registrarProductoLimpieza()
        elif opc==2:
            self.registrarProductoAlimento()
        elif opc==3:
            self.registrarProductoElectrodomestico
        elif opc==4:
            self.registrarProductoMaquillaje()
        else:
            return
        
    def mostrarProductos(self):
        self.printHeader("MOSTRAR PRODUCTOS")
        if len(self.productos) <= 0:
            print("No hay productos registrados aún")
        else:
            print("ID:\tDescripción:\tPrecio:\tStock:")
            for i in self.productos:
                print(f"{i.getID()}\t{i.getNombre()}\t\t{i.getPrecio()}\t{i.getStock()}\t")
        self.returnToMainMenu()
        
    def mostrarClientes(self):
        self.printHeader("MOSTRAR CLIENTES")
        if len(self.clientes) <= 0:
            print("No hay usuarios registrados aún")
        else:
            for i in self.clientes:
                print(f"  * {i.getNombre()}")
        self.returnToMainMenu()
        
    def eliminarProducto(self):
        self.printHeader("ELIMINAR PRODUCTO")
        producto = self.buscarProducto(False)
        opc = input("¿Está seguro de que quiere eliminar este producto? (s/n): ")
        ans = self.siONo(opc)
        if ans == True:
            self.productos.remove(producto)
            print("El producto ha sido eliminado")
        else:
            print("El producto no se eliminó")
        self.returnToMainMenu()
    
    def eliminarCliente(self):
        self.printHeader("ELIMINAR CLIENTE")
        cliente = self.buscarCliente(False)
        opc = input("¿Está seguro de que quiere eliminar este cliente? (s/n): ")
        ans = self.siONo(opc)
        if ans == True:
            self.clientes.remove(cliente)
            print("El cliente ha sido eliminado")
        else:
            print("El cliente no se eliminó")
        self.returnToMainMenu()
        
    def añadirStock(self):
        self.printHeader("AÑADIR STOCK")
        producto = self.buscarProducto(True)
        while True:
            stock = int(input("Ingrese el stock a añadir: "))
            if producto.agregarStock(stock) == True:
                print("La cantidad se ha agregado al producto")
                break
            else:
                print("La cantidad especificada no es válida")
        self.productos.append(producto)
        self.returnToMainMenu()
        
    def quitarStock(self):
        self.printHeader("QUITAR STOCK")
        producto = self.buscarProducto(True)
        while True:
            stock = int(input("Ingrese el stock a quitar: "))
            if producto.quitarStock(stock) == True:
                print("La cantidad se ha quitado exitosamente")
                break
            else:
                print("La cantidad especificada no es válda")
        self.productos.append(producto)
        self.returnToMainMenu()
        
    def verCompras(self):
        self.printHeader("VER COMPRAS")
        print("Ingrese una opción:")
        print("1. Ver las compras de la tienda")
        print("2. Ver las compras de un cliente")
        print("3. Volver al menú principal")
        opt = int(input(">> "))
        
        if opt == 1:
            print("Compras de la tienda")
            for i in self.compras:
                i.imprimirInfoCompra()
            self.returnToMainMenu()

        elif opt == 2:
            cliente = self.buscarCliente(False)
            cliente.imprimirListaDeCompras()
            self.returnToMainMenu()
            
        else:
            return
    
    def buscarCliente(self, modificar):
        cliente = None
        while True:
            nombre = input("Ingrese el nombre del cliente: ")
            for i in self.clientes:
                if nombre == i.getNombre():
                    cliente = i
                    print("¡El cliente ha sido encontrado!")
                    if modificar == True:
                        self.clientes.remove(cliente)
                    break
            if cliente == None:
                print("El cliente no ha sido encontrado. Por favor ingrese un nombre válido")
            else:
                break
        return cliente
        
    def buscarProducto(self, modificar):
        producto = None
        while True:
            id = int(input("Ingrese el ID del producto: "))
            for i in self.productos:
                if id == i.getID():
                    producto = i
                    print("¡El producto ha sido encontrado!")
                    if modificar == True:
                        self.productos.remove(producto)
                    break
            if producto == None:
                print("El producto no ha sido encontrado. Por favor ingrese un ID válido")
            else:
                break
        return producto
    
    def realizarCompra(self):
        carritoDeCompras = []
        self.printHeader("REALIZAR COMPRA")
        cliente = self.buscarCliente(True)
        while True:
            print("CARRITO DE COMPRAS")
            print("Seleccione una opción:")
            print("1. Agregar producto al carrito")
            print("2. Proceder a la compra")
            opc = int(input(">> "))
            
            if opc == 1:            
                while True:
                    producto = self.buscarProducto(False)
                    if producto == None:
                        print("Este producto está agotado")
                        self.returnToMainMenu()
                    else:
                        ans = input("¿Está seguro de que quiere comprar " + producto.getNombre() + "? (s/n) ")
                        if self.siONo(ans) == True:
                            while True:
                                cantidad = int(input("Ingrese la cantidad del producto a comprar: "))
                                if(producto.quitarStock(cantidad)==False):
                                    print("La cantidad ingresada no es válida")
                                else:
                                    break
                            for i in range(0, cantidad):
                                carritoDeCompras.append(producto)
                            print(f"¡{cantidad} ejemplares de {producto.getNombre()} han sido agregadas al carrito!")
                            self.returnToMainMenu()
                            break
            else:
                total = 0
                if len(carritoDeCompras)==0:
                    print("No se han agregado productos al carrito de compras")
                else:
                    for i in carritoDeCompras:
                        total+=i.getPrecio()
                    print(f"Total a pagar: ${total}")
                    input("Presione enter para confirmar la compra...")
                    compra = Compra(carritoDeCompras, total, cliente)
                    cliente.agregarCompra(compra)
                    print("¡La compra ha sido realizada exitosamente!")
                self.clientes.append(cliente)
                self.returnToMainMenu()
                break
    
    # Registrar productos
        
    def registrarProductoLimpieza(self):
        datos = self.registrarDatosComunesProducto()
        nombre = datos[0]
        numSerie = datos[1]
        precio = datos[2]
        fechaImp = datos[3]
        stock = datos[4]
        marca = input("Ingrese la marca del producto: ")
        self.productos.append(Limpieza(nombre, numSerie, precio, fechaImp, stock, marca))
        print("¡El producto de limpieza ha sido registrado exitosamente!")
        self.returnToMainMenu()
    
    def registrarProductoAlimento(self):
        datos = self.registrarDatosComunesProducto()
        nombre = datos[0]
        numSerie = datos[1]
        precio = datos[2]
        fechaImp = datos[3]
        stock = datos[4]
        fechaCad = input("Ingrese la fecha de caducidad del producto (dd/mm/aa): ")
        self.productos.append(Alimento(nombre, numSerie, precio, fechaImp, stock, fechaCad))
        print("¡El producto alimenticio ha sido registrado exitosamente!")
        self.returnToMainMenu()
        
    def registrarProductoElectrodomestico(self):
        datos = self.registrarDatosComunesProducto()
        nombre = datos[0]
        numSerie = datos[1]
        precio = datos[2]
        fechaImp = datos[3]
        stock = datos[4]
        alimentacion = input("Ingrese el tipo de alimentación que requiere el producto (Baterias, enchufe, etc.): ")
        self.productos.append(Electrodomestico(nombre, numSerie, precio, fechaImp, stock, alimentacion))
        print("¡El producto alimenticio ha sido registrado exitosamente!")
        self.returnToMainMenu()
        
    def registrarProductoMaquillaje(self):
        datos = self.registrarDatosComunesProducto()
        nombre = datos[0]
        numSerie = datos[1]
        precio = datos[2]
        fechaImp = datos[3]
        stock = datos[4]
        tipo = input("Ingrese el tipo de maquillaje")
        pigmento = input("Ingrese el pigmento del maquillaje")
        self.productos.append(Maquillaje(nombre, numSerie, precio, fechaImp, stock, tipo, pigmento))
        print("¡El producto de maquillaje ha sido registrado exitosamente!")
        self.returnToMainMenu()
        
    # Registrar usuarios    
        
    def registrarCliente(self):
        datos = self.registrarDatosComunesPersona()
        nombre = datos[0]
        curp = datos[1]
        fechaNac = datos[2]
        numTarjeta = input("Ingrese el número de tarjeta bancaria del cliente: ")
        self.clientes.append(Cliente(nombre, curp, fechaNac, numTarjeta))
        print("¡El cliente ha sido registrado correctamente!")
        self.returnToMainMenu()
        
    def registrarEmpleado(self):
        datos = self.registrarDatosComunesPersona()
        nombre = datos[0]
        curp = datos[1]
        fechaNac = datos[2]
        salario = input("Ingrese el salario del empleado: ")
        rfc = input("Ingrese el RFC del empleado: ")
        self.empleados.append(Empleado(nombre, curp, fechaNac, salario, rfc))
        print("¡El empleado ha sido registrado correctamente!")
        self.returnToMainMenu()
        
    # Otros Métodos
    
    def seleccionDeProducto(self):
        print("Seleccione un tipo de producto:")
        print("1. Limpieza")
        print("2. Alimento")
        print("3. Electrodomésticos")
        print("4. Maquillaje")
        print("5. Volver al menú principal")
        opc = int(input(">> "))
        return opc
        
    def printHeader(self, header):
        print("=======================================================")
        print(header)
        print("=======================================================")
        
    def returnToMainMenu(self):
        input("Presione enter para volver al menú anterior...")
    
    def addCliente(self, cliente):
        self.clientes.append(cliente)
        
    def addProducto(self, producto):
        self.productos.append(producto)
        
    def siONo(self, char):
        respuesta = False
        opc = char.lower()
        if opc=='s' or opc =='y':
            respuesta = True
        else:
            respuesta = False
        return respuesta
    
    def registrarDatosComunesProducto(self):
        datos = []
        datos.append(input("Ingrese el nombre del producto: "))
        datos.append(input("Ingrese el número de serie: "))
        datos.append(input("Ingrese el precio: "))
        datos.append(input("Ingrese la fecha de importación: (dd/mm/aa) "))
        datos.append(input("Ingrese el stock del producto: "))
        return datos
        
    def registrarDatosComunesPersona(self):
        datos = []
        datos.append(input("Ingrese su nombre completo: "))
        datos.append(input("Ingrese su CURP: "))
        datos.append(input("Ingrese su fecha de nacimiento (dd/mm/aa): "))
        return datos