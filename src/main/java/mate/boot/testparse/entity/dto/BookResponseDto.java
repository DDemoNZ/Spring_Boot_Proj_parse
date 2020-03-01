package mate.boot.testparse.entity.dto;

import lombok.Data;

@Data
public class BookResponseDto {

    private Long id;
    private String title;
    private String description;
    private Double price;
}
