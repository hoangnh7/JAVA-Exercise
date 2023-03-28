package org.example;

public class Calculation {
    public  Integer divide2Number (Integer x, Integer y){
        try {
            Integer result = x/y;
            return result;
        } catch (ArithmeticException e){
            System.err.println("Arithmetic Exception : " + e.getMessage());
            return Integer.MAX_VALUE;
        } finally {
            System.out.println("This is finally");
        }
    }
    public void readPortConfig(Integer port) throws MyException {
        if (port == 1234) {
            throw new MyException("Invalid port", ErrorCode.INVALID_PORT_CONFIGURATION);
        }
    }

}
