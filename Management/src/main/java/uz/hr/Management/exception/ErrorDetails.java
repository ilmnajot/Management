package uz.hr.Management.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorDetails {

    private Date timestamp;

    private String message;

    private String errorDetails;
}
