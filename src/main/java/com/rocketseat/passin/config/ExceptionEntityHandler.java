package com.rocketseat.passin.config;

import com.rocketseat.passin.domain.attendee.exceptions.AttendeeAlreadyRegisteredException;
import com.rocketseat.passin.domain.attendee.exceptions.AttendeeNotFoundException;
import com.rocketseat.passin.domain.checkin.exceptions.CheckInAlreadyExistsException;
import com.rocketseat.passin.domain.event.exceptions.EventFullException;
import com.rocketseat.passin.domain.event.exceptions.EventNotFoundException;
import com.rocketseat.passin.dto.general.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionEntityHandler {

    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity handleEventNotFound(EventNotFoundException exception){
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(EventFullException.class)
    public ResponseEntity<ErrorResponseDTO> handleEvenFull(EventFullException exception){
        return ResponseEntity.badRequest().body(new ErrorResponseDTO(exception.getMessage()));
    }

    @ExceptionHandler(AttendeeNotFoundException.class)
    public ResponseEntity handleAttendeeNotFound(AttendeeNotFoundException exception){
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(AttendeeAlreadyRegisteredException.class)
    public ResponseEntity handleAttendeeAlreadyRegistered(AttendeeAlreadyRegisteredException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
    @ExceptionHandler(CheckInAlreadyExistsException.class)
    public ResponseEntity handleCheckinAlreadyExists(CheckInAlreadyExistsException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }





}
