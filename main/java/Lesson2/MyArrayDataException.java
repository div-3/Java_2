package Lesson2;

public class MyArrayDataException extends NumberFormatException {
    int row, column;   //Адрес ячейки с ошибочными данными

    public MyArrayDataException(int _row, int _column) {
        super("Ошибка при преобразовании в целое число.");
        this.row = _row;
        this.column = _column;
    }
}
