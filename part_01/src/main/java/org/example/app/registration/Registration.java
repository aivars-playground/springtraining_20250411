package org.example.app.registration;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Registration(
        Integer id,
        @NotNull Integer productId,
        String ticketCode,
        @NotBlank String attendeeName
) {
}
