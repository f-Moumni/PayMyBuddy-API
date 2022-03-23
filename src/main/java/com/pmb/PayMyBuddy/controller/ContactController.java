package com.pmb.paymybuddy.controller;

import com.pmb.paymybuddy.DTO.ContactDTO;
import com.pmb.paymybuddy.exception.AlreadyExistsException;
import com.pmb.paymybuddy.exception.DataNoteFoundException;
import com.pmb.paymybuddy.DTO.Response;
import com.pmb.paymybuddy.service.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;
@RestController
@RequestMapping("/contact")
public class ContactController {
@Autowired
    IContactService contactService;

    @GetMapping
    public ResponseEntity<Response> getContact(@RequestParam @Valid String mail) throws DataNoteFoundException {
        return ResponseEntity.ok(
                Response.builder().timeStamp(now())
                        .data(Map.of("contact", contactService.getContact(mail)))
                        .message("Contact retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build());
    }
    @PostMapping
    public ResponseEntity<Response> addContact(@RequestBody @Valid ContactDTO contactToAdd, @RequestParam @Valid String mail) throws AlreadyExistsException {
        return ResponseEntity.ok(
                Response.builder().timeStamp(now())
                        .data(Map.of("contact", contactService.addContact(contactToAdd,mail)))
                        .message("Contact added")
                        .status(OK)
                        .statusCode(OK.value())
                        .build());
    }
    @PutMapping
    public ResponseEntity<Response> removeContact(@RequestBody @Valid ContactDTO contactToAdd, @RequestParam @Valid String mail) {
        return ResponseEntity.ok(
                Response.builder().timeStamp(now())
                        .data(Map.of("contact", contactService.deleteContact(contactToAdd,mail)))
                        .message("Contact removed")
                        .status(OK)
                        .statusCode(OK.value())
                        .build());
    }
}
