package ezenweb.model.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
public class BaseTimeDto {
    private LocalDateTime cdate;
    private LocalDateTime udate;
}
