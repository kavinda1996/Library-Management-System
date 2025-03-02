package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Borrowing {
    private String bookId;
    private String description;
    private String borrowedDate;
    private String returnDate;
    private String studentName;

}
