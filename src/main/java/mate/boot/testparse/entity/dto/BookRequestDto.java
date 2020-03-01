package mate.boot.testparse.entity.dto;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
public class BookRequestDto {

    @NonNull
    @NotEmpty(message = "Title mustn't be empty.")
    private String title;

    @NonNull
    @NotEmpty(message = "Description mustn't be empty.")
    private String description;

    @NonNull
    @Min(value = 0, message = "Price mustn't be negative.")
    private Double price;
}
