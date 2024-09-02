package homework10;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Data
public class Book {
    private int id = 1;
    private String name;
    private String аuthor;
}
