import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.Optional;

class ErrorHandling {

    void handleErrorByThrowingIllegalArgumentException() {
        throw new IllegalArgumentException();
    }

    void handleErrorByThrowingIllegalArgumentExceptionWithDetailMessage(String message) {
        throw new IllegalArgumentException("This is the detail message.");
    }

    void handleErrorByThrowingAnyCheckedException() throws IOException{
        throw new IOException("This is the detail message.");
    }

    void handleErrorByThrowingAnyCheckedExceptionWithDetailMessage(String message) throws SQLException{
        throw new SQLException("This is the detail message.");
    }

    void handleErrorByThrowingAnyUncheckedException() {
       throw new IllegalArgumentException();
    }

    void handleErrorByThrowingAnyUncheckedExceptionWithDetailMessage(String message) {
       throw new IndexOutOfBoundsException("This is the detail message.");
    }

    void handleErrorByThrowingCustomCheckedException() throws CustomCheckedException {
        throw new CustomCheckedException();
    }

    void handleErrorByThrowingCustomCheckedExceptionWithDetailMessage(String message) throws CustomCheckedException{
        throw new CustomCheckedException("This is the detail message.");
    }

    void handleErrorByThrowingCustomUncheckedException() {
        throw new CustomUncheckedException();
    }

    void handleErrorByThrowingCustomUncheckedExceptionWithDetailMessage(String message) {
        throw new CustomUncheckedException("This is the detail message.");
    }

    Optional<Integer> handleErrorByReturningOptionalInstance(String integer) {
        try{
            return Optional.of(Integer.valueOf(integer));
        }catch (NumberFormatException e){
            return Optional.empty();
        }
    }

}
