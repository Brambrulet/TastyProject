package utils.errors;

/**
 * Исключение ничем не примечательно,
 * просто выдаёт сообщние.
 * Вызывается в случае неверного количества аргументов.
 *
 * Используется в конструкторах всех объектов Pojo
 */
public class InvalidNumberOfArgumentsException extends RuntimeException {
    public InvalidNumberOfArgumentsException(){
        super("invalid number of argument");
    }

    public InvalidNumberOfArgumentsException(String message){
        super(message);
    }
}
