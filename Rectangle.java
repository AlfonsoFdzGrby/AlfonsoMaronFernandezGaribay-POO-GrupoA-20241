public class Rectangle {
    int width;
    int height;
    int result;
    int id;
    
    Rectangle(int w, int h, int id) {
        width = w;
        height = h;
        this.id = id;
    }

    public void ShowArea() {
        result = width*height;
        System.out.println("--------------------------------");
        System.out.println("Rectangle #" + id + "'s AREA");
        System.out.println("Width: " + width + " units");
        System.out.println("Height: " + height + " units");
        System.out.println("The area of this rectangle is " + result + " square units.");
    }

    public void ShowPerimeter() {
        System.out.println("--------------------------------");
        System.out.println("Rectangle #" + id + "'s PERIMETER");
        System.out.println("Width: " + width + " units");
        System.out.println("Height: " + height + " units");
        result = (width*2)+(height*2);
        System.out.println("The perimeter of this rectangle is " + result + " units.");   
    }
}
