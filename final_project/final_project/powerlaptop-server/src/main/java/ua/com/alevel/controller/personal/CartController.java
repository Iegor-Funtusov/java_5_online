package ua.com.alevel.controller.personal;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.alevel.data.response.DataContainer;

@RestController
@RequestMapping("/api/private/personal/cart")
@PreAuthorize("hasRole('PERSONAL')")
public class CartController {

    @GetMapping
    @PreAuthorize("hasAuthority('personal:read')")
    public ResponseEntity<DataContainer<String>> getCart() {
        return ResponseEntity.ok(new DataContainer<>("cart!!!"));
    }
}
