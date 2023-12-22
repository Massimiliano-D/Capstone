package Massimiliano.Capstone.Exeption.ExeptionPayloads;

import java.util.Date;
import java.util.List;

public record ErrorsListResponseDTO(String message,
                                    Date timeStamp,
                                    List<String> errorsList) {
}
