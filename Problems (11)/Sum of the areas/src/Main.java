public static int sumOfAreas(Shape[] array) {
    int sum = 0;
    for (Shape shape : array) {
        if (shape instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) shape;
            sum += rectangle.getHeight() * rectangle.getWidth();
        } else if (shape instanceof Square) {
            Square square = (Square) shape;
            sum += square.getSide() * square.getSide();
        }
    }
    return sum;
}