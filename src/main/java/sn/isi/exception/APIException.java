package sn.isi.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class APIException {
    String message;
    HttpStatus status;
    LocalDateTime timestamp;
}
