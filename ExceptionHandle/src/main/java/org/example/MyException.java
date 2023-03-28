package org.example;

public class MyException extends Exception{
    private  final  ErrorCode code;
    //Constructor
    MyException(String message, ErrorCode code){
        super(message);
        this.code = code;
    }
    //get code
    public  ErrorCode getCode(){
        return  code;
    }
}
enum ErrorCode {
    INVALID_PORT_CONFIGURATION,
    WRONG_NAME,
}
