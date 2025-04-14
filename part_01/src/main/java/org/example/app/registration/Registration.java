package org.example.app.registration;

public record Registration(
        Integer id,
        Integer productId,
        String ticketCode,
        String attendeeName
) {
}
